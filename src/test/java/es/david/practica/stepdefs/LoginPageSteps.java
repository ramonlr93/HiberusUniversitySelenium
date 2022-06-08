package es.david.practica.stepdefs;

import es.david.practica.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = pf.getBasePage();
    LoginPage lp = pf.getLoginPage();
    HomePage hp = pf.getHomePage();

    @Given("the user is in the main page")
    public void userInHomePage() {
        hp.navigateTo(HomePage.PAGE_URL);
    }

    @And("the user goes to login")
    public void goToLogin() {
        bp.clickMyAccount();
        bp.clickLogin();
    }

    @And("the user provides the mail {string}")
    public void enterEmail(String mail) {
        lp.enterEmail(mail);
    }

    @And("the user provides the password {string}")
    public void enterPassword(String password) {
        lp.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void clickLogin() {
        lp.clickLogin();
    }

    @Then("the user is logged successfully")
    public void checkLogin() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals("Isn't the correct URL"
                , AccountPage.PAGE_URL
                , pf.getDriver().getCurrentUrl());
    }

    @Then("the user can see the error message")
    public void checkMessageError() {
        Assert.assertTrue("Error message isn't visible", lp.isAlertVisible());
    }
}
