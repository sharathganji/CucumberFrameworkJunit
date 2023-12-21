package cucumberOptions;

//re-run scenario:
//@CucumberOptions(features = "@target/failed_scenarios.txt", glue = "stepDefinitions",
//        monochrome = true, dryRun = false,
//        plugin ={"html:target/cucumber.html", "json:target/cucumber.json",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//                "rerun:target/failed_scenarios.txt.txt"})


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//actual scenario
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions",
        monochrome = true, dryRun = false, tags = "@CheckOutItem or @SearchItem",
plugin ={"html:target/cucumber.html", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"rerun:target/failed_scenarios.txt"})
public class JunitTestRunnerTest {


}
