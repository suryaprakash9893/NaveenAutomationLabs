package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.EditAccountInfoPage;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.base.TestBase;

public class MyAccountTest extends TestBase {

	LoginPage loginPage;
	ChangePasswordPage changePasswordPage;
	MyAccountPage myAccountPage;
	EditAccountInfoPage editAccountInfoPage;

	@BeforeMethod
	public void launch() {
		initialisation();
		loginPage = new LoginPage();
	}

	// Validate user can update password.
	@Test(enabled = false)
	public void validateUserCanUpdatePassword() {
		myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
		changePasswordPage = myAccountPage.updatePassword();
		myAccountPage = changePasswordPage.changePassword("goppa123", "goppa123");
		Assert.assertEquals(myAccountPage.getPasswordUpdateSuccessMessageText(),
				"Success: Your password has been successfully updated.", "Password not changed!");
	}
}
