package genericUtility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int  getRandomNumber()
	{
		Random rm=new Random();
		int random = rm.nextInt();
		return random;
	}
public String getSystemDateAndTime()
{
	Date date = new Date();
	return date.toString();
}

public String formatsystemDateAndTime ()
{
	Date d=new Date();
	String[] dArr=d.toString().split(" ");
	String date=dArr[2];
	String month=dArr[1];
	String year=dArr[5];
	String time=dArr[3].replace(";", "-");
	String dateInFormat=date+"-"+month+"-"+year+"-"+time;
	return dateInFormat;
}
public String getSystemDateinFormat()

{
	SimpleDateFormat dateformat=new SimpleDateFormat("dd-mm-yyyy HH:MM:SS");
	Date systemdate=new Date();
	String getDateAndTime=dateformat.format(systemdate);
	System.out.println(getDateAndTime);
	return getDateAndTime.replaceAll(":", "-");
	
	
}
}
