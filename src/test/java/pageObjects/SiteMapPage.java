package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SiteMapPage extends BasePage {

	public SiteMapPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Search']") private WebElement searchLink;
	@FindBy(xpath = "//div[@class='col-sm-6']//a[normalize-space()='My Account']") private WebElement myAccountLink;
	@FindBy(xpath = "//a[normalize-space()='Password']") private WebElement passwordLink;

	public void clickPasswordLink()
	{
		try {
			waitUtils.waitForElementVisibility(passwordLink, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(passwordLink).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("password link not available to click!" + e.getMessage());
		}
	}

	public void clickMyAccountLink()
	{
		waitUtils.waitForElementClickable(myAccountLink, 10).click();
	}

	public void clickSearchLink()
	{
		searchLink.click();
	}

}
