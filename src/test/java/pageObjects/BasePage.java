package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.LoggerHelper;
import utilities.WaitUtils;

public class BasePage {

	protected WebDriver driver;
	protected WaitUtils waitUtils;
	protected Logger log;

	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		this.waitUtils = new WaitUtils(driver);
		this.log = LoggerHelper.getLogger(this.getClass());
		PageFactory.initElements(driver, this);
	}

}
