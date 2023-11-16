package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class NewsletterPage extends TestBase {

	public NewsletterPage() {
		PageFactory.initElements(driver, this);
	}

	MyAccountPage myAccountPage;

	//Disable Newsletter subscription Radio button 
	@FindBy(css = "input[value='0']")
	WebElement radioBtnNoForNewsletter;

	//Enable Newsletter subscription Radio button
	@FindBy(css = "input[value='1']")
	WebElement radioBtnYesForNewsletter;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtnForNewsletter;

	//Method to enable Newsletter subs.
	public MyAccountPage enableNewsletterSubs() {
		if (radioBtnNoForNewsletter.isSelected()) {
			radioBtnYesForNewsletter.click();
		}
		continueBtnForNewsletter.click();
		return new MyAccountPage();
	}

	//Method to Disable Newsletter subs.
	public MyAccountPage disableNewsletterSubs() {
		if (radioBtnYesForNewsletter.isSelected()) {
			radioBtnNoForNewsletter.click();
		}
		continueBtnForNewsletter.click();
		return new MyAccountPage();
	}
}
