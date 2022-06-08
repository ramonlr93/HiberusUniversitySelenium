package com.opencart.practicafinal.stepdefs;

import com.opencart.practicafinal.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LogoutPageSteps {

    // Creamos una instancia de las pages
    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = pf.getBasePage();
    LoginPage lp = pf.getLoginPage();
    HomePage hp = pf.getHomePage();
    AccountPage ap = pf.getAccountPage();

    @When("the user clicks on logout button")
    public void theUserClicksOnLogoutButton() {
        bp.clickMyAccount();
        bp.clickLogout();
    }

    @Then("the user is in logout page")
    public void theUserIsInLogoutPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("The user isnt in the correct page", LogoutPage.PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}