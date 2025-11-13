package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.TestContextSetup;
import utilities.PasswordManager;

public class LoginPageStepDefinitions {

	TestContextSetup testContextSetup;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	LogoutPage logoutPage;
	ChangePasswordPage changePasswordPage;
	HomePage homePage;
	String email;
	String oldPassword;
	String newPassword;
	Set<Cookie> cookies;
	Set<String> clickedLinks;

	public LoginPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		loginPage = testContextSetup.pageObjectManger.getLoginPage();
		myAccountPage = testContextSetup.pageObjectManger.getMyAccountPage();
		logoutPage = testContextSetup.pageObjectManger.getLogoutPage();
		changePasswordPage = testContextSetup.pageObjectManger.getChangePasswordPage();
		homePage = testContextSetup.pageObjectManger.getHomePage();
	}

	@Then("User is landed to login account page")
	public void user_is_landed_to_login_account_page() {
		testContextSetup.log.info("verifying login page breadcrumb is displayed!");
	    Assert.assertTrue(loginPage.isLoginBreadcrumbDisplayed(), "User is not landed on login page!");
	    testContextSetup.log.info("login page breadcrumb is displayed successfully!");
	}

	@Then("Warning message with text - Warning: No match for E-Mail Address and\\/or Password. should be displayed")
	public void warning_message_with_text_warning_no_match_for_e_mail_address_and_or_password_should_be_displayed() {
		testContextSetup.log.info("verifying invalid error is displayed correctly!");
		Assert.assertTrue(loginPage.isInvalidLoginErrorDisplayed(), "invalid message is not displayed correctly!");
		testContextSetup.log.info("invalid error is displayed correctly has been verified!");
	}

	@When("User enter {string} into email field")
	public void user_enter_into_email_field(String email) {
		testContextSetup.log.info("entering email into runtime email field!");
		loginPage.enterEmailIntoRuntimeEmailField(email);
		testContextSetup.log.info("successfully entered email into runtime email field!");
	}
	@When("User enter {string} into password field")
	public void user_enter_into_password_field(String password) {
		testContextSetup.log.info("entering password into password field!");
		loginPage.enterLoginPasswordField(password);
		testContextSetup.log.info("successfully entered password into password field!");
	}
	@When("User click on login button")
	public void user_click_on_login_button() {
		testContextSetup.log.info("clicking on login button!");
		loginPage.clickLoginBtn();
		testContextSetup.log.info("successfully clicked on login button!");
	}

	@Then("User is redirected to login page")
	public void user_is_redirected_to_login_page() {
		testContextSetup.log.info("verifying user is on login page!");
		loginPage.isUserOnLoginPage();
		testContextSetup.log.info("user is landed successfully on login page!");
	}

	@When("click on continue button inside New Customer box")
	public void click_on_continue_button_inside_new_customer_box()
	{
		testContextSetup.log.info("clicking on continue button!");
		loginPage.clickContinueButton();
		testContextSetup.log.info("clicked successfully on continue button!");
	}

	@When("click on Register option from the Right Column options")
	public void click_on_register_option_from_the_right_column_options()
	{
		testContextSetup.log.info("clicking on register link from right column!");
		loginPage.clickRegisterLinkFromRightCol();
		testContextSetup.log.info("clicked successfully on register link from right column!");
	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String email) {
		testContextSetup.log.info("entering email into email field!");
		loginPage.enterLoginEmailField(email);
		testContextSetup.log.info("successfully entered email into email field!!");
	}

	@When("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String password) {
		testContextSetup.log.info("entering login password into password field!");
		loginPage.enterLoginPasswordField(password);
		testContextSetup.log.info("successfully entered password into password field!");
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		testContextSetup.log.info("clicking on login button!");
		loginPage.clickLoginButton();
		testContextSetup.log.info("successfully clicked on login button!");
	}

	@When("User must log in with credentials email {string} and password {string} of page")
	public void user_must_log_in_with_credentials_email_and_password_of_page(String email, String password) {
		testContextSetup.log.info("entering email into email field!");
		loginPage.enterLoginEmailField(email);
		testContextSetup.log.info("successfully entered email into email field!!");
		testContextSetup.log.info("entering login password into password field!");
		loginPage.enterLoginPasswordField(password);
		testContextSetup.log.info("successfully entered password into password field!");
		testContextSetup.log.info("clicking on login button!");
		loginPage.clickLoginButton();
		testContextSetup.log.info("successfully clicked on login button!");
	}

	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String invalidEmail)
	{
		testContextSetup.log.info("entering invalid email into email field!");
		loginPage.enterLoginEmailField(invalidEmail);
		testContextSetup.log.info("successfully entered invalid email into email field!!");
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPassword) {
		testContextSetup.log.info("entering invalid login password into password field!");
		loginPage.enterLoginPasswordField(invalidPassword);
		testContextSetup.log.info("successfully entered invalid password into password field!");
	}

	@Then("Warning message with the text {string} should be displayed")
	public void warning_message_with_the_text_should_be_displayed(String LoginFailedWarningMessage)
	{
		testContextSetup.log.info("verifying login failed warning message!");
		Assert.assertEquals(loginPage.getWarningFailedWarningMessage(), LoginFailedWarningMessage, "Login failed warning message did not match!");
		testContextSetup.log.info("login failed warning message has been verified!");
	}

	@When("User enters nothing into email address {string} into email field")
	public void user_enters_nothing_into_email_address_into_email_field(String emptyEmailField) {
		testContextSetup.log.info("entering empty email into email field!");
		loginPage.enterLoginEmailField(emptyEmailField);
		testContextSetup.log.info("successfully entered empty email into email field!!");
	}

	@When("User enters nothing into password field {string} into password field")
	public void user_enters_nothing_into_password_field_into_password_field(String emptyPasswordField) {
		testContextSetup.log.info("entering empty password into password field!!");
		loginPage.enterLoginPasswordField(emptyPasswordField);
		testContextSetup.log.info("successfully entered empty password into password field!!");
	}

	@Then("User should be taken to login page")
	public void user_should_be_taken_to_login_page() {
		testContextSetup.log.info("verifying user is on login page!!");
		Assert.assertTrue(loginPage.isUserOnLoginPage(), "Login page breadcrumb is not displayed!");
		testContextSetup.log.info("successfully verified user is on login page!!");
	}

	@Then("User must able to see Forgotten Password link on login page")
	public void user_must_able_to_see_forgotten_password_link_on_login_page() {
		testContextSetup.log.info("verifying forgotten password link is displayed!!");
		Assert.assertTrue(loginPage.isForgottenPasswordLinkDisplayed(), "Forgotten link is not displaying!");
		testContextSetup.log.info("successfully verified forgotten password link is displayed!!");
	}

	@When("User selects forgotten password link")
	public void user_selects_forgotten_password_link() {
		testContextSetup.log.info("clicking on forgotten password link!!");
		loginPage.clickForgottenPasswordLink();
		testContextSetup.log.info("successfully clicked on forgotten password link!!");
	}
	@Then("User should be taken to Forgotten Password page")
	public void user_should_be_taken_to_forgotten_password_page() {
		testContextSetup.log.info("verifying heading of forgotten password!!");
		Assert.assertEquals(loginPage.getHeadingOfForgottenPassword(), "Forgot Your Password?", "Forgotten password page is not displayed!");
		testContextSetup.log.info("successfully verified heading of forgotten password!!");
	}

	@When("User enters valid email address {string} into email field by using keyboardkeys")
	public void user_enters_valid_email_address_into_email_field_by_using_keyboardkeys(String email) {
		testContextSetup.log.info("entering email into email field using keyboard keys!!");
		for(int i=0;i<23;i++)
		{
			testContextSetup.actions.sendKeys(Keys.TAB).perform();
		}
		testContextSetup.actions.sendKeys(email).perform();
		testContextSetup.log.info("successfully entered email into email field using keyboard keys!!");
	}

	@When("User enters valid password {string} into password field by using keyboardkeys")
	public void user_enters_valid_password_into_password_field_by_using_keyboardkeys(String password) {
		testContextSetup.log.info("entering password into password field using keyboard keys!!");
		testContextSetup.actions.sendKeys(Keys.TAB).perform();
		testContextSetup.actions.sendKeys(password).perform();
		testContextSetup.log.info("successfully entered password into password field using keyboard keys!!");
	}
	@When("User press enter on login button to get loggedIn")
	public void user_press_enter_on_login_button_to_get_logged_in() {
		testContextSetup.log.info("pressing enter key using keyboard keys!!");
		testContextSetup.actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		testContextSetup.actions.sendKeys(Keys.ENTER).perform();
		testContextSetup.log.info("successfully pressed enter key using keyboard keys!!");
	}
	@Then("User must able to see E-mail placeholder text {string} in E-Mail field")
	public void user_must_able_to_see_e_mail_placeholder_text_in_e_mail_field(String EmailFieldplaceholderText) {
		testContextSetup.log.info("fetching placeholder of email field!!");
		Assert.assertEquals(loginPage.getPlaceholderEmailField(), EmailFieldplaceholderText, "Placeholder text for e-mail field is not matched!");
		testContextSetup.log.info("placeholder fetched successfully of email field!!");
	}
	@Then("User must able to see Password placeholder text {string} in Password field")
	public void user_must_able_to_see_password_placeholder_text_in_password_field(String PasswordFieldPlaceholderText) {
		testContextSetup.log.info("fetching placeholder of password field!!");
		Assert.assertEquals(loginPage.getPlaceholderPasswordField(), PasswordFieldPlaceholderText, "placeholder text for password field is not matched!");
		testContextSetup.log.info("placeholder fetched successfully of password field!!");
	}
	@Then("User clicks browserBack button")
	public void user_clicks_browser_back_button() throws IOException {
		testContextSetup.log.info("navigating back!!");
		testContextSetup.testBase.WebDriverManager().navigate().back();
		testContextSetup.waitUtils.waitForPageLoad(10);
		testContextSetup.log.info("successfully navigated back!!");
	}
	@Then("User should not loggedOut")
	public void user_should_not_logged_out() throws IOException {
		testContextSetup.log.info("refreshing page!!");
		testContextSetup.testBase.WebDriverManager().navigate().refresh();
		testContextSetup.waitUtils.waitForPageLoad(10);
		Assert.assertTrue(myAccountPage.isLogoutButtonDisplayed());
	}

	@When("User select logout option")
	public void user_select_logout_option() {
		testContextSetup.log.info("clicking on logout button from menu!!");
		myAccountPage.clickLogoutButtonFromMenu();
		testContextSetup.log.info("clicked on logout button from menu!!");
	}
	@Then("User must be on Account Logout confirmation page")
	public void user_must_be_on_account_logout_confirmation_page() {
		testContextSetup.log.info("verifying account logout confirmation message is displayed!!");
		Assert.assertTrue(logoutPage.isAccountLogoutConfirmationPageDisplayed(), "User not getting LogoutConfirmationPage");
		testContextSetup.log.info("verified account logout confirmation message is displayed!!");
	}
	@Then("User should not get logged out")
	public void user_should_not_get_logged_out() throws IOException {
		testContextSetup.waitUtils.waitForPageLoad(5);
		testContextSetup.testBase.WebDriverManager().navigate().refresh();
		boolean isLoggedIn = false;
		try {
			isLoggedIn = myAccountPage.isOnMyAccountPage();
		}catch(Exception e) {
			isLoggedIn = false;
		}

		Assert.assertTrue(isLoggedIn,"User is logged out after pressing browser back button!");
	}

	@When("User clicks on login button {int} times")
	public void user_clicks_on_login_button_times(int times) {
		for(int i=0;i<times;i++)
		{
			WebElement loginButton = testContextSetup.waitUtils.waitForElementClickable(loginPage.getLoginButton(), 10);
			loginButton.click();

			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Then("User should get {string} warning message")
	public void user_should_get_warning_message(String loginLimitExistsWarningMessage) {
		WebElement warningElement = testContextSetup.waitUtils.waitForElementVisibility(loginPage.getLoginLimitExceedsWarningMessage(), 10);
		String actualWarningMessage = warningElement.getText();
		Assert.assertEquals(actualWarningMessage, loginLimitExistsWarningMessage, "Warning message did not match!");
	}

	@Then("Text entered into the Password {string} field should be toggled to hide its visibility because of password field type")
	public void text_entered_into_the_password_field_should_be_toggled_to_hide_its_visibility_because_of_password_field_type(String PasswordFieldType) {
		testContextSetup.log.info("fetching password field type!!");
		Assert.assertEquals(loginPage.getPassWordFieldType(), PasswordFieldType, "Password field text is not toggled to hide it's visibility!");
		testContextSetup.log.info("successfully fetched password field type!!");
	}

	@When("User select the text entered into the Password field and press Ctrl+C shorcut for copying")
	public void user_select_the_text_entered_into_the_password_field_and_press_ctrl_c_shorcut_for_copying() {
		loginPage.getCursorOnPasswordField();
		testContextSetup.actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		testContextSetup.actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	}

	@Then("User should not able to copy password text")
	public void user_should_not_able_to_copy_password_text() throws InterruptedException {
		loginPage.getCursorOnEmailField();
		testContextSetup.actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		Assert.assertNotEquals(loginPage.getValueOfEmailField(), "fetgrd23454", "Password copy is not disabled");
	}

	@Then("Inspect the Password text field click on login button and inspect the Password text field")
	public void inspect_the_password_text_field_click_on_login_button_and_inspect_the_password_text_field() throws IOException {
		String password = "fetgrd23454";
		String pageSource = testContextSetup.testBase.WebDriverManager().getPageSource();
		Assert.assertFalse(pageSource.contains(password), "Password is visible in page source!");
	}

	@When("User clicks on change your password link from MyAccount page")
	public void user_clicks_on_change_your_password_link_from_my_account_page() {
		testContextSetup.log.info("clicking on change your password link!!");
		myAccountPage.changeYourPasswordLink();
		testContextSetup.log.info("clicked on change your password link!!");
	}
	@When("User enters password in password field and confirm password field from change password page")
	public void user_enters_password_in_password_field_and_confirm_password_field_from_change_password_page() {
		changePasswordPage.isOnChangePasswordPage();
		testContextSetup.newPassword = testContextSetup.faker.internet().password(8,12);
		changePasswordPage.enterChangePassword(testContextSetup.newPassword);
		changePasswordPage.enterChangeConfPassword(testContextSetup.newPassword);
	}
	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		testContextSetup.log.info("clicking on continue button!!");
		changePasswordPage.clickContinue();
		testContextSetup.log.info("clicked on change your password link!!");
	}
	@When("User clicks on Logout from myAccount dropmenu")
	public void user_clicks_on_logout_from_my_account_dropmenu() {
		homePage.clickMyAccount();
		myAccountPage.clickLogoutButtonFromMenu();
		logoutPage.clickContinuebtn();
	}

	@When("User clears email and password field from login page by clicking on login breadCrumb")
	public void user_clears_email_and_password_field_from_login_page() {
		testContextSetup.log.info("clicking on login breadcrumb!!");
		loginPage.clickLoginBreadcrumb();
		testContextSetup.log.info("clicked on login breadcrumb!!");
	}

	@Then("Password is successfully Changed")
	public void password_is_successfully_changed() {
		testContextSetup.log.info("updating password!!");
		PasswordManager.updatePassword(testContextSetup.newPassword);
		testContextSetup.log.info("password updated successfully!!");
	}

	@When("User enters changed password into password field")
	public void user_enters_changed_password_into_password_field() {
		loginPage.enterLoginPasswordField(testContextSetup.newPassword);
	}

	@When("User enters valid email address into email field")
	public void user_enters_valid_email_address_into_email_field() {
		loginPage.enterLoginEmailField(testContextSetup.email);
	}
	@When("User enters valid password into password field")
	public void user_enters_valid_password_into_password_field() {
		loginPage.enterLoginPasswordField(testContextSetup.oldPassword);
	}
	@When("User enters same email address into email field")
	public void user_enters_same_email_address_into_email_field() {
		loginPage.enterLoginEmailField(testContextSetup.email);
	}
	@When("User enters with old password into password field")
	public void user_enters_with_old_password_into_password_field() {
		loginPage.enterLoginPasswordField(testContextSetup.oldPassword);
	}
	@When("User clicks on Continue button under new customer section")
	public void user_clicks_on_continue_button_under_new_customer_section() {
		testContextSetup.log.info("clicking on continue button!!");
		loginPage.clickContinueButton();
		testContextSetup.log.info("clicked on continue button!!");
	}
	@Then("User clicks on links one by one present on login account page and verify navigated to same webpage and navigates back to login account page")
	public void user_clicks_on_links_one_by_one_present_on_login_account_page_and_verify_navigated_to_same_webpage_and_navigates_back_to_login_account_page() throws IOException {
		clickedLinks = new HashSet<>();

		verifyLinksSection("RightColumn", loginPage.getRightColumnLinks());
		verifyLinksSection("Footer", loginPage.getFooterLinks());
	}

	private void verifyLinksSection(String sectionName, List<WebElement> list) throws IOException {
		// ✅ Map of link text vs expected page title
		Map<String, String> expectedTitles = new HashMap<>();

		expectedTitles.put("Register", "Register Account");
		expectedTitles.put("Forgotten Password", "Forgot Your Password?");
		expectedTitles.put("My Account", "Account Login");
		expectedTitles.put("Address Book", "Account Login");
		expectedTitles.put("Wish List", "Account Login");
		expectedTitles.put("Order History", "Account Login");
		expectedTitles.put("Downloads", "Account Login");
		expectedTitles.put("Recurring payments", "Account Login");
		expectedTitles.put("Reward Points", "Account Login");
		expectedTitles.put("Returns", "Account Login");
		expectedTitles.put("Transactions", "Account Login");
		expectedTitles.put("Newsletter", "Account Login");

		// Footer links
		expectedTitles.put("About Us", "About Us");
		expectedTitles.put("Delivery Information", "Delivery Information");
		expectedTitles.put("Privacy Policy", "Privacy Policy");
		expectedTitles.put("Terms & Conditions", "Terms & Conditions");
		expectedTitles.put("Contact Us", "Contact Us");
		expectedTitles.put("Site Map", "Site Map");
		expectedTitles.put("Brands", "Find Your Favorite Brand");
		expectedTitles.put("Gift Certificates", "Purchase a Gift Certificate");
		expectedTitles.put("Affiliate", "Affiliate Program");
		expectedTitles.put("Specials", "Special Offers");
		expectedTitles.put("My Account", "Account Login");
		expectedTitles.put("Order History", "Account Login");
		expectedTitles.put("Wish List", "Account Login");
		expectedTitles.put("Newsletter", "Account Login");
		expectedTitles.put("Returns", "Account Login");

		for (int i = 0; i < list.size(); i++) {
			if (sectionName.equals("RightColumn")) {
				list = loginPage.getRightColumnLinks();
			} else if (sectionName.equals("Footer")) {
				list = loginPage.getFooterLinks();
			}

			WebElement link = list.get(i);
			String linkText = link.getText().trim();

			if (clickedLinks.contains(linkText) || linkText.equalsIgnoreCase("Login") || linkText.isEmpty()) {
				continue;
			}

			clickedLinks.add(linkText);
			System.out.println("Clicking on [" + sectionName + "] link: " + linkText);

			String expectedTitle = expectedTitles.getOrDefault(linkText, "");

			String beforeUrl = testContextSetup.testBase.WebDriverManager().getCurrentUrl();
			link.click();

			WebDriverWait wait = new WebDriverWait(testContextSetup.testBase.WebDriverManager(), Duration.ofSeconds(5));

			if (!expectedTitle.isEmpty()) {
				wait.until(ExpectedConditions.titleIs(expectedTitle));
				Assert.assertEquals(
						testContextSetup.testBase.WebDriverManager().getTitle(),
						expectedTitle,
						"User did not land on correct page after clicking link: " + linkText
						);
			} else {
				wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
				System.out.println("No expected title mapped for link: " + linkText +
						". Navigated to: " + testContextSetup.testBase.WebDriverManager().getTitle());
			}

			System.out.println("Navigated to page: " + testContextSetup.testBase.WebDriverManager().getTitle());

			testContextSetup.testBase.WebDriverManager().navigate().back();
			wait.until(ExpectedConditions.titleIs("Account Login"));
			Assert.assertEquals(
					testContextSetup.testBase.WebDriverManager().getTitle(),
					"Account Login",
					"User is not back on Login page after clicking link: " + linkText
					);
		}
	}

	@When("User navigates back")
	public void user_navigates_back() throws IOException {
		testContextSetup.log.info("navigating back!!");
		testContextSetup.testBase.WebDriverManager().navigate().back();
		testContextSetup.log.info("navigated back successfully!!");
	}

	@When("User must able see Proper Breadcrumb, Page Heading, Page URL and Page Title")
	public void user_must_able_see_proper_breadcrumb_page_heading_page_url_and_page_title() {
		testContextSetup.log.info("verifying login page details!!");
		Assert.assertTrue(loginPage.isLoginBreadcrumbDisplayed(), "Proper breadcrumb for loginPage is not displaying!");
		Assert.assertTrue(loginPage.isLoginPageHeadingDisplayed(), "Login page headings not displaying!");
		Assert.assertEquals(loginPage.getURLOfLoginPage(), "https://tutorialsninja.com/demo/index.php?route=account/login","Login page URL is not correct!");
		Assert.assertEquals(loginPage.getTitleofLoginPage(), "Account Login");
		testContextSetup.log.info("verified login page details!!");
	}

	@When("Login Account functionality should work in all the supported browser")
	public void login_account_functionality_should_work_in_all_the_supported_browser() {
		testContextSetup.log.info("verifying title of login page!!");
		Assert.assertEquals(loginPage.getTitleofLoginPage(), "Account Login");
		testContextSetup.log.info("verified title of login page!!");
	}
}

