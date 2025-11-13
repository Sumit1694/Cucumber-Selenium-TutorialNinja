package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListPage extends BasePage {

	public MyWishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@class='btn btn-primary']//i[@class='fa fa-shopping-cart']") private WebElement AddToCartButton;
	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']") private WebElement shoppingCartHeaderOption;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//tr") private List<WebElement> productsListInWishlist;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//tr//td[6]//a") private List<WebElement> removeButtons;
	@FindBy(xpath = "//div[@id='content']//p") private WebElement emptyWishListmessage;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement myWishListPageBreadCrumb;
	@FindBy(xpath = "//a[@id='wishlist-total']") private WebElement WishListHeaderOption;
	@FindBy(xpath = "//tbody/tr[1]/td[6]/button[1]/i[1]") private WebElement addToCartBtn;
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]") private WebElement stockStatus;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//td[4]") private WebElement stockStatusText;
	@FindBy(xpath = "//button[@data-original-title='Add to Cart']") private WebElement addToCartButtonUnderActionColmn;

	public boolean validateAddToCartButtonIsDisabledForOutOfStockProduct()
	{
		try {
			waitUtils.waitForElementVisibility(stockStatusText, 10);
			String stockStatus = stockStatusText.getText().trim();

			if(stockStatus.equalsIgnoreCase("Out Of Stock")) {
				boolean isEnabled = addToCartButtonUnderActionColmn.isEnabled();

				if(!isEnabled) {
					return true;
				}else {
					return false;
				}
			}else {
				addToCartButtonUnderActionColmn.click();
				return true;
			}
		}catch(Exception e) {
			log.error("Exception while validating add to cart buttton state: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyAddToCartButtonIsDisabledForOutOfStockProduct()
	{
		try {
			String statusText = stockStatus.getText().trim();

			if(statusText.equalsIgnoreCase("Out Of Stock")) {
				boolean isButtonEnabled = addToCartBtn.isEnabled();

				if(isButtonEnabled) {
					return false;
				}else {
					return true;
				}
			}else {
				return addToCartBtn.isEnabled();
			}
		}catch(Exception e) {
			return false;
		}
	}

	public void clickAddToCartButtonfromWishList()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementVisibility(addToCartBtn, 10).click();
	}

	public boolean isWishListCountDecreasedAfterRemove()
	{
		int beforeRemove = getWishListHeaderCount();
		waitUtils.waitForElementClickable(WishListHeaderOption, 10).click();
		removeAllProductsOneByOne();
		int afterRemove = getWishListHeaderCount();
		return afterRemove < beforeRemove;
	}

	public int getWishListHeaderCount()
	{
		String text = WishListHeaderOption.getText().replaceAll("[^0-9]", "");
		return Integer.parseInt(text);
	}

	public boolean isMyWishListBreadCrumbIsDisplayed()
	{
		return waitUtils.waitForElementVisibility(myWishListPageBreadCrumb, 10).isDisplayed();
	}

	public boolean isWishlistProductDetailsDisplayed()
	{
		if(productsListInWishlist.isEmpty()) {
			return false;
		}

		boolean allDetailsDisplayed = true;

		for(WebElement row:productsListInWishlist)
		{
			WebElement image = row.findElement(By.xpath(".//td[1]//img"));
			WebElement name = row.findElement(By.xpath(".//td[2]//a"));
			WebElement model = row.findElement(By.xpath(".//td[3]"));
			WebElement stock = row.findElement(By.xpath(".//td[4]"));
			WebElement price = row.findElement(By.xpath(".//td[5]"));
			WebElement actionButtons = row.findElement(By.xpath(".//td[6]"));

			if(!(image.isDisplayed()) && name.isDisplayed() && model.isDisplayed() && stock.isDisplayed() && price.isDisplayed() && actionButtons.isDisplayed()) {
				allDetailsDisplayed = false;
				break;
			}
		}
		return allDetailsDisplayed;
	}

	public String getEmptyWishListMessage()
	{
		return emptyWishListmessage.getText().trim();
	}

	public void removeAllProductsOneByOne()
	{
		while(true)
		{
			if(removeButtons.isEmpty()) {
				System.out.println("No more products in wishlist!");
				break;
			}

			try {
				removeButtons.get(0).click();
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		}
	}

	public void clickRemoveButtonForFirstProductOnly()
	{
		for(WebElement first:removeButtons)
		{
			try {
				first.click();
				break;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void clickRemoveButton()
	{
		if(removeButtons.isEmpty())
		{
			System.out.println("No remove buttons are there!");
			return;
		}

		for(WebElement btns:removeButtons)
		{
			try {
				btns.click();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public boolean isProductListCorrect(int number)
	{
		return productsListInWishlist.size()==number;
	}

	public void clickRemoveBtnFromWishList()
	{

	}

	public boolean isProductNotDuplicated()
	{
		return productsListInWishlist.size()==1;
	}

	public void clickAddToCartButton()
	{
		waitUtils.waitForElementClickable(AddToCartButton, 10).click();
	}

	public void clickShoppingCartHeaderOption()
	{
		waitUtils.waitForElementClickable(shoppingCartHeaderOption, 10).click();
	}





}
