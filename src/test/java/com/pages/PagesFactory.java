package com.pages;

import org.openqa.selenium.WebDriver;
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;

    public PagesFactory(WebDriver driver) {
      this.driver = driver;
      loginPage = new LoginPage(driver);
      inventoryPage = new InventoryPage(driver);
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
}


