package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import testBase.TestContextSetup;

public class CheckOutPageStepDefinitions {

	TestContextSetup testContextSetup;
	CheckOutPage checkOutPage;

	 public CheckOutPageStepDefinitions(TestContextSetup testContextSetup) {
	        this.testContextSetup = testContextSetup;
	        this.checkOutPage = testContextSetup.pageObjectManger.getCheckOutPage();
	        testContextSetup.log.info("Initialized AddAddressStepDefinitions...");
	    }

	@Then("User should see gift certificate in checkout summary")
	public void user_should_see_gift_certificate_in_checkout_summary() {
		testContextSetup.log.info("Validating that gift certificate is displayed in checkout summary.");
		boolean landedOnWrongSection = checkOutPage.isUserOnCheckoutOrBillingDetailsSection();
		Assert.assertFalse(landedOnWrongSection, "Gift certificate not displayed in checkout summary!");
	}

	@Then("User User lands on Checkout page")
	public void user_user_lands_on_checkout_page() {
		testContextSetup.log.info("Verifying user is landed on Checkout page.");
		Assert.assertTrue(checkOutPage.userIsOnCheckOutPage(), "User is not on checkout page!");
	}

	@Then("User should see i want to use existing address radio btn is selected by default in delivery details section")
	public void user_should_see_i_want_to_use_existing_address_radio_btn_is_selected_by_default_in_delivery_details_section() {
		testContextSetup.log.info("Checking default selection of existing address radio button in delivery details section.");
		Assert.assertTrue(checkOutPage.isDeliveryAndBillingAddressRadioBtnIsSelectedByDefault(), "Existing address radio button not selected by default!");
	}

	@Then("User should be taken to billing details section")
	public void user_should_be_taken_to_billing_details_section() {
		testContextSetup.log.info("Verifying user is taken to Billing Details section.");
		Assert.assertTrue(checkOutPage.userIsOnBillingDetailsSection(), "User is not taken to billing details section!");
	}

	@Then("User should see i want to use an existing address checkbox should be displayed as selected as by default")
	public void user_should_see_i_want_to_use_an_existing_address_checkbox_should_be_displayed_as_selected_as_by_default() {
		testContextSetup.log.info("Validating existing address checkbox is selected by default in Billing Details section.");
		Assert.assertTrue(checkOutPage.isExistingAddressRadioButtonisSelectedByDefaultInBillingDetails(), "Existing address checkbox not selected by default!");
	}

	@When("User enters credentails of existing account in the Returning Customer section of the displayed checkout page {string} and {string}")
	public void user_enters_credentails_of_existing_account_in_the_returning_customer_section_of_the_displayed_checkout_page_and(String email, String password) {
		testContextSetup.log.info("Entering returning customer credentials: {}", email);
		checkOutPage.enterEmailInEmailFieldReturningCustomer(email);
		checkOutPage.enterPasswordInPasswordFieldReturningCustomer(password);
	}

	@When("User click login button")
	public void user_click_login_button() {
		testContextSetup.log.info("Clicking on Login button in Returning Customer section.");
		checkOutPage.clickLoginButtonReturningCustomer();
	}

	@When("User click on continue button in account and billing details")
	public void user_click_on_continue_button_in_account_and_billing_details() {
		testContextSetup.log.info("Clicking Continue button in Account and Billing Details section.");
		checkOutPage.clickContinueAccountAndRegister();
	}

	@When("User enters your personal details and your address in account and billing details section")
	public void user_enters_your_personal_details_and_your_address_in_account_and_billing_details_section() {
		testContextSetup.log.info("Filling all personal and address details in Billing Details section.");
		checkOutPage.fillAllDetailsIntoAllTheFields();
	}

	@Then("User should see My delivery and billing addresses are the same checkbox is selected by default for account and billing details section")
	public void user_should_see_my_delivery_and_billing_addresses_are_the_same_checkbox_is_selected_by_default_for_account_and_billing_details_section() {
		testContextSetup.log.info("Validating 'My delivery and billing address are the same' checkbox is selected by default.");
		Assert.assertTrue(checkOutPage.isDeliveryAndBillingAddressRadioBtnIsSelectedByDefault(), "Checkbox not selected by default!");
	}

	@Then("User should be taken to accounts and billing detail section")
	public void user_should_be_taken_to_accounts_and_billing_detail_section() {
		testContextSetup.log.info("Verifying user is on Account and Billing Details section.");
		Assert.assertTrue(checkOutPage.userIsOnAccountAndBillingDetailsSection(), "User not on account and billing details section!");
	}

	@When("User select Register Account option in the new customer section of the displayed checkout page")
	public void user_select_register_account_option_in_the_new_customer_section_of_the_displayed_checkout_page() {
		testContextSetup.log.info("Selecting 'Register Account' option in New Customer section.");
		checkOutPage.userSelectsRegisterAccountBtn();
	}

	@Then("User should be taken to confirm order section")
	public void user_should_be_taken_to_confirm_order_section() {
		testContextSetup.log.info("Validating user reached Confirm Order section.");
		Assert.assertTrue(checkOutPage.userIsOnConfirmOrderSection(), "User not on confirm order section!");
	}

	@Then("User should be taken to Payment Method section")
	public void user_should_be_taken_to_payment_method_section() {
		testContextSetup.log.info("Verifying user reached Payment Method section.");
		Assert.assertTrue(checkOutPage.userIsOnPaymentMethodSection(), "Payment method section not displayed!");
	}

	@Then("User must see cash On delivery radio button should be displayed as selected by default")
	public void user_must_see_cash_on_delivery_radio_button_should_be_displayed_as_selected_by_default() {
		testContextSetup.log.info("Checking if 'Cash On Delivery' option is selected by default in Payment Method section.");
		Assert.assertTrue(checkOutPage.isCashOnDeliveryRadioBtnisSelectedByDefault(), "Cash On Delivery not selected by default!");
	}

	@Then("User should be taken to delivery method section")
	public void user_should_be_taken_to_delivery_method_section() {
		testContextSetup.log.info("Verifying user reached Delivery Method section.");
		Assert.assertTrue(checkOutPage.userIsOnDeliveryMethodSection(), "Delivery method section not displayed!");
	}

	@Then("User click on continue button on billing details your personal details and your address section")
	public void user_click_on_continue_button_on_billing_details_your_personal_details_and_your_address_section() {
		testContextSetup.log.info("Clicking Continue on Billing Details section.");
		checkOutPage.clickContinueBtnBillingDetailsSection();
	}

	@When("User enters your personal details and your address")
	public void user_enters_your_personal_details_and_your_address() {
		testContextSetup.log.info("Entering mandatory Personal Details and Address fields.");
		checkOutPage.fillAllDetailsIntoMandatoryFields();
	}

	@Then("User should be taken to billing detail section")
	public void user_should_be_taken_to_billing_detail_section() {
		testContextSetup.log.info("Verifying user is taken to Billing Details section.");
		Assert.assertTrue(checkOutPage.userIsOnBillingDetailsSection(), "User not on billing details section!");
	}

	@Then("User should see my delivery and billing addresses are the same checkbox should be displayed as selected by default")
	public void user_should_see_my_delivery_and_billing_addresses_are_the_same_checkbox_should_be_displayed_as_selected_by_default() {
		testContextSetup.log.info("Checking 'My delivery and billing addresses are the same' checkbox default selection.");
		Assert.assertTrue(checkOutPage.myDeliveryAndBillingAddressIsCheckedByDefault(), "Checkbox not selected by default!");
	}

	@When("User select guest checkout option in the new customer section of the displayed checkout page")
	public void user_select_guest_checkout_option_in_the_new_customer_section_of_the_displayed_checkout_page() {
		testContextSetup.log.info("Selecting 'Guest Checkout' option in New Customer section.");
		checkOutPage.clickGuestRadioBtn();
	}

	@When("User click on continue button in the checkout option section")
	public void user_click_on_continue_button_in_the_checkout_option_section() {
		testContextSetup.log.info("Clicking Continue button in New Customer section.");
		checkOutPage.clickContinueBtnNewCustomerSection();
	}

	@Then("User can see checkout page should be displayed")
	public void user_can_see_checkout_page_should_be_displayed() {
		testContextSetup.log.info("Validating Checkout page breadcrumb is displayed.");
		Assert.assertTrue(checkOutPage.userIsOnCheckOutPageBreadcrumb(), "Checkout page not displayed!");
	}

	@Then("User add comment in comment box displayed in payment method section")
	public void user_add_comment_in_comment_box_displayed_in_payment_method_section() {
		testContextSetup.log.info("Adding comment in Payment Method section.");
		checkOutPage.addCommentInPaymentMethodSection();
	}

	@Then("User click on continue button on delivery details section")
	public void user_click_on_continue_button_on_delivery_details_section() {
		testContextSetup.log.info("Clicking Continue in Delivery Details section.");
		checkOutPage.clickDeliveryDetailsSection();
	}

	@When("User enters any text into the Add Comments About Your Order text field")
	public void user_enters_any_text_into_the_add_comments_about_your_order_text_field() {
		testContextSetup.log.info("Entering text into 'Add Comments About Your Order' field.");
		checkOutPage.addTextToAboutYourOrderText();
	}

	@Then("User comment entered should be displayed as it is in the payment method section")
	public void user_comment_entered_should_be_displayed_as_it_is_in_the_payment_method_section() {
		testContextSetup.log.info("Verifying comment consistency from Delivery Method to Payment Method section.");
		Assert.assertTrue(checkOutPage.verifyCommentFromPaymentMethodSectionToPaymentMethodSection(), "Comment mismatch in payment method section!");
	}

	@Then("User must see proper field level warning messages should be displayed for all the mandatory fields in the Delivery Details section")
	public void user_must_see_proper_field_level_warning_messages_should_be_displayed_for_all_the_mandatory_fields_in_the_delivery_details_section() {
		testContextSetup.log.info("Validating mandatory field warning messages in Delivery Details section.");
		Assert.assertTrue(checkOutPage.verifyAllMandatoryFieldsHaveWarningMessagesOfDeliveryDetails(), "Warning messages are missing in Delivery Details section!");
	}

	@Then("User can see proper placeholder text are displayed for all the address details fields in delivery details section")
	public void user_can_see_proper_placeholder_text_are_displayed_for_all_the_address_details_fields_in_delivery_details_section() {
		testContextSetup.log.info("Verifying placeholder texts for all fields in Delivery Details section.");
		Assert.assertTrue(checkOutPage.verifyAllDeliveryDetailsFieldHavePlaceholders(), "Placeholders missing in Delivery Details section!");
	}

	@When("User enter new address details only into the all fields")
	public void user_enter_new_address_details_only_into_the_all_fields() {
		testContextSetup.log.info("Entering new address details in all fields of Delivery Details section.");
		checkOutPage.enterAllNewDeliveryDetailsAddress("India", "Bihar");
	}

	@When("User enter new address details only into the mandatory fields")
	public void user_enter_new_address_details_only_into_the_mandatory_fields() {
		testContextSetup.log.info("Entering only mandatory address fields in Delivery Details section.");
		checkOutPage.enterNewDeliveryDetailsAddress("India", "Bihar");
	}

	@When("User select i want to use a new address radio delivery details option")
	public void user_select_i_want_to_use_a_new_address_radio_delivery_details_option() {
		testContextSetup.log.info("Selecting 'I want to use a new address' radio option in Delivery Details section.");
		checkOutPage.selectIWantToUseNewAddressDetailsRadioBtn();
	}

	@Then("User can see new address fields are displayed in the Delivery details section")
	public void user_can_see_new_address_fields_are_displayed_in_the_delivery_details_section() {
		testContextSetup.log.info("Validating visibility of new address fields in Delivery Details section.");
		Assert.assertTrue(checkOutPage.isNewAddressFieldsDisplayedInDeliveryDetailsSection(), "New address fields are not displayed in Delivery Details section!");
	}

	@Then("User must see proper field level warning messages should be displayed for all the mandatory fields in the Billing Details section")
	public void user_must_see_proper_field_level_warning_messages_should_be_displayed_for_all_the_mandatory_fields_in_the_billing_details_section() {
		testContextSetup.log.info("Validating mandatory field warning messages in Billing Details section.");
		Assert.assertTrue(checkOutPage.verifyAllMandatoryFieldsHaveWarningMessages(), "Warning messages are missing in Billing Details section!");
	}

	@Then("User can see proper placeholder text are displayed for all the address details fields")
	public void user_can_see_proper_placeholder_text_are_displayed_for_all_the_address_details_fields() {
		testContextSetup.log.info("Verifying placeholder texts for all fields in Billing Details section.");
		Assert.assertTrue(checkOutPage.verifyAllBillingFieldHavePlaceholders(), "Placeholders missing in Billing Details section!");
	}

	@When("User enters all details into new Address fields in billing address section")
	public void user_enters_all_details_into_new_address_fields_in_billing_address_section() {
		testContextSetup.log.info("Entering complete new address details in Billing Details section.");
		checkOutPage.enterAllNewBillingAddress("India", "Goa");
	}

	@Then("I want to use an existing address radio option should be displayed as selected by default in the Delivery Details section and all new address details should be displayed in the text field")
	public void i_want_to_use_an_existing_address_radio_option_should_be_displayed_as_selected_by_default_in_the_delivery_details_section_and_all_new_address_details_should_be_displayed_in_the_text_field() {
		testContextSetup.log.info("Verifying default selection of existing address and pre-filled new address details in Delivery Details section.");
		Assert.assertTrue(checkOutPage.existingAddressDeliveryDetailsRadioButtonSelectedByDefault(), "Existing address radio option not selected by default!");
		Assert.assertTrue(checkOutPage.getExistingNewAddressDeliveryDetails(), "New address details not displayed correctly!");
	}

	@When("User enters mandatory details into new Address fields in billing address section")
	public void user_enters_mandatory_details_into_new_address_fields_in_billing_address_section() {
		testContextSetup.log.info("Entering only mandatory address fields in Billing Details section.");
		checkOutPage.enterNewBillingAddress("India", "Goa");
	}

	@Then("User can see new address fields are displayed in the billing section")
	public void user_can_see_new_address_fields_are_displayed_in_the_billing_section() {
		testContextSetup.log.info("Validating visibility of new address fields in Billing Details section.");
		Assert.assertTrue(checkOutPage.isNewAddressFieldsDisplayedInBillingDetailsSection(), "New address fields are not displayed in Billing Details section!");
	}

	@When("User click on i want to use new address radio button")
	public void user_click_on_i_want_to_use_new_address_radio_button() {
		testContextSetup.log.info("Clicking on 'I want to use new address' radio button in Billing Details section.");
		checkOutPage.clickNewAddressRadioBtn();
	}

	@When("User click on confirm order button")
	public void user_click_on_confirm_order_button() {
		testContextSetup.log.info("Clicking on 'Confirm Order' button.");
		checkOutPage.clickConfirmOrderButton();
	}

	@Then("User is landed to checkout page")
	public void user_is_landed_to_checkout_page() {
		testContextSetup.log.info("Verifying user is on Checkout page.");
		Assert.assertTrue(checkOutPage.userIsOnCheckOutPage(), "User is not landed on Checkout page!");
	}

	@When("User click on continue button on billing details section")
	public void user_click_on_continue_button_on_billing_details_section() {
		testContextSetup.log.info("Clicking 'Continue' on Billing Details section.");
		checkOutPage.clickContinueButtonBiilingDetails();
	}

	@When("User click on Continue button on delivery details section")
	public void user_click_on_button_on_delivery_details_section() {
		testContextSetup.log.info("Clicking 'Continue' on Delivery Details section.");
		checkOutPage.clickDeliveryDetailsContinueBtn();
	}

	@Then("{string} radio option should be displayed as selected by default in the Delivery Method section")
	public void radio_option_should_be_displayed_as_selected_by_default_in_the_delivery_method_section(String flatShippingRateText) {
		testContextSetup.log.info("Verifying '{}' option is selected by default in Delivery Method section.", flatShippingRateText);
		Assert.assertTrue(checkOutPage.isDeliveryMethodRadioButtonSelected(), "Flat Shipping Rate option not selected by default!");
	}

	@When("User click on Continue button on delivery method section")
	public void user_click_on_continue_button_on_delivery_method_section() {
		testContextSetup.log.info("Clicking 'Continue' on Delivery Method section.");
		checkOutPage.clickContinueButtonDeliveryMethodSection();
	}

	@Then("{string} radio option should be displyaed as selected by default in the Payment Method section")
	public void radio_option_should_be_displyaed_as_selected_by_default_in_the_payment_method_section(String CashOnDelivery) {
		testContextSetup.log.info("Verifying '{}' option is selected by default in Payment Method section.", CashOnDelivery);
		Assert.assertTrue(checkOutPage.isCashOnDeliveryRadioBtnSelected(), "Cash On Delivery option not selected by default!");
	}

	@Then("Select the Terms & Conditions checkbox field")
	public void select_the_terms_conditions_checkbox_field() {
		testContextSetup.log.info("Selecting Terms & Conditions checkbox.");
		checkOutPage.selectCheckBoxTermsAndConditions();
	}

	@Then("User click on continue button on payment method section")
	public void user_click_on_continue_button_on_payment_method_section() {
		testContextSetup.log.info("Clicking 'Continue' on Payment Method section.");
		checkOutPage.clickContinueBtnOfPaymentMethod();
	}

	@Then("User can see Proper details displayed in the Confirm Order section")
	public void user_can_see_proper_details_displayed_in_the_confirm_order_section() {
		testContextSetup.log.info("Validating details displayed in Confirm Order section.");
		Assert.assertTrue(checkOutPage.verifyConfirmOrderTableDisplayed(), "Confirm Order section details not displayed correctly!");
	}
}
