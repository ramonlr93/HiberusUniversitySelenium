package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

@Slf4j
public class CartPageSteps {

    @When("the user goes to the cart page")
    public void theUserGoesToTheCartPage(){
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user goes to the cart page");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.waitForPageLoad();
        inventoryPage.goToCartButton();
    }

    @Then("the user updates and deletes items in the cart")
    public void theUserUpdatesAndDeletesTheCart() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user updates the cart");
        CartPage cartPage = pf.getCartPage();
        cartPage.waitForPageLoad();
        cartPage.updateItemFromCart();
        cartPage.waitForPageLoad();
        cartPage.removeItemFromCart();
    }

    @Then("it shows a message that the cart was updated")
    public void itShowsAMessageThatTheCartWasUpdated() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("A message showing the cart was updated succesfully");
        CartPage cartPage = pf.getCartPage();
        cartPage.waitForPageLoad();
        Assert.assertTrue("Updated message not found", cartPage.updatedCartMessage());
        log.info("The cart was updated succesfully");
    }
}
