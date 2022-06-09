package org.hiberus.com.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.hiberus.com.pages.HomePage;
import org.hiberus.com.pages.PagesFactory;
import org.hiberus.com.pages.RegisterPage;
import org.junit.Assert;

@Slf4j
public class HomePageRegisterSteps {
    /*
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
    */
    @When("the user clicks on registerSelectOption")
    public void theUserClicksTheLoginSelectOption() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the register button");
        HomePage homePage = pf.getHomePage();
        homePage.clickRegisterSelectOption();
    }


    @Then("the user go to RegisterPage")
    public void theUserGoToLoginPage() {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Login Page", RegisterPage.PAGE_URL, currentUrl);
    }

}
