package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage {

public SuccessPage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath="//a[normalize-space()='Success']") private WebElement successPageLanded;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") private WebElement accountCreatedHeading;
@FindBy(xpath="//p[contains(text(),'Congratulations! Your new account has been success')]") private WebElement newAccountSuccesstxt;
@FindBy(xpath="//p[contains(text(),'You can now take advantage of member privileges to')]") private WebElement takeAdvantagetxt;
@FindBy(xpath="//p[contains(text(),'If you have ANY questions about the operation of t')]") private WebElement anyQuestiontxt;
@FindBy(xpath="//div[@id='content']//p[4]") private WebElement confirmationSenttxt;
@FindBy(xpath="//div[@id='content']//p[4]//a") private WebElement contactUsLinkTest;
@FindBy(xpath="//a[normalize-space()='Continue']") private WebElement continueButton;
@FindBy(xpath="//ul[@class='breadcrumb']//li[last()]") private WebElement successPageBreadCrumb;
@FindBy(xpath="//div[@id='content']//h1") private WebElement orderPlacedSuccessMessage;

public boolean isOrderPlacedSuccessMessageDisplayed()
{
	return orderPlacedSuccessMessage.isDisplayed();
}

public boolean isSuccessPageBreadCrumbDisplayed()
{
	return successPageBreadCrumb.isDisplayed();
}

public boolean isOnsuccessPage()
{
	return successPageLanded.isDisplayed();
}

public String getAccountCreatedHeading()
{
	return accountCreatedHeading.getText();
}

public String getAccountSuccessMessage()
{
	return newAccountSuccesstxt.getText();
}

public String getAdvantagesMessage()
{
	return takeAdvantagetxt.getText();
}

public String getAnyQuestionMessage()
{
	return anyQuestiontxt.getText();
}

public String getConfirmationSentMessage()
{
	return confirmationSenttxt.getText();
}

public String getContactUsParagraphLinkText()
{
	return contactUsLinkTest.getText();
}

public void clickContinueButtonOnSuccessPage()
{
	continueButton.click();
}



}
