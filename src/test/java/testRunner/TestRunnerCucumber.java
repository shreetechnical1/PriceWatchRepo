package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//Features/Login.feature", ".//Features/TrackProductPage.feature",".//Features/ProductWatchListPage.feature"},
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:cucumber-output"}
        )

public class TestRunnerCucumber {
}
