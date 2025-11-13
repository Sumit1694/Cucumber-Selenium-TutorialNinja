package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.GenericUtils;

public class GiftCertificatePage extends BasePage  {

	public GiftCertificatePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']/li//a[text()='Gift Certificate']") private WebElement giftCertficateBreadCrumb;
	@FindBy(id = "input-to-name") private WebElement recipientsNameField;
	@FindBy(id = "input-to-email") private WebElement recipientsEmail;
	@FindBy(id = "input-from-name") private WebElement yourNameField;
	@FindBy(id = "input-from-email") private WebElement yourEmailField;
	@FindBy(xpath = "//input[@name='voucher_theme_id' and @value='7']") private WebElement birthdayRadioBtn;
	@FindBy(xpath = "//input[@name='voucher_theme_id' and @value='6']") private WebElement ChristmasRadioBtn;
	@FindBy(xpath = "//input[@name='voucher_theme_id' and @value='8']") private WebElement GeneralRadioBtn;
	@FindBy(id = "input-message") private WebElement messageTextField;
	@FindBy(id = "input-amount") private WebElement amountField;
	@FindBy(xpath = "//input[@name='agree']") private WebElement checkBoxField;
	@FindBy(xpath = "//input[@value='Continue']") private WebElement continueBtn;
	@FindBy(xpath = "//label[contains(@class,'col-sm-2 control-label') and contains(text(),'Gift Certificate Theme')]") private WebElement giftCertificateThemeField;
	@FindBy(xpath = "//input[@name='voucher_theme_id']") List<WebElement> giftCertificateThemeRadios;
	@FindBy(xpath = "//input[@id='input-to-name']/following-sibling::div") private WebElement recepientNameFieldWarningMessage;
	@FindBy(xpath = "//input[@id='input-to-email']/following-sibling::div") private WebElement recepientEmailFieldWarningMessage;
	@FindBy(xpath = "//input[@id='input-amount']/following-sibling::div") private WebElement amountFieldWarningMessage;

	public boolean userFillAllDetailsInGiftCertificatePage() {
	    try {
	        waitUtils.waitForElementVisibility(giftCertficateBreadCrumb, 10);
	        recipientsNameField.clear();
	        recipientsNameField.sendKeys(GenericUtils.getRandomString(6));
	        recipientsEmail.clear();
	        recipientsEmail.sendKeys(GenericUtils.getRandomEmail());
	        String yourNameValue = yourNameField.getAttribute("value");
	        if (yourNameValue == null || yourNameValue.isEmpty()) {
	            yourNameField.sendKeys(GenericUtils.getRandomString(6));
	        }
	        String yourEmailValue = yourEmailField.getAttribute("value");
	        if (yourEmailValue == null || yourEmailValue.isEmpty()) {
	            yourEmailField.sendKeys(GenericUtils.getRandomEmail());
	        }
	        if (!birthdayRadioBtn.isSelected()) {
	            birthdayRadioBtn.click();
	        }
	        messageTextField.clear();
	        messageTextField.sendKeys(GenericUtils.getRandomString(40));
	        amountField.clear();
	        amountField.sendKeys("1");
	        if (!checkBoxField.isSelected()) {
	            checkBoxField.click();
	        }
	        continueBtn.click();
	        System.out.println("Gift certificate form submitted (except recipient name).");
	        return true;

	    } catch (Exception e) {
	        System.out.println("Gift certificate form is not getting submitted successfully! " + e.getMessage());
	        return false;
	    }
	}

	public boolean verifyWarningMessageForAmountField()
	{
		try {
			return waitUtils.waitForElementVisibility(amountFieldWarningMessage, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("amount field warning message is not displayed! " + e.getMessage());
			return false;
		}
	}

	public boolean userFillAllDetailsInGiftCertificatePageWithamountZero() {
	    try {
	        waitUtils.waitForElementVisibility(giftCertficateBreadCrumb, 10);
	        recipientsNameField.clear();
	        recipientsNameField.sendKeys(GenericUtils.getRandomString(6));
	        recipientsEmail.clear();
	        recipientsEmail.sendKeys(GenericUtils.getRandomString(5));
	        String yourNameValue = yourNameField.getAttribute("value");
	        if (yourNameValue == null || yourNameValue.isEmpty()) {
	            yourNameField.sendKeys(GenericUtils.getRandomString(6));
	        }
	        String yourEmailValue = yourEmailField.getAttribute("value");
	        if (yourEmailValue == null || yourEmailValue.isEmpty()) {
	            yourEmailField.sendKeys(GenericUtils.getRandomEmail());
	        }
	        if (!birthdayRadioBtn.isSelected()) {
	            birthdayRadioBtn.click();
	        }
	        messageTextField.clear();
	        messageTextField.sendKeys(GenericUtils.getRandomString(40));
	        amountField.clear();
	        amountField.sendKeys("0");
	        if (!checkBoxField.isSelected()) {
	            checkBoxField.click();
	        }
	        continueBtn.click();
	        System.out.println("Gift certificate form submitted (except recipient name).");
	        return true;

	    } catch (Exception e) {
	        System.out.println("Gift certificate form is not getting submitted successfully! " + e.getMessage());
	        return false;
	    }
	}

	public boolean verifyRecipientEmailWarningMessage()
	{
		try {
			return waitUtils.waitForElementVisibility(recepientEmailFieldWarningMessage, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("recepient email field warning message is not displayed correctly! " + e.getMessage());
			return false;
		}
	}

	public boolean userFillAllDetailsInGiftCertificatePageWithInvalidRecipientEmail() {
	    try {
	        waitUtils.waitForElementVisibility(giftCertficateBreadCrumb, 10);
	        recipientsNameField.clear();
	        recipientsNameField.sendKeys(GenericUtils.getRandomString(6));
	        recipientsEmail.clear();
	        recipientsEmail.sendKeys(GenericUtils.getRandomString(5));
	        String yourNameValue = yourNameField.getAttribute("value");
	        if (yourNameValue == null || yourNameValue.isEmpty()) {
	            yourNameField.sendKeys(GenericUtils.getRandomString(6));
	        }
	        String yourEmailValue = yourEmailField.getAttribute("value");
	        if (yourEmailValue == null || yourEmailValue.isEmpty()) {
	            yourEmailField.sendKeys(GenericUtils.getRandomEmail());
	        }
	        if (!birthdayRadioBtn.isSelected()) {
	            birthdayRadioBtn.click();
	        }
	        messageTextField.clear();
	        messageTextField.sendKeys(GenericUtils.getRandomString(40));
	        amountField.clear();
	        amountField.sendKeys(GenericUtils.getRandomNumber(3));
	        if (!checkBoxField.isSelected()) {
	            checkBoxField.click();
	        }
	        continueBtn.click();
	        System.out.println("Gift certificate form submitted (except recipient name).");
	        return true;

	    } catch (Exception e) {
	        System.out.println("Gift certificate form is not getting submitted successfully! " + e.getMessage());
	        return false;
	    }
	}

	public boolean verifyRecepientNameFieldWarningMessage()
	{
		try {
			return waitUtils.waitForElementVisibility(recepientNameFieldWarningMessage, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("recepient name warning message is not displayed! " + e.getMessage());
			return false;
		}
	}

	public boolean userFillAllDetailsInGiftCertificatePageExceptRecipientName() {
	    try {
	        waitUtils.waitForElementVisibility(giftCertficateBreadCrumb, 10);
	        String recNameValue = recipientsNameField.getAttribute("value");
	        if (recNameValue != null && !recNameValue.isEmpty()) {
	            recipientsNameField.clear();
	        }
	        System.out.println("Recipient name intentionally left blank.");
	        recipientsEmail.clear();
	        recipientsEmail.sendKeys(GenericUtils.getRandomEmail());
	        String yourNameValue = yourNameField.getAttribute("value");
	        if (yourNameValue == null || yourNameValue.isEmpty()) {
	            yourNameField.sendKeys(GenericUtils.getRandomString(6));
	        }
	        String yourEmailValue = yourEmailField.getAttribute("value");
	        if (yourEmailValue == null || yourEmailValue.isEmpty()) {
	            yourEmailField.sendKeys(GenericUtils.getRandomEmail());
	        }
	        if (!birthdayRadioBtn.isSelected()) {
	            birthdayRadioBtn.click();
	        }
	        messageTextField.clear();
	        messageTextField.sendKeys(GenericUtils.getRandomString(40));
	        amountField.clear();
	        amountField.sendKeys(GenericUtils.getRandomNumber(3));
	        if (!checkBoxField.isSelected()) {
	            checkBoxField.click();
	        }
	        continueBtn.click();
	        System.out.println("Gift certificate form submitted (except recipient name).");
	        return true;

	    } catch (Exception e) {
	        System.out.println("Gift certificate form is not getting submitted successfully! " + e.getMessage());
	        return false;
	    }
	}


	public boolean verifygiftThemeFirstOptionIsSelectedByDefault()
	{
		try {
			waitUtils.waitForElementVisibility(giftCertficateBreadCrumb, 10);

			if(giftCertificateThemeRadios.isEmpty())
			{
				System.out.println("No gift theme radio buttons found!");
				return false;
			}

			WebElement firstRadio = giftCertificateThemeRadios.get(0);

			if(firstRadio.isSelected())
			{
				System.out.println("First gift theme option is selected by default!");
				return true;
			}else {
				System.out.println("First gift theme option is not selected by default!");
				return false;
			}
		}catch(Exception e) {
			System.out.println("Error while verifying gift theme default seletion: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyMandatoryAsteriskColorForAllFields() {
	    try {
	        // Get all labels that have ::before content (asterisk)
	        List<WebElement> requiredLabels = driver.findElements(By.xpath("//label"));

	        if (requiredLabels.isEmpty()) {
	            System.out.println("No label elements found on page!");
	            return false;
	        }

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        boolean allPass = true;

	        for (WebElement label : requiredLabels) {
	            // Get the computed style of the ::before pseudo-element
	            String content = (String) js.executeScript(
	                    "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
	                    label
	            );

	            // If label has ::before content (usually '*')
	            if (content != null && content.contains("*")) {
	                String color = (String) js.executeScript(
	                        "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",
	                        label
	                );

	                System.out.println("Label: " + label.getText() + " | ::before color: " + color);

	                // Expected red color check (can vary by app theme)
	                if (!(color.contains("rgb(255, 0, 0)") || color.equalsIgnoreCase("red"))) {
	                    System.out.println("Asterisk for label '" + label.getText() + "' is not red!");
	                    allPass = false;
	                }
	            }
	        }

	        if (allPass)
	            System.out.println("All mandatory field asterisks (::before) are red.");
	        else
	            System.out.println("Some asterisks are not red!");

	        return allPass;

	    } catch (Exception e) {
	        System.out.println("Exception in verifying asterisk color: " + e.getMessage());
	        return false;
	    }
	}




	public boolean userIsOnGiftCertificatePage()
	{
		try {
			waitUtils.waitForElementVisibility(giftCertficateBreadCrumb, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Gift certificate page is not displayed!" + e.getMessage());
			return false;
		}
	}



}
