package com.naveenautomationlabs.PageTests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLogOutPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.EditAccountInfoPage;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.base.TestBase;

public class AccountLogOutTest extends TestBase {

	LoginPage loginPage;
	ChangePasswordPage changePasswordPage;
	MyAccountPage myAccountPage;
	EditAccountInfoPage editAccountInfoPage;
	AccountLogOutPage accountLogOutPage;

	@BeforeMethod
	public void launch() throws MalformedURLException {
		initialisation();
		loginPage = new LoginPage();
	}

	// Validate if user can Logout from their account.
	@Test
	public void validateUserCanLogoutFromTheirAccount() {
		myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
		accountLogOutPage = myAccountPage.logoutFromUserAccount();
		Assert.assertEquals(accountLogOutPage.getAccountLogoutSuccessText(),
				"You have been logged off your account. It is now safe to leave the computer.",
				"Account not Logged Out!");
	}

}
