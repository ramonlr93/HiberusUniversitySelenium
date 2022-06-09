package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.UserPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class UserSteps {
    @Given("the user is logged on the user page")
    public void theUserIsLoggedOnTheUserPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is in the user Page");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
        loginPage.fillEmail("ojmeneses@hiberus.com");
        loginPage.fillPassword("encryptedPass");
        loginPage.clickOnLogin();
    }

    @When("user clicks on Your Store label")
    public void userClicksOnYourStoreLabel() throws InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicking on the main inventory page link");
        UserPage userPage=pf.getUserPage();
        userPage.clickOnHomePage();
    }

    @Then("{string} is displayed")
    public void isDisplayed(String mainInventory) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Validating the user is in the main inventory page");
        UserPage userPage= pf.getUserPage();
        Assert.assertEquals("Main inventory page not displayed", mainInventory, userPage.currentPage());
    }
}
