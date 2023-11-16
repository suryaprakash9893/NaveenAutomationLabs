package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class ChangePasswordPage extends TestBase {

	public ChangePasswordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-password")
	WebElement passwordInput;

	@FindBy(css = "#input-confirm")
	WebElement confirmPasswordInput;

	@FindBy(css = "input[type='submit']")
	WebElement submitChangePasswordBtn;

	private void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	private void enterPasswordConfirm(String password) {
		confirmPasswordInput.sendKeys(password);
	}

	public MyAccountPage changePassword(String password, String confirmPassword) {
		enterPassword(password);
		enterPasswordConfirm(confirmPassword);
		submitChangePasswordBtn.click();
		return new MyAccountPage();
	}

}
