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
import org.openqa.selenium.WebElement;

@Slf4j
public class LoginPageSteps {

  @Given("the user is on the home page")
  public void theUserIsOnTheHomePage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user is on the home page");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.navigateTo(LoginPage.PAGE_URL);
    Assert.assertTrue("We are not on home page", loginPage.homePage());
  }

  @And("the user provides the username {string}")
  public void theUserProvidesTheUsername(String username) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user provides the username");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.enterUsername(username);
  }

  @And("the user provides the password {string}")
  public void theUserProvidesThePassword(String password) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user provides the password");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.enterPassword(password);
  }

  @When("the user clicks the login button")
  public void theUserClicksTheLoginButton() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks the login button");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.clickLogin();
  }

  @Then("the user is logged successfully")
  public void theUserIsLoggedSuccessfully() {
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    inventoryPage.waitForPageLoad();
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not inventory Page", InventoryPage.PAGE_URL, currentUrl);
  }

  @Then("the user should be shown and invalid message")
  public void theUserShouldBeShownAndInvalidMessage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user should be shown an invalid message");
    LoginPage loginPage = pf.getLoginPage();
    Assert.assertTrue("error message not found", loginPage.hasUsernamePasswordError());
  }
}
