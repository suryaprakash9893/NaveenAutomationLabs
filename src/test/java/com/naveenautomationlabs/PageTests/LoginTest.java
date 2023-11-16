package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.base.TestBase;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	MyAccountPage accountPage;

	@BeforeMethod
	public void launch() {
		initialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserCanLoginWithValidCredentials() {
		loginPage.submitLogin("suryaprakasha@live.in","goppa1234");
		Assert.assertEquals(driver.getTitle(), "My Account", "Login failed!");
	}
	
	@Test
	public void validateUserCannotLoginWithInvalidCredentials() {
		loginPage.submitLogin("suryaprakasha@live.in","goppa123");
		Assert.assertEquals(loginPage.loginCredentialsMismatchAlert.getText(), "Warning: No match for E-Mail Address and/or Password.", "Login passed!");
	}

}
