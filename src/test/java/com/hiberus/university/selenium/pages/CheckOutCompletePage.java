package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CheckOutCompletePage extends BasePage {
  public static final String PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";

  @FindBy(xpath = "//span[@class='title']")
  private WebElement title;


  public CheckOutCompletePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return title;
  }
}
