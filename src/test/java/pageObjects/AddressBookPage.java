package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPage extends BasePage {

	public AddressBookPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement breadCrumbAddressBook;
	@FindBy(xpath = "//div[@class='row']//div/h2") private WebElement headingOfAddressBookPage;
	@FindBy(xpath = "//a[text()='New Address']") private WebElement newAddressBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-success') and contains(text(),'Your address has been successfully added')]") private WebElement newAddressAddedSuccessMsg;
	@FindBy(xpath = "//a[text()='New Address']")  private WebElement newAddressBtnWhenNewAccCreated;
	@FindBy(xpath = "//div[contains(@class,'text-danger') and contains(text(),'Postcode')]") private WebElement postcodeErrorMessage;
	@FindBy(xpath = "//a[@class='btn btn-info']") private WebElement editBtn;
	@FindBy(xpath = "//table[contains(@class,'table ')]//tr[1]//td[2]/a[contains(@class,'btn btn-danger')]") private WebElement deleteBtndefualtAddress;
	@FindBy(xpath = "//tbody/tr[2]/td[2]/a[2]") private WebElement deleteBtnNewAddress;
	@FindBy(xpath = "//div[contains(@class,'alert-success') and contains(normalize-space(.),'Your address has been successfully deleted')]") private WebElement addressDeleteSuccessMsg;
	@FindBy(xpath = "//div[contains(@class,'alert-warning') and contains(normalize-space(text()),'Warning: You must have at least one address!')]") private WebElement addressWarningMsg;
	@FindBy(xpath = "//a[contains(@href,'delete')]") private List<WebElement> deleteButtons;
	@FindBy(xpath = "//div[contains(@class,'alert')]") private WebElement alertMessage;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement breadCrumbAddressBookPage;

	public boolean verifyAddressBookWorking()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(breadCrumbAddressBookPage));
			if(breadCrumbAddressBookPage.isDisplayed())
			{
				String beforeClickUrl = driver.getCurrentUrl();
				breadCrumbAddressBookPage.click();
				wait.until(ExpectedConditions.urlToBe(beforeClickUrl));
				String afterCLickUrl = driver.getCurrentUrl();

				if(beforeClickUrl.equals(afterCLickUrl))
				{
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
            }catch(Exception e) {
            	return false;
            }
	}

	public boolean areTwoAddressesPresent() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        List<WebElement> addressRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='table-responsive']//table//tbody/tr")));
	        int totalAddresses = addressRows.size();
	        System.out.println("Total addresses found: " + totalAddresses);
	        // Check if exactly 2 addresses are present
	        return totalAddresses == 2;
	    } catch (Exception e) {
	        System.out.println("Failed to count addresses in Address Book: " + e.getMessage());
	        return false;
	    }
	}

	public boolean deleteAddressesUntilDefaultRemains() {
	    List<WebElement> deleteButtons;
	    boolean defaultAddressProtected = false;

	    while (true) {
	        deleteButtons = driver.findElements(By.xpath("//a[text()='Delete']"));

	        // If no delete button found → break
	        if (deleteButtons.isEmpty()) {
	            System.out.println("No delete button found, breaking loop...");
	            break;
	        }

	        // Click first delete button
	        deleteButtons.get(0).click();

	        // Wait for alert message to appear
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[contains(@class,'alert')]")
	        ));

	        String alertText = alert.getText().trim();
	        System.out.println("Alert message displayed: " + alertText);

	        // Case 1: Address deleted successfully
	        if (alertText.contains("successfully deleted")) {
	            // Wait until alert disappears before continuing
	            try {
	                wait.until(ExpectedConditions.invisibilityOf(alert));
	            } catch (Exception e) {
	                System.out.println("Alert did not disappear quickly; continuing...");
	            }

	            // Re-check remaining addresses
	            int remaining = driver.findElements(By.xpath("//a[text()='Delete']")).size();
	            System.out.println("Remaining addresses: " + remaining);
	        }

	        // Case 2: Default address cannot be deleted
	        else if (alertText.contains("Warning: You can not delete your default address!")) {
	            System.out.println("Default address cannot be deleted — as expected ✅");
	            defaultAddressProtected = true;
	            break; // stop loop
	        }

	        // Case 3: Must have at least one address
	        else if (alertText.contains("Warning: You must have at least one address!")) {
	            System.out.println("Warning displayed: " + alertText);
	            defaultAddressProtected = true;
	            break;
	        }

	        else {
	            System.out.println("Unexpected alert: " + alertText);
	            break;
	        }
	    }

	    return defaultAddressProtected;
	}



	public boolean makeAddressDefaultAndValidate() {
		try {
			waitUtils.waitForElementVisibility(editBtn, 10).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement regionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-zone")));
			String selectedRegion = new Select(regionDropdown).getFirstSelectedOption().getText().trim();
			WebElement yesDefaultRadioBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='1']")));
			yesDefaultRadioBtn.click();
			WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
			continueBtn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-bordered table-hover']")));
			List<WebElement> addressRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tr"));
			for (WebElement row : addressRows) {
				String addressText = row.findElement(By.xpath("./td[1]")).getText();
				if (addressText.contains(selectedRegion)) {
					WebElement deleteBtn = row.findElement(By.xpath(".//a[contains(@href,'delete')]"));
					deleteBtn.click();
					By warningMsgLocator = By.xpath("//div[contains(@class,'alert') and contains(normalize-space(.), 'Warning: You can not delete your default address')]");

					try {
						WebElement warningMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(warningMsgLocator));
						if (warningMsg.isDisplayed()) {
							System.out.println("Validation Passed: Default address cannot be deleted. Warning message displayed.");
							return true;
						} else {
							System.out.println("Warning message element found but not displayed.");
							return false;
						}
					} catch (TimeoutException te) {
						System.out.println("Warning message not visible within timeout: " + te.getMessage());
						return false;
					}
				}
			}

			System.out.println("No matching address found for region: " + selectedRegion);
			return false;

		} catch (Exception e) {
			System.out.println("Failed to make address default and validate deletion: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyDefaultAddressCannotBeDeleted() {
		try {
			waitUtils.waitForPageLoad(10);
			String defaultAddressWarningMsg = waitUtils.waitForElementVisibility(addressWarningMsg, 10).getText();
			return defaultAddressWarningMsg.equals("Warning: You must have at least one address!");
		} catch (Exception e) {
			System.out.println("Error verifying default address warning: " + e.getMessage());
			return false;
		}
	}

	public boolean isAddressDeletedSuccessMsg()
	{
		try {
			waitUtils.waitForElementVisibility(addressDeleteSuccessMsg, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Address deleted success message is not displayed " + e.getMessage());
			return false;
		}
	}

	public void clickDeleteBtnNewAddress()
	{
		try {
			waitUtils.waitForElementClickable(deleteBtnNewAddress, 10).click();
		}catch(Exception e) {
			System.out.println("User can't click delete button!");
		}
	}

	public void clickDeleteBtnDefaultAddress()
	{
		try {
			waitUtils.waitForElementClickable(deleteBtndefualtAddress, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(deleteBtndefualtAddress).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("User can't click delete button!");
		}
	}

	public void clickEditBtn()
	{
		try {
			waitUtils.waitForElementVisibility(editBtn, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(editBtn).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("Edit button is not clickable! " + e.getMessage());
		}
	}

	public boolean isPostcodeErrorDisplayed() {
		try {
			return postcodeErrorMessage.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickNewAddressBtnWhenNewAccCreated()
	{
		try {
			waitUtils.waitForElementClickable(newAddressBtnWhenNewAccCreated, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(newAddressBtnWhenNewAccCreated).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("New address btn is not visible to click!" + e.getMessage());
		}
	}

	public boolean isNewAddressAddedSuccessMsg()
	{
		try {
			waitUtils.waitForElementVisibility(newAddressAddedSuccessMsg, 10);
			return newAddressAddedSuccessMsg.isDisplayed();
		}catch(Exception e) {
			System.out.println("Success message not displayed: " +e.getMessage());
			return false;
		}
	}

	public void clickNewAddressBtn()
	{
		try {
			waitUtils.waitForElementVisibility(newAddressBtn, 10);
			waitUtils.scrollToElement(newAddressBtn);
			Actions actions = new Actions(driver);
			actions.moveToElement(newAddressBtn).pause(Duration.ofSeconds(10)).click().perform();
		}catch(Exception e) {
			System.out.println("new Address btn is not clicked!" + e.getMessage());
		}
	}

	public boolean isNewAddressButtonIsVisibleAndClickable()
	{
		try {
			WebElement element = waitUtils.waitForElementVisibility(newAddressBtn, 10);
			waitUtils.scrollToElement(element);
			return element.isDisplayed() && element.isEnabled();
		}catch(Exception e) {
			System.out.println("new Address button is not displayed and enabled!" + e.getMessage());
			return false;
		}
	}

	public boolean isAddressBookPageHeadingIsDisplayed()
	{
		try {
			String actualHeading = waitUtils.waitForElementVisibility(headingOfAddressBookPage, 10).getText();
			String expectedHeading = "Address Book Entries";
			return actualHeading.equalsIgnoreCase(expectedHeading);
		}catch(Exception e) {
			System.out.println("Address book page heading is not displayed! " + e.getMessage());
			return false;
		}
	}

	public boolean isAddressBookBreadCrumbIsDisplayed()
	{
		try {
			return waitUtils.waitForElementVisibility(breadCrumbAddressBook, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("Address book page breadcrumb is not displayed: " + e.getMessage());
			return false;
		}
	}




}
