package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.BasePage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();

    @Given("the user go to the home page")
    public void theUserGoToTheHomePage(){
        LoginPage loginPage = pf.getLoginPage();
        loginPage.navigateTo(BasePage.PAGE_URL);
    }

    @And("the user go to the login page")
    public void theUserGoToTheLoginPage() {
        LoginPage loginPage = pf.getLoginPage();
        loginPage.goToLogin();
    }

    @And("the user provides the email {string}")
    public void theUserProvidesTheEmail(String username) {
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername(username);
    }


    @And("the user provides the password {string}")
    public void theUserProvidesThePassword(String password) {
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        LoginPage loginPage = pf.getLoginPage();
        loginPage.clickLogin();
    }

    @Then("the user is logged successfully")
    public void theUserIsLoggedSuccessfully() {
        String currentURL = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not inventory Page","https://opencart.abstracta.us/index.php?route=account/account", currentURL);
    }

    @Then("the user should be shown and invalid message")
    public void theUserShouldBeShownAndInvalidMessage() {
        LoginPage loginPage = pf.getLoginPage();
        Assert.assertTrue("error message not found", loginPage.hasUsernamePasswordError());
    }

}
