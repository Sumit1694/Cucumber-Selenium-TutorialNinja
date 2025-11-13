package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utilities.GenericUtils;

public class AffiliateAccountPage extends BasePage {

	public AffiliateAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement affiliateBreadcrumb;
	@FindBy(xpath = "//div[contains(@class,'alert') and contains(text(),'Warning: You must agree to the About Us!')]") private WebElement alertMsg;
	@FindBy(xpath = "//input[@value='Continue']") private WebElement continueBtn;
	@FindBy(xpath = "//input[@id='input-company']") private WebElement companyField;
	@FindBy(xpath = "//input[@id='input-website']") private WebElement webSiteField;
	@FindBy(xpath = "//input[@id='input-tax']") private WebElement taxField;
	@FindBy(xpath = "//input[@value='cheque']") private WebElement chequePaymentMethod;
	@FindBy(xpath = "//input[@value='paypal']") private WebElement paypalPaymentMethod;
	@FindBy(xpath = "//input[@value='bank']") private WebElement BankTransferPaymentMethod;
	@FindBy(xpath = "//input[@id='input-cheque']") private WebElement chequePayeeName;
	@FindBy(xpath = "//input[@name='agree']") private WebElement agreeCheckBox;
	@FindBy(xpath = "//div[contains(@class,'alert') and contains(text(),'Warning: You must agree to the About Us!')]") private WebElement chckBoxWarning;
	@FindBy(xpath = "//input[@id='input-bank-name']") private WebElement bankNameField;
	@FindBy(xpath = "//input[@id='input-bank-branch-number']") private WebElement ABABSBNumberField;
	@FindBy(xpath = "//input[@id='input-bank-swift-code']") private WebElement swiftCodeField;
	@FindBy(xpath = "//input[@id='input-bank-account-name']") private WebElement AccountNameField;
	@FindBy(xpath = "//input[@id='input-bank-account-number']") private WebElement accountNumberField;
	@FindBy(xpath = "//div[text()='Account Name required!']") private WebElement accountNameWarningMessage;
	@FindBy(xpath = "//div[text()='Account Number required!']") private WebElement accountNumberWarningMessage;
	@FindBy(xpath = "//input[@name='paypal']//following-sibling::div") private WebElement invalidPaypalEmailAddressWarningMsg;
	@FindBy(xpath = "//a[normalize-space()='Custom Affiliate Tracking Code']") private WebElement customAffiliateTrackingcodeLink;

	public boolean verifyCopyingCustomAffiliateTrackingCode()
	{
		try {
		waitUtils.waitForElementVisibility(customAffiliateTrackingcodeLink, 10);
        Actions actions = new Actions(driver);
        actions.moveToElement(customAffiliateTrackingcodeLink).pause(Duration.ofMillis(500)).click().perform();
        waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//ul[@class='breadcrumb']//li[last()]")), 10).isDisplayed();
        Thread.sleep(2000);
        WebElement yourTrackingCodeTextArea = waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//textarea[@id='input-code']")), 10);
        String trackingCode = yourTrackingCodeTextArea.getAttribute("value");
        if(trackingCode !=null && !trackingCode.trim().isEmpty())
        {
        	yourTrackingCodeTextArea.click();
        	yourTrackingCodeTextArea.sendKeys(Keys.CONTROL + "a");
        	yourTrackingCodeTextArea.sendKeys(Keys.CONTROL + "c");
        	System.out.println("Tracking code copied successfully: " + trackingCode);
        	return true;
        }else {
        	System.out.println("Tracking field is empty!");
        	return false;
        }
		}catch(Exception e) {
			System.out.println("Tracking code copying is not possible!" + e.getMessage());
			return false;
		}
	}

	public boolean fillAllTheFieldsWherePaymentMethodPaypalWithInvalidEmailID()
	{
		try {
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10).sendKeys("TechZone");
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TX1001");
			if(!paypalPaymentMethod.isSelected())
			{
				waitUtils.waitForElementVisibility(paypalPaymentMethod, 10).click();
			}
			WebElement paypalEmailField = waitUtils.waitForElementVisibility(
					driver.findElement(By.id("input-paypal")), 10);
			paypalEmailField.clear();
			paypalEmailField.sendKeys("test@com");
			agreeCheckBox.click();
			Thread.sleep(1000);
			continueBtn.click();
			waitUtils.waitForElementVisibility(invalidPaypalEmailAddressWarningMsg, 10);
			return invalidPaypalEmailAddressWarningMsg.isDisplayed();
		}catch(Exception e) {
			System.out.println("invalid paypal account id is not showed warning message!" +e.getMessage());
			return false;
		}
	}

	public boolean fillAllTheFieldsWherePaymentMethodPaypalWithValidEmailID()
	{
		try {
			By successMsgLocator = By.xpath("//div[contains(text(),'Success')]");
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10).sendKeys("TechZone");
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TX1001");
			if(!paypalPaymentMethod.isSelected())
			{
				waitUtils.waitForElementVisibility(paypalPaymentMethod, 10).click();
			}
			WebElement paypalEmailField = waitUtils.waitForElementVisibility(
					driver.findElement(By.id("input-paypal")), 10);
			paypalEmailField.clear();
			paypalEmailField.sendKeys(GenericUtils.getRandomEmail());
			agreeCheckBox.click();
			Thread.sleep(1000);
			continueBtn.click();
			waitUtils.waitForElementVisibility(driver.findElement(successMsgLocator), 10);
			System.out.println("Successfully switched to PayPal method!");
			return true;
		}catch(Exception e) {
			System.out.println("Affiliate fields are not visible to be filled! " +e.getMessage());
			return false;
		}
	}

	public boolean fillAllTheFieldsWherePaymentMethodBankFieldsShouldBeEmpty()
	{
		try {
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10).sendKeys("TechZone");
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TX1001");
			if(!BankTransferPaymentMethod.isSelected())
			{
				waitUtils.waitForElementVisibility(BankTransferPaymentMethod, 10).click();
			}

			waitUtils.waitForElementVisibility(bankNameField, 10).clear();
			bankNameField.sendKeys("ICICI Bank");
			ABABSBNumberField.clear();
			ABABSBNumberField.sendKeys("2435753");
			swiftCodeField.clear();
			swiftCodeField.sendKeys("DWED6783954");
			AccountNameField.clear();
			accountNumberField.clear();

			agreeCheckBox.click();
			Thread.sleep(1000);
			continueBtn.click();
			waitUtils.waitForElementVisibility(accountNameWarningMessage, 10).isDisplayed();
			waitUtils.waitForElementVisibility(accountNumberWarningMessage, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Affiliate fields are not visible to be filled! " +e.getMessage());
			return false;
		}
	}

	public boolean switchBetweenPaymentMethods() {
		try {
			By editAffiliateLinkLocator = By.xpath("//a[text()='Edit your affiliate information']");
			By successMsgLocator = By.xpath("//div[contains(text(),'Success')]");

			// --- Step 1: Open Edit Affiliate Page ---
			waitUtils.waitForElementClickable(driver.findElement(editAffiliateLinkLocator), 10).click();

			// --- CASE 1: Cheque → PayPal ---
			if (chequePaymentMethod.isSelected()) {
				System.out.println("Currently selected: Cheque. Switching to PayPal...");

				waitUtils.waitForElementClickable(paypalPaymentMethod, 10).click();
				WebElement paypalEmailField = waitUtils.waitForElementVisibility(
						driver.findElement(By.id("input-paypal")), 10);
				paypalEmailField.clear();
				paypalEmailField.sendKeys(GenericUtils.getRandomEmail());

				continueBtn.click();
				waitUtils.waitForElementVisibility(driver.findElement(successMsgLocator), 10);
				System.out.println("Successfully switched to PayPal method!");

				// Re-fetch element to avoid stale reference
				waitUtils.waitForElementClickable(driver.findElement(editAffiliateLinkLocator), 10).click();
			}

			// --- CASE 2: PayPal → Bank Transfer ---
			if (paypalPaymentMethod.isSelected()) {
				System.out.println("Currently selected: PayPal. Switching to Bank Transfer...");

				waitUtils.waitForElementClickable(BankTransferPaymentMethod, 10).click();

				waitUtils.waitForElementVisibility(bankNameField, 10).clear();
				bankNameField.sendKeys("ICICI Bank");

				ABABSBNumberField.clear();
				ABABSBNumberField.sendKeys("2435753");

				swiftCodeField.clear();
				swiftCodeField.sendKeys("DWED6783954");

				AccountNameField.clear();
				AccountNameField.sendKeys("Axis Bank");

				accountNumberField.clear();
				accountNumberField.sendKeys("2435675433");

				continueBtn.click();
				waitUtils.waitForElementVisibility(driver.findElement(successMsgLocator), 10);
				System.out.println("Successfully switched to Bank Transfer method!");

				// Re-fetch element again after DOM reload
				waitUtils.waitForElementClickable(driver.findElement(editAffiliateLinkLocator), 10).click();
			}

			// --- CASE 3: Bank Transfer → Cheque ---
			if (BankTransferPaymentMethod.isSelected()) {
				System.out.println("Currently selected: Bank Transfer. Switching to Cheque...");

				waitUtils.waitForElementClickable(chequePaymentMethod, 10).click();

				waitUtils.waitForElementVisibility(chequePayeeName, 10).clear();
				chequePayeeName.sendKeys("Sundrlal Mehta");

				continueBtn.click();
				waitUtils.waitForElementVisibility(driver.findElement(successMsgLocator), 10);
				System.out.println("Successfully switched to Cheque method!");

				return true;
			}

		} catch (StaleElementReferenceException se) {
			System.out.println("Caught stale element, retrying...");
			// Re-run method once in case of transient DOM reload
			return switchBetweenPaymentMethods();
		} catch (Exception e) {
			System.out.println("Affiliate information update failed! " + e.getMessage());
			return false;
		}
		return false;
	}



	public boolean EditInformationInAffiliateAccountPage()
	{
		try {
			waitUtils.waitForElementClickable(driver.findElement(By.xpath("//a[text()='Edit your affiliate information']")), 10).click();
			if(chequePaymentMethod.isSelected())
			{
				waitUtils.waitForElementClickable(paypalPaymentMethod, 10).click();
			}
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//input[@id='input-paypal']")), 10).sendKeys(GenericUtils.getRandomEmail1());
			Thread.sleep(1000);
			continueBtn.click();
			return driver.findElement(By.xpath("//div[contains(text(),'Success')]")).isDisplayed();
		}catch(Exception e) {
			System.out.println("Affiliate fields are not visible to be filled! " + e.getMessage());
			return false;
		}
	}

	public boolean fillAllTheFieldsInAffilateAccountPage()
	{
		try {
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10).sendKeys("TechZone");
			waitUtils.waitForElementVisibility(webSiteField, 10).sendKeys("https://morganStanley.com");
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TX1001");
			if(!chequePaymentMethod.isSelected())
			{
				waitUtils.waitForElementVisibility(chequePaymentMethod, 10).click();
			}
			chequePayeeName.sendKeys("Sundrlal mehta.");
			agreeCheckBox.click();
			Thread.sleep(1000);
			continueBtn.click();
			return driver.findElement(By.xpath("//div[contains(text(),'Success')]")).isDisplayed();
		}catch(Exception e) {
			System.out.println("Affiliate fields are not visible to be filled! " +e.getMessage());
			return false;
		}
	}

	public boolean verifyCompanyFieldIsAcceptingMoreThanFiftyChars() {
		try {
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10)
			.sendKeys(GenericUtils.getRandomString(55));
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TAX123");

			if (!chequePaymentMethod.isSelected()) {
				waitUtils.waitForElementVisibility(chequePaymentMethod, 10).click();
			}

			chequePayeeName.sendKeys("Sundarlal Mehta");
			agreeCheckBox.click();

			// click Continue
			waitUtils.waitForElementClickable(continueBtn, 10).click();
			waitUtils.waitForPageLoad(10);

			// Check for success message
			driver.findElement(By.xpath("//div[contains(text(),'Success')]")).isDisplayed();
			return false;
		} catch (Exception e) {
			System.out.println("Error verifying company name length, that it is accepting more than 50 characters! " + e.getMessage());
			return true;
		}
	}

	public boolean verifyCompanyFieldIsAcceptingFiftyChars() {
		try {
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10)
			.sendKeys(GenericUtils.getRandomString(50));
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TAX123");

			if (!chequePaymentMethod.isSelected()) {
				waitUtils.waitForElementVisibility(chequePaymentMethod, 10).click();
			}

			chequePayeeName.sendKeys("Sundarlal Mehta");
			agreeCheckBox.click();

			// click Continue
			waitUtils.waitForElementClickable(continueBtn, 10).click();
			waitUtils.waitForPageLoad(10);

			// Check for success message
			return driver.findElement(By.xpath("//div[contains(text(),'Success')]")).isDisplayed();

		} catch (Exception e) {
			System.out.println("Error verifying company name length: " + e.getMessage());
			return false;
		}
	}


	public boolean isCheckBoxWarningMessageDisplayed()
	{
		try {
			return waitUtils.waitForElementVisibility(chckBoxWarning, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("CheckBox warning message is not displayed!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyTaxIdFieldDoesNotAcceptSpecialChars()
	{
		try {
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10).sendKeys("TechZone");
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TAX@123!");
			if(!chequePaymentMethod.isSelected())
			{
				waitUtils.waitForElementVisibility(chequePaymentMethod, 10).click();
			}
			chequePayeeName.sendKeys("Sundrlal mehta.");
			agreeCheckBox.click();
			Thread.sleep(1000);
			continueBtn.click();
			Thread.sleep(1000);
			Assert.assertFalse(driver.findElement(By.xpath("//div[contains(text(),'Success')]")).isDisplayed(), "Tax field is accepting special characters!");
			return true;
		}catch(Exception e) {
			System.out.println("Affiliate fields are not visible to be filled! " +e.getMessage());
			return false;
		}
	}

	public boolean fillAllTheFieldsExceptTearmsAndConditions()
	{
		try {
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10).sendKeys("TechZone");
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TX1001");
			if(!chequePaymentMethod.isSelected())
			{
				waitUtils.waitForElementVisibility(chequePaymentMethod, 10).click();
			}
			chequePayeeName.sendKeys("Sundrlal mehta.");
			Thread.sleep(1000);
			continueBtn.click();
			return true;
		}catch(Exception e) {
			System.out.println("Affiliate fields are not visible to be filled! " +e.getMessage());
			return false;
		}
	}

	public boolean fillAllTheFields()
	{
		try {
			waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10);
			waitUtils.waitForElementClickable(companyField, 10).sendKeys("TechZone");
			waitUtils.waitForElementVisibility(taxField, 10).sendKeys("TX1001");
			if(!chequePaymentMethod.isSelected())
			{
				waitUtils.waitForElementVisibility(chequePaymentMethod, 10).click();
			}
			chequePayeeName.sendKeys("Sundrlal mehta.");
			agreeCheckBox.click();
			Thread.sleep(1000);
			continueBtn.click();
			return true;
		}catch(Exception e) {
			System.out.println("Affiliate fields are not visible to be filled! " +e.getMessage());
			return false;
		}
	}

	public void clickContinueBtn()
	{
		waitUtils.waitForElementClickable(continueBtn, 10).click();
	}

	public boolean isAlertMsgDisplayed()
	{
		return waitUtils.waitForElementVisibility(alertMsg, 10).isDisplayed();
	}

	public boolean isAffiliateBreadcrumbIsDisplayed()
	{
		return waitUtils.waitForElementVisibility(affiliateBreadcrumb, 10).isDisplayed();
	}



}
