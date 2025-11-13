package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPage;
import testBase.TestContextSetup;
import utilities.GenericUtils;

public class RegisterPageStepDefinitions {

	TestContextSetup testContextSetup;
    RegisterPage registerPage;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String password;
    Set<String> clickedLinks;

    public RegisterPageStepDefinitions(TestContextSetup testContextSetup)
    {
    	this.testContextSetup=testContextSetup;
		registerPage = testContextSetup.pageObjectManger.getRegisterPage();
    }

    @Then("User should not see logout option in rightcolumn links")
    public void user_should_not_see_logout_option_in_rightcolumn_links() {
       List<String> options = registerPage.getOptionsFromRightColmn();
       Assert.assertFalse(options.contains("Logout"), "Logout option is still visible!");
    }

	@When("User enters mandatory registration details into fields")
	public void user_enters_mandatory_registration_details_into_fields()
	{
			registerPage.enterFirstName(GenericUtils.getRandomString(8));
	        registerPage.enterLastName(GenericUtils.getRandomString(6));
	        registerPage.enteremail(GenericUtils.getRandomEmail());
	        registerPage.enterTelephone(GenericUtils.getRandomNumber(10));
	        String password = GenericUtils.getRandomString(5)+GenericUtils.getRandomNumber(4);
	        registerPage.enterpassword(password);
	        registerPage.enterConfPassword(password);
	        registerPage.acceptPrivacyPolicy();
	}

	@When("User enters all registration details into fields")
	public void user_enters_all_registration_details_into_fields()
	{
			registerPage.enterFirstName(GenericUtils.getRandomString(8));
	        registerPage.enterLastName(GenericUtils.getRandomString(6));
	        registerPage.enteremail(GenericUtils.getRandomEmail());
	        registerPage.enterTelephone(GenericUtils.getRandomNumber(10));
	        String password = GenericUtils.getRandomString(5)+GenericUtils.getRandomNumber(4);
	        registerPage.enterpassword(password);
	        registerPage.enterConfPassword(password);
	        registerPage.selectNoRadioButton();
	        registerPage.acceptPrivacyPolicy();
	}

	@When("User clicks on continue button on register account page")
	public void user_clicks_on_continue_button_on_register_account_page() throws InterruptedException {
		 registerPage.clickContinueButtonOnRegisterPage();
	}

	@Then("User should be able to see all validation message for all mandatory fields")
	public void user_should_be_able_to_see_all_validation_message_for_all_mandatory_fields() {

		Assert.assertEquals(registerPage.getFirstNameWarningMessage(), "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getLastNameWarningMessage(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getEmailWarningMessage(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(registerPage.getTelephoneWarningMessage(), "Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(registerPage.getpasswordWarningMessage(), "Password must be between 4 and 20 characters!");
		Assert.assertEquals(registerPage.getPrivacyPolicyWarningMessage(), "Warning: You must agree to the Privacy Policy!");
	}

	@When("User selects yes radio button for newsletter field")
	public void user_selects_yes_radio_button_for_newsletter_field()
	{
		registerPage.selectYesRadioButton();
	}

	@When("User selects no radio button for newsletter field")
	public void user_selects_no_radio_button_for_newsletter_field() {
		registerPage.selectNoRadioButton();
	}

	@Then("User should be taken to Register Account page")
	public void user_should_be_taken_to_register_account_page() {
		Assert.assertTrue(registerPage.isOnRegisterAccountPage(),"User is not on register account page.");
	}

	@When("User enters existing Account Details {string} {string} {string} {string} {string} {string} into all the Fields")
	public void user_enters_existing_account_details_into_all_the_fields(String firstName, String LastName, String email,String telephone, String password,String confPassword) {
		registerPage.enterFirstName(firstName);
		registerPage.enterLastName(LastName);
		registerPage.enteremail(email);
		registerPage.enterTelephone(telephone);
		registerPage.enterpassword(password);
		registerPage.enterConfPassword(confPassword);
		registerPage.selectNoRadioButton();
		registerPage.acceptPrivacyPolicy();
	}

	@Then("User must get warning message Warning: E-Mail Address is already registered!")
	public void user_must_get_warning_message_warning_e_mail_address_is_already_registered() {
		Assert.assertEquals(registerPage.getEmailAlreadyRegisteredWarningMsg(),"Warning: E-Mail Address is already registered!");
	}

	@When("User enters all registration details into fields with wrong email address")
	public void User_enters_all_registration_details_into_fields_with_wrong_email_address() throws IOException {

		List<String> invalidEmails = GenericUtils.getInvalidEmails();
	    registerPage.registerWithInvalidEmails(invalidEmails, testContextSetup.testBase.WebDriverManager());
	}

	@Then("User must get proper field level warning message or page level warning message to provide valid email address should be displayed")
	public void user_must_get_proper_field_level_warning_message_or_page_level_warning_message_to_provide_valid_email_address_should_be_displayed() {
		System.out.println("Invalid email warnings validated for all test data.");
	}

	@When("User enter new Account Details into all the Fields by using keyboard keys")
	public void user_enter_new_account_details_into_all_the_fields_by_using_keyboard_keys() {

		String firstName = GenericUtils.getRandomString(8);
		String lastName = GenericUtils.getRandomString(6);
		String email = GenericUtils.getRandomEmail();
		String telephone = GenericUtils.getRandomNumber(10);
		String Password = GenericUtils.getRandomString(5)+GenericUtils.getRandomNumber(4);

		registerPage.fillRegistrationFormUsingKeyboard(firstName, lastName, email, telephone, Password, Password);
	}

	@Then("User must see proper placeholder text is present for every field")
	public void user_must_display_proper_placeholder_text_is_present_for_every_field() {

        Assert.assertEquals(registerPage.getPlaceholderAttributforFname(), "First Name");
        Assert.assertEquals(registerPage.getPlaceholderAttributeForLname(), "Last Name");
        Assert.assertEquals(registerPage.getPlaceholderAttributeforEmail(), "E-Mail");
        Assert.assertEquals(registerPage.getPlaceholderAttributeforTel(), "Telephone");
        Assert.assertEquals(registerPage.getPlaceholderAttributeforPass(), "Password");
        Assert.assertEquals(registerPage.getPlaceholderAttributeforconfPass(), "Password Confirm");
	}

	@Then("User must see all mandatory fields with red star symbol on register accounts page")
	public void user_must_see_all_mandatory_fields_with_star_symbol_on_register_accounts_page() {

        Assert.assertEquals(registerPage.getFirstNameFieldSymbol(), "* ");
        Assert.assertEquals(registerPage.getFirstNameFieldColor(), "rgb(255, 0, 0)");
        Assert.assertEquals(registerPage.getLastNameFieldSymbol(), "* ");
        Assert.assertEquals(registerPage.getLastNameFieldColor(), "rgb(255, 0, 0)");
        Assert.assertEquals(registerPage.getEmailFieldSymbol(), "* ");
        Assert.assertEquals(registerPage.getEmailFieldColor(), "rgb(255, 0, 0)");
        Assert.assertEquals(registerPage.getTelephoneFieldSymbol(), "* ");
        Assert.assertEquals(registerPage.getTelephoneFieldColor(), "rgb(255, 0, 0)");
        Assert.assertEquals(registerPage.getPasswordFieldSymbol(), "* ");
        Assert.assertEquals(registerPage.getPasswordFieldColor(), "rgb(255, 0, 0)");
        Assert.assertEquals(registerPage.getConfPasswordFieldSymbol(), "* ");
        Assert.assertEquals(registerPage.getConfPasswordFieldColor(), "rgb(255, 0, 0)");
	}

	@When("User enters all registration details into into registration fields")
	public void user_enters_all_registration_details_into_into_registration_fields() {
	     firstName = GenericUtils.getRandomString(7);
	     lastName = GenericUtils.getRandomString(6);
	     email = GenericUtils.getRandomEmail1();
	     telephone = GenericUtils.getRandomNumber(10);
	     password = GenericUtils.getRandomString(5)+"@"+GenericUtils.getRandomNumber(4);

	    registerPage.enterFirstName(firstName);
	    registerPage.enterLastName(lastName);
	    registerPage.enteremail(email);
	    registerPage.enterTelephone(telephone);
	    registerPage.enterpassword(password);
	    registerPage.enterConfPassword(password);
	    registerPage.selectNoRadioButton();
	    registerPage.acceptPrivacyPolicy();

	    registerPage.saveUserInMockDB(firstName, lastName, email, telephone, password, password);
	}

	@Then("All registration details are successfully stored in database")
	public void all_registration_details_are_successfully_stored_in_database() {

		String testEmail = GenericUtils.getLastGeneratedEmail();
		boolean exists = GenericUtils.getMockDatabase().isUserPresent(testEmail);

		Assert.assertTrue(exists, "User was not saved in Mock Database!");

		String [] userDetails = GenericUtils.getMockDatabase().getUserDetails(testEmail);

		Assert.assertEquals(userDetails[0], firstName, "First name mismatch!");
		Assert.assertEquals(userDetails[1], lastName, "Last name mismatch!");
		Assert.assertEquals(userDetails[2], email, "Email mismatch!");
		Assert.assertEquals(userDetails[3], telephone,"Telephobe mismatch!");
		Assert.assertEquals(userDetails[4], password, "password mismatch!");
		System.out.println("DB Record: " + String.join(", ", userDetails));
	}

	@When("user clicks on Login button from rightcolumn Register Account Page")
	public void user_clicks_on_login_button_from_rightcolumn_register_account_page() {
	    registerPage.getRightColumnLinks();
	}

	@When("User enters only spaces in mandatory registration details fields")
	public void user_enters_only_spaces_in_mandatory_registration_details_fields() {
	    String firstName = "    ";
	    String lastName = "      ";
	    String email = "       ";
	    String telephone = "       ";

	    registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enteremail(email);
        registerPage.enterTelephone(telephone);
        registerPage.acceptPrivacyPolicy();
	}
	@Then("User should get warning message for these Mandatory fields for spaces")
	public void user_should_get_warning_message_for_these_mandatory_fields() {

		Assert.assertEquals(registerPage.getFirstNameWarningMessage(), "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getLastNameWarningMessage(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getEmailWarningMessage(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(registerPage.getTelephoneWarningMessage(), "Telephone must be between 3 and 32 characters!");
	}

	@When("User enters all registration details into fields with password not following standard")
	public void user_enters_all_registration_details_into_fields_with_password_not_following_standard() {
	    String firstName = GenericUtils.getRandomString(7);
	    String lastName = GenericUtils.getRandomString(8);
	    String email = GenericUtils.getRandomEmail();
	    String telephone = GenericUtils.getRandomNumber(10);
	    String password = GenericUtils.getRandomString(3);

        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enteremail(email);
        registerPage.enterTelephone(telephone);
        registerPage.enterpassword(password);
        registerPage.enterConfPassword(password);
        registerPage.acceptPrivacyPolicy();
	}
	@Then("User should get warning message for following Password Complexity Standards")
	public void user_should_get_warning_message_for_following_password_complexity_standards() {
	    Assert.assertEquals(registerPage.getpasswordWarningMessage(), "Password must be between 4 and 20 characters!", "Password field not following standards");
	}

	@Then("Check all the fields on register account page including the Continue button Text fields should abide to the Client requirements")
	public void Check_all_the_fields_on_register_account_page_including_continue_button() {
	   Assert.assertEquals(registerPage.getHeightOfFirstNameField(),     34,  "Height of First Name field is incorrect!");
	   Assert.assertEquals(registerPage.getWidthOfFirstNameField(),     701,  "Width of First Name field is incorrect!");
	   Assert.assertEquals(registerPage.getHeightOfLastNameField(),      34,  "Height of Last Name field is incorrect!");
	   Assert.assertEquals(registerPage.getWidthOfLastNameField(),      701,  "Width of Last Name field is incorrect!");
	   Assert.assertEquals(registerPage.getHeightOfEmailField(),         34,  "Height of Email field is incorrect!");
	   Assert.assertEquals(registerPage.getWidthOfEmailField(),         701,  "Width of Email field is incorrect!");
	   Assert.assertEquals(registerPage.getHeigthOfTelephoneField(),     34,  "Height of Telephone field is incorrect!");
	   Assert.assertEquals(registerPage.getWidthOfTelephoneField(),     701,  "Width of Telephone field is incorrect!");
	   Assert.assertEquals(registerPage.getHeightOfPasswordField(),      34,  "Height of Password field is incorrect!");
	   Assert.assertEquals(registerPage.getWidthOfPasswordField(),      701,  "Width of Password field is incorrect!");
	   Assert.assertEquals(registerPage.getHeightOfConfPasswordField(),  34,  "Height of confPassword field is incorrect!");
	   Assert.assertEquals(registerPage.getWidthOfConfPasswordField() ,  701, "Width of confPassword field is incorrect!");

	}

	@When("User enters all data into registration fields by adding leading and trailing spaces")
	public void user_enters_all_data_into_registration_fields_by_adding_leading_and_trailing_spaces() {
		String firstName = "    "+GenericUtils.getRandomString(4)+"    ";
	    String lastName = "   "+GenericUtils.getRandomString(5)+"   ";
	    String email = "  "+GenericUtils.getRandomEmail()+"    ";
	    String telephone = "  "+GenericUtils.getRandomNumber(10)+"  ";
	    String password = GenericUtils.getRandomString(12);

        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enteremail(email);
        registerPage.enterTelephone(telephone);
        registerPage.enterpassword(password);
        registerPage.enterConfPassword(password);
        registerPage.acceptPrivacyPolicy();
	}
	@Then("User clicks on Edit your account information link")
	public void user_clicks_on_edit_your_account_information_link() {
        registerPage.clickEditAccountInformationLink();
	}

	@Then("User should able to see account created by information after removing leading and trailing spaces")
	public void user_should_able_to_see_account_created_by_information_after_removing_leading_and_trailing_spaces() {

       Assert.assertEquals(firstName, registerPage.getAttributeValueFirstName(),"FirstName field found spaces");
       Assert.assertEquals(lastName, registerPage.getAttributeValueLastName(),"LastName field found spaces");
       Assert.assertEquals(email, registerPage.getAttributeValueEmailField(),"Email field found spaces");
       Assert.assertEquals(telephone, registerPage.getAttributeValueTelephoneField(),"telephone field found spaces");

	}

	@Then("User should see the privacy policy checkbox is not selected bydefault")
	public void user_should_see_the_privacy_policy_checkbox_is_not_selected_bydefault() {

	 Assert.assertFalse(registerPage.checkPrivacyPolicyCheckboxSelected());
	}

	@Then("User enters mandatory registration details into fields except privacyPolicyCheckbox")
	public void user_enters_mandatory_registration_details_into_fields_except_privacy_policy_checkbox() {

		String firstName = GenericUtils.getRandomString(7);
	    String lastName = GenericUtils.getRandomString(8);
	    String email = GenericUtils.getRandomEmail();
	    String telephone = GenericUtils.getRandomNumber(10);
	    String password = GenericUtils.getRandomString(3);

	    registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enteremail(email);
        registerPage.enterTelephone(telephone);
        registerPage.enterpassword(password);
        registerPage.enterConfPassword(password);
	}
	@Then("User must get warning message for privancy policy")
	public void user_must_get_warning_message_for_privancy_policy() {
		Assert.assertEquals(registerPage.getPrivacyPolicyWarningMessage(), "Warning: You must agree to the Privacy Policy!");
	}

	@When("User enters some text into password field")
	public void user_enters_some_text_into_password_field() {
        String password = GenericUtils.getRandomString(3)+"@"+GenericUtils.getRandomNumber(4);
        registerPage.enterpassword(password);
        registerPage.enterConfPassword(password);
	}
	@Then("Password text entered into Password fields need to be toggled to hide its visibilty")
	public void password_text_entered_into_password_fields_need_to_be_toggled_to_hide_its_visibilty() {
		Assert.assertEquals(registerPage.getPasswordFieldType(), "password","Password field text is not toggling to '*'");
		Assert.assertEquals(registerPage.getConfPasswordFieldType(), "password","Confirm Password field text is not toggling to '*'");
	}

	@When("User clicks on links one by one present on Register Account page and verify navigated to same webpage and navigates back to register account page")
	public void user_clicks_on_links_one_by_one_present_on_register_account_page_and_verify_navigated_to_same_webpage_and_navigates_back_to_register_account_page() throws IOException {

		 clickedLinks = new HashSet<>();

        verifyLinksSection(registerPage.getRightColumnLinks());
        verifyLinksSection(registerPage.getCategoryLinks());
        verifyLinksSection(registerPage.getFooterLinks());
    }

    private void verifyLinksSection(List<WebElement> links) throws IOException {
        for (WebElement link : links) {
            String linkText = link.getText().trim();

            if (clickedLinks.contains(linkText) || linkText.equalsIgnoreCase("Register")) {
                System.out.println("Skipping link: " + linkText);
                continue;
            }

            clickedLinks.add(linkText);

            System.out.println("Clicking on link: " + linkText);
            link.click();

            WebDriverWait wait = new WebDriverWait(testContextSetup.testBase.WebDriverManager(), Duration.ofSeconds(5));
            try {
                wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Register Account")));
            } catch (Exception e) {
                System.out.println("Title did not change for link: " + linkText);
            }

            System.out.println("Navigated to page: " + testContextSetup.testBase.WebDriverManager().getTitle());

            testContextSetup.testBase.WebDriverManager().navigate().back();

            wait.until(ExpectedConditions.titleIs("Register Account"));
            Assert.assertTrue(testContextSetup.testBase.WebDriverManager().getTitle().equals("Register Account"),
                "User is not back on Register Account page after clicking link: " + linkText);
        }

	}

    @When("User clicks on Login button from Register Account Page")
	public void user_clicks_on_login_button_from_register_account_page() {
	   registerPage.clickLoginPageLink();
	}

    @Then("Proper Breadcrumb, Page Heading, Page URL and Page Title should be displayed")
    public void proper_breadcrumb_page_heading_page_url_and_page_title_should_be_displayed() {

    	Assert.assertTrue(registerPage.isProperRegisterPageBreadcrumbDisplayed(), "Proper breadcrumb is not displayed!");
    	Assert.assertEquals(registerPage.getRegisterPageTitle(), "Register Account", "Title is not displayed correct!");
    	Assert.assertEquals(registerPage.getURLofRegisterAccountPage(), "https://tutorialsninja.com/demo/index.php?route=account/register", "Url is not correct!");
    }

    @Then("Proper and good UI should be displayed on the Register Account page")
    public void proper_and_good_ui_should_be_displayed_on_the_register_account_page() {
        Assert.assertTrue(registerPage.isFirstNameFieldDisplayedAndEnabled(), "FirstName field is not appeared!");
        Assert.assertTrue(registerPage.isLastNameFieldDisplayedAndEnabled(),  "LastName field is not appeared!");
        Assert.assertTrue(registerPage.isEmailFieldDisplayedAndEnabled(), "Email field is not appeared!");
        Assert.assertTrue(registerPage.isTelephoneFieldDisplayedAndEnabled(), "Telephone field is not appeared!");
        Assert.assertTrue(registerPage.isPasswordFieldDisplayedAndEnabled(), "Password field is not appeared!");
        Assert.assertTrue(registerPage.isConfPasswordFieldDisplayedAndEnabled(), "ConfPassword field is not appeared!");
        Assert.assertTrue(registerPage.isYesAndNoRadioButtonFieldDisplayedAndEnabled(), "Radio buttons field is not appeared!");
        Assert.assertTrue(registerPage.isContinueButtonDisplayed(), "Continue button field is not appeared!");
    }

    @Then("Register Account functionality should work in all the supported browser")
    public void register_account_functionality_should_work_in_all_the_supported_browser() {

        Assert.assertEquals(registerPage.getRegisterPageTitle(), "Register Account");
    }
}
