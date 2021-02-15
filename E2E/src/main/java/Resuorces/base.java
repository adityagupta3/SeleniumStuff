package Resuorces;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	public Properties properties = new Properties();
	
	public WebDriver initializeDriver() throws IOException {
		
				
		FileInputStream fis = new FileInputStream("src/main/java/data.properties");	
		properties.load(fis);
		String browser = properties.getProperty("Browser");
		System.out.println("Browser name : "+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			//CHROME BROWSER
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			//options.addArguments("--disable-dev-shm-usage");
			//options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
		} else {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("implicitlyWait")), TimeUnit.SECONDS);
		return driver;
		
	}

}
