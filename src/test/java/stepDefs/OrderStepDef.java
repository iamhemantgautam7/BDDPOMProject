package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductListPage;

public class OrderStepDef {
	
	WebDriver driver=TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage listPage;
	
	public OrderStepDef() {
		loginPage=new LoginPage(driver);
		listPage =new ProductListPage(driver);	
	}
	
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		TestBase.openUrl("https://www.saucedemo.com/");		
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String strUser, String strPwd) {
		loginPage.login(strUser, strPwd);


		
	}
	@Then("User should be on Home page")
	public void user_should_be_on_home_page() {
		boolean isValidLogin= listPage.isOnProducts();
		Assert.assertTrue(isValidLogin);
		
	}
	@Given("User is on cart page")
	public void user_is_on_cart_page() {


		
	}
	@When("User do checkout")
	public void user_do_checkout() {


		
	}
	@Then("Should navigate to checkoout page")
	public void should_navigate_to_checkoout_page() {
	  
		
	}
	

}
