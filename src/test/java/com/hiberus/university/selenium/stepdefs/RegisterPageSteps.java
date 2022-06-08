package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import com.hiberus.university.selenium.pages.RegisterSuccessPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


@Slf4j
public class RegisterPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private RegisterPage registerPage = pf.getRegisterPage();
    private WebDriver driver = pf.getDriver();


    @Given("the user navigates to the register page")
    public void theUserNavigatesToTheRegisterPage() {
        driver.get(registerPage.PAGE_URL);
    }

    @Given("the user is in the register page")
    public void theUserIsInTheRegisterPage() {
        Assert.assertEquals("The user is not in the register page", registerPage.PAGE_URL, driver.getCurrentUrl());
    }

    @Then("the user can see the FirstName input")
    public void theUserCanSeeTheInputFirstName() {
        Assert.assertTrue("The user can't see the input FirstName", registerPage.existInputFirstName());
    }

    @And("the user can see the LastName input")
    public void theUserCanSeeTheInputLastName() {
        Assert.assertTrue("The user can't see the input LastName", registerPage.existInputLastName());
    }

    @And("the user can see the E-Mail input")
    public void theUserCanSeeTheInputEMail() {
        Assert.assertTrue("The user can't see the input E-Mail", registerPage.existInputEmail());
    }

    @And("the user can see the Telephone input")
    public void theUserCanSeeTheInputTelephone() {
        Assert.assertTrue("The user can't see the input Telephone", registerPage.existInputTelephone());
    }

    @And("the user can see the Password input")
    public void theUserCanSeeTheInputPassword() {
        Assert.assertTrue("The user can't see the input Password", registerPage.existInputPassword());
    }

    @And("the user can see the Password Confirm input")
    public void theUserCanSeeTheInputPasswordConfirm() {
        Assert.assertTrue("The user can't see the input Password Confirm", registerPage.existInputPasswordConfirm());
    }

    @And("the user can see the Subscribe div")
    public void theUserCanSeeTheDivSubscribe() {
        Assert.assertTrue("The user can't see the div Subscribe", registerPage.existDivSubscribe());
    }

    @And("the user can see the PrivacyPolicy div")
    public void theUserCanSeeTheDivPrivacyPolicy() {
        Assert.assertTrue("The user can't see the div PrivacyPolicy", registerPage.existCheckPrivacyPolicy());
    }

    @And("the user can see the Continue button")
    public void theUserCanSeeTheButtonContinue() {
        Assert.assertTrue("The user can't see the button LastName", registerPage.existButtonContinue());
    }

    @And("the user write in the FirstName {string} input")
    public void theUserWriteFirstName(String text) {
        registerPage.writeInputFirstName(text);
    }

    @And("the user write in the LastName {string} input")
    public void theUserWriteLastName(String text) {
        registerPage.writeInputLastName(text);
    }

    @And("the user write in the E-Mail input")
    public void theUserWriteEMail() {
        registerPage.writeInputEmail(registerPage.generateEmail());
    }

    @And("the user write in the Telephone {string} input")
    public void theUserWriteTelephone(String text) {
        registerPage.writeInputTelephone(text);
    }

    @And("the user write in the Password {string} input")
    public void theUserWritePassword(String text) {
        registerPage.writeInputPassword(text);
    }

    @And("the user write in the Password Confirm {string} input")
    public void theUserWritePasswordConfirm(String text) {
        registerPage.writeInputPasswordConfirm(text);
    }

    @And("the user click in the PrivacyPolicy div")
    public void theUserClickPrivacyPolicy() {
        registerPage.clickCheckPrivacyPolicy();
    }

    @When("the user click the Continue button")
    public void theUserClickContinue() {
        registerPage.clickButtonContinue();
    }


    @And("the user write in the E-Mail {string} input")
    public void theUserWriteEMail(String text) {
        registerPage.writeInputEmail(text);
    }

    @Then("the user can see {int} the error messages")
    public void theUserCanSeeTheErrorMessages(int num) {
        Assert.assertEquals("The user can't see " + num + " error messages", num, registerPage.sizeOflistTextDanger());
    }

    @Then("the user can see the warning messages of {string} appear")
    public void theWarningMessageAppear(String text) {
        Assert.assertTrue("The warning messages of" + " not appear", registerPage.getWarningText().contains(text));
    }

    @When("the user click the login page link")
    public void theUserClickTheLoginPageLink() {
        registerPage.clickLoginPageLink();
    }

}
