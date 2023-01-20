package contactModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactNGTest extends BaseClass
{
@Test
public void createcont() throws Throwable
	{

	String LASTNAME=Eutil.readDataFromExcelSheet("contacts",7,2);
	
	HomePage hp=new HomePage(driver);
	hp.clickoncontactslink();
	ContactsPage cp=new ContactsPage(driver);
	cp.createcontact();
	CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
	cncp.newcontactname(LASTNAME);
	//hp.signoutlink(driver);
}
	}


