package com.naveenautomationlabs.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {

	int count = 1;
	int maxCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying Failed test :"+result.getMethod().getMethodName());
		if (count < maxCount) {
			count++;
			return true;
		}
		return false;
	}
}
