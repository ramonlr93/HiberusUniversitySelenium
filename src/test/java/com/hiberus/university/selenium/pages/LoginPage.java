package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
  public static final String PAGE_URL = "http://opencart.abstracta.us/";
  public static final String LOGIN_URL = "https://opencart.abstracta.us/index.php?route=account/login";
  public static final String LOGGED_URL = "https://opencart.abstracta.us/index.php?route=account/account";

  public static final String FORGOTTENPASSWORD_URL = "https://opencart.abstracta.us/index.php?route=account/forgotten";
  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
  private WebElement accountLink;

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
  private WebElement loginLink;

  @FindBy(id = "input-email")
  private WebElement usernameInput;

  @FindBy(id = "input-password")
  private WebElement passwordInput;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
  private WebElement loginButton;
  @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
  private WebElement errorMessage;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")
  private WebElement forgottenPasswordLink;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  private WebElement continueButton;

  @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
  private WebElement confirmationMessage;



  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return loginLink;
  }

  public void clickMyAccount() {
    try {
      accountLink.click();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());

    } catch (Exception e) {
      log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
    }
  }
  public void clickLoginLink() {
    log.info("Logging in...");
    try {
      loginLink.click();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());

    } catch (Exception e) {
      log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
    }
  }

  public void clickLoginButton() {
    log.info("Logging in...");
    try {
      loginButton.click();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());

    } catch (Exception e) {
      log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
    }
  }

  public void clickContinueButton() {
    log.info("Logging in...");
    try {
      continueButton.click();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());

    } catch (Exception e) {
      log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
    }
  }

  public void clickForgottenPasswordLink() {
    log.info("Logging in...");
    try {
      forgottenPasswordLink.click();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());

    } catch (Exception e) {
      log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
    }
  }
  public void enterPassword(String password) {
    passwordInput.click();
    passwordInput.sendKeys(password);
  }

  public void enterUsername(String username) {
    usernameInput.click();
    usernameInput.sendKeys(username);
  }
  public boolean hasUsernamePasswordError() {
    return errorMessage.isDisplayed();
  }

  public boolean confirmationForgottenPasswordMessage() {
    return confirmationMessage.isDisplayed();
  }

}
