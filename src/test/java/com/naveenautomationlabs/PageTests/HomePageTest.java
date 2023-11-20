package com.naveenautomationlabs.PageTests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLogOutPage;
import com.naveenautomationlabs.Pages.HomePage;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.base.TestBase;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	MyAccountPage myAccountPage;
	AccountLogOutPage accountLogOutPage;
	HomePage homePage;

	@BeforeMethod
	public void launch() throws MalformedURLException {
		initialisation();
		loginPage = new LoginPage();
	}

	// Validate user can continue to HomePage after Logging out from Their account.
	@Test
	public void validateUserCanNavigateToHomepageAfterLoggingOut() {
		myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
		accountLogOutPage = myAccountPage.logoutFromUserAccount();
		homePage = accountLogOutPage.continueToHomePage();
		Assert.assertEquals(homePage.getHomepageTitle(), "Your Store", "Home Page not Loaded!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
