package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    WebDriver driver;
    public WebDriver webDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\gasharat\\IdeaProjects\\CucumberFramework\\src\\test\\resources\\global.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String url = properties.getProperty("URL");

        if(driver ==  null){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\gasharat\\Documents\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(url);
        }
        return driver;
    }
}
