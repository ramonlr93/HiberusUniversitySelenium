package com.hiberus.university.selenium.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends AbstractPage {
  public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

  @FindBy(xpath = "//button[text()='Open Menu']")
  private WebElement hamburgerElem;

  @FindBy(css = "#shopping_cart_container > a")
  private WebElement shoppingCartElem;

  @FindBy(css = "#inventory_container")
  private WebElement inventoryContainer;

  @FindBy(xpath = "//div[@class='inventory_item_name']")
  private List<WebElement> inventoryNameList;

  @FindBy(xpath = "//div[@class='inventory_item_price']")
  private List<WebElement> inventoryPriceList;

  @FindBy(xpath = "//select[@data-test='product_sort_container']")
  private WebElement selectOptions;


  public InventoryPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return inventoryContainer;
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

  public List<WebElement> getInventoryNameList() {
    return inventoryNameList;
  }

  public List<WebElement> getInventoryPriceList() {
    return inventoryPriceList;
  }

  public boolean existProductInInventoryList(String itemName) {
    boolean isProductPresent = false;
    for (WebElement webElement : inventoryNameList) {
      if (webElement.getText().equals(itemName)) {
        isProductPresent = true;
        break;
      }
    }
    return isProductPresent;
  }

  public void selectOption(String option) {
    Select selectOption = new Select(selectOptions);
    selectOption.selectByValue(option);
  }
}
