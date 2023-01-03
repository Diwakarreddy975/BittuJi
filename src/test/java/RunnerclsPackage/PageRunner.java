package RunnerclsPackage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features/loginpage.feature",
        glue = "stepclasses",
        dryRun = false,
        monochrome = true,
        plugin= {"pretty","html:test-output"})


public class PageRunner {
}
