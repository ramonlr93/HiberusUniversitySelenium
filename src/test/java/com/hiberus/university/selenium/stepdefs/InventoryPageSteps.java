package com.hiberus.university.selenium.stepdefs;



import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class InventoryPageSteps {

    @Given("the user is on the inventory page")
    public void theUserIsOnTheInventoryPage() {

        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the inventory page");
        InventoryPage inventoryPage = pf.getInventoryPage();


        inventoryPage.navigateTo(InventoryPage.PAGE_URL);
    }

    @Then("the user see the inventory list with items size list {int}")
    public void theInventoryContainerItems(int size){
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        Assert.assertEquals("EL NUMERO DE ITEMS RESULTANTES EN EL INVENTARIO, NO ES EL CORRECTO. ",
                size, inventoryPage.getInventoryItemsSize());

    }

    @Then("the user see the item in the inventory list {string}")
    public void theProductExistsInTheInventory (String itemName){
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<WebElement> inventoryResults;

        inventoryResults = inventoryPage.getInventoryNameList();

        boolean isProductPresent = false;
        for(int i = 0; i < inventoryResults.size(); i++) {
            if(inventoryResults.get(i).getText().equals(itemName)) {
                isProductPresent = true;
            }
        }

        Assert.assertTrue("EL PRODUCTO 'Sauce Labs Bolt T-Shirt', NO APARECE EN EL LISTADO DE ITEMS DEL INVENTARIO",
                isProductPresent);
    }

    @Then("the item is added to the cart and the cart has 1 product {string}")
    public void theItemIsAddedToTheCart(String nameItem) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName(nameItem);
        inventoryPage.clickOnShoppingCart();

        CartPage cartPage = pf.getCartPage();
        int currentCount = cartPage.getItemCount();
        Assert.assertEquals(1, currentCount);
    }

    @Then("the item is removed from the cart {string}")
    public void theItemIsRemovedFromTheCart(String itemName){
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.removeItemToCartByName(itemName);

        String productsQuantityInCart = inventoryPage.getProductsQuantityInCart().getText();

        if(productsQuantityInCart.equals("")) {
            productsQuantityInCart = null;
        }

        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA", null, productsQuantityInCart);

    }

    @Then("the user see the list by price desc order")
    public void theUserSeeTheListByPriceDescOrder() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<WebElement> inventoryPriceList = inventoryPage.getInventoryPriceList();
        List<Double> priceInventoryResultsHighToLow = new ArrayList<>();
        List<Double> priceInventoryResultHighToLowSorted = new ArrayList<>();
        for (WebElement webElement: inventoryPriceList) {
            priceInventoryResultsHighToLow.add(
                Double.parseDouble(webElement.getText().replace("$","").trim()));
            priceInventoryResultHighToLowSorted.add(
                    Double.parseDouble(webElement.getText().replace("$","").trim()));
        }
        priceInventoryResultHighToLowSorted.sort(Collections.reverseOrder());
        Assert.assertEquals("list is sorted by price",
                priceInventoryResultHighToLowSorted, priceInventoryResultsHighToLow);
    }

}
