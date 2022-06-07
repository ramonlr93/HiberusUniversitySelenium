package com.opencart.automation.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
  public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

  @FindBy(id = "input-email")
  private WebElement inputEmail;

  @FindBy(id = "input-password")
  private WebElement inputPassword;

  @FindBy(xpath = "//input[@value='Login']")
  private WebElement loginButton;

  @FindBy(className = "alert-dismissible")
  private WebElement errorMessage;

  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return loginButton;
  }

  public void enterEmail(String email) {
    sendText(inputEmail, email);
  }
  public void enterPassword(String password) {
    sendText(inputPassword, password);
    }

  public void clickLogin() {
    click(loginButton);
  }

  public boolean hasEmailPasswordError() {
    return errorMessage.isDisplayed();
  }
}
