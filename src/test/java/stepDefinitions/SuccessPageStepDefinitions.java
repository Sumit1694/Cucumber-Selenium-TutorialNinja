package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.SuccessPage;
import testBase.TestContextSetup;

public class SuccessPageStepDefinitions {

    TestContextSetup testContextSetup;
    SuccessPage successPage;

    public SuccessPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.successPage = testContextSetup.pageObjectManger.getsuccessPage();
    }

    @Then("User should be landed on account success page")
    public void user_should_be_landed_on_account_success_page() {
        testContextSetup.log.info("Verifying that the user has successfully landed on the Account Success page...");
        Assert.assertTrue(successPage.isOnsuccessPage(), "User is not landed on Success Page!");
        testContextSetup.log.info("User successfully landed on the Account Success page.");
    }

    @Then("Order should be placed and user should be taken to Success page")
    public void order_should_be_placed_and_user_should_be_taken_to_success_page() {
        testContextSetup.log.info("Verifying that the order is placed and Success page is displayed...");
        Assert.assertTrue(successPage.isSuccessPageBreadCrumbDisplayed(), "User is not on Success Page breadcrumb!");
        testContextSetup.log.info("Success Page breadcrumb is displayed.");
        Assert.assertTrue(successPage.isOrderPlacedSuccessMessageDisplayed(), "Order placed success message not displayed!");
        testContextSetup.log.info("Order placed successfully, and Success page displayed correctly.");
    }

    @Then("User should be logged in, taken to Account Succcess page and proper details should be displayed on the page")
    public void user_should_be_logged_in_taken_to_account_succcess_page_and_proper_details_should_be_displayed_on_the_page() {
        testContextSetup.log.info("Verifying all account creation success messages and page content...");
        Assert.assertTrue(successPage.isOnsuccessPage(), "User is not on Success Page!");
        testContextSetup.log.info("User is on Success Page.");

        Assert.assertEquals(successPage.getAccountCreatedHeading(), "Your Account Has Been Created!");
        testContextSetup.log.info("Verified: Account Created heading displayed.");

        Assert.assertEquals(successPage.getAccountSuccessMessage(), "Congratulations! Your new account has been successfully created!");
        testContextSetup.log.info("Verified: Account success message displayed.");

        Assert.assertEquals(successPage.getAdvantagesMessage(), "You can now take advantage of member privileges to enhance your online shopping experience with us.");
        testContextSetup.log.info("Verified: Advantages message displayed correctly.");

        Assert.assertEquals(successPage.getAnyQuestionMessage(), "If you have ANY questions about the operation of this online shop, please e-mail the store owner.");
        testContextSetup.log.info("Verified: Any question message displayed correctly.");

        Assert.assertEquals(successPage.getConfirmationSentMessage(), "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.");
        testContextSetup.log.info("Verified: Confirmation email message displayed correctly.");

        Assert.assertEquals(successPage.getContactUsParagraphLinkText(), "contact us");
        testContextSetup.log.info("Verified: Contact Us link text displayed correctly.");

        testContextSetup.log.info("All success messages and content verified successfully on the Account Success Page.");
    }

    @Then("User clicks on continue button on Account Success page")
    public void user_clicks_on_continue_button_on_account_success_page() {
        testContextSetup.log.info("Clicking on Continue button on Account Success page...");
        successPage.clickContinueButtonOnSuccessPage();
        testContextSetup.log.info("Clicked on Continue button successfully, proceeding to the next page.");
    }
}
