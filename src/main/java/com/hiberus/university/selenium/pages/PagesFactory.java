package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {

  private static PagesFactory pagesFactories;
  private final WebDriver driver;

  public PagesFactory(WebDriver driver) {
    this.driver = driver;
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
