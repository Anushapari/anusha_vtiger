package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//declaration
@FindBy(linkText="Organizations")
private WebElement orgmodule;
@FindBy(linkText="Contacts")
private WebElement contactmodule;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']/..")
private WebElement administratorimg;
@FindBy (linkText="Sign Out")
private WebElement signoutbutton;

//initialization
public HomePage(WebDriver driver)
{
PageFactory.initElements(driver,this);

}
//utilization
public WebElement getOrgmodule() {
	return orgmodule;
}
public WebElement getContactmodule() {
	return contactmodule;
}
public WebElement getAdministratorimg() {
	return administratorimg;
}

public WebElement getSignoutbutton() {
	return signoutbutton;
}

//business libraries

public void clickonorganizationlink()
{
	orgmodule.click();
}
public void clickoncontactslink()
{
	contactmodule.click();
}
public void signoutlink(WebDriver driver)
{
	
	mousehover(driver, administratorimg);
	signoutbutton.click();
}
}


