package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinitions",monochrome=true,dryRun=false,tags="@TC_ATC_001",
plugin={"pretty","html:target/cucumber-report.html","json:target/cucumber-jsonreport.json","rerun:target/failed_scenarios.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestNGRTestRunner extends AbstractTestNGCucumberTests {

}