package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchLoginPage {
	
	public LaunchLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	WebDriver driver;
	By id = By.xpath("//div/form/div[1]/input[@type='text']");
	By pass = By.xpath("//input[@type='password']");
	By submit = By.xpath("//div[@class='_1D1L_j']//button[@type='submit']");
	By username = By.xpath("//div/div[contains(text(),'aditya')]");
	


	public WebElement getId() {
		return driver.findElement(id);
	}
	
	public WebElement getPass() {
		return  driver.findElement(pass);
	}
	
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
	
	public WebElement getusername() {
		return driver.findElement(username);
	}


}
