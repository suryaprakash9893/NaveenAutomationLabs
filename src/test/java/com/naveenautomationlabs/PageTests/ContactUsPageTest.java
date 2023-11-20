package com.naveenautomationlabs.PageTests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.ContactUsPage;
import com.naveenautomationlabs.Pages.HomePage;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.base.TestBase;

public class ContactUsPageTest extends TestBase {
	LoginPage loginPage;
	ContactUsPage contactUsPage;
	MyAccountPage myAccountPage;
	HomePage homePage;

	@BeforeMethod
	public void launch() throws MalformedURLException {
		initialisation();
		loginPage = new LoginPage();
	}

	// Validate if an user can submit a completed form after logging in.
	@Test
	public void validateIfALoggedInUserCanSubmitContactUs() {
		myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
		contactUsPage = myAccountPage.openContactUsForm();
		contactUsPage.fillContactUsFormAfterLoggingIn("When will the black friday sale start?");
		Assert.assertEquals(contactUsPage.getcontactSuccessMessage(),
				"Your enquiry has been successfully sent to the store owner!", "Enquiry not submitted!");
		homePage = contactUsPage.clickContinueBtn();
		Assert.assertEquals(homePage.getHomepageTitle(), "Your Store",
				"Not returned to HomePage upon submitting the Enquiry!");
	}

	// Validate if an user can submit a completed form without logging in.
	@Test
	public void validateIfAUserCanSubmitAContactUsFormWithoutLoggingIn() {
		contactUsPage = loginPage.openContactUsForm();
		contactUsPage.fillContactUsFormWithoutLoggingIn("Surya", "suryaprakasha@live.in",
				"What is the return policy for items with water damage");
		Assert.assertEquals(contactUsPage.getcontactSuccessMessage(),
				"Your enquiry has been successfully sent to the store owner!", "Enquiry not submitted!");
		homePage = contactUsPage.clickContinueBtn();
		Assert.assertEquals(homePage.getHomepageTitle(), "Your Store",
				"Not returned to HomePage upon submitting the Enquiry!");
	}

	// Validate if an user can submit a Blank form after logging in.
	@Test
	public void validateIfALoggedInUserCanSubmitAContactUsFormWithABlankEnquiry() {
		myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
		contactUsPage = myAccountPage.openContactUsForm();
		contactUsPage.clickSubmitBtn();
		Assert.assertEquals(contactUsPage.getEnquiryAlertMessage(), "Enquiry must be between 10 and 3000 characters!",
				"Failed to display name alert message");
	}

	// Validate if a user can submit a Blank form without logging in.
	@Test
	public void validateIfAUserCanSubmitABlankContactUsFormWithoutLoggingIn() {
		contactUsPage = loginPage.openContactUsForm();
		contactUsPage.fillContactUsFormWithoutLoggingIn("", "", "");
		Assert.assertEquals(contactUsPage.getNameAlertMessage(), "Name must be between 3 and 32 characters!",
				"Name alert message not displayed!");
		Assert.assertEquals(contactUsPage.getEmailAddressAlert(), "E-Mail Address does not appear to be valid!",
				"Email alert message not displayed!");
		Assert.assertEquals(contactUsPage.getEnquiryAlertMessage(), "Enquiry must be between 10 and 3000 characters!",
				"Enquiry alert message not displayed!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
