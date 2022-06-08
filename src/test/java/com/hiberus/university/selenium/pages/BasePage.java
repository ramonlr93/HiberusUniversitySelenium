package com.hiberus.university.selenium.pages;

import com.hiberus.university.selenium.utils.MyFluentWait;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.time.temporal.ChronoUnit;

@Slf4j
public abstract class BasePage {

  protected Wait<WebDriver> wait;

  private final WebDriver driver;

  @FindBy(xpath = "//a[contains(@title, 'My Account') and contains(@class, 'dropdown-toggle')]")
  private WebElement myAccountDropdown;

  @FindBy(xpath = "//li[@class='dropdown']")
  private WebElement myAccountDropdownMenu;

  @FindBy(xpath = "//ul[@class='breadcrumb']//a[contains(@href, 'http://opencart.abstracta.us:80/index.php?route=common/home')]")
  private WebElement homeButton;
  @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href, 'https://opencart.abstracta.us:443/index.php?route=account/register')]")
  private WebElement registerButton;

  @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[contains(@href, 'https://opencart.abstracta.us:443/index.php?route=account/login')]")
  private WebElement loginButton;

  @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[contains(@href, 'https://opencart.abstracta.us:443/index.php?route=account/logout')]")
  private WebElement logoutButton;

  @FindBy(xpath = "//ul[@class='list-inline']/descendant::a[contains(@href, 'https://opencart.abstracta.us:443/index.php?route=checkout/checkout')]")
  private WebElement checkoutButton;

//<div id="top-links" class="nav pull-right">

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

  public void clickMyAccount() {
    myAccountDropdown.click();
  }

  public void clickMyAccountFromMenu() {
    myAccountDropdownMenu.click();
  }
  public void clickHomeButton() {
    homeButton.click();
  }
  public void clickRegisterFromMenu() {
    registerButton.click();
  }
  public void clickLoginFromMenu() {
    loginButton.click();
  }
  public void clickCheckoutFromMenu() {
    checkoutButton.click();
  }
  public void clickLogoutFromMenu() {
    logoutButton.click();
  }
}