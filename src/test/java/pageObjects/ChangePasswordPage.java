package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utilities.TestData;

public class ChangePasswordPage extends BasePage {

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath="//div[@id='content']//h1") private WebElement ChangePasswordPageHeading;
@FindBy(xpath="//input[@id='input-password']") private WebElement ChangePasswordField;
@FindBy(xpath="//input[@id='input-confirm']") private WebElement ChangeConfPasswordField;
@FindBy(xpath="//input[@value='Continue']") private WebElement ChangePasswordContinueBtn;
@FindBy(xpath="//div[contains(@class,'text-danger') and contains(text(),'Password must be between 4 and 20 characters!')]") private WebElement passwordFieldWarningMessage;
@FindBy(xpath="//div[@class='text-danger' and  contains(text(),'Password confirmation does not match password!')]") private WebElement confPasswordFieldLevelWarningMessage;
@FindBy(xpath="//label[@for='input-password']") private WebElement passwordFieldMandatoryLabel;
@FindBy(xpath="//label[@for='input-confirm']") private WebElement confirmPasswordFieldLabel;
@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement breadcrumb;
@FindBy(xpath="//h1[normalize-space()='Change Password']") private WebElement changePasswordPageHeading;

public boolean validateHeadingTitleAndURL() {
    try {
        String title = driver.getTitle().trim();
        String url = driver.getCurrentUrl().trim();
        String heading = changePasswordPageHeading.getText().trim();

        String expectedTitle = "Change Password";
        String expectedHeading = "Change Password";
        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/password";

        if (title.equalsIgnoreCase(expectedTitle) && heading.equalsIgnoreCase(expectedHeading) && url.equalsIgnoreCase(expectedURL))
        {
            return true;
        } else {
            System.out.println("Page Validation Failed:");
            System.out.println("Actual Title: " + title);
            System.out.println("Actual Heading: " + heading);
            System.out.println("Actual URL: " + url);
            return false;
        }
    } catch (Exception e) {
        System.out.println("Exception in validateHeadingTitleAndURL(): " + e.getMessage());
        return false;
    }
}


public boolean verifyBreadCrumbOFChangePasswordPage()
{
	try {
		waitUtils.waitForElementVisibility(breadcrumb, 10).click();
		Thread.sleep(2000);
		return waitUtils.waitForElementVisibility(breadcrumb, 10).isDisplayed();
	}catch(Exception e) {
		System.out.println("Breadcrumb of change password page is not working properly! " + e.getMessage());
		return false;
	}
}

public boolean isBreadCrumbIsDisplayed()
{
	try {
		return waitUtils.waitForElementVisibility(breadcrumb, 10).isDisplayed();
	}catch(Exception e) {
		return false;
	}
}

public boolean verifyPasswordAndConfPasswordFieldIsEmpty() {
    try {
        String passwordFieldValue = ChangePasswordField.getAttribute("value");
        String confPasswordFieldValue = ChangeConfPasswordField.getAttribute("value");
        return passwordFieldValue.isEmpty() && confPasswordFieldValue.isEmpty();
    } catch (Exception e) {
        System.out.println("Exception while verifying password fields are empty: " + e.getMessage());
        return false;
    }
}

public void clickBrowserBackButton()
{
	driver.navigate().back();
}

public boolean verifyPasswordAndConfPasswordFieldHidesVisibility()
{
	try {
		boolean passwordField = waitUtils.waitForElementVisibility(ChangeConfPasswordField, 10).getAttribute("type").equalsIgnoreCase("password");
		boolean confPasswordField = waitUtils.waitForElementVisibility(ChangeConfPasswordField, 10).getAttribute("type").equalsIgnoreCase("password");
		return passwordField && confPasswordField;
	}catch(Exception e) {
		System.out.println("Visibility of password and confPassword field is not visible!");
		return false;
	}
}

public void verifyMandatoryAsteriskOnChangePasswordLabels() {
    validateMandatoryAsterisk(passwordFieldMandatoryLabel, "Password");
    validateMandatoryAsterisk(confirmPasswordFieldLabel, "Confirm Password");
}

public void validateMandatoryAsterisk(WebElement labelElement, String fieldName) {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    String content = (String) js.executeScript(
        "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",labelElement);
    String color = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",labelElement);

    Assert.assertTrue(content.contains("*"),fieldName + " label does not display mandatory * mark in ::before pseudo-element.");
    Assert.assertTrue(color.contains("255, 0, 0"),fieldName + " label * mark color is not red. Actual: " + color);
}


public boolean isConfPasswordFieldLevelWarnignMessageDisplayed()
{
	try {
		return waitUtils.waitForElementVisibility(confPasswordFieldLevelWarningMessage, 10).isDisplayed();
	}catch(Exception e) {
		System.out.println("Confirm password field level message is not displayed! " + e.getMessage());
		return false;
	}
}

public boolean isPasswordFieldLevelWarningMessageDisplayed()
{
	try {
		return waitUtils.waitForElementVisibility(passwordFieldWarningMessage, 10).isDisplayed();
	}catch(Exception e) {
		System.out.println("password field level message is not displayed! " + e.getMessage());
	    return false;
	}
}

public void loginWithNewPassword()
{
    waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[@title='My Account']")), 10).click();
    WebElement emailId = driver.findElement(By.xpath("//input[@id='input-email']"));
    emailId.clear();
    emailId.sendKeys(TestData.createdEmail);
    WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
    password.clear();
    password.sendKeys("admin");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
}

public void logoutAndLoginWithOldPassword()
{
	waitUtils.waitForPageLoad(10);
    Actions actions = new Actions(driver);
    driver.findElement(By.xpath("//a[@title='My Account']")).click();
    WebElement logout = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
    actions.moveToElement(logout).pause(Duration.ofMillis(500)).click().perform();
    WebElement continueBtn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
    actions.moveToElement(continueBtn).pause(Duration.ofMillis(500)).click().perform();
    waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[@title='My Account']")), 10).click();
    WebElement login = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
    actions.moveToElement(login).pause(Duration.ofMillis(500)).click().perform();
    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(TestData.createdEmail);
    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(TestData.createdPassword);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
}

public boolean userIsOnChangePasswordPage()
{
	try {
		return waitUtils.waitForElementVisibility(ChangePasswordPageHeading, 10).isDisplayed();
	}catch(Exception e) {
		System.out.println("User is not landed on change password page!");
		return false;
	}
}

public void isOnChangePasswordPage()
{
	waitUtils.waitForElementVisibility(ChangePasswordPageHeading, 10).isDisplayed();
}

public void enterChangePassword(String password)
{
	ChangePasswordField.sendKeys(password);
}

public void enterChangeConfPassword(String confPassword)
{
	ChangeConfPasswordField.sendKeys(confPassword);
}

public void clickContinue()
{
	ChangePasswordContinueBtn.click();
}




}
