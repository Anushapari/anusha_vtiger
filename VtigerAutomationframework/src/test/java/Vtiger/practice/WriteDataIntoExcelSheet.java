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

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/organization.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet("organization").getRow(0).getCell(0).setCellValue("Courses");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/organization.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Data is wrriten into sheet");

	}

}

