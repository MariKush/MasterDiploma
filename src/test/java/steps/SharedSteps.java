package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SharedSteps {

    String homePageUrl = "https://rozetka.com.ua/";

    @Given("I open ROZETKA home page")
    public void openHomePage() {
        open(homePageUrl);
    }

    @Then("^I verify that URL contains (.*)$")
    public void assertThenUrlContainSearchWord(String searchWord) {
        assertThat(WebDriverRunner.url()).containsIgnoringCase(searchWord);
    }

    @After
    public void attachScreenshotIfFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
    }

}
