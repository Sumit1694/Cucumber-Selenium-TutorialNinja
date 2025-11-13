package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SpecialOffersPage extends BasePage {

	public SpecialOffersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']/li[2]//a[normalize-space()='Special Offers']") private WebElement specialOffersPageBreadcrumb;
	@FindBy(xpath = "//div[contains(@class,'product-thumb')]") private List<WebElement> allProductsListedInSpecialOFfersPage;
	@FindBy(id = "input-sort") private WebElement sortByDropdown;
	@FindBy(xpath = "//div[contains(@class,'product-thumb')]//h4/a") private List<WebElement> productNames;
	@FindBy(xpath = "//div[contains(@class,'product-thumb')]//p[@class='price']") private List<WebElement> productPrices;
	@FindBy(xpath = "//div[contains(@class,'product-thumb')]//span[contains(@class,'rating')]") private List<WebElement> productRatings;

	private By oldPriceLocator = By.xpath(".//span[contains(@class,'price-old')]");
	private By newPriceLocator = By.xpath(".//span[contains(@class,'price-new')]");

	public boolean verifyOnlyActiveDiscountedProductsAreListed() {
	    try {
	        // Wait for all products to be visible
	        waitUtils.waitForAllElementsVisible(allProductsListedInSpecialOFfersPage, 10);
	        boolean allValidDiscounts = true;

	        for (WebElement product : allProductsListedInSpecialOFfersPage) {
	            // Fetch product name
	            String productName = "Unnamed Product";
	            try {
	                productName = product.findElement(By.xpath(".//h4/a")).getText().trim();
	            } catch (Exception e) {
	                // ignore
	            }

	            // Check for old and new price elements
	            boolean hasOldPrice = !product.findElements(oldPriceLocator).isEmpty();
	            boolean hasNewPrice = !product.findElements(newPriceLocator).isEmpty();

	            // Check if product shows signs of expiry or unavailability
	            boolean isExpired = false;
	            try {
	                String productText = product.getText().toLowerCase();
	                if (productText.contains("expired") || productText.contains("out of stock")) {
	                    isExpired = true;
	                }
	            } catch (Exception e) {
	                // safe fallback
	            }

	            // Validate conditions
	            if (hasOldPrice && hasNewPrice && !isExpired) {
	                System.out.println("Active discounted product verified: " + productName);
	            } else {
	                System.out.println("Invalid or expired product found: " + productName);
	                allValidDiscounts = false;
	            }
	        }

	        return allValidDiscounts;

	    } catch (StaleElementReferenceException e) {
	        System.out.println("Caught StaleElementReferenceException. Retrying...");
	        return verifyOnlyActiveDiscountedProductsAreListed(); // retry once
	    } catch (Exception e) {
	        System.out.println("Error while verifying discounted/expired products: " + e.getMessage());
	        return false;
	    }
	}

	public void clickFirstProductDisplayedInPage() {
	    try {
	        waitUtils.waitForElementClickable(specialOffersPageBreadcrumb, 10);

	        List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'product-thumb')]//h4/a"));
	        if (products.isEmpty()) {
	            System.out.println("No products found on Special Offers page.");
	            return;
	        }

	        WebElement firstProduct = products.get(0);
	        String parentWindow = driver.getWindowHandle();

	        new Actions(driver).moveToElement(firstProduct).click().perform();
	        System.out.println("Clicked on first product: " + firstProduct.getText());

	        // Switch to new window/tab if it opens
	        Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                System.out.println("Switched to product details window/tab");
	                break;
	            }
	        }

	    } catch (StaleElementReferenceException e) {
	        System.out.println("Stale element found. Retrying...");
	        clickFirstProductDisplayedInPage();
	    } catch (Exception e) {
	        System.out.println("Error while clicking on product: " + e.getMessage());
	    }
	}


	// ---------------------- MAIN METHOD ----------------------
	public boolean verifyAllSortingOptions() {
		try {
			List<String> allOptions = new Select(sortByDropdown).getOptions()
					.stream().map(WebElement::getText).collect(Collectors.toList());
			for (String optionText : allOptions) {
				System.out.println("🔹 Validating sort option: " + optionText);
				try {
					// Recreate dropdown reference each time to avoid staleness
					Select select = new Select(driver.findElement(By.id("input-sort")));
					select.selectByVisibleText(optionText);
					Thread.sleep(2000); // Wait for products to reload
					boolean isSorted = false;
					if (optionText.contains("Name")) {
						isSorted = verifySortingByName(optionText);
					} else if (optionText.contains("Price")) {
						isSorted = verifySortingByPrice(optionText);
					} else if (optionText.contains("Rating")) {
						isSorted = verifySortingByRating(optionText);
					} else if (optionText.contains("Model")) {
						isSorted = verifySortingByModel(optionText);
					} else {
						System.out.println("Skipping unsupported option: " + optionText);
						continue;
					}
					if (isSorted) {
						System.out.println("Sorting verified for: " + optionText);
					} else {
						System.out.println("Sorting failed for: " + optionText);
						return false;
					}
				} catch (StaleElementReferenceException e) {
					System.out.println("Stale element after selecting: " + optionText + " — retrying...");
					return verifyAllSortingOptions(); // retry once
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("Error verifying all Sort By options: " + e.getMessage());
			return false;
		}
	}
	// ---------------------- HELPER METHODS ----------------------
	private boolean verifySortingByName(String sortOption) {
		try {
			List<String> actual = driver.findElements(By.xpath("//div[contains(@class,'product-thumb')]//h4/a")).stream().map(WebElement::getText).collect(Collectors.toList());
			List<String> expected = new ArrayList<>(actual);
			if (sortOption.contains("A - Z")) Collections.sort(expected);
			else if (sortOption.contains("Z - A")) Collections.sort(expected, Collections.reverseOrder());
			return actual.equals(expected);
		} catch (StaleElementReferenceException e) {
			System.out.println("Retrying verifySortingByName...");
			return verifySortingByName(sortOption);
		}
	}

	private boolean verifySortingByPrice(String sortOption) {
		try {
			List<Double> actual = driver.findElements(By.xpath("//div[contains(@class,'product-thumb')]//p[@class='price']")).stream().map(WebElement::getText).map(this::extractPrice).collect(Collectors.toList());
			List<Double> expected = new ArrayList<>(actual);
			if (sortOption.contains("Low > High")) Collections.sort(expected);
			else if (sortOption.contains("High > Low")) Collections.sort(expected, Collections.reverseOrder());
			return actual.equals(expected);
		} catch (StaleElementReferenceException e) {
			System.out.println("Retrying verifySortingByPrice...");
			return verifySortingByPrice(sortOption);
		}
	}

	private boolean verifySortingByRating(String sortOption) {
		try {
			List<Integer> actual = driver.findElements(By.xpath("//div[contains(@class,'product-thumb')]//div[contains(@class,'rating')]")).stream().map(e -> e.findElements(By.xpath(".//span[@class='fa fa-star filled']")).size()).collect(Collectors.toList());
			List<Integer> expected = new ArrayList<>(actual);
			if (sortOption.contains("Highest")) Collections.sort(expected, Collections.reverseOrder());
			else Collections.sort(expected);
			return actual.equals(expected);
		} catch (StaleElementReferenceException e) {
			System.out.println("Retrying verifySortingByRating...");
			return verifySortingByRating(sortOption);
		}
	}

	private boolean verifySortingByModel(String sortOption) {
		try {
			List<String> actual = driver.findElements(By.xpath("//div[contains(@class,'product-thumb')]//div[@class='caption']/p[contains(text(),'Model')]")).stream().map(WebElement::getText).collect(Collectors.toList());
			List<String> expected = new ArrayList<>(actual);
			if (sortOption.contains("A - Z")) Collections.sort(expected);
			else if (sortOption.contains("Z - A")) Collections.sort(expected, Collections.reverseOrder());
			return actual.equals(expected);
		} catch (StaleElementReferenceException e) {
			System.out.println("Retrying verifySortingByModel...");
			return verifySortingByModel(sortOption);
		}
	}
	private Double extractPrice(String priceText) {
		try {
			String clean = priceText.replaceAll("[^0-9.]", "").trim();
			return Double.parseDouble(clean);
		} catch (Exception e) {
			return 0.0;
		}
	}

	public boolean verifyOldPriceStrikeThroughAndNewPriceHighlighted() {
		try {
			waitUtils.waitForAllElementsVisible(allProductsListedInSpecialOFfersPage, 10);

			for (WebElement product : allProductsListedInSpecialOFfersPage) {
				WebElement oldPrice = product.findElement(oldPriceLocator);
				WebElement newPrice = product.findElement(newPriceLocator);
				// Get CSS properties
				String textDecoration = oldPrice.getCssValue("text-decoration");
				String fontWeight = newPrice.getCssValue("font-weight");
				String color = newPrice.getCssValue("color");
				// Validate old price strike-through
				boolean isStrikeThrough = textDecoration.contains("line-through");
				// Validate new price highlighted (bold or bright color)
				boolean isHighlighted = Integer.parseInt(fontWeight) >= 600 || color.contains("rgba(201, 76, 76")  || color.contains("rgb(255, 0, 0)");
				if (!isStrikeThrough || !isHighlighted) {
					System.out.println("Price style not correct for product: " + product.getText());
					return false;
				}
			}
			System.out.println("All products show old price strike-through and new price highlighted.");
			return true;
		} catch (Exception e) {
			System.out.println("Error verifying price styling: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyAllDisplayedProductsAreDiscountedProducts() {
		try {
			// Wait for all products to be visible
			waitUtils.waitForAllElementsVisible(allProductsListedInSpecialOFfersPage, 10);
			boolean allDiscounted = true;
			for (WebElement product : allProductsListedInSpecialOFfersPage) {
				// Check if both old and new prices exist within each product block
				boolean hasOldPrice = !product.findElements(oldPriceLocator).isEmpty();
				boolean hasNewPrice = !product.findElements(newPriceLocator).isEmpty();
				// Get product name (optional, for log)
				String productName = "";
				try {
					productName = product.findElement(By.xpath(".//h4/a")).getText();
				} catch (Exception e) {
					productName = "Unnamed Product";
				}
				// Validate discount
				if (hasOldPrice && hasNewPrice) {
					System.out.println("Discounted product verified: " + productName);
				} else {
					System.out.println("Product without discount: " + productName);
					allDiscounted = false;
				}
			}
			return allDiscounted;
		} catch (Exception e) {
			System.out.println("Error while verifying discounted products: " + e.getMessage());
			return false;
		}
	}

	public boolean verifySpecialOffersPageBreadcrumbIsDisplayed()
	{
		try {
			return waitUtils.waitForElementVisibility(specialOffersPageBreadcrumb, 10).isDisplayed();
		}catch(Exception e) {
			System.out.println("special offers page breadcrumb is not displayed! " + e.getMessage());
			return false;
		}
	}

	public boolean clickSpecialOffersLinkAndMeasureLoadTime()
	{
		try {
			waitUtils.scrollToElement(driver.findElement(By.xpath("//a[text()='Specials']")));
			Actions actions = new Actions(driver);

			long startTime = System.currentTimeMillis();
			actions.moveToElement(driver.findElement(By.xpath("//a[text()='Specials']"))).pause(Duration.ofMillis(500)).click().perform();
			WebElement breadCrumb = waitUtils.waitForElementVisibility(specialOffersPageBreadcrumb, 10);
			long endTime = System.currentTimeMillis();
			long loadTime = endTime - startTime;
			System.out.println("Special offers page loaded in: " + loadTime + " ms");

			if(breadCrumb.isDisplayed() && loadTime<=5000)
			{
				System.out.println("page loaded successfully within acceptable time limit (<= 5 seconds).");
				return true;
			}else {
				System.out.println("Page took longer than epected to load: " + loadTime + " ms");
				return false;
			}
		}catch(Exception e) {
			System.out.println("Error measuring page load time: " + e.getMessage());
			return false;
		}
	}



}
