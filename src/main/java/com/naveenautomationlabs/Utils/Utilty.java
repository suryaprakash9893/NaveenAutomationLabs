package com.naveenautomationlabs.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.base.TestBase;

public class Utilty extends TestBase {

	public static String getCurrentDateTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

	public static void takefailTestScreenShot(String testMethodName) {

		String timeStamp = getCurrentDateTimeStamp();

		File screenShotFfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile,
					new File("./FailedTestCasesScreenShot\\" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}
	}
	
	public static boolean isRadioButtonSelected(WebElement webElement) {
		return webElement.isSelected();
	}
	
	public static void selectFromDropDownByVisibleText(WebElement element, String visibleText) {
		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);
	}
	
	public static void hoverOverElement(WebElement webElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).perform();
	}

	public static void findSideNavBarElements(String elementText) {
		List<WebElement> sideNavBar = driver.findElements(By.cssSelector("div.list-group>a"));
		for (WebElement webElement : sideNavBar) {
			if (webElement.getText().equals(elementText)) {
				webElement.click();
				break;
			}
		}
	}
}
