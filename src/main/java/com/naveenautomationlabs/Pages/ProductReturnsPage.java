package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class ProductReturnsPage extends TestBase {

	public ProductReturnsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content>p")
	WebElement noItemsToReturnBanner;

	public String getNoItemsToReturnText() {
		return noItemsToReturnBanner.getText();
	}

}
