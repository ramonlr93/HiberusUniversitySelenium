package com.hiberus.university.opencart.stepdefs;

import com.hiberus.university.opencart.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class HomePageSteps {

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the home page");
        HomePage homePage = pf.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);
    }

    @And("the user clicks the my account button")
    public void theUserClicksTheMyAccountButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the my account button");
        HomePage homePage = pf.getHomePage();
        homePage.clickMyAccountButton();
    }

    @And("the user clicks the checkout button")
    public void theUserClicksTheCheckoutButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the checkout button");
        HomePage homePage = pf.getHomePage();
        homePage.clickCheckoutButton();
    }

    @And("the user clicks the Your Store link")
    public void theUserClicksTheYourStoreLink() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the Your Store link");
        HomePage homePage = pf.getHomePage();
        homePage.clickYourStoreLink();
    }

    @When("the user clicks the register link")
    public void theUserClicksTheRegisterLink() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the register link");
        HomePage homePage = pf.getHomePage();
        homePage.clickRegisterLink();
    }

    @When("the user clicks the login link")
    public void theUserClicksTheLoginLink() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the login link");
        HomePage homePage = pf.getHomePage();
        homePage.clickLoginLink();
    }

    @When("the user adds a {string} from homepage to cart")
    public void theUserAddsAByClickingAddToCart(String itemName) {
        log.info("the user adds a " + itemName + " from homepage to cart");
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage = pf.getHomePage();
        homePage.addItemToCartByName(itemName);
    }

    @Then("the user should be shown a product added confirmation message")
    public void theUserShouldBeShownAProductAddedMessage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown a product added confirmation message");
        HomePage homePage = pf.getHomePage();
        Assert.assertTrue("success message not found", homePage.productAddedConfirmation());
    }

    @And("there should be {string} items on the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(String num_items) {
        log.info("there should be " + num_items + " items in the shopping cart");
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage = pf.getHomePage();
        int expectedCount = Integer.parseInt(num_items);
        int actualCount = homePage.getItemCount();
        Assert.assertEquals(expectedCount, actualCount);
    }

}

