package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPageSteps {

    PagesFactory pf;
    LoginPage loginPage;
    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        pf = PagesFactory.getInstance();
        loginPage = pf.getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user provides the username {string}")
    public void theUserProvidesTheUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("the user provides the password {string}")
    public void theUserProvidesThePassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLogin();

    }

    @Then("the user is logged successfully and is into the inventory page")
    public void theUserIsLoggedSuccessfullyAndIsIntoTheInventoryPage() {
        pf.getInventoryPage().waitForPageLoad();
        assertEquals("PRUEBA FALLIDA: El login no se ha realizado correctamente", InventoryPage.PAGE_URL, pf.getCurrentUrl());
    }

    @Then("the page shows a error message")
    public void thePageShowsAErrorMessage() {
        assertTrue("PRUEBA FALLIDA: No aparece el mensaje de error", loginPage.hasErrorMessage());
    }
}
