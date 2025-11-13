package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ContactUsPage;
import testBase.TestContextSetup;

public class ContactUsPageStepDefinitions {

	TestContextSetup testContextSetup;
	ContactUsPage contactUsPage;

	public ContactUsPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.contactUsPage = testContextSetup.pageObjectManger.getContactUsPage();
	}

	@Then("User should see correct Page URL, Page Heading and Page Title should be displayed in the Contact Us page.")
	public void user_should_see_correct_page_url_page_heading_and_page_title_should_be_displayed_in_the_contact_us_page() {
		testContextSetup.log.info("verifying page url, heading, and on contact us page!");
	    Assert.assertTrue(contactUsPage.verifyContactUsPageDetails(), "Contact us page details are not matching!");
	    testContextSetup.log.info("page url, heading, and on contact us page has been verified!");
	}

	@Then("User should see breadCrumb of contactUs page")
	public void user_should_see_bread_crumb_of_contact_us_page() {
		testContextSetup.log.info("verifying breadcrumb on contact us page!");
		Assert.assertTrue(contactUsPage.verifyBreadCrumbOfContactUsPage(), "Breadcrumb of contact us page is not displayed!");
		testContextSetup.log.info("breadcrumb on contact us page has been verified!");
	}

	@When("User enters enquiry text in enquiry field")
	public void user_enters_enquiry_text_in_enquiry_field() {
		testContextSetup.log.info("enterting enquiry text in enquiry field!");
		Assert.assertTrue(contactUsPage.EnterEnquiryTextInEnquiryField(), "User is not able to enter text into enquiry text field!");
		testContextSetup.log.info("enquiry text is entered successfully in enquiry field!");
	}
	@When("User click on submit")
	public void user_click_on_submit() {
		testContextSetup.log.info("clicking on submit button!");
		contactUsPage.clickSubmitBtn();
		testContextSetup.log.info("clicked successfully on submit button!");
	}
	@Then("User must see success Message with text Your Enquiry has been Submitted should be displayed")
	public void user_must_see_success_message_with_text_your_enquiry_has_been_submitted_should_be_displayed() {
		testContextSetup.log.info("verifying success message on contact us page!");
		Assert.assertTrue(contactUsPage.verifySuccessMessageForContactUs(), "success message is not displayed for contact us form!");
		testContextSetup.log.info("success message has been verified on contact us page!");
	}

	@Then("User should see logged in user name and email address in contact Us page")
	public void user_should_see_logged_in_user_name_and_email_address_in_contact_us_page() {
		testContextSetup.log.info("verifying logged in name and email present on contact us page!");
		Assert.assertTrue(contactUsPage.verifyLoggedInNameAndEmailPresentInContactUsPage(), "Logged in name and email are not matching under contact us page!");
		testContextSetup.log.info("logged in name and email present on contact us page has been verified!");
	}

	@Then("User fill all fields in contactUs page with invalid email input then email field level warning message should be displayed")
	public void user_fill_all_fields_in_contact_us_page_with_invalid_email_input_then_email_field_level_warning_message_should_be_displayed() {
		testContextSetup.log.info("verifying invalid email input warning message on contact us page!");
		 Assert.assertTrue(contactUsPage.verifyInvalidEmailInputWarningMessages(), "Invalid email inputs are getting accepted in contactUs form!");
		 testContextSetup.log.info("invalid email input warning message on contact us page has been verified!");
	}

	@When("User click submit button")
	public void user_click_submit_button() {
		testContextSetup.log.info("clicking on submit button!");
		contactUsPage.clickSubmitBtn();
		testContextSetup.log.info("clicked successfully on submit button!");
	}
	@Then("All fields level messages should be displayed for mandatory text fields")
	public void all_fields_level_messages_should_be_displayed_for_mandatory_text_fields() {
		testContextSetup.log.info("verifying all field level warning messages in contact us page!");
	    Assert.assertTrue(contactUsPage.verifyAllFieldLevelWarningMessages(), "Field level warning messages are not displayed!");
	    testContextSetup.log.info("All field level warning messages has been verified in contact us page!");
	}

	@When("User fill all details in the contact us form and submit")
	public void user_fill_all_details_in_the_contact_us_form_and_submit() {
		testContextSetup.log.info("filling all details in contact us page!");
		Assert.assertTrue(contactUsPage.userFillAllDetailsInContactUsField(), "User is not able to fill all the fields in contact us form!");
		testContextSetup.log.info("all details in contact us page has been successfully added!");
	}
	@Then("User should see success message with text {string} should be displayed")
	public void user_should_see_success_message_with_text_should_be_displayed(String string) {
		testContextSetup.log.info("verifying success message in contact us page!");
		Assert.assertTrue(contactUsPage.verifySuccessMessageForContactUs(), "User is not see success message for contact us form filled!");
		testContextSetup.log.info("success message is verified in contact us page!");
	}
	@When("User click continue button")
	public void user_click_continue_button() {
		testContextSetup.log.info("clicking on continue button in contact us page!");
		contactUsPage.clickContinueBtn();
		testContextSetup.log.info("clicked successfully on continue button in contact us page!");
	}

	@Then("User should see all the text fields are marked with star symbol as mandatory")
	public void user_should_see_all_the_text_fields_are_marked_with_star_symbol_as_mandatory() {
		testContextSetup.log.info("verifying red asterisk mark for all mandatory fields in contact us page!");
		Assert.assertTrue(contactUsPage.verifyRedAsteriskPresenceForMandatoryFields(), "Red asterisk symbols are not present for mandatory fields!");
		testContextSetup.log.info("red asterisk mark for all mandatory fields in contact us page has been verified!");
	}

	@Then("User should be taken to Contact Us page")
	public void user_should_be_taken_to_contact_us_page() {
		testContextSetup.log.info("verifying user is landed on contact us page!");
		Assert.assertTrue(contactUsPage.verifyBreadCrumbOfContactUsPage(), "User is not landed on contactUs Page!");
		testContextSetup.log.info("user is landed successfully on contact us page!");
	}

	@Then("User should see Our Location and Contact Form on contact us page")
	public void user_should_see_our_location_and_contact_form_on_contact_us_page() {
		testContextSetup.log.info("verifying contact us page details!");
		Assert.assertTrue(contactUsPage.verifyContactUsPageDetails(), "Contact us page details are not showing correctly!");
		testContextSetup.log.info("contact us page details has been verified!");
	}


}
