package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.BasePage;
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
  PagesFactory pf = PagesFactory.getInstance();
  BasePage basePage = pf.getBasePage();
  LoginPage loginPage = pf.getLoginPage();

  @Given("the user is on the home page")
  public void theUserIsOnTheHomePage() {
    log.info("The user is on the Home Page");
    basePage.navigateTo(BasePage.PAGE_URL);
  }

  @And("the user clicks MyAccount")
  public void theUserClicksMyAccount() {
    basePage.clickMyAccount();
  }

  @And("the user click Login")
  public void theUserClickLogin() {
    basePage.clickLogin();
  }

  @And("the user provides the email {string} and password {string}")
  public void theUserProvidesTheUsernameAndPassword(String username, String password) {
    log.info("The user provides the username and password");
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
  }

  @When("the user clicks the login button")
  public void theUserClicksTheLoginButton() {
    log.info("The user clicks the 'Login' button");

    loginPage.clickLogin();
  }

  @Then("the user is logged successfully and is into the My Account page")
  public void theUserIsLoggedSuccessfullyAndIsIntoTheInventoryPage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should login successfully and is brought to the inventory page");


    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not inventory Page", "https://opencart.abstracta.us/index.php?route=account/account", currentUrl);
  }

  @Then("The user should be shown an invalid message")
  public void theUserShouldBeShownAnInvalidMessage() {
    log.info("The user should be shown an invalid username/password message");

    Assert.assertTrue(loginPage.hasUsernamePasswordError());
  }

    @When("the user clicks the logout button")
    public void clickLogoutButton() {
      basePage.clickMyAccount();
      basePage.clickLogout();
    }

    @Then("the user is logout successfully and a message appear")
    public void logoutSuccessfully() {
      Assert.assertTrue(basePage.textLogout());
    }
}
