package utilities;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	WebDriver driver;

	public WaitUtils(WebDriver driver)
	{
		this.driver=driver;
	}

	public boolean waitForCondition(Function<WebDriver, Boolean> condition, int timeoutInSeconds) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(Exception.class);

            return wait.until(condition);
        } catch (Exception e) {
            System.out.println("Condition not met within " + timeoutInSeconds + " seconds: " + e.getMessage());
            return false;
        }
    }

	public boolean isElementVisible(By locator, int timeoutInSeconds) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        return true;
	    } catch (TimeoutException e) {
	        return false;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}


	public WebElement waitForElementPresence(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void clickElementUsingJS(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}

	public static void waitForElementVisible(WebDriver driver, WebElement element, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementClickable(WebDriver driver, WebElement element, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForSeconds(int seconds) {
	    try {
	        Thread.sleep(seconds * 1000);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt(); // restore interrupt status
	        e.printStackTrace();
	    }
	}

	public void waitForTextChange(String cssSelector, String oldValue) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String newValue = driver.findElement(By.cssSelector(cssSelector)).getAttribute("src");
                return !newValue.equals(oldValue);
            }
        });
    }

	public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread sleep interrupted: " + e.getMessage());
        }
    }

	public void waitForTextToBePresentInElement(WebElement element, String expectedText, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    wait.until(driver -> {
	        String actualText = element.getText().replaceAll("[^0-9.]", "");
	        return actualText.equals(expectedText.replaceAll("[^0-9.]", ""));
	    });
	}

	public void waitForPageLoad(int timeOutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	    wait.until(webDriver -> ((JavascriptExecutor) webDriver)
	        .executeScript("return document.readyState").toString().equals("complete"));
	}

	public WebElement waitForElementVisibility(WebElement element, int timeoutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementClickable(WebElement element, int timeoutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElementVisibility(By locator, int timeoutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementClickable(By locator, int timeoutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public boolean waitForUrlContains(String fraction, int timeoutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.urlContains(fraction));
	}

	public WebElement fluentWaitForElement(By locator, int timeoutInSeconds, int pollingEveryMillis) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryMillis))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}

	public void scrollToElement(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToBottom() {
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scrollToTop() {
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}

	public void scrollByPixel(int x, int y) {
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	public void scrollHorizontally(int pixels) {
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], 0);", pixels);
	}

	public void scrollUsingActions(int pixelDown) {
	    Actions actions = new Actions(driver);
	    actions.scrollByAmount(0, pixelDown).perform();
	}

	public void scrollToElementAndClick(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	}

	public void scrollTillEndWithPause() throws InterruptedException {
	    long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
	    while (true) {
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(1000);
	        long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
	        if (newHeight == lastHeight) break;
	        lastHeight = newHeight;
	    }
	}

	public WebElement fluentWaitForElement(WebElement element, int timeoutInSeconds, int pollingEveryMillis) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryMillis))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		return wait.until(driver -> {
			if (element.isDisplayed()) {
				return element;
			}
			return null;
		});
	}

	public List<WebElement> waitForAllElementsVisible(List<WebElement> elements, int timeoutInSeconds) {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    } catch (TimeoutException e) {
        System.out.println("Timeout: Not all elements became visible within " + timeoutInSeconds + " seconds.");
        return Collections.emptyList();
    } catch (Exception e) {
        System.out.println("Exception in waitForAllElementsVisible: " + e.getMessage());
        return Collections.emptyList();
    }
}

	}
