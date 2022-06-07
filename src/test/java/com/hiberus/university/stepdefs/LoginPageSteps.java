package com.hiberus.university.stepdefs;

import com.hiberus.university.pages.LoginPage;
import com.hiberus.university.pages.PagesFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();

    @Given("the user is on the login page")
    public void userInTheLogin() {
        log.info("The user is on the login page");
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @When("the user clicks the login button")
    public void theUserClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user is logged successfully")
    public void theUserIsLogged() {
        String myAccountPageURL = "https://opencart.abstracta.us/index.php?route=account/account";
        Assert.assertEquals("login failed",
                myAccountPageURL, pf.getDriver().getCurrentUrl());
    }

    @Then("the user should be shown and invalid message")
    public void ErrorMessageDisplayed() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue("Error message isn't displayed", loginPage.hasLoginError());
    }

}
