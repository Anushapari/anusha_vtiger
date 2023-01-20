package Vtiger.practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;

import org.apache.hc.core5.util.Asserts;
import org.testng.annotations.Test;

public class AssertTest 
{
@Test
public void sample1()
{
	System.out.println("test for sample1");
	System.out.println("test for sample2");
	
	System.out.println("test for sample3");
	System.out.println("test for sample4");
}

@Test
public void sample2()
{

	System.out.println("test for sample5");
	System.out.println("test for sample6");
	String a="hfhg";
	assertNull(a);
	System.out.println("test for sample7");
	System.out.println("test for sample8");
	
}

@Test
public void sample3()
{

	System.out.println("test for sample9");
	System.out.println("test for sample10");
	assertNotEquals('a', 'a');
	System.out.println("test for sample11");
	System.out.println("test for sample12");
}
}
