package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RegisterPageSteps {

    private RegisterPage registerPage;

    public RegisterPageSteps() {
        registerPage = PagesFactory.getInstance().getRegisterPage();
    }

    @Given("the user introduces {string} as first name")
    public void theUserIntroducesAsFirstName(String firstName) {
        registerPage.enterFirstName(firstName);
    }

    @And("the user introduces {string} as last name")
    public void theUserIntroducesAsLastName(String lastName) {
        registerPage.enterLastName(lastName);
    }

    @And("the user introduces {long} as telephone")
    public void theUserIntroducesAsTelephone(long telephone) {
        registerPage.enterTelephone(telephone);
    }

    @And("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        registerPage.clickContinue();
    }

    @And("the user introduces {string} as confirm password")
    public void theUserIntroducesAsConfirmPassword(String password) {
        registerPage.enterConfirmPassword(password);
    }

    @And("the user agree the privacy policy")
    public void theUserAgreeThePrivacyPolicy() {
        registerPage.clickPrivatePolicy();
    }

    @Then("the user sees an error message behind input that says {string}")
    public void theUserSeesAnErrorMessageBehindInputThatSays(String errorMessage) {
        Assert.assertEquals(
                "El mensaje de error en el first name es incorrecto",
                errorMessage,
                registerPage.getFieldMessageError()
        );
    }
}
