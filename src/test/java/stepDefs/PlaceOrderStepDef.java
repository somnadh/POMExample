package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderStepDef {
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	public PlaceOrderStepDef(){
		driver=TestBase.getDriver();
		loginPage=new LoginPage(driver);
		listPage=new ProductListPage(driver);
		cartPage=new CartPage(driver);
		checkoutPage=new CheckoutPage(driver);
	}
	
	@Given("User is on Login page")
	public void user_is_on_login_page()
	{
	  TestBase.OpenUrl("https://www.saucedemo.com/");
	}
	
	@When("User enters {string} and {string} credentials")
	public void user_enters_and_credentials(String strUser, String strPwd) 
	{
	   loginPage.loginIntoApp(strUser, strPwd);
	}
	
	@Then("User should be on Home page")
	public void user_should_be_on_home_page() 
	{
	   Assert.assertTrue(listPage.isHeaderDisp());
	}
	
	@When("User add item to cart")
	public void user_add_item_to_cart() 
	{
	  listPage.addItems("Sauce Labs Backpack","Sauce Labs Bike Light");
	 
	}
	
	@Then("Item must be added")
	public void item_must_be_added() 
	{
		 listPage.navigatToCartPage();
		 Assert.assertTrue(cartPage.isItemsAdded());			
	}

	@Given("User is on cart page")
	public void user_is_on_cart_page() {
		listPage.navigatToCartPage();
	}
	
	
	@When("User do checkout")
	public void user_do_checkout() {
	    cartPage.cheoutOrder();
	}
	
	@Then("Should navigat to Checkout page")
	public void should_navigat_to_checkout_page() {
		Assert.assertTrue(checkoutPage.isCheckoutHeaderDisp());
		checkoutPage.Checkout("Somu", "kind", "530101");
	   
	}
		
	@Given("Cart must have items")
	public void cart_must_have_items() {
		Assert.assertTrue(checkoutPage.isItemsOrdered());
		checkoutPage.finish();
	}
	
	@When("User delete an item")
	public void user_delete_an_item() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Should delete item from cart")
	public void should_delete_item_from_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

		
	

}
