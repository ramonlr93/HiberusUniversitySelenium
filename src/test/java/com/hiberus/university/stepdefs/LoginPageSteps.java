package com.hiberus.university.stepdefs;

import com.hiberus.university.pages.AccountPage;
import com.hiberus.university.pages.LoginPage;
import com.hiberus.university.pages.PagesFactory;
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
    AccountPage accountPagePage = pf.getAccountPage();

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
       Assert.assertEquals("login failed",
                AccountPage.PAGE_URL, pf.getDriver().getCurrentUrl());
    }

    @Then("the user should be shown an invalid message \"login failed\"")
    public void ErrorMessageDisplayed() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue("Error message isn't displayed", loginPage.hasLoginInputError());
    }

    @And("the user clicks the \"Forgotten Password\" link")
    public void theUserClickLink() {
        loginPage.clickForgottenPasswordLink();
    }

    @When("the user clicks the continue button to recover the password")
    public void theUserClickContinueButton() {
        loginPage.clickContinueForgottenPasswordLink();
    }

    @Then("the user should be shown the message \"An email with a confirmation link has been sent your email address.\"")
    public void AlertConfirmationLinkDisplayed() {
        log.info("The user should be shown a valid message");
        Assert.assertTrue("Error message isn't displayed", loginPage.hasForgottenPasswordAlert());
    }
}
