package com.naveenautomationlabs.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomationlabs.base.TestBase;

public class CustomListener extends TestBase implements ITestListener {

	// Invoked each time a test starts.
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("***************************Test Case Started " + result.getMethod().getMethodName()
				+ "***************************");
	}

	// Invoked each time a test succeeds.
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("***************************Test Case Succeeded " + result.getMethod().getMethodName()
				+ "***************************");
	}

	// Invoked each time a test fails.
	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("!!!!!!!!!!!!!!!!Test Case Failed " + result.getMethod().getMethodName()
				+ " Taking Screenshot!!!!!!!!!!!!!!!!!!!!");
		Utilty.takefailTestScreenShot(result.getMethod().getMethodName());
	}

	// Invoked each time a test is skipped.
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("***************************Test Case Skipped " + result.getMethod().getMethodName()
				+ "***************************");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
