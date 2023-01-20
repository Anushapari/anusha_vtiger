package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatenewOrganizationPage extends  WebDriverUtility{
	//declaration
	@FindBy(name="accountname")
	private WebElement lastname;
	@FindBy(name="industry")
	private WebElement industrydropdown;
	@FindBy(name="button")
	private WebElement savebutton;
	@FindBy(name="accounttype")
	private WebElement typedropdown;
	
	//initialization
	public CreatenewOrganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}

	
//utilization
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}
	
	public WebElement getTypedropdown() {
		return typedropdown;
	}


	//bussiness library
	public void Neworganization(String ORGNAME)
	{
		lastname.sendKeys(ORGNAME);
		savebutton.click();
	}
public void Neworgwithindus(String ORGNAME, String INDUSNAME)
{
	
	lastname.sendKeys(ORGNAME);
	select(INDUSNAME, industrydropdown);
	//select(industrydropdown, INDUSNAME);
	//select(industrydropdown, INDUSNAME);
//select(typedropdown, INDUSNAME);
	//industrydropdown.sendKeys(INDUSNAME);
	
	savebutton.click();
}
}
