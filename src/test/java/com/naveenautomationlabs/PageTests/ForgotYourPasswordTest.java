package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.base.TestBase;

public class ForgotYourPasswordTest extends TestBase {

	LoginPage loginPage;
	ForgotYourPasswordPage forgotYourPasswordPage;

	@BeforeMethod
	public void launch() {
		initialisation();
		loginPage = new LoginPage();
	}

	//validate user cannot recover password of an account using an unregistered email.
	@Test
	public void validateUserCannotRetreivePasswordOfAnInvalidEmail() {
		forgotYourPasswordPage = loginPage.submitForgotPassword();
		forgotYourPasswordPage.emailInputForForgotPassword("goppa@live.in");
		forgotYourPasswordPage.submitEmailInputForForgotPassword();
		Assert.assertEquals(forgotYourPasswordPage.getEmailNotFoundBannerText(),
				"Warning: The E-Mail Address was not found in our records, please try again!",
				"Password recovery sent to email");
	}

}
