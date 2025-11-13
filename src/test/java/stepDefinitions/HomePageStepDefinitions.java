package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import testBase.TestContextSetup;

public class HomePageStepDefinitions {

	TestContextSetup testContextSetup;
	HomePage homePage;

	public HomePageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.homePage = testContextSetup.pageObjectManger.getHomePage();
	}

	@Then("User changes currency to Dollars and see complete application is changes into Dollars")
	public void user_changes_currency_to_dollars_and_see_complete_application_is_changes_into_dollars() {
		testContextSetup.log.info("verifying currency conversion to dollar!!");
		Assert.assertTrue(homePage.verifyCurrencyConversionToDollar(), "currency conversion to dollars in not working correctly!");
		testContextSetup.log.info("currency conversion to dollar has been verified!!");
	}

	@Then("User changes currency to pounds and see complete application is changes into pounds")
	public void user_changes_currency_to_pounds_and_see_complete_application_is_changes_into_pounds() {
		testContextSetup.log.info("verifying currency conversion to pound!!");
		Assert.assertTrue(homePage.verifyCurrencyConversionToPound(), "currency conversion to pounds in not working correctly!");
		testContextSetup.log.info("verifying currency conversion to pound!!");
	}

	@Then("User changes currency to Euro and see complete application is changes into Euros")
	public void user_changes_currency_to_euro_and_see_complete_application_is_changes_into_euros() {
		testContextSetup.log.info("verifying currency conversion to euros!!");
		Assert.assertTrue(homePage.verifyCurrencyConversionToEuro(), "currency conversion to euros is not working correctly!");
		testContextSetup.log.info("verifying currency conversion to euros!!");
	}

	@Then("User must see copyright text Correct year and brand name in footer section")
	public void user_must_see_copyright_text_correct_year_and_brand_name_in_footer_section() {
		testContextSetup.log.info("verifying copyright text correct year and brand name is displayed in footer section!!");
		Assert.assertTrue(homePage.verifyFooterTextIsDisplayed(), "copyright text is not displayed in footer section!");
		testContextSetup.log.info("copyright text correct year and brand name is displayed in footer section has been verified!!");
	}

	@When("User click on returns in footer section")
	public void user_click_on_returns_in_footer_section() {
		testContextSetup.log.info("clicking on returns in footer section!!");
		Assert.assertTrue(homePage.clickReturnsLinkInFooter(), "returns link is not clickable!");
		testContextSetup.log.info("clicked successfully on returns in footer section!!");
	}
	@Then("User should be redirected to returns page")
	public void user_should_be_redirected_to_returns_page() {
		testContextSetup.log.info("verifying user is landed on returns page!!");
		Assert.assertTrue(homePage.verifyReturnsPageIsLanded(), "returns page is not landed!");
		testContextSetup.log.info("user is landed on returns page!!");
	}

	@When("User click on contact us in footer section")
	public void user_click_on_contact_us_in_footer_section() {
		testContextSetup.log.info("clicking on contact us link in footer section!!");
		Assert.assertTrue(homePage.clickContactUsLink(), "Contact us link is not clickable!");
		testContextSetup.log.info("clicked successfully on contact us link in footer section!!");
	}
	@Then("User should be redirected to Contact page")
	public void user_should_be_redirected_to_contact_page() {
		testContextSetup.log.info("verifying user is landed on contact us page!!");
		Assert.assertTrue(homePage.isUserOnContactUsPage(), "User is not landed on contact us page!");
		testContextSetup.log.info("user successfully landed on contact us page!!");
	}

	@Then("User should see links like Contact Us, Returns, Site Map should be present")
	public void user_should_see_links_like_contact_us_returns_site_map_should_be_present() {
		testContextSetup.log.info("verifying links present under customer service!");
		Assert.assertTrue(homePage.verifyLinksUnderCustomerServiceLinks(), "links under customer service is not visible!");
		testContextSetup.log.info("all links present under customer service has been verified!");
	}

	@Then("User should see links like About Us, Delivery Information, Privacy Policy, Terms & Conditions should be present")
	public void user_should_see_links_like_about_us_delivery_information_privacy_policy_terms_conditions_should_be_present() {
		testContextSetup.log.info("verifying links under informarion section!");
		Assert.assertTrue(homePage.verifyLinksUnderInformationSection(), "links under information section is not visible!");
		testContextSetup.log.info("all links present under information section!!");
	}

	@Then("User click on My Account Login option and user should be redirected to login page")
	public void user_click_on_my_account_login_option_and_user_should_be_redirected_to_login_page() {
		testContextSetup.log.info("verifying login option redirects to login page!");
		Assert.assertTrue(homePage.verifyLoginOptionRedirectToLoginPage(), "Login page redirection is not working!");
		testContextSetup.log.info("login option redirected to login page has been verified!");
	}

	@Then("User should see footer is visible at below of the page")
	public void user_should_see_footer_is_visible_at_below_of_the_page() {
		testContextSetup.log.info("verifying footer is present on the homepage!");
		Assert.assertTrue(homePage.verifyFooterOfThePage(), "footer of the page is not visible!");
		testContextSetup.log.info("footer is present on the homepage has been verified!");
	}

	@Then("User should see Login and register dropdown option in my Account dropdown")
	public void user_should_see_login_and_register_dropdown_option_in_my_account_dropdown() {
		testContextSetup.log.info("verifying myAccountDropMenu is working correctly and shows login and register options under it!");
		Assert.assertTrue(homePage.verifyClickOnMyAccountDropMenu(), "my account drop menu is working as expected!");
		testContextSetup.log.info("myAccountDropMenu is working as expected and showing login and register options under it!");
	}

	@Then("User should see components Dropdown colour is highlighted when hoverover")
	public void user_should_see_components_dropdown_colour_is_highlighted_when_hoverover() {
		testContextSetup.log.info("user should see components dropdown colour is highlighted when hoverover!");
		Assert.assertTrue(homePage.verifyLaptopsAndNoteBooksMenuHighlightOnHover(), "header option colour is not getting changed!");
		testContextSetup.log.info("components dropdown colour is highlighted when hoverover has been verified!");
	}

	@Then("User should see Dropdown showAll options for each category")
	public void user_should_see_dropdown_show_all_options_for_each_category() {
		testContextSetup.log.info("verifying showAllOption for each header option category!");
		Assert.assertTrue(homePage.verifyClickingShowAllOptionForEachHeaderCategory(), "show all option for each category is not working correcly!");
		testContextSetup.log.info("showAll option for each header option is working correctly has been verified!");
	}

	@Then("User should see Dropdown macs and windows suboptions")
	public void user_should_see_dropdown_macs_and_windows_suboptions() {
		testContextSetup.log.info("verifying laptops and notebook menu options!");
		Assert.assertTrue(homePage.verifyLaptopsAndNoteBooksMenuOption(), "Laptops and desktops options are not showing correclty!");
		testContextSetup.log.info("laptops and notebook menu options has been verified!");
	}

	@Then("User should see deskTop menu option verify suboptions")
	public void user_should_see_desk_top_menu_option_verify_suboptions() {
		testContextSetup.log.info("verifying laptops and notebook menu options!");
		Assert.assertTrue(homePage.verifyDesktopMenuOption(), "Desktop options are not displaying correctly!");
		testContextSetup.log.info("verifying laptops and notebook menu options!");
	}

	@When("User click on cart icon present in header")
	public void user_click_on_cart_icon_present_in_header() {
		testContextSetup.log.info("clicking on header cart icon!");
		Assert.assertTrue(homePage.clickOnHeaderCartIcon(), "cart icon is not displayed!");
		testContextSetup.log.info("clicked on header cart icon!");
	}
	@Then("User should see a small dropdown should appear showing cart summary or your shopping cart is empty! message")
	public void user_should_see_a_small_dropdown_should_appear_showing_cart_summary_or_your_shopping_cart_is_empty_message() {
		testContextSetup.log.info("verifying cart small window is appears when click on cart!");
		Assert.assertTrue(homePage.verifyCartSmallWindowAppears(), "small cart window does not appear!");
		testContextSetup.log.info("cart small window is appears when click on cart has been verified!");
	}

	@Then("User see cart icon displayed in header cart section")
	public void user_see_cart_icon_displayed_in_header_cart_section() {
		testContextSetup.log.info("verifying cart icon is visible on header!");
		Assert.assertTrue(homePage.isHeaderCartIconVisible(), "cart icon is not visible to user on homePage!");
		testContextSetup.log.info("cart icon is visible has been verified!");
	}

	@Then("User enter invalid product in search box field and user must get no product found in search result message")
	public void user_enter_invalid_product_in_search_box_field_and_user_must_get_no_product_found_in_search_result_message() {
		testContextSetup.log.info("verifying invalid product search landing page is displaying correctly!");
		Assert.assertTrue(homePage.verifyInvalidProductSearchLandingPage(), "Invalid product seach is not working properly!");
		testContextSetup.log.info("invalid product search is displayed correctly!!");
	}

	@Then("User enter valid product in search box field and user must gets same product on search result")
	public void user_enter_valid_product_in_search_box_field_and_user_must_gets_same_product_on_search_result() {
		testContextSetup.log.info("verifying user is landed on correct search page!");
		Assert.assertTrue(homePage.verifyProductSearchLandingValidPage(), "Product search landing on wrong page!");
		testContextSetup.log.info("user is landed on correct search page has been verified!");
	}

	@Then("Search box should be visible in header")
	public void search_box_should_be_visible_in_header() {
		testContextSetup.log.info("verifying search box is present on homePage!!");
		Assert.assertTrue(homePage.verifySearchBoxIsPresentOnHomePage(), "Search box is not displayed on homePage!");
		testContextSetup.log.info("search box is present on homePage has been verified!!");
	}

	@When("User click on logo")
	public void user_click_on_logo() {
		testContextSetup.log.info("clicking on logo!!");
		Assert.assertTrue(homePage.clickOnLogo(), "logo is not clickable!");
		testContextSetup.log.info("clicked successfully on logo!!");
	}
	@Then("User is landed to homePage")
	public void user_is_landed_to_home_page() {
		testContextSetup.log.info("verifying user is landed on homepage!!");
		Assert.assertTrue(homePage.userIsOnHomePage(), "User is not landed on homepage!");
		testContextSetup.log.info("user is successfully landed on homePage section!!");
	}

	@Then("Application logo should be visible in header")
	public void application_logo_should_be_visible_in_header() {
		testContextSetup.log.info("verifying logo is present on homepage header!!");
		Assert.assertTrue(homePage.verifyLogoPresentOnHeader(), "Logo not present on header section!");
		testContextSetup.log.info("logo is present on homepage has been verified!!");
	}

	@When("Click Gift Certificates from footer\\/extras")
	public void click_gift_certificates_from_footer_extras() {
		testContextSetup.log.info("clicking on gift certificate link from footer!!");
		Assert.assertTrue(homePage.clickGiftCertificateLinkFromFooter(), "Gift certificate link is not clickable!");
		testContextSetup.log.info("gift certificate link is not clickable on footer section!!");
	}

	@Then("User should be landed to homePage")
	public void user_should_be_landed_to_home_page() {
		testContextSetup.log.info("verifying user is landed on homePage!!");
		Assert.assertTrue(homePage.isUserLandedOnHomePage(), "User is not on the homepage!");
		testContextSetup.log.info("user is landed on homePage has been verified!!");
	}

	@When("Click on Contact Us link from the Footer options")
	public void click_on_contact_us_link_from_the_footer_options() {
		testContextSetup.log.info("clicking on contact us link!!");
		Assert.assertTrue(homePage.clickContactUsLink(), "contact us link is not clickable!");
		testContextSetup.log.info("clicked successfully on contact us link!!");
	}

	@When("User creates new account and select no radio button of subscription and land on myAccount page")
	public void user_creates_new_account_and_select_no_radio_button_of_subscription_and_land_on_my_account_page() {
		testContextSetup.log.info("creating new account with no radio button option is selected for subscription!");
		Assert.assertTrue(homePage.createNewAccountWithNoOptionSelectedForRadioButton(), "Account is not created with No subscription option!");
		testContextSetup.log.info("new account with no radio button option is selected for subscription has been created successfully!");
	}

	@When("User creates new account and select yes radio button of subscription and land on myAccount page")
	public void user_creates_new_account_and_select_yes_radio_button_of_subscription_and_land_on_my_account_page() {
		testContextSetup.log.info("creating new account with yes radio button subscription option selected!");
		Assert.assertTrue(homePage.createNewAccountWithYesOptionSelectedForRadioButton(), "New account is not created successfully with yes radio button selected!");
		testContextSetup.log.info("new account with yes radio button option is selected for subscription has been created successfully!");
	}

	@When("Click on Newsletter link from the Footer of the page")
	public void click_on_newsletter_link_from_the_footer_of_the_page() {
		testContextSetup.log.info("clicking on newsletter option from footer!");
		Assert.assertTrue(homePage.clickNewsLetterLinkFromFooter(), "NewsLetter option is not clickable!");
		testContextSetup.log.info("clicked successfully on newsletter option from footer!");
	}

	@When("User click on site map link from footer option")
	public void user_click_on_site_map_link_from_footer_option() {
		testContextSetup.log.info("clicking on siteMap link option!");
		homePage.clickSiteMapLink();
		testContextSetup.log.info("clicked successfully on sitemap link option!");
	}

	@When("User click on My Account link from my Account dropdown")
	public void user_click_on_my_account_link_from_my_account_dropdown() {
		testContextSetup.log.info("clicking on myAccount drop menu option!");
		homePage.clickMyAccountDropMenu();
		testContextSetup.log.info("clicked successfully on myAccount drop menu option!");
		testContextSetup.log.info("clicking on myAccount drop menu sub options!");
		homePage.clickMyAccountSubLink();
		testContextSetup.log.info("clicked successfully on myAccount drop menu suboptions option!");
	}

	@When("User click on checkout page header option link")
	public void user_click_on_checkout_page_header_option_link() {
		testContextSetup.log.info("clicking on checkout header option!");
		homePage.clickCheckOutHeaderLink();
		testContextSetup.log.info("clicked successfully on checkout header option!");
	}

	@Then("Check the Partner Carousel Logo images and slider options on the displayed Home page")
	public void check_the_partner_carousel_logo_images_and_slider_options_on_the_displayed_home_page() throws InterruptedException {
		testContextSetup.log.info("validating partner carousel!");
		homePage.validatePartnerCarousel();
		testContextSetup.log.info("partner carousel has been verified!");
	}

	@Then("User can see Hero Images and slider options on the displayed Home page")
	public void user_can_see_hero_images_and_slider_options_on_the_displayed_home_page() {
		testContextSetup.log.info("validating hero image carousel!");
		Assert.assertTrue(homePage.validateHeroImageCarousel(), "User is not able to land on homepage from every page");
		testContextSetup.log.info("hero image carousel has been verified!");
	}

	@Given("User Open the Application URL and navigate to different pages of the Application and by clicking on home breadcrumb user must landed to homePage")
	public void user_open_the_application_url_and_navigate_to_different_pages_of_the_application_and_by_clicking_on_home_breadcrumb_user_must_landed_to_home_page() {
		testContextSetup.log.info("validating homePage breadcrumb from all pages!");
		Assert.assertTrue(homePage.validateHomeBreadcrumbNavigationFromAllPages(), "User is not able to land on homepage from every page");
		testContextSetup.log.info("homePage breadcrumb from all pages has been verified!");
	}

	@Then("All the option of the Products in the Featured section should be working correctly")
	public void all_the_option_of_the_products_in_the_featured_section_should_be_working_correctly() {
		testContextSetup.log.info("validating all featured products!");
		Assert.assertTrue(homePage.validateAllFeaturedProducts(), "All the options are not working correctly in featured section!");
		testContextSetup.log.info("all featured products has been verified!");
	}

	@Then("User can see four products in featured section of homePage")
	public void user_can_see_four_products_in_featured_section_of_home_page() {
		testContextSetup.log.info("validating four products are displayed under featured section!");
		Assert.assertTrue(homePage.isFourProductsDisplayedInFeaturedSection(), "four products are not displaying in featured section of homepage");
		testContextSetup.log.info("four products are displayed under featured section has been verified!");
	}

	@When("User hover on desktop")
	public void user_hover_on_desktop() {
		testContextSetup.log.info("validating mouse hover on desktop link!");
		homePage.hoverOnDesktop();
		testContextSetup.log.info("mouse hover on desktop link has been validated!");
	}
	@When("User click on PC\\(o) link present in desktop menu")
	public void user_click_on_pc_o_link_present_in_desktop_menu() {
		testContextSetup.log.info("clicking on PC link under desktop option!");
		homePage.clickPCLinkUnderDesktop();
		testContextSetup.log.info("clicked successfully on pc link under desktop option!");
	}

	@When("User click on About Us footer link")
	public void user_click_on_about_us_footer_link() {
		testContextSetup.log.info("clicking on about us footer link!");
		homePage.clickAboutUsFooterLink();
		testContextSetup.log.info("clicked successfully on about us footer link!");
	}

	@Then("User must be landed to homepage")
	public void user_must_be_landed_to_homepage() {
		testContextSetup.log.info("verifying user is landed on homepage!");
		Assert.assertTrue(homePage.isUserLandedOnHomePage(), "Homepage is displayed!");
		testContextSetup.log.info("user is landed successfully on homePage!");
	}

	@When("User click on shopping cart header link")
	public void user_click_on_shopping_cart_header_link() {
		testContextSetup.log.info("clicking on shopping cart link!");
		homePage.clickShoppingCartLink();
		testContextSetup.log.info("clicked successfully on shopping cart link!");
	}

	@Then("User will see if wishList header count is getting increased after product is added")
	public void user_will_see_if_wish_list_header_count_is_getting_increased_after_product_is_added() {
		testContextSetup.log.info("verifying wishlist count increase after add!");
		homePage.isWishListCountIncreasedAfterAdd();
		testContextSetup.log.info("wishlist count increase after add has been verified!");
	}

	@When("User click on wish list icon in header")
	public void user_click_on_wish_list_icon_in_header() {
		testContextSetup.log.info("clicking on wishlist header option!");
		homePage.clickWishListHeaderOption();
		testContextSetup.log.info("clicked successfully on wishlist header option!");
	}

	@When("User clears global search field")
	public void user_clears_global_search_field() {
		testContextSetup.log.info("clear search text box field!!");
		homePage.clearSearchTextBoxField();
		testContextSetup.log.info("search text box field has been cleared!!");
	}

	@Given("User is on the TutorialsNinja home page")
	public void user_is_on_the_tutorials_ninja_home_page() throws IOException {
		testContextSetup.log.info("verifying homePage title is displayed!!");
		testContextSetup.testBase.WebDriverManager();
		Assert.assertTrue(homePage.isHomePageTitleDisplayed());
		testContextSetup.log.info("homePage title is displayed has been verified!!");
	}

	@When("User click on compare this product option and click on product comparison link from success message")
	public void user_click_on_compare_this_product_option_and_click_on_product_comparison_link_from_success_message() {
		testContextSetup.log.info("clicking on compareproduct option!");
		homePage.clickCompareProductOption();
		testContextSetup.log.info("clicked successfully on productcompare option!!");
		testContextSetup.log.info("clicking on product comparison link in success message!!");
		homePage.clickProductComparisonLinkInSuccessMessage();
		testContextSetup.log.info("clicked on product comparison link under success message!!");
	}
	@When("User click on add to cart button on the product that is displayed in the featured section of the Home page")
	public void user_click_on_add_to_cart_button_on_the_product_that_is_displayed_in_the_featured_section_of_the_home_page() {
		testContextSetup.log.info("clicking on add to cart button for first product displayed!");
		homePage.clickAddToCartFirstProduct();
		testContextSetup.log.info("clicked successfully on add to cart first product!");
	}

	@Then("User should be navigated to Homepage")
	public void user_should_be_navigated_to_homepage() {
		testContextSetup.log.info("verifying homepage title is displayed!");
		Assert.assertTrue(homePage.isHomePageTitleDisplayed(), "User is not landed on homePage!");
		testContextSetup.log.info("homepage title is displayed successfully has been veriifed!!");
	}

	@When("Hover the mouse cursor on Compare this Product option from one of the Product displayed in the Featured section of Home Page")
	public void hover_the_mouse_cursor_on_compare_this_product_option_from_one_of_the_product_displayed_in_the_featured_section_of_home_page() {
		testContextSetup.log.info("mouse hover on featured product compare option!");
		homePage.hoverOnFeaturedProductCompareOption();
		testContextSetup.log.info("mouse hover on featured product compare option has been done successfully!");
	}

	@Then("Tool tip with the text - {string} should be displayed for featured Section")
	public void tool_tip_with_the_text_should_be_displayed_for_featured_section(String CompareThisProductText) {
		testContextSetup.log.info("extracting compare this product tooltip text!");
		Assert.assertEquals(homePage.getCompareThisProductTooltipText(), CompareThisProductText, "Tooltip text is not matching!");
		testContextSetup.log.info("compare this product tooltip text us extracted successfully!");
	}
	@When("User selects Compare this Product option on featured Section")
	public void user_selects_compare_this_product_option_on_featured_section() {
		testContextSetup.log.info("clicking on compare this product button!");
		homePage.clickCompareThisProductButton();
		testContextSetup.log.info("clicked successfully on compare this product option!");
	}

	@When("User mouse hover on any menu say Desktops and select Show All Desktops option")
	public void user_mouse_hover_on_any_menu_say_desktops_and_select_show_all_desktops_option() {
		testContextSetup.log.info("mouse hover on desktop option!");
		homePage.hoverOnDesktop();
		testContextSetup.log.info("mouse hover is done successfully on desktop option!");
		testContextSetup.waitUtils.waitForPageLoad(10);
		testContextSetup.log.info("clicking on show all desktop option!");
		homePage.clickShowAllDesktopOption();
		testContextSetup.log.info("clicked successfully on show all desktop option!");
	}

	@When("User click on Site Map link in the footer options")
	public void user_click_on_site_map_link_in_the_footer_options() {
		testContextSetup.log.info("clicking on site map link!");
		homePage.clickSitMapLink();
		testContextSetup.log.info("clicked successfully on site map link!");
	}

	@When("User press Tab and Enter keys to perform Search operation and select several options in the Search page")
	public void user_press_tab_and_enter_keys_to_perform_search_operation_and_select_several_options_in_the_search_page() throws InterruptedException {
		testContextSetup.log.info("navigating to search page using keyboard keys!");
		homePage.navigateToSearchPageUsingKeyboardKeys();
		testContextSetup.log.info("successfully navigated to search page using keyboard keys!");
	}

	@When("User clicks on My Account Drop menu")
	public void user_clicks_on_my_account_drop_menu() {
		testContextSetup.log.info("clicking on myAccount link!");
		homePage.clickMyAccount();
		testContextSetup.log.info("successfully clicked on myAccount link!");
	}

	@When("User enters any non existing product name {string} into the search text box field")
	public void user_enters_any_non_existing_product_name_into_the_search_text_box_field(String nonExistingProductName) {
		testContextSetup.waitUtils.waitForPageLoad(5);
		testContextSetup.log.info("entering text into text box field using non existing product name!");
		homePage.EnterTextInSearchTextBox(nonExistingProductName);
		testContextSetup.log.info("enter successfully nonexisting product names into a search text box field!");
	}

	@When("User not entered anything into the {string} search text box field")
	public void user_not_entered_anything_into_the_search_text_box_field(String emptyString) {
		testContextSetup.waitUtils.waitForPageLoad(5);
		testContextSetup.log.info("entering empty string text into text box field using!");
		homePage.EnterTextInSearchTextBox(emptyString);
		testContextSetup.log.info("entered successfully empty text into text box field!");
	}

	@When("User enters the search criteria in the {string} text box field which can result in mutliple products")
	public void user_enters_the_search_criteria_in_the_text_box_field_which_can_result_in_mutliple_products(String searchItem) {
		testContextSetup.log.info("entering text into search text box field!");
		homePage.EnterTextInSearchTextBox(searchItem);
		testContextSetup.log.info("entered successfully text into search text box field!");
	}

	@When("User enters any existing product name {string} into the search text box field")
	public void user_enters_any_existing_product_name_into_the_search_text_box_field(String searchItem) {
		testContextSetup.log.info("entering text into text box field using existing product name!");
		testContextSetup.waitUtils.waitForPageLoad(5);
		homePage.enterTextInSearchTextBox(searchItem);
		testContextSetup.log.info("entered successfully text into text box field using existing product name!");
	}
	@When("User clicks on button having search icon")
	public void user_clicks_on_button_having_search_icon() throws IOException {
		testContextSetup.log.info("clicking on search button!");
		homePage.clickSearchButton();
		testContextSetup.log.info("clicked successfully on search icon!");
	}

	@When("User Selects Register option")
	public void user_selects_register_option() {
		testContextSetup.log.info("clicking on register button!");
		homePage.clickRegister();
		testContextSetup.log.info("clicked successfully on register button!");
	}

	@When("click on Login option")
	public void click_on_login_option() {
		testContextSetup.log.info("clicking on login button!");
		homePage.clickLogin();
		testContextSetup.log.info("clicked successfully on login button!");
	}

	@When("User Selects Login option")
	public void user_selects_login_option() {
		testContextSetup.log.info("clicking on login button!");
		homePage.clickLogin();
		testContextSetup.log.info("clicked successfully on login button!");
	}
	@Then("User navigate to all the pages of the Application search box field and the button with Search icon should be displayed on all the page of the Application")
	public void user_navigate_to_all_the_pages_of_the_application_search_box_field_and_the_button_with_search_icon_should_be_displayed_on_all_the_page_of_the_application() {
		testContextSetup.log.info("navigating to search page and verifying search!");
		homePage.navigateToAllPagesAndVerifySearch();
		testContextSetup.log.info("navigated successfully to search page and search is verified!");
	}
}
