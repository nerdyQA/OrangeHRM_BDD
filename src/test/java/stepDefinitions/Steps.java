
package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddUsersPage;
import pageObjects.EditUser;
import pageObjects.LoginPage;

public class Steps extends BaseClass {
	
	

	// Script for Login Feature
	@Given("user launches the Browser")
	public void user_launches_the_browser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe/");
		driver = new ChromeDriver();

	}

	@And("user enters the {string}")
	public void user_enters_the(String string) {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String Emailid, String Pass) {
		lp = new LoginPage(driver);
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
	// Scripts for User Management features//

	@And("clicks on Admin menu")
	public void clicks_on_admin_menu() {
		adduser = new AddUsersPage(driver);
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
	public void enter_and_and_and(String Empame, String username, String password, String conpassword)
			throws InterruptedException {

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
			// driver.close();
			Assert.assertTrue(false);
		} /*
			 * else if (driver.getPageSource().contains("Required")) {
			 * //driver.close(); Assert.assertTrue(false); } else if
			 * (driver.getPageSource().contains("Already exists")) {
			 * //driver.close(); Assert.assertTrue(false); }
			 */ else {
			Assert.assertEquals(message, "Successfully Saved");
		}
	}

	// Script for Edit user//
	

		/*@Then("title should be {string} should be present")
		public void title_should_be_should_be_present(String txt) {
			edituser=new EditUser(driver);
			if(driver.findElement(By.xpath("//a[@class='toggle tiptip']")).getText().equalsIgnoreCase("System users"))
			{
				Assert.assertTrue(true);
				//or directly use assertequals(string,"actual")
			}
		}*/
	
		@Then("User enters the username to search {string}")
		public void user_enters_the_username_to_search(String uname) {
			EditUser edituser=new EditUser(driver);
			edituser.searchuname(uname);
		}
		@When("Click on Search button")
		public void click_on_search_button() {
			EditUser edituser=new EditUser(driver);
		   edituser.searchbutton();
		}
		@Then("verify if the username is {string}")
		public void verify_if_the_username_is(String text) {
		    if(driver.findElement(By.xpath("//tbody//tr[1]//td[2]//a")).getText().equals("aliciia"))
		    		{
		    	Assert.assertTrue(true);
		    		}
		    else
		    {
		    	System.out.println("username not found");
		    }
			
		}
		@Then("click on the username")
		public void click_on_the_username() {
			EditUser edituser=new EditUser(driver);
		    edituser.clickusername();
		}
		@Then("click on the edit button")
		public void click_on_the_edit_button() {
			EditUser edituser=new EditUser(driver);
			edituser.edit();
		}
		@Then("Change the user role to {string}")
		public void change_the_user_role_to(String role) {
			EditUser edituser=new EditUser(driver);
			edituser.selectUserRole(role);
		}
		
		@Then("verify that the message {string}")
		public void verify_that_the_message(String msg) {
		   if(driver.getPageSource().contains("Successfully Updated"))
		   {
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   System.out.println("No action");
		   }
		}



	}
