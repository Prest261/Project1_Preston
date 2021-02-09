package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.LoginMain;
import com.revature.runners.LoginRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepImpl {
	
	public static LoginMain loginmain = LoginRunner.loginmain;
	public static WebDriver driver = LoginRunner.driver;
	public static String url = "http://localhost:8080/Project_1_Preston/index.html";
	
	

@Given("^The user is on the login page$")
public void the_user_is_on_the_login_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^the user types \"([^\"]*)\" email$")
public void the_user_types_email(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^the user types \"([^\"]*)\" password$")
public void the_user_types_password(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^the user clicks the login button$")
public void the_user_clicks_the_login_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^the main page button should show up$")
public void the_main_page_button_should_show_up() throws Throwable {
 
    throw new PendingException();
}
}
