package es.david.practica.stepdefs;

import es.david.practica.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = PagesFactory.getInstance().getBasePage();
    RegisterPage rp = pf.getRegisterPage();



    @And("the user goes to register")
    public void theUserGoesToRegister() {
        bp.clickMyAccount();
        bp.clickRegister();
    }

    @And("the user provides the firstname {string}")
    public void theUserProvidesTheFirstname(String firstname) {
        rp.enterName(firstname);
    }

    @And("the user provides the lastname {string}")
    public void theUserProvidesTheLastname(String lastname) {
        rp.enterLastname(lastname);
    }

    @And("the user provides the phone {string}")
    public void theUserProvidesThePhone(String phone) {
        rp.enterPhone(phone);
    }

    @And("the user provides the register password again {string}")
    public void theUserProvidesThePasswordAgain(String password) {
        rp.enterConfirmPassword(password);
    }

    @And("the user provides the register password {string}")
    public void theUserProvidesTheRegisterPassword(String password) {
        rp.enterPassword(password);
    }

    @And("the user provides the register mail")
    public void theUserProvidesTheRegisterMail() {
        rp.enterEmail();
    }

    @And("the user accept the policy check")
    public void theUserAcceptThePolicyCheck() {
        rp.acceptPoticy();
    }

    @When("the user clicks the register button")
    public void theUserClicksTheRegisterButton() {
        rp.clickRegister();
    }

    @Then("the user is registered successfully")
    public void theUserIsRegisteredSuccessfully() {
        Assert.assertEquals("The url isn't correct"
                , AccountSuccessPage.PAGE_URL
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
