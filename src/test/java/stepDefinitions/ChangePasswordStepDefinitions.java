package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ChangePasswordPage;
import testBase.TestContextSetup;

public class ChangePasswordStepDefinitions {

	TestContextSetup testContextSetup;
	ChangePasswordPage changePasswordPage;

	public ChangePasswordStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		changePasswordPage = testContextSetup.pageObjectManger.getChangePasswordPage();
	}

	@Then("Validate Heading, title, and Url of change password page")
	public void validate_heading_title_and_url_of_change_password_page() {
	    testContextSetup.log.info("Validating heading, title, and URL of the Change Password page...");
	    Assert.assertTrue(changePasswordPage.validateHeadingTitleAndURL(),
	            "Heading, title, or URL of Change Password page do not match expected values!");
	    testContextSetup.log.info("Heading, title, and URL of Change Password page validated successfully.");
	}

	@Then("User can see breadcrumb of change password page")
	public void user_can_see_breadcrumb_of_change_password_page() {
	    testContextSetup.log.info("Checking if breadcrumb is displayed on the Change Password page...");
	    Assert.assertTrue(changePasswordPage.isBreadCrumbIsDisplayed(),
	            "Breadcrumb is not displayed correctly on the Change Password page!");
	    testContextSetup.log.info("Breadcrumb is displayed properly on the Change Password page.");
	}

	@Then("breadcrumb of change password page is working properly")
	public void breadcrumb_of_change_password_page_is_working_properly() {
	    testContextSetup.log.info("Verifying functionality of breadcrumb on Change Password page...");
	    Assert.assertTrue(changePasswordPage.verifyBreadCrumbOFChangePasswordPage(),
	            "Breadcrumb navigation on Change Password page is not working properly!");
	    testContextSetup.log.info("Breadcrumb navigation on Change Password page verified successfully.");
	}

	@When("User click on browser back button")
	public void user_click_on_browser_back_button() {
	    testContextSetup.log.info("Clicking the browser back button on Change Password page...");
	    changePasswordPage.clickBrowserBackButton();
	    testContextSetup.log.info("Browser back button clicked successfully.");
	}

	@Then("User can see entered password and confirm password field lost the entered password")
	public void user_can_see_entered_password_and_confirm_password_field_lost_the_entered_password() {
	    testContextSetup.log.info("Verifying that password and confirm password fields are cleared after navigating back...");
	    Assert.assertTrue(changePasswordPage.verifyPasswordAndConfPasswordFieldIsEmpty(),
	            "Password and Confirm Password fields retained data after navigation!");
	    testContextSetup.log.info("Password and Confirm Password fields are cleared successfully after back navigation.");
	}

	@Then("Text entered into the password fields - password and password confirm should be toggled to hide its display instead of entered text user should see symbols")
	public void text_entered_into_the_password_fields_password_and_password_confirm_should_be_toggled_to_hide_its_display_instead_of_entered_text_user_should_see_symbols() {
	    testContextSetup.log.info("Verifying that password and confirm password fields mask the entered text with symbols...");
	    Assert.assertTrue(changePasswordPage.verifyPasswordAndConfPasswordFieldHidesVisibility(),
	            "Password and Confirm Password fields are not masking text as expected!");
	    testContextSetup.log.info("Password and Confirm Password fields correctly mask input visibility.");
	}

	@When("User can see all the fields are mandatory with star mark and colour of star is red")
	public void user_can_see_all_the_fields_are_mandatory_with_star_mark_and_colour_of_star_is_red() {
	    testContextSetup.log.info("Verifying presence and color (red) of mandatory asterisks on Change Password page fields...");
	    changePasswordPage.verifyMandatoryAsteriskOnChangePasswordLabels();
	    testContextSetup.log.info("Mandatory asterisks on all required fields are displayed correctly in red.");
	}

	@When("User enter new password in password field and enter different password in confirm password field")
	public void user_enter_new_password_in_password_field_and_enter_different_password_in_confirm_password_field() {
	    testContextSetup.log.info("Entering different values in Password and Confirm Password fields...");
	    changePasswordPage.enterChangePassword("admin");
	    changePasswordPage.enterChangeConfPassword("admin1");
	    testContextSetup.log.info("Different passwords entered in both fields successfully.");
	}

	@Then("Field level warning message should be displayed under the confirm password fields by not allowing the user to update the password")
	public void field_level_warning_message_should_be_displayed_under_the_confirm_password_fields_by_not_allowing_the_user_to_update_the_password() {
	    testContextSetup.log.info("Validating field-level warning message for mismatched Confirm Password field...");
	    Assert.assertTrue(changePasswordPage.isConfPasswordFieldLevelWarnignMessageDisplayed(),
	            "Field-level warning message not displayed for mismatched Confirm Password field!");
	    testContextSetup.log.info("Field-level warning message for Confirm Password mismatch displayed correctly.");
	}

	@When("User clicks on continue button on change password page")
	public void user_clicks_on_continue_button_on_change_password_page() {
	    testContextSetup.log.info("Clicking on Continue button on Change Password page...");
	    changePasswordPage.clickContinue();
	    testContextSetup.log.info("Continue button clicked successfully.");
	}

	@Then("Field level warning message should be displayed under the Password fields by not allowing the user to update the account with a blank password")
	public void field_level_warning_message_should_be_displayed_under_the_password_fields_by_not_allowing_the_user_to_update_the_account_with_a_blank_password() {
	    testContextSetup.log.info("Verifying field-level warning message for blank Password fields...");
	    Assert.assertTrue(changePasswordPage.isPasswordFieldLevelWarningMessageDisplayed(),
	            "Field-level warning message not displayed for blank Password field!");
	    testContextSetup.log.info("Field-level warning message for blank Password field displayed successfully.");
	}

	@Then("User should be navigated to change password page")
	public void user_should_be_navigated_to_change_password_page() {
	    testContextSetup.log.info("Checking if user is navigated to the Change Password page...");
	    Assert.assertTrue(changePasswordPage.userIsOnChangePasswordPage(),
	            "User was not navigated to the Change Password page!");
	    testContextSetup.log.info("User successfully navigated to Change Password page.");
	}

	@When("Enter new password into the Password and Passwrod Confirm fields")
	public void enter_new_password_into_the_password_and_passwrod_confirm_fields() {
	    testContextSetup.log.info("Entering matching values in Password and Confirm Password fields...");
	    changePasswordPage.enterChangePassword("admin");
	    changePasswordPage.enterChangeConfPassword("admin");
	    testContextSetup.log.info("Password and Confirm Password fields filled with matching values.");
	}

	@When("User click on continue button in change password page")
	public void user_click_on_continue_button_in_change_password_page() {
	    testContextSetup.log.info("Clicking on Continue button to submit Change Password form...");
	    changePasswordPage.clickContinue();
	    testContextSetup.log.info("Continue button clicked successfully for Change Password form.");
	}

	@When("User logout and login with old password")
	public void user_logout_and_login_with_old_password() {
	    testContextSetup.log.info("Logging out and attempting login with old password...");
	    changePasswordPage.logoutAndLoginWithOldPassword();
	    testContextSetup.log.info("Logout and login attempt with old password completed.");
	}

	@When("User Login with new password")
	public void user_login_with_new_password() {
	    testContextSetup.log.info("Logging in using the newly changed password...");
	    changePasswordPage.loginWithNewPassword();
	    testContextSetup.log.info("Login with new password completed successfully.");
	}

}
