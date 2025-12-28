package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import testBase.TestBase;
import utilities.RetryAnalyzer;

@CucumberOptions(features="src/test/resources/features",glue="stepDefinitions",monochrome=true,dryRun=false, tags="@RegisterAccount",
plugin={"pretty","html:target/cucumber-report.html","json:target/cucumber-jsonreport.json","rerun:target/failed_scenarios.txt"})
public class ParallelTestNGTestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser)
	{
		TestBase.browserFromXml = browser;
	}

	@Override
	@Test(
			dataProvider = "scenarios",
			retryAnalyzer = RetryAnalyzer.class
			)
	public void runScenario(
			io.cucumber.testng.PickleWrapper pickle,
			io.cucumber.testng.FeatureWrapper feature) {

		super.runScenario(pickle, feature);
	}



}