package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTestRun {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		LaunchLogin test = new LaunchLogin(driver);
		
		test.setExplicitTimeout(10);
		test.setImplicitTimeout(10);
		test.loginLaunch();
		test.search();
	}

}
