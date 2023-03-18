package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features", glue = "steps",
        plugin = {"pretty","html:target/cucumber-html-report"})
public class CucumberRunnerTest extends AbstractTestNGCucumberTests{


}