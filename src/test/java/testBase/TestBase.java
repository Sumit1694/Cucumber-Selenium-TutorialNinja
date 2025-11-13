package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase
{
	public static String browserFromXml; // will be set once from runner

	public WebDriver driver;
	public DriverBaseSetup driverBaseSetup;
	public Properties prop;

	public TestBase()
	{
		driverBaseSetup = new DriverBaseSetup(driver);
	}
	// Main method used everywhere
	public WebDriver WebDriverManager() throws IOException
	{
		if (driver == null)
		{
			loadProperties();
			// Priority: XML browser > properties file browser
			String browser = (browserFromXml != null && !browserFromXml.isEmpty()) ? browserFromXml : prop.getProperty("browser");

			String url = prop.getProperty("QAurl");

			switch (browser.toLowerCase())
			{
			case "chrome": driver = driverBaseSetup.getChromeDriver(); break;
			case "firefox": driver = driverBaseSetup.getFireFoxDriver(); break;
			case "edge": driver = driverBaseSetup.getEdgeDriver(); break;
			default: throw new RuntimeException("Browser not supported: " + browser);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get(url);
			}
		return driver;
		}

	private void loadProperties() throws IOException
	{
		if (prop == null)
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\global.properties");
			prop = new Properties();
			prop.load(fis);
			}
		}
	}

