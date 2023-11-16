package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomationlabs.base.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {
	
	LoginPage loginPage;

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "list-view")
	WebElement listViewButton;
	
	@FindBy(id = "grid-view")
	WebElement gridViewButton;
	
	public void changeToListView() {
		listViewButton.click();
	}
	
	public void changeToGridView() {
		gridViewButton.click();
	}
	
	public boolean isListViewSelected() {
		if(listViewButton.isEnabled()) {
			return true;
		}else
			return false;
	}
	
	public boolean isGridViewSelected() {
		if(gridViewButton.isEnabled()) {
			return true;
		}else
			return false;
	}
}
