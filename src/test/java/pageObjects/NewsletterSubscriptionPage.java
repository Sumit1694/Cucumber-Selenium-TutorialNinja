package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NewsletterSubscriptionPage extends BasePage {

	public NewsletterSubscriptionPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@value='1']") private WebElement yesRadioButton;
	@FindBy(xpath="//input[@value='0']") private WebElement noRadioButton;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement newsLetterpageBreadCrumb;
	@FindBy(xpath="//a[text()='Back']") private WebElement backButton;
	@FindBy(xpath="//input[@value='Continue']") private WebElement continueBtn;

	public boolean verifyNewsLetterPageData()
	{
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/newsletter";
		String expectedHeading = "Newsletter Subscription";
		String expectedTitle = "Newsletter Subscription";

		String actualURL = driver.getCurrentUrl();
		String actualHeading = waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//h1[text()='Newsletter Subscription']")), 10).getText();
		String actualTitle = driver.getTitle();

		return expectedURL.equals(actualURL) && expectedHeading.equals(actualHeading) && expectedTitle.equals(actualTitle);
	}

	public boolean verifyBreadCrumbIsDisplayedAndWorking()
	{
		try {
		waitUtils.waitForElementVisibility(newsLetterpageBreadCrumb, 10).isDisplayed();
		String currentUrl = driver.getCurrentUrl();
		Actions actions = new Actions(driver);
		actions.moveToElement(newsLetterpageBreadCrumb).pause(Duration.ofMillis(500)).click().perform();
		String AfterRefreshUrl = driver.getCurrentUrl();
		return currentUrl.equals(AfterRefreshUrl);
		}catch(Exception e) {
			System.out.println("breadcrumb is not working properly! " + e.getMessage());
			return false;
		}
	}

	public boolean userIsOnSubscriptionPageAndNoOptionIsSelectedByDefault()
	{
		try {
		waitUtils.waitForElementVisibility(newsLetterpageBreadCrumb, 10).isDisplayed();
		if(noRadioButton.isSelected())
		{
			return true;
		}else {
			return false;
		}
		}catch(Exception e) {
			System.out.println("radion button is not selected as what is selected at the time of registration!");
			return false;
		}
	}

	public boolean userIsOnSubscriptionPageAndYesOptionIsSelectedByDefault()
	{
		try {
		waitUtils.waitForElementVisibility(newsLetterpageBreadCrumb, 10).isDisplayed();
		if(yesRadioButton.isSelected())
		{
			return true;
		}else {
			return false;
		}
		}catch(Exception e) {
			System.out.println("radion button is not selected as what is selected at the time of registration!");
			return false;
		}
	}

	public void clickContinueBtn()
	{
		waitUtils.waitForElementClickable(continueBtn, 10).click();
	}

	public boolean isUpdatedRadioButtonDisplayedAsSelected(String expectedSelection) {
	    try {
	        waitUtils.waitForElementVisibility(newsLetterpageBreadCrumb, 10);

	        expectedSelection = expectedSelection.trim().toLowerCase();

	        if (expectedSelection.equals("yes") && yesRadioButton.isSelected()) {
	            System.out.println("'Yes' radio button is correctly displayed as selected!");
	            return true;
	        } else if (expectedSelection.equals("no") && noRadioButton.isSelected()) {
	            System.out.println("'No' radio button is correctly displayed as selected!");
	            return true;
	        } else {
	            System.out.println("Expected '" + expectedSelection + "' to be selected, but it is not.");
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println("Unable to verify updated radio button selection! " + e.getMessage());
	        return false;
	    }
	}

	public boolean selectYesOrNoRadioButton() {
	    try {
	        waitUtils.waitForElementVisibility(newsLetterpageBreadCrumb, 10);

	        if (noRadioButton.isSelected()) {
	            waitUtils.waitForElementClickable(yesRadioButton, 10).click();
	            System.out.println("Switched to 'Yes' radio button.");
	        } else if (yesRadioButton.isSelected()) {
	            waitUtils.waitForElementClickable(noRadioButton, 10).click();
	            System.out.println("Switched to 'No' radio button.");
	        } else {
	            waitUtils.waitForElementClickable(yesRadioButton, 10).click();
	            System.out.println("No option selected — selected 'Yes' by default.");
	        }
	        return true;

	    } catch (Exception e) {
	        System.out.println("Radio button toggle failed! Reason: " + e.getMessage());
	        return false;
	    }
	}


public void clickBakcButtonPresentOnPage()
{
	waitUtils.waitForElementClickable(backButton, 10).click();
}

public boolean isNewsLetterPageBreadCrumbIsDisplayed()
{
	try {
		return waitUtils.waitForElementVisibility(newsLetterpageBreadCrumb, 10).isDisplayed();
	}catch(Exception e) {
		System.out.println("User is not on newsLetter page breadcrumb!" + e.getMessage());
		return false;
	}
}

public boolean isYesRadioButtonSelected()
{
	return yesRadioButton.isSelected();
}

public boolean isNoRadioButtonSelected()
{
	return noRadioButton.isSelected();
}

public void clickYesRadioButton()
{
	if(!yesRadioButton.isSelected())
	{
		yesRadioButton.click();
	}
}

public void clickNoRadioButton()
{
	if(!noRadioButton.isSelected())
	{
		noRadioButton.click();
	}
}



}
