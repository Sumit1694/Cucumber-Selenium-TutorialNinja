package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {

	static WebDriver driver;

	@SuppressWarnings("static-access")
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}

	public void resetSearchPage() {
	   driver.get("https://tutorialsninja.com/demo/");
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equals("complete"));
	}

	public static String getRandomString(int length)
	{
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for(int i=0;i<length;i++)
		{
			sb.append(characters.charAt(random.nextInt(characters.length())));
		}
		return sb.toString();
	}

	public static String getRandomNumber(int length)
	{
		String numbers = "0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for(int i=0;i<length;i++)
		{
		sb.append(numbers.charAt(random.nextInt(numbers.length())));
		}
		return sb.toString();
	}

	public static String getRandomEmail()
	{
		return "user_" + UUID.randomUUID().toString().substring(0,5) +"@test.com";
	}

	//Reading properties file where all invalid emails are added

	public static String FILE_PATH = System.getProperty("user.dir") + "/src/test/testdata/invalidEmailAddress.properties";
	public static List<String> getInvalidEmails() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(FILE_PATH);
		properties.load(fis);
		fis.close();

		return properties.values().stream().map(Object::toString).collect(Collectors.toList());
	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
            File destFile = new File(dest);
            FileUtils.copyFile(src, destFile);
            return dest;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }}

	public static void hoverAndClick(WebElement parent, WebElement child) {
        Actions action = new Actions(driver);
        action.moveToElement(parent).perform();
        child.click();
    }

	public static boolean compareImages(String expectedPath, String actualPath) throws IOException {
        BufferedImage expectedImg = ImageIO.read(new File(expectedPath));
        BufferedImage actualImg = ImageIO.read(new File(actualPath));

        if (expectedImg.getWidth() != actualImg.getWidth() || expectedImg.getHeight() != actualImg.getHeight()) {
            return false;
        }

        for (int y = 0; y < expectedImg.getHeight(); y++) {
            for (int x = 0; x < expectedImg.getWidth(); x++) {
                if (expectedImg.getRGB(x, y) != actualImg.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

	public static String getBeforeContent(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String content = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", element);
		return content.replace("\"", "");
	}

	public static String getBeforeColor(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", element);
	}

 //Created Object for MockDataBase
	public static MockDatabase mockDB = new MockDatabase();

    public static MockDatabase getMockDatabase()
    {
    	return mockDB;
    }

    public static String lastGeneratedEmail;
    public static String getRandomEmail1()
    {
    	lastGeneratedEmail = "user" + System.currentTimeMillis()+"@test.com";
    	return lastGeneratedEmail;
    }

    public static String getLastGeneratedEmail()
    {
    	return lastGeneratedEmail;
    }

	public static void saveUserInMockDB(String firstName,String lastName,String email,String telephone,String password,String confPassword)
	{
		GenericUtils.getMockDatabase().saveUser(firstName, lastName, email, telephone, password, confPassword);
	}

    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
