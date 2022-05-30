package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

@Slf4j
public class cartPageSteps {


    @And("the user clicks in the button {string} of two random items")
    public void theUserClicksInTheButtonOfTwoRandomItems(String itemName) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<String> names = inventoryPage.getItemNames();
        Collections.shuffle(names);
        for(int i=0;i<2;i++){
            inventoryPage.addItemToCartByName(names.get(i));
        }
    }

    @And("the user goes to cart")
    public void theUserGoesToCart() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.clickOnShoppingCart();
    }

    @When("the user remove one of those items")
    public void theUserRemoveOneOfThoseItems() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();
        String name = cartPage.getItemNames().get(0);
        cartPage.deleteCarItemByName(name);
    }

    @Then("the deleted item doesn't appear in the cart")
    public void theDeletedItemDoesntAppearInTheCart() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();
        Assert.assertEquals("Item not deleted", 1, cartPage.getItemCount());
    }
}
