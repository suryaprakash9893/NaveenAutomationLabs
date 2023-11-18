package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class RegistrationPage extends TestBase {

	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='firstname']")
	WebElement inputFirstName;

	@FindBy(css = "input[name='lastname']")
	WebElement inputLastName;

	@FindBy(css = "input[name='email']")
	WebElement inputEmail;

	@FindBy(css = "input[name='telephone']")
	WebElement inputTelePhone;

	@FindBy(css = "input[name='password']")
	WebElement inputPassword;

	@FindBy(css = "input[name='confirm']")
	WebElement inputConfirmPassword;

	@FindBy(css = "input[name='agree']")
	WebElement checkAgreeCheckBox;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//div[text()=' Warning: You must agree to the Privacy Policy!']")
	WebElement privacyPolicyAgreeCheckBoxValidationMessage;

	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	WebElement enterFNameRequirements;

	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	WebElement enterLNameRequirements;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	WebElement enterEmailRequirements;

	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	WebElement enterPhoneRequirements;

	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	WebElement enterPasswordRequirements;

	@FindBy(xpath = "//div[text()=' Warning: E-Mail Address is already registered!']")
	WebElement emailAlreadyRegisteredWarningBanner;

	@FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
	WebElement passwordsMisMatchWarningBanner;

	private void enterFirstName(String firstName) {
		inputFirstName.sendKeys(firstName);
	}

	private void enterLastName(String lastName) {
		inputLastName.sendKeys(lastName);
	}

	private void enteremail(String email) {
		inputEmail.sendKeys(email);
	}

	private void enterTelePhone(String telephoneNumber) {
		inputTelePhone.sendKeys(telephoneNumber);
	}

	private void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}

	private void enterConfirmPassword(String confirmPassword) {
		inputConfirmPassword.sendKeys(confirmPassword);
	}

	public String getEnterFNameRequirementsBanner() {
		return enterFNameRequirements.getText();
	}

	public String getEnterLNameRequirementsBanner() {
		return enterLNameRequirements.getText();
	}

	public String getEnterEmailRequirementsBanner() {
		return enterEmailRequirements.getText();
	}

	public String getEnterPhoneRequirementsBanner() {
		return enterPhoneRequirements.getText();
	}

	public String getEnterPasswordRequirementsBanner() {
		return enterPasswordRequirements.getText();
	}

	public String getEmailAlreadyRegisteredWarningBanner() {
		return emailAlreadyRegisteredWarningBanner.getText();
	}

	public String getPasswordMisMatchWarningBanner() {
		return passwordsMisMatchWarningBanner.getText();
	}

	public RegistrationSuccessMessagePage clickContinueBtn() {
		continueBtn.click();
		return new RegistrationSuccessMessagePage();
	}

	public void clickAgreeCheckBox() {
		checkAgreeCheckBox.click();
	}

	public String getprivacyPolicyAgreeCheckBoxValidationMessage() {
		return privacyPolicyAgreeCheckBoxValidationMessage.getText();
	}

	public void fillRegistrationForm(String firstName, String lastName, String email, String telephoneNumber,
			String password, String confirmPassword) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enteremail(email);
		enterTelePhone(telephoneNumber);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
	}

}
