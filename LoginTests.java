package com.guru99.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.Assert;

public class LoginTests extends BaseTests {
	
	@Parameters({"username", "userPassword"})
	
	
	@Test
	public void verifyUserLoginWithCorrectCredentials(String username, String password) {
		
		reportUtils.createATestCase("verifyUserLoginWithCorrectCredentials");
		
		reportUtils.addTestLog(Status.INFO, "Performing Login");
		
		// need instance of LoginPage, to actually login
		loginpage.loginToApplication(username, password);
		
		// add an assertion to compare the Title of page
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = cmnDriver.getTitleOfThePage();
		
		reportUtils.addTestLog(Status.INFO, "Comparing expected and actual titles");
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
}
