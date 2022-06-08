package com.pfopencart.stepdefs;


import com.pfopencart.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class LogOutPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = pf.getBasePage();
    LoginPage lp = pf.getLoginPage();
    LogoutPage lop = pf.getLogoutPage();
    HomePage hp = pf.getHomePage();
    @Given("the user is on the home page")
    public void userInLandingPage() {
        hp.navigateTo(HomePage.PAGE_URL);
    }
    @And("the user click on home login button")
    public void theUserClickOnHomeLoginButton() {
        bp.clickMyAccount();
        bp.clickLogin();
    }
    @And("the user provides the mail {string}")
    public void theUserProvidesTheMail(String mail) { lp.enterEmail(mail);
    }
    @And("the user provides the password {string}")
    public void theUserProvidesThePassword(String password) {
        lp.enterPassword(password);
    }
    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        lp.clickLogin();
    }
    @When("the user clicks the logout button")
    public void theUserClickTheLogoutButton() {
        bp.clickMyAccount();
        bp.clickLogout();
    }
    @Then("the user is in the logout page")
    public void theUserIsInTheLogoutPage() {
        PagesFactory pf = PagesFactory.getInstance();
        Assert.assertEquals("Wrong url", pf.getLogoutPage().PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}
