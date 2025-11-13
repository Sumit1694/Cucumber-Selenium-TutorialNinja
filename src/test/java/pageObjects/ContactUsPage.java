package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.GenericUtils;
import utilities.TestData;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[normalize-space()='Contact Us']") private WebElement breadCrumbOfContactUsPage;
	@FindBy(xpath = "//h3[text()='Our Location']") private WebElement ourLocationHeading;
	@FindBy(xpath = "//body//div[@id='information-contact']//div[@class='row']//div[@class='row']//div[1]") private WebElement storeDetails;
	@FindBy(xpath = "//body//div[@id='information-contact']//div[@class='row']//div[@class='row']//div[2]") private WebElement telephoneDetails;
	@FindBy(xpath = "//legend[text()='Contact Form']") private WebElement contactFormHeading;
	@FindBy(xpath = "//input[@id='input-name']") private WebElement yourNameField;
	@FindBy(xpath = "//input[@id='input-email']") private WebElement emailField;
	@FindBy(xpath = "//textarea[@id='input-enquiry']") private WebElement enquiryField;
	@FindBy(xpath = "//input[@value='Submit']") private WebElement submitBtn;
	@FindBy(xpath = "//div[contains(@class,'alert') and contains(normalize-space(),'Success')]") private WebElement successMsg;
	@FindBy(xpath = "//a[text()='Continue']") private WebElement continueBtn;
	@FindBy(xpath = "//div[contains(@class,'danger') and contains(text(),'Name must be between 3 and 32 characters!')]") private WebElement YourNameWarningMsg;
	@FindBy(xpath = "//div[contains(@class,'danger') and contains(text(),'E-Mail Address does not appear to be valid!')]") private WebElement emailWarningMsg;
	@FindBy(xpath = "//div[contains(@class,'danger') and contains(text(),'Enquiry must be between 10 and 3000 characters!')]") private WebElement enquiryWarningMsg;
	@FindBy(xpath = "//h1[text()='Contact Us']") private WebElement contactUsPageHeading;

	public boolean validateContactUsPageDetails()
	{
		try {
			String expectedTitle = "Contact Us";
			String expectedHeading = "Contact Us";
			String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=information/contact";

			String actualTitle = driver.getTitle();
			String actualHeading = contactUsPageHeading.getText();
			String actualUrl = driver.getCurrentUrl();

			return expectedTitle.equals(actualTitle) && expectedHeading.equals(actualHeading) && expectedUrl.equals(actualUrl);
		}catch(Exception e) {
			System.out.println("Contact us page details are not matching!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyContactUsFormSubmittedSuccessMsg()
	{
		try {
			waitUtils.waitForElementVisibility(successMsg, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Contact us form submission success message is not displayed! " + e.getMessage());
			return false;
		}
	}

	public boolean EnterEnquiryTextInEnquiryField()
	{
		try {
			waitUtils.waitForElementVisibility(breadCrumbOfContactUsPage, 10);
			enquiryField.sendKeys(GenericUtils.getRandomString(30));
			return true;
		}catch(Exception e) {
			System.out.println("User is not able to enter text into enquiry text field! " + e.getMessage());
			return false;
		}
	}

	public boolean verifyLoggedInNameAndEmailPresentInContactUsPage()
	{
		try {
			waitUtils.waitForElementVisibility(breadCrumbOfContactUsPage, 10).isDisplayed();
			String yourName = yourNameField.getAttribute("value");
			String email = emailField.getAttribute("value");
			return yourName.equals(TestData.createdFirstName) && email.equals(TestData.createdEmail);
		}catch(Exception e) {
			System.out.println("Name and email are not matching under contactUs field!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyInvalidEmailInputWarningMessages() {
	    try {
	        String[] invalidEmails = {"Sumit", "Sumit@", "Sumit@gmail", "Sumit@gmail."};
	        waitUtils.waitForElementVisibility(breadCrumbOfContactUsPage, 10);

	        yourNameField.clear();
	        yourNameField.sendKeys(GenericUtils.getRandomString(6));
	        enquiryField.clear();
	        enquiryField.sendKeys(GenericUtils.getRandomString(20));

	        boolean allWarningsDisplayed = true;

	        for (String email : invalidEmails) {
	            emailField.clear();
	            emailField.sendKeys(email);

	            // Click Submit
	            Actions actions = new Actions(driver);
	            actions.moveToElement(submitBtn).pause(Duration.ofMillis(500)).click().perform();

	            // Re-locate the warning element fresh each time (prevents stale reference)
	            try {
	                WebElement warningMsg = waitUtils.waitForElementVisibility(
	                        By.xpath("//div[contains(@class,'alert-danger') or contains(text(),'E-Mail Address does not appear to be valid!')]"), 5);

	                if (warningMsg.isDisplayed()) {
	                    System.out.println("Warning displayed correctly for invalid email: " + email);
	                } else {
	                    System.out.println("No warning displayed for invalid email: " + email);
	                    allWarningsDisplayed = false;
	                }
	            } catch (Exception ex) {
	                System.out.println("Warning not found for email: " + email + " | " + ex.getMessage());
	                allWarningsDisplayed = false;
	            }
	        }

	        return allWarningsDisplayed;

	    } catch (Exception e) {
	        System.out.println("Error during invalid email validation test: " + e.getMessage());
	        return false;
	    }
	}

	public boolean verifyAllFieldLevelWarningMessages()
	{
		try {
			waitUtils.waitForElementVisibility(YourNameWarningMsg, 10).isDisplayed();
			emailWarningMsg.isDisplayed();
			enquiryWarningMsg.isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Field level warning messages are not displayed!" + e.getMessage());
			return false;
		}
	}

	public void clickSubmitBtn()
	{
		try {
			waitUtils.waitForElementVisibility(submitBtn, 10).click();
		}catch(Exception e) {
			System.out.println("Submit button in contact us page is not clickable! " + e.getMessage());
		}
	}

	public void clickContinueBtn()
	{
		try {
			waitUtils.waitForElementClickable(continueBtn, 10).click();
		}catch(Exception e) {
			System.out.println("Continue button is not clickable! " + e.getMessage());
		}
	}

	public boolean verifySuccessMessageForContactUs()
	{
		try {
			waitUtils.waitForElementVisibility(successMsg, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Success message is not displayed as expected! " + e.getMessage());
			return false;
		}
	}

	public boolean userFillAllDetailsInContactUsField()
	{
		try {
			waitUtils.waitForElementVisibility(breadCrumbOfContactUsPage, 10).isDisplayed();
			yourNameField.sendKeys(GenericUtils.getRandomString(6));
			emailField.sendKeys(GenericUtils.getRandomEmail());
			enquiryField.sendKeys(GenericUtils.getRandomString(15)+" "+GenericUtils.getRandomEmail()+" "+GenericUtils.getRandomString(32));
			Actions actions = new Actions(driver);
			actions.moveToElement(submitBtn).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("All fields are not getting filled and submitted! " + e.getMessage());
			return false;
		}
	}

	public boolean verifyRedAsteriskPresenceForMandatoryFields() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			By[] fieldLabels = { By.xpath("//label[@for='input-name']"), By.xpath("//label[@for='input-email']"), By.xpath("//label[@for='input-enquiry']")};
			for (By label : fieldLabels) {
				WebElement labelElement = waitUtils.waitForElementVisibility(driver.findElement(label), 10);
				// Get ::before content and color using JS
				String beforeContent = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",labelElement);
				String color = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",labelElement);
				System.out.println("Label: " + labelElement.getText());
				System.out.println(" ::before content = " + beforeContent + " | color = " + color);
				if (beforeContent == null || !beforeContent.contains("*")) {
					System.out.println("Asterisk symbol missing for field: " + labelElement.getText());
					return false;
				}
				if (color == null || !color.contains("255, 0, 0")) {
					System.out.println("Asterisk for field '" + labelElement.getText() + "' is not red!");
					return false;
				}
			}
			System.out.println("All mandatory fields have red asterisks present.");
			return true;
		} catch (Exception e) {
			System.out.println("Error verifying red asterisk for mandatory fields: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyContactUsPageDetails()
	{
		try {
			waitUtils.waitForPageLoad(10);
			return breadCrumbOfContactUsPage.isDisplayed() && ourLocationHeading.isDisplayed() && storeDetails.isDisplayed() && telephoneDetails.isDisplayed() &&
					contactFormHeading.isDisplayed() && yourNameField.isDisplayed() && emailField.isDisplayed() && enquiryField.isDisplayed();
		}catch(Exception e) {
			System.out.println("Contact us page fields not displaying correctly! " + e.getMessage());
			return false;
		}
	}


	public boolean verifyBreadCrumbOfContactUsPage()
	{
		try {
			return waitUtils.waitForElementVisibility(breadCrumbOfContactUsPage, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("BreadCrumb is not displayed as expected! " + e.getMessage());
			return false;
		}
	}



}
