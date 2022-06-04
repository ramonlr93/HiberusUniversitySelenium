package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {
  public static final String ACCOUNT_PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/account";

  @FindBy(id = "account-account")
  private WebElement accountContainer;

  public AccountPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return accountContainer;
  }
}
