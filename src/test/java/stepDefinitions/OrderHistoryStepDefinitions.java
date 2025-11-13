package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OrderHistoryPage;
import pageObjects.OrderInformationPage;
import testBase.TestContextSetup;

public class OrderHistoryStepDefinitions {

	TestContextSetup testContextSetup;
	OrderHistoryPage orderHistoryPage;
	OrderInformationPage orderInformationPage;

	public OrderHistoryStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.orderHistoryPage = testContextSetup.pageObjectManger.getOrderHistoryPage();
		this.orderInformationPage = testContextSetup.pageObjectManger.getOrderInformationPage();
	}

	@Then("User should see exact match Order ID, Date Added, Status, and Total details in order information page")
	public void user_should_see_exact_match_order_id_date_added_status_and_total_details_in_order_information_page() {
		testContextSetup.log.info("Verifying that Order ID, Date Added, Status, and Total details match in the Order Information page...");
		orderHistoryPage.verifyOrderDetails();
		testContextSetup.log.info("Verified Order ID, Date Added, Status, and Total details successfully in the Order Information page.");
	}

	@Then("All required columns and headers should be displayed correctly")
	public void all_required_columns_and_headers_should_be_displayed_correctly() {
		testContextSetup.log.info("Checking if all required headers are displayed correctly in the Order History table...");
		Assert.assertTrue(orderHistoryPage.verifyOrderHistoryTableRequiredHeadersAreDisplayed(),
				"Order history headers are not displayed as expected!");
		testContextSetup.log.info("All required Order History table headers are displayed correctly.");
	}

	@Then("User should navigates back to orderHistory page")
	public void user_should_navigates_back_to_order_history_page() {
		testContextSetup.log.info("Verifying that user navigated back to the Order History page...");
		Assert.assertTrue(orderHistoryPage.isOrderHistoryPageBreadcrumbIsDisplayed(),
				"Order History breadcrumb is not displayed as expected!");
		testContextSetup.log.info("User successfully navigated back to the Order History page.");
	}

	@Then("User should see dates in descending order in order history page")
	public void user_should_see_dates_in_descending_order_in_order_history_page() {
		testContextSetup.log.info("Validating that all order dates are displayed in descending order...");
		Assert.assertTrue(orderHistoryPage.verifyOrderHistoryDatesInDescendingOrder(),
				"Order History dates are not displayed in descending order!");
		testContextSetup.log.info("Order dates verified successfully in descending order.");
	}

	@Then("User order status should correctly display as Pending, Processing, Complete etc.")
	public void user_order_status_should_correctly_display_as_pending_processing_complete_etc() {
		testContextSetup.log.info("Verifying that all order statuses (Pending, Processing, Complete, etc.) are displayed correctly...");
		Assert.assertTrue(orderHistoryPage.verifyOrderStatus(),
				"Order history status is not displayed correctly!");
		testContextSetup.log.info("Order statuses verified successfully in Order History page.");
	}

	@When("User click on view button of any order")
	public void user_click_on_view_button_of_any_order() {
		testContextSetup.log.info("Clicking on 'View' button for an order in the Order History page...");
		orderHistoryPage.clickOrderHistoryViewButton();
		testContextSetup.log.info("Clicked on 'View' button successfully and navigated to Order Information page.");
	}

	@Then("User should see All past orders with correct details Order ID Status Date Total Action should be displayed")
	public void user_should_see_all_past_orders_with_correct_details_order_id_status_date_total_action_should_be_displayed() {
		testContextSetup.log.info("Verifying all past orders are displayed correctly with Order ID, Status, Date, Total, and Action columns...");
		Assert.assertTrue(orderHistoryPage.verifyOrderHistoryTableDisplayedCorrectly(),
				"Order History table is not displayed correctly!");
		testContextSetup.log.info("All past orders are displayed correctly with complete details.");
	}

	@Then("User should see You have not made any previous orders! message in order history page if there is no order")
	public void user_should_see_you_have_not_made_any_previous_orders_message_in_order_history_page_if_there_is_no_order() {
		testContextSetup.log.info("Checking if empty Order History message is displayed when no orders exist...");
		Assert.assertTrue(orderHistoryPage.verifyEmptyOrderHistory(),
				"'You have not made any previous orders!' message not displayed correctly!");
		testContextSetup.log.info("Verified 'You have not made any previous orders!' message successfully.");
	}

	@Then("User should be navigated to the Order History page")
	public void user_should_be_navigated_to_the_order_history_page() {
		testContextSetup.log.info("Verifying that user is navigated to the Order History page...");
		Assert.assertTrue(orderHistoryPage.isOrderHistoryPageBreadcrumbIsDisplayed(),
				"User is not on the Order History page!");
		testContextSetup.log.info("User successfully landed on the Order History page.");
	}

	@Then("User should see correct navigation path Home > My Account > Order History")
	public void user_should_see_correct_navigation_path_home_my_account_order_history() {
		testContextSetup.log.info("Verifying breadcrumb navigation path: Home > My Account > Order History...");
		Assert.assertTrue(orderHistoryPage.verifyOrderHistoryBreadcrumbPath(),
				"Order History breadcrumb navigation path is incorrect!");
		testContextSetup.log.info("Verified breadcrumb navigation path successfully: Home > My Account > Order History.");
	}
}
