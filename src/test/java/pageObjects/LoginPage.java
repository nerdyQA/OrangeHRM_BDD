package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@CacheLookup
	@FindBy(id = "txtUsername")
	WebElement username;

	@CacheLookup
	@FindBy(id = "txtPassword")
	WebElement password;

	@CacheLookup
	@FindBy(id = "btnLogin")
	WebElement loginbtn;

	@CacheLookup
	@FindBy(xpath = "//li//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(id="welcome")
	WebElement welcomelink;

	public void setUsername(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void login() {
		loginbtn.click();
	}

	public void logout() {
		welcomelink.click();//click on Menu first
		logout.click();
	}

}
