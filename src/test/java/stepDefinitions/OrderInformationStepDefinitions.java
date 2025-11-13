package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OrderInformationPage;
import testBase.TestContextSetup;

public class OrderInformationStepDefinitions {

    TestContextSetup testContextSetup;
    OrderInformationPage orderInformationPage;

    public OrderInformationStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.orderInformationPage = testContextSetup.pageObjectManger.getOrderInformationPage();
    }

    @Then("User must be navigated to order information page")
    public void user_must_be_navigated_to_order_information_page() {
        testContextSetup.log.info("Verifying that user is navigated to Order Information page...");
        Assert.assertTrue(
            orderInformationPage.isOrderInformationBreadCrumbIsDisplayed(),
            "User is not landed on the Order Information page!"
        );
        testContextSetup.log.info("User successfully navigated to Order Information page.");
    }

    @Then("User should be redirected to the order information page showing all order details")
    public void user_should_be_redirected_to_the_order_information_page_showing_all_order_details() {
        testContextSetup.log.info("Validating Order Information page and order details visibility...");
        Assert.assertTrue(
            orderInformationPage.isOrderInformationBreadCrumbIsDisplayed(),
            "User is not landed on the Order Information page!"
        );
        testContextSetup.log.info("Order Information page is displayed with order details.");
    }

    @When("User click browser back button")
    public void user_click_browser_back_button() {
        testContextSetup.log.info("User clicks the browser back button...");
        orderInformationPage.clickBrowserBackButton();
        testContextSetup.log.info("Browser back button clicked successfully.");
    }
}
