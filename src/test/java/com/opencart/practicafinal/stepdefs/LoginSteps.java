package com.opencart.practicafinal.stepdefs;



import com.opencart.practicafinal.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {


    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = pf.getBasePage();
    LoginPage lp = pf.getLoginPage();
    HomePage hp = pf.getHomePage();

    @Given("the user is in the landing page")
    public void userInLandingPage() {
        hp.navigateTo(HomePage.PAGE_URL);
    }

    @And("the user click on login button")
    public void theUserClickOnLoginButton() {
        bp.clickMyAccount();
        bp.clickLogin();
    }

    @And("the user fills the mail {string}")
    public void theUserFillsTheMail(String mail) {
        lp.enterEmail(mail);
    }

    @And("the user fills the password {string}")
    public void theUserFillsThePassword(String password) {
        lp.enterPassword(password);
    }

    @When("the user clicks on login button")
    public void theUserClicksTheLoginButton() {
        lp.clickLogin();
    }

    @Then("the user is logged")
    public void theUserIsLoggedSuccessfully() {
        Assert.assertEquals("It is not the correct URL"
                , AccountPage.PAGE_URL
                , pf.getDriver().getCurrentUrl());
    }

    @Then("the error message is shown")
    public void theUserCanSeeTheErrorMessage() {
        Assert.assertTrue("Error message is not visible", lp.isAlertVisible());
    }
}
