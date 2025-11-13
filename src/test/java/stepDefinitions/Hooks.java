package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBase.TestContextSetup;

public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        testContextSetup.log.info("------ Starting Scenario: " + scenario.getName() + " ------");
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetup.testBase.WebDriverManager();

        if (scenario.isFailed()) {
            // Take screenshot
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create folder if not exists
            String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots/";
            Files.createDirectories(Paths.get(screenshotDir));

            // Save with scenario name
            String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".png";
            File destinationPath = new File(screenshotDir + screenshotName);
            FileUtils.copyFile(sourcePath, destinationPath);

            // Attach to Cucumber report
            byte[] fileContent = FileUtils.readFileToByteArray(destinationPath);
            scenario.attach(fileContent, "image/png", scenario.getName());

            testContextSetup.log.error("Scenario failed: " + scenario.getName());
            testContextSetup.log.error("Screenshot saved at: " + destinationPath.getAbsolutePath());
        }
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        testContextSetup.log.info("------ Ending Scenario: " + scenario.getName() + " ------");
        WebDriver driver = testContextSetup.testBase.WebDriverManager();
        if (driver != null) {
            driver.quit();
        }
    }
}
