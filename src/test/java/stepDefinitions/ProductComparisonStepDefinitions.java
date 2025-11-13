package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductComparisonPage;
import testBase.TestContextSetup;

public class ProductComparisonStepDefinitions {

    TestContextSetup testContextSetup;
    ProductComparisonPage productComparisonPage;

    public ProductComparisonStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.productComparisonPage = testContextSetup.pageObjectManger.getProductComparisonPage();
    }

    // --- Navigation and Heading Validation ---
    @Then("User should be navigated to the {string} page")
    public void user_should_be_navigated_to_the_product_compare_page(String heading) {
        testContextSetup.log.info("Validating Product Comparison page heading...");
        Assert.assertEquals(
            productComparisonPage.getProductComparisonPageHeading(),
            heading,
            "Product Comparison page heading mismatched!"
        );
        testContextSetup.log.info("Product Comparison page heading verified successfully.");
    }

    @Then("User should be taken to the {string} page with the details of the Product that we have added for comparision")
    public void user_should_be_taken_to_the_page_with_the_details_of_the_product_that_we_have_added_for_comparision(String heading) {
        testContextSetup.log.info("Verifying that the Product Comparison table is displayed...");
        Assert.assertEquals(productComparisonPage.getProductComparisonPageHeading(), heading, "Heading mismatched!");
        Assert.assertTrue(productComparisonPage.isProductCompareTableIsDisplayed(), "Product Comparison table not displayed!");
    }

    @Then("User should be taken to the {string} page with the details of the Product {string} that we have added for comparision")
    public void user_should_be_taken_to_the_page_with_the_details_of_the_product_that_we_have_added_for_comparision(String heading, String productName) {
        testContextSetup.log.info("Validating Product Comparison page heading and product name...");
        Assert.assertEquals(productComparisonPage.getProductComparisonPageHeading(), heading, "Heading mismatched!");
        Assert.assertEquals(productComparisonPage.getProductNameInProductComparisonPage(), productName, "Incorrect product name in comparison page!");
    }

    @Then("User should be taken to Product Compare page")
    public void user_should_be_taken_to_product_compare_page() {
        testContextSetup.log.info("Checking if user is on Product Compare page...");
        Assert.assertTrue(productComparisonPage.userIsoNProductComparePage(), "User is not on Product Compare page!");
    }

    // --- Add/Remove Product Actions ---
    @When("User click on Add to Cart button on the product that is displayed in the Product Comparison page")
    public void user_click_on_add_to_cart_button_on_the_product_that_is_displayed_in_the_product_comparison_page() {
        testContextSetup.log.info("Clicking 'Add to Cart' button in Product Comparison page...");
        productComparisonPage.clickAddToCartButton();
    }

    @Then("User click on Add to Cart button of the Product from the Product Comparison page")
    public void user_click_on_add_to_cart_button_of_the_product_from_the_product_comparison_page() {
        testContextSetup.log.info("Clicking 'Add to Cart' from Product Comparison page...");
        productComparisonPage.clickAddToCartButton();
    }

    @When("User click on shopping Cart link from displayed success message")
    public void user_click_on_shopping_cart_link_from_displayed_success_message() {
        testContextSetup.log.info("Navigating to Shopping Cart from success message...");
        productComparisonPage.ClickShoppingCartLink();
    }

    @When("User click on Remove button of the Product from the Product Comparison page")
    public void user_click_on_remove_button_of_the_product_from_the_product_comparison_page() {
        testContextSetup.log.info("Clicking 'Remove' button for product on Product Comparison page...");
        productComparisonPage.clickRemoveButton();
    }

    @When("Success message with text - Success: You have modified your product comparison! should be displayed")
    public void success_message_with_text_success_you_have_modified_your_product_comparison_should_be_displayed() {
        testContextSetup.log.info("Validating success message after modifying product comparison...");
        Assert.assertTrue(
            productComparisonPage.isProductComparisonModifiedSuccessMessageDisplayed(),
            "Success message not displayed for modified product comparison!"
        );
    }

    // --- Product Count Validations ---
    @Then("Validate that the product shoud be displayed in the Product Comparison page only one with all the proper product details and the buttons \\(Add to Cart and Remove buttons)")
    public void validate_that_the_product_shoud_be_displayed_in_the_product_comparison_page_only_one_with_all_the_proper_product_details_and_the_buttons_add_to_cart_and_remove_buttons() {
        testContextSetup.log.info("Validating only one product is displayed with correct details...");
        productComparisonPage.verifyProductsInComparisonPage(1);
    }

    @Then("User should able to see single product is displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons")
    public void user_should_able_to_see_single_product_is_displayed_in_the_product_comparison_page_with_all_the_proper_product_details_and_the_buttons_add_to_cart_and_remove_buttons() {
        productComparisonPage.verifyProductsInComparisonPage(1);
    }

    @Then("User should able to see two products is displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons")
    public void user_should_able_to_see_two_products_is_displayed_in_the_product_comparison_page_with_all_the_proper_product_details_and_the_buttons_add_to_cart_and_remove_buttons() {
        productComparisonPage.verifyProductsInComparisonPage(2);
    }

    @Then("User should able to see three products is displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons")
    public void user_should_able_to_see_three_products_is_displayed_in_the_product_comparison_page_with_all_the_proper_product_details_and_the_buttons_add_to_cart_and_remove_buttons() {
        productComparisonPage.verifyProductsInComparisonPage(3);
    }

    @Then("User should able to see four products is displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons")
    public void user_should_able_to_see_four_products_is_displayed_in_the_product_comparison_page_with_all_the_proper_product_details_and_the_buttons_add_to_cart_and_remove_buttons() {
        productComparisonPage.verifyProductsInComparisonPage(4);
    }

    @Then("Validate that lastest four products - Second Product Name to Fifth Product Name are displayed in the Product Comparison page with all the proper product details and the buttons - Add to Cart and Remove buttons and the First added Product is automatically removed from the Product Comparison page as it allows only four products for comparision.")
    public void validate_that_lastest_four_products_second_product_name_to_fifth_product_name_are_displayed_in_the_product_comparison_page_with_all_the_proper_product_details_and_the_buttons_add_to_cart_and_remove_buttons_and_the_first_added_product_is_automatically_removed_from_the_product_comparison_page_as_it_allows_only_four_products_for_comparision() {
        testContextSetup.log.info("Validating that only last 4 products are displayed (and first removed)...");
        productComparisonPage.verifyProductsInComparisonPage(4, "iMac");
    }

    // --- Page Metadata and Messages ---
    @Then("User check the Page Title, Page Heading and Page URL of the displayed Product Comparison page")
    public void user_check_the_page_title_page_heading_and_page_url_of_the_displayed_product_comparison_page() {
        testContextSetup.log.info("Validating Product Comparison page title, heading, and URL...");
        Assert.assertEquals(
            productComparisonPage.getPageURL(),
            "https://tutorialsninja.com/demo/index.php?route=product/compare",
            "Product Comparison page URL mismatched!"
        );
        Assert.assertEquals(productComparisonPage.getPageHeading(), "Product Comparison", "Heading mismatched!");
        Assert.assertEquals(productComparisonPage.getTitleOfProductComparisonPage(), "Product Comparison", "Title mismatched!");
    }

    @Then("User {string} should be displayed on product comparison page")
    public void user_should_be_displayed_on_product_comparison_page(String noProductChosenText) {
        testContextSetup.log.info("Validating 'No product chosen' message on Product Comparison page...");
        Assert.assertEquals(
            productComparisonPage.getNoProductChoosenText(),
            noProductChosenText,
            "No product chosen message mismatched!"
        );
    }

    // --- Miscellaneous ---
    @When("USer clicks on continue button")
    public void u_ser_clicks_on_continue_button() {
        testContextSetup.log.info("Clicking Continue button on Product Comparison page...");
        productComparisonPage.clickContinueButton();
    }

    @Then("Check working of breadCrumb on product compare page")
    public void check_working_of_bread_crumb_on_product_compare_page() {
        testContextSetup.log.info("Validating breadcrumb functionality on Product Comparison page...");
        Assert.assertTrue(
            productComparisonPage.isBredCrumbOfProductComparisonPageIsDisplayed(),
            "Breadcrumb not displayed properly!"
        );
        productComparisonPage.verifyBreadcrumbIsWorking();
    }
}
