package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GenericUtils;

public class AddAddressPage extends BasePage {

	public AddAddressPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']") private WebElement firstNameField;
	@FindBy(xpath = "//input[@id='input-lastname']") private WebElement lastNameField;
	@FindBy(xpath = "//input[@id='input-company']") private WebElement companyField;
	@FindBy(xpath = "//input[@id='input-address-1']") private WebElement address1Field;
	@FindBy(xpath = "//input[@id='input-address-2']") private WebElement address2Field;
	@FindBy(xpath = "//input[@id='input-city']") private WebElement cityField;
	@FindBy(xpath = "//input[@id='input-postcode']") private WebElement postCodeField;
	@FindBy(xpath = "//select[@id='input-country']") private WebElement countryDrpDwn;
	@FindBy(xpath = "//select[@id='input-zone']") private WebElement RegionStateDrpDwn;
	@FindBy(xpath = "//input[@value='1']") private WebElement DefaultAddressYesRadioBtn;
	@FindBy(xpath = "//input[@value='0']") private WebElement DefaultAddressNoRadioBtn;
	@FindBy(xpath = "//input[@value='Continue']") private WebElement continueBtn;
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div[contains(text(),'First Name must be between 1 and 32 characters!')]") private WebElement firstNameFieldValidationMsg;
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div[contains(text(),'Last Name must be between 1 and 32 characters!')]") private WebElement lastNameFieldValidationMsg;
	@FindBy(xpath = "//input[@id='input-address-1']/following-sibling::div[contains(text(),'Address must be between 3 and 128 characters!')]") private WebElement Address1FieldValidationMsg;
	@FindBy(xpath = "//input[@id='input-city']/following-sibling::div[contains(text(),'City must be between 2 and 128 characters!')]") private WebElement cityFieldValidationMsg;
	@FindBy(xpath = "//select[@id='input-country']/following-sibling::div[contains(text(),'Please select a country!')]") private WebElement countryFieldValidationMsg;
	@FindBy(xpath = "//select[@id='input-zone']/following-sibling::div[contains(text(),'Please select a region / state!')]") private WebElement regionValidationMsg;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement addressModifiedSuccessMsg;

	public boolean isCityFieldShowsExistingValueAfterBackAndComeBack() {
		try {
			waitUtils.waitForElementVisibility(cityField, 10);
			String currentCity = cityField.getAttribute("value");

			driver.navigate().back();
			waitUtils.waitForPageLoad(10);
			driver.navigate().forward();
			waitUtils.waitForPageLoad(10);
			waitUtils.waitForElementVisibility(cityField, 10);

			String updatedCity = cityField.getAttribute("value");

			if (currentCity.equals(updatedCity)) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error while validating city field persistence: " + e.getMessage());
			return false;
		}
		return false;
	}

	public boolean addressModifiedSuccessMsgIsDisplayed()
	{
		try {
			waitUtils.waitForElementVisibility(addressModifiedSuccessMsg, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Address modified success message is not displayed!" + e.getMessage());
			return false;
		}
	}

	public boolean modifyCityField()
	{
		try {
			waitUtils.waitForElementVisibility(cityField, 10);
			if(!cityField.getAttribute("value").isEmpty())
			{
				cityField.clear();
			}
			waitUtils.waitForElementVisibility(cityField, 10).sendKeys(GenericUtils.getRandomString(6));
			return true;
		}catch(Exception e) {
			System.out.println("City field is not getting filled! " + e.getMessage());
			return false;
		}
	}

	public boolean verifyAddressLimitExceedsValidationMessageIsDisplayed()
	{
		try {
			return waitUtils.waitForElementVisibility(Address1FieldValidationMsg, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("Address limit is accepted: " + e.getMessage());
			return false;
		}
	}

	public boolean fillAllAddressDetailsWithExceedingAddressLimit() {
		try {
			waitUtils.waitForElementVisibility(firstNameField, 10).sendKeys(GenericUtils.getRandomString(6));
			lastNameField.sendKeys(GenericUtils.getRandomString(6));
			companyField.sendKeys(GenericUtils.getRandomString(6));
			address1Field.sendKeys(102 + GenericUtils.getRandomString(143) + " " + GenericUtils.getRandomString(150) + " street");
			address2Field.sendKeys(105 + GenericUtils.getRandomString(150) + " " + GenericUtils.getRandomString(143) + " Avenue");
			cityField.sendKeys(GenericUtils.getRandomString(6));
			postCodeField.sendKeys(GenericUtils.getRandomNumber(6));
			// --- Select Country ---
			waitUtils.waitForElementVisibility(countryDrpDwn, 10);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].value = '99'; arguments[0].dispatchEvent(new Event('change'))", // 99 is India’s value usually
					countryDrpDwn
					);

			// Wait for region dropdown to get populated
			waitUtils.waitForElementClickable(RegionStateDrpDwn, 10);
			Thread.sleep(2000); // give time for AJAX load

			// Click region dropdown via JS
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", RegionStateDrpDwn);

			// Wait for options to load under region dropdown
			List<WebElement> regionOptions = driver.findElements(By.xpath("//select[@id='input-zone']/option"));
			for (WebElement option : regionOptions) {
				if (option.getText().trim().equalsIgnoreCase("Maharashtra")) { // or any valid state
					((JavascriptExecutor) driver).executeScript("arguments[0].selected = true;", option);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].dispatchEvent(new Event('change'))", RegionStateDrpDwn
							);
					break;
				}
			}

			if (!DefaultAddressNoRadioBtn.isSelected()) {
				DefaultAddressNoRadioBtn.click();
			}
			return true;
		} catch (Exception e) {
			System.out.println("Error while filling address details: " + e.getMessage());
			return false;
		}
	}

	public boolean fillAllAddressDetailsWithInvalidPostCodeField() {
		try {
			waitUtils.waitForElementVisibility(firstNameField, 10).sendKeys(GenericUtils.getRandomString(6));
			lastNameField.sendKeys(GenericUtils.getRandomString(6));
			companyField.sendKeys(GenericUtils.getRandomString(6));
			address1Field.sendKeys(102 + GenericUtils.getRandomString(6) + " " + GenericUtils.getRandomString(6) + " street");
			address2Field.sendKeys(105 + GenericUtils.getRandomString(6) + " " + GenericUtils.getRandomString(6) + " Avenue");
			cityField.sendKeys(GenericUtils.getRandomString(6));
			postCodeField.sendKeys(GenericUtils.getRandomString(6)); // Invalid postcode
			// --- Select Country ---
			waitUtils.waitForElementVisibility(countryDrpDwn, 10);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].value = '99'; arguments[0].dispatchEvent(new Event('change'))", // 99 is India’s value usually
					countryDrpDwn
					);

			// Wait for region dropdown to get populated
			waitUtils.waitForElementClickable(RegionStateDrpDwn, 10);
			Thread.sleep(2000); // give time for AJAX load

			// Click region dropdown via JS
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", RegionStateDrpDwn);

			// Wait for options to load under region dropdown
			List<WebElement> regionOptions = driver.findElements(By.xpath("//select[@id='input-zone']/option"));
			for (WebElement option : regionOptions) {
				if (option.getText().trim().equalsIgnoreCase("Maharashtra")) { // or any valid state
					((JavascriptExecutor) driver).executeScript("arguments[0].selected = true;", option);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].dispatchEvent(new Event('change'))", RegionStateDrpDwn
							);
					break;
				}
			}

			if (!DefaultAddressNoRadioBtn.isSelected()) {
				DefaultAddressNoRadioBtn.click();
			}
			return true;
		} catch (Exception e) {
			System.out.println("Error while filling address details: " + e.getMessage());
			return false;
		}
	}


	public boolean verifyAllFieldsValidationMsgs() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement countryElement = driver.findElement(By.id("input-country"));
			Select countrySelect = new Select(countryElement);
			String selectedCountry = countrySelect.getFirstSelectedOption().getText().trim();
			if (!selectedCountry.equalsIgnoreCase("--- Please Select ---")) {
				countrySelect.selectByVisibleText("--- Please Select ---");
				try {
					WebElement regionBefore = driver.findElement(By.id("input-zone"));
					wait.until(ExpectedConditions.stalenessOf(regionBefore));
				} catch (TimeoutException te) {
					System.out.println("Region dropdown not reloaded (country default selected). Continuing...");
				}
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-zone")));
			WebElement regionElement = driver.findElement(By.id("input-zone"));
			Select regionSelect = new Select(regionElement);
			String selectedRegion = regionSelect.getFirstSelectedOption().getText().trim();
			if (!selectedRegion.equalsIgnoreCase("--- Please Select ---")) {
				regionSelect.selectByVisibleText("--- Please Select ---");
			}
			waitUtils.waitForElementClickable(continueBtn, 10).click();
			waitUtils.waitForElementVisibility(firstNameFieldValidationMsg, 10);
			waitUtils.waitForElementVisibility(lastNameFieldValidationMsg, 10);
			waitUtils.waitForElementVisibility(Address1FieldValidationMsg, 10);
			waitUtils.waitForElementVisibility(cityFieldValidationMsg, 10);
			waitUtils.waitForElementVisibility(countryFieldValidationMsg, 10);
			waitUtils.waitForElementVisibility(regionValidationMsg, 10);
			boolean allMsgsDisplayed =
					firstNameFieldValidationMsg.isDisplayed() &&
					lastNameFieldValidationMsg.isDisplayed() &&
					Address1FieldValidationMsg.isDisplayed() &&
					cityFieldValidationMsg.isDisplayed() &&
					countryFieldValidationMsg.isDisplayed() &&
					regionValidationMsg.isDisplayed();
			return allMsgsDisplayed;
		} catch (StaleElementReferenceException se) {
			System.out.println("Caught stale element; retrying once...");
			return verifyAllFieldsValidationMsgs();
		} catch (Exception e) {
			System.out.println("All fields validation messages are not displaying correctly! " + e.getMessage());
			return false;
		}
	}


	public void clickContinueBtn()
	{
		try {
			waitUtils.waitForElementClickable(continueBtn, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(continueBtn).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("Continue btn is not enabled to click!" + e.getMessage());
		}
	}

	public boolean fillAllAddressDetails() {
		try {
			waitUtils.waitForElementVisibility(firstNameField, 10).sendKeys(GenericUtils.getRandomString(6));
			lastNameField.sendKeys(GenericUtils.getRandomString(6));
			companyField.sendKeys(GenericUtils.getRandomString(6));
			address1Field.sendKeys("102 " + GenericUtils.getRandomString(6) + " Street");
			address2Field.sendKeys("105 " + GenericUtils.getRandomString(6) + " Avenue");
			cityField.sendKeys(GenericUtils.getRandomString(6));
			postCodeField.sendKeys(GenericUtils.getRandomNumber(6));

			// --- Select Country ---
			waitUtils.waitForElementVisibility(countryDrpDwn, 10);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].value = '99'; arguments[0].dispatchEvent(new Event('change'))", // 99 is India’s value usually
					countryDrpDwn
					);

			// Wait for region dropdown to get populated
			waitUtils.waitForElementClickable(RegionStateDrpDwn, 10);
			Thread.sleep(2000); // give time for AJAX load

			// Click region dropdown via JS
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", RegionStateDrpDwn);

			// Wait for options to load under region dropdown
			List<WebElement> regionOptions = driver.findElements(By.xpath("//select[@id='input-zone']/option"));
			for (WebElement option : regionOptions) {
				if (option.getText().trim().equalsIgnoreCase("Maharashtra")) { // or any valid state
					((JavascriptExecutor) driver).executeScript("arguments[0].selected = true;", option);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].dispatchEvent(new Event('change'))", RegionStateDrpDwn
							);
					break;
				}
			}

			return true;
		} catch (Exception e) {
			System.out.println("Error while filling address details: " + e.getMessage());
			return false;
		}
	}

}





