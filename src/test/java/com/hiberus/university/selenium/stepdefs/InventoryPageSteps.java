package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class InventoryPageSteps {
    private static final InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();

    @Then("the user see the inventory list with {string} size list")
    public void theUserSeeTheInventoryListWithSizeList(String arg0) {
        Assert.assertEquals("El numero de elementos no es 6", 6, inventoryPage.getInventoryListSize());
    }

    @Then("the user see the {string} in the inventory list")
    public void theUserSeeTheInTheInventoryList(String name) {
        Assert.assertTrue("El item " + name + " no se muestra", inventoryPage.isItemVisible(name));
    }

    @When("the user adds a {string} by clicking Add To Cart")
    public void theUserAddsAByClickingAddToCart(String name) {
        inventoryPage.addItemToCartByName(name);
    }

    @And("the user clicks on the shopping cart")
    public void theUserClicksOnTheShoppingCart() {
        inventoryPage.clickOnShoppingCart();
    }

    @Then("there should be {int} items in the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(int cantidad) {
        Assert.assertEquals("La cantidad de items en carrito no coincide", cantidad, inventoryPage.getCartListSize());
    }

    @When("the user selects")
    public void theUserSelects(DataTable dataTable) {
        for (String item : dataTable.asList(String.class)) {
            inventoryPage.addItemToCartByName(item);
        }
    }

    @When("the user clicks select {string}")
    public void theUserClicksSelect(String option) {
        inventoryPage.selectOption(option);
    }

    @Then("the user see the list by alphabetical desc order")
    public void theUserSeeTheListByAlphabeticalDescOrder() {
        List<String> baseSortedItems = inventoryPage.getInventoryItemsName();
        Collections.sort(baseSortedItems, Collections.reverseOrder());
        Assert.assertEquals("La lista no esta ordenada en orden inverso", baseSortedItems, inventoryPage.getInventoryItemsName());
    }

    @Then("the user see the list by price desc order")
    public void theUserSeeTheListByPriceDescOrder() {
        List<Double> baseSortedItems = inventoryPage.getItemPrices();
        Collections.sort(baseSortedItems, Collections.reverseOrder());
        Assert.assertEquals("Lista no esta con precios de mayor a menor", baseSortedItems, inventoryPage.getItemPrices());
    }


    @Then("the user see the list by price asc order")
    public void theUserSeeTheListByPriceAscOrder() {
        List<Double> baseSortedItems = inventoryPage.getItemPrices();
        Collections.sort(baseSortedItems);
        Assert.assertEquals("Lista no esta con precios de menor a mayor", baseSortedItems, inventoryPage.getItemPrices());
    }

    @And("the user deletes the {string} in the cart")
    public void theUserDeletesTheItemInTheCart(String name) {
        inventoryPage.removeItemFromCartByName(name);
    }
}
