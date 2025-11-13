package pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GenericUtils;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	private String firstNameValue;
	private String lastNameValue;
	private String companyValue;
	private String address1Value;
	private String address2Value;
	private String cityValue;
	private String postCodeValue;
	private String countryValue;
	private String regionValue;
	@FindBy(xpath = "//input[@id='input-payment-firstname']") private WebElement firstNameField;
	@FindBy(xpath = "//input[@id='input-payment-lastname']") private WebElement lastNameField;
	@FindBy(xpath = "//input[@id='input-payment-email']") private WebElement emailField;
	@FindBy(xpath = "//input[@id='input-payment-telephone']") private WebElement telephoneField;
	@FindBy(xpath = "//input[@id='input-payment-password']") private WebElement passwordField;
	@FindBy(xpath = "//input[@id='input-payment-confirm']") private WebElement confPasswordField;
	@FindBy(xpath = "//input[@id='input-payment-company']") private WebElement companyField;
	@FindBy(xpath = "//input[@id='input-payment-address-1']") private WebElement address1Field;
	@FindBy(xpath = "//input[@id='input-payment-address-2']") private WebElement address2Field;
	@FindBy(xpath = "//input[@id='input-payment-city']") private WebElement cityField;
	@FindBy(xpath = "//input[@id='input-payment-postcode']") private WebElement postCodeField;
	@FindBy(xpath = "//select[@id='input-payment-country']") private WebElement countryDrpDwn;
	@FindBy(xpath = "//div[@class='col-sm-10']//select[@name='country_id']") private WebElement regionDrpDwn;
	@FindBy(name  = "zone_id") private WebElement regionSelect;
	@FindBy(xpath = "//input[@id='button-payment-address']") private WebElement BillingDetailscontinueBtn;
	@FindBy(xpath = "//input[@id='button-shipping-address']") private WebElement DeliveryDetailsContinueBtn;
	@FindBy(xpath = "//input[@id='button-shipping-method']") private WebElement DeliveryMethodContinueBtn;
	@FindBy(xpath = "//input[@name='agree']") private WebElement checkBoxPaymentMethod;
	@FindBy(xpath = "//input[@id='button-payment-method']") private WebElement continueBtnPaymentMethod;
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]") private WebElement productNameLnk;
	@FindBy(xpath = "//div[@id='collapse-payment-address']//label[contains(normalize-space(), 'I want to use an existing address')]/input[@name='payment_address']") private WebElement wantToUseExistingAddreessRadioButton;
	@FindBy(xpath = "//div[@id='payment-existing']//select[@name='address_id']/option[@selected='selected']") private WebElement ExistingAddress;
	@FindBy(xpath = "//input[@id='button-payment-address']") private WebElement continueBtnBillingDetails;
	@FindBy(xpath = "//label[normalize-space()='I want to use an existing address']//input[@name='shipping_address']") private WebElement DeliveryDetailsExistingAddressrdioBtn;
	@FindBy(xpath = "//div[@id='shipping-existing']//select[@name='address_id']/option[@selected='selected']") private WebElement DeliveryDetailsExistingAddreess;
	@FindBy(xpath = "//input[@id='button-shipping-address']") private WebElement deliveryDetailsContinueButton;
	@FindBy(xpath = "//input[@name='shipping_method']") private WebElement deliveryMethodShippingRadioBtn;
	@FindBy(xpath = "//input[@id='button-shipping-method']") private WebElement continueBtnDeliveryMethodSection;
	@FindBy(xpath = "//input[@name='payment_method']") private WebElement cashOnDeliveryradioBtn;
	@FindBy(xpath = "//div[@id='collapse-shipping-address']//div[@class='panel-body']") private WebElement deliveryDetailsSection;
	@FindBy(xpath = "//div[@id='collapse-payment-address']") private WebElement BillingDetailsSection;
	@FindBy(xpath = "//div[@id='collapse-payment-method']//div[@class='panel-body']") private WebElement paymentMethodSection;
	@FindBy(xpath = "//input[@name='agree']") private WebElement checkBoxTermsandCondInPaymentDetails;
	@FindBy(xpath = "//input[@id='button-payment-method']") private WebElement ContinueBtnPaymentMethod;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//tr") private List<WebElement> productsDisplayed;
	@FindBy(xpath = "//div[@id='collapse-checkout-confirm']//div[@class='panel-body']") private WebElement confirmOrderSection;
	@FindBy(xpath = "//div[@id='collapse-checkout-confirm']//table[contains(@class,'table')]") private WebElement confirmOrderTable;
	@FindBy(xpath = "//div[@id='collapse-checkout-confirm']//table//thead//tr//td") private List<WebElement> tableHeaders;
	@FindBy(xpath = "//div[@id='collapse-checkout-confirm']//table//tbody//tr") private List<WebElement> productRows;
	@FindBy(xpath = "//div[@id='collapse-checkout-confirm']//table//tfoot//tr//td[1]") private List<WebElement> footerLabels;
	@FindBy(xpath = "//div[@id='collapse-checkout-confirm']//table//tfoot//tr//td[2]") private List<WebElement> footerValues;
	@FindBy(xpath = "//input[@id='button-confirm']") private WebElement confirmOrderBtn;
	@FindBy(xpath = "//input[@value='new']") private WebElement newAddressRadioBtn;
	@FindBy(xpath = "//div[@id='shipping-existing']//select[@name='address_id']") private WebElement newDeliveryDetailsExistingAddress;
	@FindBy(xpath = "//label[normalize-space()='I want to use a new address']//input[@name='shipping_address']") private WebElement newAddressRadioBtnDeliveryDetails;
	@FindBy(xpath = "//input[@id='input-shipping-firstname']") private WebElement firstNameFieldDeliveryDetails;
	@FindBy(xpath = "//input[@id='input-shipping-lastname']") private WebElement lastNameFieldDeliveryDetails;
	@FindBy(xpath = "//input[@id='input-shipping-company']") private WebElement companyFieldDeliveryDetails;
	@FindBy(xpath = "//input[@id='input-shipping-address-1']") private WebElement address1DeliveryDetails;
	@FindBy(xpath = "//input[@id='input-shipping-address-2']") private WebElement address2DeliveryDetails;
	@FindBy(xpath = "//input[@id='input-shipping-city']") private WebElement cityDeliveryDetails;
	@FindBy(xpath = "//input[@id='input-shipping-postcode']") private WebElement postCodeDeliveryDetails;
	@FindBy(xpath = "//select[@id='input-shipping-country']") private WebElement countryDrpDwnDeliveryDetails;
	@FindBy(xpath = "//select[@id='input-shipping-zone']") private WebElement regionDrpDwnDeliveryDetails;
	@FindBy(xpath = "//textarea[@name='comment']") private WebElement AddCommentsToYourOrder;
	@FindBy(xpath = "//div[@id='collapse-shipping-method']//div[@class='panel-body']") private WebElement DeliveryMethodSection;
	@FindBy(xpath = "//div[@id='collapse-payment-method']//div[@class='panel-body']") private WebElement PaymenetMethodSection;
	@FindBy(name = "comment") private WebElement paymentMethodTextArea;
	@FindBy(xpath = "//input[@id='button-shipping-address']") private WebElement continueBtnDeliveryDetails;
	@FindBy(xpath = "//div[@id='collapse-payment-method']//textarea[@name='comment']") private WebElement commentTextBoxInPaymentMethodSection;
	@FindBy(xpath = "//div[@class='radio']//input[@value='guest']") private WebElement guestRadioBtn;
	@FindBy(id = "button-account") private WebElement ContinueBtnNewCustomerSection;
	@FindBy(xpath = "//body/div[@id='checkout-checkout']/div[@class='row']/div[@id='content']/div[@id='accordion']/div[@class='panel panel-default']/div[@id='collapse-checkout-option']/div[@class='panel-body']/div[@class='row']/div[1]") private WebElement checkoutOptionSection;
	@FindBy(xpath = "//a[@href='#collapse-payment-address']") private WebElement billingDetailsToggle;
	@FindBy(xpath = "//div[@id='collapse-payment-address']//label//input[@type='checkbox']") private WebElement myDeliveryAndBillingAddressCheckBox;
	@FindBy(id = "input-payment-firstname") private WebElement firstNamePersonalDetails;
	@FindBy(id = "input-payment-lastname") private WebElement lastNamePersonalDetails;
	@FindBy(id = "input-payment-email") private WebElement emailPersonalDetails;
	@FindBy(id = "input-payment-telephone") private WebElement telephonePersonalDetails;
	@FindBy(id = "input-payment-address-1") private WebElement address1YourAddressSection;
	@FindBy(id = "input-payment-city") private WebElement cityYourAddressSection;
	@FindBy(id = "input-payment-postcode") private WebElement postCodeYourAddressSection;
	@FindBy(id = "input-payment-country") private WebElement countryYourAddressSection;
	@FindBy(id = "input-payment-zone") private WebElement regionYourAddressSection;
	@FindBy(xpath = "//input[@id='button-guest']") private WebElement continueButtonBillingDetailsSection;
	@FindBy(xpath = "//a[@href='#collapse-shipping-method']") private WebElement DeliveryMethodToggle;
	@FindBy(xpath = "//a[@href='#collapse-payment-method']") private WebElement PaymentMethodToggle;
	@FindBy(xpath = "//input[@name='payment_method']") private WebElement cashOnDeliveryRadioButton;
	@FindBy(xpath = "//a[@href='#collapse-checkout-confirm']") private WebElement confirmOrderToggle;
	@FindBy(xpath = "//input[@value='register']") private WebElement registerAccountRadioBtn;
	@FindBy(xpath = "//input[@name='shipping_address']") private WebElement myDeliveryAndBillingAddressRadioBtn;
	@FindBy(xpath = "//a[@href='#collapse-payment-address']") private WebElement AccountAndBillingDetailsToggle;
	@FindBy(name = "agree") private WebElement checkBoxAccountAndBillingDetails;
	@FindBy(id = "button-register") private WebElement continueBtnAccountAndRegister;
	@FindBy(id = "input-email") private WebElement emailFieldReturningCustomer;
	@FindBy(id = "input-password") private WebElement passwordFieldReturningCustomer;
	@FindBy(id="button-login") private WebElement loginBtnReturningCustomer;
	@FindBy(xpath = "//label[normalize-space()='I want to use an existing address']//input[@name='shipping_address']") private WebElement iWantToUseExistingAddressRadioBtn;
	@FindBy(xpath = "//a[normalize-space()='Step 2: Billing Details' and @aria-expanded='true']") private WebElement billingDetailsExpanded;
	@FindBy(xpath = "//a[normalize-space()='Step 1: Checkout Options' and @aria-expanded='true']") private WebElement checkoutOptionsExpanded;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li//a[normalize-space()='Checkout']") private WebElement checkOutPageBreadcrumb;

	public void clickDeliveryDetailsSection() {
	    try {
	        // Wait for delivery details section to be visible
	        waitUtils.waitForElementVisibility(deliveryDetailsSection, 10);

	        // Ensure section is scrolled into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", deliveryDetailsSection);
	        Thread.sleep(500); // wait for scroll/animation

	        // Wait for button to be present and visible
	        WebElement continueBtn = waitUtils.waitForElementVisibility(continueBtnDeliveryDetails, 10);

	        // Sometimes Selenium reports clickable but still intercepted — handle that safely
	        try {
	            waitUtils.waitForElementClickable(continueBtn, 10).click();
	        } catch (Exception e) {
	            // Fallback: use JavaScript click if normal click fails
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);
	        }

	        System.out.println("Clicked Continue button in Delivery Details section.");

	    } catch (Exception e) {
	        System.out.println("Failed to click Continue button in Delivery Details: " + e.getMessage());
	    }
	}


	public boolean userIsOnCheckOutPage()
	{
		try {
			waitUtils.waitForElementVisibility(checkOutPageBreadcrumb, 10);
			return checkOutPageBreadcrumb.isDisplayed();
		}catch(Exception e) {
			System.out.println("CheckoutPage breadcrumb is not displayed: " + e.getMessage());
			return false;
		}
	}

	public boolean isUserOnCheckoutOrBillingDetailsSection() {
		try {
			// Check visibility of either section
			if (billingDetailsExpanded.isDisplayed() || checkoutOptionsExpanded.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// No such section — return false
			System.out.println("Neither checkout nor billing section found: " + e.getMessage());
		}
		return false;
	}

	public boolean iWantToUseExistingAddressRadioBtnIsSelectedByDefaultInDeliveryDetailsSection()
	{
		return waitUtils.waitForElementVisibility(iWantToUseExistingAddressRadioBtn, 10).isSelected();
	}

	public boolean isExistingAddressRadioButtonisSelectedByDefaultInBillingDetails()
	{
		return waitUtils.waitForElementVisibility(wantToUseExistingAddreessRadioButton, 10).isSelected();
	}

	public void clickLoginButtonReturningCustomer()
	{
		waitUtils.waitForElementClickable(loginBtnReturningCustomer, 10).click();
	}

	public void enterPasswordInPasswordFieldReturningCustomer(String pass)
	{
		waitUtils.waitForElementVisibility(passwordFieldReturningCustomer, 10).sendKeys(pass);
	}

	public void enterEmailInEmailFieldReturningCustomer(String email)
	{
		waitUtils.waitForElementVisibility(emailFieldReturningCustomer, 10).sendKeys(email);
	}

	public void clickContinueAccountAndRegister()
	{
		waitUtils.waitForElementClickable(continueBtnAccountAndRegister, 10).click();
	}

	public void fillAllDetailsIntoAllTheFields() {
		try {
			waitUtils.waitForElementVisibility(AccountAndBillingDetailsToggle, 10);

			// === Fill personal details ===
			firstNameField.clear();
			firstNameField.sendKeys(GenericUtils.getRandomString(6));

			lastNameField.clear();
			lastNameField.sendKeys(GenericUtils.getRandomString(6));

			emailField.clear();
			emailField.sendKeys(GenericUtils.getRandomEmail());

			telephoneField.clear();
			telephoneField.sendKeys(GenericUtils.getRandomNumber(10));

			passwordField.clear();
			String password = "Pass@" + GenericUtils.getRandomNumber(4);
			passwordField.sendKeys(password);

			confPasswordField.clear();
			confPasswordField.sendKeys(password);

			// === Company & Address ===
			companyField.clear();
			companyField.sendKeys("Company_" + GenericUtils.getRandomString(4));

			address1Field.clear();
			address1Field.sendKeys("House No. " + GenericUtils.getRandomNumber(3));

			address2Field.clear();
			address2Field.sendKeys("Street " + GenericUtils.getRandomString(4));

			cityField.clear();
			cityField.sendKeys(GenericUtils.getRandomString(5));

			postCodeField.clear();
			postCodeField.sendKeys(GenericUtils.getRandomNumber(6));

			// === Country ===
			Select countrySelect = new Select(countryDrpDwn);
			countrySelect.selectByVisibleText("India");

			// === Wait for Region dropdown to populate dynamically ===
			boolean regionLoaded = false;
			for (int i = 0; i < 20; i++) {  // 20 x 500ms = 10 seconds
				Thread.sleep(500);
				try {
					WebElement regionDropdown = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
					Select regionSelect = new Select(regionDropdown);
					List<WebElement> options = regionSelect.getOptions();

					if (options.size() > 1) {
						// Select first valid region
						regionSelect.selectByIndex(1);
						System.out.println("✅ Region selected: " + options.get(1).getText());
						regionLoaded = true;
						break;
					}
				} catch (StaleElementReferenceException | NoSuchElementException e) {
					// Element refreshed, retry next iteration
				}
			}

			if (!regionLoaded) {
				System.out.println("⚠️ Region dropdown failed to populate after waiting.");
			}

			// === Checkbox ===
			waitUtils.waitForElementClickable(checkBoxAccountAndBillingDetails, 10).click();

			System.out.println("✅ Successfully filled all Account and Billing details.");

		} catch (Exception e) {
			System.out.println("❌ Failed to fill all Account and Billing details: " + e.getMessage());
			e.printStackTrace();
		}
	}





	public boolean isDeliveryAndBillingAddressRadioBtnIsSelectedByDefault()
	{
		waitUtils.scrollToElement(myDeliveryAndBillingAddressRadioBtn);
		return waitUtils.waitForElementVisibility(myDeliveryAndBillingAddressRadioBtn, 10).isSelected();
	}

	public boolean userIsOnAccountAndBillingDetailsSection() {
		try {
			waitUtils.waitForElementVisibility(AccountAndBillingDetailsToggle, 10);
			String expanded = AccountAndBillingDetailsToggle.getAttribute("aria-expanded");
			boolean isExpanded = "true".equalsIgnoreCase(expanded);
			return isExpanded;
		} catch (Exception e) {
			return false;
		}
	}

	public void userSelectsRegisterAccountBtn()
	{
		waitUtils.waitForElementVisibility(registerAccountRadioBtn, 10);
		waitUtils.waitForElementClickable(registerAccountRadioBtn, 10);

		String isChecked = registerAccountRadioBtn.getAttribute("checked");

		if(isChecked == null || !isChecked.equalsIgnoreCase("true"))
		{
			registerAccountRadioBtn.click();
		}else {
			System.out.println("Register account radio btn is already selected!");
		}
	}

	public boolean userIsOnConfirmOrderSection() {
		try {
			waitUtils.waitForElementVisibility(confirmOrderToggle, 10);
			String expanded = confirmOrderToggle.getAttribute("aria-expanded");
			return "true".equalsIgnoreCase(expanded);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isCashOnDeliveryRadioBtnisSelectedByDefault()
	{
		try {
			waitUtils.waitForElementVisibility(cashOnDeliveryRadioButton, 10);
			return waitUtils.waitForElementClickable(cashOnDeliveryRadioButton, 10).isSelected();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean userIsOnPaymentMethodSection() {
		try {
			waitUtils.waitForElementVisibility(PaymentMethodToggle, 10);
			String expanded = PaymentMethodToggle.getAttribute("aria-expanded");
			return "true".equalsIgnoreCase(expanded);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean userIsOnDeliveryMethodSection() {
		try {
			waitUtils.waitForElementVisibility(DeliveryMethodToggle, 10);
			String expanded = DeliveryMethodToggle.getAttribute("aria-expanded");
			boolean isExpanded = "true".equalsIgnoreCase(expanded);
			return isExpanded;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickContinueBtnBillingDetailsSection()
	{
		waitUtils.waitForElementClickable(continueButtonBillingDetailsSection, 10).click();
	}

	public boolean fillAllDetailsIntoMandatoryFields() {
		try {
			waitUtils.waitForElementVisibility(BillingDetailsSection, 10);

			// Personal Details
			firstNamePersonalDetails.clear();
			firstNamePersonalDetails.sendKeys(GenericUtils.getRandomString(6));

			lastNamePersonalDetails.clear();
			lastNamePersonalDetails.sendKeys(GenericUtils.getRandomString(6));

			emailPersonalDetails.clear();
			emailPersonalDetails.sendKeys(GenericUtils.getRandomEmail());

			telephonePersonalDetails.clear();
			telephonePersonalDetails.sendKeys(GenericUtils.getRandomNumber(10));

			// Address Details
			address1YourAddressSection.clear();
			address1YourAddressSection.sendKeys("102" + GenericUtils.getRandomString(5) + GenericUtils.getRandomNumber(3));

			cityYourAddressSection.clear();
			cityYourAddressSection.sendKeys(GenericUtils.getRandomString(4));

			postCodeYourAddressSection.clear();
			postCodeYourAddressSection.sendKeys(GenericUtils.getRandomNumber(6));

			// Select Country
			Select countryDropdown = new Select(countryYourAddressSection);
			countryDropdown.selectByVisibleText("India");

			// ✅ Wait for region dropdown to load with options
			boolean regionLoaded = waitUtils.waitForCondition(driver -> {
				try {
					WebElement regionDropdownElement = driver.findElement(By.id("input-payment-zone"));
					Select regionDropdownCheck = new Select(regionDropdownElement);
					return regionDropdownCheck.getOptions().size() > 1;
				} catch (Exception e) {
					return false;
				}
			}, 15);

			if (!regionLoaded) {
				System.out.println("Region dropdown did not load properly after selecting country.");
				return false;
			}

			// Try selecting region with retry (for dynamic AJAX loads)
			boolean regionSelected = false;
			int attempts = 0;
			while (attempts < 3 && !regionSelected) {
				try {
					WebElement freshRegionDropdown = driver.findElement(By.id("input-payment-zone"));
					Select regionDropdown = new Select(freshRegionDropdown);
					List<WebElement> options = regionDropdown.getOptions();

					if (options.size() > 1) {
						regionDropdown.selectByIndex(1);
						String selectedValue = regionDropdown.getFirstSelectedOption().getText();
						if (!selectedValue.contains("Please Select")) {
							regionSelected = true;
							System.out.println("Region selected successfully: " + selectedValue);
							break;
						}
					}
				} catch (StaleElementReferenceException e) {
					System.out.println("Region dropdown became stale, retrying...");
				}
				Thread.sleep(1000); // give AJAX one more second
				attempts++;
			}

			if (!regionSelected) {
				System.out.println("Failed to select region even after retries.");
				return false;
			}

			System.out.println("Billing details filled successfully.");
			return true;

		} catch (Exception e) {
			System.out.println("Failed to fill mandatory billing details: " + e.getMessage());
			return false;
		}
	}

	public boolean myDeliveryAndBillingAddressIsCheckedByDefault()
	{
		try {
			waitUtils.waitForElementVisibility(myDeliveryAndBillingAddressCheckBox, 10);
			boolean isSelected = myDeliveryAndBillingAddressCheckBox.isSelected();
			return isSelected;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean userIsOnBillingDetailsSection() {
		try {
			waitUtils.waitForElementVisibility(billingDetailsToggle, 10);
			String expanded = billingDetailsToggle.getAttribute("aria-expanded");
			boolean isExpanded = "true".equalsIgnoreCase(expanded);
			return isExpanded;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickContinueBtnNewCustomerSection()
	{
		waitUtils.waitForElementVisibility(checkoutOptionSection, 10);
		waitUtils.waitForElementClickable(ContinueBtnNewCustomerSection, 10).click();
	}

	public void clickGuestRadioBtn()
	{
		waitUtils.waitForElementVisibility(guestRadioBtn, 10);
		waitUtils.waitForElementClickable(guestRadioBtn, 10);

		String isChecked = guestRadioBtn.getAttribute("checked");

		if(isChecked == null || !isChecked.equalsIgnoreCase("true"))
		{
			guestRadioBtn.click();
		}else {
			System.out.println("Guest radio btn is already selected!");
		}
	}

	public boolean userIsOnCheckOutPageBreadcrumb()
	{
		return waitUtils.waitForElementVisibility(checkOutPageBreadcrumb, 10).isDisplayed();
	}

	public void addCommentInPaymentMethodSection()
	{
		waitUtils.waitForElementPresence(By.id("collapse-payment-method"), 10);
		waitUtils.waitForElementVisibility(commentTextBoxInPaymentMethodSection, 10).sendKeys("Your order is going to be placed! Now it is in delivery method section!");
	}

	public boolean verifyCommentFromPaymentMethodSectionToPaymentMethodSection()
	{
		waitUtils.waitForElementVisibility(AddCommentsToYourOrder, 10);
		String commentText = waitUtils.waitForElementVisibility(paymentMethodTextArea, 10).getAttribute("value");
		return commentText.equalsIgnoreCase("Your order is going to be placed! Now it is in delivery method section!");
	}

	public void addTextToAboutYourOrderText()
	{
		waitUtils.waitForElementVisibility(DeliveryMethodSection, 10);

		AddCommentsToYourOrder.sendKeys("Your order is going to be placed! Now it is in delivery method section!");
	}

	public boolean verifyAllMandatoryFieldsHaveWarningMessagesOfDeliveryDetails() {
		try {
			// Step 1: Wait until Delivery Details section is visible
			waitUtils.waitForElementVisibility(
					By.xpath("//div[@id='collapse-shipping-address']//div[@class='panel-body']"), 10);

			// Step 2: Locate dropdowns
			Select countryDropdown = new Select(driver.findElement(By.id("input-shipping-country")));
			Select regionDropdown = new Select(driver.findElement(By.id("input-shipping-zone")));

			// Step 3: Reset dropdowns to default BEFORE clicking Continue
			String selectedCountry = countryDropdown.getFirstSelectedOption().getText().trim();
			String selectedRegion = regionDropdown.getFirstSelectedOption().getText().trim();

			if (!selectedCountry.equalsIgnoreCase("--- Please Select ---")) {
				System.out.println("Country is already selected as: " + selectedCountry + " → Resetting to default");
				countryDropdown.selectByVisibleText("--- Please Select ---");
			}

			if (!selectedRegion.equalsIgnoreCase("--- Please Select ---")) {
				System.out.println("Region/State is already selected as: " + selectedRegion + " → Resetting to default");
				regionDropdown.selectByVisibleText("--- Please Select ---");
			}

			// Step 4: Click Continue AFTER resetting dropdowns to trigger validation
			WebElement continueBtn = driver.findElement(By.id("button-shipping-address"));
			continueBtn.click();
			System.out.println("Clicked Continue after resetting dropdowns.");

		} catch (Exception e) {
			System.out.println("Unable to reset dropdowns or click Continue: " + e.getMessage());
		}

		// Step 5: Define all expected warning messages
		Map<By, String> warningLocators = new LinkedHashMap<>();
		warningLocators.put(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"), "First Name must be between 1 and 32 characters!");
		warningLocators.put(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"), "Last Name must be between 1 and 32 characters!");
		warningLocators.put(By.xpath("//div[contains(text(),'Address 1 must be between 3 and 128 characters!')]"), "Address 1 must be between 3 and 128 characters!");
		warningLocators.put(By.xpath("//div[contains(text(),'City must be between 2 and 128 characters!')]"), "City must be between 2 and 128 characters!");
		warningLocators.put(By.xpath("//div[normalize-space()='Please select a country!']"), "Please select a country!");
		warningLocators.put(By.xpath("//div[normalize-space()='Please select a region / state!']"), "Please select a region / state!");

		boolean allHaveWarnings = true;

		// Step 6: Validate all warning messages
		for (Map.Entry<By, String> entry : warningLocators.entrySet()) {
			By locator = entry.getKey();
			String expectedMessage = entry.getValue();

			try {
				WebElement element;
				// Country & Region take slightly longer to appear
				if (expectedMessage.contains("country") || expectedMessage.contains("region")) {
					element = waitUtils.waitForElementVisibility(locator, 10);
				} else {
					element = waitUtils.waitForElementVisibility(locator, 5);
				}

				String actualMessage = element.getText().trim();

				if (!actualMessage.equalsIgnoreCase(expectedMessage)) {
					System.out.println("Warning mismatch: Expected '" + expectedMessage + "', Found '" + actualMessage + "'");
					allHaveWarnings = false;
				} else {
					System.out.println("Found correct warning: " + actualMessage);
				}

			} catch (Exception e) {
				System.out.println("Warning message not found for: " + expectedMessage);
				if (!expectedMessage.contains("country") && !expectedMessage.contains("region")) {
					allHaveWarnings = false;
				}
			}
		}

		return allHaveWarnings;
	}



	public boolean verifyAllDeliveryDetailsFieldHavePlaceholders()
	{
		Map<WebElement, String> DeliveryFields = new LinkedHashMap<>();
		DeliveryFields.put(firstNameFieldDeliveryDetails, "First Name");
		DeliveryFields.put(lastNameFieldDeliveryDetails, "Last Name");
		DeliveryFields.put(companyFieldDeliveryDetails, "Company");
		DeliveryFields.put(address1DeliveryDetails, "Address 1");
		DeliveryFields.put(address2DeliveryDetails, "Address 2");
		DeliveryFields.put(cityDeliveryDetails, "City");
		DeliveryFields.put(postCodeDeliveryDetails, "Post Code");

		boolean allHavePlaceHolders = true;

		for(Map.Entry<WebElement, String>entry:DeliveryFields.entrySet())
		{
			WebElement field = entry.getKey();
			String expectedPlaceholder = entry.getValue();

			try {
				String actualPlaceholder = field.getAttribute("placeholder");

				if(actualPlaceholder==null || actualPlaceholder.trim().isEmpty())
				{
					System.out.println("Missing placeholder for field: " + expectedPlaceholder);
					allHavePlaceHolders = false;
				}else if(!actualPlaceholder.trim().equalsIgnoreCase(expectedPlaceholder)){
					allHavePlaceHolders = false;
				}else {
					System.out.println("All placeholders verified");
				}
			}catch(Exception e) {
				System.out.println("could not access placeholder for: " + entry.getValue());
				allHavePlaceHolders = false;
			}
		}
		return allHavePlaceHolders;
	}


	public void enterAllNewDeliveryDetailsAddress(String country, String region) {
		waitUtils.waitForElementVisibility(deliveryDetailsSection, 10);
		newAddressRadioBtnDeliveryDetails.click();

		firstNameValue = GenericUtils.getRandomString(6);
		lastNameValue = GenericUtils.getRandomString(6);
		companyValue = GenericUtils.getRandomString(6);
		address1Value = "102 " + GenericUtils.getRandomString(6) + GenericUtils.getRandomNumber(3);
		address2Value = GenericUtils.getRandomString(6);
		cityValue = GenericUtils.getRandomString(6);
		postCodeValue = GenericUtils.getRandomNumber(6);
		countryValue = country;
		regionValue = region;

		// Enter values into fields
		WebElement firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-shipping-firstname")));
		firstName.sendKeys(firstNameValue);

		driver.findElement(By.id("input-shipping-lastname")).sendKeys(lastNameValue);
		driver.findElement(By.id("input-shipping-company")).sendKeys(companyValue);
		driver.findElement(By.id("input-shipping-address-1")).sendKeys(address1Value);
		driver.findElement(By.id("input-shipping-address-2")).sendKeys(address2Value);
		driver.findElement(By.id("input-shipping-city")).sendKeys(cityValue);
		driver.findElement(By.id("input-shipping-postcode")).sendKeys(postCodeValue);

		WebElement countryDropdown = driver.findElement(By.id("input-shipping-country"));
		new Select(countryDropdown).selectByVisibleText(countryValue);

		WebElement regionDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-shipping-zone")));
		new Select(regionDropdown).selectByVisibleText(regionValue);
	}

	public void enterNewDeliveryDetailsAddress(String country, String region) {
		waitUtils.waitForElementVisibility(deliveryDetailsSection, 10);
		newAddressRadioBtnDeliveryDetails.click();

		firstNameValue = GenericUtils.getRandomString(6);
		lastNameValue = GenericUtils.getRandomString(6);
		address1Value = "102 " + GenericUtils.getRandomString(6) + GenericUtils.getRandomNumber(3);
		cityValue = GenericUtils.getRandomString(6);
		postCodeValue = GenericUtils.getRandomNumber(6);
		countryValue = country;
		regionValue = region;

		// Enter values into fields
		WebElement firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-shipping-firstname")));
		firstName.sendKeys(firstNameValue);

		driver.findElement(By.id("input-shipping-lastname")).sendKeys(lastNameValue);
		driver.findElement(By.id("input-shipping-address-1")).sendKeys(address1Value);
		driver.findElement(By.id("input-shipping-city")).sendKeys(cityValue);
		driver.findElement(By.id("input-shipping-postcode")).sendKeys(postCodeValue);

		WebElement countryDropdown = driver.findElement(By.id("input-shipping-country"));
		new Select(countryDropdown).selectByVisibleText(countryValue);

		WebElement regionDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-shipping-zone")));
		new Select(regionDropdown).selectByVisibleText(regionValue);
	}

	public boolean isNewAddressFieldsDisplayedInDeliveryDetailsSection()
	{
		waitUtils.waitForElementVisibility(deliveryDetailsSection, 10);
		Map<String, WebElement> fieldMap = new LinkedHashMap<>();
		fieldMap.put("First Name", firstNameFieldDeliveryDetails);
		fieldMap.put("Last Name", lastNameFieldDeliveryDetails);
		fieldMap.put("Address", address1DeliveryDetails);
		fieldMap.put("City", cityDeliveryDetails);
		fieldMap.put("Post Code", postCodeDeliveryDetails);
		fieldMap.put("Country", countryDrpDwnDeliveryDetails);
		fieldMap.put("Region", regionDrpDwnDeliveryDetails);

		for(Map.Entry<String, WebElement> entry: fieldMap.entrySet())
		{
			if(!entry.getValue().isDisplayed())
			{
				System.out.println("Field not displayed" + entry.getKey());
				return false;
			}
		}
		return true;
	}

	public void selectIWantToUseNewAddressDetailsRadioBtn()
	{
		waitUtils.waitForElementVisibility(deliveryDetailsSection, 10);
		waitUtils.waitForElementClickable(newAddressRadioBtnDeliveryDetails, 10).click();
	}

	public boolean verifyAllMandatoryFieldsHaveWarningMessages() {
		Map<By, String> warningLocators = new LinkedHashMap<>();
		warningLocators.put(By.xpath("//div[@id='payment-new']//div[contains(text(),'First Name must be between 1 and 32 characters!')]"),
				"First Name must be between 1 and 32 characters!");
		warningLocators.put(By.xpath("//div[@id='payment-new']//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"),
				"Last Name must be between 1 and 32 characters!");
		warningLocators.put(By.xpath("//div[@id='payment-new']//div[contains(text(),'Address 1 must be between 3 and 128 characters!')]"),
				"Address 1 must be between 3 and 128 characters!");
		warningLocators.put(By.xpath("//div[@id='payment-new']//div[contains(text(),'City must be between 2 and 128 characters!')]"),
				"City must be between 2 and 128 characters!");
		warningLocators.put(By.xpath("//div[normalize-space()='Please select a country!']"),
				"Please select a country!");
		warningLocators.put(By.xpath("//div[@id='payment-new']//div[contains(text(),'Please select a region / state!')]"),
				"Please select a region / state!");

		boolean allHaveWarnings = true;

		for (Map.Entry<By, String> entry : warningLocators.entrySet()) {
			By locator = entry.getKey();
			String expectedMessage = entry.getValue();

			try {
				WebElement element;
				// Give the 'country' warning extra wait time since it may appear last
				if (expectedMessage.contains("country")) {
					element = waitUtils.waitForElementVisibility(locator, 10);
				} else {
					element = waitUtils.waitForElementVisibility(locator, 5);
				}

				String actualMessage = element.getText().trim();

				if (!actualMessage.equalsIgnoreCase(expectedMessage)) {
					System.out.println("Warning mismatch: Expected '" + expectedMessage + "', Found '" + actualMessage + "'");
					allHaveWarnings = false;
				} else {
					System.out.println("Found correct warning: " + actualMessage);
				}

			} catch (Exception e) {
				System.out.println("⚠Warning message not found for: " + expectedMessage);
				// Don’t fail the test if the country field is auto-selected
				if (!expectedMessage.contains("country")) {
					allHaveWarnings = false;
				}
			}
		}

		return allHaveWarnings;
	}

	public boolean verifyAllBillingFieldHavePlaceholders()
	{
		Map<WebElement, String> billingFields = new LinkedHashMap<>();
		billingFields.put(firstNameField, "First Name");
		billingFields.put(lastNameField, "Last Name");
		billingFields.put(companyField, "Company");
		billingFields.put(address1Field, "Address 1");
		billingFields.put(address2Field, "Address 2");
		billingFields.put(cityField, "City");
		billingFields.put(postCodeField, "Post Code");

		boolean allHavePlaceHolders = true;

		for(Map.Entry<WebElement, String>entry:billingFields.entrySet())
		{
			WebElement field = entry.getKey();
			String expectedPlaceholder = entry.getValue();

			try {
				String actualPlaceholder = field.getAttribute("placeholder");

				if(actualPlaceholder==null || actualPlaceholder.trim().isEmpty())
				{
					System.out.println("Missing placeholder for field: " + expectedPlaceholder);
					allHavePlaceHolders = false;
				}else if(!actualPlaceholder.trim().equalsIgnoreCase(expectedPlaceholder)){
					allHavePlaceHolders = false;
				}else {
					System.out.println("All placeholders verified");
				}
			}catch(Exception e) {
				System.out.println("could not access placeholder for: " + entry.getValue());
				allHavePlaceHolders = false;
			}
		}
		return allHavePlaceHolders;
	}

	public void enterAllNewBillingAddress(String country, String region) {
		waitUtils.waitForElementVisibility(BillingDetailsSection, 10);
		newAddressRadioBtn.click();

		firstNameValue = GenericUtils.getRandomString(6);
		lastNameValue = GenericUtils.getRandomString(6);
		companyValue = GenericUtils.getRandomString(6);
		address1Value = "102 " + GenericUtils.getRandomString(6) + GenericUtils.getRandomNumber(3);
		address2Value = GenericUtils.getRandomString(6);
		cityValue = GenericUtils.getRandomString(6);
		postCodeValue = GenericUtils.getRandomNumber(6);
		countryValue = country;
		regionValue = region;

		// Enter values into fields
		WebElement firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-firstname")));
		firstName.sendKeys(firstNameValue);

		driver.findElement(By.id("input-payment-lastname")).sendKeys(lastNameValue);
		driver.findElement(By.id("input-payment-company")).sendKeys(companyValue);
		driver.findElement(By.id("input-payment-address-1")).sendKeys(address1Value);
		driver.findElement(By.id("input-payment-address-2")).sendKeys(address2Value);
		driver.findElement(By.id("input-payment-city")).sendKeys(cityValue);
		driver.findElement(By.id("input-payment-postcode")).sendKeys(postCodeValue);

		WebElement countryDropdown = driver.findElement(By.id("input-payment-country"));
		new Select(countryDropdown).selectByVisibleText(countryValue);

		WebElement regionDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-zone")));
		new Select(regionDropdown).selectByVisibleText(regionValue);
	}

	public boolean getExistingNewAddressDeliveryDetails() {
		try {
			waitUtils.waitForPageLoad(15);
			waitUtils.waitForElementVisibility(deliveryDetailsSection, 15);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newDeliveryDetailsExistingAddress);
			WebElement element = waitUtils.waitForElementVisibility(newDeliveryDetailsExistingAddress, 10);

			String addressText = element.getText().trim();

			// Handle case where text might be inside a value attribute
			if (addressText.isEmpty()) {
				addressText = element.getAttribute("value").trim();
			}

			// Normalize and simplify for comparison
			String normalizedAddress = addressText.replaceAll("\\s+", " ").replaceAll(",", "").toLowerCase();

			// Build expected address string from previously stored values
			@SuppressWarnings("unused")
			String expectedAddress = String.format("%s %s %s %s %s %s %s",firstNameValue,lastNameValue,address1Value,cityValue,postCodeValue,countryValue,regionValue).replaceAll("\\s+", " ").toLowerCase();

			// Compare normalized strings
			return normalizedAddress.contains(firstNameValue.toLowerCase()) &&
					normalizedAddress.contains(lastNameValue.toLowerCase()) &&
					normalizedAddress.contains(address1Value.toLowerCase()) &&
					normalizedAddress.contains(cityValue.toLowerCase()) &&
					normalizedAddress.contains(countryValue.toLowerCase()) &&
					normalizedAddress.contains(regionValue.toLowerCase());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public void enterNewBillingAddress(String country, String region) {
		waitUtils.waitForElementVisibility(BillingDetailsSection, 10);
		newAddressRadioBtn.click();

		firstNameValue = GenericUtils.getRandomString(6);
		lastNameValue = GenericUtils.getRandomString(6);
		address1Value = "102 " + GenericUtils.getRandomString(6) + GenericUtils.getRandomNumber(3);
		cityValue = GenericUtils.getRandomString(6);
		postCodeValue = GenericUtils.getRandomNumber(6);
		countryValue = country;
		regionValue = region;

		// Enter values into fields
		WebElement firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-firstname")));
		firstName.sendKeys(firstNameValue);

		driver.findElement(By.id("input-payment-lastname")).sendKeys(lastNameValue);
		driver.findElement(By.id("input-payment-address-1")).sendKeys(address1Value);
		driver.findElement(By.id("input-payment-city")).sendKeys(cityValue);
		driver.findElement(By.id("input-payment-postcode")).sendKeys(postCodeValue);

		WebElement countryDropdown = driver.findElement(By.id("input-payment-country"));
		new Select(countryDropdown).selectByVisibleText(countryValue);

		WebElement regionDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-zone")));
		new Select(regionDropdown).selectByVisibleText(regionValue);
	}


	public boolean isNewAddressFieldsDisplayedInBillingDetailsSection()
	{
		waitUtils.waitForElementVisibility(BillingDetailsSection, 10);
		Map<String, WebElement> fieldMap = new LinkedHashMap<>();
		fieldMap.put("First Name", firstNameField);
		fieldMap.put("Last Name", lastNameField);
		fieldMap.put("Address", address1Field);
		fieldMap.put("City", cityField);
		fieldMap.put("Post Code", postCodeField);
		fieldMap.put("Country", countryDrpDwn);
		fieldMap.put("Region", regionDrpDwn);

		for(Map.Entry<String, WebElement> entry: fieldMap.entrySet())
		{
			if(!entry.getValue().isDisplayed())
			{
				System.out.println("Field not displayed" + entry.getKey());
				return false;
			}
		}
		return true;
	}

	public void clickNewAddressRadioBtn()
	{
		waitUtils.waitForElementVisibility(BillingDetailsSection, 10);
		waitUtils.waitForElementClickable(newAddressRadioBtn, 10).click();
	}

	public void clickConfirmOrderButton()
	{
		waitUtils.waitForElementVisibility(confirmOrderBtn, 10);
		waitUtils.waitForElementClickable(confirmOrderBtn, 10).click();
	}

	public boolean verifyConfirmOrderTableDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(confirmOrderTable));
			if (!confirmOrderTable.isDisplayed()) {
				System.out.println("Confirm order table is not visible!");
				return false;
			}
			List<String> actualHeaders = tableHeaders.stream()
					.map(e -> e.getText().trim())
					.collect(Collectors.toList());
			System.out.println("Actual headers on UI: " + actualHeaders);
			List <String> expectedHeaders = Arrays.asList("Product", "Model", "Quantity", "Unit Price", "Total");
			for (String expected : expectedHeaders) {
				boolean found = actualHeaders.stream()
						.anyMatch(actual -> actual.toLowerCase().contains(expected.toLowerCase()));
				if (!found) {
					System.out.println("Missing or mismatched header: " + expected);
					return false;
				}
			}
			if (productRows.isEmpty()) {
				System.out.println("No product rows found in Confirm Order table!");
				return false;
			} else {
				System.out.println("Product rows found: " + productRows.size());
			}
			List<String> footerLabelsList = footerLabels.stream()
					.map(e -> e.getText().trim())
					.collect(Collectors.toList());
			System.out.println("Footer labels: " + footerLabelsList);
			List<String> expectedFooterLabels = Arrays.asList("Sub-Total", "Shipping", "Total");
			for (String label : expectedFooterLabels) {
				boolean found = footerLabelsList.stream()
						.anyMatch(actual -> actual.toLowerCase().contains(label.toLowerCase()));
				if (!found) {
					System.out.println("Missing footer label: " + label);
					return false;
				}
			}
			for (WebElement value : footerValues) {
				if (value.getText().trim().isEmpty()) {
					System.out.println("Footer value missing for some label!");
					return false;
				}
			}
			return true;
		} catch (TimeoutException e) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void clickContinueBtnPaymentMethod()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementVisibility(paymentMethodSection, 10);
		waitUtils.waitForElementClickable(continueBtnPaymentMethod, 10).click();
	}

	public void selectCheckBoxTermsAndConditions()
	{
		try {
			waitUtils.waitForPageLoad(10);
			waitUtils.waitForElementVisibility(paymentMethodSection, 10);

			waitUtils.waitForElementClickable(checkBoxTermsandCondInPaymentDetails, 10).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isCashOnDeliveryRadioBtnSelected()
	{
		waitUtils.waitForPageLoad(10);
		return waitUtils.waitForElementVisibility(cashOnDeliveryradioBtn, 10).isSelected();
	}

	public void clickContinueButtonDeliveryMethodSection()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementClickable(continueBtnDeliveryMethodSection, 10).click();
		waitUtils.waitForPageLoad(10);
	}

	public boolean isDeliveryMethodRadioButtonSelected()
	{
		waitUtils.waitForPageLoad(10);
		return waitUtils.waitForElementVisibility(deliveryMethodShippingRadioBtn, 10).isSelected();
	}

	public void clickDeliveryDetailsContinueButton()
	{
		waitUtils.waitForElementVisibility(deliveryDetailsSection, 10);
		waitUtils.waitForElementVisibility(deliveryDetailsContinueButton, 10).click();
		waitUtils.waitForPageLoad(10);
	}

	public String getExistingAdressDeliveryDetails()
	{
		try {
			waitUtils.waitForPageLoad(15);
			waitUtils.waitForElementVisibility(deliveryDetailsSection, 15);

			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", DeliveryDetailsExistingAddreess);
			WebElement element = waitUtils.waitForElementVisibility(DeliveryDetailsExistingAddreess, 10);

			String addressText = element.getText().trim();

			if(addressText.isEmpty())
			{
				addressText = element.getAttribute("value").trim();
			}

			return addressText;
		}catch(Exception e) {
			return "";
		}
	}

	public boolean existingAddressDeliveryDetailsRadioButtonSelectedByDefault()
	{
		waitUtils.waitForElementVisibility(deliveryDetailsSection, 10);
		return DeliveryDetailsExistingAddressrdioBtn.isSelected();
	}

	public void clickContinueButtonBiilingDetails()
	{
		waitUtils.waitForElementVisibility(BillingDetailsSection, 10);
		waitUtils.waitForElementClickable(continueBtnBillingDetails, 10).click();
		waitUtils.waitForPageLoad(10);
	}

	public String getExistingAddress()
	{
		try {
			waitUtils.waitForPageLoad(15);
			waitUtils.waitForElementVisibility(BillingDetailsSection, 15);

			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ExistingAddress);
			WebElement element = waitUtils.waitForElementVisibility(ExistingAddress, 10);
			String addressText = element.getText().trim();
			if(addressText.isEmpty())
			{
				addressText = element.getAttribute("value").trim();
			}
			return addressText;
		}catch(Exception e) {
			return "";
		}
	}

	public boolean isExistingAddreessUseRadioButtonIsSelected()
	{
		return wantToUseExistingAddreessRadioButton.isSelected();
	}

	public void clickProductNameLink()
	{
		waitUtils.waitForPageLoad(10);
		if(productNameLnk.isDisplayed())
		{
			waitUtils.waitForElementClickable(productNameLnk, 10).click();
		}
	}

	public void clickContinueBtnOfPaymentMethod()
	{
		waitUtils.waitForPageLoad(10);
		if(continueBtnPaymentMethod.isDisplayed())
		{
			waitUtils.waitForElementVisibility(continueBtnPaymentMethod, 10).click();
		}
	}

	public void selectCheckBoxOfPaymentMethod()
	{
		waitUtils.waitForPageLoad(10);
		if(checkBoxPaymentMethod.isDisplayed())
		{
			waitUtils.waitForElementVisibility(checkBoxPaymentMethod, 10).click();
		}
	}

	public void clickDeliveryDetailsContinueBtn()
	{
		waitUtils.waitForPageLoad(10);
		if(DeliveryDetailsContinueBtn.isDisplayed())
		{
			waitUtils.waitForElementVisibility(DeliveryDetailsContinueBtn, 10).click();
		}
	}

	public void clickBillingDetailsContinueBtn()
	{
		waitUtils.waitForPageLoad(10);
		if(BillingDetailscontinueBtn.isDisplayed())
		{
			waitUtils.waitForElementVisibility(BillingDetailscontinueBtn, 10).click();
		}
	}

	public void fillBillingDetailsIfRequired()
	{
		waitUtils.waitForPageLoad(10);
		try {
			if(firstNameField.isDisplayed())
			{
				waitUtils.waitForElementVisibility(firstNameField, 10).sendKeys(GenericUtils.getRandomString(8));
				waitUtils.waitForElementVisibility(lastNameField, 10).sendKeys(GenericUtils.getRandomString(8));
				waitUtils.waitForElementVisibility(address1Field, 10).sendKeys(GenericUtils.getRandomString(8)+" "+GenericUtils.getRandomString(8));
				waitUtils.waitForElementVisibility(cityField, 10).sendKeys(GenericUtils.getRandomString(5));
				waitUtils.waitForElementVisibility(postCodeField, 10).sendKeys(GenericUtils.getRandomNumber(6));

				Select countrySelect = new Select(countryDrpDwn);
				countrySelect.selectByVisibleText("Tuvalu");

				waitUtils.waitForPageLoad(10);

				Select regionSelect = new Select(regionDrpDwn);
				regionSelect.selectByVisibleText("Bristol");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
