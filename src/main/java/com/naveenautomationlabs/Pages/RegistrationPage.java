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
	
	public void fillRegistrationForm(String firstName,String lastName,String email,String telephoneNumber,String password,String confirmPassword) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enteremail(email);
		enterTelePhone(telephoneNumber);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
	}
	
}
