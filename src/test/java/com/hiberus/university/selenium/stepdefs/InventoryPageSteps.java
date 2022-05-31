package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class InventoryPageSteps {
    private static final InventoryPage inventory = PagesFactory.getInstance().getInventoryPage();

    @Then("the user see the inventory list with {string} size list")
    public void theUserSeeTheInventoryListWithSizeList(String arg0) {
        Assert.assertEquals("El numero de elementos no es 6", 6, inventory.getInventoryListSize());
    }

    @Then("the user see the {string} in the inventory list")
    public void theUserSeeTheInTheInventoryList(String name) {
        Assert.assertTrue("El item " + name + " no se muestra", inventory.isItemVisible(name));
    }

    @When("the user adds a {string} by clicking Add To Cart")
    public void theUserAddsAByClickingAddToCart(String name) {
        inventory.addItemToCartByName(name);
    }

    @And("the user clicks on the shopping cart")
    public void theUserClicksOnTheShoppingCart() {
        inventory.clickOnShoppingCart();
    }

    @Then("there should be {int} items in the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(int cantidad) {
        Assert.assertEquals("La cantidad de items en carrito no coincide", cantidad, inventory.getCartListSize());
    }

    @When("the user selects")
    public void theUserSelects() {

    }

    @When("the user clicks select {string}")
    public void theUserClicksSelect(String option) {
        inventory.selectOption(option);
    }

    @Then("the user see the list by alphabetical desc order")
    public void theUserSeeTheListByAlphabeticalDescOrder() {
        List<String> baseSortedItems = inventory.getInventoryItemsName();
        Collections.sort(baseSortedItems, Collections.reverseOrder());
        Assert.assertEquals("La lista no esta ordenada en orden inverso", baseSortedItems, inventory.getInventoryItemsName());
    }

    @Then("the user see the list by price desc order")
    public void theUserSeeTheListByPriceDescOrder() {
        List<Double> baseSortedItems = inventory.getItemPrices();
        Collections.sort(baseSortedItems, Collections.reverseOrder());
        Assert.assertEquals("Isnt sorted from H to L", baseSortedItems, inventory.getItemPrices());
    }



}
