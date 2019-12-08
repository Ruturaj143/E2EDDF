package com.mindtree.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {

	public static boolean validateUrl(WebDriver driver, String expUrl)
	{
		boolean result = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expUrl))
			result = true;
		return result;
	}
	
	public static boolean validatePageTitle(WebDriver driver, String expTitle)
	{
		boolean result = false;
		if(driver.getTitle().equalsIgnoreCase(expTitle))
			result = true;
		return result;
	}
	
	public static String validateUsrname(WebDriver driver, String xpath)
	{
		return driver.findElement(By.xpath(xpath)).getText();
	}
}
