package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryPageSteps {
    @When("the user is in the inventory page")
    public void theUserIsInTheInventoryPage(){
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        inventoryPage.navigateTo(inventoryPage.PAGE_URL);
    }

    @Then("it shows there are {string} in the inventory")
    public void itShowsThereAreInTheInventory(String items) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        assertEquals("FAILED, the number of products is not 6", items, inventoryPage.getInventoryCount());
    }

    @Then("it shows that the product {string} exists")
    public void itShowsThatTheProductExists(String product) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        assertTrue("FAILED, THE ITEM IT DOESNT EXIST", inventoryPage.isDisplayedItemByName(product));
    }

    @When("the user adds the product {string} to the cart")
    public void theUserAddsTheProductToTheCart(String product) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName(product);

    }

    @Then("it shows in the cart icon that the product was added")
    public void itShowsInTheCartIconThatTheProductWasAdded() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.clickShoppingCart();
        CartPage cartPage = pf.getCartPage();
        int currentCount = cartPage.getItemCount();

        Assert.assertEquals("FAILED, THE PRODUCTS WAS NOT ADDED TO THE CART", 1, currentCount);
    }

    @And("the user added the product {string} to the cart")
    public void theUserAddedTheProductToTheCart(String product) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName(product);

    }

    @When("the user removes the product {string} from the cart")
    public void theUserRemovesTheProductFromTheCart(String product) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.removeItemToCartByName(product);
    }

    @Then("it shows in the cart icon that the product was removed")
    public void itShowsInTheCartIconThatTheProductWasRemoved() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.clickShoppingCart();
        CartPage cartPage = pf.getCartPage();
        int currentCount = cartPage.getItemCount();

        Assert.assertEquals("FAILED, THE PRODUCT WAS NOT DELETED FROM THE CART", 0, currentCount);
    }

    @When("the user adds to the cart")
    public void theUserAddsToTheCart() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getThreeRandomItems();
    }

    @Then("it shows in the cart icon that the three products were added")
    public void itShowsInTheCartIconThatTheProductsWereAdded() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        int numItemsCart = inventoryPage.getThreeRandomItems();

        Assert.assertEquals("FAILED, THE 3 PRODUCTS WERE NOT ADDED", 3, numItemsCart);
    }

    @When("the user clicks the filter button {string}")
    public void theUserClicksTheFilterButton(String optionSort) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.selectOption(optionSort);
    }

    @Then("it shows that the items are sorted by alphabetic desc order")
    public void itShowsThatTheItemsAreSortedByAlphabeticDescOrder() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<WebElement> inventoryList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResult = new ArrayList<>();
        List<String> nameInventoryResultSorted = new ArrayList<>();

        for (WebElement webElement : inventoryList) {
            nameInventoryResult.add(webElement.getText());
            nameInventoryResultSorted.add(webElement.getText());
        }

        Collections.sort(nameInventoryResultSorted);
        Assert.assertEquals("FAILED, THE LIST IS NOT SORTED", nameInventoryResultSorted, nameInventoryResult);
    }

    @Then("it shows that the items are sorted by price - Low to High")
    public void itShowsThatTheItemsAreSortedByPriceLowToHigh() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<WebElement> inventoryList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResult = new ArrayList<>();
        List<String> nameInventoryResultSorted = new ArrayList<>();

        for (WebElement webElement : inventoryList) {
            nameInventoryResult.add(webElement.getText());
            nameInventoryResultSorted.add(webElement.getText());
        }

        Collections.sort(nameInventoryResultSorted);
        Assert.assertEquals("FAILED, THE LIST IS NOT SORTED", nameInventoryResultSorted, nameInventoryResult);
    }

    @Then("it shows that the items are sorted by price - High to Low")
    public void itShowsThatTheItemsAreSortedByPriceHighToLow() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<WebElement> inventoryList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResult = new ArrayList<>();
        List<String> nameInventoryResultSorted = new ArrayList<>();

        for (WebElement webElement : inventoryList) {
            nameInventoryResult.add(webElement.getText());
            nameInventoryResultSorted.add(webElement.getText());
        }

        Collections.sort(nameInventoryResultSorted);
        Assert.assertEquals("FAILED, THE LIST IS NOT SORTED", nameInventoryResultSorted, nameInventoryResult);
    }
}
