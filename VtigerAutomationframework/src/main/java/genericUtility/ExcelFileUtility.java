package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String readDataFromExcelSheet(String Sheetname,int rowno,int cellno) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\organization.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		Row rw = sh.getRow(rowno);
		Cell ce=rw.getCell(cellno);
		String value = ce.getStringCellValue();
		return value;
		}
	public void writeDataToExcelSheet(String Sheetname) throws Throwable
	{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\organization.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	//Row rw = sh.getRow(rowno);
	//Cell ce=rw.getCell(cellno);
	//ce.SetCellValue(value);
	FileOutputStream  fio=new FileOutputStream(".\\src\\test\\resources\\organization.xlsx");
	wb.write(fio);
	wb.close();
	
	}
	public int getrowcount(String Sheetname) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\organization.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);	
		int rowcount=sh.getLastRowNum();
		return rowcount;
	}
	public Object[][] readMultipleData(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DataPro.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int lastrow=sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
				
			}
			
		}
		return obj;
	}
	
	}

