package wowtest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePNJ {
	@FindBy(xpath="//form[@method=\"get\"]/input")
	private WebElement search_bar;
}
