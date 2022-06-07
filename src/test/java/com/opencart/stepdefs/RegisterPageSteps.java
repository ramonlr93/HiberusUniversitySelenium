package com.opencart.stepdefs;

import com.opencart.pages.PagesFactory;
import com.opencart.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class RegisterPageSteps {

    private RegisterPage registerPage;

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
        if (value.isEmpty()) value = "";
        registerPage.setName(value);
    }

    @And("the user enters the last name {string}")
    public void theUserEntersTheLastName(String value) {
        if (value.isEmpty()) value = "";
        registerPage.setLastName(value);
    }

    @And("the user enters the email {string}")
    public void theUserEntersTheEmail(String value) {
        if (value.isEmpty()) value = "";
        registerPage.setEmail(value);
    }

    @And("the user enters the phone number {string}")
    public void theUserEntersThePhneNumber(String value) {
        if (value.isEmpty()) value = "";
        registerPage.setTelephone(value);
    }

    @And("the user enters the password {string}")
    public void theUserEntersThePassword(String value) {
        if (value.isEmpty()) value = "";
        registerPage.setPassword(value);
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

    @Then("the error message shows {string}")
    public void theErrorMessageShows(String errMsg) {
        //Assert.assertEquals("Error message is not shown", errMsg,registerPage.isProperErrorMessageDisplayed(field, error));
    }

    @Then("the alert message shows up")
    public void theAlertMessageShowsUp() {
        Assert.assertTrue("Alert message is not shown", registerPage.isAlertMessageDisplayed());
    }


    @Then("the {string} error message shows {string}")
    public void theErrorMessageShows(String field, String error) {
        Assert.assertTrue("Error message for " + field + " is not shown", registerPage.isProperErrorMessageDisplayed(field, error));
    }
}
