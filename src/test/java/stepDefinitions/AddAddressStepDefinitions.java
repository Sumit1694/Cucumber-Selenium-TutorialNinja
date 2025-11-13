package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddAddressPage;
import testBase.TestContextSetup;

public class AddAddressStepDefinitions {

    TestContextSetup testContextSetup;
    AddAddressPage addAddressPage;

    public AddAddressStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.addAddressPage = testContextSetup.pageObjectManger.getAddAddressPage();
        testContextSetup.log.info("Initialized AddAddressStepDefinitions...");
    }

    @When("User modify city field")
    public void user_modify_city_field() {
        testContextSetup.log.info("Attempting to modify the City field...");
        Assert.assertTrue(addAddressPage.modifyCityField(), "City field was not modified successfully!");
        testContextSetup.log.info("City field modified successfully.");
    }

    @Then("User updates city field and navigates back and come back to same page then city field should not be updated")
    public void user_updates_city_field_and_navigates_back_and_come_back_to_same_page_then_city_field_should_not_be_updated() {
        testContextSetup.log.info("Verifying that City field retains its previous value after navigating back and returning...");
        Assert.assertTrue(addAddressPage.isCityFieldShowsExistingValueAfterBackAndComeBack(),
                "City field value was unexpectedly updated!");
        testContextSetup.log.info("City field retains its previous value as expected.");
    }

    @Then("User can see success message Your address has been successfully updated should appear")
    public void user_can_see_success_message_your_address_has_been_successfully_updated_should_appear() {
        testContextSetup.log.info("Verifying that the success message for updated address is displayed...");
        Assert.assertTrue(addAddressPage.addressModifiedSuccessMsgIsDisplayed(),
                "Success message for updated address is not displayed!");
        testContextSetup.log.info("Success message for updated address displayed successfully.");
    }

    @When("User fill all details with adress length exceeds max limit")
    public void user_fill_all_details_with_adress_length_exceeds_max_limit() {
        testContextSetup.log.info("Filling address details with input exceeding maximum allowed length...");
        Assert.assertTrue(addAddressPage.fillAllAddressDetailsWithExceedingAddressLimit(),
                "Address accepted input beyond the allowed character limit!");
        testContextSetup.log.info("Address field length validation working correctly (max limit enforced).");
    }

    @Then("User should see correct Error message indicating max length exceeded")
    public void user_should_see_correct_error_message_indicating_max_length_exceeded() {
        testContextSetup.log.info("Verifying the error message displayed for exceeding maximum address length...");
        Assert.assertTrue(addAddressPage.verifyAddressLimitExceedsValidationMessageIsDisplayed(),
                "Error message for exceeding address length not displayed correctly!");
        testContextSetup.log.info("Correct error message displayed for exceeding maximum address length.");
    }

    @When("User fill all details with invalid postcode field of new address in add address page")
    public void user_fill_all_details_with_invalid_postcode_field_of_new_address_in_add_address_page() {
        testContextSetup.log.info("Filling all address details with invalid Postcode value...");
        Assert.assertTrue(addAddressPage.fillAllAddressDetailsWithInvalidPostCodeField(),
                "Invalid Postcode value was not entered properly!");
        testContextSetup.log.info("Invalid Postcode value entered successfully for validation check.");
    }

    @Then("User should see validation message for all the mandatory fields")
    public void user_should_see_validation_message_for_all_the_mandatory_fields() {
        testContextSetup.log.info("Verifying validation messages for all mandatory fields on Add Address page...");
        Assert.assertTrue(addAddressPage.verifyAllFieldsValidationMsgs(),
                "Validation messages for mandatory fields are missing or incorrect!");
        testContextSetup.log.info("All mandatory field validation messages verified successfully.");
    }

    @When("User click continue btn on add address page")
    public void user_click_continue_btn_on_add_address_page() {
        testContextSetup.log.info("Clicking on Continue button on Add Address page...");
        addAddressPage.clickContinueBtn();
        testContextSetup.log.info("Clicked on Continue button successfully.");
    }

    @When("User fill all details of new address in add address page")
    public void user_fill_all_details_of_new_address_in_add_address_page() {
        testContextSetup.log.info("Filling all required details for new address...");
        Assert.assertTrue(addAddressPage.fillAllAddressDetails(), "New address details were not filled properly!");
        testContextSetup.log.info("All required address details filled successfully.");
    }
}
