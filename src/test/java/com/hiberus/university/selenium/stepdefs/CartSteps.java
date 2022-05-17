package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class CartSteps {

    int numberOfProductsExpected;
    @And("the user remove {int} product from the cart")
    public void theUserRemoveProductFromTheCart(int numberOfProducts) {
        CartPage cartPage = PagesFactory.getInstance().getCartPage();
        numberOfProductsExpected = cartPage.getProductsOnCart() - numberOfProducts;
        cartPage.removeRandomProducs(numberOfProducts);
    }
    @Then("the removed product doesn't appears on the cart")
    public void theRemovedProductDoesnTAppearsOnTheCart() {
        CartPage cartPage = PagesFactory.getInstance().getCartPage();
        assertEquals("PRUEBA FALLIDA: no se han eliminado correctamente los productos del carrito", numberOfProductsExpected, cartPage.getProductsOnCart());
    }
}
