package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
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
        for(WebElement webElement: inventoryPriceList){
            priceInventoryResultsHighToLow.add(Double.parseDouble(webElement.getText().replace("$","").trim()));
            priceInventoryResultsHighToLowSorted.add(Double.parseDouble(webElement.getText().replace("$","").trim()));
            //Lo añadimos, pasandolo a double, quitando el $ por nada
        }
        priceInventoryResultsHighToLowSorted.sort(Collections.reverseOrder()); //Ordenamos para compararlo con el otro después
        Assert.assertEquals("list is sorted by price", priceInventoryResultsHighToLowSorted,priceInventoryResultsHighToLow);
    }

    @When("the user adds a {string} by clicking Add To Cart")
    public void theUserAddsAByClickingAddToCart(String item) {

        inventoryPage.addItemToCartByName(item);
    }


    @And("the user clicks on the shopping cart")
    public void theUserClicksOnTheShoppingCart() {

        inventoryPage.clickOnShoppingCart();
    }


    @And("the user remove a {string} by clicking Remove Button")
    public void theUserRemoveAByClickingRemoveButton(String name) {

        inventoryPage.removeItemToCartByName(name);
    }


    @Then("the user see the list by alphabetical desc order")
    public void theUserSeeTheListByAlphabeticalDescOrder() {

        List<WebElement> inventoryPriceList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResultsZA = new ArrayList();
        List<String> nameInventoryResultsZASorted = new ArrayList();
        for(WebElement webElement: inventoryPriceList){
            nameInventoryResultsZA.add(webElement.getText());
            nameInventoryResultsZASorted.add(webElement.getText());
        }
        nameInventoryResultsZASorted.sort(Collections.reverseOrder()); //Ordenamos para compararlo con el otro después
        Assert.assertEquals("list is sorted by price", nameInventoryResultsZASorted,nameInventoryResultsZA);
    }


    @When("the user selects")
    public void theUserSelects(DataTable table) {

        for(int i=0; i<table.asList(String.class).size(); i++){
            inventoryPage.addItemToCartByName(table.asList().get(i));
        }
    }

    @Then("the user see the list by lower high price")
    public void theUserSeeTheListByLowerHighPrice() {

        List<WebElement> inventoryPriceList = inventoryPage.getInventoryPriceList();
        List<Double> priceInventoryResultsLowToHigh = new ArrayList();
        List<Double> priceInventoryResultsLowToHighSorted = new ArrayList();
        for(WebElement webElement: inventoryPriceList){
            priceInventoryResultsLowToHigh.add(Double.parseDouble(webElement.getText().replace("$","").trim()));
            priceInventoryResultsLowToHighSorted.add(Double.parseDouble(webElement.getText().replace("$","").trim()));
        }
        Collections.sort(priceInventoryResultsLowToHighSorted); //Ordenamos para compararlo con el otro después
        Assert.assertEquals("list is sorted by price", priceInventoryResultsLowToHighSorted,priceInventoryResultsLowToHigh);
    }

    @When("the user selects {int} random items")
    public void theUserSelectsRandomItems(int num) {

        inventoryPage.addRandomItemByNumber(2);
    }
}