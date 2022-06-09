package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();

    @And("the user go to the register page")
    public void theUserGoToTheRegisterPage() {
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.goToRegister();
    }

    @And("the user provides the first name {string}")
    public void theUserProvidesTheFirstName(String fistName) {
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterFirstName(fistName);
    }

    @And("the user provides the last name {string}")
    public void theUserProvidesTheLastName(String lastName) {
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterLastName(lastName);
    }

    @And("the user provides the telephone {string}")
    public void theUserProvidesTheTelephone(String telephone) {
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterTelephone(telephone);
    }

    @And("the user provides the password confirm {string}")
    public void theUserProvidesThePasswordConfirm(String password) {
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.enterConfirmPassword(password);
    }

    @And("the user checked checkbox")
    public void theUserCheckedCheckbox() {
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.checkedCheckbox();
    }

    @When("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        RegisterPage registerPage = pf.getRegisterPage();
        registerPage.clickContinue();
    }
}