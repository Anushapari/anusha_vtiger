package Vtiger.practice;

import org.testng.annotations.Test;

public class SampleTESTNGTest_1 
{
@Test(groups = "regression")
public void run()
{
	System.out.println("sample test 1");
}
@Test(groups= {"smoke","regression"})
public void test()
{
	System.out.println("sample test 2");
}
}
