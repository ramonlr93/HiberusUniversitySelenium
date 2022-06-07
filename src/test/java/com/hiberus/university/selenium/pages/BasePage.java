package com.hiberus.university.selenium.pages;

import com.hiberus.university.selenium.utils.MyFluentWait;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

@Slf4j
public abstract class BasePage {
  @FindBy(xpath = "//li[@class='dropdown open']")
  WebElement liMyAcount;


  protected Wait<WebDriver> wait;
  private final WebDriver driver;

  BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new MyFluentWait<>(driver)
      .withTimeout(60, ChronoUnit.SECONDS)
      .pollingEvery(2, ChronoUnit.SECONDS)
      .ignoring(NoSuchElementException.class);
  }
  public abstract WebElement getPageLoadedTestElement();

  protected WebDriver getDriver() {
    return driver;
  }

  protected Wait<WebDriver> getWait() {
    return wait;
  }

  protected void setWait(Wait<WebDriver> wait) {
    this.wait = wait;
  }

  public void waitForPageLoad() {
    WebElement testElement = getPageLoadedTestElement();
    wait.until(ExpectedConditions.visibilityOf(testElement));
  }

  public String generateEmail(){
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    String email = "";
    Random rnd = new Random();
    while (email.length() < 10) { // length of the random string.
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      email += SALTCHARS.charAt(index);
    }
    email += "@";
    while (email.length() < 16) { // length of the random string.
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      email += SALTCHARS.charAt(index);
    }
    email += ".";
    while (email.length() < 19) { // length of the random string.
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      email += SALTCHARS.charAt(index);
    }

    return email;
  }

  public void navigateTo(String url) {
    WebDriver driver = getDriver();
    try {
      driver.navigate().to(url);
    } catch (java.lang.Exception e) {
      if (e instanceof TimeoutException) {
        log.info("Timeout loading home page");
      } else if (e instanceof ScriptTimeoutException) {
        log.info("Script Timeout loading home page");
      } else {
        log.error(e.getMessage());
      }
    }
  }
}