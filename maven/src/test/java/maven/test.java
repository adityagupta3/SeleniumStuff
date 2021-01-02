package maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {

	@Test
	public void BrowserAutomation() {
		System.out.println("Check...");

		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

	}
}
