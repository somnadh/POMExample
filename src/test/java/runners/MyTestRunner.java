package runners;

//import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="src\\test\\resources\\features\\PlaceOrder.feature",
		glue= {"stepDefs"},
		dryRun=false,
		monochrome=true,
		//tags = "@SmokeTest",
		plugin = {
				"pretty","html:test-output/report/cucumber.html"
				/*
				 * "json:test-output/report/cucumber.json",
				 * "rerun:test-output/failedScenarios.txt",
				 */
		         //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		)

public class MyTestRunner extends AbstractTestNGCucumberTests{
	
	/*
	 * @DataProvider(parallel=true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */

}
