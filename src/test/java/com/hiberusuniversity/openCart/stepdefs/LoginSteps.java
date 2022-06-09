package com.hiberusuniversity.openCart.stepdefs;

import com.hiberusuniversity.openCart.pages.LoginPage;
import com.hiberusuniversity.openCart.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();

    @Given("the user is in the login page")
    public void theUserIsOnTheLogInPage() {
        log.info("The user is on the login page");
        loginPage.navigateTo(loginPage.PAGE_URL);
    }

    @And("the user introduces his email {string} and password {string}")
    public void theUserIntroducesHisEmailAndPassword(String email, String password) {
        loginPage.enterEmailPassword(email,password);
    }

    @When("the user click the login button")
    public void theUserClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user login successfully and is redirected to his account {string}")
    public void theUserLoginSuccessfullyAndIsRedirectedToHisAccount(String url) {
        Assert.assertEquals("The user is not on his account",url,pf.getDriver().getCurrentUrl());
    }

    @Then("the user cant log in and is redirected to the login page {string} and shown a message")
    public void theUserCantLogInAndIsRedirectedToTheLoginPageAndShownAMessage(String url ) {
        Assert.assertEquals("The user is not on his account",url,pf.getDriver().getCurrentUrl());
        Assert.assertTrue("The error message is not shown",loginPage.getErrorMessage().isDisplayed());
    }

    @When("the user click in the button to create a new account")
    public void theUserClickInTheButtonContinueToCreateANewAccount() {
        loginPage.clickRegisterButton();
    }

    @Then("the user is redirected to the page of registration {string}")
    public void theUserIsRedirectedToThePageOfRegistration(String url) {
        Assert.assertEquals("The user is not in the registration page",url,pf.getDriver().getCurrentUrl());
    }

    @When("the user click in the section register in the menu")
    public void theUserClickInTheSectionRegisterInTheMenu() {
        loginPage.clickRegisterMenu();
    }

    @When("the user click in the section forgotten password under the login")
    public void theUserClickInTheSectionForgottenPasswordUnderTheLogin() {
        loginPage.clickForgottenPassword();
    }

    @Then("the user is redirected to the page of password recovery {string}")
    public void theUserIsRedirectedToThePageOfPasswordRecovery(String url) {
        Assert.assertEquals("The user is not in the password recovery page",url,pf.getDriver().getCurrentUrl());
    }
}
