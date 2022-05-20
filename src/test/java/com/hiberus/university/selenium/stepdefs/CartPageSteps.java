package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CartPageSteps {
    @And("the user added 2 items to the cart")
    public void theUserAdded2ItemsToTheCart(){
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        String itemName1 = "Sauce Labs Backpack";
        String itemName2 = "Sauce Labs Bolt T Shirt";

        inventoryPage.addItemToCartByName(itemName1);
        inventoryPage.addItemToCartByName(itemName2);
    }

    @And("the user clicked the cart button")
    public void theUserClickedTheCartButton() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        inventoryPage.clickShoppingCart();
    }

    @When("the user removes a product from the cart")
    public void theUserRemovesAProductFromTheCart() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();

        String itemName1 = "Sauce Labs Backpack";
        cartPage.deleteCartItemByName(itemName1);
    }

    @Then("it shows that the product was removed")
    public void itShowsThatTheProductWasRemoved() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();

        int currentCount = cartPage.getItemCount();
        Assert.assertEquals("FAILED, THE PRODUCT WAS NOT DELETED FROM CART",1, currentCount);
    }
}
