package com.hiberus.university.selenium.pages;

import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {
  public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

  @FindBy(id = "shopping_cart_container")
  private WebElement shoppingCart;

  @FindBy(xpath = "//div[@class='inventory_item']")
  private List<WebElement> inventoryItems;

  @FindBy(xpath = "//select[@data-test='product_sort_container']")
  private WebElement selectOptions;

  @FindBy(xpath = "//div[@class='inventory_list']")
  private List<WebElement> inventoryPriceList;

  @FindBy(xpath = "//a[@class='shopping_cart_link']")
  private WebElement productsQuantityInCart;


  public InventoryPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//div[@class='inventory_item_name']")
  private List<WebElement> inventoryNameList;



  @Override
  public WebElement getPageLoadedTestElement() {
    return selectOptions;
  }

  public int getInventoryItemsSize(){
    return inventoryItems.size();
  }

  public void addItemToCartByName(String itemName) {
    String xpath = getButton(itemName);
    WebElement itemElem = getDriver().findElement(By.xpath(xpath));
    itemElem.click();
  }


  public void removeItemToCartByName(String itemName) {
    //UString xpath = getButton(itemName);
    String xpath = getRemoveButton(itemName);
    WebElement itemElem = getDriver().findElement(By.xpath(xpath));
    itemElem.click();
  }

  public WebElement getProductsQuantityInCart() {
    return productsQuantityInCart;
  }

  private String getButton(String itemName) {
    return "//div[contains(., '" + itemName + "')]/parent::a/parent::div/following-sibling::div/button";
  }

  private String getRemoveButton(String itemName) {
    String itemNameNoSpaces = itemName.toLowerCase();
    String itemNameScripts = itemNameNoSpaces.replace(" ", "-");

    String xpath = "//button[@id='remove-" + itemNameScripts + "']";
    return xpath;
  }

  public void clickOnShoppingCart() {
    shoppingCart.click();
  }

  public void selectOption(String option) {
    Select selectOption = new Select(selectOptions);
    selectOption.selectByValue(option);
  }

  public List<WebElement> getItemList() {
    return inventoryItems;
  }

  public List<WebElement> getInventoryNameList() {
    return inventoryNameList;
  }

  public List<WebElement> getInventoryPriceList(){
    return inventoryPriceList;
  }
}
