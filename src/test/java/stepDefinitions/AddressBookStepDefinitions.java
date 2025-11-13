package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddressBookPage;
import testBase.TestContextSetup;

public class AddressBookStepDefinitions {

    TestContextSetup testContextSetup;
    AddressBookPage addressBookPage;

    public AddressBookStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.addressBookPage = testContextSetup.pageObjectManger.getAddressBookPage();
        testContextSetup.log.info("Initialized AddressBookStepDefinitions...");
    }

    @Then("User click on breadcrumb verify page is refreshed and User remains on same page")
    public void user_click_on_breadcrumb() {
        testContextSetup.log.info("Verifying that clicking on Address Book breadcrumb refreshes the page but keeps the user on the same page...");
        Assert.assertTrue(addressBookPage.verifyAddressBookWorking(), "Address Book breadcrumb did not work as expected!");
        testContextSetup.log.info("Address Book breadcrumb verified successfully. Page refreshed and remained on the same page.");
    }

    @When("User should able to see newly added address in address book")
    public void user_should_able_to_see_newly_added_address_in_address_book() {
        testContextSetup.log.info("Checking if newly added address is visible in the Address Book...");
        boolean hasTwoAddresses = addressBookPage.areTwoAddressesPresent();
        Assert.assertTrue(hasTwoAddresses, "Expected 2 addresses, but count is different!");
        testContextSetup.log.info("Verified: Newly added address is visible. Two addresses are present as expected.");
    }

    @When("User delete all address only default one should be remaining")
    public void user_delete_all_address_only_default_one_should_be_remaining() {
        testContextSetup.log.info("Deleting all addresses until only the default one remains...");
        Assert.assertTrue(addressBookPage.deleteAddressesUntilDefaultRemains(), "Default address was not the only one remaining!");
        testContextSetup.log.info("All non-default addresses deleted successfully. Only default address remains.");
    }

    @Then("User Edit newly added address and select as default address radio button and click continue")
    public void user_edit_newly_added_address_and_select_as_default_address_radio_button_and_click_continue() {
        testContextSetup.log.info("Editing a non-default address and selecting it as the default...");
        Assert.assertTrue(addressBookPage.makeAddressDefaultAndValidate(), "Unable to make the address as default!");
        testContextSetup.log.info("Address successfully marked as default and validated.");
    }

    @When("User click delete option of default address in address book page")
    public void user_click_delete_option_of_default_address_in_address_book_page() {
        testContextSetup.log.info("Attempting to delete the default address...");
        addressBookPage.clickDeleteBtnDefaultAddress();
        testContextSetup.log.info("Delete button clicked for default address.");
    }

    @Then("User can see system should not allow deletion of default address validation message displayed")
    public void user_can_see_system_should_not_allow_deletion_of_default_address_validation_message_displayed() {
        testContextSetup.log.info("Verifying that system does not allow deletion of default address...");
        Assert.assertTrue(addressBookPage.verifyDefaultAddressCannotBeDeleted(), "Default address deletion was allowed!");
        testContextSetup.log.info("Validation message displayed correctly. System prevented deletion of default address.");
    }

    @When("User click delete option in address book page")
    public void user_click_delete_option_in_address_book_page() {
        testContextSetup.log.info("Clicking delete button for a non-default address...");
        addressBookPage.clickDeleteBtnNewAddress();
        testContextSetup.log.info("Delete button clicked for non-default address.");
    }

    @Then("User can see success message Your address has been successfully deleted in the address book page")
    public void user_can_see_success_message_your_address_has_been_successfully_deleted_in_the_address_book_page() {
        testContextSetup.log.info("Verifying success message after deleting an address...");
        Assert.assertTrue(addressBookPage.isAddressDeletedSuccessMsg(), "Address deleted success message not displayed!");
        testContextSetup.log.info("Success message displayed correctly after address deletion.");
    }

    @When("User click Edit option in address book page")
    public void user_click_edit_option_in_address_book_page() {
        testContextSetup.log.info("Clicking Edit button for an address entry...");
        addressBookPage.clickEditBtn();
        testContextSetup.log.info("Edit button clicked successfully.");
    }

    @Then("User should see correct error message of invalid postcode field")
    public void user_should_see_correct_error_message_of_invalid_postcode_field() {
        testContextSetup.log.info("Verifying validation message for invalid postcode field...");
        Assert.assertTrue(addressBookPage.isPostcodeErrorDisplayed(),
                "Expected postcode validation message was not displayed. Application allowed invalid postcode!");
        testContextSetup.log.info("Invalid postcode validation message verified successfully.");
    }

    @When("User click new address button when new account created")
    public void user_click_new_address_button_when_new_account_created() {
        testContextSetup.log.info("Clicking New Address button after new account creation...");
        addressBookPage.clickNewAddressBtnWhenNewAccCreated();
        testContextSetup.log.info("New Address button clicked successfully after account creation.");
    }

    @When("User click new address button")
    public void user_click_new_address_button() {
        testContextSetup.log.info("Clicking New Address button from Address Book page...");
        addressBookPage.clickNewAddressBtn();
        testContextSetup.log.info("New Address button clicked successfully.");
    }

    @Then("User should see success message Your address has been successfully added appeared")
    public void user_should_see_success_message_your_address_has_been_successfully_added_appeared() {
        testContextSetup.log.info("Verifying success message after adding a new address...");
        Assert.assertTrue(addressBookPage.isNewAddressAddedSuccessMsg(), "Success message for new address addition not displayed!");
        testContextSetup.log.info("Success message displayed correctly after adding new address.");
    }

    @Then("User should see new address button in address book page")
    public void user_should_see_new_address_button_in_address_book_page() {
        testContextSetup.log.info("Verifying New Address button visibility and clickability...");
        Assert.assertTrue(addressBookPage.isNewAddressButtonIsVisibleAndClickable(),
                "New Address button is not displayed or clickable!");
        testContextSetup.log.info("New Address button is visible and clickable as expected.");
    }

    @Then("User should be navigated to the Address Book page successfully")
    public void user_should_be_navigated_to_the_address_book_page_successfully() {
        testContextSetup.log.info("Verifying that user is navigated to Address Book page...");
        Assert.assertTrue(addressBookPage.isAddressBookBreadCrumbIsDisplayed(),
                "Address Book breadcrumb not displayed after navigation!");
        testContextSetup.log.info("User successfully navigated to Address Book page. Breadcrumb verified.");
    }

    @Then("User should see Address Book Entries page heading")
    public void user_should_see_address_book_entries_page_heading() {
        testContextSetup.log.info("Verifying Address Book Entries page heading...");
        Assert.assertTrue(addressBookPage.isAddressBookPageHeadingIsDisplayed(),
                "Address Book page heading not displayed!");
        testContextSetup.log.info("Address Book Entries page heading displayed successfully.");
    }
}
