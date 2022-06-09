package org.hiberus.com.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.hiberus.com.pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

@Slf4j
public class LoginPageSteps {

    @And("the user introduces his email {string} and password {string}")
    public void theUserIsOnTheHomePage(String email, String password) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the home page");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("the user clicks on the login button")
    public void theUserClicksOnTheShoppingCart() {
        log.info("the user clicks on the login button");
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.clickLogin();
    }

    @Then("the user see Your Store Page")
    public void theUserSeeYourStorePage() {
        log.info("the user see Your Store Page");
        PagesFactory pf = PagesFactory.getInstance();
        StorePage storePage = pf.getStorePage();
        storePage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Store Page", StorePage.PAGE_URL, currentUrl);

    }

    @Then("the user should be shown an error message")
    public void theUserShouldBeShownAndInvalidMessage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message");
        LoginPage loginPage = pf.getLoginPage();
        boolean isTrue = loginPage.hasUsernamePasswordError();
        Assert.assertTrue("error message not found", isTrue);
    }
}
