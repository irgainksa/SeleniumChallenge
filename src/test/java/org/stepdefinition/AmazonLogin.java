package org.stepdefinition;

import org.pojo.AmazonSigninPage;
import org.pom.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonLogin extends BaseClass{
	AmazonSigninPage a;
	@Given("To launch the chrome browser and maximize the window")
	public void to_launch_the_chrome_browser_and_maximize_the_window() {
	       launchBrowser();
	       maximize();
	}
	@When("To launch url of the amazon application")
	public void to_launch_url_of_the_amazon_application() {
		launchUrl("https://www.amazon.in");
		a=new AmazonSigninPage();
		moveToElement(a.getsignin());
		clk(a.getbtnsignin());
	}
	@When("To pass the valid username in the email field")
	public void to_pass_the_valid_username_in_the_email_field() {
		a=new AmazonSigninPage();
		passTxt("marisankar0809@gmail.com",a.getTxtUser());
	   	}
	@When("To click the continue button")
	public void to_click_the_continue_button() {
		a=new AmazonSigninPage();
		clk(a.getbtncont());
	}
	@When("To pass the invalid password in the password field")
	public void to_pass_the_invalid_password_in_the_password_field() {
		a=new AmazonSigninPage();
		passTxt("64716814",a.getTxtPass());
	   }
	@When("To click the signin button")
	public void to_click_the_signin_button() {
		a=new AmazonSigninPage();
		clk(a.getBtnclick());
	  }
	@When("To check whether navigate to home page or not")
	public void to_check_whether_navigate_to_home_page_or_not() {
	   System.out.println("Check the login credentials");
	}
	@Then("To close the browser")
	public void to_close_the_browser() {
		closeBrowser();
	}

}