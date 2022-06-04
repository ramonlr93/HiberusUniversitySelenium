package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
  public static final String HOME_PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

  @FindBy(xpath = "//button[@onclick='cart.add('40');']")
  private WebElement iphoneElement;

  private WebElement pageLoadedTestElement;

  public WebElement GetPageLoadedTestElement() {
    return this.pageLoadedTestElement;
  }

  public void SetPageLoadedTestElement(WebElement testElement) {
    this.pageLoadedTestElement = testElement;
  }

  public HomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return GetPageLoadedTestElement();
  }

  public void addItemToCartByName(String itemName) {
    String xpath =
      String.format("//div[contains(., '%s')]/parent::a/parent::div/following-sibling::div/button",
        itemName);
    WebElement itemElem = getDriver().findElement(By.xpath(xpath));

    itemElem.click();
  }

}
