package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDisplayPage extends BasePage {

	public ProductDisplayPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement lastBreadcrumbpage;
	@FindBy(xpath="//i[@class='fa fa-exchange']") private List<WebElement> productCompareBtns;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") private WebElement ProductAddedSuccessMsg;
	@FindBy(xpath="//a[normalize-space()='product comparison']") private WebElement productComparisonLink;
	@FindBy(xpath="//div[@id='product-product']//div[@class='btn-group']//button[2]") private WebElement CompareThisProduct;
	@FindBy(xpath="//div[@class='tooltip-inner']") private WebElement CompareProductHoverText;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement ProductCompareSuccessAddedMsg;
	@FindBy(xpath="//a[normalize-space()='product comparison']") private WebElement ProductComparisonLnk;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'iMac')]") private WebElement productNameLinkiMac;
	@FindBy(xpath="//h1[normalize-space()='iMac']") private WebElement iMacProductDisplayPage;
	@FindBy(xpath="//div[@class='col-sm-4']//button[2]") private WebElement compareThisProductOption;
	@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']//h4//a") private WebElement iMacProductDisplayedInSearch;
	@FindBy(xpath="//div[@id='product-product']//div[@class='btn-group']//button[2]") private WebElement compareThisProductButton;
	@FindBy(xpath="//li[1]//a[1]//img[1]") private WebElement productThumbnailImage;
	@FindBy(xpath="//div[@class='mfp-content']") private WebElement lightBoxContainer;
	@FindBy(xpath="//button[@title='Previous (Left arrow key)']") private WebElement leftArrowKey;
	@FindBy(xpath="//button[@title='Next (Right arrow key)']") private WebElement nextArrowKey;
	@FindBy(xpath="//div[@class='mfp-counter']") private WebElement paginationText;
	@FindBy(xpath="//button[@title='Close (Esc)']") private WebElement closeButtonOfListBoxView;
	@FindBy(xpath = "//h1[contains(text(),'iMac')]") private WebElement productName;
	@FindBy(xpath = "//li[contains(text(),'Brand:')]") private WebElement brandInfo;
	@FindBy(xpath = "//li[contains(text(),'Product Code:')]") private WebElement productCodeInfo;
	@FindBy(xpath = "//li[contains(text(),'Availability:')]") private WebElement availabilityInfo;
	@FindBy(xpath = "//div[@class='col-sm-4']//ul[@class='list-unstyled']//li//h2") private WebElement priceOfOpenedProduct;
	@FindBy(xpath = "//div[@class='col-sm-4']//ul[@class='list-unstyled']//li[contains(text(),'Ex Tax')]") private WebElement ExTaxPrice;
	@FindBy(xpath = "//input[@id='input-quantity']") private WebElement qtyField;
	@FindBy(id = "button-cart") private WebElement AddToCartButton;
	@FindBy(css = "div.alert.alert-danger, div.alert.alert-warning, div.text-danger") private List<WebElement> errorMessages;
	@FindBy(css = "div.alert.alert-success") private List<WebElement> successMessages;
	@FindBy(id = "cart-total") private WebElement cartTotal;
	@FindBy(xpath = "//div[contains(@class,'alert-success') and contains(text(),'Success: You have added')]") private WebElement successMessage;
	@FindBy(xpath = "//a[normalize-space()='Description']") private WebElement descriptionTab;
	@FindBy(xpath = "//div[@id='tab-description']") private WebElement desciptionText;
	@FindBy(xpath = "//a[normalize-space()='Specification']") private WebElement specificationTab;
	@FindBy(xpath = "//table[@class='table table-bordered']//tr//strong") private WebElement headingOfSpecificationTable;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[1]") private WebElement firstColmnText;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[2]") private WebElement secondColmnText;
	@FindBy(xpath = "//ul[@class='nav nav-tabs']//li[3]//a") private WebElement reviewTab;
	@FindBy(xpath = "//input[@id='input-name']") private WebElement enterNameInReview;
	@FindBy(xpath = "//textarea[@id='input-review']") private WebElement enterReviewTextBox;
	@FindBy(xpath = "//div[@class='col-sm-12']//input[@value='3']") private WebElement selectRatingRadioButton;
	@FindBy(xpath = "//button[@id='button-review']") private WebElement continueReviewBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible' and contains(text(),'review. It has been submitted')]") private WebElement ReviewSubmittedSuccessMsg;
	@FindBy(xpath = "//p[normalize-space()='There are no reviews for this product.']") private WebElement TextUnderReviewTab;
	@FindBy(xpath = "//a[normalize-space()='Reviews (0)']") private WebElement reviewTabProductDisplayPage;
	@FindBy(xpath = "//div[@id='tab-review']//label") private List<WebElement> labels;
	@FindBy(xpath = "//a[normalize-space()='Write a review']") private WebElement writeAReviewLink;
	@FindBy(xpath = "//div[@id='tab-review']") private WebElement tabReview;
	@FindBy(xpath = "//a[contains(text(),'review')]") private WebElement reviewsCount;
	@FindBy(xpath = "//div[@class='rating']//span") private List<WebElement> ratingStars;
	@FindBy(xpath = "//a[contains(normalize-space(),'reviews')]") private WebElement reviewsCountLink;
	@FindBy(xpath = "//div[@id='reviews']//p[contains(text(),'There are no reviews for this product.')]") private WebElement noReviewsMessage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") private WebElement alertMessageForReview;
	@FindBy(xpath = "//button[@class='btn btn-default']//i[@class='fa fa-heart']") private WebElement addToWishListButton;
	@FindBy(xpath = "//a[normalize-space()='wish list']") private WebElement wishListButton;
	@FindBy(xpath = "//div[@id='content']//h2") private WebElement WishListPage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//tr") private List<WebElement> noOfProductsAdded;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement successMessageforWishList;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'wish list')]") private WebElement wishListLinkinSuccessMessage;
	@FindBy(xpath = "//img[@title='Apple Cinema 30\"']") private WebElement relatedProductSection;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[2]") private WebElement breadcrumbOfProductDisplayPage;
	@FindBy(xpath = "//tbody//tr//td[@class='text-center']") private WebElement imgIconMyWishList;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement productDisplayedPage;
	@FindBy(xpath = "//a[normalize-space()='iMac']") private WebElement productNameLinkUnderProductDisplayPage;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'iMac')]") private WebElement productNameLinkUnderSuccessMsg;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement productDisplayPageofProduct;
	@FindBy(xpath = "//a[normalize-space()='shopping cart']") private WebElement shoppingCartLinkUnderSuccessMessage;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'iMac')]") private WebElement productNameLink;
	@FindBy(xpath = "//li[normalize-space()='Reward Points:100']") private WebElement rewardPointText;
	@FindBy(xpath = "//ul[@class='list-unstyled']//span[contains(@style,'line-through')]") private WebElement strikeOffOriginalPrice;
	@FindBy(xpath = "//ul[@class='list-unstyled']//h2") private WebElement unitProductPrice;
	@FindBy(name = "quantity") private WebElement quantityTextBox;
	@FindBy(id = "button-cart") private WebElement addToCartButton;
	@FindBy(xpath = "//span[@id='cart-total']") private WebElement cartTotalPrice;
	@FindBy(xpath = "//i[@class='fa fa-times']") private WebElement cartClosebutton;
	@FindBy(xpath = "//div[@id='content']//h1") private WebElement headingOfProductDisplayPage;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement userIsOnShoppingCartPage;
	@FindBy(xpath = "//span[normalize-space()='Wish List (1)']") private WebElement WishListHeaderOption;
	@FindBy(xpath = "//div[@id='product-product']//div[@class='btn-group']//button[1]") private WebElement addToWishList;
	@FindBy(xpath = "//strong[normalize-space()='View Cart']") private WebElement viewCartOption;
	@FindBy(xpath = "//button[@type='button']//span[contains(text(),'Add to Cart')]") private WebElement addToCartButtonInRelatedSearch;
	@FindBy(xpath = "//div[@class='product-layout product-list col-xs-12']//button[1]") private WebElement appleCinema30AddtoCartBtn;
	@FindBy(xpath = "//img[@title='iPhone']") private WebElement relatedSearchProduct;
	@FindBy(xpath = "//button[@id='button-cart']") private WebElement addToCartButtonForIphone;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[4]") private WebElement wishListlinkSuccessMsg;
	@FindBy(xpath = "//button[@id='button-cart']") private WebElement addToCartButtonMacBook;
	@FindBy(xpath = "//input[@id='input-quantity']") private WebElement qtyFieldMacBook;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[2]") private WebElement iMacBreadCrumbDisplayed;
	@FindBy(xpath = "//h2") private WebElement pcProductPageHeading;
	@FindBy(xpath = "//a[@class='btn btn-primary']") private WebElement pcContinuePage;
	@FindBy(xpath = "//button[@id='button-cart']") private WebElement addToCartHPLP;
	@FindBy(xpath = "//div[@class='col-sm-3']//div[@id='cart']") private WebElement blackCartButton;
	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']//p[@class='text-right']//a[2]") private WebElement checkOutBtninBlackCart;
	@FindBy(xpath = "//button[@id='button-cart']") private WebElement AddToCartButtonHp;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[2]") private WebElement breadcrumb;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement successMessage1;
	@FindBy(xpath = "//h2[normalize-space()='My Wish List']") private WebElement wishListHeader;

	public void clickOnProductComparisonLink() {
	    try {
	        // Wait until the success message and link are visible
	        By comparisonLinkLocator = By.xpath("//a[normalize-space()='product comparison']");
	        waitUtils.waitForElementVisibility(comparisonLinkLocator, 10);

	        WebElement comparisonLink = driver.findElement(comparisonLinkLocator);

	        // Scroll into view to make sure it’s clickable
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", comparisonLink);

	        // Try normal click first
	        try {
	            comparisonLink.click();
	        } catch (ElementClickInterceptedException e) {
	            // Fallback: use JavaScript click if overlay or animation interferes
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", comparisonLink);
	        }

	        System.out.println("Clicked on 'product comparison' link successfully.");

	    } catch (StaleElementReferenceException e) {
	        // Retry if the alert re-renders and element becomes stale
	        WebElement comparisonLink = driver.findElement(By.xpath("//a[normalize-space()='product comparison']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", comparisonLink);
	    } catch (NoSuchElementException e) {
	        System.out.println("Product comparison link not found — it may not have appeared yet.");
	    } catch (Exception e) {
	        System.out.println("Failed to click on product comparison link: " + e.getMessage());
	    }
	}


	public boolean isUserOnWishListPage() {
	    try {
	        // Re-locate element before checking
	        WebElement header = driver.findElement(By.xpath("//h2[normalize-space()='My Wish List']"));
	        waitUtils.waitForElementVisibility(header, 10);
	        return header.isDisplayed();
	    } catch (StaleElementReferenceException e) {
	        // Re-try once after stale reference
	        try {
	            WebElement header = driver.findElement(By.xpath("//h2[normalize-space()='My Wish List']"));
	            waitUtils.waitForElementVisibility(header, 10);
	            return header.isDisplayed();
	        } catch (Exception ex) {
	            return false;
	        }
	    } catch (Exception e) {
	        return false;
	    }
	}

	public boolean areProductAddedSuccessfully() {
	    try {
	        List<WebElement> products = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
	        return !products.isEmpty();
	    } catch (StaleElementReferenceException e) {
	        // retry after stale exception
	        try {
	            List<WebElement> products = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
	            return !products.isEmpty();
	        } catch (Exception ex) {
	            return false;
	        }
	    } catch (Exception e) {
	        return false;
	    }
	}


	public boolean verifyWarningMsgByAddingQuantityToNegativeNullOrZero() {
	    String productName = "iMac";
	    By searchBox = By.name("search");
	    By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	    By productLink = By.xpath("//a[contains(text(),'" + productName + "')]");
	    By quantityInput = By.name("quantity");
	    By addToCartButton = By.id("button-cart");
	    By alertMessage = By.xpath("//div[contains(@class,'alert') or contains(@class,'text-danger')]");

	    String[] invalidQuantities = {"-1", "0", ""};
	    boolean allWarningsDisplayed = true;

	    try {
	        // Search product
	        driver.findElement(searchBox).clear();
	        driver.findElement(searchBox).sendKeys(productName);
	        driver.findElement(searchButton).click();
	        driver.findElement(productLink).click();

	        for (String qty : invalidQuantities) {
	            WebElement qtyBox = driver.findElement(quantityInput);
	            qtyBox.clear();
	            qtyBox.sendKeys(qty);
	            driver.findElement(addToCartButton).click();

	            // Wait for alert to appear
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            try {
	                WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
	                String alertText = alert.getText().trim();

	                System.out.println("Quantity [" + (qty.isEmpty() ? "null" : qty) + "] -> " + alertText);

	                if (alertText.contains("Success:")) {
	                    System.out.println("Success message shown for invalid quantity: " + qty);
	                    allWarningsDisplayed = false;
	                    break;
	                } else if (alertText.toLowerCase().contains("warning") ||
	                           alertText.toLowerCase().contains("error") ||
	                           alertText.toLowerCase().contains("must be between")) {
	                    System.out.println("Warning message displayed for quantity: " + (qty.isEmpty() ? "null" : qty));
	                } else {
	                    System.out.println("Unexpected alert message: " + alertText);
	                    allWarningsDisplayed = false;
	                    break;
	                }
	            } catch (TimeoutException te) {
	                System.out.println("No alert appeared for quantity: " + (qty.isEmpty() ? "null" : qty));
	                allWarningsDisplayed = false;
	                break;
	            }
	            Thread.sleep(1000);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        allWarningsDisplayed = false;
	    }
	    return allWarningsDisplayed;
	}

	public String getSuccessMessageText() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
	        WebElement messageElement = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
	        String msg = messageElement.getText().trim();
	        System.out.println("Captured success message: " + msg);
	        return msg;
	    } catch (Exception e) {
	        System.out.println("Failed to capture success message: " + e.getMessage());
	        return null;
	    }
	}

	public boolean verifyProductDisplayPageBreadcrumbDisplayed()
	{
		try {
			waitUtils.waitForElementVisibility(breadcrumb, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Product display page breadcrumb is not displayed! " + e.getMessage());
			return false;
		}
	}

	public void clickAddToCartButtonForHP()
	{
		waitUtils.waitForElementClickable(AddToCartButtonHp, 10).click();
	}

	public void clickCheckOutBtnInBlackCart()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementClickable(checkOutBtninBlackCart, 10).click();
	}

	public void clickBlackCartButton()
	{
		waitUtils.waitForElementClickable(blackCartButton, 10).click();
	}

	public void clickAddToCartButtonHPLP()
	{
		waitUtils.waitForElementClickable(addToCartHPLP, 10).click();
	}

	public void clickContinuePage()
	{
		waitUtils.waitForElementClickable(pcContinuePage, 10).click();
	}

	public boolean isUserLandedOnPCPage()
	{
		try {
			String headingText = pcProductPageHeading.getText().trim();
			return headingText.equalsIgnoreCase("PC");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public void addQuantityForMacBook(int quantity) {
	    try {
	        // Wait for the quantity field to be visible
	        waitUtils.waitForElementVisibility(qtyFieldMacBook, 10);

	        // Clear the existing quantity
	        qtyFieldMacBook.clear();

	        // Enter the new quantity
	        qtyFieldMacBook.sendKeys(String.valueOf(quantity));

	        // Optional: small pause for UI update (if needed)
	        Thread.sleep(1000);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}



	public boolean isIMacBreadCrumbIsDisplayed()
	{
		return waitUtils.waitForElementVisibility(iMacBreadCrumbDisplayed, 10).isDisplayed();
	}

	public void setProductquantity(int quantity)
	{
		try {
			waitUtils.waitForElementVisibility(qtyFieldMacBook, 10);
			String existingValue = qtyFieldMacBook.getAttribute("value");
			if(existingValue !=null && !existingValue.isEmpty())
			{
				qtyFieldMacBook.clear();
			}
			qtyFieldMacBook.sendKeys(String.valueOf(quantity));
		}catch(Exception e) {
			throw e;
		}
	}
	public void clickAddToCartMacBook()
	{
		waitUtils.waitForElementClickable(addToCartButtonMacBook, 10).click();
	}

	public void clickWishListLinksuccessMesg()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wishListlinkSuccessMsg);
	}

	public void clickAddToCartButtonForIPhone()
	{
		waitUtils.waitForElementClickable(addToCartButtonForIphone, 10).click();
	}

	public void clickRelatedSearchProduct()
	{
		waitUtils.scrollToElementAndClick(relatedSearchProduct);
	}

	public void clickAddToCartButtonAppleProduct()
	{
		waitUtils.waitForElementClickable(appleCinema30AddtoCartBtn, 10).click();
	}

	public void clickAddToCartButtonInRelatedSearch()
	{
		waitUtils.waitForElementClickable(addToCartButtonInRelatedSearch, 10).click();
	}

	public void clickViewCartOption()
	{
		waitUtils.waitForElementClickable(viewCartOption, 10).click();
	}

	public void clickAddToWishListbtn()
	{
		waitUtils.waitForElementClickable(addToWishList, 10).click();
	}

	public void clickWishListHeaderOption()
	{
		waitUtils.waitForElementClickable(WishListHeaderOption, 10).click();
	}

	public boolean IsUserLandedOnShoppingCartPage()
	{
		return waitUtils.waitForElementVisibility(userIsOnShoppingCartPage, 10).isDisplayed();
	}

	public boolean verifyUrlOfProductDisplayPage()
	{
		String url = driver.getCurrentUrl();
		if(url.equals("https://tutorialsninja.com/demo/index.php?route=product/product&product_id=41&search=iMac"))
		{
			return true;
		}
		return false;
	}

	public boolean verifyTitleOfProductDisplayPage()
	{
		String title = driver.getTitle();
		if(title.equals("iMac"))
		{
			return true;
		}
		return false;
	}

	public boolean isProductPageHeadingCorrect(String expectedProductName) {
		try {
			// Wait for page to load and title to be visible
			waitUtils.waitForElementVisibility(headingOfProductDisplayPage, 10);
			// Get title text
			String actualTitle = headingOfProductDisplayPage.getText().trim();
			// Verify dynamically
			return actualTitle.equalsIgnoreCase(expectedProductName);

		} catch (Exception e) {
			System.out.println("Error verifying product page title: " + e.getMessage());
			return false;
		}
	}

	public boolean isPriceOfTwentyProductCorrect() {
		try {
			cartTotalPrice.click();
			waitUtils.waitForPageLoad(10);
			waitUtils.waitForElementClickable(cartClosebutton, 10).click();
			waitUtils.waitForPageLoad(10);

			// Get per-unit price text and clean it
			String unitPriceText = unitProductPrice.getText().replaceAll("[^0-9.]", "");

			// Get cart total text (it may contain quantity and price, like "20 item(s) - $4,839.76")
			String cartText = cartTotalPrice.getText();

			// Extract only the price portion (after the dash)
			String[] parts = cartText.split("-");
			String cartPriceText = parts.length > 1 ? parts[1].replaceAll("[^0-9.]", "") : cartText.replaceAll("[^0-9.]", "");

			// Convert to numeric values
			double perUnitPrice = Double.parseDouble(unitPriceText);
			double actualTotalPrice = Double.parseDouble(cartPriceText);

			// Calculate expected total for 20 products
			double expectedTotalPrice = perUnitPrice * 20;

			System.out.println("Unit Price: " + perUnitPrice);
			System.out.println("Expected (x20): " + expectedTotalPrice);
			System.out.println("Actual Cart Total: " + actualTotalPrice);

			// Allow a small rounding difference (±0.05)
			double tolerance = 0.05;
			return Math.abs(actualTotalPrice - expectedTotalPrice) <= tolerance;

		} catch (Exception e) {
			System.out.println("Error validating price for 20 products: " + e.getMessage());
			return false;
		}
	}


	public boolean isPriceOfTenProductCorrect() {
		try {
			cartTotalPrice.click();
			waitUtils.waitForPageLoad(10);
			waitUtils.waitForElementClickable(cartClosebutton, 10).click();
			waitUtils.waitForPageLoad(10);

			String unitPriceText = unitProductPrice.getText().replaceAll("[^0-9.]", "");
			String cartText = cartTotalPrice.getText();
			String[] parts = cartText.split("-");
			String cartPriceText = parts.length > 1 ? parts[1].replaceAll("[^0-9.]", "") : cartText.replaceAll("[^0-9.]", "");

			double perUnitPrice = Double.parseDouble(unitPriceText);
			double actualTotalPrice = Double.parseDouble(cartPriceText);
			double expectedTotalPrice = perUnitPrice * 10;

			System.out.println("Unit Price: " + perUnitPrice);
			System.out.println("Expected (x10): " + expectedTotalPrice);
			System.out.println("Actual Cart Total: " + actualTotalPrice);

			// Allow a small difference (e.g., ±0.05)
			double tolerance = 0.05;
			return Math.abs(actualTotalPrice - expectedTotalPrice) <= tolerance;

		} catch (Exception e) {
			System.out.println("Error validating price for 10 products: " + e.getMessage());
			return false;
		}
	}

	public void clickAddToCartButtonOnProductDisplay()
	{
		addToCartButton.click();
	}

	public void UpdateQuantityOfProduct(String quantity)
	{
		waitUtils.waitForElementVisibility(quantityTextBox, 10).clear();
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementVisibility(quantityTextBox, 10).sendKeys(quantity);
	}

	public boolean isOriginalPriceDisplayedAsStrikeOff()
	{
		try {
			WebElement element = waitUtils.waitForElementVisibility(strikeOffOriginalPrice, 10);
			if(element.isDisplayed()) {
				String textDecoration = element.getCssValue("text-decoration-line");
				if(textDecoration == null || textDecoration.isEmpty())
				{
					textDecoration = element.getCssValue("text-decoration");
				}
				return textDecoration.contains("line-through");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean isRewardsPointsDisplayedCorrect()
	{
		try {
			if(waitUtils.waitForElementVisibility(rewardPointText, 10).isDisplayed())
			{
				String text=rewardPointText.getText().trim();
				String points = text.replaceAll("[^0-9]", "");
				return points.equals("100");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void clickProductNameLinkUnderMessage()
	{
		waitUtils.waitForElementClickable(productNameLink, 10).click();
	}

	public void clickShoppingCartLink()
	{
		waitUtils.waitForElementClickable(shoppingCartLinkUnderSuccessMessage, 10).click();
	}

	public boolean isUserLandedOnProductDisplayPage()
	{
		return waitUtils.waitForElementVisibility(productDisplayPageofProduct, 10).isDisplayed();
	}

	public void clickProductNameLinkUnderSuccessMsg()
	{
		waitUtils.waitForElementClickable(productNameLinkUnderSuccessMsg, 10).click();
	}

	public void clickProductNameLink()
	{
		waitUtils.waitForElementClickable(productNameLinkUnderProductDisplayPage, 10).click();
	}

	public boolean isProductDisplayed()
	{
		return productDisplayedPage.isDisplayed();
	}

	public void clickImgIcon()
	{
		waitUtils.waitForElementClickable(imgIconMyWishList, 10).click();
	}

	public boolean isBreadCrumbOfRelatedProductIsDisplayed()
	{
		return breadcrumbOfProductDisplayPage.isDisplayed();
	}

	public void clickRelatedSectionProduct()
	{
		waitUtils.scrollToElementAndClick(relatedProductSection);
	}

	public void clickWishListLinkInMessage() {
		try {
			WebElement link = waitUtils.waitForElementClickable(wishListLinkinSuccessMessage, 10);
			link.click();
			System.out.println("Clicked on Wishlist link inside success message.");
		} catch (Exception e) {
			System.out.println("Failed to click Wishlist link: " + e.getMessage());
		}
	}

	public boolean isWishlistMessageDisplayedCorrectly(String productName)
	{
		try {
			WebElement messageElement = waitUtils.waitForElementVisibility(successMessageforWishList, 10);
			String actualMsg = messageElement.getText().trim();
			String expectedText = "You must login or create an account to save " + productName + " to your wish list";

			if (actualMsg.contains(expectedText)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void clickAddToWishListButton()
	{
		waitUtils.waitForElementVisibility(wishListButton, 10).click();
	}

	public void clickAddToWishList()
	{
		waitUtils.waitForElementClickable(addToWishListButton, 10).click();
	}

	public boolean isErrorMessageIsDisplayed()
	{
		return waitUtils.waitForElementVisibility(alertMessageForReview, 10).isDisplayed();
	}

	public boolean isReviewSectionValid() {
		try {
			reviewsCountLink.click();
			Thread.sleep(1000); // or use WebDriverWait for better sync

			if (isElementDisplayed(noReviewsMessage)) {
				String actualMsg = noReviewsMessage.getText().trim();
				if (actualMsg.equals("There are no reviews for this product.")) {
					System.out.println("Verified: No reviews message displayed correctly.");
					return true;
				} else {
					System.out.println("Message mismatch: " + actualMsg);
					return false;
				}
			} else {
				String reviewText = reviewsCountLink.getText().trim(); // e.g. "0 reviews" or "1 review"
				boolean validFormat = reviewText.matches("\\d+ review(s)?");
				if (validFormat) {
					System.out.println("Verified: Review count displayed correctly -> " + reviewText);
					return true;
				} else {
					System.out.println("Invalid review count format: " + reviewText);
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception during review validation: " + e.getMessage());
			return false;
		}
	}

	private boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyReviewCountAndStarRating()
	{
		try {
			waitUtils.waitForElementVisibility(reviewsCount, 10);

			String reviewText = reviewsCount.getText().trim();
			int count = 0;
			try {
				count = Integer.parseInt(reviewText.split(" ")[0]);
			}catch(Exception e) {
				System.out.println(reviewText + e.getMessage());
			}

			boolean validCount = count>=0;
			boolean starsVisible = !ratingStars.isEmpty();
			System.out.println("Number of rating stars displayed: " + ratingStars.size());

			System.out.println("Valid review count: " + validCount + ", Stars visible: " + starsVisible);
			return validCount && starsVisible;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickWriteAReviewAndVerifyTabActive() {
		try {
			writeAReviewLink.click();

			waitUtils.waitForPageLoad(10);
			waitUtils.waitForElementVisibility(tabReview, 10).getAttribute("class").contains("active");
			return tabReview.getAttribute("class").contains("active");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean areAllReviewFieldsMandatory()
	{
		boolean allMandatory = true;

		for(WebElement label:labels)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String content = (String) js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",label);
			if(content == null || content.equals("") || !content.contains("*")) {
				allMandatory = false;
			}else {
				System.out.println(label.getText());
			}
		}
		return allMandatory;
	}

	public void clickReviewTabOnProductDisplayPage()
	{
		reviewTabProductDisplayPage.click();
	}

	public String getTextUnderReviewTab()
	{
		return TextUnderReviewTab.getText();
	}

	public String getReviewSubmittedSuccessMsg()
	{
		return ReviewSubmittedSuccessMsg.getText();
	}

	public void clickContinueReviewButton()
	{
		waitUtils.waitForElementVisibility(continueReviewBtn, 10).click();
	}

	public void selectRatingRadioButton()
	{
		waitUtils.waitForElementClickable(selectRatingRadioButton, 10).click();
	}

	public void AddReviewInTextBox(String review)
	{
		enterReviewTextBox.sendKeys(review);
	}

	public void enterNameInReview(String name)
	{
		enterNameInReview.sendKeys(name);
	}

	public void clickReviewTab()
	{
		reviewTab.click();
	}

	public String getTitleOFSpecification()
	{
		return headingOfSpecificationTable.getText();
	}

	public String getFirstColmnText()
	{
		return firstColmnText.getText();
	}

	public String getSecondColmnText()
	{
		return secondColmnText.getText();
	}

	public void clickSpecificationTab()
	{
		specificationTab.click();
	}

	public String getDescriptionText()
	{
		return desciptionText.getText();
	}

	public void clickDescriptionTab()
	{
		if(!descriptionTab.isSelected())
		{
			descriptionTab.click();
		}
	}

	public String getGlobalSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText().trim();
	}

	public void enterValueInQuantityTextBox(String value)
	{
		waitUtils.waitForElementVisibility(qtyField, 10).clear();
		qtyField.sendKeys(value);
	}

	public boolean checkInvalidQuantity(String qty) {
		try {
			qtyField.clear();
			qtyField.sendKeys(qty);
			AddToCartButton.click();
			Thread.sleep(1000); // small wait for message to appear

			if (!errorMessages.isEmpty()) {
				System.out.println("Validation message appeared for invalid quantity: " + qty);
				return true;
			}
			if (!successMessages.isEmpty()) {
				System.out.println("BUG: Success message appeared for invalid quantity: " + qty);
				return false;
			}
			System.out.println("No message appeared for invalid quantity: " + qty);
			return false;
		} catch (Exception e) {
			System.out.println("Exception occurred while testing qty '" + qty + "': " + e.getMessage());
			return false;
		}
	}

	public void clickAddToCartButton()
	{
		waitUtils.waitForElementClickable(AddToCartButton, 10).click();
	}

	public boolean verifyUpdatedQuantity()
	{
		try {
			waitUtils.waitForElementVisibility(qtyField, 10);
			String quantityValue = qtyField.getAttribute("value").trim();
			return quantityValue.equals("2");
		}catch(Exception e) {
			return false;
		}
	}

	public void UpdateQuantity(int quantity)
	{
		try {
			waitUtils.waitForElementVisibility(qtyField, 10);
			qtyField.clear();
			qtyField.sendKeys(String.valueOf(quantity));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getQuantity()
	{
		return qtyField.getAttribute("value").trim();
	}

	public boolean verifyDefaultQuantityis1()
	{
		try {
			waitUtils.waitForElementVisibility(qtyField, 10);

			String quantityValue = qtyField.getAttribute("value").trim();
			return quantityValue.equals("1");
		}catch(Exception e) {
			return false;
		}
	}

	public boolean isQtyTextFieldIsEnabled()
	{
		return qtyField.isEnabled();
	}

	public boolean verifyDisplayedProductPriceAndExTaxPrice()
	{
		try {
			String priceText = priceOfOpenedProduct.getText().trim();
			String exTaxText = ExTaxPrice.getText().trim();

			boolean isPriceValid = priceText.matches("^\\$\\d+(\\.\\d{2})?$");
			boolean isExTaxValid = exTaxText.matches("^Ex Tax:\\$\\d+(\\.\\d{2})?$");

			return priceOfOpenedProduct.isDisplayed() && ExTaxPrice.isDisplayed() && isPriceValid && isExTaxValid;
		}catch(Exception e){
			return false;
		}
	}

	public boolean verifyAvailabilityStatus()
	{
		try {
			String availabilityText = availabilityInfo.getText().trim();
			String status = availabilityText.split("Availability:")[1].trim();

			List<String> validStatuses = new ArrayList<>();
			validStatuses.add("In Stock");
			validStatuses.add("Out Of Stock");
			validStatuses.add("Limited Stock");

			if(validStatuses.contains(status)) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}

	public boolean verifyProductInformation(String expectedName, String expectedBrand, String expectedCode, String expectedAvailability)
	{
		try {
			String actualName = productName.getText().trim();
			String actualBrand = brandInfo.getText().split("Brand:")[1].trim();
			String actualCode = productCodeInfo.getText().split("Product Code:")[1].trim();
			String actualAvailability = availabilityInfo.getText().split("Availability:")[1].trim();

			boolean isNameCorrect = actualName.equalsIgnoreCase(expectedName);
			boolean isBrandCorrect = actualBrand.equalsIgnoreCase(expectedBrand);
			boolean isCodeCorrect = actualCode.equalsIgnoreCase(expectedCode);
			boolean isAvailabilityCorrect = actualAvailability.equalsIgnoreCase(expectedAvailability);

			if(isNameCorrect && isBrandCorrect && isCodeCorrect && isAvailabilityCorrect)
			{
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void pressEscapeKey() {
		try {
			if(lightBoxContainer.isDisplayed())
			{
				Actions actions = new Actions(driver);
				actions.sendKeys(org.openqa.selenium.Keys.ESCAPE).build().perform();
			}
		} catch (Exception e) {
			System.out.println("Failed to press Escape key: " + e.getMessage());
		}
	}

	public void clickCloseButtonListBoxView()
	{
		closeButtonOfListBoxView.click();
	}

	public boolean verifyLightBoxPreviousNextWrapping()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			int totalImages = Integer.parseInt(paginationText.getText().trim().split(" ")[2]);
			if(paginationText.getText().trim().startsWith("1")) {
				leftArrowKey.click();
				wait.until(d-> paginationText.getText().trim().equals(totalImages + " of " + totalImages));
				if(!paginationText.getText().trim().equals(totalImages + " of " + totalImages)) {
					return false;
				}
			}
			if (paginationText.getText().trim().startsWith(totalImages + "")) {
				nextArrowKey.click();
				wait.until(d -> paginationText.getText().trim().equals("1 of " + totalImages));
				if (!paginationText.getText().trim().equals("1 of " + totalImages)) {
					return false;
				}
			}
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public void clickNextArrowKey()
	{
		nextArrowKey.click();
	}

	public void clickLeftArrowKey()
	{
		leftArrowKey.click();
	}

	public boolean isNextArrowKeyIsDisplayed()
	{
		try {
			return nextArrowKey.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean isLightBoxContainerIsDisplyed()
	{
		try {
			return lightBoxContainer.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean isLeftArrowKeyIsDisplayed()
	{
		try {
			return leftArrowKey.isDisplayed();
		}catch(Exception e){
			return false;
		}
	}

	public void clickProductThumbnail()
	{
		waitUtils.waitForElementClickable(productThumbnailImage, 10).click();
	}

	public void clickCompareThisProductButton()
	{
		waitUtils.waitForElementClickable(compareThisProductButton, 10).click();
	}

	public void clickiMacLinkInDisplayedSearchResult()
	{
		waitUtils.scrollToElementAndClick(iMacProductDisplayedInSearch);
	}

	public void clickCompareThisProductOptionOnProductDisplayPage()
	{
		waitUtils.waitForElementClickable(compareThisProductOption, 10).click();
	}

	public boolean userIsOniMacProductDisplayPage()
	{
		return waitUtils.waitForElementVisibility(iMacProductDisplayPage, 10).isDisplayed();
	}

	public void clickProductNameDisplayedInLink()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementClickable(productNameLinkiMac, 10).click();
	}

	public void waitForFewSeconds()
	{
		waitUtils.waitForPageLoad(10);
	}

	public void clickProductComparisonLink()
	{
		waitUtils.waitForElementClickable(productComparisonLink, 10).click();
	}

	public String getProductCompareSuccessAddedMsg()
	{
		return ProductCompareSuccessAddedMsg.getText();
	}

	public void clickCompareThisProductOption()
	{
		CompareThisProduct.click();
	}

	public String getCompareProductMouseHoverText()
	{
		return CompareProductHoverText.getText();
	}

	public void HoverOnCompareThisProduct()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(CompareThisProduct).perform();
	}

	public String getProductAddedSuccessMsg()
	{
		String rawMsg = ProductAddedSuccessMsg.getText();
		return rawMsg.replace("×", "").trim().replace("\n", " ");
	}

	public void clickProductCompare(int index)
	{
		if(index>=0 && index<productCompareBtns.size()) {
			productCompareBtns.get(index).click();
		}else {
			throw new RuntimeException("Invalid product index: " + index);
		}
	}

	public String IsRightProductPageDisplayed()
	{
		return lastBreadcrumbpage.getText();
	}


}
