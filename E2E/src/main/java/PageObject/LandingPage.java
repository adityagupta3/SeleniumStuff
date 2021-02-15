package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	By login = By.xpath("//a/span[contains(text(),'Login')]");
	By title = By.xpath("//section/div/div/h2");
	By navbar = By.xpath("//nav[contains(@class,'navbar')]");

	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavbar() {
		return driver.findElement(navbar);
	}
}
