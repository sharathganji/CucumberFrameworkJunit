package stepDefinitions;
//Execution hierarchy: Before>>Background>>Scenario>>After
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import pageObjects.OffersPage;
import utils.TestContextSetUp;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    String offer_product_title;
    TestContextSetUp testContextSetUp;
    OffersPage offersPage;

    public OfferPageStepDefinition(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
        this.offersPage = testContextSetUp.pageObjectManager.getOffersPage();
    }

    @Then("^User searched with same (.+) shortname on offers page$")
    public void user_searched_same_shortname_on_offers_page_to_check_if_product_is_exist(String product_short_name) throws InterruptedException {

        //offersPage = new OffersPage(testContextSetUp.driver);
        offersPage.clickTopDealsLink();
        switchToOffersPage();
        offersPage.searchProductOnOffersPage(product_short_name);
    }
    public void switchToOffersPage(){
    testContextSetUp.genericUtils.switchToWindowChild();
    }

    @And("validate product name in offers page matches with landing page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        offer_product_title = offersPage.getProductTitleFromOffersPage();
        //System.out.println(offer_product_title+"::"+testContextSetUp.Home_product_title);
        Assert.assertEquals(offer_product_title, testContextSetUp.Home_product_title);
    }


}
