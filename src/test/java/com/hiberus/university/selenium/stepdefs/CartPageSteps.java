package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Slf4j
public class CartPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private CartPage cartPage = pf.getCartPage();


    @Then("there should be {int} items in the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(int item) {
        int numItems = cartPage.getItemCount();
        Assert.assertEquals("EL NUMERO DE ITEMS EN EL CARRITO NO ES "+item+". ",
                numItems, item);
    }

    @Then("the user remove a {string} by clicking Remove in cart")
    public void theUserRemoveAByClickingRemoveInCart(String item) {
        cartPage.deleteCarItemtByName(item);
    }

    @And("the user clicks on the checkout button")
    public void theUserClicksOnTheCheckoutButton() {
        cartPage.clickCheckout();
    }
}
