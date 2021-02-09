package com.revature.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.revature.pages.LoginMain;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.revature.steps")
public class LoginRunner {
	
	public static FirefoxDriver driver;
	public static LoginMain loginmain;
	
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		
		WebDriver driver2 = new FirefoxDriver();
		loginmain = new LoginMain(driver);
		
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	

}
