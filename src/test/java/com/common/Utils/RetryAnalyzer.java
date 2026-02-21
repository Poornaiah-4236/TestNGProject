package com.common.Utils;

import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int counter = 0;
		int retryLimit = 4;
		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
