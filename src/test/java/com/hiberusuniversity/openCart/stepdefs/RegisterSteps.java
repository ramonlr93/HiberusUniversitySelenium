package com.hiberusuniversity.openCart.stepdefs;

import com.hiberusuniversity.openCart.pages.LoginPage;
import com.hiberusuniversity.openCart.pages.PagesFactory;
import com.hiberusuniversity.openCart.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class RegisterSteps {

    PagesFactory pf = PagesFactory.getInstance();
    RegisterPage registerPage = pf.getRegisterPage();

    @Given("the user is on the register page")
    public void theUserIsOnTheLogInPage() {
        log.info("The user is on the register page");
        registerPage.navigateTo(registerPage.PAGE_URL);
    }

    @And("the user introduces his name {string}, last name {string}, email {string}, telephone {string} and password {string}")
    public void theUserIntroducesHisNameLastNameEmailTelephoneAndPassword(String name, String lastname, String email, String telephone, String password) {
        registerPage.enterRegisterValues(name,lastname,email,telephone,password);
    }

    @And("the user check the privacy policy checkbox")
    public void theUserCheckThePrivacyPolicyCheckbox() {
        registerPage.checkCheckbox();
    }

    @When("the user click the button continue")
    public void theUserClickTheButtonContinue() {
        registerPage.clickRegisterButton();

    }

    @Then("the user will get redirected to page {string} that will indicate to the user that he has register correctly")
    public void theUserWillGetRedirectedToPageThatWillIndicateToTheUserThatHeHasRegisterCorrectly(String url) {
        Assert.assertEquals("The user is not on the successful register page",url,pf.getDriver().getCurrentUrl());
    }

    @Then("the page shows a error message")
    public void thePageShowsAErrorMessage() {
        Assert.assertTrue("The error message is not shown",registerPage.getErrorMessage().isDisplayed());
    }

    @And("the user introduces his name {string}, last name {string}, telephone {string} and password {string}")
    public void theUserIntroducesHisNameLastNameTelephoneAndPassword(String name, String lastname, String telephone, String password) {
        registerPage.enterRegisterValues(name,lastname,"",telephone,password);
    }

    @Then("the page shows a error message showing the field is empty and the user still is in the registration page {string}")
    public void thePageShowsAErrorMessageShowingTheFieldIsEmpty(String url) {
        Assert.assertTrue("The error is not showing",registerPage.getErrorInputEmail().isDisplayed());
        Assert.assertEquals("The user is not in the registration page",url,pf.getDriver().getCurrentUrl());
    }

    @Then("the page shows a error message showing privacy policy is not checked and the user still is in the registration page {string}")
    public void thePageShowsAErrorMessageShowingPrivacyPolicyIsNotCheckedAndTheUserStillIsInTheRegistrationPage(String url) {
        Assert.assertTrue("The error is not showing",registerPage.getErrorMessage().isDisplayed());
        Assert.assertEquals("The user is not in the registration page",url,pf.getDriver().getCurrentUrl());

    }

    @And("the user introduces his name {string}, last name {string}, a random email {string}, telephone {string} and password {string}")
    public void theUserIntroducesHisNameLastNameARandomEmailTelephoneAndPassword(String name, String lastname, String email, String telephone, String password) {
        registerPage.enterRegisterValuesRandomEmail(name,lastname,email,telephone,password);
    }

}
