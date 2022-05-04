package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends AbstractPage {
  public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

  @FindBy(xpath = "//button[text()='Open Menu']")
  private WebElement hamburgerElem;

  @FindBy(css = "#shopping_cart_container > a")
  private WebElement shoppingCartElem;

  @FindBy(css = "#inventory_container")
  private WebElement inventoryContainerElem;

  public InventoryPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return inventoryContainerElem;
  }

  public void addItemToCartByName(String itemName) {
    String xpath =
      String.format("//div[contains(., '%s')]/parent::a/parent::div/following-sibling::div/button",
        itemName);
    WebElement itemElem = getDriver().findElement(By.xpath(xpath));

    itemElem.click();
  }

  public void clickOnShoppingCart() {
    shoppingCartElem.click();
  }
}
