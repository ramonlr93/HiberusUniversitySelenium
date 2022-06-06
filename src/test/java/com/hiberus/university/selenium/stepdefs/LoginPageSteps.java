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
public class LoginPageSteps {

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage(){
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the home page");
        LoginPage loginSaucePage = pf.getLoginPage();
        loginSaucePage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user go to the login page")
    public void theUserGoToTheLoginPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the home page");
        LoginPage loginSaucePage = pf.getLoginPage();
        loginSaucePage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user provides the email {string}")
    public void theUserProvidesTheEmail(String username) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the email");
        LoginPage loginSaucePage = pf.getLoginPage();
        loginSaucePage.enterUsername(username);
    }


    @And("the user provides the password {string}")
    public void theUserProvidesThePassword(String password) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the password");
        LoginPage loginSaucePage = pf.getLoginPage();
        loginSaucePage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the login button");
        LoginPage loginSaucePage = pf.getLoginPage();
        loginSaucePage.clickLogin();
    }

//    @Then("the user is logged successfully")
//    public void theUserIsLoggedSuccessfully() {
//        PagesFactory pf = PagesFactory.getInstance();
//        InventoryPage inventoryPage = pf.getInventoryPage();
//        inventoryPage.waitForPageLoad();
//        String currentURL = PagesFactory.getInstance().getDriver().getCurrentUrl();
//        Assert.assertEquals("the URL is not inventory Page", InventoryPage.PAGE_URL, currentURL);
//    }

    @Then("the user should be shown and invalid message")
    public void theUserShouldBeShownAndInvalidMessage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message");
        LoginPage loginSaucePage = pf.getLoginPage();
        Assert.assertTrue("error message not found", loginSaucePage.hasUsernamePasswordError());
    }

}
