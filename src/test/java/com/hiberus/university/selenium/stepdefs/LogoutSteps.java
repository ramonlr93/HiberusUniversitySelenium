package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LogoutSteps {


    @When("the user clicks on the lateral panel")
    public void theUserClicksOnTheLateralPanel() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.clicksOnLateralPanelButton();
    }

    @And("the user clicks on the log out button")
    public void theUserClicksOnTheLogOutButton() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.clicksOnTheLogoutButton();
    }

    @Then("the page redirects to the login page")
    public void thePageRedirectsToTheLoginPage() {
        assertEquals("PRUEBA FALLIDA: no se ha podido hacer el logout", LoginPage.PAGE_URL, PagesFactory.getInstance().getCurrentUrl());
    }
}
