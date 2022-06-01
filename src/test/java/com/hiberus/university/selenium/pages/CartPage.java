
package com.hiberus.university.selenium.pages;


import com.hiberus.university.selenium.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AbstractPage {

  @FindBy(className = "cart_item")
  private List<WebElement> products;

  @FindBy(id = "continue-shopping")
  private WebElement continueShoppingButton;

  @FindBy(id = "checkout")
  private WebElement goCheckoutButton;

  CartPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return null;
  }

  public WebElement getProductTitle(WebElement productContainer) {
    return productContainer
            .findElement(By.xpath(".//div[@class='inventory_item_desc']"));
  }

  public int getProductsOnCart() {
    return products.size();
  }
  public WebElement getProduct(String title) throws Exception {
    for (WebElement productContainer : products) {
      if (getProductTitle(productContainer).getText().equals(title)) {
        return productContainer;
      }
    }
    throw new Exception("No se ha podido encontrar el producto" + title);
  }
  public boolean isProductDisplayed(String title) throws Exception {
    return getProduct(title).isDisplayed();
  }
  private WebElement getButton(WebElement productContainer) {
    return productContainer.findElement(By.xpath(".//button"));
  }

  public int getProductQuantity(WebElement product) {
    return Integer.parseInt(product.findElement(By.xpath(".//div[@class='cart_quantity']")).getText());
  }

  public Double getProductPrice(String title) throws Exception {
    return getProductPrice(getProduct(title));
  }
  public Double getProductPrice(WebElement productContainer) {
    return Double.parseDouble(productContainer
            .findElement(By.xpath(".//div[@class='inventory_item_price']"))
            .getText()
            .replace("$", ""));
  }

  public void removeProductFromCart(String title) throws Exception {
    removeProductFromCart(getProduct(title));
  }
  public void removeProductFromCart(WebElement productContainer) {
    WebElement button = getButton(productContainer);
    if (button.getText().trim().equalsIgnoreCase("Remove"))
      button.click();
  }

  public void continueShopping() {
    continueShoppingButton.click();
  }

  public void goCheckout() {
    goCheckoutButton.click();
  }

  public Double getTotalPrice() {
    Double totalPrice = 0d;
    for (WebElement product : products)
      totalPrice += getProductPrice(product) * getProductQuantity(product);
    return totalPrice;
  }

  private List<WebElement> getAllProductsButtons() {
    List<WebElement> allButtons = new ArrayList<>();
    for (WebElement product : products)
      allButtons.add(getButton(product));
    return allButtons;
  }

  public void removeRandomProducs(int numberOfProducts) {
    List<WebElement> botonesProductos = getAllProductsButtons();
    List<Integer> numerosRandom = new ArrayList<>();
    for (int i = 0; i < numberOfProducts && i < botonesProductos.size(); i++) {
      int rnd;
      do
        rnd = (int) Math.floor(Math.random() * (botonesProductos.size()));
      while (numerosRandom.contains(rnd));
      botonesProductos.get(rnd).click();
      numerosRandom.add(rnd);
    }
  }
}
