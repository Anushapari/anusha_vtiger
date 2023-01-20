package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {

	public String readDataFromPropertyFile(String key) throws Throwable
	{
		
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
Properties pobj=new Properties();
pobj.load(fis);
String value=pobj.getProperty(key);
return value;
	}

}
