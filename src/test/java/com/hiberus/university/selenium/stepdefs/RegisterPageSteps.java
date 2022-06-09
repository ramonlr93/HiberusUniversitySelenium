package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.BasePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class RegisterPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    BasePage basePage = pf.getBasePage();
    RegisterPage registerPage = pf.getRegisterPage();

    @And("the user click Register")
    public void clickRegisterButton() {
        basePage.clickRegister();
    }

    @And("the user provides the firstName {string}, the lastName {string}, the email {string} and the telephone {string}")
    public void enterPersonalDetails(String firstName, String lastName, String email, String telephone) {
        log.info("The user provides the Personal Details");
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterTelephone(telephone);
    }

    @And("the user provides the password {string} and confirm the password {string}")
    public void enterPasswords(String password, String confirmPassword) {
        log.info("The user provides the Passwords");
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        Assert.assertEquals("The password and the confirm password are not the same", password, confirmPassword);
    }

    @And("the user checks the Private Policy check")
    public void checkPrivatePolicy() {
        log.info("The user checks the Private Policy check");
        registerPage.checkPrivatePolicy();
    }

    @When("the user clicks the continue button")
    public void clickContinueButton() {
        log.info("The user clicks the continue button");
        registerPage.clickContinueButton();
    }

    @Then("the user is register successfully and is into the account-success page")
    public void validateRegisterSuccessfully() {
        log.info("The user is register successfully");
        String url = "http://opencart.abstracta.us/index.php?route=account/success";
        String currentUrl = pf.getDriver().getCurrentUrl();
        Assert.assertEquals("The registration of the user fail", url, currentUrl);
    }

    @Then("a warning message appear on the top of the page")
    public void warningMessageDisplay() {
        log.info("The user should be shown an warning message of the Privacy Policy");
        Assert.assertTrue(registerPage.hasPrivatePolicyError());
    }

    @Then("a message appear on the field that is invalid")
    public void invalidFieldMessage() {
        log.info(registerPage.errorMessageDisplay());
        Assert.assertTrue(registerPage.errorMessageDisplay()!=null);
    }
}
