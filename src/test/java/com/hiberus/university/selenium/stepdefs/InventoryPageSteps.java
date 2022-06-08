package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class InventoryPageSteps {

    @When("the user clicks on cart button")
    public void theUserClicksOnCartButton() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
        inventoryPage.clickOnCartButton();
    }

    @Then("the cart button shows {int} products")
    public void theCartButtonShowsItem(int number) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
        Assert.assertTrue("The cart does not show "+number+ " products on cart", number== inventoryPage.numberOfProductsOnCart());
    }

    @When("the user clicks on remove button")
    public void theUserClicksOnRemoveButton() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
        inventoryPage.removeProductFromCart();
    }

    @When("the user adds {int} product to the cart")
    public void theUserAddsProductToTheCart(int numberOfProducts) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
        for (int i=0;i<numberOfProducts;i++){
            inventoryPage.addRandomProductToCart();
        }
    }

    @When("the user adds {string} to the cart")
    public void theUserAddsProductToTheCart(String product) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
        inventoryPage.addProductToCartByName(product);
    }


    @And("the user is shown a success message")
    public void theUserIsShownASuccessMessage() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
        Assert.assertTrue("The user is not shown a success message",inventoryPage.successMessageAddedToCart());
    }

    @Then("{string} products are shown")
    public void productsAreShown(String numberOfProducts) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
        Assert.assertEquals("Not" + numberOfProducts + "products shown", Integer.parseInt(numberOfProducts), inventoryPage.numberOfProductsShown());
    }

    @Then("the {string} is shown")
    public void theIsShown(String product) {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
    }

    @And("the user clicks the cart button")
    public void theUserClicksTheCartButton() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getCartPage();
        inventoryPage.clickOnCartButton();

    }
}
