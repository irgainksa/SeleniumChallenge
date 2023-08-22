package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pom.BaseClass;

public class GmailLoginPage extends BaseClass {
	public GmailLoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement btnSignin;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement txtEmail;
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement btnNext;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement txtPass;
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement btnNextPa;
	public WebElement getBtnSignin() {
		return btnSignin;
	}
	public WebElement getTxtEmail() {
		return txtEmail;
	}
	public WebElement getBtnNext() {
		return btnNext;
	}
	public WebElement getTxtPass() {
		return txtPass;
	}
	public WebElement getBtnNextPa() {
		return btnNextPa;
	}
	

}
