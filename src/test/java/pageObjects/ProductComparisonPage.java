package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

public class ProductComparisonPage extends BasePage {

	public ProductComparisonPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[normalize-space()='Product Comparison']") private WebElement headingProductComparison;
	@FindBy(xpath="//tbody//tr[1]//td[2]//a//strong") private WebElement ProductNameInProductComparisonPage;
	@FindBy(xpath="//div[@id='content']//table") private WebElement ProductCompareWebTable;
	@FindBy(xpath="//div[@id='content']//p") private WebElement notchosenanyproducts;
	@FindBy(xpath="//div[@class='pull-right']//a") private WebElement ContinueBtn;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[2]//a") private WebElement BreadcrumbOfProductComparisonPage;
	@FindBy(xpath = "//table[@class='table table-bordered']") private WebElement comparisonTable;
	@FindBy(xpath = "//table[@class='table table-bordered']//tr[1]//td//a") private List<WebElement> productNames;
	@FindBy(xpath = "//tr[td[contains(text(),'Price')]]/td[2]") private WebElement productPrice;
	@FindBy(xpath = "//tr[td[contains(text(),'Model')]]/td[2]") private WebElement productModel;
	@FindBy(xpath = "//tr[td[contains(text(),'Brand')]]/td[2]") private WebElement productBrand;
	@FindBy(xpath = "//tr[td[contains(text(),'Availability')]]/td[2]") private WebElement productAvailability;
	@FindBy(xpath = "//input[@value='Add to Cart']") private WebElement addToCartButton;
	@FindBy(xpath = "//a[normalize-space()='Remove']") private WebElement removeButton;
	@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td[@class='name']/a") private List<WebElement> productName;
	@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td[@class='price']") private List<WebElement> productPrices;
	@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td[@class='model']") private List<WebElement> productModels;
	@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td[@class='brand']") private List<WebElement> productBrands;
	@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td[@class='availability']") private List<WebElement> productAvailabilities;
	@FindBy(xpath = "//input[@value='Add to Cart']") private List<WebElement> addToCartButtons;
	@FindBy(xpath = "//a[text()='Remove']") private List<WebElement> removeButtons;
	@FindBy(xpath = "//a[normalize-space()='shopping cart']") private WebElement shoppingCartlnk;
	@FindBy(xpath = "//div[contains(@class,'alert-success') and contains(text(),'Success: You have modified your product comparison!')]") private WebElement successMessage;
	@FindBy(xpath = "//h1[contains(text(),'Product Comparison')]") private WebElement pageHeading;

	public boolean clickAddToCartButton() {
	    try {
	        waitUtils.waitForPageLoad(10);
	        waitUtils.waitForElementVisibility(addToCartButton, 10);
	        waitUtils.waitForElementClickable(addToCartButton, 10);

	        try {
	            addToCartButton.click();
	        } catch (ElementClickInterceptedException e) {
	            // If something overlays the button temporarily, scroll and retry with JS
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
	            Thread.sleep(500);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
	        }

	        return true;

	    } catch (StaleElementReferenceException e) {
	        // Re-locate and retry once if element went stale
	        WebElement freshAddToCart = driver.findElement(By.xpath("//input[@value='Add to Cart']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", freshAddToCart);
	        return true;

	    } catch (Exception e) {
	        System.out.println("Add to Cart button not clickable! " + e.getMessage());
	        return false;
	    }
	}

	public String getPageURL() {
        return driver.getCurrentUrl();
    }

	public String getPageHeading() {
		return pageHeading.getText().trim();
	}

	public String getTitleOfProductComparisonPage()
	{
		return driver.getTitle();
	}

	public boolean isProductComparisonModifiedSuccessMessageDisplayed() {
		try {
			return successMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickRemoveButton()
	{
		waitUtils.waitForElementClickable(removeButton, 10).click();
	}

	public void ClickShoppingCartLink()
	{
		waitUtils.waitForElementClickable(shoppingCartlnk, 10).click();
	}

	public void verifyProductsInComparisonPage(int expectedCount, String firstRemovedProductName) {
		//Locate product names (each product column's header link)
		List<WebElement> productNameElements = driver.findElements(
				By.cssSelector("table.table.table-bordered tbody tr td.name a"));

		List<String> displayedProductNames = new ArrayList<>();
		for (WebElement element : productNameElements) {
			String name = element.getText().trim();
			if (!name.isEmpty()) {
				displayedProductNames.add(name);
			}
		}

		//Verify that the first added product (e.g. iMac) is removed
		Assert.assertFalse(displayedProductNames.contains(firstRemovedProductName),
				"The first added product (" + firstRemovedProductName + ") is still displayed, but it should have been removed!");

		//Verify that exactly expectedCount products are visible
		int totalProducts = driver.findElements(By.cssSelector("div#content td.text-center img")).size();
		Assert.assertEquals(totalProducts, expectedCount,
				"Expected " + expectedCount + " products, but found " + totalProducts);

		//Verify all displayed products have images, buttons, and details
		for (int i = 1; i <= expectedCount; i++) {
			WebElement productImage = driver.findElement(
					By.xpath("(//div[@id='content']//td[@class='text-center']/img)[" + i + "]"));
			Assert.assertTrue(productImage.isDisplayed(), "Product image not displayed for product index: " + i);

			WebElement addToCartBtn = driver.findElement(
					By.xpath("(//input[@value='Add to Cart'])[" + i + "]"));
			Assert.assertTrue(addToCartBtn.isDisplayed(), "Add to Cart button not displayed for product index: " + i);

			WebElement removeBtn = driver.findElement(
					By.xpath("(//a[text()='Remove'])[" + i + "]"));
			Assert.assertTrue(removeBtn.isDisplayed(), "Remove button not displayed for product index: " + i);

			List<WebElement> infoRows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
			Assert.assertTrue(infoRows.size() >= 8, "Less than 8 information rows for product comparison");
		}
	}

	public void verifyProductsInComparisonPage(int expectedCount) {
		// Locate all product comparison columns (excluding the first column with feature names)
		@SuppressWarnings("unused")
		List<WebElement> productColumns = driver.findElements(By.cssSelector(".table.table-bordered tr td:nth-child(n+2)"));

		// Count unique product columns (each column represents one product)
		int totalProducts = driver.findElements(By.cssSelector("div#content td.text-center img")).size();

		// Verify product count
		Assert.assertEquals(totalProducts, expectedCount, "Expected " + expectedCount + " products, but found " + totalProducts);

		// For each product column, verify presence of details and buttons
		for (int i = 1; i <= expectedCount; i++) {
			// Verify product image
			WebElement productImage = driver.findElement(By.xpath("(//div[@id='content']//td[@class='text-center']/img)[" + i + "]"));
			Assert.assertTrue(productImage.isDisplayed(), "Product image " + i + " not displayed");

			// Verify Add to Cart button
			WebElement addToCartBtn = driver.findElement(By.xpath("(//input[@value='Add to Cart'])[" + i + "]"));
			Assert.assertTrue(addToCartBtn.isDisplayed(), "Add to Cart button not displayed for product " + i);

			// Verify Remove button
			WebElement removeBtn = driver.findElement(By.xpath("(//a[text()='Remove'])[" + i + "]"));
			Assert.assertTrue(removeBtn.isDisplayed(), "Remove button not displayed for product " + i);

			// Verify information rows (each row represents a feature)
			List<WebElement> infoRows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
			Assert.assertTrue(infoRows.size() >= 8, "Less than 8 information rows for product comparison");
		}

		System.out.println("Verified " + expectedCount + " products with proper details, Add to Cart, and Remove buttons.");
	}


	public void verifyBreadcrumbIsWorking()
	{
		String beforeClickTitle = driver.getTitle();
		waitUtils.waitForElementClickable(BreadcrumbOfProductComparisonPage, 10).click();
		waitUtils.waitForPageLoad(10);
		String afterClickTitle = driver.getTitle();
		Assert.assertTrue(!beforeClickTitle.isEmpty(), "Before title was empty!");
		Assert.assertEquals(beforeClickTitle, afterClickTitle, "Page did not reload properly after clicking breadCrumb!");
	}

	public boolean isBredCrumbOfProductComparisonPageIsDisplayed()
	{
		return BreadcrumbOfProductComparisonPage.isDisplayed();
	}

	public void clickContinueButton()
	{
		waitUtils.waitForElementVisibility(ContinueBtn, 10).click();
	}

	public String getNoProductChoosenText()
	{
		return notchosenanyproducts.getText();
	}

	public boolean isProductCompareTableIsDisplayed()
	{
		return waitUtils.waitForElementVisibility(ProductCompareWebTable, 10).isDisplayed();
	}

	public boolean userIsoNProductComparePage()
	{
		return waitUtils.waitForElementVisibility(headingProductComparison, 10).isDisplayed();
	}

	public String getProductNameInProductComparisonPage()
	{
		return ProductNameInProductComparisonPage.getText();
	}

	public String getProductComparisonPageHeading()
	{
		return headingProductComparison.getText();
	}
}
