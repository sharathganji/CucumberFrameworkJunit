package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartBg = By.xpath("//img[@alt='Cart']");
    By checkOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    By promo_btn = By.xpath("//button[text()='Apply']");
    By place_order = By.xpath("//button[text()='Place Order']");
    By product_name = By.xpath("//p[@class='product-name']");

    public void checkOutItems(){
        driver.findElement(cartBg).click();
        driver.findElement(checkOutButton).click();
    }

    public boolean verifyPromoBtn(){
        return driver.findElement(promo_btn).isDisplayed();
    }

    public boolean verifyPlaceOrderBtn(){
        return driver.findElement(place_order).isDisplayed();
    }

    public String verifyProductName(){
        return driver.findElement(product_name).getText();
    }

}
