package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class streamTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		List<WebElement> all = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		// System.out.println("Size = " + size);

		// Find the Original List

		// ArrayList<String> orignal = getItems(size,driver);

		List<String> expectedSorted = all.stream().map(s -> s.getText()).collect(Collectors.toList());
		expectedSorted = expectedSorted.stream().sorted().collect(Collectors.toList());
		System.out.println(expectedSorted.toString());

		// System.out.println(orignal.stream().sorted());

		// Sort the list on page

		driver.findElement(By.xpath("//tr[1]/th[1]")).click();

		List<WebElement> newAll = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> orignalSorted = newAll.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(orignalSorted.toString());

		// Assert.assertTrue(expectedSorted.equals(orignalSorted));

		WebElement next = driver.findElement(By.cssSelector("[aria-label='Next']"));
		boolean notFound=false;

		while (next.getAttribute("aria-disabled").equals("false")) {

			List<WebElement> newcol = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			List<String> price = newcol.stream().filter(s -> s.getText().contains("MAN")).map(s -> getPrice(s))
					.collect(Collectors.toList());


			if (price.size() < 1) {
				next.click();
			} else {
				price.forEach(s -> System.out.println(s));
				break;
			}
				
			notFound=true;
		}

		
		if(notFound) {
			System.out.println("ELEMENT NOT FOUND!!!");
		}
		// Sort

		// ArrayList<String> sorted = getItems(size,driver);

		// sorted.stream().filter(s->s.equals(orignal(s))).forEach(System.out.println("EQUAL"));

	}

//	public static ArrayList<String> getItems(int size, WebDriver driver) {
//
//		ArrayList<String> arr = new ArrayList<>();
//		for (int i = 1; i <= size; i++) {
//
//			arr.add(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText());
//		}
//		
//		return arr;
//
//	}

	public static String getPrice(WebElement name) {

		String price = name.findElement(By.xpath("following-sibling::td[1]")).getText();
		// System.out.println(price);
		return price;

	}
}
