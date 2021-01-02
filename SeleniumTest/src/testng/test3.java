package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test3 {
	
	@Parameters({"URL"})
	@Test
	public void test(String URL) {
		System.out.println(URL);
	}

	
	@Parameters({"URL"})
	@Test
	public void test1(String URL) {
		System.out.println(URL);
	}

}
