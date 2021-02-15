import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class practice {

	@Test
	public void test() {
		
		String url = "https://www.flipkart.com/apple-iphone-11-white-64-gb/p/itmfc6a7091eb20b?pid=MOBFWQ6BVWVEH3XE&lid=LSTMOBFWQ6BVWVEH3XESAHPTP&marketplace=FLIPKART&srno=s_1_1&otracker=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&fm=SEARCH&iid=8c3652ee-0eba-4892-9dbd-9ae974034630.MOBFWQ6BVWVEH3XE.SEARCH&ppt=sp&ppn=sp&ssid=53tblcasuo0000001611509498142&qH=f6cdfdaa9f3c23f3";
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get(url);
		
		List<WebElement> buttons = driver.findElements(By.xpath("//button"));
		
		for(int i=0;i<buttons.size();i++) {
			if(buttons.get(i).getText().contains("ADD TO CART")) {
				buttons.get(i).click();
				break;
			}
		}
		
		
	}
}
