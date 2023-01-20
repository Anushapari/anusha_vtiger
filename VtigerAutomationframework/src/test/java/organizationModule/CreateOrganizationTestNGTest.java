package organizationModule;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.CreatenewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationPage;

public class CreateOrganizationTestNGTest extends BaseClass
{

	@Test (groups="smoke")
	public void orgcreate() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.clickonorganizationlink();
		OrganizationPage op=new OrganizationPage(driver);
		op.createorglookupimg();
		//ExcelFileUtility Eutil=new ExcelFileUtility();
		//JavaUtility Jutil=new JavaUtility();
		String ORGNAME=Eutil.readDataFromExcelSheet("Organization", 1, 2)+Jutil.getRandomNumber();
		CreatenewOrganizationPage cnop=new CreatenewOrganizationPage(driver);
		cnop.Neworganization(ORGNAME);
		Thread.sleep(2000);
	}
		@Test(groups="regression")
		public void demo1()
		{
			System.out.println("demo1 test");
		}
		
		@Test(groups="smoke")
		public void demo2()
		{
			System.out.println("demo2 test");
		}
		
	}
	


