package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInformationPage extends BasePage {

	public OrderInformationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement orderInformationBreadCrumb;

    public void clickBrowserBackButton()
    {
    	try {
            waitUtils.waitForElementVisibility(orderInformationBreadCrumb, 10);
            driver.navigate().back();
    	}catch(Exception e) {
            System.out.println("browser back button is not working!" + e.getMessage());
    	}
    }

	public boolean isOrderInformationBreadCrumbIsDisplayed()
	{
		try {
			return waitUtils.waitForElementVisibility(orderInformationBreadCrumb, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("Order information breadcrumb is not displayed! " + e.getMessage());
			return false;
		}
	}



}
