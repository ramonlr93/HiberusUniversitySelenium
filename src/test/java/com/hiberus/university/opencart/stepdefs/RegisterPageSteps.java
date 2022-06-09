package com.hiberus.university.opencart.stepdefs;

import com.hiberus.university.opencart.pages.AccountPage;
import com.hiberus.university.opencart.pages.LoginPage;
import com.hiberus.university.opencart.pages.PagesFactory;
import com.hiberus.university.opencart.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class RegisterPageSteps {

    @Given("the user is on the register page")
    public void theUserIsOnTheRegisterPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the register page");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.navigateTo(RegisterPage.PAGE_URL);
    }

    @And("the user enter the first name {string}")
    public void theUserEnterTheFirstName(String first_name) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the first name");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterFirstName(first_name);
    }

    @And("the user enter the last name {string}")
    public void theUserEnterTheLastName(String last_name) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the last name");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterLastName(last_name);
    }

    @And("the user enter the email {string}")
    public void theUserEnterTheEmail(String email) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the email");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterEmail(email);
    }

    @And("the user enter the telephone {string}")
    public void theUserEnterTheTelephone(String telephone) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the telephone");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterTelephone(telephone);
    }

    @And("the user enter the password {string}")
    public void theUserEnterThePassword(String password) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the password");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterPassword(password);
    }

    @And("the user enter the password confirmation {string}")
    public void theUserEnterThePasswordConfirmation(String password_confirm) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the password confirmation");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterPasswordConfirm(password_confirm);
    }

    @And("the user checks the newsletter subscription box")
    public void theUserChecksTheNewsletterBox() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user checks the newsletter subscription box");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.checkNewsletterBox();
    }

    @And("the user checks the privacy policy button")
    public void theUserChecksThePrivacyPolicyButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user checks the privacy policy button");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.checkPrivacyPolicy();
    }

    @And("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the continue button");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickContinue();
    }

    @Then("the user is registered successfully")
    public void theUserIsRegisteredSuccessfully() {
        PagesFactory pf = PagesFactory.getInstance();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not account success page", "http://opencart.abstracta.us/index.php?route=account/success", currentUrl);
    }

    @Then("the user should be shown an invalid message due to password confirmation error")
    public void theUserShouldBeShownAnInvalidMessagePasswordConfirmation() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to password confirmation error");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue("error message not found", registerPage.passwordConfirmError());
    }

    @Then("the user should be shown an invalid message due to email already registered error")
    public void theUserShouldBeShownAnInvalidMessageEmailAlreadyRegistered() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to email already registered error");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue("error message not found", registerPage.emailAlreadyRegisteredError());
    }

    @Then("the user should be shown an invalid message due to first name error")
    public void theUserShouldBeShownAnInvalidMessageFirstName() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to first name error");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue("error message not found", registerPage.firstNameError());
    }

    @Then("the user should be shown an invalid message due to last name error")
    public void theUserShouldBeShownAnInvalidMessageLastName() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to last name error");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue("error message not found", registerPage.lastNameError());
    }

    @Then("the user should be shown an invalid message due to email error")
    public void theUserShouldBeShownAnInvalidMessageEmail() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to mail error");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue("error message not found", registerPage.emailError());
    }

    @Then("the user should be shown an invalid message due to telephone error")
    public void theUserShouldBeShownAnInvalidMessageTelephone() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to telephone error");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue("error message not found", registerPage.telephoneError());
    }

    @Then("the user should be shown an invalid message due to password error")
    public void theUserShouldBeShownAnInvalidMessagePassword() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to password error");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue("error message not found", registerPage.passwordError());
    }

    @Then("the user should be shown an invalid message due to accept privacy policy error")
    public void theUserShouldBeShownAnInvalidMessagePrivacyPolicy() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message due to accept privacy policy error");
        RegisterPage registerPage = pf.getRegisterPage();
        Assert.assertTrue("error message not found", registerPage.privacyPolicyError());
    }
}