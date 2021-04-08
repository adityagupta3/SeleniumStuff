package Tests;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import PageObject.LandingPage;
import Resuorces.base;

public class validateTitle extends base {
	
	@BeforeTest
	public void initiliazation() throws IOException {
		driver = initializeDriver();
	}
	
	
	@Test(dataProvider = "title")
	public void getTitle(String strTitle)  {
		
		LandingPage lp = new LandingPage(driver);
		driver.get(properties.getProperty("URL"));
		
		Assert.assertEquals(strTitle, lp.getTitle().getText());
		Assert.assertTrue(lp.getNavbar().isDisplayed());
		System.out.println("TITLE present and NAVIGATION BAR FOUND");

	}
	
	@DataProvider
	public Object[] title() {
		Object[] title = new Object[1];
		title[0] = "FEATURED COURSES";
		return title;
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
