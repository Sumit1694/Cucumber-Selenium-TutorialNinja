package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OrderSuccessPage extends BasePage {

	public OrderSuccessPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//li[normalize-space()='Success']") private WebElement successPageBreadCrumb;
	@FindBy(xpath = "//a[text()='store owner']") private WebElement storeOwnerLink;

	public boolean clickStoreOwnerLink()
	{
		try {
			waitUtils.waitForElementVisibility(successPageBreadCrumb, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(storeOwnerLink).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("Store owner link is not clickable! " + e.getMessage());
			return false;
		}
	}



}
