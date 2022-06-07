package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class InventoryPageSteps {


    @And("the user goes to the Mobile Phones & PDAs page")
    public void theUserGoesToTheMobilePhonesPDAsPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is in the Phones and PDAs page");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.navigateTo(InventoryPage.PAGE_URL);
    }

    @When("the user add {string} item to the cart")
    public void theUserAddOneItemToTheCart(String number){
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user adds one item to the cart");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCart(number);
    }

    @Then("it shows that the item was added")
    public void itShowsThatTheItemWasAdded() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("It shows that the item was added");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addedItemMessage();
    }

    @When("the user removes the item from cart")
    public void theUserRemovesTheItemFromCart() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user removes the item from cart");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.removeItemFromCart();
    }

    @Then("it shows the item was removed")
    public void itShowsTheItemWasRemoved() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("It shows the item was removed");
        InventoryPage inventoryPage = pf.getInventoryPage();
        int currentCount = inventoryPage.getCartCount();
        Assert.assertEquals("The number of item on cart is not 0", 0, currentCount);
    }

    @When("the user adds two items to the cart")
    public void theUserAddsTwoItemsToTheCart() {
    }

    @Then("it shows that the {int} items were added")
    public void itShowsThatTheItemsWereAdded(int arg0) {
    }
}
