package Vtiger.practice;

import org.testng.annotations.Test;

public class SampleTETNGTest_4 
{
	@Test(groups={"smoke"})
	public void run()
	{
		System.out.println("sample test 7");
	}
	@Test(groups= {"regression"})
	public void test()
	{
		System.out.println("sample test 8");
	}

}
