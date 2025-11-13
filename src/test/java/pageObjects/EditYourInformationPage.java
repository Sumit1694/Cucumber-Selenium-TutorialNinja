package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.GenericUtils;

public class EditYourInformationPage extends BasePage {

	public EditYourInformationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='My Account Information']") private WebElement EditYourInfoPageHeading;
	@FindBy(id = "input-firstname") private WebElement firstNameField;
	@FindBy(id = "input-lastname") private WebElement lastNameField;
	@FindBy(id = "input-email") private WebElement emailField;
	@FindBy(id = "input-telephone") private WebElement telephoneField;
	@FindBy(xpath = "//input[@value='Continue']") private WebElement continueBtn;
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]") private WebElement firstNameFieldValidationMsg;
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]") private WebElement lastNameFieldValidationMsg;
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]") private WebElement emailFieldValidationMsg;
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]") private WebElement telephoneValidationMsg;

	public String getCurrentUrlOfEditYourInformationPage()
	{
		return driver.getCurrentUrl();
	}

	public void clickBrowserBackButton()
	{
		driver.navigate().back();
	}

	public boolean verifyAllFieldsValidationMsgDisplayed()
	{
		try {
		waitUtils.waitForElementVisibility(firstNameFieldValidationMsg, 10);
		waitUtils.waitForElementVisibility(lastNameFieldValidationMsg, 10);
		waitUtils.waitForElementVisibility(emailFieldValidationMsg, 10);
		waitUtils.waitForElementVisibility(telephoneValidationMsg, 10);

		boolean isFirstNameMsgDisplayed = firstNameFieldValidationMsg.isDisplayed();
		boolean isLastNameMsgDisplayed = lastNameFieldValidationMsg.isDisplayed();
		boolean isEmailMsgDisplayed = emailFieldValidationMsg.isDisplayed();
		boolean isTelephoneMsgDisplayed = telephoneValidationMsg.isDisplayed();

		if(isFirstNameMsgDisplayed && isLastNameMsgDisplayed && isEmailMsgDisplayed && isTelephoneMsgDisplayed)
		{
			return true;
		}else {
			return false;
		}
		}catch(Exception e) {
			return false;
		}
	}

	public void makeAllFieldsEmpty()
	{
		try {
			waitUtils.waitForElementVisibility(firstNameField, 10);
			if(!firstNameField.getAttribute("value").trim().isEmpty()) {
				firstNameField.clear();
			}
			if(!lastNameField.getAttribute("value").trim().isEmpty()) {
				lastNameField.clear();
			}
			if(!emailField.getAttribute("value").trim().isEmpty()) {
				emailField.clear();
			}
			if(!telephoneField.getAttribute("value").trim().isEmpty()) {
				telephoneField.clear();
			}
		}catch(Exception e) {
			System.out.println("Failed to clear fields: " + e.getMessage());
		}
	}

	public boolean isTelephoneValidationMsgDisplayed() {
	    try {
	        waitUtils.waitForElementVisibility(telephoneValidationMsg, 10);
	        return telephoneValidationMsg.isDisplayed();
	    } catch (Exception e) {
	        System.out.println("Telephone validation message not displayed: " + e.getMessage());
	        return false;
	    }
	}

	public void makeTelephoneFieldEmpty()
	{
		try {
			waitUtils.waitForElementVisibility(telephoneField, 10);
			String currentValue = telephoneField.getAttribute("value").trim();

			if(!currentValue.isEmpty())
			{
				telephoneField.clear();
				System.out.println("Telephone field was not empty, it has cleared successfully!");
			}else {
				System.out.println("Telephone field is already empty!");
			}
		}catch(Exception e) {
			System.out.println("Failed to clear telephone field: " + e.getMessage());
		}
	}

	public boolean isTelephoneFieldValidatesCharacters() {
	    try {
	        waitUtils.waitForElementVisibility(telephoneField, 10);

	        // Step 1: Enter invalid (alphanumeric) telephone
	        String invalidTelephone = "123abc45";
	        telephoneField.clear();
	        telephoneField.sendKeys(invalidTelephone);

	        // Step 2: Click Continue or Submit button
	        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
	        continueBtn.click();

	        // Step 3: Wait a moment for possible validation or error
	        Thread.sleep(2000);

	        // Step 4: Check if the success message appears
	        List<WebElement> successMsgs = driver.findElements(By.xpath("//div[contains(@class,'alert-success')]"));

	        if (successMsgs.size() > 0) {
	            System.out.println(" BUG: Telephone field accepted invalid input and showed success message.");
	            return false; // invalid input was wrongly accepted
	        } else {
	            System.out.println("Validation prevented updating invalid telephone number.");
	            return true; // expected behavior if error is shown or no success message
	        }

	    } catch (Exception e) {
	        System.out.println("Error while validating telephone field: " + e.getMessage());
	        return false;
	    }
	}


	public boolean isInvalidEmailValidationMessageDisplayed() {
	    try {
	        waitUtils.waitForElementVisibility(emailField, 10);

	        emailField.clear();
	        emailField.sendKeys("rameshKolhapure@");
	        emailField.sendKeys(Keys.TAB); // shift focus to trigger validation

	        // Use JavaScript to get browser's built-in validation message
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", emailField);

	        System.out.println("Email validation message: " + validationMsg);

	        // Check if the message contains expected text (can vary by browser locale)
	        if (validationMsg.contains("Please enter a part following '@'")) {
	            System.out.println("Validation message is correctly displayed for invalid email input.");
	            return true;
	        } else {
	            System.out.println("Expected validation message not found. Actual: " + validationMsg);
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println("Error while checking email validation message: " + e.getMessage());
	        return false;
	    }
	}

	public void updateEmailWithWrongEmailFormatInField()
	{
		try {
			waitUtils.waitForElementVisibility(emailField, 10);
			String updatedEmail = "rameshsitapur@gmail.com";
			emailField.clear();
			emailField.sendKeys(updatedEmail);
			System.out.println("Email field is updated: ");
		}catch(Exception e) {
			System.out.println("Failed to update email field!");
		}
	}

	public void updateEmailField()
	{
		try {
			waitUtils.waitForElementVisibility(emailField, 10);
			String updatedEmail = GenericUtils.getRandomEmail();
			emailField.clear();
			emailField.sendKeys(updatedEmail);
			System.out.println("Email field is updated: ");
		}catch(Exception e) {
			System.out.println("Failed to update email field!");
		}
	}

	public void updateLastNameField()
	{
		try {
			waitUtils.waitForElementVisibility(firstNameField, 10);
			String currentLastName = lastNameField.getAttribute("value").trim();
			String updatedLastName = currentLastName + "Y";

			lastNameField.clear();
			lastNameField.sendKeys(updatedLastName);
			System.out.println("Last name field is updated from :" + currentLastName + "' to '" + updatedLastName + "'." );
		}catch(Exception e) {
			System.out.println("Failed to update first name dynamically! " + e.getMessage());
		}
	}

	public void clickContinueBtn()
	{
		waitUtils.waitForElementClickable(continueBtn, 10).click();
	}

	public void updateFirstNameField() {
		try {
			waitUtils.waitForElementVisibility(firstNameField, 10);

			String currentName = firstNameField.getAttribute("value").trim();

			String updatedName = currentName + "X";

			firstNameField.clear();
			firstNameField.sendKeys(updatedName);

			System.out.println("First name field updated dynamically from '" + currentName + "' to '" + updatedName + "'.");

		} catch (Exception e) {
			System.out.println("Failed to update first name dynamically: " + e.getMessage());
		}
	}

	public boolean verifyAllFieldsArePrefilledWithExistingData() {
		try {
			waitUtils.waitForElementVisibility(firstNameField, 10);
			waitUtils.waitForElementVisibility(lastNameField, 10);
			waitUtils.waitForElementVisibility(emailField, 10);
			waitUtils.waitForElementVisibility(telephoneField, 10);

			String actualFirstName = firstNameField.getAttribute("value").trim();
			String actualLastName = lastNameField.getAttribute("value").trim();
			String actualEmail = emailField.getAttribute("value").trim();
			String actualTelephone = telephoneField.getAttribute("value").trim();

			String expectedFirstName = "ramesh";
			String expectedLastName = "kolhapure";
			String expectedEmail = "rameshkolhapure@gmail.com";
			String expectedTelephone = "234566554";

			boolean match = actualFirstName.equalsIgnoreCase(expectedFirstName)
					&& actualLastName.equalsIgnoreCase(expectedLastName)
					&& actualEmail.equalsIgnoreCase(expectedEmail)
					&& actualTelephone.equalsIgnoreCase(expectedTelephone);

			if (match) {
				System.out.println("All fields are correctly prefilled with existing data.");
			} else {
				System.out.println("Prefilled data mismatch:"
						+ "\nExpected: " + expectedFirstName + ", " + expectedLastName + ", " + expectedEmail + ", " + expectedTelephone
						+ "\nActual: " + actualFirstName + ", " + actualLastName + ", " + actualEmail + ", " + actualTelephone);
			}

			return match;

		} catch (Exception e) {
			System.out.println("Exception while verifying prefilled data: " + e.getMessage());
			return false;
		}
	}


	public boolean areAllFieldVisibleInEditYourInformationPage() {
		try {
			waitUtils.waitForElementVisibility(firstNameField, 10);
			waitUtils.waitForElementVisibility(lastNameField, 10);
			waitUtils.waitForElementVisibility(emailField, 10);
			waitUtils.waitForElementVisibility(telephoneField, 10);
			return firstNameField.isDisplayed() && lastNameField.isDisplayed() && emailField.isDisplayed() && telephoneField.isDisplayed();
		} catch (Exception e) {
			System.out.println("One or more fields are not visible on Edit Your Information page: " + e.getMessage());
			return false;
		}
	}


	public boolean userIsOnEditYourInfoPage()
	{
		return waitUtils.waitForElementVisibility(EditYourInfoPageHeading, 10).isDisplayed();
	}



}
