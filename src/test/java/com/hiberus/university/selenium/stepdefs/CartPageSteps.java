package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CartPageSteps {
    private static CartPage cartPage = PagesFactory.getInstance().getCartPage();

    @Then("there should be {int} items in the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(int num) {

        Assert.assertEquals("El nÃºmero de elementos en el carrito no es: " + num, num, cartPage.getItemCount());
    }

    @Then("the user remove {int} item by clicking Remove Button cart")
    public void theUserRemoveItemByClickingRemoveButtonCart(int num) {
        try {
            for (int i = 0; i < num; i++) {
                cartPage.deleteCarItemtByName(cartPage.getItemsListName().get(i).getText());
            }
        } catch (Exception e) {
            log.info(e.toString());
        }

    }

    @And("the user does the checkout of the products")
    public void theUserDoesTheCheckoutOfTheProducts() {

        cartPage.clickCheckout();
    }
}