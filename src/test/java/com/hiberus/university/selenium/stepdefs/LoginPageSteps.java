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
}
