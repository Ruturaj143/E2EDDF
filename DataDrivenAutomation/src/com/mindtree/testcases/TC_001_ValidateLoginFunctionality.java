package com.mindtree.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mindtree.assertion.Compare;
import com.mindtree.base.DriverInstance;
import com.mindtree.datagenrators.DataGenerators;
import com.mindtree.pages.LoginPage;
import com.mindtree.reusablemethods.ReusableMethod;
import com.mindtree.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class TC_001_ValidateLoginFunctionality extends DriverInstance{

	@Test(dataProvider="dataProvider", dataProviderClass=DataGenerators.class)
	public void checkLogin(String Tc, String userName, String password, String run) throws IOException 
	{
		if(run.equalsIgnoreCase("y")){
			test = report.startTest("login:"+Tc);
			LoginPage login = new LoginPage(driver);
			String screenshotPath = "C:/BBA1/worspace/DataDrivenAutomation/screenshot/"+ReusableMethod.dateTime()+".png";
			try {
				log.info("----Login execution Started------");
				login.clickOnSignIn();
				test.log(LogStatus.PASS, "clickonSignIn Successfully");
				log.info("sign in button clicked");
				login.enterUsername(userName);
				test.log(LogStatus.INFO, "UserName:"+userName);
				log.info("username entered");
				login.enterPassword(password);
				test.log(LogStatus.INFO, "Password:"+password);
				log.info("password entered");
				login.clickOnLogin();
				test.log(LogStatus.PASS, "click on Login successfully");
				log.info("login button clicked");
				Assert.assertEquals(Compare.validateUsrname(driver, Utility.fetchElementPropetyFileData("login_username_xpath")),"Ruturaj Madiwale");
				test.log(LogStatus.PASS, "assertion passed successfully");
				log.info("login done and compared the actual login username with expected username");
			} catch(AssertionError a)
			{
				test.log(LogStatus.FAIL, "assertion failed:"+a.getMessage());
				log.error("login comarison failed the actual username is not matching with the expected username");
			}
			catch (Exception e) {
				ReusableMethod.takeScreenshot(screenshotPath, driver);
				test.log(LogStatus.FAIL, "Fail"+test.addScreenCapture(screenshotPath));
				log.error("Test case failed at some step");

			}
		}

	}



}
