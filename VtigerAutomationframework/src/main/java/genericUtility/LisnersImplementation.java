package genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LisnersImplementation  implements ITestListener
{
ExtentReports report;
ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		//Execution start from here
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"-------TestScript execution started");
		
	}
	public void onTestSuccess(ITestResult result)
	{
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"-------passed");
		Reporter.log(MethodName+"----testScript execution successful");
	}

	public void onTestFailure(ITestResult result) 
	{
		String FS="failedscript"+new JavaUtility().getSystemDateinFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File path=new File("./screenshot/"+FS+".png");
		String filepath=path.getAbsolutePath();
		try {
			FileUtils.copyFile(src, path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL,result.getThrowable());
		Reporter.log("--TestScript Execution failed--");
	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"-- Skipped");
		Reporter.log("--TestScript Execution skipped--");
		
		
	}

	public void onStart(ITestContext context) 
	{
		//Configure the report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("anu extent report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("vtiger report");
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("Base-URL", "http://localhost:8888/");
		report.setSystemInfo("reporter name", "Anusha");
		
	
		
	}

	public void onFinish(ITestContext context) 
	{
		//Consolidated the report
				report.flush();
		
	}
	

}
