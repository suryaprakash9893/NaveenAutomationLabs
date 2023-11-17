package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.RegistrationPage;
import com.naveenautomationlabs.base.TestBase;

public class RegistrationPageTest extends TestBase {

	private LoginPage loginPage;
	private RegistrationPage registrationPage;

	@BeforeMethod
	public void launch() {
		initialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserCannotRegisterwithoutCheckingTheAgreeToCheckbox() {
		registrationPage = loginPage.clickContinueRegisterBtn();
		registrationPage.fillRegistrationForm("Surya", "Prakash", "suryaprakasha@live.in", "2269788983", "goppa1234",
				"goppa1234");
		registrationPage.clickContinueBtn();
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
				registrationPage.getprivacyPolicyAgreeCheckBoxValidationMessage());
	}
	
	public void validateUserCannotRegisterWithoutFillingAllTheMandatoryFields() {
		registrationPage = loginPage.clickContinueRegisterBtn();
	}
	
	public void validateIfUserCanREgisterWithoutMandatoryFields() {
		System.out.println("Dummy Test case");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
