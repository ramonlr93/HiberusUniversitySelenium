package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class InventoryPage extends BasePage {
  public static final String CART_URL = "http://opencart.abstracta.us/index.php?route=checkout/cart";

  @FindBy(xpath = "//*[@id=\"cart-total\"]/i")
  private WebElement cartButton;
  @FindBy(xpath = "//*[@id=\"cart-total\"]")
  private WebElement itemsOnCartButton;

  @FindBy(xpath = "//*[@id=\"cart\"]/ul")
  private WebElement cartWindow;
  @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[5]/button")
  private WebElement cartWindowRemoveButton;

  @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[4]/td[2]")
  private WebElement cartWindowTotalPrice;

  @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
  private WebElement cartWindowViewCartLink;

  @FindBy(xpath = "//*[@id=\"common-home\"]/div[1]")
  private WebElement successMessageAddedToCart;



  public InventoryPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return cartButton;
  }
  public List<WebElement> getProducts(){
    List<WebElement> productsList = getDriver().findElements(By.xpath("//div[contains(@class, 'product-layout')]"));
    return productsList;
  }

  public int numberOfProductsShown(){
    return getProducts().size();
  }

  public boolean produtcIsShown(String product){
    List<WebElement> productsList = getProducts();
    for (int i=0; i<productsList.size();i++){
      if(productsList.get(i).getText().contains(product)){
        return true;
      }
    }
    return false;
  }

  public WebElement getRandomProduct(List<WebElement> list){
    int random = ThreadLocalRandom.current().nextInt(0, list.size()-1);
    return list.get(random);
  }

  public void addRandomProductToCart() {
    WebElement productToAdd = getRandomProduct(getProducts());
    productToAdd.findElement(By.xpath("//button[contains(@onclick, 'cart.add')]")).click();
    getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  public int getProductPrice (WebElement product) {
    return Integer.parseInt(product.findElement(By.xpath("p[@class='price']")).getText());
  }

  public String getProductName (WebElement product) {
    return product.findElement(By.tagName("a")).getText();
  }

  public void getProductInfo(){
    WebElement product = getRandomProduct(getProducts());
  }

  public void addProductToCartByName(String productToAdd){
    List<WebElement> list = getProducts();
    WebElement productToAddWebelement = getProducts().get(0);
    for (int i=0; i< list.size(); i++){
      if(list.get(i).getText().contains(productToAdd)){
        productToAddWebelement = list.get(i);
        productToAddWebelement.findElement(By.xpath("//button[contains(@onclick, 'cart.add')]")).click();
      }
    }
  }

  public void removeProductFromCart() {
    try {
      cartWindowRemoveButton.click();
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }

  }

  // Devuelve el número de productos del carrito
  public int numberOfProductsOnCart() throws InterruptedException {
    Thread.sleep(1000);
    try {
      return Integer.parseInt(itemsOnCartButton.getText().substring(0,1));
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }
    return 0;

  }

  private void clickButton (WebElement webelementToClick) {
    webelementToClick.click();
  }

  public void clickOnCartButton(){
    clickButton(cartButton);
  }

  public boolean successMessageAddedToCart() {
    return successMessageAddedToCart.isDisplayed();
  }


}
