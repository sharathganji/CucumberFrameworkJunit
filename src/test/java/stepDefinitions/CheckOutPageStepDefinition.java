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

import org.junit.Assert;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetUp;

public class CheckOutPageStepDefinition {
    TestContextSetUp testContextSetUp;
    PageObjectManager pageObjectManager;
    CheckOutPage checkOutPage;


    public CheckOutPageStepDefinition(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
        this.checkOutPage = testContextSetUp.pageObjectManager.getCheckOutPage();
    }

    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void userProceedsToCheckoutAndValidateTheNameItemsInCheckoutPage(String itemName) throws InterruptedException {
        checkOutPage.checkOutItems();
        Thread.sleep(4000);
        Assert.assertTrue(checkOutPage.verifyProductName().contains(itemName));
    }


    @And("Verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkOutPage.verifyPromoBtn());
        Assert.assertTrue(checkOutPage.verifyPlaceOrderBtn());
    }
}
