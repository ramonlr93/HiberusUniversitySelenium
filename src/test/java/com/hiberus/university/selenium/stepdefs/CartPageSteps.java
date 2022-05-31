package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private CartPage cartPage = pf.getCartPage();


    @Then("there should be {int} items in the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(int item) {
        int numItems = cartPage.getItemCount();
        Assert.assertEquals("EL NUMERO DE ITEMS EN EL CARRITO NO ES "+item+". ",
                numItems, item);
    }
}

