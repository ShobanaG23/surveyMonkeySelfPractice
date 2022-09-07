package com.surveyMonkey.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//1
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//2 constructor
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3 locators
	
	@FindBy(linkText= "Log in")
	WebElement lnklogin;
	
	//4 methods for login
	
	public void clickOnLogin() {
		
		lnklogin.click();
		logger.info("login link has been clicked");
	}
	
}
