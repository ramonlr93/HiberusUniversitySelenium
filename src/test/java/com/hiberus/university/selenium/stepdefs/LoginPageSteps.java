package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

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
  public void theUserProvidesTheUsernameAndPassword(String arg0, String arg1) {
  }

  @When("the user clicks the login button")
  public void theUserClicksTheLoginButton() {
  }

  @Then("the user is logged successfully and is into the inventory page")
  public void theUserIsLoggedSuccessfullyAndIsIntoTheInventoryPage() {
  }

  @Then("The user should be shown an invalid message")
  public void theUserShouldBeShownAnInvalidMessage() {
  }
}
