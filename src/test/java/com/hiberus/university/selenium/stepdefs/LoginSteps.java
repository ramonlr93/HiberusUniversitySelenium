package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginSteps {
    @Given("the user is on the login page")
    public void theUserIsOnTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Login Page");
        LoginPage loginPage=pf.getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("input email {string} in email field")
    public void inputEmailInEmailField(String email) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Introducing email");
        LoginPage loginPage=pf.getLoginPage();
        loginPage.fillEmail(email);
    }

    @And("input password {string} in password field")
    public void inputPasswordInPasswordField(String password) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Introducing password");
        LoginPage loginPage=pf.getLoginPage();
        loginPage.fillPassword(password);
    }

    @When("clics on Login button")
    public void clicsOnLoginButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Clicking on login button");
        LoginPage loginPage=pf.getLoginPage();
        loginPage.clickOnLogin();
    }

    @Then("Your Store webpage is displayed")
    public void yourStoreWebpageIsDisplayed(String yourStore) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Displaying Your Store web page");
        LoginPage loginPage=pf.getLoginPage();
        Assert.assertEquals("Not logged", yourStore, loginPage.loginSucceed());
    }
}
