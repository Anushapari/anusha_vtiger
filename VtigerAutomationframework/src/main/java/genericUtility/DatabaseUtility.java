package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



public class DatabaseUtility 
{
	Connection con=null;
	public void connectionToDatabase() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.dburl,IpathConstants.dbusername,IpathConstants.dbpassword);
	}
	public String executeQueryAndGetData(String query, int colIndex, String expdata) throws SQLException
	{
		ResultSet result=con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data=result.getString(colIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
				if(flag)
				{
					System.out.println(expdata+"project is created");
					return expdata;
				}
				else
				{
					System.out.println("project not created");
					return "not created";
				}
			
			
		
	}
		
		public void closeDB() throws SQLException
		{
			con.close();
		}
}

