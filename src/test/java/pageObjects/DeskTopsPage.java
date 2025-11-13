package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeskTopsPage extends BasePage {

	public DeskTopsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[3]") private WebElement MacSubCategory;
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']") private WebElement addToCartButton;
	@FindBy(xpath = "//a[@id='compare-total']") private WebElement productCompareLink;

	public void clickProductCompareLink() {
	    By compareLinkLocator = By.xpath("//a[@id='compare-total']");

	    for (int attempt = 0; attempt < 2; attempt++) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(compareLinkLocator));
	            element.click();
	            System.out.println("Clicked on Product Compare link successfully.");
	            return;
	        }
	        catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException on Product Compare link. Retrying... Attempt " + (attempt + 1));
	        }
	        catch (ElementClickInterceptedException e) {
	            System.out.println("ElementClickInterceptedException on Product Compare link. Using JS click... Attempt " + (attempt + 1));
	            try {
	                WebElement element = driver.findElement(compareLinkLocator);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	                Thread.sleep(300);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	                System.out.println("Clicked on Product Compare link using JavaScript.");
	                return;
	            } catch (Exception jsEx) {
	                System.out.println("JS click retry failed: " + jsEx.getMessage());
	            }
	        }
	        catch (TimeoutException e) {
	            System.out.println("Timeout waiting for Product Compare link. Retrying... Attempt " + (attempt + 1));
	        }
	        catch (Exception e) {
	            throw new RuntimeException("Unexpected error while clicking Product Compare link", e);
	        }
	    }

	    throw new RuntimeException("Failed to click Product Compare link after multiple attempts.");
	}

	public void clickMacSubCategory()
	{
		waitUtils.waitForElementClickable(MacSubCategory, 10).click();
	}

	public void clickAddToCartButton()
	{
		waitUtils.waitForElementClickable(addToCartButton, 10).click();
	}


}
