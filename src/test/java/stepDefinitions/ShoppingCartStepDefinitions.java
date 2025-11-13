package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ShoppingCartPage;
import testBase.TestContextSetup;

public class ShoppingCartStepDefinitions {

	TestContextSetup testContextSetup;
	ShoppingCartPage shoppingCartPage;

	public ShoppingCartStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.shoppingCartPage=testContextSetup.pageObjectManger.getShoppingCartPage();
	}

	@When("User click on checkOut button")
	public void user_click_on_check_out_button() {
		shoppingCartPage.clickCheckOutButton();
	}

	@Then("User must see gift certificate added to shopping cart with valid amount")
	public void user_must_see_gift_certificate_added_to_shopping_cart_with_valid_amount() {
		Assert.assertTrue(shoppingCartPage.verifyGiftCertificateIsAddedToShoppingCart(), "gift certificate is not showing in shopping cart page!");
	}

	@When("User click on checkout button from shopping cart page")
	public void user_click_on_checkout_button_from_shopping_cart_page() {
		shoppingCartPage.clickCheckOutButton();
	}

	@Then("User should be taken to an empty Shopping Cart page instead of Checkout page")
	public void user_should_be_taken_to_an_empty_shopping_cart_page_instead_of_checkout_page() {
		Assert.assertTrue(shoppingCartPage.userIsLandedOnShoppingCartPage(), "Shopping cart page is not loaded!");
	}

	@When("User click contine button on shopping cart page")
	public void user_click_contine_button_on_shopping_cart_page() {
		shoppingCartPage.clickContinueShoppingButton();
	}

	@Then("User can see high quantity is getting accepted")
	public void user_can_see_high_quantity_is_getting_accepted() {
		Assert.assertTrue(shoppingCartPage.isQuantityHighAcceptedInShoppingCart(), "Quantity field is accepting not accepting high values!");
	}

	@When("User click on product name link in shopping cart")
	public void user_click_on_product_name_link_in_shopping_cart() {
		shoppingCartPage.clickProductNamePresentInCart();
	}

	@When("User removes all listed products in shopping cart")
	public void user_removes_all_listed_products_in_shopping_cart() {
		shoppingCartPage.clickRemoveAllButtons();
	}

	@When("User remove product from cart")
	public void user_remove_product_from_cart() {
		shoppingCartPage.clickRemoveButton();
	}

	@When("User update quantity from {int} to {string} from quantity text box")
	public void user_update_quantity_from_to_from_quantity_text_box(Integer int1, String invalidString) {
		shoppingCartPage.UpdateQuantityAsString(invalidString);
	}

	@Then("User can see {string} message")
	public void user_can_see_message(String emptyShoppingCartMessage) {
		Assert.assertTrue(shoppingCartPage.isEmptyShoppingCartPageIsDisplayed(), "empty shopping cart page not displaying correctly");
	}

	@Then("Success message with text - {string} should be displayed in shopping cart page")
	public void success_message_with_text_should_be_displayed_in_shopping_cart_page(String string) {
		Assert.assertTrue(shoppingCartPage.isSuccessModifiedCartMessageDisplayed(), "Success message for modified cart is not displayed!");
	}

	@When("User update quantity from {int} to {int} from quantity text box")
	public void user_update_quantity_from_to_from_quantity_text_box(Integer deafultNumber, Integer UpdatedNumber) {
		shoppingCartPage.updateQuantityInShoppingCartProduct(UpdatedNumber);
	}
	@When("User click on update button")
	public void user_click_on_update_button() {
		shoppingCartPage.clickUpdateQuantity();
	}

	@Then("User can see recalculated price according to quantity updated")
	public void user_can_see_recalculated_price_according_to_quantity_updated() {
		Assert.assertTrue(shoppingCartPage.verifyTotalPriceBasedOnQuantity(), "Grand total price is not proprly updating");
	}

	@Then("User can see correct Grand Total price of products added in shopping cart")
	public void user_can_see_correct_sub_total_price_of_products_added_in_shopping_cart() {
		Assert.assertTrue(shoppingCartPage.verifyGrandTotalPriceforMultipleProductsAdded(), "Total price is not getting updated correctly!");
	}

	@Then("User can see 3x price of MacBook product")
	public void user_can_see_2x_price_of_mac_book_product() {
		Assert.assertTrue(shoppingCartPage.verifyTotalPriceBasedOnQuantity(), "Total price is not getting updated correctly!");
	}

	@Then("User must see proper image visible, product name link, unit price, quantity field, line total.")
	public void user_must_see_proper_image_visible_product_name_link_unit_price_quantity_field_line_total() {
		Assert.assertTrue(shoppingCartPage.verifyProductDetailsDisplayedInShoppingCart(), "Product fields added is not displaying correctly!");
	}
	@Then("User must see currency symbol as well")
	public void user_must_see_currency_symbol_as_well() {
		Assert.assertTrue(shoppingCartPage.verifyCurrencySymbolInPriceColumn("$"), "Currency symbol before price is not displaying correctly!");
	}

	@Then("User can see availability as out of stock then user cannot add product product to cart or error message should be displayed!")
	public void user_can_see_availability_as_out_of_stock_then_user_cannot_add_product_product_to_cart_or_error_message_should_be_displayed() {
		Assert.assertTrue(shoppingCartPage.verifyAddToCartBehaviorForOutOfStockProduct(), "AddToCart behaviour is not correct!");
	}

	@When("User click on add to cart button for MacBook product in product display page")
	public void user_click_on_add_to_cart_button_for_MacBook_product_in_Product_display_page()
	{
		shoppingCartPage.clickAddToCartBtn();
	}

	@Then("User can see only single product is added in cart with quantity three")
	public void user_can_see_only_single_product_is_added_in_cart_with_quantity_three() {
		Assert.assertTrue(shoppingCartPage.verifyOneProductsWithQuantityThreeEach(), "Product is not as per expected changed!");
	}

	@Then("User can see only single product is added in cart with quantity two")
	public void user_can_see_only_single_product_is_added_in_cart_with_quantity_two() {
		Assert.assertTrue(shoppingCartPage.verifyOneProductsWithQuantityTwoEach(), "Product is not as per expected changed!");
	}

	@Then("User can see all three products are listed in shopping cart with quantity one each")
	public void user_can_see_all_three_products_are_listed_in_shopping_cart_with_quantity_one_each() {
		Assert.assertTrue(shoppingCartPage.verifyThreeProductsWithQuantityOneEach(), "Products are not added in shopping cart!");
	}

	@Then("User can see product is added in shopping cart")
	public void user_can_see_product_is_added_in_shopping_cart() {
		Assert.assertTrue(shoppingCartPage.verifyProductIsListedInShoppingCart(), "Product is not added in shopping cart!");
	}

	@Then("User can see correct price for this product")
	public void user_can_see_correct_price_for_this_product() {
		Assert.assertTrue(shoppingCartPage.verifyPriceOfMacBookProductInShoppingCart(), "Price displayed in shopping cart is not correct!s");
	}

	@Then("validate that the products are successfully added to the Shopping Cart page from the Product Compare page.")
	public void validate_that_the_products_are_successfully_added_to_the_shopping_cart_page_from_the_product_compare_page() {
		Assert.assertTrue(shoppingCartPage.isProductAddedToCart("iMac"), "iMac product is added to cart");
	}
	@When("User click on the Product image from the displayed Shopping Cart page")
	public void user_click_on_the_product_image_from_the_displayed_shopping_cart_page() {
		shoppingCartPage.clickShoppingCart();
	}
	@When("User click on checkout button in shopping cart page")
	public void user_click_on_checkout_button_in_shopping_cart_page() {
		shoppingCartPage.clickCheckoutPageButton();
	}
	@When("User click on cart button which is in black color beside the search icon button on the top of the page")
	public void user_click_on_cart_button_which_is_in_black_color_beside_the_search_icon_button_on_the_top_of_the_page() {
		shoppingCartPage.clickCartButton();
	}
	@When("User click on the Product Image in the displayed toggle box")
	public void user_click_on_the_product_image_in_the_displayed_toggle_box() {
		shoppingCartPage.clickImgOfCartToggledBox();
	}
	@When("User click on the Product name link in the displayed toggle box")
	public void user_click_on_the_product_name_link_in_the_displayed_toggle_box() {
		shoppingCartPage.clickProductNameLinkCartToggleBox();
	}
	@Then("User must see original price of product without offer in the displayed product display page")
	public void user_must_see_original_price_of_product_without_offer_in_the_displayed_product_display_page() {

	}


}
