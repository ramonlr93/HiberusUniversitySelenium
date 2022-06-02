package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

@Slf4j
public class InventoryPageSteps {


  @And("the user adds a {string} by clicking 'Add To Cart'")
  public void theUserAddsAByClickingAddToCart(String itemName) {
    log.info("the user adds " + itemName + " by 'Add To Cart'");
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    inventoryPage.addItemToCartByName(itemName);
  }

  @And("the user clicks on the shopping cart")
  public void theUserClicksOnTheShoppingCart() {
    log.info("the user clicks on the shopping cart");
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    inventoryPage.clickOnShoppingCart();
  }

  @Then("the user see the inventory list with {string} size list")
  public void theUserSeeTheInventoryListWith(String itemSize) {
    log.info("the user see the item list");
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    Assert.assertEquals("the item list size is different", Integer.parseInt(itemSize),
      inventoryPage.getInventoryNameList().size());
  }

  @Then("the user see the {string} in the inventory list")
  public void theUserSeeTheInTheInventoryList(String itemName) {
    log.info("the user see the item list");
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    Assert.assertTrue("the item not exist in inventory list",
      inventoryPage.existProductInInventoryList(itemName));
  }

  @And("the user selects")
  public void theUserSelects(DataTable dataTable) {
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    List<String> selectedItems = dataTable.asList(String.class);
    for (String itemName : selectedItems)
    {
      log.info("the user selects " + itemName);
      inventoryPage.addItemToCartByName(itemName);
    }
  }

  @And("the user clicks select {string}")
  public void theUserClicksSelect(String optionSort) {
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    inventoryPage.selectOption(optionSort);
  }

  @Then("the user see the list by alphabetical desc order")
  public void theUserSeeTheListByAlphabeticalDescOrder() {
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    List<WebElement> inventoryList = inventoryPage.getInventoryNameList();
    List<String> nameInventoryResult = new ArrayList<>();
    List<String> nameInventoryResultSorted = new ArrayList<>();
    for (WebElement webElement : inventoryList) {
      nameInventoryResult.add(webElement.getText());
      nameInventoryResultSorted.add(webElement.getText());
    }
    nameInventoryResultSorted.sort(Collections.reverseOrder());
    Assert.assertEquals("list is not sorted",
      nameInventoryResultSorted, nameInventoryResult);
  }

  @Then("the user see the list by price desc order")
  public void theUserSeeTheListByPriceDescOrder() {
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    List<WebElement> inventoryPriceList = inventoryPage.getInventoryPriceList();
    List<Double> priceInventoryResultsHighToLow = new ArrayList<>();
    List<Double> priceInventoryResultsHighToLowSorted = new ArrayList<>();
    for (WebElement webElement : inventoryPriceList) {
      priceInventoryResultsHighToLow.add(
        Double.parseDouble(webElement.getText().replace("$", "").trim()));
      priceInventoryResultsHighToLowSorted.add(
        Double.parseDouble(webElement.getText().replace("$", "").trim()));
    }
    priceInventoryResultsHighToLowSorted.sort(Collections.reverseOrder());
    Assert.assertEquals("list is sorted by price",
      priceInventoryResultsHighToLowSorted, priceInventoryResultsHighToLow);
  }
}
