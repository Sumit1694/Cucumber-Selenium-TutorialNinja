package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AboutUsPage;
import testBase.TestContextSetup;

public class AboutUsPageStepDefinitions {

	TestContextSetup testContextSetup;
	AboutUsPage aboutUsPage;

	public AboutUsPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.aboutUsPage = testContextSetup.pageObjectManger.getAboutUsPage();
		testContextSetup.log.info("AboutUsPageStepDefinitions initiated.");
	}

	@When("User click on about us link which takes user to page about us")
	public void user_is_on_any_other_page_like_about_us() {
		testContextSetup.log.info("clicking on about us link in footer!");
		Assert.assertTrue(aboutUsPage.verifyUserLandsOnAboutUsPage(), "About us page is not loaded correctly!");
		testContextSetup.log.info("verified about us page loaded successfully!");
	}

	@Then("User is landed on About Us page")
	public void user_is_landed_on_about_us_page() {
		testContextSetup.log.info("checking if user landed on about us page...");
		Assert.assertTrue(aboutUsPage.isUserLandedOnAboutUsPage(), "About us page is not loaded correctly!");
		testContextSetup.log.info("user is confirmed on about us page!");
	}

	@When("User click on the Logo Your Store in our application")
	public void user_click_on_the_logo_your_store_in_our_application() {
		testContextSetup.log.info("clicking on homepage logo....");
		aboutUsPage.clickHomePageLogo();
		testContextSetup.log.info("navigated back ti homepage....");
	}



}
