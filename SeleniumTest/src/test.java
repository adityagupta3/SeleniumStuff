import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class test {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe") ;
		
		WebDriver driver = new ChromeDriver() ;
		
		String URL = "http://www.qaclickacademy.com/practice.php" ;
		driver.get(URL);
		driver.manage().window().maximize();
		
		
		
		//WEBELEMENT ======== Sub Web Driver =====
		
		
//		System.out.println(driver.findElements(By.tagName("a")).size());
//		WebElement footer = driver.findElement(By.id("gf-BIG")) ;
//		System.out.println(footer.findElements(By.tagName("a")).size()) ;
//		
//		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
//		System.out.println(column.findElements(By.tagName("a")).size());
//		
//		for(int i=0 ; i < column.findElements(By.tagName("a")).size();i++) {
//			column.findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
//		}
//		
//		System.out.println(driver.getWindowHandles().size());
//		
//		Set<String> abc = driver.getWindowHandles();
//		Iterator<String> it = abc.iterator();
//		
//		while(it.hasNext()){
//			driver.switchTo().window(it.next());
//			System.out.println(driver.getTitle());
//		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.id("checkBoxOption2")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());
		
		//System.out.println(driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());
		String label = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		
		System.out.println("LABEL = "+label);
		
		Select optionDropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		optionDropdown.selectByVisibleText(label);
		
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys(label);		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		
		if (alertText.contains(label)) {
			System.out.println("Alert Contains the text!");
		} else {
			System.out.println("ALERT FAILS!");
		}
		
		
		
	}

}