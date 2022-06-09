package org.hiberus.com.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.hiberus.com.pages.*;
import org.junit.Assert;

@Slf4j
public class RegisterPageSteps {

    @And("the user introduces his register information: {string}, {string}, {string}," +
            " {string}, {string}, {string}")
    public void theUserIntroducesRegisterInformation(String firstName, String lastName,
                                                     String email, String telephone,
                                                     String password, String confirmPassword) {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.introducesRegisterInformation(firstName,lastName, email,
                telephone, password, confirmPassword);
    }

    @And("the user clicks Privacy Policy")
    public void theUserClicksPrivacyPolicy() {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickPolicyCheckbox();
    }

    @And("the user clicks continueButton")
    public void theUserClicksContinueButton() {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickContinueButton();
    }

    @Then("the user see Success Account Page")
    public void theUserSeeSuccesAcountPage() {
        log.info("the user see Success Account Page");
        PagesFactory pf = PagesFactory.getInstance();
        SuccessAcountPage successAcountPage = pf.getSuccessAcountPage();
        successAcountPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Succes Acount Page", SuccessAcountPage.PAGE_URL, currentUrl);
    }

    @Then("the user introduces an email registered in the data base and it showed a warning message")
    public void theUserIntroducesEmailInUse() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user should be shown an invalid message");
        RegisterPage registerPage = pf.getRegisterPage();
        boolean isTrue = registerPage.emailRegisteredInDataBaseMessage();
        Assert.assertTrue("error message not found", isTrue);
    }




}
