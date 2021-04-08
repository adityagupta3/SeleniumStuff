import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;
//public static WebDriver driver; 





public class test {
	
	@Test
	public void launch() throws InterruptedException{
		String url = "https://www.flipkart.com/";
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get(url);

		String idStr = "9560955180";
		String passStr = "aaddii";
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement id = driver.findElement(By.xpath("//div/form/div[1]/input[@type='text']"));
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		//String js = "arguments[0].setAttribute('value','aditya')";
//		String jsc = "arguments[0].click()";
//		((JavascriptExecutor) driver).executeScript(jsc, id);
////	span//div/div[2]/div/form/div[2]/input 
//		Thread.sleep(2000);
//		((JavascriptExecutor) driver).executeScript(js, id); //input[@type='text']
		wait.until(ExpectedConditions.elementToBeClickable(id));
		id.click();
		id.sendKeys(idStr);//WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		pass.click();
		pass.sendKeys(passStr);
		//WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		driver.findElement(By.xpath("//form/div[3]/button")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/div/input[@type='text']")));
		//WebElement name = driver.findElement(By.xpath("//div[contains(text(),'aditya')]']"));
		
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(search))); //By.xpath("///div[contains(text(),'aditya')]']")));
		//driver.navigate().refresh();
		//WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		//String jsClick = "arguments[0].click()";	
		//((JavascriptExecutor)driver).executeScript(jsClick, search);
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//form/div/div/input[@type='text']"));
		search.sendKeys("iphone");
		//driver.findElement(By.xpath("//ul/li/div[contains(text(),'iphone 11')]")).click();
		
		int autoCount = driver.findElements(By.xpath("//ul/li")).size();
		
		for(int i =0;i<autoCount;i++) {
			if(driver.findElements(By.xpath("//ul/li")).get(i).getText().contains("iphone 11")) {
				driver.findElements(By.xpath("//ul/li")).get(i).click();
			}
		}
		
		driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone 11 (White, 64 GB)')][1]")).click();
		
		driver.manage().window().maximize();
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		
		for(int i=0;i<wid.size();i++) {
			if(driver.switchTo().window(wid.get(i)).getTitle().contains("Apple")) {
				driver.switchTo().window(wid.get(i));
				break;
			}
		}
		
		
		driver.navigate().refresh();
		Thread.sleep(5000);
	
		boolean flag=false;;
		for(int i=0;i<driver.findElements(By.xpath("//button")).size();i++) {
			//System.out.println(driver.findElements(By.xpath("//button")).get(i).getText());
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button"), 5));
			int buttons = driver.findElements(By.xpath("//button")).size();
			System.out.println("Buttons = "+buttons);
			if(driver.findElements(By.xpath("//button")).get(i).getText().contains("GO TO CART")) {
				driver.findElements(By.xpath("//button")).get(i).click();
				flag=true;
				break;
			}
		}
		
		
		if(!flag) {
			Assert.assertTrue(false, "ADD TO CART not found on webpage/button");
		}
		
		////div[contains(text(),"Remove")]
		//div[contains(text(),"Remove")]//parent::div//following-sibling::div/div/a
		////div/ul/li/button
//		Thread.sleep(5000);
//		driver.navigate().refresh();
//		Thread.sleep(5000);
		
		int totalcart = driver.findElements(By.xpath("//div/div/div[1]/div[1]/div[1]/a")).size();
		
		
		while(totalcart>1) {
			int cart = driver.findElements(By.xpath("//div/div/div[1]/div[1]/div[1]/a")).size();
			System.out.println("Items in CART : "+cart);
			int j=0;
			
				if(!driver.findElements(By.xpath("//div/div/div[1]/div[1]/div[1]/a")).get(j).getText().contains("Apple iPhone 11 (White, 64 GB)")) {
					driver.findElements(By.xpath("//div[contains(text(),'Remove')]")).get(j).getText();
					driver.findElements(By.xpath("//div[contains(text(),'Remove')]")).get(j).click();
					
					//Thread.sleep(5000);
					
					driver.findElement(By.xpath("//div[contains(text(),'Cancel')]//following-sibling::div[contains(text(),'Remove')]")).click();
					Thread.sleep(5000);
					--totalcart;
					
					//div[contains(text(),"Are you sure")]
					//div[contains(text(),"Cancel")]//following sibling::div[contains(text(),"Remove")]
				}
			}
			
		}
		
	
		
	}


