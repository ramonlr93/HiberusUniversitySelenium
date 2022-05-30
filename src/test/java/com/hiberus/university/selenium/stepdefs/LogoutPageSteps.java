package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.BasePage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class LogoutPageSteps {




    @And("the user clicks the menuButton")
    public void theUserClicksTheMenuButton() {
        PagesFactory pf = PagesFactory.getInstance();
        BasePage basePage = pf.getBasePage();
        basePage.clickMenuButton();
    }

    @When("the user clicks the logout link")
    public void theUserClicksTheLogoutLink() {
        PagesFactory pf = PagesFactory.getInstance();
        BasePage basePage = pf.getBasePage();
        basePage.clickLogoutLink();
    }

    @Then("the user is in the login page")
    public void theUserIsInTheLoginPage() {
        PagesFactory pf = PagesFactory.getInstance();
        Assert.assertEquals("Wrong url", pf.getLoginPage().PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}
