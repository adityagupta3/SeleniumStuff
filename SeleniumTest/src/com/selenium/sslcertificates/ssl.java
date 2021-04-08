package com.selenium.sslcertificates;

import java.io.File;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ssl {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sel\\chromedriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// The below commands are just different ways of doing the same thing
		capabilities.acceptInsecureCerts();
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		ChromeOptions ch = new ChromeOptions();
		ch.merge(capabilities);

		WebDriver driver = new ChromeDriver(ch);
		
		driver.get("http://www.google.com");
		
		
		
		File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copy(sc,new File("C://screenshot.png") );
	}
}

