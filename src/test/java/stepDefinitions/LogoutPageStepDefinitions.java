package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.TestContextSetup;

public class LogoutPageStepDefinitions {

	public TestContextSetup testContextSetup;
	public LogoutPage logoutPage;
	public MyAccountPage myAccountPage;
	public HomePage homePage;

	public LogoutPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		logoutPage = testContextSetup.pageObjectManger.getLogoutPage();
		myAccountPage = testContextSetup.pageObjectManger.getMyAccountPage();
		homePage = testContextSetup.pageObjectManger.getHomePage();
	}

	@Then("User should be taken to the Account Logout page and click on continue button")
	public void user_should_be_taken_to_the_account_logout_page() {
		testContextSetup.log.info("verifying user is landed on logout page and clicking on continue button!!");
		testContextSetup.waitUtils.waitForPageLoad(5);
		Assert.assertTrue(logoutPage.isAccountLogoutConfirmationPageDisplayed(),"Account logout confirmation page is not displayed!");
		logoutPage.clickContinuebtn();
		testContextSetup.log.info("verified user is landed on logout page and clicked on continue button!!");
	}

	@When("User clicks on browser back button")
	public void user_clicks_on_browser_back_button() throws IOException {
		testContextSetup.log.info("navigating back!!");
		testContextSetup.testBase.WebDriverManager().navigate().back();
		testContextSetup.log.info("navigated back successfully!!");
	}
	@Then("User should not get logged in")
	public void user_should_not_get_logged_in() throws IOException {
		testContextSetup.testBase.WebDriverManager().navigate().refresh();
		testContextSetup.waitUtils.waitForPageLoad(5);
		myAccountPage.clickMyAccountDropMenu();
		Assert.assertFalse(myAccountPage.isLogoutButtonDisplayed(),"Logout button is not displaying!");
	}
	@Then("Proper Page Heading, Page Title, Page URL and Breadcrumb should be displayed for Account Logout page")
	public void proper_page_heading_page_title_page_url_and_breadcrumb_should_be_displayed_for_account_logout_page() {
		testContextSetup.log.info("verifying logout page breadcrumb!!");
		Assert.assertTrue(logoutPage.isLastBreadCrumbDisplayed(),"Logout page breadcrumb is not displaying!");
		Assert.assertEquals(logoutPage.getLogoutPageTitle(), "Account Logout","Page title is mismatched!");
		Assert.assertEquals(logoutPage.getLogoutPageURL(), "https://tutorialsninja.com/demo/index.php?route=account/logout", "Logout page URL is mismatched!");
		Assert.assertEquals(logoutPage.getLogoutPageHeading(), "Account Logout","Logout page heading mismached!");
		testContextSetup.log.info("verified successfully logout page breadcrumb!!");
	}




}
