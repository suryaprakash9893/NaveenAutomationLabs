package com.naveenautomationlabs.PageTests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.RegistrationPage;
import com.naveenautomationlabs.Pages.RegistrationSuccessMessagePage;
import com.naveenautomationlabs.base.TestBase;

public class RegistrationPageTest extends TestBase {

	private LoginPage loginPage;
	private RegistrationPage registrationPage;
	private RegistrationSuccessMessagePage registrationSuccessMessagePage;

	@BeforeMethod
	public void launch() throws MalformedURLException {
		initialisation();
		loginPage = new LoginPage();
	}

	// Validate if user cannot Register without checking the "Agree To" box.
	@Test
	public void validateUserCannotRegisterwithoutCheckingTheAgreeToCheckbox() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "Prakash", "suryaprakasha@live.in", "2269788983", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
				registrationPage.getprivacyPolicyAgreeCheckBoxValidationMessage());
	}

	// Validate if user cannot Register with an Invalid First Name.
	// Bug identified!
	@Test
	public void validateUserCannotRegisterWithAnInvalidFirstName() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("1234", "Prakash", "suryaprakasha@live.in", "2269788983", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
				registrationPage.getprivacyPolicyAgreeCheckBoxValidationMessage());
	}

	// Validate if user cannot Register with an invalid filling the First Name.
	@Test
	public void validateUserCannotRegisterWithoutFillingFirstName() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("", "Prakash", "suryaprakasha@live.in", "2269788983", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				registrationPage.getEnterFNameRequirementsBanner(), "First Name entered.");
	}

	// Validate if user cannot Register without filling the Last Name.
	//Bug identified!
	@Test
	public void validateUserCannotRegisterWithAnInvalidLastName() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "1234", "suryaprakasha@live.in", "2269788983", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
				registrationPage.getprivacyPolicyAgreeCheckBoxValidationMessage());
	}

	// Validate if user cannot Register with an invalid filling the Last Name.
	@Test
	public void validateUserCannotRegisterWithoutFillingLastName() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "", "suryaprakasha@live.in", "2269788983", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
				registrationPage.getEnterLNameRequirementsBanner(), "Last Name entered.");
	}

	// Validate if user cannot Register without filling the email.
	@Test
	public void validateUserCannotRegisterWithoutFillingEmail() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "Prakash", "", "2269788983", "goppa1234", "goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("E-Mail Address does not appear to be valid!",
				registrationPage.getEnterEmailRequirementsBanner(), "Email address entered.");
	}

	// Validate if user cannot Register without filling the Phone Number.
	@Test
	public void validateUserCannotRegisterWithoutFillingPhoneNumber() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "Prakash", "suryaprakasha@live.in", "", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registrationPage.getEnterPhoneRequirementsBanner(), "Telephone number entered.");
	}

	// Validate if user cannot Register with An Invalid Phone Number.
	//Bug identified- Telephone# can take alphabets.
	@Test
	public void validateUserCannotRegisterWithAnInvalidPhoneNumber() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "Prakash", "suryaprakasha@live.in", "su", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registrationPage.getEnterPhoneRequirementsBanner(), "Telephone number entered.");
	}

	// Validate if user cannot Register without filling the Password.
	@Test
	public void validateUserCannotRegisterWithoutFillingPassword() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "Prakash", "suryaprakasha@live.in", "2269788983", "", "");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("Password must be between 4 and 20 characters!",
				registrationPage.getEnterPasswordRequirementsBanner(), "Password entered.");
	}

	// Validate if user cannot Register if Passwords don't match.
	@Test
	public void validateUserCannotRegisterIfPasswordsDontMatch() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "Prakash", "dummy@email1.com", "2269788983", "goppa123",
				"goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("Password confirmation does not match password!",
				registrationPage.getPasswordMisMatchWarningBanner(), "Password entered matches Password confirmation.");
	}

	// Validate if user cannot Register with an already registered email.
	@Test
	public void validateUserCannotRegisterWithAnAlreadyRegisteredEmail() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "Prakash", "suryaprakasha@live.in", "2269788983", "goppa1234",
				"goppa1234");
		registrationPage.clickAgreeCheckBox();
		registrationPage.clickContinueBtn();
		Assert.assertEquals("Warning: E-Mail Address is already registered!",
				registrationPage.getEmailAlreadyRegisteredWarningBanner(), "Valid Email address entered.");
	}

	// Validate if user can register with all mandatory fields filled as per
	// requirements.
	@Test(enabled = false)
	public void validateUserCannotRegisterWithAllMandatoryFieldsFilledAsPerRequirements() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Suriya", "Prakaash", "frsurya@yahoo.com", "2269788983", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		registrationPage.clickAgreeCheckBox();
		Assert.assertEquals("Congratulations! Your new account has been successfully created!",
				registrationSuccessMessagePage.getRegistrationSucessMessage(), "Registration failed!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
