package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSuccessPage extends BasePage {

  public static final String CHECKOUT_SUCCESS_PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/success";

  @FindBy(xpath = "//div[@id='content']")
  private WebElement checkoutSuccessContainer;


  public CheckoutSuccessPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return checkoutSuccessContainer;
  }
}




