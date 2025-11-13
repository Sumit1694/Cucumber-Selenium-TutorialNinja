package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import utilities.AddAddressTestData;
import utilities.GenericUtils;
import utilities.TestData;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']") private WebElement MyAccountPageTitle;
	@FindBy(xpath="//a[contains(text(),'Subscribe / unsubscribe to newsletter')]") private WebElement SubscriberUnsubscribeLink;
	@FindBy(xpath="//div[@class='list-group']//a[13]") private WebElement isLogoutButtonDisplayed;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li[5]") private WebElement logoutButtonlnk;
	@FindBy(xpath="//a[normalize-space()='Change your password']") private WebElement changeYourPasswordLnk;
	@FindBy(xpath="//span[@class='caret']") private WebElement myAccountDropMenu;
	@FindBy(xpath="//a[normalize-space()='Login']") private WebElement loginButtonInDrpDwn;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") private WebElement logoutBtnrightcolmn;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a") private List<WebElement> myAccountOptions;
	@FindBy(xpath="//a[@id='wishlist-total']//span") private WebElement wishListHeaderOption;
	@FindBy(xpath="//a[normalize-space()='View your order history']") private WebElement orderHistoryLink;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement myAccountPageBreadcrumb;
	@FindBy(xpath = "//h2[normalize-space()='My Account']") private WebElement pageHeading;
	@FindBy(xpath = "//a[normalize-space()='Edit your account information']") private WebElement EditYourAccountInfoLink;
	@FindBy(xpath = "//div[contains(@class,'alert-success') and contains(text(),'Your account has been successfully updated')]") private WebElement accountSuccessfullyUpdatedSuccessMsg;
	@FindBy(xpath = "//div[contains(@class,'alert-success') and contains(text(),'Your password has been successfully updated')]") private WebElement passwordUpdatedSuccessMsg;
	@FindBy(xpath = "//a[normalize-space()='Change your password']") private WebElement changeYourPasswordLink;
	@FindBy(xpath = "//a[text()='Password']") private WebElement rightColmnPasswordLink;
	@FindBy(xpath = "//a[normalize-space()='Modify your address book entries']") private WebElement addressBooklnk;
	@FindBy(xpath = "//a[text()='View your order history']") private WebElement orderHistorylink;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Order History']") private WebElement orderHistorydrpdwn;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li//a[contains(text(),'Register for an affiliate account')]") private WebElement affiliateAccountLink;
	@FindBy(xpath = "//div[contains(@class,'alert') and contains(text(),'Success: Your account has been successfully updated.')]") private WebElement affiliateAccountcreatedSuccessMsg;
	@FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']") private WebElement subscribeUnsubscribeLink;
	@FindBy(xpath = "//a[text()='Newsletter']") private WebElement newsLetterRightColmnOption;
	@FindBy(xpath = "//div[contains(@class,'alert') and contains(text(),'Success')]") private WebElement successMsg;
	@FindBy(xpath = "//a[text()='Specials']") private WebElement specialOffersLink;
	@FindBy(xpath = "//div[@id='search']//button") private WebElement searchFieldButton;
	@FindBy(xpath = "//a[normalize-space()='Logout']") private WebElement logoutButton;
	@FindBy(xpath = "//h2[normalize-space()='My Account']") private WebElement myAccountHeading;
	@FindBy(xpath = "//div[@id='content']//li[3]//a[text()='Modify your address book entries']") private WebElement modifyYourAddressLink;
	@FindBy(xpath = "//div[@class='pull-right']//a[text()='New Address']") private WebElement newAddressBtn;

	public boolean AddAddressForUser() {
	    try {
	        waitUtils.waitForElementVisibility(myAccountPageBreadcrumb, 10);
	        waitUtils.waitForElementClickable(modifyYourAddressLink, 10).click();

	        waitUtils.waitForElementVisibility(
	                driver.findElement(By.xpath("//ul[@class='breadcrumb']//li[3]//a[text()='Address Book']")), 10);
	        WebElement newAddressBtn = waitUtils.waitForElementClickable(
	                driver.findElement(By.xpath("//div[@class='pull-right']//a[text()='New Address']")), 10);
	        newAddressBtn.click();

	        // Fill all details
	        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
	        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
	        WebElement companyField = driver.findElement(By.id("input-company"));
	        WebElement address1Field = driver.findElement(By.id("input-address-1"));
	        WebElement address2Field = driver.findElement(By.id("input-address-2"));
	        WebElement cityField = driver.findElement(By.id("input-city"));
	        WebElement postCodeField = driver.findElement(By.id("input-postcode"));
	        WebElement countryField = driver.findElement(By.id("input-country"));
	        WebElement regionField = driver.findElement(By.id("input-zone"));

	        AddAddressTestData.firstName = GenericUtils.getRandomString(6);
	        AddAddressTestData.lastName = GenericUtils.getRandomString(6);
	        AddAddressTestData.company = GenericUtils.getRandomString(6);
	        AddAddressTestData.Address1 = GenericUtils.getRandomString(19);
	        AddAddressTestData.Address2 = GenericUtils.getRandomString(22);
	        AddAddressTestData.city = GenericUtils.getRandomString(6);
	        AddAddressTestData.postCode = GenericUtils.getRandomNumber(6);

	        firstNameField.sendKeys(AddAddressTestData.firstName);
	        lastNameField.sendKeys(AddAddressTestData.lastName);
	        companyField.sendKeys(AddAddressTestData.company);
	        address1Field.sendKeys(AddAddressTestData.Address1);
	        address2Field.sendKeys(AddAddressTestData.Address2);
	        cityField.sendKeys(AddAddressTestData.city);
	        postCodeField.sendKeys(AddAddressTestData.postCode);

	        // ✅ Click and select country manually (Uganda)
	        countryField.click();
	        Thread.sleep(500); // wait for options to appear
	        List<WebElement> countryOptions = driver.findElements(By.cssSelector("#input-country option"));
	        for (WebElement option : countryOptions) {
	            if (option.getText().trim().equals("Uganda")) {
	                option.click();
	                break;
	            }
	        }

	        // ✅ Wait for region list to refresh
	        waitUtils.waitForCondition(driver1 -> {
	            List<WebElement> regionOptions = driver1.findElements(By.cssSelector("#input-zone option"));
	            return regionOptions.size() > 1 && !regionOptions.get(0).getText().contains("Please Select");
	        }, 10);

	        Thread.sleep(700);

	        // ✅ Click and select region manually (e.g. "Kampala")
	        regionField.click();
	        Thread.sleep(500);
	        List<WebElement> regionOptions = driver.findElements(By.cssSelector("#input-zone option"));
	        for (WebElement option : regionOptions) {
	            if (option.getText().trim().equals("Kampala")) { // Change region name as needed
	                option.click();
	                break;
	            }
	        }

	        Thread.sleep(500);

	        // ✅ Click Continue
	        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
	        waitUtils.waitForElementClickable(continueBtn, 10).click();

	        // ✅ Verify success message
	        boolean isSuccess = waitUtils.isElementVisible(
	                By.xpath("//div[contains(@class,'alert-success')]"), 5);

	        if (isSuccess) {
	            System.out.println("Address added successfully for: "
	                    + AddAddressTestData.firstName + " " + AddAddressTestData.lastName);
	            return true;
	        } else {
	            System.out.println("Address was not added successfully.");
	            return false;
	        }

	    } catch (Exception e) {
	        System.out.println("Failed to add address: " + e.getMessage());
	        return false;
	    }
	}


	public boolean userIsOnMyAccountPageNavigatesBackAndRefresh() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Verify user is on My Account page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='My Account']")));
			System.out.println("User is on My Account page");

			// Click browser back
			driver.navigate().back();
			System.out.println("Clicked browser back");

			// Wait briefly and refresh
			Thread.sleep(2000);
			driver.navigate().refresh();
			System.out.println("Page refreshed after navigating back");

			// Wait for page to reload and check if Logout button is visible again
			WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='list-group']//a[normalize-space()='Logout']")));

			if (logoutButton.isDisplayed()) {
				System.out.println("User is still logged in after navigating back and refreshing.");
				return true;
			} else {
				System.out.println("Logout button not displayed — user might be logged out.");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Exception while verifying session after browser back: " + e.getMessage());
			return false;
		}
	}

	public boolean isUserLoggedIn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait for either Logout link OR My Account heading
			wait.until(ExpectedConditions.or(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Logout']")),
					ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[normalize-space()='My Account']"))
					));

			// Check both indicators safely
			if (isElementVisible(logoutButton)) {
				System.out.println("Logout button is visible — user is logged in!");
				return true;
			} else if (isElementVisible(myAccountHeading)) {
				System.out.println("My Account heading is visible — user is logged in!");
				return true;
			} else {
				System.out.println("Neither Logout nor My Account heading found!");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error while verifying login: " + e.getMessage());
			return false;
		}
	}

	private boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}



	public void placeOrderAndVerifyNavigationToMyAccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			// Step 1: Search for product
			WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
			searchBox.clear();
			searchBox.sendKeys("HP LP3065");
			driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

			// Step 2: Click on product name
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("HP LP3065"))).click();

			// Step 3: Add to Cart
			WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));
			js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
			addToCartButton.click();

			// Step 4: Wait for success message
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success")));

			// Step 5: Click on Shopping Cart
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("shopping cart"))).click();

			// Step 6: Click on Checkout button
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout"))).click();

			// Step 7: Wait for Checkout page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Checkout')]")));

			// Step 8: Select "New Address" for Billing Details
			WebElement newAddressRadio = driver.findElement(By.xpath("//input[@name='payment_address' and @value='new']"));
			if (!newAddressRadio.isSelected()) {
				js.executeScript("arguments[0].click();", newAddressRadio);
			}

			// Step 9: Fill Billing Details
			driver.findElement(By.id("input-payment-firstname")).sendKeys(GenericUtils.getRandomString(6));
			driver.findElement(By.id("input-payment-lastname")).sendKeys(GenericUtils.getRandomString(6));
			driver.findElement(By.id("input-payment-address-1")).sendKeys(GenericUtils.getRandomString(6));
			driver.findElement(By.id("input-payment-city")).sendKeys(GenericUtils.getRandomString(6));
			driver.findElement(By.id("input-payment-postcode")).sendKeys(GenericUtils.getRandomString(6));
			new Select(driver.findElement(By.id("input-payment-country"))).selectByVisibleText("India");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("input-payment-zone"))).selectByIndex(1);

			driver.findElement(By.id("button-payment-address")).click();

			// Step 10: Wait and continue through checkout steps
			wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method"))).click();

			WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
			if (!termsCheckbox.isSelected()) {
				termsCheckbox.click();
			}

			driver.findElement(By.id("button-payment-method")).click();

			// Step 11: Confirm Order
			wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm"))).click();

			// Step 12: Wait for Success Page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Your order has been placed!')]")));

			// Step 13: Click on My Account dropdown → My Account link
			WebElement myAccountDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='My Account']")));
			js.executeScript("arguments[0].click();", myAccountDropdown);
			WebElement myAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account")));
			myAccountLink.click();

			// Step 14: Verify user landed on My Account page
			WebElement myAccountHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Account']")));
			if (myAccountHeading.isDisplayed()) {
				System.out.println("Test Passed: User successfully landed on My Account page after placing order.");
			} else {
				System.out.println("Test Failed: My Account page not displayed.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Failed due to exception: " + e.getMessage());
		}
	}


	public void clickWishListHeaderOption() {
		By wishListLocator = By.xpath("//a[@id='wishlist-total']//span");

		for (int attempt = 0; attempt < 2; attempt++) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(wishListLocator));
				element.click();
				return; // clicked successfully, exit method
			}
			catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException caught, retrying... Attempt: " + (attempt + 1));
			}
			catch (ElementClickInterceptedException e) {
				System.out.println("ElementClickInterceptedException caught, using JS click... Attempt: " + (attempt + 1));
				try {
					WebElement element = driver.findElement(wishListLocator);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(300);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
					return;
				} catch (Exception jsEx) {
					System.out.println("JS click retry failed: " + jsEx.getMessage());
				}
			}
			catch (TimeoutException e) {
				System.out.println("Timeout waiting for Wish List header option, retrying... Attempt: " + (attempt + 1));
			}
			catch (Exception e) {
				throw new RuntimeException("Unexpected error while clicking Wish List header option", e);
			}
		}
		throw new RuntimeException("Failed to click on Wish List header option after multiple attempts.");
	}

	public boolean addProductsToWishListAndVerifySuccessMessage() {
		try {
			String[] products = {"iMac", "iPhone", "MacBook"};
			By searchBox = By.xpath("//input[@placeholder='Search']");
			By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']"); // update if your locator differs
			By successMsgLocator = By.xpath("//div[contains(@class,'alert-success')]");
			By wishlistButtons = By.xpath("//button[@data-original-title='Add to Wish List']");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			for (String product : products) {
				// Step 1: Clear and enter product name
				WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
				searchField.clear();
				searchField.sendKeys(product);
				log.info("Entered product name: " + product);

				// Step 2: Click search button
				driver.findElement(searchButton).click();
				log.info("Clicked on search button for product: " + product);

				// Step 3: Wait for search results
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(wishlistButtons));

				// Step 4: Handle multiple results for MacBook
				List<WebElement> allWishlistButtons = driver.findElements(wishlistButtons);
				WebElement wishlistBtnToClick;
				if (product.equalsIgnoreCase("MacBook") && allWishlistButtons.size() > 0) {
					wishlistBtnToClick = allWishlistButtons.get(0);
					log.info("Multiple results found for MacBook. Clicking on the first product's wishlist button.");
				} else {
					wishlistBtnToClick = allWishlistButtons.get(0);
				}

				// Step 5: Click on wishlist button
				wait.until(ExpectedConditions.elementToBeClickable(wishlistBtnToClick)).click();
				log.info("Clicked on 'Add to WishList' button for: " + product);

				// Step 6: Wait and verify success message
				WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsgLocator));
				String actualMsg = successMsg.getText().trim();
				String expectedPartial = "Success: You have added " + product + " to your wish list!";

				if (actualMsg.contains(expectedPartial)) {
					log.info("Success message verified for product: " + product);
				} else {
					log.error("Expected: [" + expectedPartial + "] but found: [" + actualMsg + "]");
					return false;
				}

				// Optional short wait between products for stability
				Thread.sleep(1000);
			}

			return true;

		} catch (Exception e) {
			log.error("Error while adding products to wishlist: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickOnWishListHeaderIcon() {
		try {
			By wishListIcon = By.xpath("//li//a[@id='wishlist-total']");
			waitUtils.waitForElementClickable(wishListIcon, 10);

			WebElement icon = driver.findElement(wishListIcon);
			Actions actions = new Actions(driver);
			actions.moveToElement(icon).pause(Duration.ofMillis(500)).click().perform();

			return true;
		} catch (StaleElementReferenceException e) {
			System.out.println("Stale element — retrying click...");
			try {
				WebElement icon = driver.findElement(By.xpath("//li//a[@id='wishlist-total']"));
				new Actions(driver).moveToElement(icon).pause(Duration.ofMillis(500)).click().perform();
				return true;
			} catch (Exception ex) {
				System.out.println("Still stale after retry: " + ex.getMessage());
				return false;
			}
		} catch (Exception e) {
			System.out.println("wishList header icon is not clickable! " + e.getMessage());
			return false;
		}
	}

	public boolean clickSearchFieldButton()
	{
		try {
			waitUtils.waitForElementVisibility(searchFieldButton, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(searchFieldButton).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("search button is not clickable at the time of second run" + e.getMessage());
			return false;
		}
	}

	public boolean verifySpecialOffersLinkIsPresentInFooter()
	{
		try {
			waitUtils.scrollToElement(specialOffersLink);
			waitUtils.waitForElementVisibility(specialOffersLink, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Special offers link is not present in footer option!" + e.getMessage());
			return false;
		}
	}

	public boolean clickSpecialOffersLink()
	{
		try {
			waitUtils.scrollToElement(specialOffersLink);
			Actions actions = new Actions(driver);
			actions.moveToElement(specialOffersLink).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("Special offers link is not clickable! " + e.getMessage());
			return false;
		}
	}

	public boolean isSuccessMessageIsDisplayed()
	{
		try {
			return waitUtils.waitForElementVisibility(successMsg, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("NewsLetter changes Success message is not displayed!" + e.getMessage());
			return false;
		}
	}

	public boolean clickNewsLetterRightColumnOption()
	{
		try {
			waitUtils.waitForElementVisibility(myAccountPageBreadcrumb, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(newsLetterRightColmnOption).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("newsLetter right column option is not present! " +e.getMessage());
			return false;
		}
	}

	public boolean clickSubscribeUnscribeLink()
	{
		try {
			waitUtils.waitForElementVisibility(myAccountPageBreadcrumb, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(subscribeUnsubscribeLink).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("Subscribe unsubscribe link is not clickable! " + e.getMessage());
			return false;
		}
	}

	public boolean isAffiliateAccountCreatedSuccessfullyMsgDisplayed()
	{
		try {
			waitUtils.waitForElementVisibility(affiliateAccountcreatedSuccessMsg, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Affiliate Account created success msg is not displayed! " + e.getMessage());
			return false;
		}
	}

	public void clickAffiliateAccountLink()
	{
		try {
			waitUtils.waitForElementVisibility(affiliateAccountLink, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(affiliateAccountLink).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("affiliate account is not visible to click!" + e.getMessage());
		}
	}

	public void clickOrderHistoryFromMyAccountDrpDwn()
	{
		try {
			waitUtils.waitForElementClickable(myAccountDropMenu, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(myAccountDropMenu).pause(Duration.ofMillis(500)).click().perform();
			waitUtils.waitForElementVisibility(orderHistorydrpdwn, 10);
			actions.moveToElement(orderHistorydrpdwn).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("order history drpdwn link is not clickable! " + e.getMessage());
		}
	}

	public void clickOrderHistroyLink()
	{
		try {
			waitUtils.waitForElementClickable(orderHistorylink, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(orderHistorylink).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("order history link is not clickable! " + e.getMessage());
		}
	}

	public void clickAddressBookLink()
	{
		try {
			Actions actions = new Actions(driver);
			waitUtils.waitForElementVisibility(addressBooklnk, 10);
			actions.moveToElement(addressBooklnk).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("Address book link is not present: " + e.getMessage());
		}
	}

	public boolean isPasswordUpdatedSuccessMsgIsDisplayed()
	{
		try {
			waitUtils.waitForElementVisibility(passwordUpdatedSuccessMsg, 10);
			return passwordUpdatedSuccessMsg.isDisplayed() && passwordUpdatedSuccessMsg.getText().trim().contains("Your password has been successfully updated");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void createNewAccountAndLandOnMyAccountPage() {
		try {
			waitUtils.waitForPageLoad(10);
			Actions actions = new Actions(driver);

			driver.findElement(By.xpath("//a[@title='My Account']")).click();
			WebElement registerAccount = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
			actions.moveToElement(registerAccount).pause(Duration.ofMillis(500)).click().perform();
			TestData.createdFirstName = GenericUtils.getRandomString(6);
			driver.findElement(By.id("input-firstname")).sendKeys(TestData.createdFirstName);
			driver.findElement(By.id("input-lastname")).sendKeys(GenericUtils.getRandomString(6));
			//Store generated email & password globally
			TestData.createdEmail = GenericUtils.getRandomEmail();
			TestData.createdPassword = GenericUtils.getRandomString(4) + GenericUtils.getRandomNumber(4) + "@" + GenericUtils.getRandomString(4);

			driver.findElement(By.id("input-email")).sendKeys(TestData.createdEmail);
			driver.findElement(By.id("input-telephone")).sendKeys(GenericUtils.getRandomNumber(10));
			driver.findElement(By.id("input-password")).sendKeys(TestData.createdPassword);
			driver.findElement(By.id("input-confirm")).sendKeys(TestData.createdPassword);
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			waitUtils.waitForElementClickable(By.xpath("//a[@class='btn btn-primary']"), 10).click();
			waitUtils.waitForElementVisibility(By.xpath("//h2[normalize-space()='My Account']"), 10);

			System.out.println("New account created: " + TestData.createdEmail);
			System.out.println("Password used: " + TestData.createdPassword);

		} catch (Exception e) {
			System.out.println("Account creation failed: " + e.getMessage());
		}
	}

	public void clickRightColumnPasswordLink()
	{
		try {
			waitUtils.waitForElementVisibility(rightColmnPasswordLink, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(rightColmnPasswordLink).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("unable to click on password link: " + e.getMessage());
		}
	}

	public void clickChangeYourPasswordLink()
	{
		try {
			waitUtils.waitForElementVisibility(changeYourPasswordLink, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(EditYourAccountInfoLink).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e){
			System.out.println("unable to click on change your password link: " + e.getMessage());
		}
	}

	public boolean verifySuccessMsgDisappearsAfterRefresh()
	{
		try {
			waitUtils.waitForElementVisibility(accountSuccessfullyUpdatedSuccessMsg, 10);
			boolean isDisplayedBeforeRefresh = accountSuccessfullyUpdatedSuccessMsg.isDisplayed();
			driver.navigate().refresh();
			Thread.sleep(2000);
			boolean isDisplayedAfterRefresh;
			try {
				isDisplayedAfterRefresh = accountSuccessfullyUpdatedSuccessMsg.isDisplayed();
			}catch(org.openqa.selenium.NoSuchElementException e) {
				isDisplayedAfterRefresh = false;
			}

			if(isDisplayedBeforeRefresh && !isDisplayedAfterRefresh) {
				System.out.println("Success message disappeared after page refresh!");
				return true;
			}else {
				System.out.println("Success message still visible after refresh!");
				return false;
			}
		}catch(Exception e) {
			System.out.println("could not verify disappearance of success message! " + e.getMessage());
			return false;
		}
	}

	public boolean userIsOnMyAccountPage()
	{
		try {
			return waitUtils.waitForElementVisibility(pageHeading, 10).isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isAccountUpdatedSuccessMsgIsDisplayed()
	{
		try {
			waitUtils.waitForElementVisibility(accountSuccessfullyUpdatedSuccessMsg, 10);
			return accountSuccessfullyUpdatedSuccessMsg.isDisplayed() && accountSuccessfullyUpdatedSuccessMsg.getText().trim().contains("Your account has been successfully updated");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void clickEditYourAccountInfoLink()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(EditYourAccountInfoLink).pause(Duration.ofMillis(500)).click().perform();
	}

	public boolean verifyMyAccountPageHeading()
	{
		String expectedHeading = "My Account";
		String actualHeading = pageHeading.getText().trim();
		return expectedHeading.equalsIgnoreCase(actualHeading);
	}

	public boolean verifyMyAccountPageTitle()
	{
		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();
		return actualTitle.equalsIgnoreCase(expectedTitle);
	}

	public boolean isUserOnMyAccountPage() {
		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
		String actualUrl = driver.getCurrentUrl();
		return actualUrl.equalsIgnoreCase(expectedUrl);
	}

	public void clickMyAccountPageBreadCrumb()
	{
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(myAccountPageBreadcrumb).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("Failed to click on my account breadcrumb: " + e.getMessage());
		}
	}

	public boolean isMyAccountPageBreadcrumbIsDisplayed()
	{
		return waitUtils.waitForElementVisibility(myAccountPageBreadcrumb, 10).isDisplayed();
	}

	public void clickOrderHistoryLink()
	{
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(orderHistoryLink).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("Failed to click on order history link: " + e.getMessage());
		}
	}

	public List<String> getMyAccountOptions()
	{
		List<String> optionText = new ArrayList<>();
		for(WebElement option : myAccountOptions)
		{
			optionText.add(option.getText().trim());
		}
		return optionText;
	}

	public void clickLogoutFromRightColumn()
	{
		logoutBtnrightcolmn.click();
	}

	public boolean isLoginButtonDisplayed()
	{
		return loginButtonInDrpDwn.isDisplayed();
	}

	public void clickMyAccountDropMenu()
	{
		myAccountDropMenu.click();
	}

	public WebElement getLogoutButton()
	{
		return isLogoutButtonDisplayed;
	}

	public void changeYourPasswordLink()
	{
		changeYourPasswordLnk.click();
	}

	public WebElement myAccountPageTitle()
	{
		return MyAccountPageTitle;
	}
	public boolean isOnMyAccountPage()
	{
		return MyAccountPageTitle.isDisplayed();
	}

	public void clickOnMyAccountDropMenu()
	{
		MyAccountPageTitle.click();
	}

	public void clickSubscribeUnsubscribeLink()
	{
		SubscriberUnsubscribeLink.click();
	}

	public boolean isLogoutButtonDisplayed()
	{
		try {
			return logoutButtonlnk.isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}

	public void clickLogoutButtonFromMenu()
	{
		logoutButtonlnk.click();
	}

}
