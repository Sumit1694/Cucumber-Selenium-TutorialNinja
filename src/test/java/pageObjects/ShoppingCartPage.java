package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//table[@class='table table-bordered']//td[2]/a") private WebElement productNameInCart;
	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/img[1]") private WebElement imgOfProductUnderShoppingCart;
	@FindBy(xpath = "//span[normalize-space()='Checkout']") private WebElement checkOutButton;
	@FindBy(xpath = "//span[@id='cart-total']") private WebElement cartButton;
	@FindBy(xpath = "//img[@class='img-thumbnail']") private WebElement imgOfProductToggledBox;
	@FindBy(xpath = "//td[@class='text-left']//a[contains(text(),'HP LP3065')]") private WebElement productNameLinkToggleBox;
	@FindBy(xpath = "//div[@id='content']//form//table[contains(@class,'table-bordered')]/tbody/tr") private List<WebElement> productsListedInShoppingCart;
	@FindBy(xpath = "//div[@id='content']//form//table[contains(@class,'table-bordered')]/tbody/tr") private List<WebElement> cartProductRows;
	@FindBy(xpath = "//div[@id='content']//form//table[contains(@class,'table-bordered')]/tbody/tr//td[5]") private WebElement priceOfMacBook;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr[td[@class='text-left']//a]") private List<WebElement> CartProductRows;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[4]/div/input[@type='text']") private List<WebElement> quantityInputs;
	@FindBy(xpath = "//button[@id='button-cart']") private WebElement addToCartbtn;
	@FindBy(xpath = "//div[@class='col-sm-4']//li[3]") private WebElement availabilityText;
	@FindBy(xpath = "//div[contains(@class,'alert-danger') or contains(@class,'alert-dismissible')]") private WebElement errorMessage;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr") private List<WebElement> cartRows;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[1]/a/img") private List<WebElement> productImages;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[2]/a") private List<WebElement> productNames;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[5]") private List<WebElement> unitPrices;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[4]/div/input") private List<WebElement> quantityFields;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[6]") private List<WebElement> lineTotals;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[1]/a/img") private WebElement productImage;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[2]/a") private WebElement productNameLink;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[4]/div/input") private WebElement quantityField;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[6]") private WebElement lineTotal;
	@FindBy(xpath = "//table[@class='table table-bordered']//input[contains(@name,'quantity')]") private WebElement quantityInputTextbox;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[5]") private WebElement unitPrice;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[6]") private WebElement totalPrice;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[5]") private List<WebElement> multipleunitPrice;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[6]") private List<WebElement> multipletotalPrice;
	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]") private WebElement GrandTotalPrice;
	@FindBy(xpath = "//button[@type='submit']") private WebElement updateQuantity;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement successmodifiedCartMessage;
	@FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]") private WebElement emptyShoppingCartMessage;
	@FindBy(xpath = "//button[@class='btn btn-danger']") private WebElement removeButton;
	@FindBy(xpath = "//div[@id='content']//button[@data-original-title='Remove']") private List<WebElement> removeButtons;
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr/td[2]/a") private List<WebElement> productNamePresentInCart;
	@FindBy(xpath = "//a[@class='btn btn-default']") private WebElement continueShoppingBtn;
	@FindBy(xpath = "//a[@class='btn btn-primary']") private WebElement checkOutBtn;
	@FindBy(xpath = "//div[@id='content']//table//td[contains(normalize-space(), 'Gift Certificate')]") private WebElement giftCertificateProductName;
	@FindBy(xpath = "//div[@id='content']//table//tr[2]//td[2][contains(normalize-space(),'$1.00')]") private WebElement totalAmountGiftCertificate;

	public boolean verifyGiftCertificateIsAddedToShoppingCart() {
	    try {
	        waitUtils.waitForElementVisibility(giftCertificateProductName, 10);
	        String productName = giftCertificateProductName.getText().trim();
	        // Locate total dynamically to make it flexible
	        WebElement totalAmountCell = driver.findElement(By.xpath("//div[@id='content']//table//tr[2]//td[contains(normalize-space(),'$')]"));
	        String totalAmount = totalAmountCell.getText().trim();
	        // Validation
	        if (productName.contains("Gift Certificate") && totalAmount.startsWith("$")) {
	            System.out.println("Gift Certificate successfully added to cart.");
	            System.out.println("Product: " + productName + " | Total: " + totalAmount);
	            return true;
	        } else {
	            System.out.println("Gift Certificate not found or amount mismatch!");
	            System.out.println("Product found: " + productName + ", Total: " + totalAmount);
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println("Gift Certificate is not added to shopping cart! " + e.getMessage());
	        return false;
	    }
	}

	public void clickCheckOutButton()
	{
		waitUtils.waitForElementClickable(checkOutBtn, 10).click();
	}

	public void clickContinueShoppingButton()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementClickable(continueShoppingBtn, 10).click();
	}

	public boolean isQuantityHighAcceptedInShoppingCart()
	{
		try {
			waitUtils.waitForElementVisibility(quantityField, 10);
			String quantityFieldValue = quantityField.getAttribute("value").trim();
			return quantityFieldValue.equals("1000");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void clickProductNamePresentInCart()
	{
		try {
		   if(!productNamePresentInCart.isEmpty())
		   {
			   WebElement firstProduct = productNamePresentInCart.get(0);
			   waitUtils.waitForElementClickable(firstProduct, 10);
			   firstProduct.click();
		   }else {
			   System.out.println("No products found in the cart.");
		   }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void clickRemoveAllButtons() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        while (!driver.findElements(By.xpath("//div[@id='content']//button[@data-original-title='Remove']")).isEmpty()) {
	            // Always find the first button fresh from the DOM
	            WebElement firstButton = driver.findElement(By.xpath("//div[@id='content']//button[@data-original-title='Remove']"));

	            firstButton.click(); // click remove

	            // Wait until the row/button is removed from DOM
	            wait.until(ExpectedConditions.stalenessOf(firstButton));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void clickRemoveButton()
	{
		waitUtils.waitForElementClickable(removeButton, 10).click();
	}

	public void UpdateQuantityAsString(String invalidString)
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementVisibility(quantityInputTextbox, 10).clear();
		waitUtils.waitForElementVisibility(quantityInputTextbox, 10).sendKeys(invalidString);
	}

	public boolean userIsLandedOnShoppingCartPage()
	{
		return driver.getTitle().equals("Shopping Cart");
	}

	public boolean isEmptyShoppingCartPageIsDisplayed()
	{
		waitUtils.waitForPageLoad(10);
		return waitUtils.waitForElementVisibility(emptyShoppingCartMessage, 10).isDisplayed();
	}

	public boolean isSuccessModifiedCartMessageDisplayed()
	{
		waitUtils.waitForPageLoad(10);
		return waitUtils.waitForElementVisibility(successmodifiedCartMessage, 10).isDisplayed();
	}

	public void clickUpdateQuantity()
	{
		waitUtils.waitForElementVisibility(updateQuantity, 10).click();
	}

	public void updateQuantityInShoppingCartProduct(int updatedNum)
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementVisibility(quantityInputTextbox, 10).clear();
		waitUtils.waitForElementVisibility(quantityInputTextbox, 10).sendKeys(String.valueOf(updatedNum));
	}

	public boolean verifyGrandTotalPriceforMultipleProductsAdded()
	{
		try {
			waitUtils.waitForPageLoad(10);
			waitUtils.waitForElementVisibility(GrandTotalPrice, 10);

			double calculatedGrandTotalPrice = 0.0;
			for(WebElement productTotal:multipletotalPrice)
			{
				String totalText = productTotal.getText().replace("$", "").replace(",", "").trim();
				double totalValue = Double.parseDouble(totalText);
				calculatedGrandTotalPrice=calculatedGrandTotalPrice+totalValue;
			}

			String GrandTotalText = GrandTotalPrice.getText().replace("$", "").replace(",", "").trim();
			double displayedGrandTotal = Double.parseDouble(GrandTotalText);

			return Math.abs(calculatedGrandTotalPrice - displayedGrandTotal)<0.01;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyTotalPriceBasedOnQuantity() {
		try {
			waitUtils.waitForPageLoad(10);
			waitUtils.waitForElementVisibility(quantityInputTextbox, 10);

			// Get values
			int quantityValue = Integer.parseInt(quantityInputTextbox.getAttribute("value").trim());
			double perUnitPrice = Double.parseDouble(unitPrice.getText().replace("$", "").replace(",", "").trim());
			double totalPriceBasedOnQuantity = Double.parseDouble(totalPrice.getText().replace("$", "").replace(",", "").trim());
			// Verify total calculation
			return Math.abs((quantityValue * perUnitPrice) - totalPriceBasedOnQuantity) < 0.01; // small tolerance for rounding
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyProductDetailsDisplayedInShoppingCart() {
		try {
			waitUtils.waitForPageLoad(10);
			boolean imageDisplayed = waitUtils.waitForElementVisibility(productImage, 10).isDisplayed();
			boolean nameDisplayed = waitUtils.waitForElementVisibility(productNameLink, 10).isDisplayed();
			boolean priceDisplayed = waitUtils.waitForElementVisibility(unitPrice, 10).isDisplayed();
			boolean qtyDisplayed = waitUtils.waitForElementVisibility(quantityField, 10).isDisplayed();
			boolean totalDisplayed = waitUtils.waitForElementVisibility(lineTotal, 10).isDisplayed();
			boolean allVisible = imageDisplayed && nameDisplayed && priceDisplayed && qtyDisplayed && totalDisplayed;
			System.out.println("Image visible: " + imageDisplayed);
			System.out.println("Product name visible: " + nameDisplayed);
			System.out.println("Unit price visible: " + priceDisplayed);
			System.out.println("Quantity field visible: " + qtyDisplayed);
			System.out.println("Line total visible: " + totalDisplayed);
			return allVisible;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyCurrencySymbolInPriceColumn(String expectedCurrencySymbol) {
		try {
			waitUtils.waitForPageLoad(10);

			for (WebElement priceElement : unitPrices) {
				String priceText = priceElement.getText().trim();
				if (!priceText.startsWith(expectedCurrencySymbol)) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAddToCartBehaviorForOutOfStockProduct() {
		try {
			waitUtils.waitForElementVisibility(availabilityText, 10);
			String availabilityStatus = availabilityText.getText().split(":")[1].trim();

			if (availabilityStatus.equalsIgnoreCase("Out Of Stock")) {
				waitUtils.waitForElementVisibility(addToCartbtn, 10);

				if (!addToCartbtn.isEnabled()) {
					return true;
				} else {
					addToCartbtn.click();
					waitUtils.waitForElementVisibility(errorMessage, 10);

					String actualErrorText = errorMessage.getText();
					System.out.println("Error message displayed: " + actualErrorText);

					return actualErrorText.toLowerCase().contains("out of stock")
							|| actualErrorText.toLowerCase().contains("unavailable");
				}
			} else {
				return addToCartbtn.isEnabled();
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void clickAddToCartBtn()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementClickable(addToCartbtn, 10).click();
	}

	public boolean verifyOneProductsWithQuantityThreeEach()
	{
		try {
			waitUtils.waitForPageLoad(10);
			int productCount = cartProductRows.size();
			if(productCount != 1)
			{
				return false;
			}
			for (int i = 1; i <= productCount; i++) {
				WebElement qtyInput = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr[" + i + "]/td[4]/div/input[@type='text']"));
				String qtyValue = qtyInput.getAttribute("value").trim();
				if (!qtyValue.equals("3")) {
					return false;
				}
			}
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean verifyOneProductsWithQuantityTwoEach()
	{
		try {
			waitUtils.waitForPageLoad(10);
			int productCount = cartProductRows.size();
			if(productCount != 1)
			{
				return false;
			}
			for (int i = 1; i <= productCount; i++) {
				WebElement qtyInput = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr[" + i + "]/td[4]/div/input[@type='text']"));
				String qtyValue = qtyInput.getAttribute("value").trim();
				if (!qtyValue.equals("2")) {
					return false;
				}
			}
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean verifyThreeProductsWithQuantityOneEach() {
		try {
			waitUtils.waitForPageLoad(10);
			int productCount = cartProductRows.size();
			if (productCount != 3) {
				return false;
			}
			for (int i = 1; i <= productCount; i++) {
				WebElement qtyInput = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr[" + i + "]/td[4]/div/input[@type='text']"));
				String qtyValue = qtyInput.getAttribute("value").trim();
				if (!qtyValue.equals("1")) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}



	public boolean verifyPriceOfMacBookProductInShoppingCart()
	{
		String priceText = priceOfMacBook.getText();
		if(priceText.equals("$602.00"))
		{
			return true;
		}else {
			return false;
		}
	}

	public boolean verifyProductIsListedInShoppingCart() {
		try {
			int productCount = cartProductRows.size();
			System.out.println("Products listed in Shopping Cart: " + productCount);

			if (productCount > 0) {
				System.out.println("Product is listed in the Shopping Cart.");
				return true;
			} else {
				System.out.println("No products found in the Shopping Cart.");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Error while verifying product listing: " + e.getMessage());
			return false;
		}
	}


	public void clickProductNameLinkCartToggleBox()
	{
		if(waitUtils.waitForElementVisibility(productNameLinkToggleBox, 10).isDisplayed())
		{
			waitUtils.waitForElementClickable(productNameLinkToggleBox, 10).click();
		}
	}

	public void clickImgOfCartToggledBox()
	{
		if(waitUtils.waitForElementVisibility(imgOfProductToggledBox, 10).isDisplayed())
		{
			waitUtils.waitForElementClickable(imgOfProductToggledBox, 10).click();
		}
	}

	public void clickCartButton()
	{
		waitUtils.waitForElementVisibility(cartButton, 10).click();
	}

	public void clickCheckoutPageButton()
	{
		waitUtils.waitForElementClickable(checkOutButton, 10).click();
	}

	public void clickShoppingCart()
	{
		waitUtils.waitForElementClickable(imgOfProductUnderShoppingCart, 10).click();
	}

	public boolean isProductAddedToCart(String expectedProductName) {
		String actualName = productNameInCart.getText().trim();
		return actualName.equalsIgnoreCase(expectedProductName);
	}

}
