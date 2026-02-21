package com.common.Tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DataProvider {
	//@Test(dataProvider="RegressData",dataProviderClass=parametes.class)
	public void dataProviderTest(String name,String password) {
		System.out.println(name+password+" from derived class");
		Reporter.log(password);
		Assert.assertEquals(30, 30);
		//Assert.
	}
	public Object[][]dpMethod(Method m){
		
			switch(m.getName()) {
			case "sum":
				return new Object[][] {{5,7,8},{7,4,9}};
			case "diff":
				return new Object[][] {{5,2,9},{8.4,7}};
			}
		
		return null;
	}
}
