package search;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class search {


	
	
	
	@Test
	public void google() {
		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		String search = "aditya";
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(search);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.TAB);
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		//WebDriverWait wait = new WebDriverWait(driver,10);
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@aria-label='Google Search']"))));
		driver.findElements(By.xpath("//input[@aria-label='Google Search']")).get(1).click();
		
		driver.findElements(By.xpath("//a/h3")).get(5).click();  
		
		if(driver.getPageSource().contains(search)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		driver.quit();
		
		//driver.findElement(By.xpath("//a[5]")).click();
		
		
	}

}






