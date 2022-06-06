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

    @Given("the user is on the register page")
    public void theUserIsOnTheRegisterPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Home Page");
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.navigateTo(RegisterPage.REGISTER_URL);
    }


    @And("the user provides the mail {string} and lastName {string} and email {string} and telephone {string} and password {string} and passwordConfirm {string}")
    public void theUserProvidesTheMailAndLastNameAndEmailAndTelephoneAndPasswordAndPasswordConfirm(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.fillRegister(firstName, lastName, email, telephone, password, passwordConfirm);
    }

    @And("the user accepts Privacy Policy terms")
    public void theUserAcceptsPrivacyPolicyTerms() {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.acceptPrivacyPolicy();
    }

    @When("the user clicks the continue register button")
    public void theUserClicksTheContinueRegisterButton() {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickContinueButton();
    }

    @Then("the user is registered successfully")
    public void theUserIsRegisteredSuccessfully() {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not success register Page", RegisterPage.REGISTER_SUCCESS_URL, currentUrl);
    }

    @Then("The user should be shown some error messages")
    public void theUserShouldBeShownSomeErrorMessages() {
        PagesFactory pf = PagesFactory.getInstance();
        RegisterPage registerPage = pf.getRegisterPage();
        boolean firstNameError = registerPage.hasErrorInField("firstName");
        boolean lastNameError = registerPage.hasErrorInField("lastName");
        boolean emailError = registerPage.hasErrorInField("email");
        boolean telephoneError = registerPage.hasErrorInField("telephone");
        boolean passwordError = registerPage.hasErrorInField("password");
        Assert.assertTrue("Some message errors are not shown", firstNameError&&lastNameError&&emailError&&telephoneError&&passwordError);
        //PROGRAMAR QUE
        // Aquçi hay mucho código igual es mejor esto validarlo en el otro lado

    }
}

