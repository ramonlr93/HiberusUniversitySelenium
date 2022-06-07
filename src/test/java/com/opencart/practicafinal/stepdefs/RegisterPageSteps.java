package com.opencart.practicafinal.stepdefs;

import com.opencart.practicafinal.pages.AccountPage;
import com.opencart.practicafinal.pages.BasePage;
import com.opencart.practicafinal.pages.PagesFactory;
import com.opencart.practicafinal.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = PagesFactory.getInstance().getBasePage();
    RegisterPage rp = pf.getRegisterPage();



    @And("the user goes to register")
    public void goToRegister() {
        bp.clickMyAccount();
        bp.clickRegister();
    }

    @And("the user provides the firstname {string}")
    public void enterFirstName(String firstname) {
        rp.enterName(firstname);
    }

    @And("the user provides the lastname {string}")
    public void enterLastname(String lastname) {
        rp.enterLastname(lastname);
    }

    @And("the user provides the phone {string}")
    public void enterPhone(String phone) {
        rp.enterPhone(phone);
    }

    @And("the user provides the register password again {string}")
    public void enterPasswordAgain(String password) {
        rp.enterConfirmPassword(password);
    }

    @And("the user provides the register password {string}")
    public void enterPassword(String password) {
        rp.enterPassword(password);
    }

    @And("the user provides the register mail")
    public void enterEmail() {
        rp.enterEmail();
    }

    @And("the user accept the policy check")
    public void acceptPolicy() {
        rp.acceptPoticy();
    }

    @When("the user clicks the register button")
    public void clickRegister() {
        rp.clickRegister();
    }

    @Then("the user is registered successfully")
    public void checkRegister() {
        Assert.assertEquals("The url isn't correct"
                , AccountPage.PAGE_URL
                , pf.getDriver().getCurrentUrl());
    }

    @Then("the user can see the error {string}")
    public void checkError(String message) {
        Assert.assertEquals("The message isn't correct"
                , rp.getMessageError()
                , message);
    }

    @Then("the user can see the policy error {string}")
    public void checkPolicyError(String message) {
        Assert.assertEquals("The policy message isn't correct"
                , rp.getPolicyMessageError()
                , message);
    }

}
