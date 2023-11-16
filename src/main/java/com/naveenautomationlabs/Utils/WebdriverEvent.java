package com.naveenautomationlabs.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.naveenautomationlabs.base.TestBase;

public class WebdriverEvent extends TestBase implements WebDriverEventListener{

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		logger.info("Before accepting Alerts");
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		logger.info("After accepting Alerts");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		logger.info("After Alert dismissal");
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		logger.info("Before Alert dismissal");
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("Navigating to :"+url);
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("Navigated to :"+url);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		logger.info("Page to be Refreshed");
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		logger.info("Page Refreshed");
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Finding element using: "+by);
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Found element using: "+by);
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicking element: "+element);
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicked on element: "+element);
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		logger.info("Getting text on element: "+element.getText());
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		logger.info("Got text on : "+element.getText());
		
	}

}
