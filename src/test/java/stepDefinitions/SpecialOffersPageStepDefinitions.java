package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.SpecialOffersPage;
import testBase.TestContextSetup;

public class SpecialOffersPageStepDefinitions {

    TestContextSetup testContextSetup;
    SpecialOffersPage specialOffersPage;

    public SpecialOffersPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        specialOffersPage = testContextSetup.pageObjectManger.getSpecialOffersPage();
    }

    @Then("User should see only discounted products are listed in special offers page not expired offers")
    public void user_should_see_only_discounted_products_are_listed_in_special_offers_page_not_expired_offers() {
        testContextSetup.log.info("Verifying that only active discounted products are listed on the Special Offers page...");
        Assert.assertTrue(specialOffersPage.verifyOnlyActiveDiscountedProductsAreListed(),
                "Expired or non-discounted products are listed on the Special Offers page!");
        testContextSetup.log.info("Verified successfully: Only active discounted products are displayed, no expired offers found.");
    }

    @Then("User click on offer product displayed in product details page")
    public void user_click_on_offer_product_displayed_in_product_details_page() {
        testContextSetup.log.info("Clicking on the first offer product displayed in the Special Offers page...");
        specialOffersPage.clickFirstProductDisplayedInPage();
        testContextSetup.log.info("Clicked on the first offer product successfully and navigated to the product details page.");
    }

    @Then("User should see products are getting sorted based on option selected in sortby dropdown")
    public void user_should_see_products_are_getting_sorted_based_on_option_selected_in_sortby_dropdown() {
        testContextSetup.log.info("Verifying product sorting functionality based on selected 'Sort By' options...");
        specialOffersPage.verifyAllSortingOptions();
        testContextSetup.log.info("Verified successfully: Products are sorted correctly as per the selected 'Sort By' options.");
    }

    @Then("User should see old price is strike through and new price is highlightes in special offers displayed products page")
    public void user_should_see_old_price_is_strike_through_and_new_price_is_highlightes_in_special_offers_displayed_products_page() {
        testContextSetup.log.info("Verifying price display: Old price should be strike-through and new price highlighted...");
        Assert.assertTrue(specialOffersPage.verifyOldPriceStrikeThroughAndNewPriceHighlighted(),
                "Old/new price styles not displayed correctly in Special Offers page!");
        testContextSetup.log.info("Verified successfully: Old price is strike-through and new price is highlighted as expected.");
    }

    @Then("User should be navigated to the Special Offers page")
    public void user_should_be_navigated_to_the_special_offers_page() {
        testContextSetup.log.info("Verifying navigation to the Special Offers page...");
        Assert.assertTrue(specialOffersPage.verifySpecialOffersPageBreadcrumbIsDisplayed(),
                "User is not landed on the Special Offers page!");
        testContextSetup.log.info("User successfully navigated to the Special Offers page.");
    }

    @Then("User click on special offers link from footer option and Measure page load time")
    public void user_click_on_special_offers_link_from_footer_option_and_measure_page_load_time() {
        testContextSetup.log.info("Clicking on Special Offers link from footer and measuring page load time...");
        Assert.assertTrue(specialOffersPage.clickSpecialOffersLinkAndMeasureLoadTime(),
                "Special Offers page did not load within acceptable time limit!");
        testContextSetup.log.info("Special Offers page loaded successfully within the expected time limit.");
    }

    @Then("User should see only discounted products are listed in special offers page")
    public void user_should_see_only_discounted_products_are_listed_in_special_offers_page() {
        testContextSetup.log.info("Verifying that only discounted products are listed on the Special Offers page...");
        Assert.assertTrue(specialOffersPage.verifyAllDisplayedProductsAreDiscountedProducts(),
                "Some non-discounted products are displayed on the Special Offers page!");
        testContextSetup.log.info("Verified successfully: All displayed products are discounted products.");
    }
}
