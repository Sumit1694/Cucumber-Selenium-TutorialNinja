package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OrderSuccessPage;
import testBase.TestContextSetup;

public class OrderSuccessPageStepDefinitions {

	TestContextSetup testContextSetup;
	OrderSuccessPage orderSuccessPage;

	public OrderSuccessPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.orderSuccessPage = testContextSetup.pageObjectManger.getOrderSuccessPage();
	}

	@Then("User click on store owner link on order success page")
	public void user_click_on_store_owner_link_on_order_success_page() {
		testContextSetup.log.info("clicking on store owner link...");
	    Assert.assertTrue(orderSuccessPage.clickStoreOwnerLink(), "Store owner link is not clickable!");
	    testContextSetup.log.info("clicked on store owner link...");
	}

}
