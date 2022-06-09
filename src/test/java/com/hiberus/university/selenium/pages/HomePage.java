package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
  public static final String HOME_PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

  @FindBy(xpath = "//div[@id='content']")
  private WebElement containerYourStore;

  @FindBy(xpath = "//button[contains(@onclick, 'cart.add') and contains(@onclick, '40')]")
  private WebElement iphoneProduct;

  @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/child::a[1]")
  private WebElement successAddToCartMessage;

  @FindBy(xpath = "//span[@id='cart-total']")
  private WebElement shoppingCartElement;

  @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
  private WebElement shoppingCartButton;

  @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']")
  private WebElement infoPanel;

  @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
  private WebElement currencyButton;

  @FindBy(xpath = "//button[@name='EUR']")
  private WebElement euroButton;

  @FindBy(xpath = "//button[@title='Remove']")
  private WebElement deleteButton;


  public HomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return containerYourStore;
  }

  public void clickIphoneProductButton() {
    iphoneProduct.click();
  }

  public boolean successAddToCartMessageIsDisplayed() {
    return successAddToCartMessage.isDisplayed();
  }

  public boolean shoppingCartInfo() {
    return shoppingCartElement.isDisplayed();
  }

  public void clickShoppingCartButton() {
    wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton)).click();
  }

  public boolean infoPanelView() {
    return infoPanel.isDisplayed();
  }

  public void clickDeleteButton() {
    wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
  }

  public String shoppingCartText() {
    return wait.until(ExpectedConditions.elementToBeClickable(shoppingCartElement)).getText();
  }

  public void clickCurrencyButton() {
    wait.until(ExpectedConditions.elementToBeClickable(currencyButton)).click();
  }

  public void clickEuroButton() {
    wait.until(ExpectedConditions.elementToBeClickable(euroButton)).click();
  }
}



