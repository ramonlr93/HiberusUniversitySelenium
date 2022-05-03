package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends AbstractPage {
  public static final String PAGE_URL = "https://www.saucedemo.com";

  @FindBy(xpath = "//input[@data-test='username']")
  private WebElement usernameInput;

  @FindBy(xpath = "//input[@data-test='password']")
  private WebElement passwordInput;

  @FindBy(xpath = "//input[@data-test='login-button']")
  private WebElement loginButton;

  public LoginPage(WebDriver driver) {
    super(driver);
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

  public void enterPassword(String password) {
      passwordInput.click();
      passwordInput.sendKeys(password);
  }

  public void enterUsername(String username) {
      usernameInput.click();
      usernameInput.sendKeys(username);
  }

  public boolean hasLockedOutError() {
    WebElement elem = getDriver().findElement(By.xpath("//button[@class='error-button']"));
    return elem.isDisplayed();
  }

  public boolean hasUsernamePasswordError() {
    WebElement elem = getDriver().findElement(By.xpath("//button[@class='error-button']"));
    return elem.isDisplayed();
  }
}
