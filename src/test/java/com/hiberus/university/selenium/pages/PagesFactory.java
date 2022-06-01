
package com.hiberus.university.selenium.pages;


import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {

  private static PagesFactory pagesFactory;
  private final WebDriver driver;
  private final LoginPage loginPage;
  private final InventoryPage inventoryPage;
  private final ProductDetailsPage productDetailsPage;
  private final CartPage cartPage;
  private final CheckOutOnePage checkoutOnePage;
  private final CheckoutTwoPage checkoutTwoPage;
  private final CheckoutComplete checkoutComplete;

  public PagesFactory(WebDriver driver) {
    this.driver = driver;
    loginPage = new LoginPage(driver);
    inventoryPage = new InventoryPage(driver);
    productDetailsPage = new ProductDetailsPage(driver);
    cartPage = new CartPage(driver);
    checkoutOnePage = new CheckOutOnePage(driver);
    checkoutTwoPage = new CheckoutTwoPage(driver);
    checkoutComplete = new CheckoutComplete(driver);
  }
  public static PagesFactory getInstance() {
    return pagesFactory;
  }
  public static PagesFactory start(WebDriver driver) {
    pagesFactory = new PagesFactory(driver);
    return pagesFactory;
  }

  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

}
