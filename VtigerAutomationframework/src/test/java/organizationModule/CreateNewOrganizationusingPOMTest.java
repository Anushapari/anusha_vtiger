package organizationModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreatenewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;

public class CreateNewOrganizationusingPOMTest {

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
		cnop.Neworganization(ORGNAME);
		hp.signoutlink(driver);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
//		driver.findElement(By.name("button")).click();
//		String orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(orgheader.contains(ORGNAME))
//		{
//			System.out.println(orgheader+"pass");
//		}
//		else
//		{
//			System.out.println("fail");
//			
//		}
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Wutil.mousehover(driver, ele);
//		//Actions a=new Actions(driver);
//		//a.moveToElement(ele).perform();
//		driver.findElement(By.linkText("Sign Out")).click();
		}


	}


