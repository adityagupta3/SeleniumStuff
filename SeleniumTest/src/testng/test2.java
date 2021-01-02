package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test2 {

	@Test(enabled=true)
	public void check() {
		System.out.println("Just a check");
	}
	
	@Test(dependsOnMethods="Pass")
	public void dependson()
	{
		System.out.println("test");
	}
	
	@Test
	public void AtestPrint() {
		System.out.println("TEST 2 TESTNG");
	}
	
	@Test(groups=("smoke"))
	public void Pass() {
		System.out.println("Pass 2");
		
	}
	
	@Parameters({"URL"})
	@Test
	public void test1(String URL) {
		System.out.println(URL);
	}
	
}
