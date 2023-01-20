package organizationModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreatenewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;
@Listeners(genericUtility.LisnersImplementation.class)
public class CreateOrgwithIndusTESTNGTest extends BaseClass
{
	
@Test (retryAnalyzer = genericUtility.IretryAnalyzerImplementation.class) //(groups="smoke")
public void organdindus() throws Throwable
{
	
	String ORGNAME=Eutil.readDataFromExcelSheet("Organization", 1, 2)+Jutil.getRandomNumber();
	String INDUSNAME=Eutil.readDataFromExcelSheet("Organization", 4, 3);
	//String TYPEDROP=Eutil.readDataFromExcelSheet("Organization", 10, 4);
	
	
	HomePage hp=new HomePage(driver);
	hp.clickonorganizationlink();
	OrganizationPage op=new OrganizationPage(driver);
	op.createorglookupimg();
	Assert.fail();
	CreatenewOrganizationPage cnop=new CreatenewOrganizationPage(driver);
	//cnop.Neworganization(ORGNAME);
	cnop.Neworgwithindus(ORGNAME,INDUSNAME);
	//cnop.Neworgwithindus(ORGNAME,INDUSNAME);
	Thread.sleep(2000);
}
}
