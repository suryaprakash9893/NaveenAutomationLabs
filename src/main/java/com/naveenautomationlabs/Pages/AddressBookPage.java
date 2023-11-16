package com.naveenautomationlabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.Utils.Utilty;
import com.naveenautomationlabs.base.TestBase;

public class AddressBookPage extends TestBase {

	MyAccountPage myAccountPage;
	LoginPage loginPage;

	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	// Add a new Address Button
	@FindBy(xpath = "//a[text()='New Address']")
	WebElement addNewAddressButton;

	// Delete an existing Address Button
	@FindBy(xpath = "//a[text()='Delete']")
	WebElement deleteAnExistingAddressButton;

	// Edit an existing Address Button
	@FindBy(xpath = "//a[text()='Edit']")
	WebElement editAnExistingAddressButton;

	// Success Banner after adding a new Address.
	@FindBy(css = "div.alert-success")
	WebElement successBannerAfterAddingANewAddress;

	@FindBy(css = "#input-firstname")
	WebElement inputFirstName;

	@FindBy(css = "#input-lastname")
	WebElement inputLastName;

	@FindBy(id = "input-address-1")
	WebElement inputAddressLine1;

	@FindBy(id = "input-city")
	WebElement inputCity;

	@FindBy(id = "input-postcode")
	WebElement inputPostalCode;

	@FindBy(id = "input-country")
	WebElement selectCountry;

	@FindBy(id = "input-zone")
	WebElement selectProvince;

	@FindBy(css = "input[value='1']")
	WebElement defaultAddressYesRadioButton;

	@FindBy(css = "input[value='0']")
	WebElement defaultAddressNoRadioButton;

	@FindBy(css = "input[value='Continue']")
	WebElement continueButtonAfterAddingAddress;

	@FindBy(xpath = "//table//tr[2]//a[text()='Delete']")
	WebElement deleteSecondAddress;

	@FindBy(xpath = "//table//tr[2]//a[text()='Edit']")
	WebElement editSecondAddress;

	public void addNewAddressToAddressBook(String fName, String lName, String addressLine1, String city,
			String postalCode, String country, String province) {
		addNewAddressButton.click();
		inputFirstName.sendKeys(fName);
		inputLastName.sendKeys(lName);
		inputAddressLine1.sendKeys(addressLine1);
		inputCity.sendKeys(city);
		inputPostalCode.sendKeys(postalCode);
		Utilty.selectFromDropDownByVisibleText(selectCountry, country);
		Utilty.selectFromDropDownByVisibleText(selectProvince, province);
		continueButtonAfterAddingAddress.click();
	}
	
	public void continueButton() {
		continueButtonAfterAddingAddress.click();
	}

	public String getTextOfSuccessBannerAfterAddingANewAddress() {
		return successBannerAfterAddingANewAddress.getText();
	}

	public WebElement deleteTheNthAddressFromTheTable(int nthAddressToBeDeleted) {
		String webElementDeleteButton = "//table//tr[" + nthAddressToBeDeleted + "]//a[text()='Delete']";
		WebElement webElementToBeDeteted = driver.findElement(By.xpath(webElementDeleteButton));
		return webElementToBeDeteted;
	}

	public WebElement editTheNthAddressFromTheTable(int nthAddressToBeDeleted) {
		String webElementEditButton = "//table//tr[" + nthAddressToBeDeleted + "]//a[text()='Edit']";
		WebElement webElementToBeEdited = driver.findElement(By.xpath(webElementEditButton));
		return webElementToBeEdited;
	}
	
	public void editFName(String fName) {
		inputFirstName.clear();
		inputFirstName.sendKeys(fName);
	}
	
	public void editLName(String lName) {
		inputLastName.clear();
		inputLastName.sendKeys(lName);
	}
	
	public void editAddressLine1(String addressLine1) {
		inputAddressLine1.clear();
		inputAddressLine1.sendKeys(addressLine1);
	}
	
	public void editCity(String city) {
		inputCity.clear();
		inputCity.sendKeys(city);
	}

	public void editPostalcode(String postalCode) {
		inputPostalCode.clear();
		inputPostalCode.sendKeys(postalCode);
	}
}
