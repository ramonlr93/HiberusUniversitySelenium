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
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();


    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        log.info("The user is on the home page");
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user provides the username {string}")
    public void theUserProvidesTheUsername(String username) {
        log.info("The user provides the username");
        loginPage.enterUsername(username);
    }

    @And("the user provides the password {string}")
    public void theUserProvidesThePassword(String password) {
        log.info("The user provides the password");
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        log.info("The user clicks the login button");
        loginPage.clickLogin();
    }

    @Then("the user is logged successfully")
    public void theUserIsLoggedSuccessfully() {
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.waitForPageLoad();
        String currentUrl = pf.getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not inventory Page", InventoryPage.PAGE_URL, currentUrl);
    }

    @Then("the user should be shown and invalid message")
    public void theUserShouldBeShownAndInvalidMessage() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue("error message not found", loginPage.hasMessageError());
    }
}
