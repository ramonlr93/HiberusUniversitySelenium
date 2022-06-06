package com.opencart.stepdefs;

import com.opencart.pages.LoginPage;
import com.opencart.pages.PagesFactory;
import com.opencart.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

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
    public void theUserEntersTheName(String name) {
        registerPage.setName(name);
    }

    @And("the user enters the last name {string}")
    public void theUserEntersTheLastName(String lastname) {
        registerPage.setLastName(lastname);
    }

    @And("the user enters the email {string}")
    public void theUserEntersTheEmail(String mail) {
        registerPage.setEmail(mail);
    }

    @And("the user enters the phone number {string}")
    public void theUserEntersThePhneNumber(String number) {
        registerPage.setTelephone(number);
    }

    @And("the user enters the password {string}")
    public void theUserEntersThePassword(String passw) {
        registerPage.setPassword(passw);
    }

    @When("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
    }
}
