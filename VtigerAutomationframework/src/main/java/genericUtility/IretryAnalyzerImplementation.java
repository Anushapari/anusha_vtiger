package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IretryAnalyzerImplementation implements IRetryAnalyzer
{
int upperlimit=4;
int count=0;
public boolean retry(ITestResult result) 
{
	if(count<upperlimit)
	{
		count++;
		return true;
	}
	
	return false;
}


}
