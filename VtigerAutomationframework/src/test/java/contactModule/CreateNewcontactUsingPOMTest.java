package contactModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewcontactUsingPOMTest {

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
		//String ORGNAME = eutil.readDataFromExcelSheet("contacts", 7, 3)+jutil.getRandomNumber();
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
		lp.login(USERNAME, PASSWORD);

		HomePage hp=new HomePage(driver);
		hp.clickoncontactslink();
		ContactsPage cp=new ContactsPage(driver);
		cp.createcontact();
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.newcontactname(LASTNAME);
		hp.signoutlink(driver);
	}

}
