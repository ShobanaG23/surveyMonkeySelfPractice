package com.surveyMonkey.TestBase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass<browserName> {

	public WebDriver driver;
	public Properties prop;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	
	@BeforeClass
	@Parameters("browserName")
	public void setup(String br) throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\rarav\\eclipse-workspace\\surveyMonkeyFrameworkPractice\\resources\\config.properties");
		prop.load(fis);
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("chrome browser is launched");
			
		} else if(br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("edge browser is launched");
			
		} else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("firefox browser is launched");
			
		} else {
			logger.info("please select proper browser chrome/edge/firefox");
		}
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "SurveyMonkey: The World’s Most Popular Free Online Survey Tool","Survey monkey application is not launched " );
		
		logger.info("Survey monkey application is launched successfully");
		
	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
		logger.info("Survey monkey application is closed");
	}
	
	public void captureScreenshot(WebDriver driver,String testName ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
		FileUtils.copyFile(source, target);
		logger.info("screenshot has been captured");
	}
}
