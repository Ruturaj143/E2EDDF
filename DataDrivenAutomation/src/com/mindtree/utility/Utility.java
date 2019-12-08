package com.mindtree.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	private XSSFCell Cell;

	public static Object fetchConfigPropetyFileData(String key) throws FileNotFoundException, IOException 
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream("./config/config.properties"));
		return prop.get(key);
	}
	
	public static String fetchElementPropetyFileData(String key) throws FileNotFoundException, IOException 
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream("./config/element.properties"));
		
		return prop.get(key).toString();
	}
	public void setExcelFile(String Path, String SheetName) throws Exception {
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}
	
	public String getCellData(int RowNum, int ColNum) throws Exception {
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		return CellData;
	}

	

}
