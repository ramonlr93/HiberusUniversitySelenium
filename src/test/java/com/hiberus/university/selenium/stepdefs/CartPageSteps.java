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

    @And("go to the cart page")
    public void goToTheCartPage() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.clickOnShoppingCart();
    }

    @When("the product random is remove")
    public String theProductRandomIsRemove() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();
        List<String> itemNames = cartPage.getItemsName();
        String itemNameRemove = itemNames.get(0);
        cartPage.removeItemToCartByName(itemNameRemove);
        return itemNameRemove;
    }

    @Then("the remove product no apparent to the cart")
    public void theRemoveProductNoApparentToTheCart() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();

        String itemRemove = theProductRandomIsRemove();
        Assert.assertFalse("PRUEBA FALLIDA - El producto seleccionado no se ha eliminado",
                cartPage.itemPresentToCartByName(itemRemove));
    }

}
