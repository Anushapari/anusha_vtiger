package organizationModule;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
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

public class CreateNewOrganizationusingList {

	
		public static void main(String[] args) throws Throwable {
		
		
			Random ran=new Random();
			int random = ran.nextInt(1000);
			FileInputStream fisp= new FileInputStream(".\\src\\test\\resources\\commonData.properties");
			Properties pobj=new Properties();
			pobj.load(fisp);
			String BROWSER = pobj.getProperty("browser");
			String URL = pobj.getProperty("url");
			String USERNAME = pobj.getProperty("username");
			String PASSWORD = pobj.getProperty("password");
			FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\organization.xlsx");
			 Workbook wb = WorkbookFactory.create(fise);
			 Sheet sh = wb.getSheet("organization");
			 Row rw = sh.getRow(0);
			 Cell ce = rw.getCell(1);
			String ORGNAME = ce.getStringCellValue()+random;
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			//driver.findElement(By.name("accountname")).sendKeys("ORGNAME");
			ArrayList<String> list = new ArrayList<String>();
			list.add("accountname");
			list.add("website");
			list.add("tickersymbol");
			//list.add("phone");
			for(int i=0; i<=2;i++)
			{
				String value=sh.getRow(i).getCell(1).getStringCellValue();
				driver.findElement(By.name(list.get(i))).sendKeys(value);
			}
			
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
