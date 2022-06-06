package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginPageSteps {

  @Given("the user is on the home page")
  public void theUserIsOnTheHomePage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user is on the Home Page");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.navigateTo(LoginPage.PAGE_URL);
  }

  @And("the user provides the username {string} and password {string}")
  public void theUserProvidesTheUsernameAndPassword(String username, String password) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user provides the username and password");

    LoginPage loginPage = pf.getLoginPage();
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
  }

  @When("the user clicks the login button")
  public void theUserClicksTheLoginButton() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks the 'Login' button");

    LoginPage loginPage = pf.getLoginPage();
    loginPage.clickLoginButton();
  }


  @Then("The user should be shown an invalid message")
  public void theUserShouldBeShownAnInvalidMessage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should be shown an invalid username/password message");

    LoginPage loginPage = pf.getLoginPage();
    Assert.assertTrue("The user isn't shown an error message",loginPage.hasUsernamePasswordError());
  }

// A PARTIR DE AQUÍ ES LO NUEVO **************************************************************
  @And("the user clicks My account link")
  public void theUserClicksMyAccountLink() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks My Account link");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.clickMyAccount();
  }

  @And("the user clicks Login link")
  public void theUserClicksLoginLink() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks Login link");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.clickLoginLink();
  }

  @Given("the user is on the login page")
  public void theUserIsOnTheLoginPage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user is on the Login Page");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.navigateTo(LoginPage.LOGIN_URL);
  }

  @And("the user provides the mail {string} and password {string}")
  public void theUserProvidesTheMailAndPassword(String mail, String password) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user provides the username and password");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.enterUsername(mail);
    loginPage.enterPassword(password);
  }

  @Then("the user is logged successfully")
  public void theUserIsLoggedSuccessfully() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should login successfully and is brought to the account page");
    // Si hago luegio una account pag lo pondré aquí
    //InventoryPage inventoryPage = pf.getInventoryPage();
    //inventoryPage.waitForPageLoad();

    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    System.out.println("LA URL ACTUAL ES: " + currentUrl);
    Assert.assertEquals("the URL is not inventory Page", LoginPage.LOGGED_URL, currentUrl);
  }

  @And("the user clicks on Forgotten Password")
  public void theUserClicksOnForgottenPassword() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks Login link");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.clickForgottenPasswordLink();
  }

  @Given("the user is on the forgottenPassword page")
  public void theUserIsOnTheForgottenPasswordPage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user is on the Login Page");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.navigateTo(LoginPage.FORGOTTENPASSWORD_URL);
  }

  @And("the user provides the mail {string}")
  public void theUserProvidesTheMail(String mail) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user provides the username and password");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.enterUsername(mail);
  }

  @When("the user clicks the continue button")
  public void theUserClicksTheContinueButton() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks Login link");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.clickContinueButton();
  }

  @Then("The user should be shown a confirmation message")
  public void theUserShouldBeShownAConfirmationMessage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should be shown an invalid username/password message");
    LoginPage loginPage = pf.getLoginPage();
    Assert.assertTrue("The user isn't shown a confirmation message", loginPage.confirmationForgottenPasswordMessage());
  }
}
