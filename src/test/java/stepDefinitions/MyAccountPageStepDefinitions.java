package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MyAccountPage;
import testBase.TestContextSetup;

public class MyAccountPageStepDefinitions {

	TestContextSetup testContextSetup;
	MyAccountPage myAccountPage;

	public MyAccountPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		myAccountPage = testContextSetup.pageObjectManger.getMyAccountPage();
	}

	@When("User add his address into address section")
	public void user_add_his_address_into_address_section() {
	    Assert.assertTrue(myAccountPage.AddAddressForUser(), "Address no added successfully!");
	}

	@Then("User is LoggedIn user do browser back still user must not loggedOut")
	public void user_is_logged_in_user_do_browser_back_still_user_must_not_logged_out() {
		Assert.assertTrue( myAccountPage.userIsOnMyAccountPageNavigatesBackAndRefresh(), "User is getting loggedout after clicking browser back!");
	}

	@Then("User is landed to MyAccount page")
	public void user_is_landed_to_my_account_page_() {
	   Assert.assertTrue( myAccountPage.userIsOnMyAccountPage(), "User is not on my account page!");
	}

	@Then("User place an order and land on my Account page from order success page")
	public void user_place_an_order_and_land_on_my_account_page_from_order_success_page() {
	   myAccountPage.placeOrderAndVerifyNavigationToMyAccount();
	}

	@When("User search for three product iMac, iPhone and MacBook and adding to wishlist and verifying success message")
	public void user_search_for_three_product_i_mac_i_phone_and_mac_book_and_adding_to_wishlist_and_verifying_success_message() {
	    Assert.assertTrue(myAccountPage.addProductsToWishListAndVerifySuccessMessage(), "products are not getting added successfully to wishlist!");
	}

	@When("User click on wish list icon on header section")
	public void user_click_on_wish_list_icon_on_header_section() {
		Assert.assertTrue(myAccountPage.clickOnWishListHeaderIcon(), "wishList header icon is not clickable!");
	}

	@When("User clicks on button having search icon for second time product search")
	public void user_clicks_on_button_having_search_icon_for_second_time_product_search() {
	    Assert.assertTrue(myAccountPage.clickSearchFieldButton(), "search field button is not clickable at this moment!");
	}

	@Then("User should see special offers link is present in footer section")
	public void user_should_see_special_offers_link_is_present_in_footer_section() {
		testContextSetup.log.info("verifying special offers link is present in footer!!");
		Assert.assertTrue(myAccountPage.verifySpecialOffersLinkIsPresentInFooter(), "special offers link is not displayed in footer section!");
		testContextSetup.log.info("verified special offers link is present in footer!!");
	}

	@When("User click on special offers link from footer option")
	public void user_click_on_special_offers_link_from_footer_option() {
		testContextSetup.log.info("clicking on special offers link is present in footer!!");
		Assert.assertTrue(myAccountPage.clickSpecialOffersLink(), "Special offers link is not clickable!");
		testContextSetup.log.info("clicked successfully on special offers link is present in footer!!");
	}

	@Then("User should see success message with text Success: Your newsletter subscription has been successfully updated! should be displayed and the User should be taken to My Account page")
	public void user_should_see_success_message_with_text_success_your_newsletter_subscription_has_been_successfully_updated_should_be_displayed_and_the_user_should_be_taken_to_my_account_page() {
		testContextSetup.log.info("verifying success message is displayed for newsletter changes and user is landed to my account page!!");
		Assert.assertTrue(myAccountPage.isSuccessMessageIsDisplayed(), "NewsLetter changes is not sucess!");
		testContextSetup.log.info("verified success message is displayed for newsletter changes and user is landed to my account page!!");
	}

	@When("User click on Newsletter Right Column option")
	public void user_click_on_newsletter_right_column_option() {
		testContextSetup.log.info("clicking on news letter right column option!!");
		Assert.assertTrue(myAccountPage.clickNewsLetterRightColumnOption(), "newsletter right column option is not clickable!");
		testContextSetup.log.info("clicked on news letter right column option!!");
	}

	@When("User click on Subscribe\\/Unsubscribe link to newsLetter link")
	public void user_click_on_subscribe_unsubscribe_link_to_news_letter_link() {
		testContextSetup.log.info("clicking on subscribe unscubscribe link!!");
		Assert.assertTrue(myAccountPage.clickSubscribeUnscribeLink(), "user is not able click on subscribe unsubscribe link!");
		testContextSetup.log.info("clicked on subscribe unscubscribe link!!");
	}

	@Then("User should be on my Account page")
	public void user_should_be_on_my_account_page() {
		testContextSetup.log.info("verifying my account page breadcrumb is displayed!!");
		Assert.assertTrue(myAccountPage.isMyAccountPageBreadcrumbIsDisplayed(), "User is not landed on myAccount Page!");
		testContextSetup.log.info("verified my account page breadcrumb is displayed!!");
	}

	@Then("User should see confirmation message Your Affiliate Account has been successfully created.")
	public void user_should_see_confirmation_message_your_affiliate_account_has_been_successfully_created() {
		testContextSetup.log.info("verifying affiliate account created success message is displayed!!");
		Assert.assertTrue(myAccountPage.isAffiliateAccountCreatedSuccessfullyMsgDisplayed(), "my Affiliate account is not created successfully!");
		testContextSetup.log.info("verified affiliate account created success message is displayed!!");
	}

	@When("User click on register for an affiliate account link")
	public void user_click_on_register_for_an_affiliate_account_link() {
		testContextSetup.log.info("clicking on affiliate account link!!");
		myAccountPage.clickAffiliateAccountLink();
		testContextSetup.log.info("clicked on affiliate account link!!");
	}

	@When("User click on order History option from my Account drop down")
	public void user_click_on_order_history_option_from_my_account_drop_down() {
		testContextSetup.log.info("clicking on Order History link from my account drop menu!!");
		myAccountPage.clickOrderHistoryFromMyAccountDrpDwn();
		testContextSetup.log.info("clicked on Order History link from my account drop menu!!");
	}

	@When("User click on order history link under my account section")
	public void user_click_on_order_history_link_under_my_account_section() {
		testContextSetup.log.info("clicking on Order History link from my account section!!");
		myAccountPage.clickOrderHistoryLink();
		testContextSetup.log.info("clicking on Order History link from my account section!!");
	}

	@When("User clicks on address book right column option")
	public void user_clicks_on_address_book_right_column_option() {
		testContextSetup.log.info("clicking on address book link!!");
		myAccountPage.clickAddressBookLink();
		testContextSetup.log.info("clicked on address book link!!");
	}

	@Then("User should login successfully and taken to My Account page")
	public void user_should_login_successfully_and_taken_to_my_account_page() {
		testContextSetup.log.info("verifying user is on my account page!!");
		Assert.assertTrue(myAccountPage.isOnMyAccountPage(), "User is not on myAccount page!");
		testContextSetup.log.info("verified user is on my account page!!");
	}

	@Then("Success message with text - Success: Your password has been successfully updated. should be displayed")
	public void success_message_with_text_success_your_password_has_been_successfully_updated_should_be_displayed() {
		testContextSetup.log.info("verifying password updated success message is displayed!!");
		Assert.assertTrue(myAccountPage.isPasswordUpdatedSuccessMsgIsDisplayed(), "Password success msg is not displayed!");
		testContextSetup.log.info("verified password updated success message is displayed!!");
	}

	@When("User creates new account and landed on my Account page")
	public void user_creates_new_account_and_landed_on_my_account_page() {
		testContextSetup.log.info("creating new account and verifying user is landed on my account page!!");
		myAccountPage.createNewAccountAndLandOnMyAccountPage();
		testContextSetup.log.info("created new account and verified user is landed on my account page!!");
	}

	@When("User clicks on password right column option")
	public void user_clicks_on_password_right_column_option() {
		testContextSetup.log.info("clicking on right column password link!");
		myAccountPage.clickRightColumnPasswordLink();
		testContextSetup.log.info("clicked on right column password link!!");
	}

	@When("User clicks on change your password link")
	public void user_clicks_on_change_your_password_link() {
		testContextSetup.log.info("clicking on change your password link!!");
		myAccountPage.changeYourPasswordLink();
		testContextSetup.log.info("clicked on change your password link!!");
	}

	@Then("User can see success message and it should disappear after page refresh")
	public void user_can_see_success_message_and_it_should_disappear_after_page_refresh() {
		testContextSetup.log.info("verifying success message is disappearing after refresh!!");
		Assert.assertTrue(myAccountPage.verifySuccessMsgDisappearsAfterRefresh(), "Success message is still visible after refresh!");
		testContextSetup.log.info("verified success message is disappearing after refresh!!");
	}

	@Then("User is landed to myAccount page")
	public void user_is_landed_to_my_account_page() {
		testContextSetup.log.info("verifying my account page is loaded successfully!!");
		Assert.assertTrue(myAccountPage.userIsOnMyAccountPage(), "user is not landed on my Account page successfully!");
		testContextSetup.log.info("verified my account page is loaded successfully!!");
	}

	@Then("User can see success message “Success: Your account has been successfully updated.” should appear.")
	public void user_can_see_success_message_success_your_account_has_been_successfully_updated_should_appear() {
		testContextSetup.log.info("verifying account updated success message is displayed!!");
		Assert.assertTrue(myAccountPage.isAccountUpdatedSuccessMsgIsDisplayed(), "Account success msg is not displayed!");
		testContextSetup.log.info("verified account updated success message is displayed!!");
	}

	@When("User click on Edit your account information link")
	public void user_click_on_edit_your_account_information_link() {
		testContextSetup.log.info("clicking on edit your account information link!!");
		myAccountPage.clickEditYourAccountInfoLink();
		testContextSetup.log.info("clicked on edit your account information link!!");
	}

	@When("Verify the Page URL, Page Title and Page Heading is correct for My Account page")
	public void verify_the_page_url_page_title_and_page_heading_is_correct_for_my_account_page() {
		testContextSetup.log.info("verifying my account page details!!");
		Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle(), "myAccountPage title is not matching!");
		Assert.assertTrue(myAccountPage.verifyMyAccountPageHeading(), "myAccountPage heading is not displayed properly!");
		Assert.assertTrue(myAccountPage.isUserOnMyAccountPage(), "myAccountPage url is matching properly!");
		testContextSetup.log.info("verified my account page details!!");
	}

	@When("User can see my Account Page breadcrumb is displayed")
	public void user_can_see_my_account_page_breadcrumb_is_displayed() {
		testContextSetup.log.info("verifying my account page breadcrumb is displayed!!");
		Assert.assertTrue(myAccountPage.isMyAccountPageBreadcrumbIsDisplayed(), "myAccountPage breadcrumb is displayed properly!");
		testContextSetup.log.info("verified my account page breadcrumb is displayed!!");
	}
	@When("also my Account page breadcrumb should be working as per expected")
	public void also_my_account_page_breadcrumb_should_be_working_as_per_expected() {
		testContextSetup.log.info("clicking on my account page breadcrumb!!");
		myAccountPage.clickMyAccountPageBreadCrumb();
		testContextSetup.log.info("clicked on my account page breadcrumb!!");
	}

	@When("User click on order history link from my Account page")
	public void user_click_on_order_history_link_from_my_account_page() {
		testContextSetup.log.info("clicking on order history link!!");
		myAccountPage.clickOrderHistoryLink();
		testContextSetup.log.info("clicked on my order history link!!");
	}

	@When("User click on Wishlist header option")
	public void user_click_on_wishlist_header_option() {
		testContextSetup.log.info("clicking on wishlist header option!!");
		myAccountPage.clickWishListHeaderOption();
		testContextSetup.log.info("clicked on wishlist header option!!");
	}

	@Then("User should be taken to My Account page")
	public void user_should_be_taken_to_My_account_page() {
		testContextSetup.log.info("verifying my account page is displayed!!");
		Assert.assertTrue(myAccountPage.isOnMyAccountPage());
		testContextSetup.log.info("verified successfully my account page is displayed!!");
	}

	@When("User clicks on Subscribe unsubscribe to newsletter link on my Account Page")
	public void user_clicks_on_subscribe_unsubscribe_to_newsletter_link_on_my_account_page()
	{
		testContextSetup.log.info("clicking on subscribe unsubscribe link!!");
		myAccountPage.clickSubscribeUnsubscribeLink();
		testContextSetup.log.info("clicked on subscribe unsubscribe link!!");
	}

	@Then("User should get logged in and taken to account Page.")
	public void user_should_get_logged_in_and_taken_to_account_page() {
		testContextSetup.log.info("verifying logout button is displayed and user is landed on my Account page!!");
		Assert.assertTrue(myAccountPage.isUserLoggedIn(), "User not logged in!");
		testContextSetup.log.info("verified logout button is displayed and user is landed on my Account page!!");
	}

	@When("User clicks on logout option")
	public void user_clicks_on_logout_option() {
		testContextSetup.log.info("clicking on logout button from menu!!");
		myAccountPage.clickLogoutButtonFromMenu();
		testContextSetup.log.info("clicked on logout button from menu!!");
	}

	@When("User clicks on My Account Drop menu on MyAccountPage")
	public void user_clicks_on_my_account_drop_menu_on_my_account_page() throws InterruptedException {
		testContextSetup.log.info("clicking on my account drop menu!!");
		Thread.sleep(3000);
		testContextSetup.waitUtils.waitForPageLoad(5);
		myAccountPage.clickMyAccountDropMenu();
		testContextSetup.log.info("clicked on my account drop menu!!");
	}

	@Then("User should see Login option inplace of Logout under the My Account dropmenu")
	public void user_should_see_login_option_inplace_of_logout_under_the_my_account_dropmenu() {
		testContextSetup.log.info("verifying user can see login button inplace of logout if not logged in!!");
		testContextSetup.waitUtils.waitForPageLoad(5);
		myAccountPage.clickMyAccountDropMenu();
		Assert.assertTrue(myAccountPage.isLoginButtonDisplayed(),"Login button is not displaying!");
		testContextSetup.log.info("verified user can see login button inplace of logout if not logged in!!");
	}
	@When("User clicks logout option from right column")
	public void user_clicks_logout_option_from_right_column() {
		testContextSetup.log.info("clicking on logout from right column!!");
		myAccountPage.clickLogoutFromRightColumn();
		testContextSetup.log.info("clicked on logout from right column!!");
	}
	@Then("User should not see logout option under myAccount drop menu")
	public void user_should_not_see_logout_option_under_my_account_drop_menu() {
		List<String> options = myAccountPage.getMyAccountOptions();
		Assert.assertFalse(options.contains("Logout"), "Logout option is still visible in My Account dropdown!");
	}
	@Then("User must be logged in successfully")
	public void user_must_be_logged_in_successfully() {
		testContextSetup.log.info("verifying user is logged in and my account page is displayed!!");
		Assert.assertTrue(myAccountPage.isOnMyAccountPage(),"My Account page is not displayed!");
		testContextSetup.log.info("verified user is logged in and my account page is displayed!!");
	}
}
