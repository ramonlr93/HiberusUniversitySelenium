package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

  public String shoppingCartInfo() {
    return shoppingCartElement.getText();
  }
}






