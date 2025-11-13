package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductCategoryPage extends BasePage {

	public ProductCategoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']//h2") private WebElement DesktopsPageHeading;
	@FindBy(xpath = "//button[@id='list-view']") private WebElement listViewOption;
	@FindBy(xpath = "//button[@id='grid-view']") private WebElement gridViewOption;
	@FindBy(xpath = "//div[@class='row']//div[@class='product-layout product-list col-xs-12'][1]//button[3]") private WebElement CompareThisProductButtonListView;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[3]") private WebElement CompareThisProductButtonGridView;
	@FindBy(xpath = "//div[contains(@class,'tooltip') and contains(text(),'Compare this Product')]") private WebElement CompareThisProducthoverMsg;
	@FindBy(xpath = "//div[contains(text(),'Compare this Product')]") private WebElement compareThisProductHoverMsgGridView;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[3]") private WebElement compareThisProductOption;
	@FindBy(xpath = "//a[@id='compare-total']") private WebElement CompareProductLink;

	public void clickCompareProductLink()
	{
		waitUtils.waitForElementClickable(CompareProductLink, 10).click();
	}

	public void clickCompareThisProductionButtonOnGridView() {
		compareThisProductOption.click();
	}

	public String getCompareThisProductHoverMsgGridView()
	{
		return compareThisProductHoverMsgGridView.getText();
	}

	public void clickCompareThisProductButton()
	{
		CompareThisProductButtonListView.click();
	}

	public String getCompareThisProductHoverMsg()
	{
		return waitUtils.waitForElementVisibility(CompareThisProducthoverMsg, 10).getText();
	}

	public void hoverOnCompareThisProduct()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(CompareThisProductButtonListView).perform();
	}

	public void hoverOnCompareThisProductGridView()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(CompareThisProductButtonGridView).perform();
	}

	public void clickGridViewOption()
	{
		try {
			waitUtils.waitForElementVisibility(gridViewOption, 10);

			String classValue = gridViewOption.getAttribute("class");
			if(classValue != null && classValue.contains("active")) {
				System.out.println("skip!");
			}else {
				gridViewOption.click();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void clickListViewOption()
	{
		waitUtils.waitForElementClickable(listViewOption, 10).click();
	}

	public boolean isOnDesktopCategoryPage()
	{
		return waitUtils.waitForElementVisibility(DesktopsPageHeading, 10).isDisplayed();
	}



}
