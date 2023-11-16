package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterPage;
import com.naveenautomationlabs.base.TestBase;

public class NewsletterPageTest extends TestBase {

	LoginPage loginPage;
	NewsletterPage newsletterPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void launch() {
		initialisation();
		loginPage = new LoginPage();
	}
	
	@Test
	public void validateIfNewsletterCanBeSubscribed() {
		myAccountPage=loginPage.submitLogin("suryaprakasha@live.in","goppa1234");
		newsletterPage=myAccountPage.openNewsletterPage();
		myAccountPage=newsletterPage.enableNewsletterSubs();
		Assert.assertEquals(myAccountPage.getNewsletterSubUpdateBanner(), "Success: Your newsletter subscription has been successfully updated!" , "Newsletter not subscribed");
	}
	
	@Test
	public void validateIfNewsletterCanBeUnSubscribed() {
		myAccountPage=loginPage.submitLogin("suryaprakasha@live.in","goppa1234");
		newsletterPage=myAccountPage.openNewsletterPage();
		myAccountPage=newsletterPage.disableNewsletterSubs();
		Assert.assertEquals(myAccountPage.getNewsletterSubUpdateBanner(), "Success: Your newsletter subscription has been successfully updated!" , "Newsletter not subscribed");
	}

}
