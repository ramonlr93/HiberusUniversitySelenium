package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;


@Slf4j
public class LogoutPageSteps {

    /*
    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the home page");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }
    */

    @Then("the user logout successfully")
    public void theUserIsLogoutSuccessfully() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not inventory Page", InventoryPage.PAGE_URL, currentUrl);
    }



}
