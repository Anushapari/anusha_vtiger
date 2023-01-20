package contactModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.CreatenewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactwithOrgUsingPOMTest {

	public static void main(String[] args) throws Throwable 
	{

		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		String ORGNAME = eutil.readDataFromExcelSheet("contacts", 7, 3)+jutil.getRandomNumber();
		String LASTNAME=eutil.readDataFromExcelSheet("contacts",7,2);
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
		driver.get(URL);
		wutil.maximizeWindow(driver);
		wutil.waitForPageLaod(driver);
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME,PASSWORD);
		HomePage hp=new HomePage(driver);
		hp.clickoncontactslink();
		ContactsPage cp=new ContactsPage(driver);
		cp.createcontact();
		CreateNewContactsPage cop=new CreateNewContactsPage(driver);
		cop.contactorglookup(LASTNAME);
		wutil.switchToWindow(driver, "Accounts&action");
		CreatenewOrganizationPage nop=new CreatenewOrganizationPage(driver);
		nop.Neworganization(ORGNAME);
		wutil.switchToWindow(driver, "Contacts&parenttab");
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
//		driver.findElement(By.name("button")).click();
//		Thread.sleep(2000);
//		wutil.elementToBeVisible(driver,driver.findElement(By.linkText("Contacts"))).click();
//		//driver.findElement(By.linkText("Contacts")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
//		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
//		wutil.switchToWindow(driver,"Accounts&action");
//		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
//		driver.findElement(By.name("search")).click();
//		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
//		wutil.switchToWindow(driver,"Contacts&action");
//		driver.findElement(By.name("button")).click();
//		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wutil.mousehover(driver, element);
//		driver.findElement(By.linkText("Sign Out")).click();
//		
		
		

	}

}
