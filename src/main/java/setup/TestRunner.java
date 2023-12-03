package setup;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features",
        glue = "stepdefinition"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
