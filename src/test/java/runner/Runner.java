package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin =  {"html:target/reports/cucumber.html, json:target/reports/cucumber.html"},
        glue = "src/test/java/stepDefinition",
        features = "src/test/resources/features",
        tags = "@LoginDemo",
        dryRun = true

)

public class Runner {


}
