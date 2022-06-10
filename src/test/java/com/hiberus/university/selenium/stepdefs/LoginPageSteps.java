package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

@Slf4j
public class LoginPageSteps {
  private PagesFactory pf = PagesFactory.getInstance();
  private LoginPage loginPage = pf.getLoginPage();
  private WebDriver driver = pf.getDriver();

  @Then("the user is in the login page")
  public void theUserIsInTheLoginPage() {
    Assert.assertEquals("The user is not in the login page", loginPage.PAGE_URL, driver.getCurrentUrl());
  }

  @Given("the user navigates to the login page")
  public void theUserNavigatesToTheLoginPage() {
    driver.get(loginPage.PAGE_URL);
  }

    @Then("the user can see the E-Mail login input")
    public void existInputEmail() {
      loginPage.existInputEmail();
    }

  @And("the user can see the Password login input")
  public void existInputPassword() {
    loginPage.existInputPassword();
  }

  @And("the user can see the ForgottenPassword link")
  public void existLinkForgottenPassword() {
    loginPage.existLinkForgottenPassword();
  }

  @And("the user can see the Login button")
  public void existButtonLogin() {
    loginPage.existButtonLogin();
  }

  @And("the user can see the ContinueRegister button")
  public void existButtonContinueRegister() {
    loginPage.existButtonContinueRegister();
  }


  @And("the user write in the E-Mail {string} login input")
  public void theUserWriteEMailLoginInput(String text) {
    loginPage.writeInputEmail(text);
  }

  @And("the user write in the Password {string} login input")
  public void theUserWritePasswordLoginInput(String text) {
    loginPage.writeInputPassword(text);
  }

  @When("the user click in the link Login button")
  public void clickButtonLogin() {
    loginPage.clickButtonLogin();
  }

  @When("the user click in the Forgotten Password link")
  public void theUserClickForgottenPasswordLink() {
    loginPage.clickLinkForgottenPassword();
  }

  @Then("the user can see the warning messages appear")
  public void theUserCanSeeTheWarningMessages() {
    loginPage.existDivWarning();
  }
}
