package com.hiberus.university.selenium.pages;

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
24  public static PagesFactory getInstance() {
    return pagesFactories;
  }
 public WebDriver getDriver() {
    return driver;
  }

  public LoginPage getLoginPage() {
    return loginPage;
  }

}
