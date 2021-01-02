package autiSuggestive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Sel\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement autoText = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		
		autoText.sendKeys("Ind");
		
		//WebElement ui = driver.findElement(By.xpath("//*[@class='ui-menu-item-wrapper']"));
		
		String text;
		int flag=0;
		int count = driver.findElements(By.xpath("//*[@id='ui-id-1']/li")).size();
		Thread.sleep(5000);
		System.out.println(count);
		
		String script= "return document.getElementById(\"autocomplete\").value;";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sc =(String) js.executeScript(script);
		System.out.println(sc);
		
		for(int i =0;i<count;i++) {
			text = driver.findElements(By.xpath("//*[@class='ui-menu-item-wrapper']")).get(i).getText();
			System.out.println(text);
			if (text.contains("Ind")) {
				System.out.println(text);
				driver.findElements(By.xpath("//*[@class='ui-menu-item-wrapper']")).get(i).click();
				flag =1;
			}
			if(flag==1) {
				break;
			}
		}

	}
}
