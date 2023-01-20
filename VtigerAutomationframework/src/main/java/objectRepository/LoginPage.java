package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.PropertyFileUtility;

public class LoginPage 
{
	//Declaration
@FindBy(name="user_name")
private WebElement username;
@FindBy(name="user_password")
private WebElement password;
@FindBy(id="submitButton")
private WebElement login_button;

//Initialization
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLogin_button() {
	return login_button;
}

//Bussiness library
public void login(String USERNAME,String PASSWORD) throws Throwable
{
	username.sendKeys(USERNAME);
	password.sendKeys(PASSWORD);
login_button.click();
}






























































}
