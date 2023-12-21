package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    WebDriver driver;
    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    By Top_Deals = By.xpath("//a[contains(text(),'Top Deals')]");
    By searchBox = By.xpath("//input[@id='search-field']");
    By product_title = By.xpath("//tbody//tr//td[1]");

    public void clickTopDealsLink(){
        driver.findElement(Top_Deals).click();
    }
    public void searchProductOnOffersPage(String product_short_name){
        driver.findElement(searchBox).sendKeys(product_short_name);
    }
    public String getProductTitleFromOffersPage(){
        return driver.findElement(product_title).getText();
    }

}
