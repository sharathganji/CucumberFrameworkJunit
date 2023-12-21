package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
    WebDriver driver;
    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }
    public void switchToWindowChild(){
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        itr.next();
        driver.switchTo().window(itr.next());

    }
}
