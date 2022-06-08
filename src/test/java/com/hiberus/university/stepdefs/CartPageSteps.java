package com.hiberus.university.stepdefs;

import com.hiberus.university.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LaptopsInventoryPage laptopsInventoryPage = pf.getLaptopsInventoryPage();
    CartPage cartPage = pf.getCartPage();

    @And("the user clicks the shopping cart icon")
    public void clicksShoppingCart() {
        laptopsInventoryPage.clickShoppingCart();
    }

    @When("clicks the view cart link")
    public void shoppingCartView() {
        laptopsInventoryPage.viewCart();
    }

    @When("the user clicks the checkout button")
    public void clickCheckoutButton() {
        cartPage.clickCheckout();
    }

    @Then("The user is in the checkout page")
    public void theUserInCheckoutPage() {
        Assert.assertEquals("Step failed", CheckoutPage.PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}


