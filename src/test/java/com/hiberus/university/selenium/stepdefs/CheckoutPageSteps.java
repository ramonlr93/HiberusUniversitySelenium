package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutPageSteps {

  @And("the user access to MyAccountNavBarButton and access LoginMenu")
  public void theUserAccessToMyAccountNavBarButtonAndAccessToLoginMenu() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user access to MyAccountMenu and access to LoginMenu");
    HomePage homePage = pf.getHomePage();
    homePage.waitForPageLoad();
    homePage.clickMyAccountFromMenu();
    homePage.clickLoginFromMenu();
  }

  @And("the user is logged in with {string}, {string}")
  public void theUserIsLoggedInWith(String email, String password) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user is logged in");
    LoginPage loginPage = pf.getLoginPage();
    loginPage.navigateTo(LoginPage.LOGIN_PAGE_URL);
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
    loginPage.clickLogin();
    AccountPage accountPage = pf.getAccountPage();
    accountPage.waitForPageLoad();
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'Account Page' page", AccountPage.ACCOUNT_PAGE_URL, currentUrl);
  }

  @And("the user clicks the HomeItemHouse")
  public void theUserAccessToHomeItemHouse() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks the HomeItemHouse");
    AccountPage accountPage = pf.getAccountPage();
    accountPage.waitForPageLoad();
    accountPage.clickHomeButton();
  }

  @And("the user adds a product to the shopping cart")
  public void theUserAddsAProductToTheShoppingCart() {
    log.info("The user adds a product to the shopping cart by clicking AddToCart");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.waitForPageLoad();
    homePage.clickIphoneProductButton();
    Assert.assertTrue(homePage.successAddToCartMessageIsDisplayed());
  }

  @And("the user clicks the CheckoutNavBarButton and navigates to the CheckoutPage")
  public void theUserClicksTheCheckoutNavBarButtonAndNavigatesToTheCheckoutPage() {
    log.info("The user clicks checkout button and navigates to CheckoutPage");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.waitForPageLoad();
    homePage.clickCheckoutFromMenu();
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'CheckoutPage' page", CheckoutPage.CHECKOUT_PAGE_URL, currentUrl);
  }

  //Billing Details
  @And("the user complete the Billing Details with {string}, {string}, {string}, {string}, {string}, {string}")
  public void theUserCompleteTheBillingDetailsWith(String firstname, String lastname, String address, String city, String country, String region_state) {
    log.info("The user provides the Billing Details");
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage checkoutPage = pf.getCheckOutPage();
    checkoutPage.waitForPageLoad();
    checkoutPage.billingAddressCheck();
    checkoutPage.fillBillingDetailsForm(firstname, lastname, address, city, country, region_state);
    checkoutPage.clickBillingDetailsContinueButton();
  }

  //Delivery Details
  @And("the user complete the Delivery Details step")
  public void theUserCompleteTheDeliveryDetailsStep() {
    log.info("The the user complete the Delivery Details");
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage checkoutPage = pf.getCheckOutPage();
    checkoutPage.clickDeliveryDetailsContinueButton();
  }
  
  //Delivery Method
  @And("the user complete the Delivery Methods step")
  public void theUserCompleteTheDeliveryMethodsStep() {
    log.info("The user complete the Delivery Methods");
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage checkoutPage = pf.getCheckOutPage();
    checkoutPage.clickDeliveryMethodContinueButton();
  }

  //Payment Method
  @And("the user complete the Payment Method step")
  public void theUserCompleteThePaymentMethodStep() {
    log.info("The user complete the Payment Method");
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage checkoutPage = pf.getCheckOutPage();
    checkoutPage.waitForPageLoad();
    checkoutPage.clickAgreeTermsCondButton();
    checkoutPage.clickPaymentMethodContinueButton();
  }

  //Confirm Order
  @When("the user Confirm the Order and checkout successfully")
  public void theUserConfirmTheOrderAndCheckoutSuccessfully() {
    log.info("The user Confirm the Order and checkout successfully");
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage checkoutPage = pf.getCheckOutPage();
    checkoutPage.waitForPageLoad();
    checkoutPage.clickConfirmOrderButton();
    CheckoutSuccessPage checkoutSuccessPage = pf.getCheckoutSuccessPage();
    checkoutSuccessPage.waitForPageLoad();
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'CheckoutSuccessPage' page", CheckoutSuccessPage.CHECKOUT_SUCCESS_PAGE_URL, currentUrl);
  }

  @Then("the user Logout successfully")
  public void theUserLogoutSuccessfully() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user Logout successfully");
    CheckoutSuccessPage checkoutSuccessPage = pf.getCheckoutSuccessPage();
    checkoutSuccessPage.waitForPageLoad();
    checkoutSuccessPage.clickMyAccountFromMenu();
    checkoutSuccessPage.clickLogoutFromMenu();
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'LogoutPage' page", LogoutPage.LOGOUT_PAGE_URL, currentUrl);
  }
}















