package Vtiger.practice;

import org.testng.annotations.Test;

public class PracticeNg 
{
	@Test(dependsOnMethods = "delete")
	public void create()
	{
		System.out.println("created");
	}

	@Test(priority=-2, dependsOnMethods = "create")
	public void update()
	{
		System.out.println("updated");
	}
	
	@Test(invocationCount = 4)
	public void delete()
	{
		System.out.println("deleted");
	}
}
