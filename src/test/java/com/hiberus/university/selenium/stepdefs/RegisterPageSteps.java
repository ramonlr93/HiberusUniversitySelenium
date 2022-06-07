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
    private RegisterSuccessPage registerSuccessPage = pf.getRegisterSuccessPage();
    private WebDriver driver = pf.getDriver();


    @Given("the user navigates to the register page")
    public void theUserNavigatesToTheRegisterPage() {
        driver.get(registerPage.PAGE_URL);
    }

    @Given("the user is in the register page")
    public void theUserIsInTheRegisterPage() {
        Assert.assertEquals("The user is not in the register page", registerPage.PAGE_URL, driver.getCurrentUrl());
    }

    @Then("the user can see the input FirstName")
    public void theUserCanSeeTheInputFirstName() {
        Assert.assertTrue("The user can't see the input FirstName", registerPage.existInputFirstName());
    }

    @And("the user can see the input LastName")
    public void theUserCanSeeTheInputLastName() {
        Assert.assertTrue("The user can't see the input LastName", registerPage.existInputLastName());
    }

    @And("the user can see the input E-Mail")
    public void theUserCanSeeTheInputEMail() {
        Assert.assertTrue("The user can't see the input E-Mail", registerPage.existInputEmail());
    }

    @And("the user can see the input Telephone")
    public void theUserCanSeeTheInputTelephone() {
        Assert.assertTrue("The user can't see the input Telephone", registerPage.existInputTelephone());
    }

    @And("the user can see the input Password")
    public void theUserCanSeeTheInputPassword() {
        Assert.assertTrue("The user can't see the input Password", registerPage.existInputPassword());
    }

    @And("the user can see the input Password Confirm")
    public void theUserCanSeeTheInputPasswordConfirm() {
        Assert.assertTrue("The user can't see the input Password Confirm", registerPage.existInputPasswordConfirm());
    }

    @And("the user can see the div Subscribe")
    public void theUserCanSeeTheDivSubscribe() {
        Assert.assertTrue("The user can't see the div Subscribe", registerPage.existDivSubscribe());
    }

    @And("the user can see the div PrivacyPolicy")
    public void theUserCanSeeTheDivPrivacyPolicy() {
        Assert.assertTrue("The user can't see the div PrivacyPolicy", registerPage.existCheckPrivacyPolicy());
    }

    @And("the user can see the button Continue")
    public void theUserCanSeeTheButtonContinue() {
        Assert.assertTrue("The user can't see the button LastName", registerPage.existButtonContinue());
    }

    @And("the user write in the input FirstName {string}")
    public void theUserWriteFirstName(String text) {
        registerPage.writeInputFirstName(text);
    }

    @And("the user write in the input LastName {string}")
    public void theUserWriteLastName(String text) {
        registerPage.writeInputLastName(text);
    }

    @And("the user write in the input E-Mail")
    public void theUserWriteEMail() {
        registerPage.writeInputEmail(registerPage.generateEmail());
    }

    @And("the user write in the input Telephone {string}")
    public void theUserWriteTelephone(String text) {
        registerPage.writeInputTelephone(text);
    }

    @And("the user write in the input Password {string}")
    public void theUserWritePassword(String text) {
        registerPage.writeInputPassword(text);
    }

    @And("the user write in the input Password Confirm {string}")
    public void theUserWritePasswordConfirm(String text) {
        registerPage.writeInputPasswordConfirm(text);
    }

    @And("the user click in the div PrivacyPolicy")
    public void theUserClickPrivacyPolicy() {
        registerPage.clickCheckPrivacyPolicy();
    }

    @When("the user click the button Continue")
    public void theUserClickContinue() {
        registerPage.clickButtonContinue();
    }

    @Then("the user is in the register success")
    public void theUserIsInTheRegisterSuccess() {
        Assert.assertEquals("The user not is in the register success page.", registerSuccessPage.PAGE_URL, driver.getCurrentUrl());
    }

    @And("the user write in the input E-Mail {string}")
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
