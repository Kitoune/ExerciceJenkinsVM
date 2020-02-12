package wowtest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import wowtest.PageAccueil;

public class ItemTest {
		WebDriver driver;
		public List<String> loadFile(String filePath) throws FileNotFoundException {
			   
		    URI uri = null;
		    
		    File file = new File(filePath);
		    ArrayList<String> list = new ArrayList<String>();
		    if(file.exists()) {
		    	Scanner s = new Scanner(file, "UTF-8");
		    	
		    	while (s.hasNextLine()){
		    		list.add(s.nextLine());
		    	}
		    	s.close();
		    	
		    	}
		    return list;
		}

		@Test
		public void testcode() throws InterruptedException, FileNotFoundException {
			System.out.println(System.getProperty("Browser"));
			if(System.getProperty("browser") == "Chrome") {
				driver = new ChromeDriver();
			} else if(System.getProperty("browser") == "Firefox") {
				driver = new FirefoxDriver();
			} else {
				System.out.println("Attention ! Navigateur inconnu choisi, Chrome sera utilisé par défaut");
				driver = new ChromeDriver();
			}
			driver.get("https://fr.wowhead.com/");
			driver.manage().window().maximize();
			PageAccueil page_accueil = PageFactory.initElements(driver, PageAccueil.class);
			Thread.sleep(2000);
			page_accueil.acceptCookies(driver);
			PageRecherche page_recherche = page_accueil.searchFor(driver, "Lardeur");
			Thread.sleep(1000);
			PagePNJ page_png = page_recherche.openSearch(driver, 46254);
			String[] files = {
					"src/test/resources/import1.txt",
					"src/test/resources/import2.txt",
					"src/test/resources/import3.txt",
					"src/test/resources/import4.txt",
					"src/test/resources/import5.txt"
				};
			for(int i = 1 ; i <= driver.findElements(By.xpath("//tbody[@class='clickable']/tr")).size() ; i++) {
				WebElement current = driver.findElement(By.xpath("//tbody[@class='clickable']/tr["+i+"]/td[3]//a"));
				new Actions(driver).moveToElement(current).build().perform();
				Thread.sleep(200);
				
				
				String all = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]")).getText();
				
				List<String> list = loadFile(files[i-1]);
				
				for(int u = 0;u < list.size();u++) {
					System.out.println(list.get(u));
					if(u != 0) {
						assertTrue(all.contains(list.get(u)));
					}
				}
			}
		}
		
		@After
		public void exit() {
			driver.quit();
		}
}

/*
String name = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]//b/")).getText();
String niveau = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]//span[@class='q1']")).getText();
String materiau = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]//span[@class='q1']")).getText();
String armure = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]//span[@class='q1']")).getText();
String intelligence = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]//span[@class='q1']")).getText();
String agilite = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]//span[@class='q1']")).getText();
String endurance = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]//span[@class='q1']")).getText();
String hate = driver.findElement(By.xpath("//div[contains(@class,'wowhead-tooltip wowhead')]//span[@class='q1']")).getText();
String 
*/