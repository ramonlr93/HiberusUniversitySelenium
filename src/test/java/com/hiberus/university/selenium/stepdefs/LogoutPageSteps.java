package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LogoutPageSteps {
    @When("the user clicks the logout button")
    public void theUserClicksTheLogoutButton(){
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        inventoryPage.clickSidebarButton();
        inventoryPage.clickLogoutButton();
    }

    @Then("the user should have logged out and be in the log in page")
    public void theUserShouldHaveLoggedOutAndBeInTheLogInPage() {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.waitForPageLoad();

        String currentURL = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Login Page", LoginPage.PAGE_URL, currentURL);
    }
}
