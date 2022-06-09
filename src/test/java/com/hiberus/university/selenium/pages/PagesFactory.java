package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;

  private final LoginPage loginPage;
  private final BasePage basePage;
  private final RegisterPage registerPage;
  private final CheckoutPage checkoutPage;

  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    loginPage = new LoginPage(driver);
    basePage = new BasePage(driver);
    registerPage = new RegisterPage(driver);
    checkoutPage = new CheckoutPage(driver);
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

  public LoginPage getLoginPage() {
    return loginPage;
  }

  public BasePage getBasePage() {
    return basePage;
  }

  public RegisterPage getRegisterPage() {
    return registerPage;
  }

  public CheckoutPage getCheckoutPage() {
    return checkoutPage;
  }

}
