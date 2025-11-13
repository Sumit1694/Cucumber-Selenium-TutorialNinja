package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PurchaseGiftCertificatePage extends BasePage {

	public PurchaseGiftCertificatePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']//p[contains(text(),'Thank you for purchasing a gift certificate!')]") private WebElement successMsgGiftCertificate;
	@FindBy(xpath = "//a[text()='Continue']") private WebElement continueBtn;

	public void clickContinueBtn()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(continueBtn).pause(Duration.ofMillis(500)).click().perform();
	}

	public boolean verifyGiftCeritificateSuccessMsg()
	{
		try {
			return waitUtils.waitForElementVisibility(successMsgGiftCertificate, 10).isDisplayed();
		}catch(Exception e) {
			 System.out.println("gift certificate purchase success message is not displayed!" + e.getMessage());
			 return false;
		}
	}



}
