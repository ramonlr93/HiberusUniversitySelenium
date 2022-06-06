package com.opencart.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;

  private final LoginPage loginPage;


  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    loginPage = new LoginPage(driver);

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

  public CheckOutCompletePage getCheckOutCompletePage() {
    return checkOutCompletePage;
  }

  public CheckOutStepOnePage getCheckOutStepOnePage() {
    return checkOutStepOnePage;
  }

  public CheckOutStepTwoPage getCheckOutStepTwoPage() {
    return checkOutStepTwoPage;
  }

  public InventoryPage getInventoryPage() {
    return inventoryPage;
  }

  public LoginPage getLoginPage() {
    return loginPage;
  }

  public CartPage getCartPage() {
    return cartPage;
  }
}
