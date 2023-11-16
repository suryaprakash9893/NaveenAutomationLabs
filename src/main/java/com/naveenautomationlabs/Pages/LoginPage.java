package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	MyAccountPage myAccountPage;
	ForgotYourPasswordPage forgotYourPasswordPage;
	ContactUsPage contactUsPage;

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement passwordInput;

	@FindBy(css = "input[type=submit]")
	WebElement submitLoginBtn;

	@FindBy(css = "div.form-group>a")
	WebElement forgotPasswordBtn;

	@FindBy(css = "div.alert")
	public WebElement loginCredentialsMismatchAlert;
	
	//WebElement for ContactUs form.
		@FindBy(xpath = "//a[text()='Contact Us']")
		WebElement contactUsPageButton;

	private void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	private void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public MyAccountPage submitLogin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		submitLoginBtn.click();
		return new MyAccountPage();
	}

	public ForgotYourPasswordPage submitForgotPassword() {
		forgotPasswordBtn.click();
		return new ForgotYourPasswordPage();
	}
	
	public  ContactUsPage openContactUsForm() {
		contactUsPageButton.click();
		return new ContactUsPage();
	}
}
