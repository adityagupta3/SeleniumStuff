package clender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companions");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='travel_date']")));
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		
		Thread.sleep(5000);
		
		WebElement calender = driver.findElement(By.xpath(".//*[@id='travel_date']"));
		
		//jse.executeScript("arguments[0].click();", calender );
		
		
		int count = driver.findElements(By.className("day")).size();
		
		for (int i =0 ; i < count ; i++) {
			String date = driver.findElements(By.className("day")).get(i).getText();
			//System.out.println(date);
			//System.out.println("IN LOOP ???");
			if ( date.equals("23") ){
				driver.findElements(By.className("day")).get(i).click();
				break;
			}			
		}
		
		
		//driver.findElement(By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']")).click();
		
		driver.findElement(By.id("travel_date")).click();
		
		jse.executeScript("arguments[0].click();", calender );
		boolean month_found = false;
		
	    while(!month_found) {
	    	String month = driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText();
			if (month.contains("Feb")) {
				 month_found=true;
				 driver.findElement(By.xpath("//th[@class='next']")).click();
			} else {
				driver.findElement(By.xpath("//th[@class='next']")).click();
			}
	    	
	    }
		
		 count = driver.findElements(By.className("day")).size();
		
		for (int i =0 ; i < count ; i++) {
			String date = driver.findElements(By.className("day")).get(i).getText();
			//System.out.println(date);
			//System.out.println("IN LOOP ???");
			if ( date.equals("2") ){
				driver.findElements(By.className("day")).get(i).click();
				break;
			}			
		}
		
		
	}

}
