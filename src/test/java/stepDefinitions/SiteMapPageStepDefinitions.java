package stepDefinitions;

import java.io.IOException;
import io.cucumber.java.en.When;
import pageObjects.SiteMapPage;
import testBase.TestContextSetup;

public class SiteMapPageStepDefinitions {

    TestContextSetup testContextSetup;
    SiteMapPage siteMapPage;

    public SiteMapPageStepDefinitions(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.siteMapPage = testContextSetup.pageObjectManger.getSiteMapPage();
    }

    @When("User click on password link in the displayed site map page")
    public void user_click_on_password_link_in_the_displayed_site_map_page() {
        testContextSetup.log.info("Clicking on 'Password' link from the Site Map page...");
        siteMapPage.clickPasswordLink();
        testContextSetup.log.info("Successfully clicked on 'Password' link and navigated to the Change Password page.");
    }

    @When("User click on my Account link from displayed site map page")
    public void user_click_on_my_account_link_from_displayed_site_map_page() {
        testContextSetup.log.info("Clicking on 'My Account' link from the Site Map page...");
        siteMapPage.clickMyAccountLink();
        testContextSetup.log.info("Successfully clicked on 'My Account' link and navigated to the My Account page.");
    }

    @When("User clicks on Search link from the site map page")
    public void user_clicks_on_search_link_from_the_site_map_page() {
        testContextSetup.log.info("Clicking on 'Search' link from the Site Map page...");
        siteMapPage.clickSearchLink();
        testContextSetup.log.info("Successfully clicked on 'Search' link and navigated to the Search page.");
    }
}
