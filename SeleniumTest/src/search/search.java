package search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class search {

	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		WebElement search = driver.findElement(By.xpath("//input[@id='search-field']"));

		String Search = "apple";
		search.click();
		search.sendKeys(Search);

		List<WebElement> result = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> tableContents = result.stream().map(s -> getPrice(s, Search)).collect(Collectors.toList());
		// tableContents.stream().filter(s -> s.equalsIgnoreCase(Search)).;

		List<Integer> index = new ArrayList<Integer>();
		tableContents.forEach(s -> {
			if (s.equalsIgnoreCase("null")) {
				 index.add(tableContents.indexOf(s));
				 System.out.println(tableContents.indexOf(s));
			}
		});
		
		index.forEach(s->{
			System.out.println(s);
			tableContents.remove((int)s);
		});
		
		System.out.println(tableContents.toString());

	}

	public static String getPrice(WebElement s, String Search) {

		if (s.getText().equalsIgnoreCase(Search)) {

			return s.findElement(By.xpath("following-sibling::td[1]")).getText();

		} else
			return "NULL";

	}

}