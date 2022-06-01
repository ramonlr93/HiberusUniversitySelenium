package com.hiberus.university.selenium.inventory;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class InventorySteps {
    @Then("the page have {int} items")
    public void thePageHaveItems(int numberOfProducts) {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        assertEquals("PRUEBA FALLIDA: el número de productos no es el correcto", 6, inventoryPage.getNumberProducts());
    }

    @Then("the page have the {string} is displayed")
    public void thePageHaveTheIsDisplayed(String productTitle) throws Exception {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        assertTrue("PRUEBA FALLIDA: no se muestra la Sauce Labs Bolt T-Shirt", inventoryPage.isProductDisplayed(productTitle));
    }

    @And("the user adds the product {string} to the cart")
    public void theUserAddsTheProductToTheCart(String productTitle) throws Exception {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.addProductToCart(productTitle);
        assertEquals("PRUEBA FALLIDA: no se ha añadido el producto al carrito", 1, inventoryPage.getNumberProductsCart());
    }

    @Then("the cart value increments to {int}")
    public void theCartValueIncrementsTo(int cartNumber) {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        assertEquals("PRUEBA FALLIDA: no se ha eliminado el producto del carrito", cartNumber, inventoryPage.getNumberProductsCart());
    }

    @And("the user removes the product {string} from the cart")
    public void theUserRemovesTheProductFromTheCart(String productTitle) throws Exception {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.removeProductFromCart(productTitle);
    }

    @Then("the cart is empty")
    public void theCartIsEmpty() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        assertEquals("PRUEBA FALLIDA: no se ha eliminado el producto del carrito", 0, inventoryPage.getNumberProductsCart());
    }

    @And("the user adds {int} random products to the cart")
    public void theUserAddsRandomProductsToTheCart(int numberOfProducts) {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.addRandomProductsCart(numberOfProducts);
    }

    @And("the user clicks the filter to sort from Z to A")
    public void theUserClicksTheFilterToSortFromZToA() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.filterBy("za");
    }

    @Then("the page get sorted from Z to A")
    public void thePageGetSortedFromZToA() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        List<String> productsTitles = inventoryPage.getProductsTitles();
        List<String> productsTitlesSorted = inventoryPage.getProductsTitles();
        Collections.sort(productsTitlesSorted, Collections.reverseOrder());

        assertArrayEquals("PRUEBA FALLIDA: no esta ordenado de manera correcta", productsTitlesSorted.toArray(), productsTitles.toArray());
    }

    @And("the user clicks the filter to sort by price from lower to higher")
    public void theUserClicksTheFilterToSortByPriceFromLowerToHigher() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.filterBy("lohi");
    }

    @Then("the page get sorted by price from lower to higher")
    public void thePageGetSortedByPriceFromLowerToHigher() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        List<Double> productsPrices = inventoryPage.getProductsPrices();
        List<Double> productsPricesSorted = inventoryPage.getProductsPrices();
        Collections.sort(productsPricesSorted);

        assertArrayEquals("PRUEBA FALLIDA: no esta ordenado de manera correcta", productsPricesSorted.toArray(), productsPrices.toArray());
    }

    @And("the user clicks the filter to sort by price from higher to lower")
    public void theUserClicksTheFilterToSortByPriceFromHigherToLower() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.filterBy("hilo");
    }

    @Then("the page get sorted by price from higher to lower")
    public void thePageGetSortedByPriceFromHigherToLower() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        List<Double> productsPrices = inventoryPage.getProductsPrices();
        List<Double> productsPricesSorted = inventoryPage.getProductsPrices();
        Collections.sort(productsPricesSorted, Collections.reverseOrder());

        assertArrayEquals("PRUEBA FALLIDA: no esta ordenado de manera correcta", productsPricesSorted.toArray(), productsPrices.toArray());
    }
}
