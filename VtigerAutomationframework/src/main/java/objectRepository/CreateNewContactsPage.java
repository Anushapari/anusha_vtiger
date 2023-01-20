package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage 
{
	//declaration
	@FindBy(name="lastname")
	private WebElement contactname;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orglookup;
	@FindBy(name="button")
	private WebElement  savebutton;
	
	//initialization
	public CreateNewContactsPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	}
	//utilization
	public WebElement getContactname() {
		return contactname;
	}
	public WebElement getOrglookup() {
		return orglookup;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
public void newcontactname(String LASTNAME)
{
	contactname.sendKeys(LASTNAME);
	savebutton.click();
}
public void contactorglookup(String LASTNAME)
{
	contactname.sendKeys(LASTNAME);
	orglookup.click();
	savebutton.click();
	
}
}
