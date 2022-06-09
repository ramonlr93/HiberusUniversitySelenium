package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.AccountPage;
import com.hiberus.university.selenium.pages.LogoutPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LogoutPageSteps {

  @And("the user is on the Account page")
  public void theUserIsOnTheAccountPage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The is on the Account page");
    AccountPage accountPage = pf.getAccountPage();
    accountPage.navigateTo(AccountPage.ACCOUNT_PAGE_URL);
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'Account Page' page", AccountPage.ACCOUNT_PAGE_URL, currentUrl);
  }

  @When("the user access to LogoutMenu")
  public void theUserAccessToLogoutMenu() throws InterruptedException {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user access to LogoutMenu");
    AccountPage accountPage = pf.getAccountPage();
    accountPage.waitForPageLoad();
    accountPage.clickLogoutFromMenu();
  }

  @Then("the user Logout successfully")
  public void theUserLogoutSuccessfully() throws InterruptedException {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user Logout successfully");
    LogoutPage logoutPage = pf.getLogoutPage();
    logoutPage.waitForPageLoad();
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'LogoutPage' page", LogoutPage.LOGOUT_PAGE_URL, currentUrl);
  }
}















