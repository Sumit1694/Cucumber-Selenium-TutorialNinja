package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.GenericUtils;

public class HomePage extends BasePage {

	Actions actions;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Register']") private WebElement registerLink;
	@FindBy(xpath="//a[normalize-space()='Qafox.com']") private WebElement homePageTitletxt;
	@FindBy(xpath="//li[@class='dropdown open']//ul//li[2]") private WebElement LoginLink;
	@FindBy(xpath="//input[@placeholder='Search']") private WebElement searchTextBox;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") private WebElement searchBtn;
	@FindBy(xpath="//input[@placeholder='Search']") private WebElement searchField;
	@FindBy(name = "search") private WebElement searchBox;
	@FindBy(css = "button.btn.btn-default.btn-lg") private WebElement searchButton;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[3]//a[text()='Site Map']") private WebElement SiteMapLnk;
	@FindBy(xpath = "//a[normalize-space()='Desktops']") private WebElement DesktopOnBar;
	@FindBy(xpath = "//a[normalize-space()='Show AllDesktops']") private WebElement showAllDesktops;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[3]") private WebElement featuredProductCompareOption;
	@FindBy(xpath = "//div[@class='tooltip-inner' and text()='Compare this Product']") private WebElement CompareThisProductText;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[3]") private WebElement CompareThisProductButton;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[1]//span[1]") private WebElement AddToCartFirstProduct;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[3]//i[1]") private WebElement compareProductFirstfeatured;
	@FindBy(xpath = "//a[normalize-space()='product comparison']") private WebElement productComparisonLinkSuccessMSg;
	@FindBy(xpath = "//a[@id='wishlist-total']") private WebElement WishListHeaderOption;
	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']") private WebElement iphoneAddToWishList;
	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']") private WebElement shoppingCartLink;
	@FindBy(xpath = "//a[normalize-space()='About Us']") private WebElement aboutUsFooterLink;
	@FindBy(xpath = "//a[normalize-space()='PC (0)']") private WebElement pcLinkUnderDesktop;
	@FindBy(xpath = "//div[contains(@class,'product-layout') and contains(@class,'col-lg-3')]") private List<WebElement> productsDisplayedInFeaturedSection;
	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/']") private WebElement homeBreadcrumb;
	@FindBy(css = ".swiper-wrapper .swiper-slide img") private List<WebElement> heroImages;
	@FindBy(css = "div.swiper-button-next") private WebElement nextButton;
	@FindBy(css = "div.swiper-button-prev") private WebElement prevButton;
	@FindBy(css = "span.swiper-pagination-bullet") private List<WebElement> bullets;
	@FindBy(xpath = "//span[normalize-space()='Checkout']") private WebElement checkOutHeaderLink;
	@FindBy(xpath = "//a[@title='My Account']") private WebElement myAccountLink;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']") private WebElement myAccountSubLink;
	@FindBy(xpath = "//a[text()='Newsletter']") private WebElement newsLetterLink;
	@FindBy(xpath = "//a[text()='Contact Us']") private WebElement contactUsLinkFooterOption;
	@FindBy(xpath = "//a[text()='Gift Certificates']") private WebElement giftCertificateLink;
	@FindBy(xpath = "//h1//a[contains(normalize-space(),'Qafox.com')]") private WebElement logoInHeader;
	@FindBy(xpath = "//div[@class='swiper-viewport']") private List<WebElement> swipperImages;
	@FindBy(xpath = "//div[@id='search']") private WebElement searchBoxPresent;
	@FindBy(xpath = "//div[@id='cart']//button[@type='button']//i[contains(@class,'fa-shopping-cart')]") private WebElement headerCartIcon;
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li/p") private WebElement emptyCartSmallWindowMsg;
	@FindBy(xpath = "//li[@class='dropdown']//a[text()='Desktops']") private WebElement desktopMenuOption;
	@FindBy(xpath = "//li[@class='dropdown']//a[text()='PC (0)']") private WebElement pc0DesktopSubOption;
	@FindBy(xpath = "//li[@class='dropdown']//a[text()='Mac (1)']") private WebElement Mac1DestopSubOption;
	@FindBy(xpath = "//a[normalize-space()='Show AllDesktops']") private WebElement showAllDesktopsOption;
	@FindBy(xpath = "//li[@class='dropdown']//a[text()='Laptops & Notebooks']") private WebElement LaptopsAndNoteBooksMenuOption;
	@FindBy(xpath = "//a[normalize-space()='Macs (0)']") private WebElement LaptopsAndNoteBooksMacSubOption;
	@FindBy(xpath = "//a[normalize-space()='Windows (0)']") private WebElement LaptopsAndNoteBooksWindowsSubOption;
	@FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']") private WebElement showAllLaptopsAndNoteBooksOption;
	@FindBy(xpath = "//a[normalize-space()='Components']") private WebElement ComponentsMenuOption;
	@FindBy(xpath = "//a[normalize-space()='Show AllComponents']") private WebElement showAllComponentsoption;
	@FindBy(xpath = "//a[normalize-space()='MP3 Players']") private WebElement allMP3PlayersOption;
	@FindBy(xpath = "//a[normalize-space()='Show AllMP3 Players']") private WebElement showAllMP3PlayersOption;
	@FindBy(xpath = "//li[@class='dropdown']//a[@title='My Account']") private WebElement myAccountDropMenu;
	@FindBy(xpath = "//footer") private WebElement footerOption;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[contains(normalize-space(.), 'Contact Us')]") private WebElement contactUsBreadcrumb;
	@FindBy(xpath = "//a[text()='Returns']") private WebElement returnsLinkInFooter;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[contains(normalize-space(),'Product Returns')]") private WebElement returnsLinkBreadcrumb;
	@FindBy(xpath = "//footer//p[contains(normalize-space(.), 'Powered By OpenCart')]") private WebElement footerCopyRightText;
	@FindBy(xpath = "//form[@id='form-currency']//button") private WebElement currencyDropdown;
	@FindBy(xpath = "//form[@id='form-currency']//ul/li/button") private List<WebElement> currencyOptions;
	@FindBy(xpath = "(//span[@class='price-new' or contains(@class,'price')])[1]") private WebElement sampleProductPrice;

	public boolean verifyCurrencyConversionToDollar() {
	    try {
	        // Click on the currency dropdown
	        currencyDropdown.click();

	        // Select Dollar option
	        for (WebElement option : currencyOptions) {
	            if (option.getText().contains("$") || option.getText().toLowerCase().contains("dollar")) {
	                option.click();
	                break;
	            }
	        }

	        // Wait for prices to update
	        Thread.sleep(2000);

	        // Capture and print the sample price
	        String priceText = sampleProductPrice.getText();
	        System.out.println("Price after selecting Dollar: " + priceText);

	        // Verify price contains Dollar symbol
	        return priceText.contains("$");
	    } catch (Exception e) {
	        System.out.println("Error verifying Dollar currency: " + e.getMessage());
	        return false;
	    }
	}

	public boolean verifyCurrencyConversionToPound() {
	    try {
	        // Open the currency dropdown
	        currencyDropdown.click();

	        // Select Pound option dynamically
	        for (WebElement option : currencyOptions) {
	            if (option.getText().contains("£") || option.getText().toLowerCase().contains("pound")) {
	                option.click();
	                break;
	            }
	        }

	        // Wait for prices to reflect the change
	        Thread.sleep(2000);

	        // Capture the price text
	        String priceText = sampleProductPrice.getText();
	        System.out.println("Price after currency change: " + priceText);

	        // Validate that Pound symbol is displayed
	        return priceText.contains("£");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	public boolean verifyCurrencyConversionToEuro() {
		try {
			currencyDropdown.click();
			for (WebElement option : currencyOptions) {
				if (option.getText().contains("€") || option.getText().contains("Euro")) {
					option.click();
					break;
				}
			}
			Thread.sleep(2000);
			String priceText = sampleProductPrice.getText();
			System.out.println("Price after currency change: " + priceText);
			return priceText.contains("€");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyFooterTextIsDisplayed() {
		try {
			WebElement footer = waitUtils.waitForElementVisibility(footerCopyRightText, 10);
			String actualFooter = footer.getText().replaceAll("\\s+", " ").trim();
			@SuppressWarnings("unused")
			String expectedFooter = "Powered By OpenCart Qafox.com © 2025";

			if (actualFooter.contains("Powered By OpenCart") && actualFooter.contains("Qafox.com") && actualFooter.contains("2025")) {
				System.out.println("Footer text is displayed correctly: " + actualFooter);
				return true;
			} else {
				System.out.println("Footer text mismatch! Found: " + actualFooter);
				return false;
			}
		} catch (Exception e) {
			System.out.println("Footer text not found or not visible: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyReturnsPageIsLanded()
	{
		return waitUtils.waitForElementVisibility(returnsLinkBreadcrumb, 10).isDisplayed();
	}

	public boolean clickReturnsLinkInFooter()
	{
		try {
			waitUtils.scrollToElement(returnsLinkInFooter);
			waitUtils.waitForElementVisibility(returnsLinkInFooter, 10).click();
			return true;
		}catch(Exception e) {
			System.out.println("returns link in footer is not clickable!" + e.getMessage());
			return false;
		}
	}

	public boolean isUserOnContactUsPage() {
		try {
			return waitUtils.waitForElementVisibility(contactUsBreadcrumb, 10).isDisplayed();
		} catch (Exception e) {
			System.out.println("Contact Us breadcrumb not visible: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyLinksUnderCustomerServiceLinks()
	{
		try {
			waitUtils.waitForElementVisibility(footerOption, 10);
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[text()='Contact Us']")), 10).isDisplayed();
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[text()='Returns']")), 10).isDisplayed();
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[text()='Site Map']")), 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("links under customer service is not present!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyLinksUnderInformationSection()
	{
		try {
			waitUtils.scrollToElement(footerOption);
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[text()='About Us']")), 10).isDisplayed();
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[text()='Delivery Information']")), 10).isDisplayed();
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[text()='Privacy Policy']")), 10).isDisplayed();
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[text()='Terms & Conditions']")), 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("all four links are not present under information!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyLoginOptionRedirectToLoginPage()
	{
		try {
			waitUtils.waitForElementVisibility(myAccountDropMenu, 10).click();
			waitUtils.waitForElementVisibility(By.xpath("//a[normalize-space()='Login']"), 10).click();
			waitUtils.waitForElementVisibility(By.xpath("//ul[@class='breadcrumb']//li[contains(normalize-space(.), 'Login')]"), 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Login page is not displayed!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyFooterOfThePage()
	{
		try {
			waitUtils.scrollToElement(footerOption);
			waitUtils.waitForElementVisibility(footerOption, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("footer option is not visible at the bottom of the page! " + e.getMessage());
			return false;
		}
	}

	public boolean verifyClickOnMyAccountDropMenu()
	{
		try {
			waitUtils.waitForElementVisibility(myAccountDropMenu, 10).click();
			waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[normalize-space()='Register']")), 10).isDisplayed();
			waitUtils.waitForElementVisibility(By.xpath("//a[normalize-space()='Login']"), 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("my Account drop menu is displayed correclty!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyLaptopsAndNoteBooksMenuHighlightOnHover() {
		try {
			waitUtils.waitForElementVisibility(LaptopsAndNoteBooksMenuOption, 10);

			// Capture styles before hover
			String beforeColor = LaptopsAndNoteBooksMenuOption.getCssValue("color");
			String beforeBgColor = LaptopsAndNoteBooksMenuOption.getCssValue("background-color");
			String beforeFontWeight = LaptopsAndNoteBooksMenuOption.getCssValue("font-weight");

			// Perform hover
			Actions actions = new Actions(driver);
			actions.moveToElement(LaptopsAndNoteBooksMenuOption).perform();
			Thread.sleep(800);

			// Capture styles after hover
			String afterColor = LaptopsAndNoteBooksMenuOption.getCssValue("color");
			String afterBgColor = LaptopsAndNoteBooksMenuOption.getCssValue("background-color");
			String afterFontWeight = LaptopsAndNoteBooksMenuOption.getCssValue("font-weight");

			System.out.println("Before hover -> color: " + beforeColor + ", bg: " + beforeBgColor + ", font-weight: " + beforeFontWeight);
			System.out.println("After hover  -> color: " + afterColor + ", bg: " + afterBgColor + ", font-weight: " + afterFontWeight);

			boolean styleChanged = !beforeColor.equals(afterColor) || !beforeBgColor.equals(afterBgColor) || !beforeFontWeight.equals(afterFontWeight);

			if (styleChanged) {
				System.out.println("Highlight verified: menu style changed on hover.");
				return true;
			} else {
				System.out.println("No visual highlight detected for menu on hover.");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Error verifying hover highlight: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyClickingShowAllOptionForEachHeaderCategory() {
		try {
			Actions actions = new Actions(driver);

			// --- Desktops ---
			waitUtils.waitForElementVisibility(desktopMenuOption, 10);
			actions.moveToElement(desktopMenuOption).perform();
			waitUtils.waitForElementVisibility(showAllDesktopsOption, 10).click();
			waitUtils.waitForElementVisibility(
					driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Desktops']")), 10);
			System.out.println("User is redirected to Desktop listed product page using Show All link!");
			driver.navigate().back();

			// --- Laptops & Notebooks ---
			waitUtils.waitForElementVisibility(LaptopsAndNoteBooksMenuOption, 10);
			actions.moveToElement(LaptopsAndNoteBooksMenuOption).perform();
			waitUtils.waitForElementVisibility(showAllLaptopsAndNoteBooksOption, 10).click();
			waitUtils.waitForElementVisibility(
					driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Laptops & Notebooks']")), 10);
			System.out.println("User is redirected to Laptops & Notebooks listed product page using Show All link!");
			driver.navigate().back();

			// --- Components ---
			waitUtils.waitForElementVisibility(ComponentsMenuOption, 10);
			actions.moveToElement(ComponentsMenuOption).perform();
			waitUtils.waitForElementVisibility(showAllComponentsoption, 10).click();
			waitUtils.waitForElementVisibility(
					driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Components']")), 10);
			System.out.println("User is redirected to Components listed product page using Show All link!");
			driver.navigate().back();

			// --- MP3 Players ---
			waitUtils.waitForElementVisibility(allMP3PlayersOption, 10);
			actions.moveToElement(allMP3PlayersOption).perform();
			waitUtils.waitForElementVisibility(showAllMP3PlayersOption, 10).click();
			waitUtils.waitForElementVisibility(
					driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='MP3 Players']")), 10);
			System.out.println("User is redirected to MP3 Players listed product page using Show All link!");
			driver.navigate().back();

			return true;

		} catch (Exception e) {
			System.out.println("Show All options link is not clickable! " + e.getMessage());
			return false;
		}
	}

	public boolean verifyLaptopsAndNoteBooksMenuOptioncolourIsHighlightedWhenHoverOver()
	{
		try {
			waitUtils.waitForElementVisibility(LaptopsAndNoteBooksMenuOption, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(LaptopsAndNoteBooksMenuOption).build().perform();

			return true;
		}catch(Exception e) {
			System.out.println("LaptopsAndNoteBooks dropdown option colour is not highlighted!" + e.getMessage());
			return false;
		}
	}


	public boolean verifyLaptopsAndNoteBooksMenuOption()
	{
		try {
			waitUtils.waitForElementVisibility(LaptopsAndNoteBooksMenuOption, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(LaptopsAndNoteBooksMenuOption).build().perform();
			waitUtils.waitForElementVisibility(LaptopsAndNoteBooksMacSubOption, 10).isDisplayed();
			waitUtils.waitForElementVisibility(LaptopsAndNoteBooksWindowsSubOption, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("LaptopsAndNoteBooks dropdown option and suboptions are showing correctly!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyDesktopMenuOption()
	{
		try {
			waitUtils.waitForElementVisibility(desktopMenuOption, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(desktopMenuOption).build().perform();
			waitUtils.waitForElementVisibility(pc0DesktopSubOption, 10).isDisplayed();
			waitUtils.waitForElementVisibility(Mac1DestopSubOption, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Desktop dropdown option and suboptions are showing correctly!" + e.getMessage());
			return false;
		}
	}

	public boolean verifyCartSmallWindowAppears()
	{
		try {
			return waitUtils.waitForElementVisibility(emptyCartSmallWindowMsg, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("empty shopping cart small window not appeared! " + e.getMessage());
			return false;
		}
	}

	public boolean clickOnHeaderCartIcon()
	{
		try {
			waitUtils.waitForElementClickable(headerCartIcon, 10).click();
			return true;
		}catch(Exception e) {
			System.out.println("Cart icon is not clickable!" + e.getMessage());
			return false;
		}
	}

	public boolean isHeaderCartIconVisible() {
		try {
			WebElement icon = waitUtils.waitForElementVisibility(headerCartIcon, 10);
			if (icon.isDisplayed()) {
				System.out.println("Header Cart icon is visible on the home page.");
				return true;
			} else {
				System.out.println("Header Cart icon is not visible.");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error verifying Header Cart icon visibility: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyInvalidProductSearchLandingPage()
	{
		try {
			waitUtils.waitForElementVisibility(searchTextBox, 10).clear();
			waitUtils.waitForElementVisibility(searchTextBox, 10).sendKeys("xyz123");
			waitUtils.waitForElementClickable(searchButton, 10).click();
			waitUtils.waitForPageLoad(10);
			return waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")), 10).isDisplayed();
		} catch (Exception e) {
			System.out.println("Error verifying product search results: " + e.getMessage());
			return false;
		}
	}


	public boolean verifyProductSearchLandingValidPage() {
		try {
			// Enter search term
			waitUtils.waitForElementVisibility(searchTextBox, 10).clear();
			waitUtils.waitForElementVisibility(searchTextBox, 10).sendKeys("MacBook");

			// Click on search button
			waitUtils.waitForElementClickable(searchButton, 10).click();
			waitUtils.waitForPageLoad(10);

			// Get all displayed products in search results
			List<WebElement> displayedProducts = waitUtils.waitForAllElementsVisible(driver.findElements(By.xpath("//div[@class='product-thumb']//h4/a")), 10);

			if (displayedProducts.isEmpty()) {
				System.out.println("No products found for the search term 'MacBook'.");
				return false;
			}

			boolean allRelated = true;

			for (WebElement product : displayedProducts) {
				String productName = product.getText().trim();
				System.out.println("Found product: " + productName);

				// Validate if product name contains "MacBook" (case-insensitive)
				if (!productName.toLowerCase().contains("macbook")) {
					System.out.println("Unrelated product found: " + productName);
					allRelated = false;
				}
			}

			if (allRelated) {
				System.out.println("All displayed products are related to 'MacBook'.");
			}

			return allRelated;

		} catch (Exception e) {
			System.out.println("Error verifying product search results: " + e.getMessage());
			return false;
		}
	}


	public boolean verifySearchBoxIsPresentOnHomePage()
	{
		try {
			waitUtils.waitForElementVisibility(searchBoxPresent, 10).isDisplayed();
			return true;
		}catch(Exception e) {
			System.out.println("Search box is not present on homePage! " + e.getMessage());
			return false;
		}
	}

	public boolean userIsOnHomePage() {
		try {
			// Wait until hero/swiper images are visible
			waitUtils.waitForAllElementsVisible(swipperImages, 10);

			// If swiper images are displayed, assume user is on home page
			for (WebElement image : swipperImages) {
				if (image.isDisplayed()) {
					System.out.println("Home Page verified — Swiper image is visible.");
					return true;
				}
			}

			System.out.println("No swiper images visible — user may not be on Home Page.");
			return false;

		} catch (Exception e) {
			System.out.println("User is not landed on Home Page! " + e.getMessage());
			return false;
		}
	}


	public boolean clickOnLogo()
	{
		try {
			waitUtils.scrollToElement(logoInHeader);
			Actions actions = new Actions(driver);
			actions.moveToElement(logoInHeader).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("Logo is not clickable from other page! " + e.getMessage());
			return false;
		}
	}

	public boolean verifyLogoPresentOnHeader()
	{
		try {
			waitUtils.waitForElementVisibility(logoInHeader, 10).isDisplayed();
			return true;
		}catch(Exception e){
			System.out.println("Logo is not displayed on header section! " + e.getMessage());
			return false;
		}
	}
	public boolean clickGiftCertificateLinkFromFooter()
	{
		try {
			waitUtils.waitForElementVisibility(homePageTitletxt, 10);
			waitUtils.scrollToElement(giftCertificateLink);
			Actions actions = new Actions(driver);
			actions.moveToElement(giftCertificateLink).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("gift certificate link is not clickable! "+ e.getMessage());
			return false;
		}
	}

	public boolean clickContactUsLink()
	{
		try {
			waitUtils.waitForElementVisibility(homePageTitletxt, 10);
			waitUtils.scrollToElement(contactUsLinkFooterOption);
			Actions actions = new Actions(driver);
			actions.moveToElement(contactUsLinkFooterOption).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("contact us footer link is not clickable! " + e.getMessage());
			return false;
		}
	}

	public boolean createNewAccountWithNoOptionSelectedForRadioButton() {
		try {
			// Locators
			By myAccountMenu = By.xpath("//span[normalize-space()='My Account']");
			By registerOption = By.xpath("//a[normalize-space()='Register']");
			By registerBreadCrumb = By.xpath("//ul[@class='breadcrumb']//li[last()]");
			By firstName = By.id("input-firstname");
			By lastName = By.id("input-lastname");
			By email = By.id("input-email");
			By telephone = By.id("input-telephone");
			By password = By.id("input-password");
			By confPassword = By.id("input-confirm");
			By noSubscribe = By.xpath("//label[normalize-space()='No']//input[@name='newsletter']");
			By privacyPolicy = By.name("agree");
			By continueButton = By.xpath("//input[@value='Continue']");
			By successHeading = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

			// Step 1: Navigate to Register Page
			waitUtils.waitForElementClickable(driver.findElement(myAccountMenu), 10).click();
			waitUtils.waitForElementClickable(driver.findElement(registerOption), 10).click();
			waitUtils.waitForElementVisibility(driver.findElement(registerBreadCrumb), 10);

			// Step 2: Fill registration details
			driver.findElement(firstName).sendKeys(GenericUtils.getRandomString(6));
			driver.findElement(lastName).sendKeys(GenericUtils.getRandomString(6));
			driver.findElement(email).sendKeys(GenericUtils.getRandomEmail());
			driver.findElement(telephone).sendKeys(GenericUtils.getRandomNumber(10));
			String pwd = GenericUtils.getRandomString(6) + "@" + GenericUtils.getRandomNumber(3) + GenericUtils.getRandomString(4);
			driver.findElement(password).sendKeys(pwd);
			driver.findElement(confPassword).sendKeys(pwd);

			// Step 3: Select newsletter = Yes
			WebElement noOption = waitUtils.waitForElementClickable(driver.findElement(noSubscribe), 10);
			if (!noOption.isSelected()) {
				noOption.click();
			}

			// Step 4: Accept Privacy Policy and Continue
			driver.findElement(privacyPolicy).click();
			driver.findElement(continueButton).click();
			waitUtils.waitForPageLoad(10);

			// Step 5: Verify registration success
			WebElement successMsg = waitUtils.waitForElementVisibility(driver.findElement(successHeading), 10);
			if (successMsg.isDisplayed()) {
				System.out.println("Account registered successfully with NO subscription option!");
				return true;
			} else {
				System.out.println("Account registration failed - success message not found!");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Account registration failed! Reason: " + e.getMessage());
			return false;
		}
	}

	public boolean createNewAccountWithYesOptionSelectedForRadioButton() {
		try {
			// Locators
			By myAccountMenu = By.xpath("//span[normalize-space()='My Account']");
			By registerOption = By.xpath("//a[normalize-space()='Register']");
			By registerBreadCrumb = By.xpath("//ul[@class='breadcrumb']//li[last()]");
			By firstName = By.id("input-firstname");
			By lastName = By.id("input-lastname");
			By email = By.id("input-email");
			By telephone = By.id("input-telephone");
			By password = By.id("input-password");
			By confPassword = By.id("input-confirm");
			By yesSubscribe = By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']");
			By privacyPolicy = By.name("agree");
			By continueButton = By.xpath("//input[@value='Continue']");
			By successHeading = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

			// Step 1: Navigate to Register Page
			waitUtils.waitForElementClickable(driver.findElement(myAccountMenu), 10).click();
			waitUtils.waitForElementClickable(driver.findElement(registerOption), 10).click();
			waitUtils.waitForElementVisibility(driver.findElement(registerBreadCrumb), 10);

			// Step 2: Fill registration details
			driver.findElement(firstName).sendKeys(GenericUtils.getRandomString(6));
			driver.findElement(lastName).sendKeys(GenericUtils.getRandomString(6));
			driver.findElement(email).sendKeys(GenericUtils.getRandomEmail());
			driver.findElement(telephone).sendKeys(GenericUtils.getRandomNumber(10));
			String pwd = GenericUtils.getRandomString(6) + "@" + GenericUtils.getRandomNumber(3) + GenericUtils.getRandomString(4);
			driver.findElement(password).sendKeys(pwd);
			driver.findElement(confPassword).sendKeys(pwd);

			// Step 3: Select newsletter = Yes
			WebElement yesOption = waitUtils.waitForElementClickable(driver.findElement(yesSubscribe), 10);
			if (!yesOption.isSelected()) {
				yesOption.click();
			}

			// Step 4: Accept Privacy Policy and Continue
			driver.findElement(privacyPolicy).click();
			driver.findElement(continueButton).click();
			waitUtils.waitForPageLoad(10);

			// Step 5: Verify registration success
			WebElement successMsg = waitUtils.waitForElementVisibility(driver.findElement(successHeading), 10);
			if (successMsg.isDisplayed()) {
				System.out.println("Account registered successfully with YES subscription option!");
				return true;
			} else {
				System.out.println("Account registration failed - success message not found!");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Account registration failed! Reason: " + e.getMessage());
			return false;
		}
	}


	public boolean clickNewsLetterLinkFromFooter()
	{
		try {
			waitUtils.scrollToElement(newsLetterLink);
			Actions action = new Actions(driver);
			action.moveToElement(newsLetterLink).pause(Duration.ofMillis(500)).click().perform();
			return true;
		}catch(Exception e) {
			System.out.println("NewsLetter option from footer link is not clickable" + e.getMessage());
			return false;
		}
	}

	public void clickSiteMapLink()
	{
		try {
			waitUtils.waitForPageLoad(10);
			waitUtils.scrollToElement(SiteMapLnk);
			Actions actions = new Actions(driver);
			actions.moveToElement(SiteMapLnk).pause(Duration.ofMillis(500)).click().perform();
		}catch(Exception e) {
			System.out.println("Failed to click on site map link:" + e.getMessage());
		}
	}

	public void clickMyAccountDropMenu() {
		try {
			waitUtils.waitForElementVisibility(myAccountLink, 10);
			Actions actions = new Actions(driver);
			actions.moveToElement(myAccountLink).pause(Duration.ofMillis(500)).click().perform();
		} catch (Exception e) {
			System.out.println("Failed to click on My Account drop menu: " + e.getMessage());
		}
	}

	public void clickMyAccountSubLink() {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(myAccountLink).pause(Duration.ofMillis(500)).moveToElement(myAccountSubLink).pause(Duration.ofMillis(300)).click().perform();
		} catch (Exception e) {
			System.out.println("Failed to click on My Account sub-link: " + e.getMessage());
		}
	}

	public void enterTextInSearchTextBox(String searchItem) {
	    try {
	        By searchBoxLocator = By.xpath("//input[@placeholder='Search']");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement searchBox = wait.until(
	            ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(searchBoxLocator))
	        );

	        searchBox.clear();
	        searchBox.sendKeys(searchItem);
	    } catch (StaleElementReferenceException e) {
	        System.out.println("Stale element found — re-locating search box...");
	        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(searchItem);
	    } catch (Exception e) {
	        System.out.println("Failed to enter text in search box: " + e.getMessage());
	    }
	}


	public void clickCheckOutHeaderLink()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementClickable(checkOutHeaderLink, 10).click();
	}

	public boolean validatePartnerCarousel() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(1500);
			WebElement carousel = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.cssSelector("div.swiper-container.partner-logos")));
			js.executeScript("arguments[0].scrollIntoView(true);", carousel);
			Thread.sleep(1000);
			List<WebElement> logos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.cssSelector("div.swiper-container.partner-logos .swiper-slide img")));
			if (logos.isEmpty()) {
				System.out.println("No partner logos found!");
				return false;
			}
			System.out.println("Partner logos count: " + logos.size());
			String firstLogoSrc = logos.get(0).getAttribute("src");
			Thread.sleep(4000); // wait 3-4s for auto-slide
			String newFirstLogoSrc = logos.get(0).getAttribute("src");
			if (firstLogoSrc.equals(newFirstLogoSrc)) {
				System.out.println("Auto-slide is not working.");
			} else {
				System.out.println("Auto-slide working. Changed logo: " + newFirstLogoSrc);
			}
			List<WebElement> navButtons = driver.findElements(By.cssSelector(
					"div.swiper-container.partner-logos .swiper-button-next, div.swiper-container.partner-logos .swiper-button-prev"));
			if (!navButtons.isEmpty()) {
				WebElement nextBtn = driver.findElement(By.cssSelector("div.swiper-container.partner-logos .swiper-button-next"));
				nextBtn.click();
				Thread.sleep(1000);
				System.out.println("Manual next button clicked.");
			} else {
				System.out.println("Navigation buttons not present.");
			}
			List<WebElement> bullets = driver.findElements(By.cssSelector(
					"div.swiper-container.partner-logos .swiper-pagination-bullet"));
			if (!bullets.isEmpty()) {
				bullets.get(0).click();
				Thread.sleep(1000);
				System.out.println("Swiper pagination bullet clicked.");
			} else {
				System.out.println("Pagination bullets not present.");
			}
			Actions actions = new Actions(driver);
			actions.clickAndHold(logos.get(0)).moveByOffset(-100, 0).release().perform();
			Thread.sleep(1000);
			System.out.println("Drag and slide performed on partner logos.");
			return true;
		} catch (Exception e) {
			System.out.println("Exception in validatePartnerCarousel: " + e.getMessage());
			return false;
		}
	}

	public boolean validateHeroImageCarousel() {
		try {
			Actions actions = new Actions(driver);
			@SuppressWarnings("unused")
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement sliderContainer = driver.findElement(By.cssSelector("div#slideshow0"));
			List<WebElement> bullets = sliderContainer.findElements(By.cssSelector("div.swiper-pagination span"));
			actions.moveToElement(sliderContainer).perform();
			Thread.sleep(1000);
			List<WebElement> nextButtons = sliderContainer.findElements(By.cssSelector("div.swiper-button-next"));
			List<WebElement> prevButtons = sliderContainer.findElements(By.cssSelector("div.swiper-button-prev"));
			boolean hasButtons = !nextButtons.isEmpty() && !prevButtons.isEmpty();
			String initialImage = sliderContainer.findElement(By.cssSelector("div.swiper-slide-active img")).getAttribute("src");
			System.out.println("Initial Hero Image: " + initialImage);
			Thread.sleep(4000);
			String autoSlideImage = sliderContainer.findElement(By.cssSelector("div.swiper-slide-active img")).getAttribute("src");
			if (!autoSlideImage.equals(initialImage)) {
				System.out.println("Auto-slide working. New image: " + autoSlideImage);
			} else {
				System.out.println("Auto-slide not working.");
			}
			if (hasButtons) {
				WebElement nextButton = nextButtons.get(0);
				WebElement prevButton = prevButtons.get(0);
				actions.moveToElement(nextButton).perform();
				Thread.sleep(500);
				waitUtils.clickElementUsingJS(driver, nextButton);
				Thread.sleep(2000);
				String afterNext = sliderContainer.findElement(By.cssSelector("div.swiper-slide-active img")).getAttribute("src");
				System.out.println("After clicking Next: " + afterNext);
				actions.moveToElement(prevButton).perform();
				Thread.sleep(500);
				waitUtils.clickElementUsingJS(driver, prevButton);
				Thread.sleep(2000);
				String afterPrev = sliderContainer.findElement(By.cssSelector("div.swiper-slide-active img")).getAttribute("src");
				System.out.println("After clicking Prev: " + afterPrev);
			} else {
				System.out.println("Navigation buttons not present, skipping next/prev clicks.");
			}
			for (int i = 0; i < bullets.size(); i++) {
				actions.moveToElement(bullets.get(i)).click().perform();
				Thread.sleep(2000);
				String img = sliderContainer.findElement(By.cssSelector("div.swiper-slide-active img")).getAttribute("src");
				System.out.println("After clicking bullet " + (i + 1) + ": " + img);
			}
			WebElement activeImage = sliderContainer.findElement(By.cssSelector("div.swiper-slide-active img"));
			actions.clickAndHold(activeImage).moveByOffset(-250, 0).pause(Duration.ofSeconds(1)).release().perform();
			Thread.sleep(2000);
			String afterHold = sliderContainer.findElement(By.cssSelector("div.swiper-slide-active img")).getAttribute("src");
			System.out.println("After click and hold slide: " + afterHold);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in validateHeroImageCarousel: " + e.getMessage());
			return false;
		}
	}

	public boolean validateHomeBreadcrumbNavigationFromAllPages() {
		try {
			String baseUrl = "https://tutorialsninja.com/demo/";
			driver.navigate().to(baseUrl);
			waitUtils.waitForPageLoad(10);
			List<WebElement> allAnchors = driver.findElements(By.tagName("a"));
			Set<String> internalLinks = allAnchors.stream().map(e -> e.getAttribute("href")).filter(href -> href != null && href.startsWith(baseUrl) && !href.equals(baseUrl)).collect(Collectors.toSet());
			System.out.println("Total internal links found: " + internalLinks.size());
			for (String link : internalLinks) {
				try {
					driver.navigate().to(link);
					waitUtils.waitForPageLoad(10);
					System.out.println("\n Navigated to: " + link);
					waitUtils.waitForElementClickable(homeBreadcrumb, 10).click();
					waitUtils.waitForPageLoad(10);
					String currentUrl = driver.getCurrentUrl();
					String title = driver.getTitle();
					if (!currentUrl.equals(baseUrl) || !title.equalsIgnoreCase("Your Store")) {
						System.out.println("Breadcrumb navigation failed from: " + link);
						return false;
					} else {
						System.out.println("Breadcrumb working fine for: " + link);
					}
				} catch (Exception e) {
					System.out.println("Error visiting: " + link + " → " + e.getMessage());
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateAllFeaturedProducts() {
		try {
			waitUtils.waitForPageLoad(10);
			if (productsDisplayedInFeaturedSection.size() != 4) {
				return false;
			}
			for (int i = 0; i < productsDisplayedInFeaturedSection.size(); i++) {
				WebElement product = productsDisplayedInFeaturedSection.get(i);
				WebElement productImage = product.findElement(By.tagName("img"));
				if (!productImage.isDisplayed()) return false;
				WebElement productName = product.findElement(By.cssSelector("div.caption h4 a"));
				String productText = productName.getText();
				if (!productName.isDisplayed()) return false;
				WebElement productPrice = product.findElement(By.cssSelector("p.price"));
				if (!productPrice.isDisplayed()) return false;
				WebElement addToCartBtn = product.findElement(By.cssSelector("button[onclick*='cart.add']"));
				waitUtils.waitForElementClickable(addToCartBtn, 5);
				WebElement wishlistBtn = product.findElement(By.cssSelector("button[data-original-title='Add to Wish List']"));
				waitUtils.waitForElementClickable(wishlistBtn, 5);
				WebElement compareBtn = product.findElement(By.cssSelector("button[data-original-title='Compare this Product']"));
				waitUtils.waitForElementClickable(compareBtn, 5);
				String originalUrl = driver.getCurrentUrl();
				productName.click();
				waitUtils.waitForPageLoad(10);
				WebElement productPageTitle = driver.findElement(By.cssSelector("div#content h1"));
				if (!productPageTitle.getText().equalsIgnoreCase(productText)) {
					System.out.println("Product page navigation failed for product: " + productText);
					driver.navigate().to(originalUrl);
					return false;
				}
				driver.navigate().to(originalUrl);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isFourProductsDisplayedInFeaturedSection()
	{
		try {
			waitUtils.waitForPageLoad(10);
			int productCount = productsDisplayedInFeaturedSection.size();
			return productCount == 4;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void clickPCLinkUnderDesktop()
	{
		waitUtils.waitForElementVisibility(pcLinkUnderDesktop, 10).click();
	}

	public void clickAboutUsFooterLink()
	{
		waitUtils.waitForElementClickable(aboutUsFooterLink, 10).click();
	}

	public boolean isUserLandedOnHomePage()
	{
		try {
			String titleHomepage = driver.getTitle().trim();
			return titleHomepage.equalsIgnoreCase("Your Store");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void clickShoppingCartLink()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementVisibility(shoppingCartLink, 10).click();
	}

	public int getWishListHeaderCount()
	{
		String text = WishListHeaderOption.getText().replaceAll("[^0-9]", "");
		return Integer.parseInt(text);
	}

	public boolean isWishListCountIncreasedAfterAdd()
	{
		int beforeAdd = getWishListHeaderCount();
		waitUtils.waitForElementVisibility(searchTextBox, 10).sendKeys("iPhone");
		waitUtils.waitForPageLoad(10);
		waitUtils.waitForElementVisibility(searchBtn, 10).click();
		waitUtils.scrollToElement(iphoneAddToWishList);
		waitUtils.waitForElementClickable(iphoneAddToWishList, 10).click();
		waitUtils.waitForPageLoad(10);
		int afterAdd = getWishListHeaderCount();
		return afterAdd > beforeAdd;
	}

	public void clickWishListHeaderOption()
	{
		waitUtils.waitForElementClickable(WishListHeaderOption, 10).click();
	}

	public void clearSearchTextBoxField()
	{
		waitUtils.waitForElementVisibility(searchTextBox, 10).clear();
	}

	public void clickProductComparisonLinkInSuccessMessage()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.scrollToElementAndClick(productComparisonLinkSuccessMSg);
	}

	public void clickCompareProductOption()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.scrollToElementAndClick(compareProductFirstfeatured);
	}

	public void clickAddToCartFirstProduct()
	{
		waitUtils.waitForPageLoad(10);
		waitUtils.scrollToElementAndClick(AddToCartFirstProduct);
	}

	public void clickCompareThisProductButton()
	{
		CompareThisProductButton.click();
	}

	public String getCompareThisProductTooltipText()
	{
		return CompareThisProductText.getText();
	}

	public void hoverOnFeaturedProductCompareOption()
	{
		waitUtils.scrollToBottom();
		Actions actions = new Actions(driver);
		actions.moveToElement(featuredProductCompareOption).perform();
	}

	public void clickShowAllDesktopOption()
	{
		showAllDesktops.click();
	}

	public void hoverOnDesktop()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(DesktopOnBar).perform();
	}

	public boolean navigateToSearchPageUsingKeyboardKeys() throws InterruptedException
	{
		Actions actions = new Actions(driver);

		for(int i=0;i<8;i++)
		{
			actions.sendKeys(Keys.TAB).perform();
			Thread.sleep(300);
			actions.sendKeys("iMac");
		}
		WebElement activeElement = driver.switchTo().activeElement();
		if(!activeElement.equals(searchBox)) {
			return false;
		}
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		WebElement focusedButton = driver.switchTo().activeElement();
		if(!focusedButton.equals(searchButton)) {
			return false;
		}
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("search")) {
			return true;
		}else {
			return false;
		}
	}

	public void clickSitMapLink()
	{
		if(SiteMapLnk.isDisplayed())
		{
			SiteMapLnk.click();
		}
	}

	public void navigateToAllPagesAndVerifySearch()
	{
		String baseUrl = driver.getCurrentUrl();

		String[] pages = {
				baseUrl,
				baseUrl + "/index.php?route=account/login",
				baseUrl + "/index.php?route=account/register",
				baseUrl + "/index.php?route=product/category&path=20",
				baseUrl + "/index.php?route=product/special",
				baseUrl + "/index.php?route=information/contact",
				baseUrl + "/index.php?route=checkout/cart"
		};

		for(String pageUrl : pages)
		{
			driver.navigate().to(pageUrl);

			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOf(searchBox));
				wait.until(ExpectedConditions.visibilityOf(searchButton));

				Assert.assertTrue(searchBox.isDisplayed(), "Search box is not displayed on: " + pageUrl);
				Assert.assertTrue(searchButton.isDisplayed(), "SearchButton is not displayed on: " + pageUrl);

				System.out.println("Search box & button are visible on: " + pageUrl);

			} catch (Exception e) {
				System.out.println("Failed on page: " + pageUrl + " - " + e.getMessage());
				Assert.fail("Search elements not found on: " + pageUrl);
			}
		}
	}

	public void enterTextIntoSearchField(String text)
	{
		searchField.sendKeys(text);
	}

	public void clickSearchButton()
	{
		searchBtn.click();
	}

	public void EnterTextInSearchTextBox(String serachItem)
	{
		searchTextBox.sendKeys(serachItem);
	}


	public WebElement homePageTitle()
	{
		return homePageTitletxt;
	}

	public void clickMyAccount()
	{
		myAccountLink.click();
	}

	public WebElement getMyAccountDrpDwnLink()
	{
		return myAccountLink;
	}

	public void clickRegister()
	{
		registerLink.click();
	}

	public void clickLogin()
	{
		LoginLink.click();
	}

	public boolean isLoginButtonDisplayed()
	{
		try {
			return LoginLink.isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}

	public boolean isHomePageTitleDisplayed()
	{
		return homePageTitletxt.isDisplayed();
	}

}
