package stepDefinitions;


	

	import java.util.concurrent.TimeUnit;

	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.cucumber.java.en.*;

	import pageObjects.LoginPage;

	public class Steps {

		WebDriver driver;
		LoginPage lp;

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

	}


