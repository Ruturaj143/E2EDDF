package com.mindtree.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mindtree.utility.Utility;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
	this.driver = driver;	
	}
	
	public void enterUsername(String username) throws FileNotFoundException, IOException
	{
		driver.findElement(By.id(Utility.fetchElementPropetyFileData("login_username_id"))).sendKeys(username);
	}
	
	public void enterPassword(String password) throws FileNotFoundException, IOException
	{
		driver.findElement(By.id(Utility.fetchElementPropetyFileData("login_password_id"))).sendKeys(password);
	}
	
	public void clickOnSignIn() throws FileNotFoundException, IOException
	{
		driver.findElement(By.xpath(Utility.fetchElementPropetyFileData("login_signIn_xpath"))).click();;
	}
	
	public void clickOnLogin() throws FileNotFoundException, IOException
	{
		driver.findElement(By.xpath(Utility.fetchElementPropetyFileData("login_logIn_xpath"))).click();
	}
	
	public void enterEmail(String email) throws FileNotFoundException, IOException
	{
		driver.findElement(By.name(Utility.fetchElementPropetyFileData("register_email_name"))).sendKeys(email);
	}
	
	public void createAccount() throws FileNotFoundException, IOException
	{
		driver.findElement(By.xpath(Utility.fetchElementPropetyFileData("register_createAccount_xpath"))).click();
	}
	
	public void enterSurName(String surname) throws FileNotFoundException, IOException
	{
		driver.findElement(By.name(Utility.fetchElementPropetyFileData("register_surname_name"))).sendKeys(surname);
	}
	
	public void enterPhoneNum(String phoneNum) throws FileNotFoundException, IOException
	{
		driver.findElement(By.xpath(Utility.fetchElementPropetyFileData("register_phonenumber_xpath"))).sendKeys(phoneNum);
	}

}
