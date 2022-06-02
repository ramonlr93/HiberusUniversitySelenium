package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CartPageSteps {

    @Then("there should be {string} items in the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(String count) {
        log.info("there should be " + count + " items in the shopping cart");
        CartPage cartPage = PagesFactory.getInstance().getCartPage();
        int actualCount = cartPage.getItemCount();
        int expectedCount = Integer.parseInt(count);
        Assert.assertEquals(actualCount, expectedCount);
    }

    @When("the user deletes a {string} item from shopping cart")
    public void theUserDeletesAItemFromShoppingCart(String item) {
        log.info("the user deletes the item: " + item);
        CartPage cartPage = PagesFactory.getInstance().getCartPage();
        cartPage.deleteCarItemtByName(item);
    }

    @And("the user clicks checkout")
    public void theUserClicksCheckout() {
        log.info("the user clicks in checkout button");
        CartPage cartPage = PagesFactory.getInstance().getCartPage();
        cartPage.clickCheckout();
    }
}
