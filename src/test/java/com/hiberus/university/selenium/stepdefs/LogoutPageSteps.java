package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LogoutPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();
    InventoryPage inventoryPage = pf.getInventoryPage();


    @When("the user clicks the logout option")
    public void logoutOption() {
        inventoryPage.logout();
    }

    @Then("the user is again on the home page")
    public void loginPage() {
        Assert.assertEquals("logout failed",
                LoginPage.PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}
