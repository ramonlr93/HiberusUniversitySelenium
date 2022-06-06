package com.hiberus.university.selenium.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;
  private final HomePage homePage;
  private final LoginPage loginPage;
  private final  RegisterPage registerPage;

  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver);
    registerPage = new RegisterPage(driver);
  }

  public static void start(WebDriver driver) {
    pagesFactories = new PagesFactory(driver);
  }

  public static PagesFactory getInstance() {
    return pagesFactories;
  }
}
