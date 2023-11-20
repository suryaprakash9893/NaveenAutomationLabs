package com.naveenautomationlabs.PageTests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.LoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.base.TestBase;

public class AddressBookPageTest extends TestBase{
	
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	AddressBookPage addressBookPage;
	
	@BeforeMethod
	public void launch() throws MalformedURLException {
		initialisation();
		loginPage=new LoginPage();
	}
	
	@Test
	public void validateIfAnUserCanAddANewAddressToAddressBook() {
		myAccountPage=loginPage.submitLogin("suryaprakasha@live.in","goppa1234");
		addressBookPage=myAccountPage.openAddressBookPage();
		addressBookPage.addNewAddressToAddressBook("Pranav", "Babu", "17 Leslie Street", "Toronto", "M1T1G7", "Canada", "Ontario");
		Assert.assertEquals(addressBookPage.getTextOfSuccessBannerAfterAddingANewAddress(),"Your address has been successfully added","New address couldnot be added!");
	}
	
	@Test
	public void validateIfAnUserCanDeleteAnExistingAddressInAddressBook() {
		myAccountPage=loginPage.submitLogin("suryaprakasha@live.in","goppa1234");
		addressBookPage=myAccountPage.openAddressBookPage();
		addressBookPage.deleteTheNthAddressFromTheTable(2).click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(addressBookPage.getTextOfSuccessBannerAfterAddingANewAddress(),"Your address has been successfully deleted","The address couldnot be deleted!");
	}
	
	@Test
	public void validateIfUserCanEditAnExistingAddressInAddressBook() {
		myAccountPage=loginPage.submitLogin("suryaprakasha@live.in","goppa1234");
		addressBookPage=myAccountPage.openAddressBookPage();
		addressBookPage.editTheNthAddressFromTheTable(2).click();
		addressBookPage.editCity("Scarborough");
		addressBookPage.editAddressLine1("74 Fairglen Ave");
		addressBookPage.continueButton();
		Assert.assertEquals(addressBookPage.getTextOfSuccessBannerAfterAddingANewAddress(),"Your address has been successfully updated","The address couldnot be updated!");
	}
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}	 
}
