package pageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.GenericUtils;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="firstname") private WebElement FirstNameField;
	@FindBy(name="lastname") private WebElement LastNameField;
	@FindBy(name="email") private WebElement EmailField;
	@FindBy(name="telephone") private WebElement TelephoneField;
	@FindBy(name="password") private WebElement PasswordField;
	@FindBy(name="confirm") private WebElement ConfPasswordField;
	@FindBy(name="agree") private WebElement privacyPolicyCheckbox;
	@FindBy(xpath="//input[@value='Continue']") private WebElement continueButtonOnRegisterPage;
	@FindBy(xpath="//label[normalize-space()='Yes']//input[@name='newsletter']") private WebElement yesRadioButton;
	@FindBy(xpath="//input[@value='0']")  private WebElement noRadioButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private WebElement privacyPolicyWarningMessage;
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]") private WebElement firstNameWarningMessage;
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]") private WebElement lastNameWarningMessage;
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]") private WebElement emailWarningMessage;
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]") private WebElement telephoneWarningMessage;
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]") private WebElement passwordWarningMessage;
	@FindBy(xpath="//h1[text()='Register Account']") private WebElement registerAccountHeadingText;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private WebElement emailAlreadyRegisteredWarningMessage;
    @FindBy(xpath="//div[@class='text-danger']") private WebElement specialEmailWarningMessage;
    @FindBy(xpath="//label[@for='input-firstname']") private WebElement firstNameLabel;
    @FindBy(xpath="//label[@for='input-lastname']") private WebElement lastNameLabel;
    @FindBy(xpath="//label[@for='input-email']") private WebElement emailFieldLabel;
    @FindBy(xpath="//label[@for='input-telephone']") private WebElement telephoneFieldLabel;
    @FindBy(xpath="//label[@for='input-password']") private WebElement passwordFieldLabel;
    @FindBy(xpath="//label[@for='input-confirm']") private WebElement confirmPasswordFieldLabel;
    @FindBy(xpath="//h1[text()='Register Account']") private WebElement RegisterAccountPageheading;
    @FindBy(xpath="//a[normalize-space()='Edit your account information']") private WebElement Edityouraccountinformationlink;
    @FindBy(xpath="//ul[@class='breadcrumb']//li[3]") private WebElement breadcrumbRegisterPage;
    @FindBy(xpath="//div[@id='content']//h1") private WebElement RegisterPageHeading;
    @FindBy(xpath = "//aside//a") private List<WebElement> rightColumnLinks;
    @FindBy(xpath = "//div[@class='list-group']//a") private List<WebElement> categoryLinks;
    @FindBy(xpath = "//footer//a") private List<WebElement> footerLinks;
    @FindBy(xpath="//a[normalize-space()='login page']") private WebElement loginPage;
    @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']") private WebElement loginLinkRightColmn;

    public List<String> getOptionsFromRightColmn()
    {
    	List<String> optionText = new ArrayList<String>();
    	for(WebElement option:rightColumnLinks)
    	{
    		optionText.add(option.getText().trim());
    	}
    	return optionText;
    }

    public void clickLoginLinkRightColmn()
    {
    	loginLinkRightColmn.click();
    }

    public void clickLoginPageLink()
    {
    	loginPage.click();
    }

    public boolean isFirstNameFieldDisplayedAndEnabled()
    {
    	return FirstNameField.isDisplayed() && FirstNameField.isEnabled();
    }

    public boolean isLastNameFieldDisplayedAndEnabled()
    {
    	return LastNameField.isDisplayed() && LastNameField.isEnabled();
    }

    public boolean isEmailFieldDisplayedAndEnabled()
    {
    	return EmailField.isDisplayed() && EmailField.isEnabled();
    }

    public boolean isTelephoneFieldDisplayedAndEnabled()
    {
    	return TelephoneField.isDisplayed() && TelephoneField.isEnabled();
    }

    public boolean isPasswordFieldDisplayedAndEnabled()
    {
    	return PasswordField.isDisplayed() && PasswordField.isEnabled();
    }

    public boolean isConfPasswordFieldDisplayedAndEnabled()
    {
    	return ConfPasswordField.isDisplayed() && ConfPasswordField.isEnabled();
    }

    public boolean isPrivacyPolicyFieldDisplayedAndEnabled()
    {
    	return privacyPolicyCheckbox.isDisplayed() && privacyPolicyCheckbox.isEnabled();
    }

    public boolean isYesAndNoRadioButtonFieldDisplayedAndEnabled()
    {
    	return yesRadioButton.isDisplayed() && yesRadioButton.isEnabled() && noRadioButton.isDisplayed() && noRadioButton.isEnabled();
    }

    public boolean isContinueButtonDisplayed()
    {
    	return continueButtonOnRegisterPage.isDisplayed();
    }

    public List<WebElement> getRightColumnLinks() {
        return rightColumnLinks;
    }

    public List<WebElement> getCategoryLinks() {
        return categoryLinks;
    }

    public List<WebElement> getFooterLinks() {
        return footerLinks;
    }

    public boolean isProperRegisterPageBreadcrumbDisplayed()
    {
    	return breadcrumbRegisterPage.isDisplayed();
    }

    public String getRegisterPageTitle()
    {
    	return RegisterPageHeading.getText();
    }

    public String getURLofRegisterAccountPage()
    {
    	return driver.getCurrentUrl();
    }

	public void enterFirstName(String firstname)
	{
		if(FirstNameField.isEnabled())
		{
			FirstNameField.sendKeys(firstname);
		}
	}

	public String getAttributeValueFirstName()
	{
		return FirstNameField.getAttribute("value");
	}

	public int getHeightOfFirstNameField()
	{
        return FirstNameField.getSize().getHeight();
	}

	public int getWidthOfFirstNameField()
	{
		return FirstNameField.getSize().getWidth();
	}

	public void enterLastName(String lastName)
	{
		if(LastNameField.isEnabled())
		{
			LastNameField.sendKeys(lastName);
		}
	}

	public String getAttributeValueLastName()
	{
		return LastNameField.getAttribute("value");
	}

	public int getHeightOfLastNameField()
	{
		return LastNameField.getSize().getHeight();
	}

	public int getWidthOfLastNameField()
	{
		return LastNameField.getSize().getWidth();
	}

	public void enteremail(String email)
	{
		if(EmailField.isEnabled())
		{
			EmailField.sendKeys(email);
		}
	}

	public String getAttributeValueEmailField()
	{
		return EmailField.getAttribute("value");
	}

	public int getHeightOfEmailField()
	{
		return EmailField.getSize().getHeight();
	}

	public int getWidthOfEmailField()
	{
		return EmailField.getSize().getWidth();
	}

	public void enterTelephone(String telephone)
	{
		if(TelephoneField.isEnabled())
		{
			TelephoneField.sendKeys(telephone);
		}
	}

	public String getAttributeValueTelephoneField()
	{
		return TelephoneField.getAttribute("value");
	}

	public int getHeigthOfTelephoneField()
	{
		return TelephoneField.getSize().getHeight();
	}

	public int getWidthOfTelephoneField()
	{
		return TelephoneField.getSize().getWidth();
	}

	public void enterpassword(String password)
	{
		if(PasswordField.isEnabled())
		{
			PasswordField.sendKeys(password);
		}
	}

	public String getPasswordFieldType()
	{
		return PasswordField.getAttribute("type");
	}

	public int getHeightOfPasswordField()
	{
		return PasswordField.getSize().getHeight();
	}

	public int getWidthOfPasswordField()
	{
		return PasswordField.getSize().getWidth();
	}

	public void enterConfPassword(String confirmPassword)
	{
		if(ConfPasswordField.isEnabled())
		{
			ConfPasswordField.sendKeys(confirmPassword);
		}
	}

	public String getConfPasswordFieldType()
	{
		return ConfPasswordField.getAttribute("type");
	}

	public int getHeightOfConfPasswordField()
	{
		return ConfPasswordField.getSize().getHeight();
	}

	public int getWidthOfConfPasswordField()
	{
		return ConfPasswordField.getSize().getWidth();
	}

	public String getFirstNameFieldSymbol() {
	    return GenericUtils.getBeforeContent(firstNameLabel);
	}

	public String getFirstNameFieldColor()
	{
		return GenericUtils.getBeforeColor(firstNameLabel);
	}

	public String getLastNameFieldSymbol()
	{
		return GenericUtils.getBeforeContent(lastNameLabel);
	}

	public String getLastNameFieldColor()
	{
		return GenericUtils.getBeforeColor(lastNameLabel);
	}

	public String getEmailFieldSymbol()
	{
		return GenericUtils.getBeforeContent(emailFieldLabel);
	}

	public String getEmailFieldColor()
	{
		return GenericUtils.getBeforeColor(emailFieldLabel);
	}

	public String getTelephoneFieldSymbol()
	{
		return GenericUtils.getBeforeContent(telephoneFieldLabel);
	}

	public String getTelephoneFieldColor()
	{
		return GenericUtils.getBeforeColor(telephoneFieldLabel);
	}

	public String getPasswordFieldSymbol()
	{
		return GenericUtils.getBeforeContent(passwordFieldLabel);
	}

	public String getPasswordFieldColor()
	{
		return GenericUtils.getBeforeColor(passwordFieldLabel);
	}

	public String getConfPasswordFieldSymbol()
	{
		return GenericUtils.getBeforeContent(confirmPasswordFieldLabel);
	}

	public String getConfPasswordFieldColor()
	{
		return GenericUtils.getBeforeColor(confirmPasswordFieldLabel);
	}

	public String getPlaceholderAttributforFname()
	{
		return FirstNameField.getAttribute("placeholder");
	}

	public String getPlaceholderAttributeForLname()
	{
		return LastNameField.getAttribute("placeholder");
	}

	public String getPlaceholderAttributeforEmail()
	{
		return EmailField.getAttribute("placeholder");
	}

	public String getPlaceholderAttributeforTel()
	{
		return TelephoneField.getAttribute("placeholder");
	}

	public String getPlaceholderAttributeforPass()
	{
		return PasswordField.getAttribute("placeholder");
	}

	public String getPlaceholderAttributeforconfPass()
	{
		return ConfPasswordField.getAttribute("placeholder");
	}

	public void acceptPrivacyPolicy()
	{
		if(!privacyPolicyCheckbox.isSelected())
		{
			privacyPolicyCheckbox.click();
		}
	}

	public int getHeightOfPrivacyPolicyCheckBox()
	{
		return privacyPolicyCheckbox.getSize().getHeight();
	}

	public int getWidthOfPrivacyPolicyCheckBox()
	{
		return privacyPolicyCheckbox.getSize().getWidth();
	}

	public void selectYesRadioButton()
	{
		if(!yesRadioButton.isSelected())
		{
			yesRadioButton.click();
		}
	}

	public void clickEditAccountInformationLink()
	{
		Edityouraccountinformationlink.click();
	}

	public void selectNoRadioButton()
	{
		if(!noRadioButton.isSelected())
		{
			noRadioButton.click();
		}
	}

	public void clickContinueButtonOnRegisterPage()
	{
		if(continueButtonOnRegisterPage.isDisplayed())
		{
			continueButtonOnRegisterPage.click();
		}
	}

	public int getHeightOfContinueButton()
	{
		return continueButtonOnRegisterPage.getSize().getHeight();
	}

	public int getWidthOfContinueButton()
	{
		return continueButtonOnRegisterPage.getSize().getWidth();
	}

	public String getPrivacyPolicyWarningMessage()
	{
		return privacyPolicyWarningMessage.getText();
	}

	public String getFirstNameWarningMessage()
	{
		return firstNameWarningMessage.getText();
	}

	public String getLastNameWarningMessage()
	{
		return lastNameWarningMessage.getText();
	}

	public String getEmailWarningMessage()
	{
		return emailWarningMessage.getText();
	}

	public String getTelephoneWarningMessage()
	{
		return telephoneWarningMessage.getText();
	}

	public String getpasswordWarningMessage()
	{
		return passwordWarningMessage.getText();
	}

	public boolean isOnRegisterAccountPage() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//h1[text()='Register Account']")));
	        return heading.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public String getEmailAlreadyRegisteredWarningMsg()
	{
		return emailAlreadyRegisteredWarningMessage.getText();
	}

	public boolean checkPrivacyPolicyCheckboxSelected()
	{
		return privacyPolicyCheckbox.isSelected();
	}

	public String getEmailWarningMessage1() {
	    try {
	        // Wait until warning appears (max 5 sec)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement warning = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!') or contains(@class,'text-danger')]")
	            )
	        );
	        return warning.getText();
	    } catch (Exception e) {
	        return "Warning message not found!";
	    }
	}

	public void fillRegistrationWithWrongEmail(String email) {
	    enterFirstName(utilities.GenericUtils.getRandomString(8));
	    enterLastName(utilities.GenericUtils.getRandomString(6));
	    enteremail(email);
	    enterTelephone(utilities.GenericUtils.getRandomNumber(10));

	    String password = utilities.GenericUtils.getRandomString(5) + utilities.GenericUtils.getRandomNumber(4);
	    enterpassword(password);
	    enterConfPassword(password);

	    selectNoRadioButton();
	    acceptPrivacyPolicy();
	}

	public void registerWithInvalidEmails(List<String> invalidEmails, WebDriver driver) throws IOException {

	    for (int i = 0; i < invalidEmails.size(); i++) {
	        String email = invalidEmails.get(i);
	        fillRegistrationWithWrongEmail(email);
	        clickContinueButtonOnRegisterPage();
	        String actualScreenshot = GenericUtils.captureScreenshot(driver, "Actual_InvalidEmail_" + (i + 1));
	        String expectedScreenshot = System.getProperty("user.dir") + "/screenshots/Expected_InvalidEmail_" + (i + 1) + ".png";
	        File expectedFile = new File(expectedScreenshot);
	        if (expectedFile.exists()) {
	            boolean match = GenericUtils.compareImages(expectedScreenshot, actualScreenshot);
	            if (match) {
	                System.out.println("PASS: Screenshot matched for email " + email);
	            } else {
	                System.out.println("FAIL: Screenshot mismatch for email " + email);
	            }
	        } else {
	            System.out.println("Expected screenshot not found for email " + email + ". Skipping comparison.");
	        }

	        String warning;
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	            if (i == 3) {
	                warning = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[@class='text-danger']"))).getText();

	                Assert.assertEquals(warning, "E-Mail Address does not appear to be valid!",
	                        "4th invalid email did not show proper warning!");
	            } else {
	                warning = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))).getText();
	                System.out.println("Email " + email + " warning: " + warning);
	            }

	        } catch (Exception e) {
	            warning = "Warning message not found!";
	            System.out.println("Email " + email + " warning: " + warning);
	        }

	        driver.navigate().refresh();
	    }
	}

	public void fillRegistrationFormUsingKeyboard(String firstName, String lastName, String email, String phone, String password, String confPassword)
	{
		Actions actions = new Actions(driver);

		FirstNameField.click();
		actions.sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(phone).sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.TAB).sendKeys(confPassword).perform();

		actions.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
	}

	public void saveUserInMockDB(String firstName,String lastName,String email,String telephone,String password,String confPassword)
	{
		GenericUtils.getMockDatabase().saveUser(firstName, lastName, email, telephone, password, confPassword);
	}
}
