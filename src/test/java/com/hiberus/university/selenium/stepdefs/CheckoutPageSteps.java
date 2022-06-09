package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutPageSteps {

  @And("the user login with {string}, {string}")
  public void theUserIsLoggedInWith(String email, String password) throws InterruptedException {
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
  public void theUserAccessToHomeItemHouse() throws InterruptedException {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user clicks the HomeItemHouse");
    AccountPage accountPage = pf.getAccountPage();
    accountPage.waitForPageLoad();
    accountPage.clickHomeButton();
  }

  @And("the user adds a product to the shopping cart")
  public void theUserAddsAProductToTheShoppingCart() throws InterruptedException {
    log.info("The user adds a product to the shopping cart by clicking AddToCart");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.waitForPageLoad();
    homePage.clickIphoneProductButton();
    Assert.assertTrue(homePage.successAddToCartMessageIsDisplayed());
  }

  @And("the user clicks the CheckoutNavBarButton")
  public void theUserClicksTheCheckoutNavBarButton() throws InterruptedException {
    log.info("The user clicks checkout button");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.waitForPageLoad();
    homePage.clickCheckoutFromMenu();
  }

  @And("navigates to the CheckoutPage")
  public void navigatesToTheCheckoutPage() {
    log.info("The user navigates to CheckoutPage");
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'CheckoutPage' page", CheckoutPage.CHECKOUT_PAGE_URL, currentUrl);
  }

  //Billing Details
  @And("the user complete the Billing Details with {string}, {string}, {string}, {string}, {string}, {string}")
  public void theUserCompleteTheBillingDetailsWith(String firstname, String lastname, String address, String city, String country, String region_state) throws InterruptedException {
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
  public void theUserCompleteThePaymentMethodStep() throws InterruptedException {
    log.info("The user complete the Payment Method");
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage checkoutPage = pf.getCheckOutPage();
    checkoutPage.waitForPageLoad();
    checkoutPage.clickAgreeTermsCondButton();
    checkoutPage.clickPaymentMethodContinueButton();
  }

  //Confirm Order
  @When("the user Confirm the order")
  public void theUserConfirmTheOrder() throws InterruptedException {
    log.info("The user Confirm the Order");
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage checkoutPage = pf.getCheckOutPage();
    checkoutPage.waitForPageLoad();
    checkoutPage.clickConfirmOrderButton();
  }

  @Then("the user Checkout successfully")
  public void theUserCheckoutSuccessfully() throws InterruptedException {
    log.info("The user Checkout successfully");
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutSuccessPage checkoutSuccessPage = pf.getCheckoutSuccessPage();
    checkoutSuccessPage.waitForPageLoad();
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("the URL is not 'CheckoutSuccessPage' page", CheckoutSuccessPage.CHECKOUT_SUCCESS_PAGE_URL, currentUrl);
  }
}

















