package com.opencart.automation.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return loginButton;
  }

  public void clickLogin() {
    log.info("Logging in...");
    try {
      loginButton.click();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());

    } catch (Exception e) {
      log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
    }
  }

  public void waitForVisibility(WebElement element) {
    wait = new WebDriverWait(driver, TIMEOUT);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void sendText(WebElement element, String text) {
    waitForVisibility(element);
    element.sendKeys(text);
  }

  public void enterData(String email, String password) {
    sendText(inputEmail, email);
    sendText(inputPassword, password);
  }



  public boolean hasUsernamePasswordError() {
    return errorMessage.isDisplayed();
  }
}
