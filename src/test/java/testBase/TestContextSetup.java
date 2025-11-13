package testBase;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

import com.github.javafaker.Faker;

import pageObjects.PageObjectManager;
import utilities.GenericUtils;
import utilities.LoggerHelper;
import utilities.PasswordManager;
import utilities.WaitUtils;

public class TestContextSetup {

	public TestBase testBase;
	public PageObjectManager pageObjectManger;
	public GenericUtils genericUtils;
	public DriverBaseSetup driverBaseSetup;
	public WaitUtils waitUtils;
	public Actions actions;
	public Faker faker;
	public PasswordManager passwordManager;
	public String email;
    public String oldPassword;
    public String newPassword;
    public Logger log;

	public TestContextSetup() throws IOException
	{
		testBase = new TestBase();
		waitUtils = new WaitUtils(testBase.WebDriverManager());
		pageObjectManger = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
		driverBaseSetup = new DriverBaseSetup(testBase.WebDriverManager());
		actions = new Actions(testBase.WebDriverManager());
		faker = new Faker();
		passwordManager = new PasswordManager();

		//Initializing logger once
		log = LoggerHelper.getLogger(this.getClass());
		log.info("TestContextSetup initiated.");
	}
}
