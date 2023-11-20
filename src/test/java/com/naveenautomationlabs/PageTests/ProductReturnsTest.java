package com.naveenautomationlabs.PageTests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.ProductReturnsPage;
import com.naveenautomationlabs.base.TestBase;

public class ProductReturnsTest extends TestBase {

	LoginPage loginPage;
	MyAccountPage myAccountPage;
	ProductReturnsPage productReturnsPage;

	@BeforeMethod
	public void launch() throws MalformedURLException {
		initialisation();
		loginPage = new LoginPage();
	}

	// Validate user can view returns if .
	@Test
	public void validateUserCanViewReturns() {
		myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
		productReturnsPage = myAccountPage.viewReturnRequests();
		Assert.assertEquals(productReturnsPage.getNoItemsToReturnText(), "You have not made any previous returns!",
				"Below items are returned");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
