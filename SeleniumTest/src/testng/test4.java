package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test4 {

	@DataProvider(name="data")
	public String[][] dataProvider() {
		
		String[][] data = new String[3][2];
		data[0][0] = "Aditya";
		data[0][1] = "24";
		
		data[1][0] = "Ram";
		data[1][1] = "25";
		
		data[2][0] = "Adi";
		data[2][1] = "22";
		
		return data;
		
	}
	
	
	@Test(dataProvider="data")
	public void test(String name,String age) {
		System.out.println(name + "  " + age);
	}
}