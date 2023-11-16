package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class EditAccountInfoPage extends TestBase {

	public EditAccountInfoPage() {
		PageFactory.initElements(driver, this);
	}

	MyAccountPage myAccountPage;

	@FindBy(id = "input-firstname")
	WebElement firstNameInput;

	@FindBy(id = "input-lastname")
	WebElement lastNameInput;

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-telephone")
	WebElement phoneNumberInput;

	@FindBy(css = "input[value='Continue']")
	WebElement submitEditBtn;

	public void editFirstName(String firstName) {
		firstNameInput.clear();
		firstNameInput.sendKeys(firstName);
	}

	public void editLastName(String lastName) {
		lastNameInput.clear();
		lastNameInput.sendKeys(lastName);
	}

	public void editEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void editTelephone(String editTelephone) {
		phoneNumberInput.clear();
		phoneNumberInput.sendKeys(editTelephone);
	}

	public MyAccountPage submitEditBtn() {
		submitEditBtn.click();
		return new MyAccountPage();
	}

}
