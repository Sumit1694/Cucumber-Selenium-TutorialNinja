package stepDefinitions;

import io.cucumber.java.en.When;
import pageObjects.DeskTopsPage;
import testBase.TestContextSetup;

public class DeskTopsPageStepDefinitions {

	TestContextSetup testContextSetup;
	DeskTopsPage deskTopsPage;

	public DeskTopsPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.deskTopsPage=testContextSetup.pageObjectManger.getDeskTopsPage();
	}

	@When("User select Mac subcategory option from the left side options displayed")
	public void user_select_mac_subcategory_option_from_the_left_side_options_displayed() {
		testContextSetup.log.info("clicking on Mac subcategory option!");
		deskTopsPage.clickMacSubCategory();
		testContextSetup.log.info("cliced successfully on Mac subcategory option!");
	}

	@When("User click on add to cart button that is availble on any of the Products of the displayed Category or Sub-category pages")
	public void user_click_on_add_to_cart_button_that_is_availble_on_any_of_the_products_of_the_displayed_category_or_sub_category_pages() {
		testContextSetup.log.info("clicking on add to cart button!");
		deskTopsPage.clickAddToCartButton();
		testContextSetup.log.info("clicked successfully on add to cart button!");
	}

	@When("User clicks on Product compare link on Desktops category page")
	public void user_clicks_on_product_compare_link_on_desktops_category_page() {
		testContextSetup.log.info("clicking on product compare link!");
		deskTopsPage.clickProductCompareLink();
		testContextSetup.log.info("clicked successfully on product compare link!");
	}
}
