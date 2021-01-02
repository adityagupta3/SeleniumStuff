package testng;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {

	@Test(groups=("smoke"))
	public void testPrint() {
		System.out.println("TEST TESTNG");
	}

	@Test(groups=("smoke"))
	public void Pass() {
		System.out.println("Pass");

	}

	@BeforeMethod
	public void Bmethod() {
		System.out.println("METHOD START - Will run with every method in the same class");

	}

	@AfterMethod
	public void Amethod() {
		System.out.println("METHOD END");
		

	}

	@BeforeTest
	public void Btest() {
		System.out.println("Before test - Will run before every test that has this class file");
	}

	@AfterTest
	public void Atest() {
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void Bclass() {
		System.out.println("Will run before every occurance of this class is called");
	}
	
	

}