package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.NewsletterSubscriptionPage;
import testBase.TestContextSetup;

public class NewsletterSubscriptionStepDefinitions {

	TestContextSetup testContextSetup;
	NewsletterSubscriptionPage newsletterSubscriptionPage;

	public NewsletterSubscriptionStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		newsletterSubscriptionPage = testContextSetup.pageObjectManger.getNewsletterSubscriptionPage();
	}

	@Then("Valiate correct Page URL, Page Heading and Page Title should be displayed in the Newsletter Subscription page")
	public void valiate_correct_page_url_page_heading_and_page_title_should_be_displayed_in_the_newsletter_subscription_page() {
		testContextSetup.log.info("Validating Newsletter Subscription page URL, title, and heading...");
		Assert.assertTrue(newsletterSubscriptionPage.verifyNewsLetterPageData(), "Newsletter Subscription page data is not matching!");
		testContextSetup.log.info("Validated Newsletter Subscription page details successfully.");
	}

	@Then("User should see breadcrumb of Newsletter subscription page and breadcrumb is working properly")
	public void user_should_see_breadcrumb_of_newsletter_subscription_page_and_breadcrumb_is_working_properly() {
		testContextSetup.log.info("Verifying breadcrumb display and functionality on Newsletter Subscription page...");
		Assert.assertTrue(newsletterSubscriptionPage.verifyBreadCrumbIsDisplayedAndWorking(), "Breadcrumb of Newsletter page is not working properly!");
		testContextSetup.log.info("Breadcrumb verified successfully on Newsletter Subscription page.");
	}

	@Then("User should be taken to Newsletter Subscription page and No radio option should be displayed as selected by default")
	public void user_should_be_taken_to_newsletter_subscription_page_and_no_radio_option_should_be_displayed_as_selected_by_default() {
		testContextSetup.log.info("Checking if 'No' radio option is selected by default on Newsletter Subscription page...");
		Assert.assertTrue(newsletterSubscriptionPage.userIsOnSubscriptionPageAndNoOptionIsSelectedByDefault(), "'No' option is not selected by default!");
		testContextSetup.log.info("'No' radio option verified as selected by default.");
	}

	@Then("User should be taken to Newsletter Subscription page and Yes radio option should be displayed as selected by default")
	public void user_should_be_taken_to_newsletter_subscription_page_and_yes_radio_option_should_be_displayed_as_selected_by_default() {
		testContextSetup.log.info("Checking if 'Yes' radio option is selected by default on Newsletter Subscription page...");
		Assert.assertTrue(newsletterSubscriptionPage.userIsOnSubscriptionPageAndYesOptionIsSelectedByDefault(), "'Yes' option is not selected by default!");
		testContextSetup.log.info("'Yes' radio option verified as selected by default.");
	}

	@Then("User click on continue button on newsLetter page")
	public void user_click_on_continue_button_on_news_letter_page() {
		testContextSetup.log.info("Clicking on 'Continue' button on Newsletter Subscription page...");
		newsletterSubscriptionPage.clickContinueBtn();
		testContextSetup.log.info("Clicked on 'Continue' button successfully.");
	}

	@When("Select Yes radio option if No is displayed as selected by default or Select No radio option if Yes is displayed as selected by default")
	public void select_yes_radio_option_if_no_is_displayed_as_selected_by_default_or_select_no_radio_option_if_yes_is_displayed_as_selected_by_default() {
		testContextSetup.log.info("Toggling Newsletter Subscription option (Yes/No) based on current selection...");
		Assert.assertTrue(newsletterSubscriptionPage.selectYesOrNoRadioButton(), "Default radio button option is not getting changed!");
		testContextSetup.log.info("Successfully toggled Newsletter Subscription option.");
	}

	@Then("User should be taken to Newsletter Subscription page and the Updated option should be displayed as selected")
	public void user_should_be_taken_to_newsletter_subscription_page_and_the_updated_option_should_be_displayed_as_selected() {
		testContextSetup.log.info("Verifying if the updated Newsletter Subscription option is displayed as selected...");
		Assert.assertTrue(newsletterSubscriptionPage.isUpdatedRadioButtonDisplayedAsSelected("yes"), "Updated radio button is not displayed as selected!");
		testContextSetup.log.info("Verified updated Newsletter Subscription option successfully.");
	}

	@When("User click back button present on newsletter subscription page")
	public void user_click_back_button_present_on_newsletter_subscription_page() {
		testContextSetup.log.info("Clicking on 'Back' button on Newsletter Subscription page...");
		newsletterSubscriptionPage.clickBakcButtonPresentOnPage();
		testContextSetup.log.info("Clicked on 'Back' button successfully.");
	}

	@Then("User should be taken to newsletter subscription page")
	public void user_should_be_taken_to_newsletter_subscription_page() {
		testContextSetup.log.info("Verifying if user is redirected to Newsletter Subscription page...");
		Assert.assertTrue(newsletterSubscriptionPage.isNewsLetterPageBreadCrumbIsDisplayed(),"User is not landed on Newsletter Subscription page!");
		testContextSetup.log.info("User successfully landed on Newsletter Subscription page.");
	}

	@Then("User should able to see Yes option should be displayed as selected by default in the Newsletter page")
	public void user_should_able_to_see_yes_option_should_be_displayed_as_selected_by_default_in_the_newsletter_page() {
		testContextSetup.log.info("Verifying 'Yes' radio button is selected by default...");
		Assert.assertTrue(newsletterSubscriptionPage.isYesRadioButtonSelected(),"'Yes' radio button should be selected, but it is not!");
		testContextSetup.log.info("'Yes' radio button is selected by default as expected.");
	}

	@Then("User should able to see no option should be displayed as selected by default in the Newsletter page")
	public void user_should_able_to_see_no_option_should_be_displayed_as_selected_by_default_in_the_newsletter_page() {
		testContextSetup.log.info("Verifying 'No' radio button is selected by default...");
		Assert.assertTrue(newsletterSubscriptionPage.isNoRadioButtonSelected(), "'No' radio button should be selected, but it is not!");
		testContextSetup.log.info("'No' radio button is selected by default as expected.");
	}
}
