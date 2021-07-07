package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.AddUsersPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass {

	// Script for Login Feature
	@Given("user launches the Browser")
	public void user_launches_the_browser() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe/");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);

	}

	@And("user enters the {string}")
	public void user_enters_the(String string) {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String Emailid, String Pass) {
		lp.setUsername(Emailid);
		lp.setPassword(Pass);

	}

	@And("click on the Login button")
	public void click_on_the_login_button() {
		lp.login();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Invalid credentials")) {
			driver.close();
			Assert.assertTrue(false);
			
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@And("click on logout button")
	public void click_on_logout_button() {
		lp.logout();
	}

	@And("close the browser")
	public void close_the_browser() {
		driver.quit();
	}
	// Scripts for User Management feature//

	
	@And("clicks on Admin menu")
	public void clicks_on_admin_menu() {
		adduser=new AddUsersPage(driver);
		adduser.gotoAdmin();
	}

	@And("then select User management")
	public void then_select_user_management() {
		adduser.gotoUserMngmnt();
	}

	@When("user clicked on the Users submenu")
	public void user_clicked_on_the_users_submenu() {
		adduser.gotoUsers();
	}

	@And("click on Add new user")
	public void click_on_add_new_user() {
		adduser.addButton();
	}

	@And("enter {string} and {string} and {string} and {string}")
	public void enter_and_and_and(String Empame, String username, String password, String conpassword) throws InterruptedException {
		
		adduser.enterEmpName(Empame);
		adduser.enterUserName(username);
		Thread.sleep(3000);
		adduser.enterPassword(password);
		Thread.sleep(3000);
		adduser.enterConfirmPassword(conpassword);
	}

	@And("click on Save Button")
	public void click_on_save_button() throws InterruptedException {
		adduser.savebutton();
		Thread.sleep(3000);
	}

	@Then("verify that the message {string} is displayed.")
	public void verify_that_the_message_is_displayed(String message) {
		if (driver.getPageSource().contains("Already exists")) {
			//driver.close();
			Assert.assertTrue(false);
		} /*else if (driver.getPageSource().contains("Required")) {
			//driver.close();
			Assert.assertTrue(false);
		} else if (driver.getPageSource().contains("Already exists")) {
			//driver.close();
			Assert.assertTrue(false);
		}*/ else {
			Assert.assertEquals(message, "Successfully Saved");
		}
	}

	// Script for Edit user
	@Given("User is on the System User Screen")
	public void user_is_on_the_system_user_screen() {

	}

	@When("User enters the username to search")
	public void user_enters_the_username_to_search() {

	}

	@When("Click on Search button")
	public void click_on_search_button() {

	}

	@Then("verify if the username is {string}")
	public void verify_if_the_username_is(String string) {

	}

	@Then("click on the username")
	public void click_on_the_username() {

	}

	@Then("click on the edit button")
	public void click_on_the_edit_button() {

	}

	@Then("Change the user role to {string}")
	public void change_the_user_role_to(String string) {

	}

	@Then("verify that the message {string}")
	public void verify_that_the_message(String string) {

	}

}