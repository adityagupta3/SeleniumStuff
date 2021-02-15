package Tests;

import java.util.concurrent.TimeUnit;
import ObjectRepo.LaunchLoginPage;
import ObjectRepo.SearchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LaunchLogin {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public void setExplicitTimeout(int time) {
		 wait = new WebDriverWait(driver,time);
	}
	
	public LaunchLogin(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setImplicitTimeout(int time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	 
	public WebDriver driver() {
		return driver;
	}
	
	@Test
	public void loginLaunch() {
		String url = "https://www.flipkart.com/";
		
		//WebDriver driver = new ChromeDriver();  
		driver.get(url);

		String idStr = "9560955180";
		String passStr = "aaddii";
		
		
		
		
		LaunchLoginPage loginpage = new LaunchLoginPage(driver);
		
		loginpage.getId().click();
		loginpage.getId().sendKeys(idStr);
		loginpage.getPass().click();
		loginpage.getPass().sendKeys(passStr);
		loginpage.getPass().click();
		loginpage.getSubmit().click();
		wait.until(ExpectedConditions.visibilityOf(loginpage.getusername())) ;
		
	}

	@Test
	public void search() {
		SearchPage sp = PageFactory.initElements(driver, SearchPage.class) ;
	//	wait.until(ExpectedConditions.)
	//	sp.getSearch().click();
		sp.getSearch().sendKeys("iphone");
		int autoCount = driver.findElements(By.xpath("//ul/li")).size();
		
		for(int i =0;i<autoCount;i++) {
			if(driver.findElements(By.xpath("//ul/li")).get(i).getText().contains("iphone 11")) {
				driver.findElements(By.xpath("//ul/li")).get(i).click();
			}
		}
		
		driver.manage().window().maximize();
		sp.getItemInSearch().click();
		
	}
}
