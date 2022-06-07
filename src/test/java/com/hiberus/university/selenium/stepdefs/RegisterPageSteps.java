package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class RegisterPageSteps {

    @Given("the user is in the register page")
    public void theUserIsInTheRegisterPage(){
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is in the register page");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.navigateTo(RegisterPage.PAGE_URL);
    }

    @And("the user provides the first name {string}")
    public void theUserProvidesThe(String firstname) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the first name");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterFirstName(firstname);
    }

    @And("the user provides the last name {string}")
    public void theUserProvidesTheLastName(String lastname) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the last name");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterLastName(lastname);
    }

    @And("the user provides the email {string}")
    public void theUserProvidesTheEmail(String email) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the email");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterEmail(email);
    }

    @And("the user provides the telephone {string}")
    public void theUserProvidesTheTelephone(String telephone) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the telephone");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterTelephone(telephone);
    }

    @And("the user provides the password for registration {string}")
    public void theUserProvidesThePasswordForRegistration(String password) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the password");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterPassword(password);
    }

    @And("the user provides the confirmation {string}")
    public void theUserProvidesTheConfirmation(String passwordConfirm) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user confirms the password");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterPasswordConfirm(passwordConfirm);
    }

    @And("the user clicks the privacy policy button")
    public void theUserClicksThePrivacyPolicyButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the privacy policy button");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickPrivacyPolicy();
    }

    @When("the user clicks the register button")
    public void theUserClicksTheRegisterButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the register button");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickRegister();
    }

    @Then("the user registers succesfully")
    public void theUserRegistersSuccesfully() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user registered succesfully");

        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        String mustBeUrl = "http://opencart.abstracta.us/index.php?route=account/success";
        Assert.assertEquals("the URL is not correct", mustBeUrl, currentUrl);
    }

    @Then("an error message is shown")
    public void anErrorMessageIsShown() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("An error message is shown");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.errorMessageInputs();
    }

    @Then("an error message saying you must accept the Privacy Policy is shown")
    public void aMessageErrorSayingYouMustAcceptThePrivacyPolicyIsShown() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("It shows an error message. You must accept the privacy policy");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.privacyPolicyError();
    }
}
