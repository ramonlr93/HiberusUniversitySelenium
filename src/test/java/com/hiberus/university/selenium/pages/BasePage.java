package com.hiberus.university.selenium.pages;


import com.hiberus.university.selenium.utils.AccountOptionsClass.*;
import com.hiberus.university.selenium.utils.MyFluentWait;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import com.hiberus.university.selenium.utils.NavBar;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

@Slf4j
public abstract class BasePage {

  @FindBy(id = "top")
  private WebElement topNavBar;

  @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]//li//a")
  private List<WebElement> myAccountOptions;

  @FindBy(xpath = "//div[contains(@class, 'alert')]")
  private WebElement errorMessageDiv;

  public void clickTopNavBarOption(NavBar navBarOption) {
    topNavBar.findElement(By.xpath(".//i[contains(@class, '" + navBarOption.value + "')]")).click();
  }

  public void clickAccountOption(AccountOptions option) {
    myAccountOptions.stream()
            .filter(e -> e.getText().equals(option.value()))
            .findFirst()
            .orElse(null)
            .click();
  }

  public List<String> getMyAccountOptions() {
    return myAccountOptions
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
  }

  public String getErrorMessage() {
    try {
      return errorMessageDiv.getText();
    } catch (Exception e) { }
    return null;
  }

  protected Wait<WebDriver> wait;
  private final WebDriver driver;

  BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new MyFluentWait<>(driver)
      .withTimeout(10, ChronoUnit.SECONDS)
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

  protected void moveTo(WebElement elem) {
    if (((RemoteWebDriver) driver).getCapabilities().getBrowserName().equals("firefox")) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
    } else {
      Actions actions = new Actions(driver);
      actions.moveToElement(elem).build().perform();
    }
  }

  protected boolean isPageLoaded(WebElement elem) {
    boolean isLoaded = false;

    try {
      isLoaded = elem.isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException e) {
      e.printStackTrace();
    }
    return isLoaded;
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