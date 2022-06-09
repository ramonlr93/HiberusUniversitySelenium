package com.practicafinal.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import com.practicafinal.pages.LoginPage;
import com.practicafinal.pages.PagesFactory;

import static com.practicafinal.support.Hooks.driver;

@Slf4j
public class LoginPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage lp = pf.getLoginpage();


    @And("the user provides the username {string} and password {string}")
    public void theUserProvidesTheUsernameAndPassword(String arg0, String arg1) {
        lp.fillLoginForm(arg0,arg1);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        lp.clickLogin();
    }

    @Then("the user is logged successfully and is into the account page")
    public void theUserIsLoggedSuccessfullyAndIsIntoTheAccountPage() {
        String URL ="https://opencart.abstracta.us/index.php?route=account/account";
        Assert.assertEquals("the url is not the same",URL,driver.getCurrentUrl());
    }

    @And("the user provides the username {string} and  wrong password {string}")
    public void theUserProvidesTheUsernameAndWrongPassword(String arg0, String arg1) {
        lp.fillLoginForm(arg0, arg1);
    }

    @Then("The user should be shown an invalid message")
    public void theUserShouldBeShownAnInvalidMessage() {
       Assert.assertTrue("the error message is not shown",lp.errorIsShown());
    }

    @And("the user clicks on forgot password")
    public void theUserClicksOnForgotPassword() {
        lp.forgotPass();
    }

    @And("the user provides the username {string} and continue")
    public void theUserProvidesTheUsernameAndContinue(String email) {
        lp.enterEmail(email);
    }

    @Then("The user should be shown an info message")
    public void theUserShouldBeShownAnInfoMessage() {
        Assert.assertTrue("the message is not displayed",lp.infoMeessageIsShown());
    }
}
