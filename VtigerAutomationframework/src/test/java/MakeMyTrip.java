import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Buses']")).click();
		//driver.findElement(By.xpath("//span[.='From']/following-sibling::input[@type='text']")).sendKeys("bangalore");
	//	driver.findElement(By.xpath("//span[.='To']/following-sibling::input[@type='text']")).sendKeys("delhi");

	}

}
