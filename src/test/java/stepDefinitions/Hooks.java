package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetUp;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetUp testContextSetUp;
    public WebDriver driver;
    public Hooks(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
    }

    @After
    public void afterScenario() throws IOException {
        testContextSetUp.testBase.webDriverManager().quit();
    }

    @AfterStep
    public void takeScreenShot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetUp.testBase.webDriverManager();
        System.out.println("====================");
        if(scenario.isFailed()){
            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            scenario.attach(fileContent, "image/png", "img");
        }
    }
}

