package runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.RetryAnalyzer;

@CucumberOptions(features="src/test/resources/features",glue="stepDefinitions",monochrome=true,dryRun=false,tags="@TC_HP_001",
plugin={"pretty","html:target/cucumber-report.html","json:target/cucumber-jsonreport.json","rerun:target/failed_scenarios.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestNGRTestRunner extends AbstractTestNGCucumberTests {

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