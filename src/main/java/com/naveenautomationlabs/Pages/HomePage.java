package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class HomePage extends TestBase {
	
	//WebElement for ContactUs form.
	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement contactUsPageText;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHomepageTitle() {
		return driver.getTitle();
	}

}
