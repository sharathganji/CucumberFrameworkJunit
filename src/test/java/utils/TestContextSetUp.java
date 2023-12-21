package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;
import utils.TestBase;

import java.io.IOException;

public class TestContextSetUp {
    public WebDriver driver;
    public String Home_product_title;

    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;


    public TestContextSetUp() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());

    }


}
