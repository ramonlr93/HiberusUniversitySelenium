package org.hiberus.com.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.hiberus.com.pages.HomePage;
import org.hiberus.com.pages.LoginPage;
import org.hiberus.com.pages.PagesFactory;
import org.junit.Assert;

@Slf4j
public class HomePageLoginSteps {
    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the home page");
        HomePage homePage = pf.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);
    }

    @And("the user clicks on myAccountButton")
    public void theUserClicksOnMyAccountButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks myAccountButton");
        HomePage homePage = pf.getHomePage();
        homePage.clickMyAccountButton();
    }

    @When("the user clicks on loginSelectOption")
    public void theUserClicksTheLoginSelectOption() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the login button");
        HomePage homePage = pf.getHomePage();
        homePage.clickLoginSelectOption();
    }

    @Then("the user go to LoginPage")
    public void theUserGoToLoginPage() {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Login Page", LoginPage.PAGE_URL, currentUrl);
    }

}
