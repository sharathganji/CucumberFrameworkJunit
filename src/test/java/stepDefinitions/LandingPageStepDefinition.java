package stepDefinitions;
//Execution hierarchy: Before>>Background>>Scenario>>After
//dependency injection: cucumber picocontainer, variables which are need to be accessible to many classes,
// will be defined on separate class, those are initialized in constructor of respective classes
//single responsibility prinicple - each page should have one dedicated stepdefinition class
//loosley coupled with dependancy injection, avoiding the dependancy of methods, g
// sharing variables with other by declaring it other classes

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetUp;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {
    TestContextSetUp testContextSetUp;
    PageObjectManager pageObjectManager;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
        this.landingPage = testContextSetUp.pageObjectManager.getLandingPage();
    }

    @Given("User is on the GreenCart land page")
    public void user_is_on_the_green_cart_land_page() {
        Assert.assertTrue(landingPage.getPageTitle().contains("GreenKart"));
    }
    @When("^User search with shortname (.+) and extract the product title$")
    public void user_search_with_shortname_and_extract_the_product_title(String product_shortcut_name) {
        landingPage.searchProduct(product_shortcut_name);
        testContextSetUp.Home_product_title = landingPage.getProductTitle().split(" ")[0].trim();
    }


    @And("^Added (.+) times of the selected product to cart$")
    public void addedTimesOfTheSelectedProductToCart(String  quantity) throws InterruptedException {
        System.out.println(quantity);
        landingPage.incrementQty(Integer.parseInt(quantity));
        landingPage.setAddToCartBtn();
    }
}
