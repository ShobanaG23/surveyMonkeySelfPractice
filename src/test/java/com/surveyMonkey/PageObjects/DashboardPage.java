package com.surveyMonkey.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	//1
			public WebDriver driver;
			public Logger logger = LogManager.getLogger(this.getClass());
			
		//2 constructor
			
			public DashboardPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
		//3
		@FindBy(linkText="Dashboard")
		WebElement lnkDashboard;
		
		public boolean checkDashboardlink() {
			boolean status = lnkDashboard.isDisplayed();
			logger.info(status);
			return status;
		}
}
