package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditUser {
	WebDriver driver;
	public EditUser(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@CacheLookup
	@FindBy(id="searchSystemUser_userName")
	WebElement srchusername;
	
	@CacheLookup
	@FindBy(id="searchBtn")
	WebElement searchbutton;
	
	@CacheLookup
	@FindBy(xpath="//tbody//tr[1]//td[2]//a")
	WebElement clickusername;
	
	@FindBy(xpath="//input[@value='Edit']")
	WebElement editbutton;
	
	@FindBy(xpath="//a[@class='toggle tiptip']")
	WebElement Systemslist;
	
	@FindBy(id="systemUser_userType")
	WebElement role;
	public void gettext(){
		Systemslist.getText();
	}
	
    
    public void selectUserRole(String userrole)
    {
    	Select drpdwn=new Select(role);
    	drpdwn.selectByVisibleText(userrole);
    }
    
    public void searchuname(String uname)
    {
    	srchusername.sendKeys(uname);
    }
    
    public void searchbutton()
    {
    	searchbutton.click();
    }
    
    public void clickusername()
    {
    	clickusername.click();
    }
    
    public void edit()
    {
    	editbutton.click();
    }
	
	

}
