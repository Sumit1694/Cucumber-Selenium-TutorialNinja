package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchPage;
import testBase.TestContextSetup;

public class SearchPageStepDefinitions {

	TestContextSetup testContextSetup;
	SearchPage searchPage;

	public SearchPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.searchPage=testContextSetup.pageObjectManger.getSearchPage();
	}



	@When("User add five products in product comparison and verify success message")
	public void user_add_five_products_in_product_comparison_and_verify_success_message() {
		searchPage.verifyCompareThisProductForFiveProducts();
	}

	@When("User add four products to product comparison page and verify success message")
	public void user_add_four_products_to_product_comparison_page_and_verify_success_message() {
	    searchPage.verifyCompareThisProductForFourProducts();
	}

	@When("User add three products to product comparison and verify success messages")
	public void user_add_three_products_to_product_comparison_and_verify_success_messages() {
		searchPage.verifyCompareThisProductForMultipleProducts();
	}

	@When("user add two products in product comparison and see success message for added successfully")
	public void user_add_two_products_in_product_comparison_and_see_success_message_for_added_successfully() {
		searchPage.verifyCompareThisProductForIMacAndIPhone();
	}

	@When("User click on shopping cart header link after loggedIn")
	public void user_click_on_shopping_cart_header_link_after_logged_in() {
	    Assert.assertTrue(searchPage.clickOnShoppingCartHeader(), "Shopping cart header link is not clickable!");
	}

	@When("User search for three product iPhone, MacBook, samsung galaxy and adding to cart and verifying success message")
	public void user_search_for_three_product_i_phone_mac_book_samsung_galaxy_and_adding_to_cart_and_verifying_success_message() {
		Assert.assertTrue(searchPage.searchAndAddMultipleProductsToCart(), "multiple products are not getting added!");
	}

	@When("User click on add to wishList button from search result")
	public void user_click_on_add_to_wish_list_button_from_search_result() {
	   Assert.assertTrue(searchPage.clickAddToWishListButton(), "add to wishlist button is not clickable at this moment!");
	}

	@When("User clicks on HP LP3065 product on the search page")
	public void user_clicks_on_hp_lp3065_product_on_the_search_page() {
        searchPage.clickHPLP3065NameLink();
	}

	@When("User clicks on HP LP3065 product from search page")
	public void user_clicks_on_hp_lp3065_product_from_search_page() {
	    searchPage.clickHPLPSearchedProduct();
	}

	@When("User click on shopping cart link in present in success message in searchPage")
	public void user_click_on_shopping_cart_link_in_present_in_success_message_in_search_page() throws Exception {
	   searchPage.clickShoppingCartInMessage();
	}

	@When("User click on add to cart button for MacBook product in search page")
	public void user_click_on_add_to_cart_button_for_mac_book_product_in_search_page() {
		searchPage.clickAddToCartMacBook();
	}

	@When("User click on add to cart button for iPhone product in search page")
	public void user_click_on_add_to_cart_button_for_i_phone_product_in_search_page() {
		searchPage.clickAddToCartButtonforiPhone();
	}

	@When("User click on add to cart button for samsung galaxy product in search page")
	public void user_click_on_add_to_cart_button_for_samsung_galaxy_product_in_search_page() {
		searchPage.clickAddToCartForSamsungProduct();
	}

	@When("User click on product name displayed in search result")
	public void user_click_on_product_name_displayed_in_search_result() {
		searchPage.clickMacBookProductName();
	}
	@Then("User must see product title and price of the searched product")
	public void user_must_see_product_title_and_price_of_the_searched_product() {
	    Assert.assertTrue(searchPage.isMacBookProductTitleAndPriceDisplayedInSearch(), "MacBook product Title and price is not displaying in search result");
	}

	@When("User click on shopping cart link in displayed success message in searchPage")
	public void user_click_on_shopping_cart_link_in_displayed_success_message_in_search_page() {
		searchPage.clickShoppingCartLinkAlertMsg();
	}

	@When("User click on add to cart button for searched product")
	public void user_click_on_add_to_cart_button_for_searched_product() {
	    searchPage.clickAddToCartButtonforiPhone();
	}

	@When("User click on wishList link present in success message on search page")
	public void user_click_on_wish_list_link_present_in_success_message_on_search_page() {
		searchPage.clickWishListLinkInSuccessMsgBeforeLogin();
	}

	@Then("User click on wishList link from success message on search page")
	public void User_click_on_wishlist_link_from_success_msg()
	{
		searchPage.clickWishListLinksuccessMesg();
	}

	@When("User click on add to wishList button from product listing page")
	public void User_click_on_add_to_wishList_button_from_product_listing_page()
	{
		searchPage.clickWishListBtn();
	}

	@Then("User is able to see breadcrumb option of searchPage")
	public void user_is_able_to_see_breadcrumb_option_of_search_page() {
		Assert.assertTrue(searchPage.isSerachPageBreadCrumbDisplayed(), "Search page breadCrumb is not displaying!");
	}
	@Then("User clicks on compare this product option in search result page")
	public void user_clicks_on_compare_this_product_option_in_search_result_page() {
	   searchPage.clickCompareThisProductButton();
	}
	@When("Click on product comparision link from the displayed success message in search page")
	public void click_on_product_comparision_link_from_the_displayed_success_message_in_search_page() {
	    searchPage.clickProductComparisonLink();
	}
	@Then("User clear search field existing text")
	public void user_clear_search_field_existing_text() {
	    searchPage.clearSearchBarField();
	}
	@When("User click on the Product Comparison link in the displayed success message on search page")
	public void user_click_on_the_product_comparison_link_in_the_displayed_success_message_on_search_page() {
	    searchPage.clickProductComparisonLink();
	}

	@Then("Breakcrumb option should be working correctly")
	public void breakcrumb_option_should_be_working_correctly() {
		searchPage.verifySearchBreadCrumbFunctionality();
	}

	@When("User should be able to perform Search operation and select several options in the Search page using the Keyboard keys Tab and Enter")
	public void user_should_be_able_to_perform_search_operation_and_select_several_options_in_the_search_page_using_the_keyboard_keys_tab_and_enter() throws InterruptedException {
		searchPage.performSearchUsingTabsAndEnter();
	}

	@Then("User should be navigated to search page")
	public void user_should_be_navigated_to_search_page() {
		Assert.assertTrue(searchPage.isHeadingOfSearchPageIsDisplayed(), "Search page is not displayed!");
	}

	@Then("Proper Page Heading, Page URL and Page Title should be displayed for Search page")
	public void proper_page_heading_page_url_and_page_title_should_be_displayed_for_search_page() {
		Assert.assertTrue(searchPage.isHeadingOfSearchPageIsDisplayed(),"Not proper heading is displayed!");
		Assert.assertEquals(searchPage.getCurrentUrlOfSearchPage(), "https://tutorialsninja.com/demo/index.php?route=product/search&search=iMac", "SearchPage url is not matching!");
		String actualTitle = searchPage.getSearchPageTitle();
		Assert.assertTrue(actualTitle.contains("Search"), "User is not on the Search page");
	}

	@Then("User should get search result {string} with respective search")
	public void user_should_get_search_result_with_respective_search(String searchedText) {
		Assert.assertEquals(searchPage.getProductSearchResult(), searchedText,"Searched item is not matching with search entered text field!");
	}

	@Then("User must see there is no product that matches the search criteria should be displayed in the Search Results page")
	public void user_must_see_there_is_no_product_that_matches_the_search_criteria_should_be_displayed_in_the_search_results_page() {
		Assert.assertTrue(searchPage.isSearchElementNotFoundMessageDisplayed(),"Search Element not found message is not displayed!");
	}

	@Then("User must see More than one products should be displayed in the search results page")
	public void user_must_see_more_than_one_products_should_be_displayed_in_the_search_results_page() {
		Assert.assertTrue(searchPage.areMultipleProductDisplayed(),"Multiple products are not displayed!");
	}

	@Then("User must see proper placeholder for search textBox field")
	public void user_must_see_proper_placeholder_for_search_text_box_field() {
		Assert.assertEquals(searchPage.getPlaceholderValueOfSearchTextField(), "Search","Search field placeholder is incorrect!");
	}
	@Then("User must see proper placeholder for search criteria textBox field")
	public void user_must_see_proper_placeholder_for_search_criteria_text_box_field() {
		Assert.assertEquals(searchPage.getPlaceholderValueOfSearchCriteriaTextBoxField(), "Keywords","Search criteria field placeholder is incorrect!");
	}
	@When("User enters any existing product name {string} into the search criteria text box field")
	public void user_enters_any_existing_product_name_into_the_search_criteria_text_box_field(String existingItem) {
		searchPage.enterTextIntoSearchCriteriaTextBoxField(existingItem);
	}
	@When("User click on search button")
	public void user_click_on_search_button() {
		searchPage.clickSearchCriteriaSearchBtn();
	}
	@When("User enters any text {string} from the Product Description into the Search Criteria text box field")
	public void user_enters_any_text_from_the_product_description_into_the_search_criteria_text_box_field(String textFromProductDescription) {
		searchPage.enterTextIntoSearchCriteriaTextBoxField(textFromProductDescription);
	}
	@When("User clicks on Search in product descriptions checkbox option")
	public void user_clicks_on_search_in_product_descriptions_checkbox_option() {
		searchPage.selectSearchInProductDescCheckbox();
	}
	@When("User selects the correct category {string} of the given Product name into Category dropdown field")
	public void user_selects_the_correct_category_of_the_given_product_name_into_category_dropdown_field(String correctCategory) {
		testContextSetup.waitUtils.waitForPageLoad(5);
		searchPage.SelectCategoryFromDropDown(correctCategory);
	}
	@When("User selects wrong category {string} from category dropdown field")
	public void user_selects_wrong_category_from_category_dropdown_field(String WrongCategory) {
		testContextSetup.waitUtils.waitForPageLoad(5);
		searchPage.SelectCategoryFromDropDown(WrongCategory);
	}
	@When("User selects the parent category of {string} the given Product Name into category dropdown field")
	public void user_selects_the_parent_category_of_the_given_product_name_into_category_dropdown_field(String parentCategory) {
		testContextSetup.waitUtils.waitForPageLoad(5);
		searchPage.selectParentCategoryForProduct(parentCategory);
	}
	@When("User select search in subcategories checkbox field")
	public void user_select_search_in_subcategories_checkbox_field() {
		testContextSetup.waitUtils.waitForPageLoad(5);
		searchPage.clickSearchInSubCategories();
	}
	@When("User select List option on search page")
	public void user_select_list_option_on_search_page() {
		testContextSetup.waitUtils.waitForPageLoad(5);
		searchPage.selectListView();
	}
	@Then("User should see single product in the List view without any problems and all the options Add to Cart, Wish List and Compare Product should be displayed")
	public void user_should_see_single_product_in_the_list_view_without_any_problems_and_all_the_options_add_to_cart_wish_list_and_compare_product_should_be_displayed() {
		testContextSetup.waitUtils.waitForPageLoad(5);
		Assert.assertTrue(searchPage.isSingleProductDisplayed(), "More than one product is displayed!");
		Assert.assertTrue(searchPage.areAllProductOptionsDisplayed(),"Not all products have Add to Cart, Wish List and Compare buttons!");
	}
	@When("User click on image of the product")
	public void user_click_on_image_of_the_product() {
		searchPage.clickOnSearchProductImage();
	}

	@When("User click on name of the product")
	public void user_click_on_name_of_the_product() {
		searchPage.clickOnSearchedProductName();
	}
	@When("User select Grid option on search page")
	public void user_select_grid_option_on_search_page() {

		testContextSetup.waitUtils.waitForPageLoad(10);
		searchPage.selectGridView();
	}
	@Then("User must clear search fields")
	public void user_must_clear_search_fields() {
		testContextSetup.waitUtils.waitForPageLoad(5);
		searchPage.clearSearchCriteriaTextBoxField();
		searchPage.clearSearchTextBoxField();
	}
	@Then("User should see single product in the Grid view without any problems and all the options Add to Cart, Wish List and Compare Product should be displayed")
	public void user_should_see_single_product_in_the_grid_view_without_any_problems_and_all_the_options_add_to_cart_wish_list_and_compare_product_should_be_displayed() {
		testContextSetup.waitUtils.waitForPageLoad(5);
		Assert.assertTrue(searchPage.isSingleProductDisplayed(), "More than one product displayed!");
		Assert.assertTrue(searchPage.areAllProductOptionsDisplayed(), "Not all products have Add to cart, Wish list, Compare buttons!");
	}
	@Then("User should see multiple products in the List view without any problems and all the options Add to Cart, Wish List and Compare Product should be displayed")
	public void user_should_see_multiple_products_in_the_list_view_without_any_problems_and_all_the_options_add_to_cart_wish_list_and_compare_product_should_be_displayed() {
		testContextSetup.waitUtils.waitForPageLoad(5);
		Assert.assertTrue(searchPage.areMultipleProductsDisplayed(), "No products or a single product is displayed!");
		Assert.assertTrue(searchPage.areAllProductsOptionsDisplayed(), "Otions are missing on search result listed products!");
	}
	@When("User clicks on every image of the product available in search result and verify user is navigated to same product page")
	public void user_clicks_on_every_image_of_the_product_available_in_search_result() {
		testContextSetup.waitUtils.waitForPageLoad(5);
		searchPage.verifyEachProductNavigation();
	}
	@When("User clicks on every product name of the product available in search result and verify user is navigated to same product page")
	public void user_clicks_on_every_product_name_of_the_product_available_in_search_result() {
		testContextSetup.waitUtils.waitForPageLoad(5);
		searchPage.verifyEachProductNameNavigation();
	}
	@Then("User should see multiple products in the Grid view without any problems and all the options Add to Cart, Wish List and Compare Product should be displayed")
	public void user_should_see_multiple_products_in_the_grid_view_without_any_problems_and_all_the_options_add_to_cart_wish_list_and_compare_product_should_be_displayed() throws IOException, InterruptedException {
		testContextSetup.testBase.WebDriverManager().navigate().refresh();
		testContextSetup.testBase.WebDriverManager().manage().deleteAllCookies();
		testContextSetup.testBase.WebDriverManager().navigate().refresh();
		testContextSetup.waitUtils.waitForPageLoad(5);
		Assert.assertTrue(searchPage.areMultipleProductsDisplayed(), "No products or a single product is displayed!");
		Assert.assertTrue(searchPage.areAllProductsOptionsDisplayed(), "Otions are missing on search result listed products!");
	}

	@Then("User selects several options from the Sort By dropdown and products are sorted according to option selected in the sort by dropdown")
	public void user_selects_several_options_from_the_sort_by_dropdown_and_products_are_sorted_according_to_option_selected_in_the_sort_by_dropdown() {
		searchPage.verifySortingForAllOptions();
	}
	@Then("User selects the number of products to be displayed from the show dropdown and products listed on page does not exceeds the selected number from dropdown")
	public void user_selects_the_number_of_products_to_be_displayed_from_the_show_dropdown_and_products_listed_on_page_does_not_exceeds_the_selected_number_from_dropdown() {
		searchPage.verifyShowDropDownFunctionality();
	}
	@Then("Search functionality should work in all the supported browser")
	public void search_functionality_should_work_in_all_the_supported_browser() {
		Assert.assertTrue(searchPage.isSerachPageBreadCrumbDisplayed(),"User is not on search page!");
	}
	@When("User must click on displayed product in search result")
	public void user_must_click_on_displayed_product_in_search_result() {
		searchPage.clickProductDisplayedOnSearchResult();
	}
	@When("User selects List view option")
	public void user_selects_list_view_option() {
		searchPage.selectListViewOption();
	}
	@When("User hover the mouse cursor on Compare this Product option from the displayed Product Display Page on search results")
	public void user_hover_the_mouse_cursor_on_compare_this_product_option_from_the_displayed_product_display_page_on_search_results() {
		testContextSetup.waitUtils.waitForPageLoad(10);
		searchPage.mouseHoverOnCompareThisProduct();
	}

	@Then("Tool tip with the text - {string} should be displayed on the search page")
	public void tool_tip_with_the_text_should_be_displayed_on_the_search_page(String compareProductMouseHoverText) {
		Assert.assertEquals(searchPage.compareProductMouseHoverText(), compareProductMouseHoverText, "Compare product mouse hover text is not matched!");
	}

	@When("User selects Compare this Product option on result page")
	public void user_selects_compare_this_product_option_on_result_page() {
		searchPage.clickCompareThisProductOption();
	}
	@When("User selects Grid view option")
	public void user_selects_grid_view_option() {
	    searchPage.selectGridViewOption();
	}
	@When("User clicks on Compare this Product option on searchPage")
	public void user_clicks_on_compare_this_product_option_on_search_page() {
	    searchPage.clickProductCompareLinkOnSearchPage();
	}
}
