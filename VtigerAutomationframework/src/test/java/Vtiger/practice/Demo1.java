package Vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[@class='nav-link active']"));
		driver.findElement(By.linkText("Round-trip")).click();
		driver.findElement(By.xpath("(//span[@class='sc-ieecCq gToiRQ fswDownArrow'])[1]"));
		driver.findElement(By.xpath("//div[@aria-label='Wed Feb 15 2023']"));
		driver.findElement(By.linkText("Return"));
		driver.findElement(By.xpath("//div[@aria-label='Wed Apr 05 2023']"));
		
	}

}
