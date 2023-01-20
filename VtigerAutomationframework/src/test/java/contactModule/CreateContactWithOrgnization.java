package contactModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactWithOrgnization {

	public static void main(String[] args) throws Throwable {
		Random rm=new Random();
		int random=rm.nextInt(500);
		FileInputStream fisp= new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj= new Properties();
		pobj.load(fisp);
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\organization.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("organization");
		 Row rw = sh.getRow(7);
		 Cell ce = rw.getCell(2);
		 String contName = ce.getStringCellValue();
		 String orgName= sh.getRow(7).getCell(3).getStringCellValue()+random;
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("lastname")).sendKeys(contName);
			driver.findElement(By.xpath("(//img[@style='cursor:hand;cursor:pointer'])[1]")).click();
			
			Set<String> window=driver.getWindowHandles();
			Iterator<String> it=window.iterator();
			while(it.hasNext())
			{
				String wind=it.next();
				String currentTitle=driver.switchTo().window(wind).getTitle();
				if(currentTitle.contains("Accounts&action"))
				{
					break;
				}}
				driver.findElement(By.id("search_txt")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
				Set<String> win=driver.getWindowHandles();
				for(String win1:win)
				{
					driver.switchTo().window(win1);
					
				}
				
				
				
			}
				}
		


