package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class ContactUsPage extends TestBase {

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	HomePage homePage;

	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement contactUsPageText;

	@FindBy(css = "#input-name")
	WebElement inputName;

	@FindBy(css = "#input-email")
	WebElement inputEmail;

	@FindBy(css = "#input-enquiry")
	WebElement inputEnquiry;

	@FindBy(css = "input[value='Submit']")
	WebElement submitContactUsEnquiryButton;

	@FindBy(css = "div[id='content']>p")
	WebElement contactSuccessMessage;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtnAfterSubmittingContactUsEnquiry;
	
	@FindBy(xpath="//div[text()='Name must be between 3 and 32 characters!']")
	WebElement nameAlertMessage;
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	WebElement emailAddressAlert;
	
	@FindBy(xpath="//div[text()='Enquiry must be between 10 and 3000 characters!']")
//	@FindBy(class="text-danger")
	WebElement enquiryAlertMessage;

	private void enterName(String name) {
		inputName.sendKeys(name);
	}

	private void enterEmail(String email) {
		inputEmail.sendKeys(email);
	}

	private void enterEnquiry(String enquiry) {
		inputEnquiry.sendKeys(enquiry);
	}

	public void clickSubmitBtn() {
		submitContactUsEnquiryButton.click();
	}

	public String getContactUsPageText() {
		return contactUsPageText.getText();
	}

	public String getNameAlertMessage() {
		return nameAlertMessage.getText();
	}
	public String getEmailAddressAlert() {
		return emailAddressAlert.getText();
	}

	public String getEnquiryAlertMessage() {
		return enquiryAlertMessage.getText();
	}

	public String getcontactSuccessMessage() {
		return contactSuccessMessage.getText();
	}

	public HomePage clickContinueBtn() {
		continueBtnAfterSubmittingContactUsEnquiry.click();
		return new HomePage();
	}
	
	public void fillContactUsFormAfterLoggingIn(String yourEnquiry) {
		enterEnquiry(yourEnquiry);
		clickSubmitBtn();
	}
	
	public void fillContactUsFormWithoutLoggingIn(String name,String email,String yourEnquiry) {
		enterName(name);
		enterEmail(email);
		enterEnquiry(yourEnquiry);
		clickSubmitBtn();
	}
	
}
