package com.opencart.stepdefs;

import com.opencart.pages.LoginPage;
import com.opencart.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginPageSteps {

    private LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = PagesFactory.getInstance().getLoginPage();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheHomePage() {
        log.info("The user is on the Home Page");
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user enters the {string} and {string}")
    public void theUserEntersTheAnd(String name, String password) {
        loginPage.enterEmail(name);
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the user is logged successfully")
    public void theUserIsLoggedSuccessfully() {
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("The user is not logged in", "https://opencart.abstracta.us/index.php?route=account/account", currentUrl);
    }

    @Then("the error message is shown")
    public void theErrorMessageIsShown() {
        Assert.assertTrue("Error mesagge is NOT shown", loginPage.isErrorMessageDisplayed());
    }
}
