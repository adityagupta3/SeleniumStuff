package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brkenLink {
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		int linkCount = footer.findElements(By.tagName("a")).size();
		String url ;
		
		HttpURLConnection conn ;
		
		for(int i=0 ; i<linkCount ;i++ ) {
			
			url = footer.findElements(By.tagName("a")).get(i).getAttribute("href");
			System.out.println(url);
			conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			System.out.println(conn.getResponseCode() +" & URL = "+url);
			
		}
	}

}
