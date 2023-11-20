package com.naveenautomationlabs.PageTests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.EditAccountInfoPage;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.base.TestBase;

public class EditAccountInfoTest extends TestBase {

	MyAccountPage myAccountPage;
	EditAccountInfoPage editAccountInfoPage;
	LoginPage loginPage;

	@BeforeMethod
	public void launch() throws MalformedURLException {
		initialisation();
		loginPage = new LoginPage();
	}
	
	// Validate if user can update First & Last Name.
		@Test
		public void validateUserCanEditName() {
			myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
			editAccountInfoPage = myAccountPage.openEditAccountInfoPage();
			editAccountInfoPage.editFirstName("Suriya"); // Change name from SuryaPrakash to SuriyaPrakaash.
			editAccountInfoPage.editLastName("Prakaash");
			editAccountInfoPage.submitEditBtn();
			Assert.assertEquals(myAccountPage.getAccountInfoUpdateSuccessMessageText(),
					"Success: Your account has been successfully updated.", "Account Info not updated!");
		}

		// Validate if user can update Telephone#.
		@Test
		public void validateUserCanEditTelephone() {
			myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
			editAccountInfoPage = myAccountPage.openEditAccountInfoPage();
			editAccountInfoPage.editTelephone("2269788983");
			editAccountInfoPage.submitEditBtn();
			Assert.assertEquals(myAccountPage.getAccountInfoUpdateSuccessMessageText(),
					"Success: Your account has been successfully updated.", "Account Info not updated!");
		}

		@AfterMethod
		public void quitBrowser() {
			tearDown();
		}
}
