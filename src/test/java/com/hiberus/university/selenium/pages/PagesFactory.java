package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;

//  private final CheckOutCompletePage checkOutCompletePage;
//  private final CheckOutStepOnePage checkOutStepOnePage;
//  private final CheckOutStepTwoPage checkOutStepTwoPage;
//  private final InventoryPage inventoryPage;
  private final LoginPage loginPage;

  private final HomePage homePage;
  private final MyAccountPage myAccountPage;
  private final CartPage cartPage;

  private final RegisterPage registerPage;

  private final CheckOutPage checkOutPage;

  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    checkOutPage = new CheckOutPage(driver);
//    checkOutCompletePage = new CheckOutCompletePage(driver);
//    checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
//    inventoryPage = new InventoryPage(driver);
    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver);
    cartPage = new CartPage(driver);
    registerPage = new RegisterPage(driver);
    myAccountPage = new MyAccountPage(driver);
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
//  public CheckOutCompletePage getCheckOutCompletePage() {
//    return checkOutCompletePage;
//  }
//
  public CheckOutPage getCheckOutStepOnePage() {
    return checkOutPage;
  }
//
//  public CheckOutStepTwoPage getCheckOutStepTwoPage() {
//    return checkOutStepTwoPage;
//  }

//  public InventoryPage getInventoryPage() {
//    return inventoryPage;
//  }

  public LoginPage getLoginPage() {

    return loginPage;
  }

  public HomePage getHomePage() {

    return homePage;
  }

  public MyAccountPage getMyAccountPage() {

    return myAccountPage;
  }

  public CartPage getCartPage() {

    return cartPage;
  }

  public RegisterPage getRegisterPage() {

    return registerPage;
  }
}
