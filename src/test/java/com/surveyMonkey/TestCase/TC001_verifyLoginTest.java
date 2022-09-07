package com.surveyMonkey.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.surveyMonkey.PageObjects.HomePage;
import com.surveyMonkey.TestBase.BaseClass;

public class TC001_verifyLoginTest extends BaseClass {
	
	@Test
	public void clickLoginTest() throws IOException {
		
		HomePage hp = new HomePage(driver);
		
		hp.clickOnLogin();
		String LoginTitle = driver.getTitle();
		logger.info("login page title is :" + LoginTitle);
		captureScreenshot(driver, "clickLoginTest");
		Assert.assertEquals(LoginTitle, "SurveyMonkey - Log in", "Login page is not opened");
		logger.info("login page is opened");
	}
	

}
