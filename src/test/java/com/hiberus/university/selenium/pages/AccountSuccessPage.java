package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage extends BasePage {
  public static final String ACCOUNT_SUCCESS_PAGE_URL = "http://opencart.abstracta.us/index.php?route=account/success";

  @FindBy(xpath = "//div[@id='common-success']")
  private WebElement accountSuccessContainer;

  public AccountSuccessPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return accountSuccessContainer;
  }
}




