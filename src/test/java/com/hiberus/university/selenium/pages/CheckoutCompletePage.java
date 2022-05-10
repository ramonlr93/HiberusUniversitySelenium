package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CheckoutCompletePage extends AbstractPage {
  public static final String PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";

  @FindBy(xpath = "//span[@class='title']")
  private WebElement title;

  @FindBy(id = "password")
  private WebElement BackHomeButton;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @FindBy(xpath = "//h3[@data-test='error']")
  private WebElement errorMessage;


  public CheckoutCompletePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return title;
  }

  public boolean hasUsernamePasswordError() {
    return errorMessage.isDisplayed();
  }
}
