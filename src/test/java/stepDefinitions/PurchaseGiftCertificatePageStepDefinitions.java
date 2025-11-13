package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.PurchaseGiftCertificatePage;
import testBase.TestContextSetup;

public class PurchaseGiftCertificatePageStepDefinitions {

    TestContextSetup testContextSetup;
    PurchaseGiftCertificatePage purchaseGiftCertificatePage;

    public PurchaseGiftCertificatePageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.purchaseGiftCertificatePage = testContextSetup.pageObjectManger.getPurchaseGiftCertificatePage();
    }

    @Then("verify success message for gift certificate")
    public void verify_success_message_for_gift_certificate() {
        testContextSetup.log.info("Verifying success message displayed after purchasing gift certificate...");
        Assert.assertTrue(purchaseGiftCertificatePage.verifyGiftCeritificateSuccessMsg(),"Success message is not displayed for purchasing gift certificate!");
        testContextSetup.log.info("Success message verified successfully for gift certificate purchase.");
    }

    @Then("User click continue button on purchase gift certificate page")
    public void user_click_continue_button_on_purchase_gift_certificate_page() {
        testContextSetup.log.info("Clicking on 'Continue' button on Purchase Gift Certificate page...");
        purchaseGiftCertificatePage.clickContinueBtn();
        testContextSetup.log.info("Successfully clicked on 'Continue' button on Purchase Gift Certificate page.");
    }
}
