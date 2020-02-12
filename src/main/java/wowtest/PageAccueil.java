package wowtest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageAccueil {
	@FindBy(xpath="//form/input[1]")
	private WebElement search_bar;
	
	@FindBy(xpath="//button[contains(text(),\"Accept and Continue\")]")
	private WebElement cookie_accept;
	
	public void acceptCookies(WebDriver driver) {
		cookie_accept.click();
	}
	
	public PageRecherche searchFor(WebDriver driver, String s) {
		search_bar.clear();
		search_bar.sendKeys(s);
		search_bar.submit();
		return PageFactory.initElements(driver, PageRecherche.class);
	}
}