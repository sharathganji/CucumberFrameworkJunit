package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
    By searchBox = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
    By product_title = By.xpath("//div[@class='product']//h4[@class='product-name']");
    By increment_btn = By.xpath("//a[@class='increment']");
    By addToCartBtn = By.xpath("//button[text()='ADD TO CART']");

    public void searchProduct(String product_shortcut_name){
        driver.findElement(searchBox).sendKeys(product_shortcut_name);
    }

    public String getProductTitle(){
        return driver.findElement(product_title).getText();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void incrementQty(int quantity) throws InterruptedException {
       int attempt=1;
        while(attempt <= quantity) {
            try {
                driver.findElement(increment_btn).click();
            } catch(Exception e) {
                e.printStackTrace();
            }
            attempt++;
        }


//        int i=quantity-1;
//        while(i>0){
//            driver.findElement(increment_btn).click();
//            Thread.sleep(1000);
//            i--;
//        }
//        for(int i=1;i<=quantity;i++){
//            driver.findElement(increment_btn).click();
//        }
    }

    public void setAddToCartBtn(){
        driver.findElement(addToCartBtn).click();
    }
}
