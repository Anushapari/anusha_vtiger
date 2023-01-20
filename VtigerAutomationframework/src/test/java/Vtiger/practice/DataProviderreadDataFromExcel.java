package Vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelFileUtility;

public class DataProviderreadDataFromExcel {
	@Test(dataProvider="readmultipledata")
	public void getdata(String src, String dst)
	{
		System.out.println("from "+src+"to  "+ dst );
	}
	
@DataProvider
public Object[][] readmultipledata() throws Throwable
	{
	ExcelFileUtility eutil=new ExcelFileUtility();
	Object[][] value=eutil.readMultipleData("DataProvider");
	return value;
		
		
	}
}

