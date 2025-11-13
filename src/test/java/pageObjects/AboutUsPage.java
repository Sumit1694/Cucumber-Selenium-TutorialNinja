package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage {

	public AboutUsPage(WebDriver driver) {
		super(driver);
		log.info("AboutUsPage initiated!");
	}

	@FindBy(xpath = "//a[normalize-space()='Qafox.com']") private WebElement homePageLogo;
	@FindBy(xpath = "//ul[@class='breadcrumb']//li[contains(normalize-space(),'About Us')]") private WebElement aboutUsPageBreadCrumb;

	public boolean verifyUserLandsOnAboutUsPage()
	{
		try {
			log.info("waiting for about us footer section link to appear!");
			WebElement aboutUsFooterLink = waitUtils.waitForElementVisibility(driver.findElement(By.xpath("//a[normalize-space()='About Us']")), 10);
			log.info("scrolling down for about us footer section link to appear!");
			waitUtils.scrollToElement(aboutUsFooterLink);
			log.info("clicking on about us footer link!");
			Actions actions = new Actions(driver);
			actions.moveToElement(aboutUsFooterLink).click().perform();
			waitUtils.waitForPageLoad(10);
			log.info("waiting for about us page to load until breadcrumb is displayed!");
			return waitUtils.waitForElementVisibility(aboutUsPageBreadCrumb, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("User is not landed on about us page!" + e.getMessage());
			return false;
		}
	}

	public void clickHomePageLogo()
	{
		log.info("waiting for homepage logo to load and clicking on it!");
		waitUtils.waitForElementClickable(homePageLogo, 10).click();
	}

	public boolean isUserLandedOnAboutUsPage()
	{
		try {
			log.info("fetching title of about us page!");
			String aboutUsPageTitle = driver.getTitle();
			log.info("matching actual title of about us page with expected title!");
			return aboutUsPageTitle.equalsIgnoreCase("About Us");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
