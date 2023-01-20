package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//declaration
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement createcontactloookup;
//initialization
public ContactsPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
//utilization
public WebElement getCreatecontactloookup() {
	return createcontactloookup;
}
//businesslibrary
public void createcontact()
{
	createcontactloookup.click();
}
}
