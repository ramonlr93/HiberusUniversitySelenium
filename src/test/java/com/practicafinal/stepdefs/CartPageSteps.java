package com.practicafinal.stepdefs;

import com.practicafinal.pages.CartPage;
import com.practicafinal.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import com.practicafinal.pages.HomePage;

@Slf4j
public class CartPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    HomePage hp = pf.getHomepage();
    CartPage cp = pf.getCartpage();

    @And("the user adds items to the cart")
    public void theUserAddsItemsToTheCart() {
        hp.addItemsFromHomePageAndGoToCartPage();
    }

    @Then("there should be {int} items in the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(int num) {
        Assert.assertEquals("the number of items is not the same",num,cp.numberOfItems());
    }

    @And("the user adds {int} items into the shopping cart")
    public void theUserAddsItemsIntoTheSoppingCart(int arg0) {
        hp.addItemsFromHomePageAndGoToCartPage();
    }

    @And("the user clicks on the shopping cart button")
    public void theUserClicksOnTheShoppingCartButton() throws InterruptedException {
        hp.goToShoppingCart();
    }

    @When("the user deletes an item from shopping cart")
    public void theUserDeletesAnItemFromShoppingCart() {
        cp.deleteOneItem();
    }


}
