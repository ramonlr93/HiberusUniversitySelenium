package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.BasePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class BasePageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    BasePage basePage = pf.getBasePage();

    @And("the user clicks the add to cart of a product")
    public void addToCartProduct() {
        log.info("the user adds a random product to the cart");
        basePage.clickAddCartButton();
    }

    @When("the user clicks on the cart button")
    public void clickCartButton() {
        log.info("the user clicks the cart button");
        basePage.clickCart();
    }

    @Then("the cart has a product")
    public void cartHasProduct() {
        Assert.assertTrue(basePage.getCartValue());
    }

    @When("the user clicks the currency button and change to {string}")
    public void clickCurrencyButton(String option) {
        basePage.changeCurrency(option);
    }

    @Then("the price of the products will be in {string}")
    public void validateCurrency(String currency) {
        Assert.assertTrue(basePage.getPrice(currency));
    }

    @And("the user clicks on the cartButton")
    public void clickOnCartButton() {
        log.info("the user clicks the cart button");
        basePage.clickCart();
    }

    @When("the user clicks in the remove button")
    public void clickRemoveButton() {
        basePage.removeFromCart();
    }

    @Then("the cart will be empty")
    public void validateCartEmpty() {
        basePage.clickCart();
        Assert.assertTrue(basePage.textCart());
    }
}
