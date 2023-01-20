package organizationModule;

import java.io.FileInputStream;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreatenewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;

public class CreateOrgwithIndusUsingPOMTest {

	public static void main(String[] args) throws Throwable {
		ExcelFileUtility Eutil = new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility Wutil=new WebDriverUtility();
		JavaUtility Jutil=new JavaUtility();
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		String ORGNAME=Eutil.readDataFromExcelSheet("Organization", 1, 2)+Jutil.getRandomNumber();
		String INDUSNAME=Eutil.readDataFromExcelSheet("Organization", 4, 3);
		String TYPEDROP=Eutil.readDataFromExcelSheet("Organization", 10, 4);
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		Wutil.maximizeWindow(driver);
		Wutil.waitForPageLaod(driver);
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		HomePage hp=new HomePage(driver);
		hp.clickonorganizationlink();
		OrganizationPage op=new OrganizationPage(driver);
		op.createorglookupimg();
		CreatenewOrganizationPage cnop=new CreatenewOrganizationPage(driver);
		//cnop.Neworganization(ORGNAME);
		//Neworgwithindus noi=new Neworgwithindus(ORGNAME,INDUSNAME);
		cnop.Neworgwithindus(ORGNAME,INDUSNAME);
	}

}
