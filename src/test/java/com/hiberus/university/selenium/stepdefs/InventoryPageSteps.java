package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class InventoryPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();


    @When("the user is in the inventory page")
    public void theUserIsInTheInventoryPage() {
        log.info("The user is on the inventory page");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.navigateTo(InventoryPage.PAGE_URL);
    }


    @Then("the number of items is six")
    public void theNumberOfItemsIsSix() {
        log.info("The number of items is 6");
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertEquals("The number of items isnt 6", 6, inventoryPage.getNumberOfItems());
    }

    @Then("the the item {string} exist in the inventory")
    public void theTheItemExistInTheInventory(String name) {
        Assert.assertTrue("The item doesnt exist", inventoryPage.findItemByName(name));
    }

    @When("the user clicks in the button {string} of the item {string}")
    public void theUserClicksInTheButtonOfTheItem(String buttonName, String itemName) {
        if(buttonName.equals("add to cart")){
            inventoryPage.addItemToCartByName(itemName);
        } else if (buttonName.equals("remove")){
            inventoryPage.removeItemFromCart(itemName);
        }

    }

    @Then("the user should see a one on the cart icon")
    public void theUserShouldSeeAOneOnTheCartIcon() {
        Assert.assertEquals("The cart number isnt 1", 1, Integer.parseInt(inventoryPage.getShoppingCartNumber()));
    }



    @Then("the user should see the cart icon empty")
    public void theUserShouldSeeTheCartIconEmpty() {
        Assert.assertEquals("The cart number should be disabled", "", inventoryPage.getShoppingCartNumber());
    }

    @And("the user clicks in the button add-to-cart of three random items")
    public void theUserClicksInTheButtonOfThreeRandomItems() {
        List<String> names = inventoryPage.getItemNames();
        Collections.shuffle(names);
        for(int i=0;i<3;i++){
            inventoryPage.addItemToCartByName(names.get(i));
        }
    }

    @Then("the user should see a three on the cart icon")
    public void theUserShouldSeeAThreeOnTheCartIcon() {
        Assert.assertEquals("The cart number isnt 3", 3, Integer.parseInt(inventoryPage.getShoppingCartNumber()));
    }

    @When("the user select the filter {string}")

    public void theUserSelectTheFilter(String filtreName) {
        inventoryPage.sortOption(filtreName);
    }

    @Then("the selected filter sort by alphabetic order")
    public void theSelectedFilterSortByAlphabeticOrder() {
        List<String> baseSortedItems = inventoryPage.getItemNames();
        Collections.sort(baseSortedItems);
        Assert.assertEquals("Isnt sorted alphabetically"
                , baseSortedItems
                , inventoryPage.sortFromAToZ());
    }

    @Then("the selected filter sort by alphabetic reverse order")
    public void theSelectedFilterSortByAlphabeticReverseOrder() {
        List<String> baseSortedItems = inventoryPage.getItemNames();
        Collections.sort(baseSortedItems, Collections.reverseOrder());
        Assert.assertEquals("Isnt sorted alphabetically reverse"
                , baseSortedItems
                , inventoryPage.sortFromAToZ());
    }

    @Then("the selected filter sort from lower to higher")
    public void theSelectedFilterSortFromLowerToHigher() {
        List<Double> baseSortedItems = inventoryPage.getItemPrices();
        Collections.sort(baseSortedItems);
        Assert.assertEquals("Isnt sorted from L to H"
                , baseSortedItems
                , inventoryPage.sortFromLoToHi());
    }

    @Then("the selected filter sort from higher to lower")
    public void theSelectedFilterSortFromHigherToLower() {
        List<Double> baseSortedItems = inventoryPage.getItemPrices();
        Collections.sort(baseSortedItems, Collections.reverseOrder());
        Assert.assertEquals("Isnt sorted from H to L"
                , baseSortedItems
                , inventoryPage.sortFromHiToLo());
    }

    @When("the user goes to checkout")
    public void theUserGoesToCheckout() {
        inventoryPage.clickOnCheckout();
    }
}
