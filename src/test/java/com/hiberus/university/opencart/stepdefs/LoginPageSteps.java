package com.hiberus.university.opencart.stepdefs;

import com.hiberus.university.opencart.pages.AccountPage;
import com.hiberus.university.opencart.pages.ForgottenPasswordPage;
import com.hiberus.university.opencart.pages.LoginPage;
import com.hiberus.university.opencart.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginPageSteps {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the login page");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @And("the user provides the email {string}")
    public void theUserProvidesTheEmail(String email) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the email");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterEmail(email);
    }

    @And("the user provides the password {string}")
    public void theUserProvidesThePassword(String password) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the password");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the login button");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.clickLogin();
    }

    @Then("the user is logged successfully")
    public void theUserIsLoggedSuccessfully() {
        PagesFactory pf = PagesFactory.getInstance();
        AccountPage accountPage = pf.getAccountPage();
        accountPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not account Page", AccountPage.PAGE_URL, currentUrl);
    }

    @Then("the user should be shown an invalid message")
    public void theUserShouldBeShownAnInvalidMessage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message");
        LoginPage loginPage = pf.getLoginPage();
        Assert.assertTrue("error message not found", loginPage.hasUsernamePasswordError());
    }

    @When("the user clicks the login button multiple times")
    public void theUserClicksTheLoginButtonMultipleTimes() {
        for(int i = 0; i <= 5; i = i + 1){
            PagesFactory pf = PagesFactory.getInstance();
            log.info("The user clicks the login button multiple times");
            LoginPage loginPage = pf.getLoginPage();
            loginPage.clickLogin();
        }
    }

    @Then("the user should be shown an invalid message due to maximum number of login attempts")
    public void theUserShouldBeShownAnInvalidMessageLoginAttempts() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to maximum number of login attempts");
        LoginPage loginPage = pf.getLoginPage();
        Assert.assertTrue("error message not found", loginPage.loginAttemptsError());
    }

    @And("the user clicks the forgotten password link")
    public void theUserClicksTheForgottenPasswordLink() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the forgotten password link");
        LoginPage loginPage = pf.getLoginPage();
        loginPage.clickForgottenPasswordLink();
    }

    @And("the user enter the email {string} to request a password reset")
    public void theUserEnterTheEmailToRequestPasswordReset(String email) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the email to request a password reset");
        ForgottenPasswordPage forgottenPasswordPage = pf.getForgottenPasswordPage();
        forgottenPasswordPage.enterEmail(email);
    }

    @When("the user clicks the continue button to request a password reset")
    public void theUserClicksContinueButtonToRequestPasswordReset() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the email to request a password reset");
        ForgottenPasswordPage forgottenPasswordPage = pf.getForgottenPasswordPage();
        forgottenPasswordPage.clickContinueButton();
    }

    @Then("the user should be shown an email confirmation message")
    public void theUserShouldBeShownAnEmailConfirmationMessage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an email confirmation message");
        LoginPage loginPage = pf.getLoginPage();
        Assert.assertTrue("success message not found", loginPage.emailConfirmation());
    }
}