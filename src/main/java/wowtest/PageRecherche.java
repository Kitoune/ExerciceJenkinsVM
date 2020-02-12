package wowtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageRecherche {
	@FindBy(xpath="//form[@method=\"get\"]/input")
	private WebElement search_bar;
	
	public PagePNJ openSearch(WebDriver driver, int i) {
		driver.findElement(By.xpath("//a[contains(@href,'"+i+"')][@class='listview-cleartext']")).click();
		return PageFactory.initElements(driver, PagePNJ.class);
	}
}