package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.List;

@Slf4j
public class CartPageSteps {

    @And("the user go to the cart page")
    public void goToTheCartPage() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.goToShoppingCart();
    }

    @When("the product random is remove")
    public List<String> theProductRandomIsRemove() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();
        List<String> itemNamesBefore = cartPage.getItemsName();
        cartPage.removeItemToCart();
        return itemNamesBefore;
    }

    @Then("the remove product no apparent to the cart")
    public void theRemoveProductNoApparentToTheCart() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();
        List<String> itemNamesAfter = cartPage.getItemsName();

        Assert.assertEquals("PRUEBA FALLIDA - El producto seleccionado no se ha eliminado",
                theProductRandomIsRemove(), itemNamesAfter);
    }
}
