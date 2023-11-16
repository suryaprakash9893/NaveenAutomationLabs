package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class RegistrationSuccessMessagePage extends TestBase {

	public RegistrationSuccessMessagePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement registrationSucessMessage;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	public String getRegistrationSucessMessage() {
		return registrationSucessMessage.getText();
	}

	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}

}
