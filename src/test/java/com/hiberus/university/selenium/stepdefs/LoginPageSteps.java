package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
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

  @And("the user provides the email {string} and password {string}")
  public void theUserProvidesTheEmailAndPassword(String email, String password) {
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

  @Then("the user is logged successfully and is into the inventory page")
  public void theUserIsLoggedSuccessfullyAndIsIntoTheInventoryPage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should login successfully and is brought to the inventory page");

    InventoryPage inventoryPage = pf.getInventoryPage();
    inventoryPage.waitForPageLoad();

    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not inventory Page", InventoryPage.PAGE_URL, currentUrl);
  }

  @Then("The user should be shown an invalid message")
  public void theUserShouldBeShownAnInvalidMessage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should be shown an invalid email/password message");

    LoginPage loginPage = pf.getLoginPage();
    Assert.assertTrue(loginPage.hasUsernamePasswordError());
  }
}
