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
  private final CheckOutCompletePage checkOutCompletePage;
  private final CheckOutStepOnePage checkOutStepOnePage;
  private final CheckOutStepTwoPage checkOutStepTwoPage;
  private final CartPage cartPage;

  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    registerPage = new RegisterPage(driver);
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    accountSuccessPage = new AccountSuccessPage(driver);
    accountPage = new AccountPage(driver);
    checkOutStepOnePage = new CheckOutStepOnePage(driver);
    checkOutCompletePage = new CheckOutCompletePage(driver);
    checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
    cartPage = new CartPage(driver);
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

  public CheckOutCompletePage getCheckOutCompletePage() {
    return checkOutCompletePage;
  }
  public CheckOutStepOnePage getCheckOutStepOnePage() {
    return checkOutStepOnePage;
  }
  public CheckOutStepTwoPage getCheckOutStepTwoPage() {
    return checkOutStepTwoPage;
  }
  public CartPage getCartPage() {
    return cartPage;
  }


}
