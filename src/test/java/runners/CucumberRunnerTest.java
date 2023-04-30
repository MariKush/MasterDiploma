package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Automated and not @DISABLED",
        features = {"src/test/java/features"},
        glue = {"steps"},
        plugin = {
                "pretty"
        }
)
public class CucumberRunnerTest {
}
