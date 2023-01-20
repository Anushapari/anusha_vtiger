package Vtiger.practice;

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

public class WriteMultipleDataToExcelsheet {

	public static void main(String[] args) throws Throwable, IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\organization.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("organization");
		
		Row rw=sh.getRow(10);
		Cell ce=rw.createCell(0);
		ce.setCellValue("anu");
		Cell ce1=rw.createCell(1);
		ce1.setCellValue("anu");
		
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/organization.xlsx");
		wb.write(fos);
		wb.close();
		}
		
	}
