package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.AccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginPageSteps {

  @Given("the user is on the login page")
  public void theUserIsOnTheLoginPage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user is on the Home Page");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.navigateTo(LoginPage.PAGE_URL);
  }

  @And("the user provides the email {string} and password {string}")
  public void theUserProvidesTheEmailAndThePassword(String email, String password) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user provides the email and password");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
  }

  @When("the user clicks the login button")
  public void theUserClicksTheLoginButton() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks the 'Login' button");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.clickLogin();
  }

  @Then("the user is logged successfully")
  public void theUserIsLoggedSuccessfully() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should login successfully and is brought to 'Account Page' page");
    AccountPage accountPage = pf.getAccountPage();
    accountPage.waitForPageLoad();
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'Account Page' page", AccountPage.ACCOUNT_PAGE_URL, currentUrl);
  }

  @And("the user not provides correct email {string} and password {string}")
  public void theUserNotProvidesCorrectEmailAndThePassword(String email, String password) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user not provides the email and/or password");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
  }
  @Then("The user should be shown an invalid message")
  public void theUserShouldBeShownAnInvalidMessage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should be shown an invalid email/password message");
    LoginPage loginPage = pf.getLoginPage();
    Assert.assertTrue(loginPage.warningMessageError());
  }
}
