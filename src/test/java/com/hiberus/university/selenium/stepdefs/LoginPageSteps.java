package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
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

    @Given("the user is in the home page")
    public void theUserIsInTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is in the home page");
        HomePage homePage = pf.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);
    }

    @And("the user clicks to go to the login page")
    public void theUserClicksToGoToTheLoginPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user goes to the login page");
        HomePage homePage = pf.getHomePage();
        homePage.clickGoToLogin();
    }

    @And("the user is in the login page")
    public void theUserIsInTheLoginPage(){
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is in the login page");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user provides the username {string}")
    public void theUserProvidesTheUsername(String email) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides de email");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterEmail(email);
    }

    @And("the user provides the password {string}")
    public void theUserProvidesThePassword(String password) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides de password");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks teh login button");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.clickLogin();
    }

    @Then("the user log in succesfully")
    public void theUserLogInSuccesfully() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user logged in succesfully");

        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        String mustBeUrl = "https://opencart.abstracta.us/index.php?route=account/account";
        Assert.assertEquals("the URL is not correct", mustBeUrl, currentUrl);

    }

    @Then("the user cant login")
    public void theUserCantLogin() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should not be able to log in");
        LoginPage loginPage = pf.getLoginPage();
        Assert.assertTrue("Error message not found", loginPage.hasUsernamePasswordError());
    }


}
