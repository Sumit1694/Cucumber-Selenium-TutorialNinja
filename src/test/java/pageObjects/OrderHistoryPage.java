package pageObjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderHistoryPage extends BasePage {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement orderHistoryBreadcrumb;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li") private List<WebElement> breadcrumbItems;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[1]//a//i") private WebElement homeIconBreadcrumb;
	@FindBy(xpath = "//p[text()='You have not made any previous orders!']") private WebElement emptyOrderHistoryPage;
	@FindBy(xpath = "//div[@id='content']//h1") private WebElement orderHistoryHeading;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']") private WebElement orderHistoryTable;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//thead//tr/td") private List<WebElement> orderHistoryTableHeadings;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//td[7]//a") private List<WebElement> orderHistoryViewButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//tr//td[4]") private List<WebElement> orderStatusList;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//td[6]") private List<WebElement> orderHistoryDates;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//thead//tr//td") private List<WebElement> orderHistoryTableHeaders;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//tr") private List<WebElement> orderHistoryTableRows;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody/tr") private List<WebElement> orderRows;
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/b[contains(text(),'Order ID:')]/following-sibling::text()[1]") private WebElement orderInfoIdText;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover'][3]//tbody//td[1]") private WebElement orderInfoDateAddedValue;
	@FindBy(xpath = "(//table[contains(@class,'table')])[1]//tr[1]/td[1]") private WebElement orderInfoHeaderCell;
    @FindBy(xpath = "(//table[contains(@class,'table')])[3]//tbody//td[2]") private WebElement orderInfoStatusValue;
	@FindBy(xpath = "(//table[contains(@class,'table')])[4]//tfoot//tr[last()]//td[2]") private WebElement orderInfoTotalValue;
	@FindBy(xpath = "(//table[contains(@class,'table')])[1]//tr[1]/td[1]") private WebElement orderInfoDateCell;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[1]") private WebElement firstOrderRow;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[last()]//a[contains(@href,'view')]") private WebElement firstViewButton;

	public void verifyOrderDetails() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        //Wait for the table to appear
	        WebElement orderTable = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//table[@class='table table-bordered table-hover']")
	        ));

	        //Get all rows except the header
	        List<WebElement> rows = orderTable.findElements(By.xpath(".//tbody/tr"));

	        if (rows.size() == 0) {
	            System.out.println("No orders available in Order History table!");
	            Assert.fail("No orders available to verify.");
	            return;
	        }

	        // Extract first row data (excluding header)
	        WebElement firstRow = rows.get(0);
	        String orderId = firstRow.findElement(By.xpath("./td[1]")).getText().trim();
	        String dateAdded = firstRow.findElement(By.xpath("./td[2]")).getText().trim();
	        String status = firstRow.findElement(By.xpath("./td[4]")).getText().trim();
	        String total = firstRow.findElement(By.xpath("./td[5]")).getText().trim();

	        System.out.println("Order History Page Data:");
	        System.out.println("Order ID: " + orderId);
	        System.out.println("Date Added: " + dateAdded);
	        System.out.println("Status: " + status);
	        System.out.println("Total: " + total);

	        //Check if the "View" button exists for this order
	        List<WebElement> viewButtons = firstRow.findElements(By.xpath("//a[@data-original-title='View']"));
	        if (viewButtons.isEmpty()) {
	            System.out.println("No 'View' button found for the order!");
	            Assert.fail("No 'View' button available to click.");
	            return;
	        }

	        // Click on the "View" button
	        WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(viewButtons.get(0)));
	        viewButton.click();

	        // Wait for Order Information page to load
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Order Information']")));

	        // Fetch order details from Order Information page
	        String infoOrderId = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//td[contains(text(),'Order ID')]"))
	                                   .getText().replace("Order ID: ", "").trim();
	        String infoDateAdded = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//td[contains(text(),'Date Added')]"))
	                                     .getText().replace("Date Added: ", "").trim();
	        String infoStatus = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//td[contains(text(),'Status')]"))
	                                  .getText().replace("Status: ", "").trim();
	        String infoTotal = driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover']//tr[last()]/td)[2]"))
	                                 .getText().trim();

	        System.out.println("Order Information Page Data:");
	        System.out.println("Order ID: " + infoOrderId);
	        System.out.println("Date Added: " + infoDateAdded);
	        System.out.println("Status: " + infoStatus);
	        System.out.println("Total: " + infoTotal);

	        //Validate both pages show matching details
	        Assert.assertEquals(infoOrderId, orderId, "Order ID mismatch!");
	        Assert.assertEquals(infoDateAdded, dateAdded, "Date Added mismatch!");
	        Assert.assertEquals(infoStatus, status, "Status mismatch!");
	        Assert.assertEquals(infoTotal, total, "Total mismatch!");

	    } catch (Exception e) {
	        System.out.println("Error while verifying Order details: " + e.getMessage());
	        Assert.fail("Failed while verifying Order details");
	    }
	}


	public boolean verifyOrderHistoryTableRequiredHeadersAreDisplayed() {
		try {
			List<String> expectedHeaders = Arrays.asList("Order ID","Customer","No. of Products","Status","Total","Date Added","");
			List<String> actualHeaders = orderHistoryTableHeaders.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
			System.out.println("Expected Headers: " + expectedHeaders);
			System.out.println("Actual Headers:   " + actualHeaders);
			if (expectedHeaders.equals(actualHeaders)) {
				return true;
			} else {
				System.out.println("Header mismatch found!");
				for (int i = 0; i < Math.min(expectedHeaders.size(), actualHeaders.size()); i++) {
					if (!expectedHeaders.get(i).equals(actualHeaders.get(i)))
					{
						System.out.println("Mismatch at position " + (i + 1) + ": expected '" + expectedHeaders.get(i) + "' but found '" + actualHeaders.get(i) + "'");
					}
				}
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyOrderHistoryDatesInDescendingOrder()
	{
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			List<Date> actualDates = new ArrayList<>();
			for(WebElement dateElement : orderHistoryDates)
			{
				String dateText = dateElement.getText().trim();
				if(!dateText.isEmpty())
				{
					actualDates.add(sdf.parse(dateText));
				}
			}

			List<Date> sortedDates = new ArrayList<>(actualDates);
			sortedDates.sort(Collections.reverseOrder());

			boolean isDescending = actualDates.equals(sortedDates);

			if(isDescending) {
				System.out.println("Order history dates are displayed in descending order!");
			}else {
				System.out.println("Order history dates are not in descending order.");
				System.out.println("Actual: " + actualDates);
				System.out.println("Expected: " + sortedDates);
			}
			return isDescending;
		}catch(Exception e) {
			System.out.println("Exception while verifying order history dates: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyOrderStatus()
	{
		try {
			for(WebElement statusElement : orderStatusList)
			{
				String statusText = statusElement.getText().trim().toLowerCase();

				if(statusText.equals("pending") || statusText.equals("processing") || statusText.equals("complete"))
				{
					System.out.println("valid order status found: " + statusText);
				}else {
					System.out.println("unexpected status found: " + statusText);
					return false;
				}
			}
			return true;
		}catch(Exception e) {
			System.out.println("Exception while verifying order status: " + e.getMessage());
			return false;
		}
	}

	public void clickOrderHistoryViewButton()
	{
		for(WebElement viewButton:orderHistoryViewButton)
		{
			viewButton.click();
			break;
		}
	}

	public boolean verifyOrderHistoryTableDisplayedCorrectly() {
		List<String> expectedColumns = Arrays.asList("Order ID", "Customer", "No. of Products", "Status", "Total", "Date Added");

		List<String> actualColumns = new ArrayList<>();
		for (WebElement heading : orderHistoryTableHeadings) {
			String text = heading.getText().trim();
			if (!text.isEmpty()) {
				actualColumns.add(text);
			}
		}

		boolean allColumnsPresent = actualColumns.containsAll(expectedColumns);
		boolean orderRowsPresent = orderHistoryTableRows.size() > 0;

		if (allColumnsPresent && orderRowsPresent) {
			System.out.println("Order History table displayed correctly with all expected columns and order entries.");
			return true;
		} else {
			System.out.println("Order History table verification failed!");
			System.out.println("Expected Columns: " + expectedColumns);
			System.out.println("Actual Columns: " + actualColumns);
			System.out.println("Order Rows Count: " + orderHistoryTableRows.size());
			return false;
		}
	}

	public boolean verifyEmptyOrderHistory()
	{
		return waitUtils.waitForElementVisibility(emptyOrderHistoryPage, 10).isDisplayed();
	}

	public boolean verifyOrderHistoryBreadcrumbPath() {
		try {
			List<String> actualBreadcrumbs = new ArrayList<>();
			for (int i = 0; i < breadcrumbItems.size(); i++) {
				WebElement item = breadcrumbItems.get(i);
				String text = item.getText().trim();
				if (i == 0 && text.isEmpty()) {
					if (homeIconBreadcrumb.isDisplayed()) {
						text = "Home";
					}
				}
				if (!text.isEmpty() && !text.equals(">") && !text.equals("/")) {
					actualBreadcrumbs.add(text);
				}
			}
			List<String> expectedBreadcrumbs = Arrays.asList("Home", "Account", "Order History");
			if (actualBreadcrumbs.size() != expectedBreadcrumbs.size()) {
				System.out.println("Breadcrumb count mismatch! Expected " + expectedBreadcrumbs.size() + " but found " + actualBreadcrumbs.size());
				return false;
			}
			for (int i = 0; i < expectedBreadcrumbs.size(); i++) {
				if (!actualBreadcrumbs.get(i).equalsIgnoreCase(expectedBreadcrumbs.get(i))) {
					System.out.println("Mismatch at position " + i + ": expected '" + expectedBreadcrumbs.get(i) + "' but found '" + actualBreadcrumbs.get(i) + "'");
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("Failed to verify Order History breadcrumb path: " + e.getMessage());
			return false;
		}
	}

	public boolean isOrderHistoryPageBreadcrumbIsDisplayed()
	{
		try {
			return waitUtils.waitForElementVisibility(orderHistoryBreadcrumb, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("order history breadcrumb is not displayed!" + e.getMessage());
			return false;
		}
	}



}
