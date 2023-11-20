package com.naveenautomationlabs.PageTests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.LaptopsAndNotebooksPage;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.base.TestBase;

public class LaptopsAndNotebooksPageTest extends TestBase {

	LoginPage loginPage;
	MyAccountPage myAccountPage;
	LaptopsAndNotebooksPage laptopsAndNotebooksPage;

	@BeforeMethod
	public void launch() throws MalformedURLException {
		initialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfWeCanToListView() {
		myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
		laptopsAndNotebooksPage = myAccountPage.openLaptopsAndNotebooksPage();
		laptopsAndNotebooksPage.changeToListView();
		Assert.assertEquals(laptopsAndNotebooksPage.isListViewSelected(), true, "ListView not selected!");
	}

	@Test
	public void validateIfWeCanToGridView() {
		myAccountPage = loginPage.submitLogin("suryaprakasha@live.in", "goppa1234");
		laptopsAndNotebooksPage = myAccountPage.openLaptopsAndNotebooksPage();
		laptopsAndNotebooksPage.changeToGridView();
		Assert.assertEquals(laptopsAndNotebooksPage.isGridViewSelected(), true, "GridView not selected!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
