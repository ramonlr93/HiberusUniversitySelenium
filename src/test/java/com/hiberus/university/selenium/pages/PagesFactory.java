package com.hiberus.university.selenium.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {

  private static PagesFactory pagesFactories;
  private final WebDriver driver;

  private final CheckOutStepOnePage checkOutStepOnePage;
  private final CheckOutStepTwoPage checkOutStepTwoPage;
  private final CartPage cartPage;
  private final CheckOutCompletePage checkOutCompletePage;

  private final RegisterPage registerPage;
  private final RegisterSuccessPage registerSuccessPage;
  private final LoginPage loginPage;
  private final MyAccountPage myAccountPage;
  private final ForgottenPasswordPage forgottenPasswordPage;
  private final InventoryPage inventoryPage;
  private final InventoryItemPage inventoryItemPage;
  public PagesFactory(WebDriver driver) {
    this.driver = driver;
    checkOutStepOnePage = new CheckOutStepOnePage(driver);
    checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
    checkOutCompletePage = new CheckOutCompletePage(driver);
    cartPage = new CartPage(driver);

    registerPage = new RegisterPage(driver);
    registerSuccessPage = new RegisterSuccessPage(driver);
    loginPage = new LoginPage(driver);
    myAccountPage = new MyAccountPage(driver);
    forgottenPasswordPage = new ForgottenPasswordPage(driver);
    inventoryPage = new InventoryPage(driver);
    inventoryItemPage= new InventoryItemPage(driver);
  }

  public static void start(WebDriver driver) {
    pagesFactories = new PagesFactory(driver);
  }

  public static PagesFactory getInstance() {
    return pagesFactories;
  }
}
