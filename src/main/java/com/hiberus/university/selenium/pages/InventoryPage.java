package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends AbstractPage {
  public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

  @FindBy(xpath = "//button[text()='Open Menu']")
  private WebElement hamburgerElem;

  @FindBy(id = "shopping_cart_container")
  private WebElement shoppingCart;

  @FindBy(css = "#inventory_list")
  private WebElement inventoryContainer;

  @FindBy(xpath = "//select[@data-test='product_sort_container']")
  private WebElement selectOptions;

  @FindBy(xpath = "//div[@class='inventory_item_name']")
  List<WebElement> inventoryResults;

  public InventoryPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return inventoryContainer;
  }

  public List<WebElement> getList(){
    return inventoryResults;
  }

  public boolean productName(String itemName) {
    boolean validar = false;
    for(int i = 0; i < inventoryResults.size(); i++) {
      if(inventoryResults.get(i).getText().equals(itemName)) {
        validar = true;
      }
    }
    return validar;
  }

  public void addItemToCartByName(String itemName) {
    String xpath = getButton(itemName);
    WebElement itemElem = getDriver().findElement(By.xpath(xpath));
    itemElem.click();
  }

  public void removeItemToCartByName(String itemName) {
    String xpath = getButton(itemName);
    WebElement itemElem = getDriver().findElement(By.xpath(xpath));
    itemElem.click();
  }

  public void addItemsToCartByName(int num) {
    ArrayList<Integer> selectValue = new ArrayList<>();
    int pos;
    int count = 0;
    if (num<inventoryResults.size() && num>0){
      for(int  i = 0; i < inventoryResults.size(); i++) {
        pos = (int) Math.floor(Math.random() * inventoryResults.size());

        while (selectValue.contains(pos)) {
          pos = (int) Math.floor(Math.random() * inventoryResults.size());
        }

        if(count < num) {
          selectValue.add(pos);
          count++;
        }
      }
    }
  }

  private String getButton(String itemName) {
    return "//div[contains(., '" + itemName + "')]/parent::a/parent::div/following-sibling::div/button";
  }

  public void clickOnShoppingCart() {
    shoppingCart.click();
  }

  public int getNumberCart() {
    try {
      return Integer.parseInt(shoppingCart.getText());
    } catch (Exception e) {
      return 0;
    }
  }

  public void selectOption(String option) {
    Select selectOption = new Select(selectOptions);
    selectOption.selectByValue(option);
  }
}


