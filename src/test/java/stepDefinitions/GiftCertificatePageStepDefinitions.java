package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GiftCertificatePage;
import testBase.TestContextSetup;

public class GiftCertificatePageStepDefinitions {

	TestContextSetup testContextSetup;
	GiftCertificatePage giftCertificatePage;

	public GiftCertificatePageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.giftCertificatePage = testContextSetup.pageObjectManger.getGiftCertificatePage();
	}

	@When("User fill all details in gift certificate page")
	public void user_fill_all_details_in_gift_certificate_page() {
		testContextSetup.log.info("filling all details in all the fields in gift certificate page!");
		Assert.assertTrue(giftCertificatePage.userFillAllDetailsInGiftCertificatePage(), "all details are not getting filled!");
		testContextSetup.log.info("filled successfully all the details in gift certificate page!");
	}

	@When("User fill all details in gift certificate page but amount is zero")
	public void user_fill_all_details_in_gift_certificate_page_but_amount_is_zero() {
		testContextSetup.log.info("filling all details in all the fields in gift certificate page with amount zero!");
		Assert.assertTrue(giftCertificatePage.userFillAllDetailsInGiftCertificatePageWithamountZero(), "amount field warning message is not displayed!");
		testContextSetup.log.info("filled successfully all details in all the fields in gift certificate page with amount zero!");
	}
	@Then("verify warning message for amount field")
	public void verify_warning_message_for_amount_field() {
		testContextSetup.log.info("verifying warning messages for amount field in gift certificate page!");
		Assert.assertTrue(giftCertificatePage.verifyWarningMessageForAmountField(), "amount field warning message is not displayed!");
		testContextSetup.log.info("verified warning messages for amount field in gift certificate page!");
	}

	@When("User fill all details in gift certificate page but recipient email is invalid")
	public void user_fill_all_details_in_gift_certificate_page_but_recipient_email_is_invalid() {
		testContextSetup.log.info("filling all details in all the fields in gift certificate page with invalid recepient email!");
		Assert.assertTrue(giftCertificatePage.userFillAllDetailsInGiftCertificatePageWithInvalidRecipientEmail(), "invalid recepient email is still accepting!");
		testContextSetup.log.info("filled all details in all the fields in gift certificate page with invalid email id!!");

	}
	@Then("verify warning message for Recipients Email field")
	public void verify_warning_message_for_recipients_email_field() {
		testContextSetup.log.info("verifying recepient email warning message in gift certificate page!");
		Assert.assertTrue(giftCertificatePage.verifyRecipientEmailWarningMessage(), "recepient warning message is not validated!");
		testContextSetup.log.info("recepient email warning message has been verified in gift certificate page!");
	}

	@Then("User should see a default theme Birthday or first option is selected by default")
	public void user_should_see_a_default_theme_birthday_or_first_option_is_selected_by_default() {
		testContextSetup.log.info("verifying gift theme first option is selected by default in gift certificate page!");
		Assert.assertTrue(giftCertificatePage.verifygiftThemeFirstOptionIsSelectedByDefault(), "first option is not selected by default!");
		testContextSetup.log.info("gift theme first option is selected by default has been verified in gift certificate page!");
	}

	@Then("User should be taken to Gift Certificate page")
	public void user_should_be_taken_to_gift_certificate_page() {
		testContextSetup.log.info("verifying user is landed in gift certificate page!");
		Assert.assertTrue(giftCertificatePage.userIsOnGiftCertificatePage(), "User is not landed on gift certificate page!");
		testContextSetup.log.info("user is landed on gift certificate page successfully!!");
	}

	@Then("User should see all the mandatory fields have star mark with red colour")
	public void user_should_see_all_the_mandatory_fields_have_star_mark_with_red_colour() {
		testContextSetup.log.info("verifying mandatory asterisk color for all the fields in gift certificate page!");
		Assert.assertTrue(giftCertificatePage.verifyMandatoryAsteriskColorForAllFields(), "User is not able to see mandatory asterisk symbol of red colour!");
		testContextSetup.log.info("verified mandatory asterisk color for all the fields in gift certificate page!");
	}

	@When("User fill all details in gift certificate page and leave Recipients Name field blank")
	public void user_fill_all_details_in_gift_certificate_page_and_leave_recipients_name_field_blank() {
		testContextSetup.log.info("user is filling all details in gift certificate page except recepient name!!");
		Assert.assertTrue(giftCertificatePage.userFillAllDetailsInGiftCertificatePageExceptRecipientName(), "User is not able to fill the gift certificate page details!");
		testContextSetup.log.info("filled all details in gift certificate page except recepient name!!");
	}
	@Then("verify warning message for Recipients Name field")
	public void verify_warning_message_for_recipients_name_field() {
		testContextSetup.log.info("verifying warning message for recepient name field!!");
		Assert.assertTrue(giftCertificatePage.verifyRecepientNameFieldWarningMessage(), "Recepient name warning message is not displayed!");
		testContextSetup.log.info("warning message for recepient name field has been verified!!");
	}




}
