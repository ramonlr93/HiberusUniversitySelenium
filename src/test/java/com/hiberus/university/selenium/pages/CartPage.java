package com.hiberus.university.selenium.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.w3c.dom.html.HTMLInputElement;

public class CartPage extends BasePage{
  public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/cart";

  @FindBy(xpath = "//i[contains(@class, 'fa fa-home')]")
  private WebElement yourStore;

  @FindBy(id = "cart-total")
  private WebElement carrito;


  @FindBy(xpath = "//button[contains(@onclick, 'cart.remove')]")
  private WebElement deleteItem;

  @FindBy(xpath = "//span[@id='cart-total']")
  private WebElement shoppingCartElement;

  public CartPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }
    @Override
    public WebElement getPageLoadedTestElement() {
     return yourStore;
    }
    public void clickYourStore() {

    yourStore.click();
    }
//    public void clickCheckout() {
//      checkOutButton.click();
//    }

    public void deleteCartItem() {

    deleteItem.click();

    }

  public void clickCart() {

    carrito.click();

  }

    public String cartInfo() {

    return shoppingCartElement.getText();
    }
  }

//  public int getItemCount() {
//    return itemsList.size();
//  }
//
//  public List<WebElement> getItemsList() {
//
//    return itemsList;
//  }
//

//  public String cartInfo() {
//    return shoppingCartElement.getText();
//  }

