package com.practicafinal.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;

  private final HomePage homepage;
  private final RegistrerPage registerpage;
  private final LoginPage loginpage;
  private final CartPage cartpage;
  private final CheckoutPage checkoutpage;

  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    homepage = new HomePage(driver);
    registerpage = new RegistrerPage(driver);
    loginpage = new LoginPage(driver);
    cartpage = new CartPage(driver);
    checkoutpage = new CheckoutPage(driver);

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

  public HomePage getHomepage(){return homepage;}

  public RegistrerPage getRegisterpage(){return registerpage;}

  public LoginPage getLoginpage(){return loginpage;}

  public CartPage getCartpage(){return cartpage;}

  public CheckoutPage getCheckoutpage(){return checkoutpage;}
}
