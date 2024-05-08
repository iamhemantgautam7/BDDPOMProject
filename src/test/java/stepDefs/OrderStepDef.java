package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class OrderStepDef {
	
	WebDriver driver=TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckOutPage checkoutPage;
	
	
	public OrderStepDef() {
		loginPage=new LoginPage(driver);
		listPage =new ProductListPage(driver);	
		cartPage=new CartPage(driver);
		checkoutPage=new CheckOutPage(driver);
		
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
	
	@When("User add item to cart")
	public void user_add_item_to_cart() throws InterruptedException {
		listPage.addToCart();
		
		
	}
	
	@Then("Item must be added")
	public void item_must_be_added() throws InterruptedException {
	//	Thread.sleep(10000);
		listPage.viewCart();
		Assert.assertTrue(cartPage.isItemAdded());
	}
	
	@Given("User is on cart page")
	public void user_is_on_cart_page() {
		
		listPage.viewCart();
		
	}
	

	@When("User do checkout")
	public void user_do_checkout() {
		
		cartPage.checkoutItem();
		
		
	}
	
	
	@Then("Should navigate to checkoout page")
	public void should_navigate_to_checkoout_page() {
		
		checkoutPage.enterDetails("hemant", "Gautam", "208017");
		checkoutPage.continueOrder();
		Assert.assertEquals(checkoutPage.getSuccessMsg(), "Thank you for your order!");
		
	}
	

}
