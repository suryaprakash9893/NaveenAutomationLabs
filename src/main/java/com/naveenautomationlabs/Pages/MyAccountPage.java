package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.Utils.Utilty;
import com.naveenautomationlabs.base.TestBase;

public class MyAccountPage extends TestBase {

	// Constructor for MyAccountPage
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	// Object of EditAccountInfoPage which is not initialised.
	EditAccountInfoPage editAccountInfoPage;
	NewsletterPage newsletterPage;
	LaptopsAndNotebooksPage laptopsAndNotebooksPage;

	@FindBy(css = "#content>h2:first-of-type")
	WebElement myAccountText;

	// Update account info success message. // Success: Your account has been
	// successfully updated.
	@FindBy(css = "div.alert-success")
	WebElement accountInfoUpdateSuccessBanner;

	@FindBy(xpath = "//a[text()='Change your password']")
	WebElement changePassword;

	// Update password success message. // Success: Your password has been
	// successfully updated.
	@FindBy(css = "div.alert-success")
	WebElement updatePasswordSuccessMessage;

	@FindBy(css = "div.list-group>a:last-of-type")
	WebElement logoutBtn;

	@FindBy(xpath = "//a[text()='View your return requests']")
	WebElement viewReturnRequests;
	
	//Newsletter update success Banner.
	@FindBy(css="div.alert-success")
	WebElement newsLetterSubBanner;
	
	//Contact us Webelement
	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement contactUsButton;
	
	//LaptopsAndNoteBooks Button
	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	WebElement laptopsAndNotebooksButton;
	
	//Show all Laptops & Notebooks
	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	WebElement showAllLaptopsAndNotebooksButton;

	public String getMyAccountText() {
		return myAccountText.getText();
	}
	
	public String getNewsletterSubUpdateBanner() {
		return newsLetterSubBanner.getText();
	}

	public ChangePasswordPage updatePassword() {
		changePassword.click();
		return new ChangePasswordPage();
	}

	public AccountLogOutPage logoutFromUserAccount() {
		Utilty.findSideNavBarElements(sideNavBarElements.LOGOUT.getSideNavBarElement());
		return new AccountLogOutPage();
	}

	public ProductReturnsPage viewReturnRequests() {
		Utilty.findSideNavBarElements(sideNavBarElements.RETURNS.getSideNavBarElement());
		return new ProductReturnsPage();
	}

	public EditAccountInfoPage openEditAccountInfoPage() {
		Utilty.findSideNavBarElements(sideNavBarElements.EDIT_ACCOUNT.getSideNavBarElement());
		return new EditAccountInfoPage();
	}
	
	public NewsletterPage openNewsletterPage() {
		Utilty.findSideNavBarElements(sideNavBarElements.NEWSLETTER.getSideNavBarElement());
		return new NewsletterPage();
	}
	
	public AddressBookPage openAddressBookPage() {
		Utilty.findSideNavBarElements(sideNavBarElements.ADDRESS_BOOK.getSideNavBarElement());
		return new AddressBookPage();
	}
	
	public  ContactUsPage openContactUsForm() {
		contactUsButton.click();
		return new ContactUsPage();
	}

	public String getPasswordUpdateSuccessMessageText() {
		return updatePasswordSuccessMessage.getText();
	}

	public String getAccountInfoUpdateSuccessMessageText() {
		return accountInfoUpdateSuccessBanner.getText();
	}
	
	public LaptopsAndNotebooksPage openLaptopsAndNotebooksPage() {
		Utilty.hoverOverElement(laptopsAndNotebooksButton);
		showAllLaptopsAndNotebooksButton.click();
		return new LaptopsAndNotebooksPage();
	}
	
	

}
