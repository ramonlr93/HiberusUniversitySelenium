package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class RegisterSteps {
    @Given("the user is on the register page")
    public void theUserIsOnTheRegisterPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Register Page");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.navigateTo(RegisterPage.PAGE_URL);
    }
    @When("input First Name {string}")
    public void inputFirstName(String firstName) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Introducing First Name");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.fillFirstName(firstName);
    }
    @And("input Last Name {string}")
    public void inputLastName(String lastName) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Introducing Last Name");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.fillLastName(lastName);
    }
    @And("input email {string}")
    public void inputEmail(String email) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Introducing email");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.fillEmail(email);
    }
    @And("input telephone number {string}")
    public void inputTelephoneNumber(String phoneNumber) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Introducing telephone number");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.fillTelephone(phoneNumber);
    }
    @And("input password {string}")
    public void inputPassword(String password) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Introducing password");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.fillPassword(password);
    }
    @And("input confirm {string}")
    public void inputConfirm(String confirm) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Confirming password");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.fillConfirm(confirm);
    }
    @And("checks checkbox")
    public void checksCheckbox() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Clicking on checkbox");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.clickOnAgreement();
    }
    @And("clics on Continue button")
    public void clicsOnContinueButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Submitting data");
        RegisterPage registerPage= pf.getRegisterPage();
        registerPage.clickOnCOntinue();
    }
    @Then("{string} webpage is displayed")
    public void webpageIsDisplayed(String success) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Displaying success page");
        RegisterPage registerPage= pf.getRegisterPage();
        Assert.assertEquals("User doesn't registered succesfully", success, registerPage.success());
    }
}
