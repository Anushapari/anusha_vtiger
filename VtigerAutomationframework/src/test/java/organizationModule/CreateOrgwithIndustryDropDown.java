package organizationModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgwithIndustryDropDown {
	

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
		 Row rw = sh.getRow(4);
		 Cell ce = rw.getCell(1);
		 String ORGNAME = ce.getStringCellValue()+random;
		 String industryType= sh.getRow(4).getCell(3).getStringCellValue();
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			WebElement element = driver.findElement(By.name("industry"));
			Select s =new Select(element);
			s.selectByVisibleText(industryType);
			element.click();
			driver.findElement(By.name("button")).click();
			String orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(orgheader.contains(ORGNAME))
			{
				System.out.println(orgheader+"pass");
			}
			else
			{
				System.out.println("fail");
				
			}
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions a=new Actions(driver);
			a.moveToElement(ele).perform();
	driver.findElement(By.linkText("Sign Out")).click();
		


	}

}
