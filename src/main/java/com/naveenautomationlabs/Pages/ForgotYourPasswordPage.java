package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class ForgotYourPasswordPage extends TestBase {

	public ForgotYourPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(css = "input[type='submit']")
	WebElement submitForgotPassword;

	@FindBy(css = "div.alert-danger")
	WebElement emailNotFoundBanner;

	public void emailInputForForgotPassword(String email) {
		emailInput.sendKeys(email);
	}

	public ForgotYourPasswordPage submitEmailInputForForgotPassword() {
		submitForgotPassword.click();
		return new ForgotYourPasswordPage();
	}

	public String getEmailNotFoundBannerText() {
		return emailNotFoundBanner.getText();
	}

}
