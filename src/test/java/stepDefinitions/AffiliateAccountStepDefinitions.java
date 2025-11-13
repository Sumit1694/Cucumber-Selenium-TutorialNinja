package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AffiliateAccountPage;
import testBase.TestContextSetup;

public class AffiliateAccountStepDefinitions {

	TestContextSetup testContextSetup;
	AffiliateAccountPage affiliateAccountPage;

	public AffiliateAccountStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		affiliateAccountPage = testContextSetup.pageObjectManger.getAffiliateAccountPage();
	}

	@Then("User click Custom Affiliate Tracking Code link present under affiliate section and copy the valid tracking code")
	public void user_click_custom_affiliate_tracking_code_link_present_under_affiliate_section_and_copy_the_valid_tracking_code() {
	    testContextSetup.log.info("Attempting to copy the Custom Affiliate Tracking Code from the affiliate section...");
	    Assert.assertTrue(affiliateAccountPage.verifyCopyingCustomAffiliateTrackingCode(),
	            "Failed to copy the custom affiliate tracking code!");
	    testContextSetup.log.info("Successfully copied the Custom Affiliate Tracking Code.");
	}

	@When("User fill all fields in affiliate account page where payment method should be paypal with invalid emailID and submit")
	public void user_fill_all_fields_in_affiliate_account_page_where_payment_method_should_be_paypal_with_invalid_email_id_and_submit() {
	    testContextSetup.log.info("Filling all affiliate account fields with PayPal as payment method and invalid email ID...");
	    Assert.assertTrue(affiliateAccountPage.fillAllTheFieldsWherePaymentMethodPaypalWithInvalidEmailID(),
	            "PayPal payment method with invalid email validation failed!");
	    testContextSetup.log.info("Validation for invalid PayPal email ID executed successfully.");
	}

	@When("User fill all fields in affiliate account page where payment method should be paypal with valid emailID and submit")
	public void user_fill_all_fields_in_affiliate_account_page_where_payment_method_should_be_paypal_with_valid_email_id_and_submit() {
	    testContextSetup.log.info("Filling all affiliate account fields with PayPal as payment method and valid email ID...");
	    Assert.assertTrue(affiliateAccountPage.fillAllTheFieldsWherePaymentMethodPaypalWithValidEmailID(),
	            "PayPal payment method with valid email ID failed!");
	    testContextSetup.log.info("Affiliate form submitted successfully with valid PayPal details.");
	}

	@Then("User fill all fields in affiliate account page where payment method should be bank transfer and some fields of bank transfer must be empty and continue")
	public void user_fill_all_fields_in_affiliate_account_page_where_payment_method_should_be_bank_transfer_and_some_fields_of_bank_transfer_must_be_empty_and_continue() {
	    testContextSetup.log.info("Filling affiliate account with Bank Transfer method, leaving some fields empty...");
	    Assert.assertTrue(affiliateAccountPage.fillAllTheFieldsWherePaymentMethodBankFieldsShouldBeEmpty(),
	            "Warning messages for incomplete Bank Transfer fields not displayed!");
	    testContextSetup.log.info("Validation for incomplete Bank Transfer details displayed successfully.");
	}

	@Then("User will click edit affiliate account information link also user can change payment method everytime and get success message will be displayed")
	public void user_will_click_edit_affiliate_account_information_link_also_user_can_change_payment_method_everytime_and_get_success_message_will_be_displayed() {
	    testContextSetup.log.info("Editing affiliate account information and switching between payment methods...");
	    Assert.assertTrue(affiliateAccountPage.switchBetweenPaymentMethods(),
	            "Unable to switch between payment methods successfully!");
	    testContextSetup.log.info("Successfully switched between different payment methods and validated success message.");
	}

	@When("User will fill all data into affiliate Account fields and success message will be displayed")
	public void user_will_fill_all_data_into_affiliate_account_fields_and_success_message_will_be_displayed() {
	    testContextSetup.log.info("Filling all required affiliate account fields with valid data...");
	    Assert.assertTrue(affiliateAccountPage.fillAllTheFieldsInAffilateAccountPage(),
	            "Failed to fill all fields correctly in affiliate account page!");
	    testContextSetup.log.info("Affiliate account fields filled successfully and success message displayed.");
	}

	@Then("User will click edit affiliate account information link and chnage payment method and success message will be displayed")
	public void user_will_click_edit_affiliate_account_information_link_and_chnage_payment_method_and_success_message_will_be_displayed() {
	    testContextSetup.log.info("Editing affiliate account and changing payment method...");
	    Assert.assertTrue(affiliateAccountPage.EditInformationInAffiliateAccountPage(),
	            "Editing affiliate information or changing payment method failed!");
	    testContextSetup.log.info("Affiliate information updated successfully and success message verified.");
	}

	@Then("User enters company name of more than {int} characters and form should be submitted successfully")
	public void user_enters_company_name_of_more_than_characters_and_form_should_be_submitted_successfully(Integer chars) {
	    testContextSetup.log.info("Verifying company field behavior with more than " + chars + " characters...");
	    Assert.assertTrue(affiliateAccountPage.verifyCompanyFieldIsAcceptingMoreThanFiftyChars(),
	            "Company name field accepted more than " + chars + " characters unexpectedly!");
	    testContextSetup.log.info("Company name field validation for max length executed correctly.");
	}

	@Then("User enters company name of {int} characters and form should be submitted successfully")
	public void user_enters_company_name_of_characters_and_form_should_be_submitted_successfully(Integer NoOfChars) {
	    testContextSetup.log.info("Verifying company field accepts exactly " + NoOfChars + " characters...");
	    Assert.assertTrue(affiliateAccountPage.verifyCompanyFieldIsAcceptingFiftyChars(),
	            "Company field did not accept exactly " + NoOfChars + " characters!");
	    testContextSetup.log.info("Company name field accepted exactly " + NoOfChars + " characters successfully.");
	}

	@Then("User enters special characters in Tax field and fill all other details")
	public void user_enters_special_characters_in_tax_field_and_fill_all_other_details() {
	    testContextSetup.log.info("Checking validation for Tax ID field with special characters...");
	    Assert.assertTrue(affiliateAccountPage.verifyTaxIdFieldDoesNotAcceptSpecialChars(),
	            "Tax ID field accepted special characters unexpectedly!");
	    testContextSetup.log.info("Tax ID field correctly restricted special characters.");
	}

	@When("User enters all valid details into all the fields excepts accepting Terms and conditions")
	public void user_enters_all_valid_details_into_all_the_fields_excepts_accepting_terms_and_conditions() {
	    testContextSetup.log.info("Filling all affiliate fields except Terms and Conditions checkbox...");
	    Assert.assertTrue(affiliateAccountPage.fillAllTheFieldsExceptTearmsAndConditions(),
	            "Form submission succeeded even without accepting Terms and Conditions!");
	    testContextSetup.log.info("Terms and Conditions checkbox validation verified successfully.");
	}

	@Then("User should see appropriate validation message for tearms and conditions")
	public void user_should_see_appropriate_validation_message_for_tearms_and_conditions() {
	    testContextSetup.log.info("Verifying warning message for Terms and Conditions checkbox...");
	    Assert.assertTrue(affiliateAccountPage.isCheckBoxWarningMessageDisplayed(),
	            "Warning message for Terms and Conditions not displayed!");
	    testContextSetup.log.info("Warning message for Terms and Conditions displayed successfully.");
	}

	@When("User enters all valid details into all the fields")
	public void user_enters_all_valid_details_into_all_the_fields() {
	    testContextSetup.log.info("Entering all valid details into affiliate account form...");
	    Assert.assertTrue(affiliateAccountPage.fillAllTheFields(),
	            "Failed to fill all valid details in affiliate account form!");
	    testContextSetup.log.info("All affiliate account fields filled successfully with valid details.");
	}

	@When("User click continue without entering details")
	public void user_click_continue_without_entering_details() {
	    testContextSetup.log.info("Clicking Continue button without entering any details...");
	    affiliateAccountPage.clickContinueBtn();
	    testContextSetup.log.info("Continue button clicked without entering data.");
	}

	@Then("User should see validation messages should be shown for all required fields")
	public void user_should_see_validation_messages_should_be_shown_for_all_required_fields() {
	    testContextSetup.log.info("Verifying validation messages for all required fields...");
	    Assert.assertTrue(affiliateAccountPage.isAlertMsgDisplayed(),
	            "Validation messages for required fields not displayed!");
	    testContextSetup.log.info("Validation messages for required fields displayed correctly.");
	}

	@Then("User should be redirected to Affiliate Account page")
	public void user_should_be_redirected_to_affiliate_account_page() {
	    testContextSetup.log.info("Verifying redirection to Affiliate Account page...");
	    Assert.assertTrue(affiliateAccountPage.isAffiliateBreadcrumbIsDisplayed(),
	            "Affiliate Account breadcrumb not displayed. User not redirected correctly!");
	    testContextSetup.log.info("User successfully navigated to Affiliate Account page.");
	}

}
