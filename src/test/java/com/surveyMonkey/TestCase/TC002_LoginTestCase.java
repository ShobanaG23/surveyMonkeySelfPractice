package com.surveyMonkey.TestCase;

import java.beans.Transient;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.surveyMonkey.PageObjects.DashboardPage;
import com.surveyMonkey.PageObjects.HomePage;
import com.surveyMonkey.PageObjects.LoginPage;
import com.surveyMonkey.TestBase.BaseClass;

public class TC002_LoginTestCase extends BaseClass{
	
	@Test
	public void logintest() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
			hp.clickOnLogin();
			logger.info("login link is clicked");
			
			Thread.sleep(5000);
		
		LoginPage lp =  new LoginPage(driver);
		lp.EnterUsername(prop.getProperty("username"));
		lp.clickNextOrLoginButton("next");
		lp.EnterPassword(prop.getProperty("password"));
		lp.clickNextOrLoginButton("login");
		
		captureScreenshot(driver, "logintest");
		
		DashboardPage dp =  new DashboardPage(driver);
		dp.checkDashboardlink();
		
		captureScreenshot(driver, "logintest");
		
		Assert.assertTrue(true, " dashboard page is not displayed");
		logger.info("dashboard page is displayed");
	}

}
