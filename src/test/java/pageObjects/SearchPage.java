package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
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
import utilities.WaitUtils;

public class SearchPage extends BasePage {

	WaitUtils waitUtils;

	public SearchPage(WebDriver driver) {
		super(driver);
		waitUtils = new WaitUtils(driver);
	}

	@FindBy(xpath="//div[@id='content']//div[@class='product-thumb']//h4/a") public WebElement searchIteminResult;
	@FindBy(xpath="//div[@id='content']//div[@class='product-thumb']//h4/a") private List<WebElement> productResults;
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]") private WebElement searchElementNotFound;
	@FindBy(xpath="//input[@placeholder='Search']") private WebElement searchTextBoxField;
	@FindBy(xpath="//input[@id='input-search']") private WebElement searchCriteriaTextBoxField;
	@FindBy(xpath="//input[@id='button-search']") private WebElement searchBtn;
	@FindBy(xpath="//input[@id='description']") private WebElement SearchinproductdescriptionsCheckBox;
	@FindBy(xpath="//select[@name='category_id']") private WebElement categoryDropdown;
	@FindBy(xpath="//input[@name='sub_category']") private WebElement subcategoryCheckbox;
	@FindBy(xpath="//button[@id='list-view']") private WebElement listViewButton;
	@FindBy(xpath="//button[@id='grid-view']") private WebElement gridViewButton;
	@FindBy(xpath = "//div[@class='product-thumb']//button[contains(span,'Add to Cart')]") private List<WebElement> addToCartButtons;
	@FindBy(xpath = "//div[@class='product-thumb']//button[@data-original-title='Add to Wish List']") private List<WebElement> wishListButtons;
	@FindBy(xpath = "//div[@class='product-thumb']//button[@data-original-title='Compare this Product']") private List<WebElement> compareButtons;
	@FindBy(xpath = "//div[@class='image']//a//img") private WebElement imgOfSearchedProduct;
	@FindBy(xpath = "//div[@class='row'][3]//div[@class='caption']//a")	private List<WebElement> productNames;
	@FindBy(xpath = "//div[@class='row'][3]//img") private List<WebElement> productImages;
	@FindBy(xpath = "//select[@id='input-sort']") private WebElement sortByDropDown;
	@FindBy(id = "input-sort") private WebElement sortByDropdown;
	@FindBy(css = "div.product-thumb h4 a") private List<WebElement> productName;
	@FindBy(css = "div.product-thumb p.price") private List<WebElement> productPrices;
	@FindBy(xpath= "//div[@id='content']//h1") private WebElement headingOfSearchPage;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement breadCrumbSearchPage;
	@FindBy(name="search") private WebElement searchBox;
	@FindBy(name="description") private WebElement searchCriteriaCheckbox;
	@FindBy(name="category_id") private WebElement categoryDropDown;
	@FindBy(name = "search") private WebElement searchBar;
	@FindBy(name = "searchCriteria") private WebElement searchCriteriaField;
	@FindBy(name = "description") private WebElement searchInDescriptionCheckbox;
	@FindBy(css = "button[type='submit']") private WebElement searchSubmitButton;
	@FindBy(id = "compare-total") private WebElement compareButton;
	@FindBy(xpath = "//div[@class='product-thumb']//img[@title='iMac']") private WebElement imacProductImage;
	@FindBy(xpath = "//div[@class='product-thumb']//h4/a[text()='iMac']") private WebElement imacNameText;
	@FindBy(xpath = "//div[@class='product-thumb']//button[@data-original-title='Compare this Product']") private WebElement compareThisProductButton;
	@FindBy(xpath = "//div[@class='caption']//a") private WebElement ProductDisplayedInSearch;
	@FindBy(xpath = "//i[@class='fa fa-th-list']") private WebElement listViewOption;
	@FindBy(xpath = "//div[contains(text(),'Compare this Product')]") private WebElement compareThisProductMouseHoverText;
	@FindBy(xpath = "//button[3]") private WebElement compareThisProductButtonListView;
	@FindBy(xpath = "//button[@id='grid-view']") private WebElement gridView;
	@FindBy(xpath = "//a[@id='compare-total']") private WebElement compareProductLnk;
	@FindBy(xpath = "//div[@class='button-group']//button[3]") private WebElement compareproductButton;
	@FindBy(xpath = "//a[normalize-space()='product comparison']") private WebElement productComparisonLink;
	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']") private WebElement wishListbtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[2]") private WebElement wishListLinkSuccessMsg;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[4]") private WebElement wishListlinkinSuccessMsgBeforeLogin;
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']") private WebElement addToCartButtoniPhone;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[2]") private WebElement shoppingCartLinkInSuccessMessageIphone;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[2]//div[1]//h4[1]//a[1]") private WebElement MacBookProductNameInSearch;
	@FindBy(xpath = "//div[@id='content']//h1") private WebElement searchMacBookProductTitle;
	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/p[2]") private WebElement priceOfMacBookProduct;
	@FindBy(xpath = "//div[@id='content']//ul[@class='list-unstyled']//h2") private WebElement priceOfMacbook;
	@FindBy(xpath = "//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]") private WebElement addToCartButtonSamsungProduct;
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']") private WebElement addToCartIPhoneProduct;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]//span[1]") private WebElement addToCartMacBook;
	@FindBy(xpath = "//a[normalize-space()='shopping cart']") private WebElement shoppingCartInMessage;
	@FindBy(xpath = "//img[@title='HP LP3065']") private WebElement clickHpLPProduct;
	@FindBy(xpath = "//div[@class='caption']//a[contains(text(),'HP LP3065')]") private WebElement HPLP3065NameLink;
	@FindBy(xpath = "//button[@data-original-title='Add to Wish List']") private List<WebElement> addToWishListButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]//a[normalize-space(.)='shopping cart']") private WebElement shoppingCartLinkInAlertMsg;

	public void verifyCompareThisProductForFiveProducts() {
	    try {
	        String[] products = {"iMac", "iPhone", "MacBook Air", "MacBook", "MacBook Pro"};
	        By searchBox = By.name("search");
	        By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	        By compareButton = By.xpath("//div[@class='button-group']//button[3]");
	        By successMsg = By.xpath("//div[contains(@class,'alert-success')]");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        for (int i = 0; i < products.length; i++) {
	            String product = products[i];

	            // Search for product
	            WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	            search.clear();
	            search.sendKeys(product);
	            driver.findElement(searchButton).click();

	            // Click on "Compare this product" button
	            WebElement compare = wait.until(ExpectedConditions.elementToBeClickable(compareButton));
	            try {
	                compare.click();
	            } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", compare);
	            }

	            // Verify success message appears
	            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
	            String msgText = alert.getText().trim();

	            if (msgText.toLowerCase().contains("success") && msgText.toLowerCase().contains(product.toLowerCase())) {
	                System.out.println("Success message displayed for product: " + product);
	            } else {
	                Assert.fail("Success message not displayed correctly for product: " + product);
	            }

	            // Clear search box for all but the last product
	            if (i < products.length - 1) {
	                Thread.sleep(800);
	                search = driver.findElement(searchBox);
	                search.clear();
	            }

	            Thread.sleep(1000);
	        }

	        System.out.println("All five products (iMac, iPhone, MacBook Air, MacBook, MacBook Pro) added to comparison successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Exception occurred while verifying product comparison addition: " + e.getMessage());
	    }
	}

	public void verifyCompareThisProductForFourProducts() {
	    try {
	        String[] products = {"iMac", "iPhone", "MacBook Air", "MacBook"};
	        By searchBox = By.name("search");
	        By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	        By compareButton = By.xpath("//div[@class='button-group']//button[3]");
	        By successMsg = By.xpath("//div[contains(@class,'alert-success')]");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        for (int i = 0; i < products.length; i++) {
	            String product = products[i];

	            // Search for product
	            WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	            search.clear();
	            search.sendKeys(product);
	            driver.findElement(searchButton).click();

	            // Click on "Compare this product" button
	            WebElement compare = wait.until(ExpectedConditions.elementToBeClickable(compareButton));
	            try {
	                compare.click();
	            } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
	                // JS fallback if normal click fails
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", compare);
	            }

	            // Verify success message appears
	            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
	            String msgText = alert.getText().trim();

	            if (msgText.toLowerCase().contains("success") && msgText.toLowerCase().contains(product.toLowerCase())) {
	                System.out.println("Success message displayed for product: " + product);
	            } else {
	                Assert.fail("Success message not displayed correctly for product: " + product);
	            }

	            // Clear search box for all but the last product
	            if (i < products.length - 1) {
	                Thread.sleep(700);
	                search = driver.findElement(searchBox);
	                search.clear();
	            }

	            Thread.sleep(1000);
	        }

	        System.out.println("All four products (iMac, iPhone, MacBook Air, MacBook) added to comparison successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Exception occurred while verifying product comparison addition: " + e.getMessage());
	    }
	}

	public void verifyCompareThisProductForMultipleProducts() {
	    try {
	        String[] products = {"iMac", "iPhone", "MacBook Air"};
	        By searchBox = By.name("search");
	        By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	        By compareButton = By.xpath("//div[@class='button-group']//button[3]");
	        By successMsg = By.xpath("//div[contains(@class,'alert-success')]");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        for (int i = 0; i < products.length; i++) {
	            String product = products[i];
	            // Search product
	            WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	            search.clear();
	            search.sendKeys(product);
	            driver.findElement(searchButton).click();

	            // Click compare this product button
	            WebElement compare = wait.until(ExpectedConditions.elementToBeClickable(compareButton));
	            try {
	                compare.click();
	            } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
	                // JS fallback for blocked or stale clicks
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", compare);
	            }

	            // Verify success message
	            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
	            String msgText = alert.getText().trim();

	            if (msgText.toLowerCase().contains("success") && msgText.toLowerCase().contains(product.toLowerCase())) {
	                System.out.println("Success message displayed for product: " + product);
	            } else {
	                Assert.fail("Success message not displayed correctly for product: " + product);
	            }

	            // Only clear search box for first two products
	            if (i < products.length - 1) {
	                Thread.sleep(500);
	                search = driver.findElement(searchBox);
	                search.clear();
	            }

	            Thread.sleep(1000);
	        }

	        System.out.println("All three products (iMac, iPhone, MacBook Air) added to comparison successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Exception occurred while verifying comparison: " + e.getMessage());
	    }
	}


	public void verifyCompareThisProductForIMacAndIPhone() {
	    try {
	        String[] products = {"iMac", "iPhone"};
	        By searchBox = By.name("search");
	        By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	        By compareButton = By.xpath("//div[@class='button-group']//button[3]");
	        By successMsg = By.xpath("//div[contains(@class,'alert-success')]");

	        for (String product : products) {
	            // Search product
	            WebElement search = driver.findElement(searchBox);
	            search.clear();
	            search.sendKeys(product);
	            driver.findElement(searchButton).click();

	            // Click compare this product button
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement compare = wait.until(ExpectedConditions.elementToBeClickable(compareButton));

	            try {
	                compare.click();
	            } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
	                // Retry using JavaScript
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", compare);
	            }

	            // Verify success message
	            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
	            String msgText = alert.getText();
	            if (msgText.toLowerCase().contains("success") && msgText.toLowerCase().contains(product.toLowerCase())) {
	                System.out.println("Success message displayed for product: " + product);
	            } else {
	                Assert.fail("Success message not displayed for product: " + product);
	            }

	            Thread.sleep(1000); // short delay before next iteration
	        }

	        // If both succeed → pass silently
	        System.out.println("Both products added to comparison successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Exception occurred while comparing products: " + e.getMessage());
	    }
	}


	public void clickCompareThisProductButton() {
	    try {
	        waitUtils.waitForElementClickable(compareproductButton, 10);

	        // Scroll into view before click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", compareproductButton);
	        Thread.sleep(500); // small pause to allow smooth scroll

	        try {
	            compareproductButton.click();
	        } catch (ElementClickInterceptedException e) {
	            // If element is blocked or overlapped — fallback to JS click
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", compareproductButton);
	        }

	        System.out.println("Clicked on 'Compare this product' button successfully.");
	    } catch (StaleElementReferenceException e) {
	        // If the element went stale, re-find and click again
	        compareproductButton = driver.findElement(By.xpath("//div[@class='button-group']//button[3]"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", compareproductButton);
	    } catch (Exception e) {
	        System.out.println("Failed to click 'Compare this product' button: " + e.getMessage());
	    }
	}


	public boolean clickOnShoppingCartHeader() {
	    By shoppingCartHeader = By.xpath("//span[text()='Shopping Cart']");
	    boolean isClicked = false;

	    try {
	        // Try up to 3 attempts if stale or temporarily not clickable
	        for (int i = 0; i < 3; i++) {
	            try {
	                WebElement cartLink = new WebDriverWait(driver, Duration.ofSeconds(10))
	                        .until(ExpectedConditions.elementToBeClickable(shoppingCartHeader));

	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartLink);

	                isClicked = true;
	                System.out.println("Clicked on Shopping Cart header successfully.");
	                break;
	            } catch (StaleElementReferenceException e) {
	                System.out.println("⚠StaleElementReferenceException occurred — retrying click...");
	                Thread.sleep(1000); // small wait before retry
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Unable to click on Shopping Cart header: " + e.getMessage());
	    }

	    return isClicked;
	}


	public boolean searchAndAddMultipleProductsToCart() {
	    String[] products = {"iPhone", "MacBook", "Samsung Galaxy"};
	    boolean allProductsAdded = true;

	    try {
	        for (int i = 0; i < products.length; i++) {
	            String product = products[i];

	            // Search product
	            WebElement searchBox = driver.findElement(By.name("search"));
	            searchBox.clear();
	            searchBox.sendKeys(product);
	            driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

	            // Click on product link
	            WebElement productLink = driver.findElement(By.xpath("//a[contains(text(),'" + product + "')]"));
	            productLink.click();

	            // Click on Add to Cart button
	            WebElement addToCartButton = driver.findElement(By.id("button-cart"));
	            addToCartButton.click();

	            // Verify success message
	            WebElement successAlert = driver.findElement(By.cssSelector(".alert-success"));
	            String alertText = successAlert.getText().trim();

	            if (alertText.contains("Success: You have added") && alertText.contains(product)) {
	                System.out.println("Product added successfully: " + product);
	            } else {
	                System.out.println("Product not added successfully: " + product);
	                allProductsAdded = false;
	                break;
	            }

	            // Only go back to homepage for first two products
	            if (i < products.length - 1) {
	                driver.findElement(By.cssSelector("div#logo a")).click();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        allProductsAdded = false;
	    }

	    return allProductsAdded;
	}

	public boolean clickShoppingCartLinkAlertMsg() {
	    try {
	        By shoppingCartLinkLocator = By.xpath("//div[contains(@class,'alert')]//a[contains(normalize-space(.),'shopping cart')]");

	        // Wait for alert to appear
	        WebElement alertLink = new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.visibilityOfElementLocated(shoppingCartLinkLocator));

	        // Scroll and make sure it's in view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", alertLink);

	        // Try clicking using multiple strategies
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(5))
	                    .until(ExpectedConditions.elementToBeClickable(alertLink))
	                    .click();
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Click intercepted, retrying via JS");
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", alertLink);
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Stale element, re-locating and retrying");
	            WebElement refreshedLink = driver.findElement(shoppingCartLinkLocator);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", refreshedLink);
	        }

	        System.out.println("Successfully clicked shopping cart link in alert message");
	        return true;

	    } catch (TimeoutException e) {
	        System.out.println("Timeout: shopping cart link not found or visible within time limit");
	        return false;

	    } catch (Exception e) {
	        System.out.println("Exception while clicking shopping cart link: " + e.getMessage());
	        return false;
	    }
	}


	public boolean clickAddToWishListButton()
	{
		try {
			waitUtils.waitForElementVisibility(breadCrumbSearchPage, 10).isDisplayed();
			waitUtils.waitForAllElementsVisible(addToWishListButton, 10);
			waitUtils.scrollToBottom();
			for(WebElement addButton : addToWishListButton)
			{
				Actions actions = new Actions(driver);
				actions.moveToElement(addButton).pause(Duration.ofMillis(500)).click().perform();
				break;
			}
			return true;
		}catch(Exception e) {
			System.out.println("add to wishlist button is not clickable at this moment!" + e.getMessage());
			return false;
		}
	}

	public void clickHPLP3065NameLink()
	{
		waitUtils.waitForElementClickable(HPLP3065NameLink, 10).click();
	}

	public void clickHPLPSearchedProduct()
	{
		waitUtils.waitForElementClickable(clickHpLPProduct, 10).click();
	}

	public void clickShoppingCartInMessage() throws Exception {
		try {
			waitUtils.waitForPageLoad(10);
			WebElement element = waitUtils.waitForElementVisibility(shoppingCartInMessage, 10);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); // small delay for smooth scroll
			try {
				waitUtils.waitForElementClickable(element, 5).click();
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public void clickAddToCartMacBook()
	{
		waitUtils.waitForElementClickable(addToCartMacBook, 10).click();
	}

	public void clickAddToCartIphone()
	{
		waitUtils.waitForElementClickable(addToCartIPhoneProduct, 10).click();
	}

	public void clickAddToCartForSamsungProduct()
	{
		waitUtils.waitForElementClickable(addToCartButtonSamsungProduct, 10).click();
	}

	public boolean isMacBookProductTitleAndPriceDisplayedInSearch()
	{
		try {
			boolean titleVisible = waitUtils.waitForElementVisibility(searchMacBookProductTitle, 10).isDisplayed();
			boolean priceVisible =  waitUtils.waitForElementVisibility(priceOfMacbook, 10).isDisplayed();

			if(titleVisible && priceVisible) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}

	}

	public void clickMacBookProductName()
	{
		waitUtils.waitForElementClickable(MacBookProductNameInSearch, 10).click();
	}

	public void clickShoppingCartLinkInMsgIphone()
	{
		waitUtils.waitForElementClickable(shoppingCartLinkInSuccessMessageIphone, 10).click();
	}

	public void clickAddToCartButtonforiPhone()
	{
		waitUtils.scrollToElement(addToCartButtoniPhone);
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementClickable(addToCartButtoniPhone, 10).click();
	}

	public void clickWishListLinkInSuccessMsgBeforeLogin()
	{
		waitUtils.waitForPageLoad(10);
		WebElement element = waitUtils.waitForElementVisibility(wishListlinkinSuccessMsgBeforeLogin, 10);

		try {
			element.click();
		}catch(ElementClickInterceptedException  e) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickWishListLinksuccessMesg()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wishListLinkSuccessMsg);
	}

	public void clickWishListBtn()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.scrollToElementAndClick(wishListbtn);
	}

	public void clickProductComparisonLink() {
		try {
			waitUtils.waitForElementClickable(productComparisonLink, 10);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productComparisonLink);
			Thread.sleep(500);
			try {
				productComparisonLink.click();
			} catch (ElementClickInterceptedException e) {
				// Fallback if intercepted again
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", productComparisonLink);
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to click on Product Comparison link: " + e.getMessage(), e);
		}
	}

	public void clearSearchBarField()
	{
		waitUtils.waitForElementVisibility(searchBar, 10).clear();
	}

	public void clickProductCompareLinkOnSearchPage()
	{
		waitUtils.waitForElementVisibility(compareProductLnk, 10).click();
	}

	public void clickButtonCompareThisProduct()
	{
		waitUtils.scrollToElement(compareThisProductButtonListView);
		waitUtils.waitForElementVisibility(compareThisProductButtonListView, 10).click();
	}

	public void selectGridViewOption()
	{
		gridView.click();
	}

	public void mouseHoverOnCompareThisProduct()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(compareThisProductButtonListView).perform();
	}

	public void clickCompareThisProductOption()
	{
		compareThisProductButtonListView.click();
	}

	public String compareProductMouseHoverText()
	{
		return compareThisProductMouseHoverText.getText();
	}

	public void selectListViewOption()
	{
		listViewOption.click();
	}

	public void clickProductDisplayedOnSearchResult()
	{
		ProductDisplayedInSearch.click();
	}

	public void performSearchUsingTabsAndEnter() throws InterruptedException {
		Actions actions = new Actions(driver);

		// 🔹 Press TAB key 24 times
		for (int i = 0; i < 24; i++) {
			actions.sendKeys(Keys.TAB).perform();
			Thread.sleep(200); // small wait for focus to move
		}

		// 🔹 After 24 tabs, press ENTER
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000); // wait for page refresh / search results to load

		// 🔹 Verify page has refreshed (URL contains 'search')
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("search"), "❌ Page did not navigate to search results.");
		System.out.println("✅ Page refreshed / navigated to search results: " + currentUrl);
	}

	public String getCurrentUrlOfSearchPage()
	{
		return driver.getCurrentUrl();
	}

	public String getSearchPageTitle() {
		return driver.getTitle();
	}

	public boolean isSerachPageBreadCrumbDisplayed()
	{
		return breadCrumbSearchPage.isDisplayed();
	}

	public boolean isHeadingOfSearchPageIsDisplayed()
	{
		return headingOfSearchPage.isDisplayed();
	}

	public void verifySearchBreadCrumbFunctionality() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Capture before-click details
		String beforeUrl = driver.getCurrentUrl();
		String beforeTitle = driver.getTitle();

		WebElement breadcrumb = driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Search']"));
		breadcrumb.click();

		// Wait for search input to be visible again (page refreshed or reloaded)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));

		// Capture after-click details
		String afterUrl = driver.getCurrentUrl();
		String afterTitle = driver.getTitle();

		// Assertions
		Assert.assertEquals(afterUrl, beforeUrl, "URL changed unexpectedly after clicking breadcrumb!");
		Assert.assertEquals(afterTitle, beforeTitle, "Page title changed unexpectedly!");
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Search']")).isDisplayed(),
				"Search input not visible after clicking breadcrumb!");
	}

	public void verifyShowDropDownFunctionality() {
		By dropdownLocator = By.id("input-limit");
		By productLocator = By.cssSelector("div.product-thumb");

		// First, capture total available options count
		Select initialSelect = new Select(driver.findElement(dropdownLocator));
		int optionCount = initialSelect.getOptions().size();

		for (int i = 0; i < optionCount; i++) {
			try {
				// Re-locate the dropdown fresh every iteration (to avoid stale elements)
				WebElement dropdownElement = new WebDriverWait(driver, Duration.ofSeconds(5))
						.until(ExpectedConditions.presenceOfElementLocated(dropdownLocator));
				Select showSelect = new Select(dropdownElement);

				List<WebElement> options = showSelect.getOptions();
				WebElement option = options.get(i);
				String optionText = option.getText().trim();

				// Skip invalid numeric values
				int expectedCount;
				try {
					expectedCount = Integer.parseInt(optionText);
				} catch (NumberFormatException e) {
					System.out.println("Skipping invalid option: " + optionText);
					continue;
				}

				// Select the dropdown value
				showSelect.selectByVisibleText(optionText);

				// Wait for page reload (ensure products are reloaded)
				new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLocator));

				// Re-fetch product list after reload
				List<WebElement> displayedProducts = driver.findElements(productLocator);

				// Validate count doesn’t exceed expected
				int actualCount = displayedProducts.size();
				Assert.assertTrue(actualCount <= expectedCount,
						"Expected max " + expectedCount + " products, but found " + actualCount);

				System.out.println("Verified Show dropdown option: " + expectedCount +
						" -> Products displayed: " + actualCount);

			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element at index " + i + " — retrying...");
				i--; // retry current iteration
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void verifySortingForAllOptions() {
		List<WebElement> options;
		Select select;

		int optionCount;

		try {
			select = new Select(driver.findElement(By.id("input-sort")));
			options = select.getOptions();
			optionCount = options.size();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		for (int i = 0; i < optionCount; i++) {
			try {
				// Re-fetch dropdown and options on each iteration
				select = new Select(driver.findElement(By.id("input-sort")));
				options = select.getOptions();
				WebElement option = options.get(i);
				String optionText = option.getText().trim();

				// Click on sort option
				option.click();

				// Wait for product grid to reload
				new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.cssSelector("div.product-thumb")));

				// Re-fetch product names and prices
				List<WebElement> refreshedProductNames = driver.findElements(By.cssSelector("div.product-thumb h4 a"));
				List<WebElement> refreshedProductPrices = driver.findElements(By.cssSelector("div.product-thumb p.price"));

				// Verify sorting
				if (optionText.toLowerCase().contains("name (a - z)")) {
					verifyProductsSortedByName(refreshedProductNames, true);
				} else if (optionText.toLowerCase().contains("name (z - a)")) {
					verifyProductsSortedByName(refreshedProductNames, false);
				} else if (optionText.toLowerCase().contains("price (low > high)")) {
					verifyProductsSortedByPrice(refreshedProductPrices, true);
				} else if (optionText.toLowerCase().contains("price (high > low)")) {
					verifyProductsSortedByPrice(refreshedProductPrices, false);
				}

			} catch (StaleElementReferenceException e) {
				System.out.println("Caught stale element for option index " + i + ", retrying...");
				i--; // retry
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//  helper methods to take dynamic elements
	private void verifyProductsSortedByName(List<WebElement> products, boolean ascending) {
		List<String> actualNames = products.stream().map(WebElement::getText).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<>(actualNames);
		sortedNames.sort(String.CASE_INSENSITIVE_ORDER);
		if(!ascending) Collections.reverse(sortedNames);

		Assert.assertEquals(actualNames, sortedNames, "Products are not sorted correctly by name (" +(ascending ? "A-Z" : "Z-A")+ ")");
	}

	private void verifyProductsSortedByPrice(List<WebElement> prices, boolean ascending) {
		List<Double> actualPrices = new ArrayList<>();

		for (WebElement p : prices) {
			try {
				// Remove currency symbols, whitespace, commas, newlines
				String text = p.getText().replaceAll("[^\\d.]", "");

				// Handle multiple dots: keep only the first dot
				int firstDot = text.indexOf('.');
				if (firstDot != -1) {
					int secondDot = text.indexOf('.', firstDot + 1);
					if (secondDot != -1) {
						text = text.substring(0, secondDot);
					}
				}

				if (!text.isEmpty()) {
					actualPrices.add(Double.parseDouble(text));
				}
			} catch (NumberFormatException e) {
				System.out.println("Skipping invalid price: " + p.getText());
			}
		}

		List<Double> sortedPrices = new ArrayList<>(actualPrices);
		Collections.sort(sortedPrices);
		if (!ascending) Collections.reverse(sortedPrices);

		Assert.assertEquals(actualPrices, sortedPrices,
				"Products are not sorted correctly by price (" + (ascending ? "Low > High" : "High > Low") + ")");
	}

	public boolean areMultipleProductsDisplayed() {
		try {
			By productLocator = By.xpath("//div[@id='content']//div[@class='product-thumb']//h4/a");
			List<WebElement> productResults = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLocator));

			return productResults.size() > 1;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean areAllProductsOptionsDisplayed() {
		try {
			By productContainerLocator = By.xpath("//div[@id='content']//div[@class='product-thumb']");
			List<WebElement> productResults = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productContainerLocator));

			int productCount = productResults.size();
			if (productCount == 0) return false;

			List<WebElement> addToCartButtons = driver.findElements(
					By.xpath("//div[@class='product-thumb']//button[contains(span,'Add to Cart')]")
					);
			List<WebElement> wishListButtons = driver.findElements(
					By.xpath("//div[@class='product-thumb']//button[@data-original-title='Add to Wish List']")
					);
			List<WebElement> compareButtons = driver.findElements(
					By.xpath("//div[@class='product-thumb']//button[@data-original-title='Compare this Product']")
					);

			return addToCartButtons.size() == productCount
					&& wishListButtons.size() == productCount
					&& compareButtons.size() == productCount;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void verifyEachProductNameNavigation() {
		try {
			int productCount = driver.findElements(By.xpath("//div[@class='row'][3]//div[@class='caption']//a")).size();

			for (int i = 0; i < productCount; i++) {
				// Re-fetch fresh list every loop
				List<WebElement> productNames = driver.findElements(
						By.xpath("//div[@class='row'][3]//div[@class='caption']//a"));

				String expectedProductName = productNames.get(i).getText().trim();

				// Click the product
				productNames.get(i).click();

				// Wait for product page title
				WebElement productTitle = new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']//h1")));
				String actualProductName = productTitle.getText().trim();

				// Verify navigation
				Assert.assertEquals(actualProductName, expectedProductName,
						"Mismatch! Expected: " + expectedProductName + " | Actual: " + actualProductName);

				System.out.println("Navigation verified for product: " + expectedProductName);

				// Navigate back
				driver.navigate().back();

				// Wait until product list is visible again
				new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//div[@class='row'][3]//div[@class='caption']//a")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyEachProductNavigation() {
		try {
			int productCount = driver.findElements(By.xpath("//div[@class='row'][3]//img")).size();

			for (int i = 0; i < productCount; i++) {
				List<WebElement> productImages = driver.findElements(By.xpath("//div[@class='row'][3]//img"));
				List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='row'][3]//div[@class='caption']//a"));

				String expectedProductName = productNames.get(i).getText().trim();

				// Click on image
				productImages.get(i).click();

				// Wait for product page to load
				WebElement productTitle = new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']//h1")));
				String actualProductName = productTitle.getText().trim();

				// Verify
				Assert.assertEquals(actualProductName, expectedProductName,
						"Mismatch! Expected: " + expectedProductName + " | Actual: " + actualProductName);

				System.out.println("Navigation verified for product: " + expectedProductName);

				driver.navigate().back();

				// Wait until search results are back
				new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//div[@class='row'][3]//div[@class='caption']//a")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearSearchTextBoxField()
	{
		searchTextBoxField.clear();
	}

	public void clearSearchCriteriaTextBoxField()
	{
		searchCriteriaTextBoxField.clear();
	}

	public void clickOnSearchedProductName()
	{
		searchIteminResult.click();
	}

	public void clickOnSearchProductImage()
	{
		imgOfSearchedProduct.click();
	}

	public boolean areAllProductOptionsDisplayed() {
		try {
			int productCount = addToCartButtons.size();
			return productCount > 0
					&& wishListButtons.size() == productCount
					&& compareButtons.size() == productCount;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean isSingleProductDisplayed()
	{
		try {
			return productResults.size()==1;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void selectGridView()
	{
		gridViewButton.click();
	}

	public void selectListView()
	{
		listViewButton.click();
	}

	public void clickSearchInSubCategories()
	{
		if(!subcategoryCheckbox.isSelected()) {
			subcategoryCheckbox.click();
		}
	}

	public void selectParentCategoryForProduct(String productName) {
		Select select = new Select(categoryDropdown);
		List<WebElement> options = select.getOptions();

		String parentCategory = null;

		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText().trim();

			if (text.equalsIgnoreCase(productName.trim())) {
				// Walk upward until we find a non-indented option
				for (int j = i - 1; j >= 0; j--) {
					String prevText = options.get(j).getText();

					// Check if it's NOT indented (not starting with spaces or NBSP)
					if (!prevText.startsWith("\u00A0") && !prevText.startsWith(" ")) {
						parentCategory = prevText.trim();
						break;
					}
				}
				break;
			}
		}

		if (parentCategory != null) {
			select.selectByVisibleText(parentCategory);
		} else {
			throw new RuntimeException("Parent category not found for product: " + productName);
		}
	}

	public void SelectCategoryFromDropDown(String category)
	{
		Select select = new Select(categoryDropdown);
		List<WebElement> options = select.getOptions();
		boolean found = false;
		for(WebElement option:options)
		{
			String actualText = option.getText().trim();
			if(actualText.equalsIgnoreCase(category.trim()))
			{
				option.click();
				found = true;
				break;
			}
		}

		if(!found)
		{
			throw new RuntimeException("Category not found in dropdown: " + category);
		}
	}

	public void selectSearchInProductDescCheckbox()
	{
		SearchinproductdescriptionsCheckBox.click();
	}

	public void clickSearchCriteriaSearchBtn()
	{
		searchBtn.click();
	}

	public void enterTextIntoSearchCriteriaTextBoxField(String searchItem) {

		driver.navigate().refresh();
		searchCriteriaTextBoxField.clear();
		searchCriteriaTextBoxField.sendKeys(searchItem);
	}

	public String getPlaceholderValueOfSearchCriteriaTextBoxField()
	{
		return searchCriteriaTextBoxField.getAttribute("placeholder");
	}

	public String getPlaceholderValueOfSearchTextField()
	{
		return searchTextBoxField.getAttribute("placeholder");
	}

	public boolean areMultipleProductDisplayed()
	{
		return productResults.size()>1;
	}

	public boolean isSearchElementNotFoundMessageDisplayed()
	{
		return searchElementNotFound.isDisplayed();
	}

	public String getProductSearchResult()
	{
		return searchIteminResult.getText();
	}
}
