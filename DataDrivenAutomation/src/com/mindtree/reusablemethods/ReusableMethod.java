package com.mindtree.reusablemethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.utility.Utility;

public class ReusableMethod {
	
	public Object[][] dataprovider(String sheet, int totalColumn) throws Exception{
		Utility utils = new Utility();
		String excelfilePath = "./testdata/TestData.xlsx";
		utils.setExcelFile(excelfilePath, sheet);
		Object[][] testObjArray = ReusableMethod.getTableArray(totalColumn);
		return testObjArray;
		
	}
	
	public static Object[][] getTableArray(int totalColumn) throws Exception {
		Utility utils = new Utility();
		Object[][] tabArray = null;
		int totalRows = Utility.ExcelWSheet.getPhysicalNumberOfRows();
		int totalCols = totalColumn;
		tabArray = new Object[totalRows-1][totalCols];
		for (int i = 1; i < totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				tabArray[i-1][j] = utils.getCellData(i, j);
			}
		}

		return tabArray;
	}
	
	public static void takeScreenshot(String filePath, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		FileUtils.copyFile(srcFile, destFile);
	}
	
	public static String dateTime()
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		Date d = new Date();
		return df.format(d);
	}
	
	public static void dropDownValue(WebDriver driver, String xpath, String type, String value) throws FileNotFoundException, IOException
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		Select sel = new Select(element);
		if(type.equalsIgnoreCase("index"))
			sel.selectByIndex(Integer.parseInt(value)-1);
		else if(type.equalsIgnoreCase("visible"))
			sel.selectByVisibleText(value);
		else if(type.equalsIgnoreCase("value"))
			sel.selectByValue(value);
		
	}

}
