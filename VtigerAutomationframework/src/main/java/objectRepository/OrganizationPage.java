package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createorglookup;
	@FindBy(name="search_text")
	private WebElement searchbox;
	
	//initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getCreateorglookup() {
		return createorglookup;
	}
	//bussiness library
	public void createorglookupimg() {
		createorglookup.click();
	}
}
