package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//div[@id='content']//h1") private WebElement AccountLogoutPageHeading;
	@FindBy(xpath="//a[normalize-space()='Continue']") private WebElement ContinueBtn;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement logoutBreadcrumb;

	public String getLogoutPageHeading()
	{
		return AccountLogoutPageHeading.getText();
	}

	public String getLogoutPageURL()
	{
		return driver.getCurrentUrl();
	}

	public String getLogoutPageTitle()
	{
		return driver.getTitle();
	}

	public boolean isLastBreadCrumbDisplayed()
	{
		try {
			return logoutBreadcrumb.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean isAccountLogoutConfirmationPageDisplayed()
	{
		return AccountLogoutPageHeading.isDisplayed();
	}

	public void clickContinuebtn()
	{
		ContinueBtn.click();
	}





}
