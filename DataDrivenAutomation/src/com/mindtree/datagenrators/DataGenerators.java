package com.mindtree.datagenrators;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.mindtree.reusablemethods.ReusableMethod;

public class DataGenerators {
	
	@DataProvider(name="dataProvider")
	public static Object[][] data(Method met) throws Exception
	{
		ReusableMethod rm = new ReusableMethod();
		if(met.getName().equalsIgnoreCase("checkLogin"))
		{
		return rm.dataprovider("login", 4);
		}
		else if(met.getName().equalsIgnoreCase("register"))
		{
			return rm.dataprovider("register", 9);
		}
		else
		{
			Object[][] obj = new Object[2][3];
			return obj;
		}
	}
	
}
