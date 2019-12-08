package com.mindtree.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mindtree.base.DriverInstance;
import com.mindtree.datagenrators.DataGenerators;
import com.mindtree.pages.LoginPage;
import com.mindtree.pages.RegisterPage;
import com.mindtree.reusablemethods.ReusableMethod;
import com.relevantcodes.extentreports.LogStatus;

public class TC_002_ValidateRegisterFunctionality extends DriverInstance{
	
	@Test(dataProvider="dataProvider", dataProviderClass=DataGenerators.class)
	public void register(String Tc, String email, String firstName, String lastName, String password, String dob, String dom, String doy, String run) throws IOException
	{
		if(run.equalsIgnoreCase("y")) {
		LoginPage login = new LoginPage(driver);
		RegisterPage reg = new RegisterPage(driver);
		test = report.startTest("Register"+Tc);
		String screenshotPath = "C:/BBA1/worspace/DataDrivenAutomation/screenshot/"+ReusableMethod.dateTime()+".png";
		try {
			log.info("---Register Execution started-----");
			login.clickOnSignIn();
			test.log(LogStatus.PASS, "clicked on sign in successfully");
			log.info("sign in clicked");
			login.enterEmail(email);
			test.log(LogStatus.INFO, "Email:"+email);
			log.info("email entered");
			login.createAccount();
			test.log(LogStatus.PASS, "clicked on create Account succefully");
			log.info("crate account entered");
			reg.selectGender();
			test.log(LogStatus.PASS, "Geneder selected");
			log.info("gender selected");
			reg.enterFirstName(firstName);
			test.log(LogStatus.INFO, "FirstName:"+firstName);
			log.info("FirstName entered");
			reg.enterLastName(lastName);
			test.log(LogStatus.INFO, "LastName:"+lastName);
			log.info("Last Name entered");
			reg.enterPassword(password);
			test.log(LogStatus.INFO, "Password:"+password);
			log.info("password entered");
			reg.enterDOB(dob);
			test.log(LogStatus.INFO, "DOB:"+dob);
			log.info("DOB entered");
			reg.enterDOM(dom);
			test.log(LogStatus.INFO, "DOm:"+dom);
			log.info("DOM entered");
			reg.enterDOY(doy);
			test.log(LogStatus.INFO, "DOY:"+doy);
			log.info("DOY entered");
		} catch (Exception e) {
			ReusableMethod.takeScreenshot(screenshotPath, driver);
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
			log.error("Failed at some step");
		}
		}
	}

}
