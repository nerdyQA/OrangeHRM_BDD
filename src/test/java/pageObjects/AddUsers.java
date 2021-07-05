package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUsers {
	WebDriver driver;
	public AddUsers(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//b[text()='Admin']")
	WebElement Adminmenu;
	
	@CacheLookup
	@FindBy(id="menu_admin_UserManagement")
	WebElement Usermngmntmenu;
	
	@CacheLookup
	@FindBy(xpath="menu_admin_viewSystemUsers")
	WebElement Userssubmenu;
	
	@CacheLookup
	@FindBy(name="btnAdd")
	WebElement Addbtn;
	
	@CacheLookup
	@FindBy(id="systemUser_employeeName_empName")
	WebElement EmpName;
	
	@CacheLookup
	@FindBy(id="systemUser_userName")
	WebElement Username;
	
	@CacheLookup
	@FindBy(id="systemUser_password")
	WebElement Password;
	
	@CacheLookup
	@FindBy(id="systemUser_confirmPassword")
	WebElement confirmPassword;
	
	@CacheLookup
	@FindBy(id="btnSave")
	WebElement Savebtn;
	
	public void gotoAdmin()
	{
		Adminmenu.click();
	}
	public void gotoUserMngmnt()
	{
		Usermngmntmenu.click();
	}
	public void gotoUsers()
	{
		Userssubmenu.click();
	}
	public void addButton()
	{
		Addbtn.click();
	}
	public void enterEmpName(String empname)
	{
		EmpName.sendKeys(empname);
	}
	public void enterUserName(String username)
	{
		Username.sendKeys(username);
	}
	public void enterPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	public void enterConfirmPassword(String confirmpwd)
	{
		confirmPassword.sendKeys(confirmpwd);
	}
	public void savebutton()
	{
		Savebtn.click();
	}
	
	

}
