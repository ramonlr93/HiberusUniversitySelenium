package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {

  private static PagesFactory pagesFactories;
  private final WebDriver driver;

  private final CheckOutStepOnePage checkOutStepOnePage;
  private final CheckOutStepTwoPage checkOutStepTwoPage;
  private final InventoryPage inventoryPage;
  private final LoginPage loginPage;
  private final CartPage cartPage;

  public PagesFactory(WebDriver driver) {
    this.driver = driver;
    checkOutStepOnePage = new CheckOutStepOnePage(driver);
    checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
    inventoryPage = new InventoryPage(driver);
    loginPage = new LoginPage(driver);
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
