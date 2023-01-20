package Vtiger.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get(" https://www.icc-cricket.com/rankings/womens/team-rankings/odi");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
List<WebElement> teams = driver.findElements(By.xpath("//span[@class='u-hide-mobile']"));
List<WebElement> points = driver.findElements(By.xpath("//span[@class='u-hide-mobile']"));
for(int i=0;i<teams.size();i++)
{
	System.out.println(teams.get(i).getText());
}





	}

}
