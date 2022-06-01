package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class InventoryPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();
    InventoryPage inventoryPage = pf.getInventoryPage();

    @When("the user is in the inventory page")
    public void theUserIsInTheInventoryPage() {
        inventoryPage.navigateTo(InventoryPage.PAGE_URL);
    }

    @Then("the user see the inventory list with 6 items")
    public void inventoryConteinerNumber() {
        Assert.assertEquals("EL NUMERO DE ITEMS RESULTANTES EN EL INVENTARIO, NO ES EL CORRECTO.", 6, inventoryPage.getItemList().size());
    }

    @Then("the user see the {string} in the inventory list")
    public void inventoryItemContains(String itemName) {
        Assert.assertTrue("EL PRODUCTO 'Sauce Labs Bolt T-Shirt', NO APARECE EN EL LISTADO DE ITEMS DEL INVENTARIO ", inventoryPage.isItemContains(itemName));
    }

    @When("the user adds a {string} by clicking Add To Cart")
    public void addItemToCart(String itemName) {
        inventoryPage.addItemToCartByName(itemName);
    }

    @Then("there should be 1 items in the shopping cart")
    public void productsQuantityInCart() {
        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA. ", 1, inventoryPage.productsQuantityInCart());
    }

    @When("the user removes a {string} by clicking Remove")
    public void removeItemToCart(String itemName) {
        inventoryPage.removeItemToCartByName(itemName);
    }

    @Then("there should be 0 items in the shopping cart")
    public void emptyCart() {
        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA. ", 0, inventoryPage.productsQuantityInCart());
    }

    @When("the user select {int} random itmes")
    public void selectRandomItems(int number) {
        inventoryPage.clickOnRandomProduct(number);
    }

    @Then("there should be 3 items in the shopping cart")
    public void itemsQuantityInCart() {
        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA. ", 3, inventoryPage.productsQuantityInCart());
    }

    @When("the user clicks select {string}")
    public void optionSort(String option) {
        inventoryPage.selectOption(option);
    }

    @Then("the user see the list by alphabetical desc order")
    public void zToAInventoryByname() {
        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", inventoryPage.sortedZtoAInventoryByname(), inventoryPage.getInventoryName());
    }

    @Then("the user see the list by price desc order")
    public void highLowSortedByPrice() {
        Assert.assertEquals("EL FILTRO 'Price (low to high)', NO FUNCIONA CORRECTAMENTE. ", inventoryPage.getProductPrice(), inventoryPage.sortedProductHighToLowPrice());
    }
}
