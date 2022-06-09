package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.MainInventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.UserPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class MainInventorySteps {
    @Given("the user is logged on and in the main inventory page")
    public void theUserIsLoggedOnAndInTheMainInventoryPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Going to main inventory page");
        LoginPage loginPage = pf.getLoginPage();
        UserPage userPage= pf.getUserPage();;
        loginPage.navigateTo(LoginPage.PAGE_URL);
        loginPage.fillEmail("ojmeneses@hiberus.com");
        loginPage.fillPassword("encryptedPass");
        loginPage.clickOnLogin();
        userPage.clickOnHomePage();
    }
    @When("user clicks on Phones & PDAS menu")
    public void userClicksOnPhonesPDASMenu() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Clicking on Phones & PDAs");
        MainInventoryPage mainInventoryPage= pf.getMainInventoryPage();
        mainInventoryPage.clickOnPhonesAndPDAS();
    }

    @Then("Phones & PDAS store {string} is displayed")
    public void phonesPDASStoreIsDisplayed(String url) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Verifying current url");
        MainInventoryPage mainInventoryPage= pf.getMainInventoryPage();
        Assert.assertEquals("Mobile devices store not displayed",url,mainInventoryPage.currentWeb());
    }
}
