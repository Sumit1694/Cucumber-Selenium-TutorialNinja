package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBaseSetup {

	WebDriver driver;

	public DriverBaseSetup(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebDriver getChromeDriver()
	{
		driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getFireFoxDriver()
	{
		driver = new FirefoxDriver();
		return driver;
	}

	public WebDriver getEdgeDriver()
	{
		driver = new EdgeDriver();
		return driver;
	}


}
