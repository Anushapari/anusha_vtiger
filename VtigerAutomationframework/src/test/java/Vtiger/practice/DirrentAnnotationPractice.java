package Vtiger.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DirrentAnnotationPractice 
{
	@BeforeClass
	public void bc()
	{
		System.out.println("launch the browser");

	}
@BeforeMethod
public void bm()
{
	System.out.println("login to application");
}
@Test
public void tm()
{
	System.out.println(" create organization");
}
@AfterMethod
public void am()
{
	System.out.println("logout of application");
	
}
@AfterClass
public void ac()
{
	System.out.println("close the browser");
}
@Test
public void createcon()
{
	System.out.println("contact is created");
}
@Test
public void createopp()
{
	System.out.println("opportunities is created");
}
@BeforeSuite
public void bs()
{
	System.out.println("connect to database");
}
@AfterSuite
public void as()
{
	System.out.println("disconnect to database");
}
@BeforeTest
public void bt()
{
	System.out.println("before test");
}
@AfterTest
public void at()
{
	System.out.println("after test");
}

}
