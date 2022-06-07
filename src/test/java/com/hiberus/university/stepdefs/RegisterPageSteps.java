package com.hiberus.university.stepdefs;

import com.hiberus.university.pages.PagesFactory;
import com.hiberus.university.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;


@Slf4j
public class RegisterPageSteps {
    public static final String ERROR_MESSAGE_ISNT_DISPLAYED = "Error message isnt displayed";
    PagesFactory pf = PagesFactory.getInstance();
    RegisterPage registerPage = pf.getRegisterPage();

    @Given("the user is on the register page")
    public void userInTheRegisterPage() {
        log.info("The user is on the home register page");
        registerPage.navigateTo(RegisterPage.PAGE_URL);
    }

    @And("the user provides the register information {string},{string},{string},{string} and {string}")
    public void fillInformationEmailRand(String firstName, String lastName, String telephone, String password, String passwordConfirm) {
        registerPage.fillInformationEmailRand(firstName, lastName, telephone, password, passwordConfirm);
    }

    @And("the user subscribe to the newsletter")
    public void subNewsletter() {
        registerPage.clickSubscribeNewsletter();
    }

    @And("the user clicks agree to the privacy policy")
    public void clickPrivacyPolicy() {
        registerPage.clickAgreePolicy();
    }

    @When("the user clicks the continue button")
    public void clickContinueButton() {
        registerPage.clickContinueButton();
    }

    @Then("the user is in the register account successfully page")
    public void theUserIsRegistered() {
        String AccountSuccessURL = "http://opencart.abstracta.us/index.php?route=account/success";
        Assert.assertEquals("Register failed",
                AccountSuccessURL, pf.getDriver().getCurrentUrl());
    }
    @And("the user provides the register information {string},{string},{string},{string},{string} and {string}")
    public void fillRegisterInformationEmail(String firstName, String lastName,String email, String telephone, String password, String passwordConfirm) {
        registerPage.fillInformation(firstName, lastName,email,telephone, password, passwordConfirm);
    }
    @Then("the user should be shown an invalid message")
    public void ErrorMessageDisplayed() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue(ERROR_MESSAGE_ISNT_DISPLAYED, registerPage.hasRegisterFirstNameError());
        Assert.assertTrue(ERROR_MESSAGE_ISNT_DISPLAYED, registerPage.hasRegisterLastNameError());
        Assert.assertTrue(ERROR_MESSAGE_ISNT_DISPLAYED, registerPage.hasRegisterEmailError());
        Assert.assertTrue(ERROR_MESSAGE_ISNT_DISPLAYED, registerPage.hasRegisterPasswordError());
    }

    @And("the user provides the email {string}")
    public void enterEmail(String email) {
        registerPage.enterEmail(email);
    }

    @Then("the user should be shown an invalid email message")
    public void alertEmailAlreadyUsedDisplayed() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue(ERROR_MESSAGE_ISNT_DISPLAYED, registerPage.hasRegisterEmailAlert());
    }
    @Then("the user should be shown a message that e-Mail address does not appear to be valid!")
    public void errorEmailInvalidDisplayed() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue(ERROR_MESSAGE_ISNT_DISPLAYED, registerPage.hasRegisterEmailError());
    }
    @And("the user provides the password {string}")
    public void enterPassword(String password) {
        registerPage.enterPassword(password);
    }

    @And("the user provides the passwordConfirmation {string}")
    public void enterPasswordConfirm(String passwordConfirm) {
        registerPage.enterPasswordConfirmation(passwordConfirm);
    }

    @Then("the user should be shown and alert \"Password confirmation does not match password!\"")
    public void alertPasswordUnmatchPasswordConf() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue(ERROR_MESSAGE_ISNT_DISPLAYED, registerPage.hasRegisterPasswordUnmatchError());
    }

    @Then("the user should be shown an warning message")
    public void warningAgreePolicyDisplayed() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue(ERROR_MESSAGE_ISNT_DISPLAYED, registerPage.hasRegisterPolicyWarning());
    }
}

