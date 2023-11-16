package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class AccountLogOutPage extends TestBase {

	public AccountLogOutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content>p")
	WebElement logoutSuccessMessageBanner;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	public String getAccountLogoutSuccessText() {
		return logoutSuccessMessageBanner.getText();
	}

	public HomePage continueToHomePage() {
		continueBtn.click();
		return new HomePage();
	}

}
