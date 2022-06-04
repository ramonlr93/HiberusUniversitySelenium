package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.AccountSuccessPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;

@Slf4j
public class RegisterPageSteps {

    @Given("the user is on the register page")
    public void theUserIsOnTheRegisterPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Register Page");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.navigateTo(RegisterPage.REGISTER_PAGE_URL);
    }

    @And("the user provides new Personal Details {string}, {string}, {string} and {string}")
    public void theUserNewProvidesPersonalDetailsAnd(String firstname, String lastname, String email, String telephone) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the Personal Details");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterFirstname(firstname);
        registerPage.enterLastname(lastname);
        registerPage.enterEmail(RandomStringUtils.randomAlphanumeric(10) + email);
        registerPage.enterTelephone(telephone);
    }

    @And("the user provides and confirm the password {string}, {string}")
    public void theUserProvidesAndConfirmThePassword(String password, String passwordConfirm) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides and confirm the password");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterPassword(password);
        registerPage.enterPasswordConfirm(passwordConfirm);
    }

    @And("the user clicks the Privacy Policy checkButton")
    public void theUserClicksOnThePrivacyPolicyCheck() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks on the Privacy Policy checkButton");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickPrivacyPolicyButton();
    }

    @When("the user clicks the Continue button")
    public void theUserClicksTheContinueButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the Continue button");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickContinueButton();
    }

    @Then("the user register successfully")
    public void theUserIsRegisterSuccessfully() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should register successfully and is brought to 'Account Success Page' page");
        AccountSuccessPage accountSuccessPage = pf.getAccountSuccessPage();
        accountSuccessPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not 'Account Success Page' page", AccountSuccessPage.ACCOUNT_SUCCESS_PAGE_URL, currentUrl);
    }

    @Then("The user should be shown a Privacy Policy warning message")
    public void theUserShouldBeShownAPrivacyPolicyWarningMessage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown a 'Privacy Policy' warning message");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue(registerPage.warningMessageIsDisplayed());
        Assert.assertEquals(
                "the user do not agree the 'Privacy Policy' form",
                "Warning: You must agree to the Privacy Policy!",
                registerPage.warningMessageText());
    }

    @And("the user provides Personal Details {string}, {string}, {string} and {string}")
    public void theUserProvidesPersonalDetailsAnd(String firstname, String lastname, String email, String telephone) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the Personal Details");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterFirstname(firstname);
        registerPage.enterLastname(lastname);
        registerPage.enterEmail(email);
        registerPage.enterTelephone(telephone);
    }

    @Then("The user should be shown a Email Address is already registered warning message")
    public void theUserShouldBeShownAEmailAddressIsAlreadyRegisteredWarningMessage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown a 'Email Address is already registered' warning message");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue(registerPage.warningMessageIsDisplayed());
        Assert.assertEquals(
                "the Email Address is already registered",
                "Warning: E-Mail Address is already registered!",
                registerPage.warningMessageText());
    }

    @Then("The user should be shown all mandatory warnings messages")
    public void theUserShouldBeShownAllMandatoryWarningsMessages() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown all mandatory warnings messages");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertEquals("All the message ar not shown ", 5, registerPage.getDangerTextMessageListCount());
        Assert.assertTrue("All Messages are not shown", registerPage.AllMessageMandatoryAreDisplayed());

    }
}

