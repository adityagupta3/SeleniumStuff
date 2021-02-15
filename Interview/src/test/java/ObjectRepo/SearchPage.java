package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	
	WebDriver driver;
//	By search = ;
	
	@FindBy(xpath="//form/div/div/input[@type='text']")
	WebElement search;
	
	@FindBy(xpath="//ul/li")
	WebElement autoCount;
	
	@FindBy(xpath="//div[contains(text(),'Apple iPhone 11 (White, 64 GB)')][1]")
	WebElement itemInSearch;

	public SearchPage(WebDriver driver) {
		this.driver =  driver;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getAutoCount() {
		return autoCount;
	}

	public WebElement getItemInSearch() {
		return itemInSearch;
	}


}
