package com.hiberus.university.opencart.stepdefs;

import com.hiberus.university.opencart.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LogoutPageSteps {

    @Given("the user is on the logout page")
    public void theUserIsOnTheLogoutPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the login page");
        LogoutPage logoutPage = pf.getLogoutPage();
        logoutPage.navigateTo(LoginPage.PAGE_URL);
    }

    @When("the user clicks the logout button")
    public void theUserClicksTheLogoutButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the logout button");
        AccountPage accountPage = pf.getAccountPage();
        accountPage.clickLogout();
    }

    @Then("the user is successfully logged out")
    public void theUserIsLoggedOutSuccessfully() {
        PagesFactory pf = PagesFactory.getInstance();
        LogoutPage logoutPage = pf.getLogoutPage();
        logoutPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not logout Page", LogoutPage.PAGE_URL, currentUrl);
    }
}
