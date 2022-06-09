package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;
  private final RegisterPage registerPage;
  private final LoginPage loginPage;
  private final HomePage homePage;
  private final AccountSuccessPage accountSuccessPage;
  private final AccountPage accountPage;
  private final CheckoutPage checkOutPage;
  private final LogoutPage logoutPage;
  private final CheckoutSuccessPage checkoutSuccessPage;

  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    registerPage = new RegisterPage(driver);
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    accountSuccessPage = new AccountSuccessPage(driver);
    accountPage = new AccountPage(driver);
    checkOutPage = new CheckoutPage(driver);
    logoutPage = new LogoutPage(driver);
    checkoutSuccessPage = new CheckoutSuccessPage(driver);
  }
  public static void start(WebDriver driver) {
    pagesFactories = new PagesFactory(driver);
  }
  public static PagesFactory getInstance() {
    return pagesFactories;
  }

  public WebDriver getDriver() {
    return driver;
  }
  public RegisterPage getRegisterPage () {
    return registerPage;
  }
  public LoginPage getLoginPage() {
    return loginPage;
  }
  public AccountSuccessPage getAccountSuccessPage () {
    return accountSuccessPage;
  }
  public AccountPage getAccountPage() {return accountPage;}
  public HomePage getHomePage(){
    return homePage;
  }
  public CheckoutPage getCheckOutPage() {
    return checkOutPage;
  }
  public LogoutPage getLogoutPage() {
    return logoutPage;
  }
  public CheckoutSuccessPage getCheckoutSuccessPage(){
    return checkoutSuccessPage;
  }
}
