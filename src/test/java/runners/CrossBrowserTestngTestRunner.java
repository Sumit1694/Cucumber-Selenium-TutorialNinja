package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import testBase.TestBase;

@CucumberOptions(features="src/test/java/features/ContactUsFunctionality.feature",glue="stepDefinitions",monochrome=true,dryRun=false,tags="@crossBrowser",
plugin={"pretty","html:target/cucumber-report.html","json:target/cucumber-jsonreport.json","rerun:target/failed_scenarios.txt"})
public class CrossBrowserTestngTestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser)
	{
		TestBase.browserFromXml = browser;
	}
}