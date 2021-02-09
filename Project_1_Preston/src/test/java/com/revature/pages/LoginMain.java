package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMain {
	
public FirefoxDriver driver;
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "password")
	public WebElement password;

	public LoginMain(FirefoxDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

}
