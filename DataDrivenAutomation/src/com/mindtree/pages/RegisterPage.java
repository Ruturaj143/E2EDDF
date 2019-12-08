package com.mindtree.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablemethods.ReusableMethod;
import com.mindtree.utility.Utility;

public class RegisterPage {
	
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
	this.driver = driver;	
	}
	
	public void selectGender() throws FileNotFoundException, IOException
	{
	driver.findElement(By.xpath(Utility.fetchElementPropetyFileData("register_Mr_xpath"))).click();	
	}
	
	public void enterFirstName(String firstName) throws FileNotFoundException, IOException
	{
		driver.findElement(By.xpath(Utility.fetchElementPropetyFileData("register_firstName_xpath"))).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) throws FileNotFoundException, IOException
	{
		driver.findElement(By.xpath(Utility.fetchElementPropetyFileData("register_lastName_xpath"))).sendKeys(lastName);
	}
	
	public void enterPassword(String password) throws FileNotFoundException, IOException
	{
		driver.findElement(By.xpath(Utility.fetchElementPropetyFileData("register_password_xpath"))).sendKeys(password);
	}
	
	public void enterDOB(String dob) throws FileNotFoundException, IOException
	{
		ReusableMethod.dropDownValue(driver,Utility.fetchElementPropetyFileData("register_DOB_xpath"), "value", dob);
	}
	
	public void enterDOM(String dom) throws FileNotFoundException, IOException
	{
		ReusableMethod.dropDownValue(driver, Utility.fetchElementPropetyFileData("register_DOM_xpath"), "value", dom);
	}
	
	public void enterDOY(String doy) throws FileNotFoundException, IOException
	{
		ReusableMethod.dropDownValue(driver, Utility.fetchElementPropetyFileData("register_DOY_xpath"), "value", doy);
	}

}
