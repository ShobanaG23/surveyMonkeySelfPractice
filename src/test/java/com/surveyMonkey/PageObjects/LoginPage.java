package com.surveyMonkey.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//1
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(this.getClass());
		
	//2 constructor
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	//3 locators
		@FindBy(xpath="//input[@aria-label='Email address']")
		WebElement txtUsername;
		
		@FindBy(xpath ="//input[@aria-label='Password']")
		WebElement txtPassword;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		WebElement lnkNextorLogin;
		
	//4 METHOD FOR Locator
		
		public void EnterUsername(String uname) {
			
			txtUsername.clear();
			txtUsername.sendKeys(uname);
			String username = txtUsername.getAttribute("value");
			logger.info("username enetered is :" + username);
		}
		
		public void EnterPassword(String pwd) {
			
			txtPassword.clear();
			txtPassword.sendKeys(pwd);
			String password = txtPassword.getAttribute("value");
			logger.info("password enetered is :" + password);
		}
		
		public void clickNextOrLoginButton(String buttonName) {
			
			if (buttonName.equalsIgnoreCase("next")) {
				lnkNextorLogin.click();
				logger.info("next button is clicked");
				
			} else if (buttonName.equalsIgnoreCase("login")) {
				lnkNextorLogin.click();
				logger.info("login button is clicked");
				
			}else {
				logger.info("please enter a valid button name");
			}
			
		}
}
