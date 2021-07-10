package stepDefinitions;

import org.openqa.selenium.WebDriver;

import pageObjects.AddUsersPage;
import pageObjects.EditUser;
import pageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver=null;
	public LoginPage lp;
	public AddUsersPage adduser;
	public EditUser edituser;
}
