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

@Slf4j
public class LoginPageSteps {

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        log.info("The user is on the Home Page");
        LoginPage loginPage = PagesFactory.getInstance().getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user provides the username {string} and password {string}")
    public void theUserProvidesTheUsernameAndPassword(String username, String password) {
        log.info("The user provides the username and password");
        LoginPage loginPage = PagesFactory.getInstance().getLoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        log.info("The user clicks the 'Login' button");
        LoginPage loginPage = PagesFactory.getInstance().getLoginPage();
        loginPage.clickLogin();
    }

    @Then("the user is logged successfully and is into the inventory page")
    public void theUserIsLoggedSuccessfullyAndIsIntoTheInventoryPage() {
        log.info("The user should login successfully and is brought to the inventory page");
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.waitForPageLoad();

        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not inventory Page", InventoryPage.PAGE_URL, currentUrl);
    }

    @Then("The user should be shown an invalid message")
    public void theUserShouldBeShownAnInvalidMessage() {
        log.info("The user should be shown an invalid username/password message");
        LoginPage loginPage = PagesFactory.getInstance().getLoginPage();
        Assert.assertTrue(loginPage.hasUsernamePasswordError());
    }
}
