package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;

  private final LoginPage loginPage;
  private final RegisterPage registerPage;


  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    loginPage = new LoginPage(driver);
    registerPage = new RegisterPage(driver);

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
  public RegisterPage getRegisterPage() {
        return registerPage;
    }

}
