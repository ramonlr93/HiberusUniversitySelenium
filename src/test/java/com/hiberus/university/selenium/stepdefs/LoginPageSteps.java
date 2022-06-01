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
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();

    @Given("the user is on the home page")
    public void userInTheLogin() {
        log.info("The user is on the home page");
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user provides the username {string}")
    public void username(String username) {
        log.info("The user provides the username");
        loginPage.enterUsername(username);
    }

    @And("the user provides the password {string}")
    public void password(String password) {
        log.info("The user provides the password");
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the user is logged successfully")
    public void theUserIsLogged() {
        Assert.assertEquals("login failed",
                InventoryPage.PAGE_URL, pf.getDriver().getCurrentUrl());
    }

    @Then("the user should be shown and invalid message")
    public void theUserShouldBeShownAndInvalidMessage() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue("Error message isn't displayed", loginPage.hasUsernamePasswordError());
    }

}
