package com.hiberus.university.selenium.stepdefs;

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
public class InventoryPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private InventoryPage inventoryPage = pf.getInventoryPage();

    @Then("the user see the inventory list with {string} size list")
    public void theUserSeeTheInventoryListWithSizeList(String products) {
        Assert.assertEquals("EL NUMERO DE ITEMS RESULTANTES EN EL INVENTARIO, NO ES EL CORRECTO. ",
                Integer.parseInt(products), inventoryPage.getNumberProducts());
    }

    @Then("the user see the {string} in the inventory list")
    public void theUserSeeTheInTheInventoryList(String item) {
        Assert.assertTrue("El producto no está en la lista", inventoryPage.isItemDisplayed(item));
    }

    @When("the user clicks select {string}")
    public void theUserClicksSelect(String optionSort) {
        inventoryPage.selectOption(optionSort);
    }

    @Then("the user see the list by price desc order")
    public void theUserSeeTheListByPriceDescOrder() {
        List<WebElement> inventoryPriceList = inventoryPage.getInventoryPriceList();
        List<Double> priceInventoryResultsHighToLow = new ArrayList();
        List<Double> priceInventoryResultsHighToLowSorted = new ArrayList();
        for (WebElement webElement : inventoryPriceList) {
            priceInventoryResultsHighToLow.add(Double.parseDouble(webElement.getText().replace("$", "").trim()));
            priceInventoryResultsHighToLowSorted.add(Double.parseDouble(webElement.getText().replace("$", "").trim()));
            //Lo añadimos, pasandolo a double, quitando el $ por nada
        }
        priceInventoryResultsHighToLowSorted.sort(Collections.reverseOrder()); //Ordenamos para compararlo con el otro después
        Assert.assertEquals("list is sorted by price", priceInventoryResultsHighToLowSorted, priceInventoryResultsHighToLow);
    }

    @When("the user adds a {string} by clicking Add To Cart")
    public void theUserAddsAByClickingAddToCart(String item) {
        inventoryPage.addItemToCartByName(item);
    }

    @And("the user clicks on the shopping cart")
    public void theUserClicksOnTheShoppingCart() {
        inventoryPage.clickOnShoppingCart();
    }

    @When("the user remove a {string} by clicking Remove")
    public void theUserRemoveAByClickingRemove(String item) {
        inventoryPage.removeItemToCartByName(item);
    }

    @Then("the user see the list by alphabetical desc order")
    public void theUserSeeTheListByAlphabeticalDescOrder() {
        List<WebElement> inventoryPriceList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResultsHighToLow = new ArrayList();
        List<String> nameInventoryResultsHighToLowSorted = new ArrayList();
        for (WebElement webElement : inventoryPriceList) {
            nameInventoryResultsHighToLow.add(webElement.getText().trim());
            nameInventoryResultsHighToLowSorted.add(webElement.getText().trim());
            //Lo añadimos, pasandolo a double, quitando el $ por nada
        }
        nameInventoryResultsHighToLowSorted.sort(Collections.reverseOrder()); //Ordenamos para compararlo con el otro después
        Assert.assertEquals("list is sorted by name", nameInventoryResultsHighToLowSorted, nameInventoryResultsHighToLow);
    }

    @Then("the user see the list by price ascend order")
    public void theUserSeeTheListByPriceAscendOrder() {
        List<WebElement> inventoryPriceList = inventoryPage.getInventoryPriceList();
        List<Double> priceInventoryResultsHighToLow = new ArrayList();
        List<Double> priceInventoryResultsHighToLowSorted = new ArrayList();
        for (WebElement webElement : inventoryPriceList) {
            priceInventoryResultsHighToLow.add(Double.parseDouble(webElement.getText().replace("$", "").trim()));
            priceInventoryResultsHighToLowSorted.add(Double.parseDouble(webElement.getText().replace("$", "").trim()));
            //Lo añadimos, pasandolo a double, quitando el $ por nada
        }
        Collections.sort(priceInventoryResultsHighToLowSorted); //Ordenamos para compararlo con el otro después
        Assert.assertEquals("list is sorted by price", priceInventoryResultsHighToLowSorted, priceInventoryResultsHighToLow);
    }

    @When("the user selects")
    public void theUserSelects(DataTable product) {
        for (int i =0 ;i < product.asList(String.class).size();i++) {
            inventoryPage.addItemToCartByName(product.asList().get(i));
        }
    }
}
