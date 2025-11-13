package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductCategoryPage;
import testBase.TestContextSetup;

public class ProductCategoryStepDefinitions {

    TestContextSetup testContextSetup;
    ProductCategoryPage productCategoryPage;

    public ProductCategoryStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.productCategoryPage = testContextSetup.pageObjectManger.getProductCategoryPage();
    }

    @When("In the displayed desktops category page, select list View option")
    public void in_the_displayed_desktops_category_page_select_list_view_option() {
        testContextSetup.log.info("Verifying that user is on Desktop Category page...");
        Assert.assertTrue(productCategoryPage.isOnDesktopCategoryPage(), "User is not on Product Category page!");
        testContextSetup.log.info("User is on Desktop Category page, selecting List View option...");
        productCategoryPage.clickListViewOption();
        testContextSetup.log.info("List View option selected successfully.");
    }

    @When("Hover the mouse cursor on Compare this Product option available on the Product that is displayed in the Product Category page")
    public void hover_the_mouse_cursor_on_compare_this_product_option_available_on_the_product_that_is_displayed_in_the_product_category_page() {
        testContextSetup.log.info("Hovering mouse over 'Compare this Product' option in List View...");
        productCategoryPage.hoverOnCompareThisProduct();
    }

    @Then("Tool tip with the text - {string} should be displayed on product category page")
    public void tool_tip_with_the_text_should_be_displayed_on_product_category_page(String expectedTooltipText) {
        testContextSetup.log.info("Validating tooltip message for 'Compare this Product' in List View...");
        Assert.assertEquals(
            productCategoryPage.getCompareThisProductHoverMsg(),
            expectedTooltipText,
            "Tooltip message did not match in List View!"
        );
        testContextSetup.log.info("Tooltip message verified successfully in List View.");
    }

    @When("User select compare this product option")
    public void user_select_compare_this_product_option() {
        testContextSetup.log.info("Selecting 'Compare this Product' option in List View...");
        productCategoryPage.clickCompareThisProductButton();
        testContextSetup.log.info("'Compare this Product' option selected successfully in List View.");
    }

    @When("In the displayed desktops category page, select grid View option")
    public void in_the_displayed_desktops_category_page_select_grid_view_option() {
        testContextSetup.log.info("Switching to Grid View on Desktop Category page...");
        productCategoryPage.clickGridViewOption();
        testContextSetup.log.info("Grid View option selected successfully.");
    }

    @When("Hover the mouse cursor on Compare this Product option available on the Product that is displayed in the Product Category page for grid view")
    public void hover_the_mouse_cursor_on_compare_this_product_option_available_on_the_product_that_is_displayed_in_the_product_category_page_for_grid_view() {
        testContextSetup.log.info("Hovering mouse over 'Compare this Product' option in Grid View...");
        productCategoryPage.hoverOnCompareThisProductGridView();
    }

    @Then("Tool tip with the text - {string} should be displayed on product category page for grid view")
    public void tool_tip_with_the_text_should_be_displayed_on_product_category_page_for_grid_view(String expectedTooltipText) {
        testContextSetup.log.info("Validating tooltip message for 'Compare this Product' in Grid View...");
        Assert.assertEquals(
            productCategoryPage.getCompareThisProductHoverMsgGridView(),
            expectedTooltipText,
            "Tooltip message did not match in Grid View!"
        );
        testContextSetup.log.info("Tooltip message verified successfully in Grid View.");
    }

    @When("User select compare this product option on grid view")
    public void user_select_compare_this_product_option_on_grid_view() {
        testContextSetup.log.info("Selecting 'Compare this Product' option in Grid View...");
        productCategoryPage.clickCompareThisProductionButtonOnGridView();
        testContextSetup.log.info("'Compare this Product' option selected successfully in Grid View.");
    }

    @When("User clicks on Product compare0 link on Desktops category page")
    public void user_clicks_on_product_compare_link_on_desktops_category_page() {
        testContextSetup.log.info("Clicking on 'Product Compare' link on Desktop Category page...");
        productCategoryPage.clickCompareProductLink();
        testContextSetup.log.info("'Product Compare' link clicked successfully.");
    }
}
