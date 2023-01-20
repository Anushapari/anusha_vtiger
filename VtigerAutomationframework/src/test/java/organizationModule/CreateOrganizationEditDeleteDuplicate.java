package organizationModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class CreateOrganizationEditDeleteDuplicate {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");

	}

}
