package com.opencart.stepdefs;

import com.opencart.pages.PagesFactory;
import com.opencart.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.UUID;

@Slf4j
public class RegisterPageSteps {

    private final RegisterPage registerPage;

    public RegisterPageSteps() {
        registerPage = PagesFactory.getInstance().getRegisterPage();
    }

    @Given("the user is on the register page")
    public void theUserIsOnTheRegisterPage() {
        log.info("The user is on the Home Page");
        registerPage.navigateTo(RegisterPage.PAGE_URL);
    }

    @And("the user enters the name {string}")
    public void theUserEntersTheName(String value) {
        registerPage.setName(value);
    }

    @And("the user enters the last name {string}")
    public void theUserEntersTheLastName(String value) {
        registerPage.setLastName(value);
    }

    @And("the user enters the email {string}")
    public void theUserEntersTheEmail(String value) {
        registerPage.setEmail(value);
    }

    @And("the user enters the email")
    public void theUserEntersGeneratedEmail() {
        //aseguramos que no coincida nunca con un mail ya creada
        String mail = "mario" + UUID.randomUUID() + "@mail.com";
        registerPage.setEmail(mail);
    }

    @And("the user enters the phone number {string}")
    public void theUserEntersThePhoneNumber(String value) {
        registerPage.setTelephone(value);
    }

    @And("the user enters the password {string}")
    public void theUserEntersThePassword(String value) {
        registerPage.setPassword(value);
    }

    @And("the user enter the confirm password {string}")
    public void theUserEnterTheConfirmPassword(String value) {
        registerPage.setConfirmPassword(value);
    }

    @And("the user accepts privacy policy")
    public void theUserAcceptsPrivacyPolicy() {
        registerPage.acceptPrivacyPolicy();
    }

    @When("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        registerPage.clickContinue();
    }

    @Then("the user account is created")
    public void theUserAccountIsCreated() {
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("Account wasnt created", "http://opencart.abstracta.us/index.php?route=account/success", currentUrl);
    }

    @Then("the user account is not created")
    public void theUserAccountIsNotCreated() {
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("Account was created", RegisterPage.PAGE_URL, currentUrl);
    }

    @Then("the alert message telling that there's already an account with that email shows up")
    public void theAlertMessageShowsUp() {
        Assert.assertTrue("Alert message is not shown", registerPage.isUsedMailAlertDisplayed());
    }

    @Then("the {string} error message shows {string}")
    public void theErrorMessageShows(String field, String error) {
        registerPage.waitForPageLoad();
        Assert.assertTrue("Error message in " + field + " is not shown", registerPage.isProperErrorMessageDisplayed(field, error));
    }
}
