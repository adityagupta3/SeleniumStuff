package Tests;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resuorces.base;

//import org.testng.annotations.Test;


public class HomePage extends base {
	
	@BeforeTest
	public void initiliazation() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider = "data")
	public void HomePageNavigation(String username,String password,String user)  {
		
		driver.get("http://qaclickacademy.com");
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		
		LoginPage lop = new LoginPage(driver);
		System.out.println("USER : "+user);
		lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		lop.getloginbtn().click();
		
	}
	
	@DataProvider
	public Object[][] data() {
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non Restricted User";
		
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Restricted User";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}


}
