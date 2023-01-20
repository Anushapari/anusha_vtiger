package Vtiger.practice;

import org.testng.annotations.Test;

public class SampleTESTNGTest_2 
{
	@Test(groups = "smoke")
	public void run()
	{
		System.out.println("sample test 3");
	}
	@Test(groups= {"regression","smoke"})
	public void test()
	{
		System.out.println("sample test 4");
	}

}
