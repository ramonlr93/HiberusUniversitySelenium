package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = pf.getBasePage();




    @When("the user clicks the logout button")
    public void theUserClickTheLogoutButton() {
        bp.clickMyAccount();
        bp.clickLogout();
    }
    @Then("the user is in the logout page")
    public void theUserIsInTheLogoutPage() {
        PagesFactory pf = PagesFactory.getInstance();
        Assert.assertEquals("Wrong url", LogoutPage.PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}
