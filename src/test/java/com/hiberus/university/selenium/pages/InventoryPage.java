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

  // Crea un listado de webelements de los productos
  public List<WebElement> getProducts(){
    List<WebElement> productsList = getDriver().findElements(By.xpath("//div[contains(@class, 'product-layout')]"));
    return productsList;
  }

  public int numberOfProductsShown(){
    System.out.println("Num products: " + getProducts().size());
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

  // Devuelve un webelement al azar del listado de productos que le pasamos como parámetro
  public WebElement getRandomProduct(List<WebElement> list){
    int random = ThreadLocalRandom.current().nextInt(0, list.size()-1);
    return list.get(random);
  }

  // Añade el producto al carrito
  public void addRandomProductToCart() {
    WebElement productToAdd = getRandomProduct(getProducts());
    System.out.println("BUTTON: " + productToAdd.findElement(By.xpath("//button[contains(@onclick, 'cart.add')]")).getText());
    productToAdd.findElement(By.xpath("//button[contains(@onclick, 'cart.add')]")).click();
    getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    System.out.println("items on cart: " + cartButton.getText());
    //getRandomProduct(getProducts()).findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]/span")).click();
  }

  public int getProductPrice (WebElement product) {
    return Integer.parseInt(product.findElement(By.xpath("p[@class='price']")).getText());
  }

  public String getProductName (WebElement product) { // AQUI ME QUEDO
    System.out.println(product.findElement(By.xpath("//a[contains(@href, 'http://opencart')]")).getText());
    return product.findElement(By.tagName("a")).getText();
  }

  public void getProductInfo(){
    WebElement product = getRandomProduct(getProducts());
    //System.out.println("Nombre: " + getProductName(product));
    System.out.println("Precio: " + getProductPrice(product));

  }

  public void addProductToCartByName(String productToAdd){
    List<WebElement> list = getProducts();
    WebElement productToAddWebelement = getProducts().get(0);
    for (int i=0; i< list.size(); i++){
      System.out.println("PRODUCTO NUMERO " + i);
      System.out.println(list.get(i).getText());
      if(list.get(i).getText().contains(productToAdd)){
        productToAddWebelement = list.get(i);
        System.out.println("producto encontrado" + productToAddWebelement.getText());
        productToAddWebelement.findElement(By.xpath("//button[contains(@onclick, 'cart.add')]")).click();
      }
    }
  }

  public void removeProductFromCart() {
    cartWindowRemoveButton.click();
  }

  // Devuelve el número de productos del carrito
  public int numberOfProductsOnCart(){
    System.out.println("items on cart button:" + itemsOnCartButton.getText());
    System.out.println("products on cart:" + itemsOnCartButton.getText().substring(0,1));
   return Integer.parseInt(itemsOnCartButton.getText().substring(0,1));
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
