package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pom.BaseClass;

public class AmazonSigninPage extends BaseClass {
	public AmazonSigninPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Account & Lists']")
	private WebElement signin;
	
	@FindBy(xpath = "(//span[text()='Sign in'])[1]")
	private WebElement btnsignin;
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement txtUser;
	
	@FindBy(id = "continue")
	private WebElement btncont;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement txtPass;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnclick;
	
	public WebElement getsignin() {
		return signin;
	}
	public WebElement getbtnsignin() {
		return btnsignin;
	}

	public WebElement getTxtUser() {
		return txtUser;
	}
	public WebElement getbtncont() {
		return btncont;
	}
	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnclick() {
		return btnclick;
	}
}
