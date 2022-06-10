package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryItemPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class InventoryPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private InventoryPage inventoryPage = pf.getInventoryPage();
    private InventoryItemPage inventoryItemPage = pf.getInventoryItemPage();
    private WebDriver driver = pf.getDriver();


    @Given("the user navigates to the inventory page")
    public void theUserNavigatesToTheInventoryPage() {
        driver.get(InventoryPage.PAGE_URL);
    }

    @Given("the user is in the inventory page")
    public void theUserIsInTheInventoryPage() {
        Assert.assertEquals("The user is not in the register page", InventoryPage.PAGE_URL, driver.getCurrentUrl());

    }

    @And("the user add the item {string}")
    public void theUserAddTheItem(String text) {
        inventoryPage.addItemToCartByName(text);
        if (driver.getCurrentUrl() != InventoryPage.PAGE_URL) {
            inventoryItemPage.waitForPageLoad();
            inventoryItemPage.select(0, 1);
            inventoryItemPage.clickAddToCart();
        }
    }

    @Then("the user can see added item message with the text {string}")
    public void theUserCanSeeAddedItemMessage(String text) {
        Assert.assertTrue("The item name don't appear in the message", inventoryPage.addedItemMessageHaveText(text));
    }

    @When("the user press the checkout button")
    public void theUserPressTheCheckoutButton() {
        inventoryPage.clickButtonCheckout();
    }
}