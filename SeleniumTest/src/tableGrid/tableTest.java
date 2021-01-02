package tableGrid;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tableTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

//		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
//		int amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]")).size();
//		int amount=0;
//		for ( int i=0;i<amounts ;i++) {
//			amount+=Integer.parseInt(driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]")).get(i).getText());
//		}
//		System.out.println(amount);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// List<WebElement> coulmns =
		// driver.findElements(By.xpath("//table[@id='product']/tbody/tr"));
		String columnText;

		int rowCount = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
		int columnCount = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();
		int flag = 0;
		System.out.println("No of coulumns :" + columnCount);
		System.out.println("No of rows :" + rowCount);

		driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[2]/td[1]")).click();

		for (int row = 2; row < rowCount + 1; row++) {
			for (int column = 1; column < columnCount + 1; column++) {
				columnText = driver
						.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + row + "]/td[" + column + "]"))
						.getText();
				System.out.println(row + "  " + column);

				if (columnText.contains("Learn SQL")) {
					for (int i = 1; i < columnCount; i++) {
						System.out.println(driver
								.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + row + "]/td[" + i + "]"))
								.getText());
					}
					flag = 1;
				}

			}
			if (flag == 1) {
				break;
			}
		}
		
	}

}
