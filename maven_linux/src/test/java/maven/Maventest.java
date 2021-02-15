package maven;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Maventest {
	
	@Test
	public void browser() {
		System.out.println("Check...");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}
	
	@Test
	public void test() {
		
		System.out.println("Excluded test , shouldnt be run");
	}

}
