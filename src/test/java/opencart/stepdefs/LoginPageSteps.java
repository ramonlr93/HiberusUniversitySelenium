package opencart.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;
import opencart.pages.PagesFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private LoginPage loginPage = pf.getLoginPage();
    private WebDriver driver = pf.getDriver();

    @And("the user is on login page")
    public void theUserIsOnLoginPage() {
        Assert.assertEquals("The user is not on login page", loginPage.PAGE_URL, driver.getCurrentUrl());
    }

    @When("the user clicks the continue button in New Customer div")
    public void theUserClicksTheContinueButtonInNewCustomerDiv() {
        loginPage.clickNewCustomerButton();
    }

    @And("the user complete the login form with email {string} and password {string}")
    public void theUserCompleteTheLoginFormWithEmailAndPassword(String email, String password) {
        loginPage.completeLoginForm(email, password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("The user can see an alert of incorrect email or password")
    public void theUserCanSeeAnAlertOfIncorrectEmailOrPassword() {
        Assert.assertTrue("The alert is not vissible", loginPage.alertIsVissible());
    }

    @When("the user clicks the forgotten password button")
    public void theUserClicksTheForgottenPasswordButton() {
        loginPage.clickForgottenPasswordButton();
    }

    @And("the user clicks login button")
    public void theUserClicksLoginButton() {
        loginPage.clickLoginButton();
    }
}
