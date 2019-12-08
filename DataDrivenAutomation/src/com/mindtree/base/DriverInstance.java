
package com.mindtree.base;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mindtree.reusablemethods.ReusableMethod;
import com.mindtree.utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class DriverInstance {

	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static Logger log;
	
	@BeforeSuite
	public void beforeTest()
	{
		report = new ExtentReports("./Report/ExtentReport/myautomation"+ReusableMethod.dateTime()+".html",true);
		report.addSystemInfo("Leneovo", "automation");
		log = Logger.getLogger("MyAutomation");
		PropertyConfigurator.configure("./config/log4j.properties");
	}
	
	@BeforeMethod
	public void driverInitiate() throws FileNotFoundException, IOException
	{
		if(Utility.fetchConfigPropetyFileData("browserName").toString().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Utility.fetchConfigPropetyFileData("browserName").toString().equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Utility.fetchConfigPropetyFileData("appUrl").toString());
	}
	
	@AfterMethod
	public void driverClose()
	{
		driver.quit();
		
	}
	
	@AfterSuite
	public void afterTest()
	{
		report.flush();
	}
}
