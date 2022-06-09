package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
@Slf4j
public class HomeSteps {
    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Home Page");
        HomePage homePage= pf.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);
    }
    @When("the user selects register option by My Account combobox")
    public void theUserSelectsRegisterOptionByMyAccountCombobox() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user selects register option by My Account combobox");
        HomePage homePage=pf.getHomePage();
        homePage.clicRegister();
    }

    @Then("Register {string} is displayed")
    public void registerUrlIsDisplayed(String registerWeb) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Register url is displayed");
        HomePage homePage=pf.getHomePage();
        Assert.assertEquals("Register page not loaded",registerWeb,homePage.currentPage());
    }

    @When("the user selects login option by My Account combobox")
    public void theUserSelectsLoginOptionByMyAccountCombobox() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user selects login option by My Account combobox");
        HomePage homePage=pf.getHomePage();
        homePage.clicLogin();
    }

    @Then("Login {string} is displayed")
    public void loginIsDisplayed(String loginWeb) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Register url is displayed");
        HomePage homePage=pf.getHomePage();
        Assert.assertEquals("Login page not loaded",loginWeb,homePage.currentPage());
    }
}
