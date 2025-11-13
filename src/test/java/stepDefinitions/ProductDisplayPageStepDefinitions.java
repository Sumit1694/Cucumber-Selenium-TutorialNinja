package stepDefinitions;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductDisplayPage;
import testBase.TestContextSetup;

public class ProductDisplayPageStepDefinitions {

	TestContextSetup testContextSetup;
	ProductDisplayPage productDisplayPage;

	public ProductDisplayPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.productDisplayPage=testContextSetup.pageObjectManger.getProductDisplayPage();
	}

	@Then("User search product and verify by adding quantity to zero, negative or null then warning message should be displayed")
	public void user_search_product_and_verify_by_adding_quantity_to_zero_negative_or_null_then_warning_message_should_be_displayed() {
		Assert.assertTrue(productDisplayPage.verifyWarningMsgByAddingQuantityToNegativeNullOrZero(), "warning message is not displaying for negative values!");
	}

	@Then("User should be navigated to product details page")
	public void user_should_be_navigated_to_product_details_page() {
		Assert.assertTrue(productDisplayPage.verifyProductDisplayPageBreadcrumbDisplayed(), "product display page breadcrumb is not displayed!");
	}

	@When("User click on add to cart button for HP LP3065 from product display page")
	public void user_click_on_add_to_cart_button_for_hp_lp3065_from_product_display_page() {
		productDisplayPage.clickAddToCartButtonForHP();
	}

	@When("User click on cart button present in black colour beside the search icon")
	public void user_click_on_cart_button_present_in_black_colour_beside_the_search_icon() {
		productDisplayPage.clickBlackCartButton();
	}
	@When("User Click on checkout option in the displayed Cart block")
	public void user_click_on_checkout_option_in_the_displayed_cart_block() {
		productDisplayPage.clickCheckOutBtnInBlackCart();
	}

	@When("User click on add to cart button for HP LP3065 searched product")
	public void user_click_on_add_to_cart_button_for_hp_lp3065_searched_product() {
		productDisplayPage.clickAddToCartButtonHPLP();
	}

	@Then("User click on continue button present on PC page")
	public void user_click_on_continue_button_present_on_pc_page() {
		productDisplayPage.clickContinuePage();
	}

	@Then("User is landed on PC page which has zero products")
	public void user_is_landed_on_pc_page_which_has_zero_products() {
		Assert.assertTrue(productDisplayPage.isUserLandedOnPCPage(), "User is not on PC product page!");
	}

	@When("User increase quantity for MacBook to one thousand")
	public void user_increase_quantity_for_mac_book_to_one_thousand() {
		productDisplayPage.addQuantityForMacBook(1000);
	}

	@Then("Verify navigation to the product detail page and product name matches.")
	public void verify_navigation_to_the_product_detail_page_and_product_name_matches() {
		Assert.assertTrue(productDisplayPage.isIMacBreadCrumbIsDisplayed(), "User is not landed on iMac product page!");
	}

	@When("User increased quantity of MacBook to {string} in product display page")
	public void user_increased_quantity_of_mac_book_to_in_product_display_page(String qty) {
		productDisplayPage.setProductquantity(3);
	}

	@Then("User click on add to cart button for searched product product display page")
	public void user_click_on_add_to_cart_button_for_searched_product_product_display_page() {
		productDisplayPage.clickAddToCartMacBook();
	}

	@When("User click on wishList link from success message")
	public void user_click_on_wish_list_link_from_success_message() {
		productDisplayPage.clickWishListLinksuccessMesg();
	}

	@When("User click on Add to cart button on one of the product displayed in search results")
	public void user_click_on_add_to_cart_button_on_one_of_the_product_displayed_in_search_results() {
		productDisplayPage.clickAddToCartButtonAppleProduct();
	}
	@When("User must click on any product displayed in related search section")
	public void user_must_click_on_any_product_displayed_in_related_search_section() {
		productDisplayPage.clickRelatedSearchProduct();
	}
	@When("User click on add to cart button for that product")
	public void user_click_on_add_to_cart_button_for_that_product() {
		productDisplayPage.clickAddToCartButtonForIPhone();
	}
	@When("User click on shopping cart link in displayed success message")
	public void user_click_on_shopping_cart_link_in_displayed_success_message() {
		productDisplayPage.clickShoppingCartLink();
	}

	@When("User click on add to wishList button")
	public void user_click_on_add_to_wish_list_button() {
		productDisplayPage.clickAddToWishListbtn();
	}
	@When("User click on View Cart option in the displayed box")
	public void user_click_on_view_cart_option_in_the_displayed_box() {
		productDisplayPage.clickViewCartOption();
	}
	@When("User click on wishList header option")
	public void user_click_on_wish_list_header_option() {
		productDisplayPage.clickWishListHeaderOption();
	}

	@When("User will update the quantity as ten")
	public void user_will_update_the_quantity_as_ten() {
		productDisplayPage.UpdateQuantity(10);
	}
	@When("User must see correct the Page Title, Page Heading and Page URL of the displayed Product Display page")
	public void user_must_see_correct_the_page_title_page_heading_and_page_url_of_the_displayed_product_display_page() {
		Assert.assertTrue(productDisplayPage.isProductPageHeadingCorrect("iMac"), "Product Page heading is incorrect!");
		Assert.assertTrue(productDisplayPage.verifyTitleOfProductDisplayPage(), "Product Page title is incorrect!");
		Assert.assertTrue(productDisplayPage.verifyUrlOfProductDisplayPage(), "Product Page url is incorrect!");
	}
	@When("click on Add to cart button")
	public void click_on_add_to_cart_button() {
		productDisplayPage.clickAddToCartButtonOnProductDisplay();
	}

	@Then("Success message with text - {string} should be displayed")
	public void success_message_with_text_should_be_displayed(String expectedMsg) {
		testContextSetup.log.info("Verifying success message: " + expectedMsg);

		String actualMsg = productDisplayPage.getSuccessMessageText();

		//wait briefly to ensure DOM update
		testContextSetup.waitUtils.waitForPageLoad(2);

		Assert.assertTrue(actualMsg.contains(expectedMsg), "Message Verification failed! expected [" + expectedMsg + "] but found [" + actualMsg + "]");
	}

	@When("User click on the shopping cart! link in the displayed success message")
	public void user_click_on_the_shopping_cart_link_in_the_displayed_success_message() {
		productDisplayPage.clickShoppingCartLink();
	}
	@Then("User must see product successfully displayed in the shopping cart page")
	public void user_must_see_product_successfully_displayed_in_the_shopping_cart_page() {
		Assert.assertTrue(productDisplayPage.isUserLandedOnProductDisplayPage(), "Shpping cart page is not Displayed!");
	}
	@Then("User should see 10X price of product under cart bar")
	public void user_should_see_10x_price_of_product_under_cart_bar() {
		Assert.assertTrue(productDisplayPage.isPriceOfTenProductCorrect(), "Price of 10 products is displaying incorrect!");
	}

	@Then("User must see original price of product without offer as strike off in the displayed product display page")
	public void user_must_see_original_price_of_product_without_offer_in_the_displayed_product_display_page() {
		Assert.assertTrue(productDisplayPage.isOriginalPriceDisplayedAsStrikeOff(), "Original price striked off is not displaying on product display page!");
	}
	@When("User click on the Product Name link displayed under the Product Name section of the displayed Wish List page")
	public void user_click_on_the_product_name_link_displayed_under_the_product_name_section_of_the_displayed_wish_list_page() {
		productDisplayPage.clickProductNameLink();
	}
	@When("User must see correct reward points are displyed in displayed product display page")
	public void user_must_see_correct_reward_points_in_displayed_product_display_page() {
		Assert.assertTrue(productDisplayPage.isRewardsPointsDisplayedCorrect(), "Reward points are not displaying correctly!");
	}
	@When("User click on product name link from the displayed success page")
	public void user_click_on_product_name_link_from_the_displayed_success_Message_page() {
		productDisplayPage.clickProductNameLinkUnderMessage();
	}

	@When("User click on Shopping cart link from the displayed success page")
	public void user_click_on_shopping_cart_link_from_the_displayed_success_page() {
		productDisplayPage.clickShoppingCartLink();
	}
	@When("User click on the Image icon displayed under the Image section of the displayed Wish List page")
	public void user_click_on_the_image_icon_displayed_under_the_image_section_of_the_displayed_wish_list_page() {
		productDisplayPage.clickImgIcon();
	}
	@Then("User should be taken the Product Display page of the Product that is displayed in the Wish List page")
	public void user_should_be_taken_the_product_display_page_of_the_product_that_is_displayed_in_the_wish_list_page() {
		Assert.assertTrue(productDisplayPage.isProductDisplayed(), "Product display page is not properly updated!");
	}

	@Then("User must see all the fields in the Reviews tab are mandatory.")
	public void user_must_see_all_the_fields_in_the_reviews_tab_are_mandatory() {
		Assert.assertTrue(productDisplayPage.areAllReviewFieldsMandatory(), "All fields are not mandatory!");
	}

	@Then("User click on write a review link under add to cart button of the product display page then review tab should come to focus")
	public void user_click_on_write_a_review_link_under_add_to_cart_button_of_the_product_display_page_then_review_tab_should_come_to_focus() {
		Assert.assertTrue(productDisplayPage.clickWriteAReviewAndVerifyTabActive());
	}
	@When("User click on continue button without providing Name, Your Review and Ratings and click on continue button")
	public void user_click_on_continue_button_without_providing_name_your_review_and_ratings_and_click_on_continue_button() {
		productDisplayPage.clickContinueReviewButton();
	}
	@When("User provide Name and Ratings")
	public void user_provide_name_and_ratings() {
		productDisplayPage.enterNameInReview("Tom alter");
		productDisplayPage.selectRatingRadioButton();
		productDisplayPage.clickContinueReviewButton();
	}
	@When("User click on add to cart button")
	public void user_click_on_add_to_cart_button_after_Login() {
		productDisplayPage.clickAddToCartButton();
	}
	@When("User click on Product Name link from the displayed success page")
	public void user_click_on_product_name_link_from_the_displayed_success_page() {
		productDisplayPage.clickProductNameLinkUnderSuccessMsg();
	}
	@Then("User should be taken to the Product Display page of the Product")
	public void user_should_be_taken_to_the_product_display_page_of_the_product() {
		productDisplayPage.isUserLandedOnProductDisplayPage();
	}

	@Then("Proper warning message with the text - Warning: Review Text must be between twentyfive and thousand characters! should be displayed")
	public void proper_warning_message_with_the_text_warning_review_text_must_be_between_twentyfive_and_thousand_characters_should_be_displayed() {
		Assert.assertTrue(productDisplayPage.isErrorMessageIsDisplayed(), "Error message is not displayed!");
	}
	@When("User click on Add to Wish List option in the displayed Product Display page")
	public void user_click_on_add_to_wish_list_option_in_the_displayed_product_display_page() {
		productDisplayPage.clickAddToWishList();
	}
	@Then("Success message with text - Success: You have added Product Name to your wish list! is displayed")
	public void success_message_with_text_success_you_have_added_product_name_to_your_wish_list_is_displayed() {
		Assert.assertTrue(productDisplayPage.isWishlistMessageDisplayedCorrectly("iMac"), "Error message is not displayed!");
	}
	@When("User click on wish list link in the success message")
	public void user_click_on_wish_list_link_in_the_success_message() {
		productDisplayPage.clickWishListLinkInMessage();;
	}

	@Then("User should be taken to Wish List page and the product added is displayed in the Wish List page")
	public void user_should_be_taken_to_wish_list_page_and_the_product_added_is_displayed_in_the_wish_list_page() {
		Assert.assertTrue(productDisplayPage.isUserOnWishListPage(), "User is not on wishList page!");
		Assert.assertTrue(productDisplayPage.areProductAddedSuccessfully(), "products are not added successfully!");
	}

	@When("User click on the Related Products section in the displayed Product Display Page")
	public void user_click_on_the_related_products_section_in_the_displayed_product_display_page() {
		productDisplayPage.clickRelatedSectionProduct();
	}
	@Then("User should see the Product displayed in the Related Products section and is able ot click it and navigate to the Product Display Page of it.")
	public void user_should_see_the_product_displayed_in_the_related_products_section_and_is_able_ot_click_it_and_navigate_to_the_product_display_page_of_it() {
		Assert.assertTrue(productDisplayPage.isBreadCrumbOfRelatedProductIsDisplayed(), "Breadcrumb of product display page is not displayed!");
	}

	@Then("Proper warning messages informing the User to fill the mandatory fields to submit the review should be displayed.")
	public void proper_warning_messages_informing_the_user_to_fill_the_mandatory_fields_to_submit_the_review_should_be_displayed() {
		Assert.assertTrue(productDisplayPage.isErrorMessageIsDisplayed(), "Error message is not displayed!");
	}
	@When("User click on review tab on product display page")
	public void user_click_on_review_tab_on_product_display_page() {
		productDisplayPage.clickReviewTabOnProductDisplayPage();
	}
	@When("User Click on the review tab of the Product in the displayed Product Display page")
	public void user_click_on_the_review_tab_of_the_product_in_the_displayed_product_display_page() {
		productDisplayPage.clickReviewTab();
	}

	@When("User Click on the review tab of iMac Product in the displayed Product Display page")
	public void user_click_on_the_review_tab_of_iMac_the_product_in_the_displayed_product_display_page() {
		productDisplayPage.clickReviewTabOnProductDisplayPage();
	}
	@Then("User must see the correct average reviews and number of reviews count under Add to cart button")
	public void user_must_see_the_correct_average_reviews_and_number_of_reviews_count_under_add_to_cart_button() {
		Assert.assertTrue(productDisplayPage.verifyReviewCountAndStarRating(), "Review count or star rating is not displayed correctly!");
	}
	@Then("User must see the correct reviews count under reviews tab of product display page")
	public void user_must_see_the_correct_reviews_count_under_reviews_tab_of_product_display_page() {
		Assert.assertTrue(productDisplayPage.isReviewSectionValid(), "review section is not working correctly!");
	}

	@When("User enter name in name text field")
	public void user_enter_name_in_name_text_field() {
		productDisplayPage.enterNameInReview("Reena Katade");
	}
	@When("User enter review text into the Your Review text are field")
	public void user_enter_review_text_into_the_your_review_text_are_field() {
		String reviewText = "he 30-inch Apple Cinema HD Display delivers an amazing 2560 x 1600 pixel resolution. Designed specifically for the creative professional, this display provides more space for easier access to all the tools and palettes needed to edit";
		productDisplayPage.AddReviewInTextBox(reviewText);
	}
	@When("User selects any rating radio button")
	public void user_selects_any_rating_radio_button() {
		productDisplayPage.selectRatingRadioButton();
	}
	@When("User click on continue button")
	public void user_click_on_continue_button() {
		productDisplayPage.clickContinueReviewButton();
	}
	@Then("User Success message with text - {string} should be displayed.")
	public void user_success_message_with_text_should_be_displayed(String SuccessMessage) {
		assertEquals(productDisplayPage.getProductAddedSuccessMsg(), SuccessMessage, "Success message is not matched!");
	}
	@Then("User must see {string} message under review Tab")
	public void user_must_see_message_under_review_tab(String NoReviewText) {
		Assert.assertEquals(productDisplayPage.getTextUnderReviewTab(), NoReviewText, "Textmessage under review tab is not matching!");
	}
	@Then("User must be navigated to product {string} display page of product")
	public void user_must_be_navigated_to_product_display_page_of_product(String productName) throws IOException {
		testContextSetup.waitUtils.waitForPageLoad(5);
		Assert.assertEquals(productDisplayPage.IsRightProductPageDisplayed(), productName, "User is landed on wrong product display page!");
		testContextSetup.testBase.WebDriverManager().navigate().back();
		testContextSetup.testBase.WebDriverManager().navigate().refresh();
		testContextSetup.testBase.WebDriverManager().manage().deleteAllCookies();
		testContextSetup.testBase.WebDriverManager().navigate().refresh();
	}
	@When("Wait for few seconds")
	public void wait_for_few_seconds() {
		productDisplayPage.waitForFewSeconds();
	}
	@When("User Click on the Specification tab of the Product in the displayed Product Display page")
	public void user_click_on_the_specification_tab_of_the_product_in_the_displayed_product_display_page() {
		productDisplayPage.clickSpecificationTab();
	}
	@Then("Correct Specifications of the product without any spelling or grammatrical mistakes should be displayed for different types of Products.")
	public void correct_specifications_of_the_product_without_any_spelling_or_grammatrical_mistakes_should_be_displayed_for_different_types_of_products() {
		Assert.assertEquals(productDisplayPage.getTitleOFSpecification(), "Processor","Title of specification is matched!");
		Assert.assertEquals(productDisplayPage.getFirstColmnText(), "Clockspeed", "First column text is not correct!");
		Assert.assertEquals(productDisplayPage.getSecondColmnText(), "100mhz", "Second column text is not correct!");
	}

	@When("User click on description tab on product display page")
	public void user_click_on_description_tab_on_product_display_page() {
		productDisplayPage.clickDescriptionTab();
	}
	@Then("Correct Description of the product without any spelling or grammatical mistakes should be displayed for different types of Products.")
	public void correct_description_of_the_product_without_any_spelling_or_grammatical_mistakes_should_be_displayed_for_different_types_of_products() {
		String ActualDescriptionText = "Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo processors. And more memory standard. Combine this with Mac OS X Leopard and iLife ´08, and it´s more all-in-one than ever. iMac packs amazing performance into a stunningly slim space.";
		Assert.assertEquals(productDisplayPage.getDescriptionText(), ActualDescriptionText, "Description text is not as per requirement!");
	}
	@When("User enter negative {string} value in qty text box field")
	public void user_enter_negative_value_in_qty_text_box_field(String negativeValue) {
		productDisplayPage.enterValueInQuantityTextBox(negativeValue);
	}
	@When("User click on Add to Cart button")
	public void user_click_on_add_to_cart_button() {
		productDisplayPage.clickAddToCartButton();
	}
	@When("Check the miniumum quantity {string} Qty text field in the Product Display Page")
	public void check_the_miniumum_quantity_qty_text_field_in_the_product_display_page(String minQuantity) {
		Assert.assertEquals(productDisplayPage.getQuantity(), minQuantity, "min quantity is not matched!");
	}

	@Then("Field level message {string} should be displayed")
	public void field_level_message_should_be_displayed(String errorMessage) {
		Assert.assertEquals(productDisplayPage.getGlobalSuccessMessage(), errorMessage,"Error message is not displayed!");
	}
	@When("User clicks on product Name link from displayed product message")
	public void user_clicks_on_product_name_link_from_displayed_product_message() {
		productDisplayPage.clickProductNameDisplayedInLink();
	}
	@When("User click on the main bigger sized Thumbnail image displayed on the Product Display Page")
	public void user_click_on_the_main_bigger_sized_thumbnail_image_displayed_on_the_product_display_page() {
		productDisplayPage.clickProductThumbnail();
	}
	@Then("Light box view of the main Thumnail image should be displayed with options to view the previous and next Thumnail images in Light box view.")
	public void light_box_view_of_the_main_thumnail_image_should_be_displayed_with_options_to_view_the_previous_and_next_thumnail_images_in_light_box_view() {
		Assert.assertTrue(productDisplayPage.isLightBoxContainerIsDisplyed(), "lightBox container is not displayed!");
		Assert.assertTrue(productDisplayPage.isLeftArrowKeyIsDisplayed(), "Left Arrow key is not displayed!");
		Assert.assertTrue(productDisplayPage.isNextArrowKeyIsDisplayed(), "Right Arrow key is not displayed!");
	}
	@When("User click on left arrow key")
	public void user_click_on_left_arrow_key() {
		productDisplayPage.clickLeftArrowKey();
	}
	@Then("Previous image of product should be displayed")
	public void previous_image_of_product_should_be_displayed() {
		Assert.assertTrue(productDisplayPage.verifyLightBoxPreviousNextWrapping());
	}
	@When("User click on rogth Arrow key")
	public void user_click_on_rogth_arrow_key() {
		productDisplayPage.clickNextArrowKey();
	}
	@Then("Next image should be displayed")
	public void next_image_should_be_displayed() {
		Assert.assertTrue(productDisplayPage.verifyLightBoxPreviousNextWrapping());
	}
	@When("User clicks on product Name link from displayed product success message")
	public void user_clicks_on_product_name_link_from_displayed_product_success_message() {
		productDisplayPage.clickProductNameDisplayedInLink();
	}

	@Then("User should be navigated to the respective Product Display Page")
	public void user_should_be_navigated_to_the_respective_product_display_page() {
		Assert.assertTrue(productDisplayPage.userIsOniMacProductDisplayPage(), "User is not on iMac product display page!");
	}
	@When("User hover the mouse cursor on Compare this Product option from the displayed Product Display Page")
	public void user_hover_the_mouse_cursor_on_compare_this_product_option_from_the_displayed_product_display_page() {
		productDisplayPage.HoverOnCompareThisProduct();
	}
	@Then("Tool tip with the text - {string} should be displayed")
	public void tool_tip_with_the_text_should_be_displayed(String CompareProductMouseHoverText) {
		testContextSetup.waitUtils.waitForPageLoad(10);
		assertEquals(productDisplayPage.getCompareProductMouseHoverText(), CompareProductMouseHoverText, "Tooltip text is not matching!");
	}
	@Then("Success message with text - Success: You have added Product Name to your product comparison! should be displayed")
	public void success_message_with_text_success_you_have_added_product_name_to_your_product_comparison_should_be_displayed() {
		testContextSetup.waitUtils.waitForPageLoad(10);
		Assert.assertTrue(productDisplayPage.getProductAddedSuccessMsg().contains("Success: You have added"), "Product is not added successfully to the product comparison!");
	}
	@When("Click on product comparision link from the displayed success message")
	public void click_on_product_comparision_link_from_the_displayed_success_message() {
		productDisplayPage.clickOnProductComparisonLink();
	}

	@When("User selects Compare this Product option")
	public void user_selects_compare_this_product_option() throws InterruptedException {
		productDisplayPage.clickCompareThisProductOptionOnProductDisplayPage();
		Thread.sleep(3000);
	}
	@When("User must click on displayed product name in search result")
	public void user_must_click_on_displayed_product_name_in_search_result() {
		productDisplayPage.clickiMacLinkInDisplayedSearchResult();
	}
	@When("User select Compare this Product option on Product Display Page")
	public void user_select_compare_this_product_option_on_product_display_page() {
		productDisplayPage.clickCompareThisProductButton();
	}

	@When("User click on the name of link on the success message")
	public void user_click_on_the_name_of_link_on_the_success_message() {
		productDisplayPage.clickProductNameDisplayedInLink();
	}
	@Then("User should be navigated to respective product display page")
	public void user_should_be_navigated_to_respective_product_display_page() {
		productDisplayPage.userIsOniMacProductDisplayPage();
	}

	@When("User click on the Product Name link in the displayed success message on product display page")
	public void user_click_on_the_product_name_link_in_the_displayed_success_message_on_product_display_page() {
		productDisplayPage.clickProductNameDisplayedInLink();
	}

	@When("User clicks on product compare link")
	public void user_clicks_on_product_compare_link() {
		productDisplayPage.clickProductCompare(0);
	}

	@Then("User should see success message {string} for added product!")
	public void user_should_see_success_message_for_added_product(String ProductSuccessMessage) {
		Assert.assertEquals(productDisplayPage.getProductAddedSuccessMsg(), ProductSuccessMessage, "Product Success message is not matched!");
	}

	@Then("User clicks on product comparison link")
	public void user_clicks_on_product_comparison_link()
	{
		productDisplayPage.clickOnProductComparisonLink();
	}

	@When("User click on the Product Name link in the success message")
	public void user_click_on_the_product_name_link_in_the_success_message() {
		productDisplayPage.clickProductNameDisplayedInLink();
	}
	@Then("User should be navigated to the respective product page")
	public void user_should_be_navigated_to_the_respective_product_page() {
		Assert.assertTrue(productDisplayPage.userIsOniMacProductDisplayPage(), "User is landed on wrong page!");
	}
	@When("User click on the Product Comparison link in the displayed success message")
	public void user_click_on_the_product_comparison_link_in_the_displayed_success_message() {
		productDisplayPage.clickProductComparisonLink();
	}
	@When("User click on x option")
	public void user_click_on_x_option() {
		productDisplayPage.clickCloseButtonListBoxView();
	}
	@Then("Light box view should close and the focus should go to the Product Display Page")
	public void light_box_view_should_close_and_the_focus_should_go_to_the_product_display_page() {
		Assert.assertTrue(productDisplayPage.userIsOniMacProductDisplayPage(), "User is landed on wrong page!");
	}
	@When("User press Esc key when thumbnails are displayed in light box view")
	public void user_press_esc_key_when_thumbnails_are_displayed_in_light_box_view() {
		productDisplayPage.pressEscapeKey();
	}
	@Then("Proper Product Name, Brand and Product Code should be displayed for the different types of Products in the Product Display Page.")
	public void proper_product_name_brand_and_product_code_should_be_displayed_for_the_different_types_of_products_in_the_product_display_page() {
		productDisplayPage.verifyProductInformation("iMac", "Apple", "Product 14", "Out Of Stock");
	}
	@Then("Proper avaialabilty statuses like In Stock, Out of Stock and Limited Stock should be displayed in the Availabilty section of the Product Display Page for the different types of Products.")
	public void proper_avaialabilty_statuses_like_in_stock_out_of_stock_and_limited_stock_should_be_displayed_in_the_availabilty_section_of_the_product_display_page_for_the_different_types_of_products() {
		productDisplayPage.verifyAvailabilityStatus();
	}
	@Then("Proper price with and without tax should be displayed for the different types of Products in the Product Display Page.")
	public void proper_price_with_and_without_tax_should_be_displayed_for_the_different_types_of_products_in_the_product_display_page() {
		productDisplayPage.verifyDisplayedProductPriceAndExTaxPrice();
	}
	@When("Check the Qty text field in the Product Display Page")
	public void check_the_qty_text_field_in_the_product_display_page() {
		Assert.assertTrue(productDisplayPage.isQtyTextFieldIsEnabled(), "Qty text field is disabled!");
	}
	@Then("Default quantity should be displayed one for this product which has not minimum quantity set")
	public void default_quantity_should_be_displayed_for_this_product_which_has_not_minimum_quantity_set() {
		Assert.assertTrue(productDisplayPage.verifyDefaultQuantityis1(), "Qty text field is default quanity is not equal to 1!");
	}
	@When("Update the quantity by increasing it to more than one and click on Add to Cart button")
	public void update_the_quantity_by_increasing_it_to_more_than_one_and_click_on_add_to_cart_button() {
		productDisplayPage.UpdateQuantity(2);
	}
	@Then("Quantity should get updated accordingly and the User should be able to add the Product to cart without any issues.")
	public void quantity_should_get_updated_accordingly_and_the_user_should_be_able_to_add_the_product_to_cart_without_any_issues() {
		Assert.assertTrue(productDisplayPage.verifyUpdatedQuantity(), "Quantity is not updated successfully");
		productDisplayPage.clickAddToCartButton();
	}
	@When("Update the quantity in the Qty text feild by providing a negative number or zero number or null quanitity and click on Add to Cart button")
	public void update_the_quantity_in_the_qty_text_feild_by_providing_a_negative_number_or_zero_number_or_null_quanitity_and_click_on_add_to_cart_button() {
		Map<String, Boolean> testResults = new LinkedHashMap<>();
		testResults.put("-1", productDisplayPage.checkInvalidQuantity("-1"));
		testResults.put("0", productDisplayPage.checkInvalidQuantity("0"));
		testResults.put("", productDisplayPage.checkInvalidQuantity(""));

		boolean allPassed = true;
		StringBuilder report = new StringBuilder("\nInvalid Quantity Validation Report:\n");

		for (Map.Entry<String, Boolean> entry : testResults.entrySet()) {
			String qty = entry.getKey();
			boolean result = entry.getValue();

			if (result) {
				report.append("PASSED: Quantity '" + qty + "' correctly rejected.\n");
			} else {
				report.append("FAILED: Quantity '" + qty + "' was accepted — BUG.\n");
				allPassed = false;
			}
		}

		System.out.println(report.toString());
		Assert.assertTrue(allPassed, "Some invalid quantities were wrongly accepted! See console log for details.");
	}
}


