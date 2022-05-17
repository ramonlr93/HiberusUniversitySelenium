package com.hiberus.university.selenium.stepsdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginPageSteps {
    
    @Given("the user is on the home page")
    public void theUserIsInTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("the user is on the home page");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user provides the username {string}")
    public void theUserProvidesTheUsername(String username) {
        log.info("The user provides the username");
        
    }

    @And("the user provides the password {string}")
    public void theUserProvidesThePassword(String arg0) {
        
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        
    }

    @Then("the user show error message")
    public void theUserShowErrorMessage() {
        
    }

    @Then("the user should be shown an invalid message")
    public void theUserShouldBeShownAnInvalidMessage() {
    }
}
