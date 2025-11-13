package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EditYourInformationPage;
import testBase.TestContextSetup;

public class EditYourInformationStepDefinitions {

	TestContextSetup testContextSetup;
	EditYourInformationPage editYourInformationPage;

	public EditYourInformationStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		editYourInformationPage = testContextSetup.pageObjectManger.getEditYourInformationPage();
	}

	@Then("User can see url {string} in address bar")
	public void user_can_see_url_in_address_bar(String urlOfEditYourInformationPage) {
		testContextSetup.log.info("fetching current url of edit your information page!");
	    Assert.assertEquals(editYourInformationPage.getCurrentUrlOfEditYourInformationPage(), urlOfEditYourInformationPage, "Url of edit your information page is not matching!");
	    testContextSetup.log.info("successfully fetched current url of edit your information page!");
	}

	@Then("User click browser back button on account information page")
	public void user_click_browser_back_button_on_account_information_page() {
		testContextSetup.log.info("click on browser back button on edit your information page!");
		editYourInformationPage.clickBrowserBackButton();
		testContextSetup.log.info("clicked successfully on browser back button on edit your information page!");
	}

	@When("User clear all the fields displayed in Edit your account information link")
	public void user_clear_all_the_fields_displayed_in_edit_your_account_information_link() {
		testContextSetup.log.info("make all fields empty on edit your information page!");
		editYourInformationPage.makeAllFieldsEmpty();
		testContextSetup.log.info("all fields are empty on edit your information page!");
	}
	@Then("User can see validation messages for all the fields")
	public void user_can_see_validation_messages_for_all_the_fields() {
		testContextSetup.log.info("verifying all the fields warning messages are displayed correctly!");
		Assert.assertTrue(editYourInformationPage.verifyAllFieldsValidationMsgDisplayed(), "All field validation msg are not displayed properly!");
		testContextSetup.log.info("all fields warning messages are displayed successfully!");
	}

	@Then("User can able to proceed with blank telephone field")
	public void user_can_able_to_proceed_with_blank_telephone_field() {
		testContextSetup.log.info("making telephone field empty!");
		editYourInformationPage.makeTelephoneFieldEmpty();
		testContextSetup.log.info("telephone field empty!");
	}
	@Then("User can see validation message for telephone field")
	public void user_can_see_validation_message_for_telephone_field() {
		testContextSetup.log.info("verifying telephone validation message is displayed!");
	    Assert.assertTrue(editYourInformationPage.isTelephoneValidationMsgDisplayed(), "Telephone field validation msg is not displayed!");
	    testContextSetup.log.info("telephone validation message is displayed!");
	}

	@Then("User cannot add characters in telephone field validates the correct behaviour")
	public void user_cannot_add_characters_in_telephone_field() {
		testContextSetup.log.info("verifying telephone field is validating characters!");
		Assert.assertTrue(editYourInformationPage.isTelephoneFieldValidatesCharacters(), "telephone field is not validating characters!");
		testContextSetup.log.info("telephone field is validating characters has been verified!");
	}

	@Then("User can see error message for email field")
	public void user_can_see_error_message_for_email_field() {
		testContextSetup.log.info("verifying invalid email warning message has been displayed in edit your information page!");
		Assert.assertTrue(editYourInformationPage.isInvalidEmailValidationMessageDisplayed(), "error message is not dispalyed for email field!");
		testContextSetup.log.info("invalid email warning message has been displayed has been verified in edit your information page!");
	}

	@Then("User can change his email in email field to wrong email format")
	public void user_can_change_his_email_in_email_field_to_wrong_email_format() {
		testContextSetup.log.info("updating email field with wrong email format in edit your information page!");
		editYourInformationPage.updateEmailWithWrongEmailFormatInField();
		testContextSetup.log.info("updated successfully email field with wrong email format in edit your information page!");
	}

	@Then("User can change his email in email field")
	public void user_can_change_his_email_in_email_field() {
		testContextSetup.log.info("updating email field in edit your information page!");
		editYourInformationPage.updateEmailField();
		testContextSetup.log.info("email field has been updated in edit your information page!");
	}

	@Then("User can change his last name in lastName field")
	public void user_can_change_his_last_name_in_last_name_field() {
		testContextSetup.log.info("updating last name in edit your information page!");
		editYourInformationPage.updateLastNameField();
		testContextSetup.log.info("last name is updated in edit your information page!");
	}

	@Then("User can change his first name in firstname field")
	public void user_can_change_his_first_name_in_firstname_field() {
		testContextSetup.log.info("updating first name in edit your information page!");
		editYourInformationPage.updateFirstNameField();
		testContextSetup.log.info("first name is updated in edit your information page!");
	}
	@Then("User click continue button in your personal details sections")
	public void user_click_continue_button_in_your_personal_details_sections() {
		testContextSetup.log.info("clicking on continue button on edit your information page!");
		editYourInformationPage.clickContinueBtn();
		testContextSetup.log.info("clicked successfully on continue button on edit your information page!");
	}

	@Then("All input fields should be pre-filled with current account data.")
	public void all_input_fields_should_be_pre_filled_with_current_account_data() {
		testContextSetup.log.info("verifying all the fields are prefilled with existing data on edit your information page!");
		Assert.assertTrue(editYourInformationPage.verifyAllFieldsArePrefilledWithExistingData(), "Some fields might have wrong data!");
		testContextSetup.log.info("all the fields are prefilled with existing data on edit your information page has been verified!");
	}

	@Then("My Account Information page should open successfully")
	public void my_account_information_page_should_open_successfully() {
		testContextSetup.log.info("verifying user is on edit your information page!");
		Assert.assertTrue(editYourInformationPage.userIsOnEditYourInfoPage(), "User is not on edit your information page!");
		testContextSetup.log.info("user is on edit your information page!");
	}

	@Then("First Name, Last Name, E-Mail, and Telephone should be visible.")
	public void first_name_last_name_e_mail_and_telephone_should_be_visible() {
		testContextSetup.log.info("verifying all fields are visible in edit your information page!");
		Assert.assertTrue(editYourInformationPage.areAllFieldVisibleInEditYourInformationPage(), "All field are not visible in edit your information page!");
		testContextSetup.log.info("all fields are visible in edit your information page!");
	}

}
