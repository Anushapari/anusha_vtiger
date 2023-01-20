package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass 
{
	
public WebDriver driver;
public static WebDriver sdriver;
public 	ExcelFileUtility Eutil = new ExcelFileUtility();
public 	PropertyFileUtility putil=new PropertyFileUtility();
public	WebDriverUtility Wutil=new WebDriverUtility();
public	JavaUtility Jutil=new JavaUtility();
	//@Parameters("BROWSER")
	@BeforeClass//(groups= {"smoke","regression"})
	public void bc() throws Throwable //String BROWSER
	{
		String BROWSER = putil.readDataFromPropertyFile("browser");
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		String URL = putil.readDataFromPropertyFile("url");
		
	 
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
		sdriver=driver;
		Wutil.maximizeWindow(driver);
		Wutil.waitForPageLaod(driver);
		driver.get(URL);
	}
		
		@BeforeMethod//(groups= {"smoke","regression"})
		public void bm() throws Throwable
		{
			String USERNAME = putil.readDataFromPropertyFile("username");
			String PASSWORD = putil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		}
		
		@AfterMethod//(groups= {"smoke","regression"})
		public void am()
		{
		HomePage hp=new HomePage(driver);
		hp.signoutlink(driver);
	}
		@AfterClass
		public void ac()
		{
			driver.close();
		}
	

}
