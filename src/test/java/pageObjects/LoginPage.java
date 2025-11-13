package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Continue']") private WebElement continueButton;
	@FindBy(xpath="//div[@class='list-group']//a[2]") private WebElement registerAccountlink;
	@FindBy(xpath="//input[@id='input-email']") private WebElement emailField;
	@FindBy(xpath="//input[@id='input-password']") private WebElement passwordField;
	@FindBy(xpath="//input[@value='Login']") private WebElement loginButton;
	@FindBy(xpath="//div[normalize-space()='Warning: No match for E-Mail Address and/or Password.']") private WebElement loginFailedWarningMessage;
	@FindBy(xpath="//div[normalize-space()='Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.']") private WebElement exceededLoginAttemptsWarningMessage;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[3]") private WebElement LoginPageBreadCrumbText;
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']") private WebElement forgottenPasswordLink;
	@FindBy(xpath="//div[@id='content']//h1") private WebElement forgottenPasswordPageHeading;
	@FindBy(xpath="//aside//a") private List<WebElement> rightColumnLinks;
	@FindBy(xpath="//footer//a") private List<WebElement> footerLinks;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement LoginBreadcrumb;
	@FindBy(xpath="//h2") private List<WebElement> loginPageHeadings;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement loginPageBreadCrumb;
	@FindBy(xpath = "//input[@id='input-email']") private WebElement inRuntimeEmailField;
	@FindBy(xpath = "//input[@id='input-password']") private WebElement inRunTimePasswordField;
	@FindBy(xpath = "//input[@value='Login']") private WebElement loginBtn;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[last()]") private WebElement LoginPageBreadcrumb;
    @FindBy(xpath = "//div[contains(@class,'alert-danger') and contains(text(),'No match for E-Mail Address and/or Password')]") private WebElement invalidLoginErrorMsg;

	public boolean isLoginPageBreadcrumbIsDisplayed()
	{
		try {
			return waitUtils.waitForElementVisibility(LoginPageBreadcrumb, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("Login page breadCrumb is not displayed!" + e.getMessage());
			return false;
		}
	}

	public boolean isInvalidLoginErrorDisplayed() {
	    try {
	        waitUtils.waitForElementVisibility(invalidLoginErrorMsg, 10);
	        return invalidLoginErrorMsg.isDisplayed();
	    } catch (Exception e) {
	        System.out.println("Invalid login error not displayed: " + e.getMessage());
	        return false;
	    }
	}

	public void enterEmailIntoRuntimeEmailField(String email)
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.fluentWaitForElement(inRuntimeEmailField, 10, 15).sendKeys(email);
	}

	public void enterPasswordIntoRuntimePasswordField(String password)
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.fluentWaitForElement(inRunTimePasswordField, 10, 15).sendKeys(password);
	}

	public void clickLoginBtn()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.fluentWaitForElement(loginBtn, 10, 15).click();
	}


	public boolean UserIsOnLoginPage()
	{
		return waitUtils.waitForElementVisibility(loginPageBreadCrumb, 10).isDisplayed();
	}

	public String getURLOfLoginPage()
	{
		return driver.getCurrentUrl();
	}

	public String getTitleofLoginPage()
	{
		return driver.getTitle();
	}

	public boolean isLoginPageHeadingDisplayed()
	{
		for(WebElement heading:loginPageHeadings)
		{
			if(heading.isDisplayed())
			{
				return true;
			}
		}
		return false;
	}

	public boolean isLoginBreadcrumbDisplayed()
	{
		try {
			return LoginBreadcrumb.isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}
	}

	public List<WebElement> getRightColumnLinks()
	{
		return rightColumnLinks;
	}

	public List<WebElement> getFooterLinks()
	{
		return footerLinks;
	}

	public String getValueOfEmailField()
	{
		return emailField.getDomProperty("value");
	}

	public void getCursorOnEmailField()
	{
		emailField.click();
	}

	public void clickLoginBreadcrumb()
	{
		LoginPageBreadCrumbText.click();
	}

	public boolean checkContextClickCopyOptionDisabled()
	{
		return !driver.getPageSource().contains("Copy");
	}

	public WebElement getPasswordField()
	{
		return passwordField;
	}

	public void getCursorOnPasswordField()
	{
		passwordField.click();
	}

	public void clickContinueButton()
	{
		continueButton.click();
	}

	public String getPassWordFieldType()
	{
		return passwordField.getAttribute("type");
	}

	public WebElement getLoginLimitExceedsWarningMessage()
	{
		return exceededLoginAttemptsWarningMessage;
	}

	public WebElement getLoginButton()
	{
		return loginButton;
	}

	public void clickRegisterLinkFromRightCol()
	{
		registerAccountlink.click();
	}

	public String getWarningFailedWarningMessage()
	{
		return loginFailedWarningMessage.getText();
	}

	public void enterLoginEmailField(String email)
	{
		emailField.sendKeys(email);
	}

	public void enterLoginPasswordField(String pass)
	{
		passwordField.sendKeys(pass);
	}

	public void clickLoginButton()
	{
		loginButton.click();
	}

	public boolean isUserOnLoginPage()
	{
		try {
			return LoginPageBreadCrumbText.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean isForgottenPasswordLinkDisplayed()
	{
		return waitUtils.waitForElementVisibility(forgottenPasswordLink, 10).isDisplayed();
	}

	public void clickForgottenPasswordLink()
	{
		waitUtils.waitForElementClickable(forgottenPasswordLink, 10).click();
	}

	public String getHeadingOfForgottenPassword()
	{
		return waitUtils.waitForElementVisibility(forgottenPasswordPageHeading, 10).getText();
	}

	public String getPlaceholderEmailField()
	{
		return emailField.getAttribute("placeholder");
	}

	public String getPlaceholderPasswordField()
	{
		return passwordField.getAttribute("placeholder");
	}
}
