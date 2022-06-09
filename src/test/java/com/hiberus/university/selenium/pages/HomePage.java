package com.hiberus.university.selenium.pages;

import com.hiberus.university.selenium.model.CartProduct;
import com.hiberus.university.selenium.model.InventoryProduct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class HomePage extends BasePage {
    public static final String HOME_PAGE_URL = "https://opencart.abstracta.us";

    @FindBy(xpath = "//div[contains(@class, 'product-thumb')]")
    private List<WebElement> products;

    @FindBy(id = "cart-total")
    private WebElement cart;

    @FindBy(xpath = "//table[contains(@class, 'table-striped')]//tr")
    private List<WebElement> cartProducts;

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return products.get(0);
    }

    private WebElement getInventoryProductWE(String name) {
        return products.stream()
                .filter(product -> getProductNameStr(product).equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private WebElement getProductName(WebElement product) {
        return product.findElement(By.xpath(".//div[contains(@class, 'caption')]//h4"));
    }

    private String getProductNameStr(WebElement product) {
        return getProductName(product).getText();
    }

    private double getProductPrice(WebElement product) {
        return Double.parseDouble(
                product.findElement(By.xpath(".//p[contains(@class, 'price')]"))
                        .getText()
                        .split("Ex")[0]
                        .replace("$", "")
        );
    }

    private WebElement getProductAddCartButton(WebElement product) {
        return product.findElement(By.xpath(".//button[contains(@onclick, 'cart.add')]"));
    }

    private WebElement getCartProductWE(String name) {
        return cartProducts.stream()
                .filter(cartProduct -> getCartProductName(cartProduct).getText().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    private WebElement getCartProductName(WebElement cartProduct) {
        return cartProduct.findElement(By.xpath(".//td[2]/a"));
    }

    private int getQuantityCartProducts(WebElement cartProduct) {
        return Integer.parseInt(
                cartProduct.findElement(By.xpath(".//td[3]"))
                        .getText()
                        .split(" ")[1]
        );
    }

    private double getCartProductPrice(WebElement cartProduct) {
        return Double.parseDouble(
                cartProduct.findElement(By.xpath(".//td[4]"))
                        .getText()
                        .replace("$", "")
                        .replace(",", "")
        );
    }

    private WebElement getRemoveFromCartButton(WebElement cartProduct) {
        return cartProduct.findElement(By.xpath(".//td[5]/button"));
    }

    public InventoryProduct getInventoryProduct(String name) {
        WebElement product = getInventoryProductWE(name);
        return new InventoryProduct(
                getProductName(product),
                getProductPrice(product),
                getProductAddCartButton(product)
        );
    }

    public List<InventoryProduct> getInventoryProducts() {
        return products.stream()
                .map(product -> getInventoryProduct(getProductNameStr(product)))
                .collect(Collectors.toList());
    }

    public CartProduct getCartProduct(String name) {
        WebElement product = getCartProductWE(name);
        return new CartProduct(
                getCartProductName(product),
                getCartProductPrice(product),
                getQuantityCartProducts(product),
                getRemoveFromCartButton(product)
        );
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts.stream()
                .map(product -> getCartProduct(getCartProductName(product).getText()))
                .collect(Collectors.toList());
    }

    public void displayCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
        if (cartProducts.size() > 0)
            wait.until(ExpectedConditions.visibilityOf(cartProducts.get(0)));
    }

    public void cleanCartProducts() {
        displayCart();
        // CLEANING THE PRODUCTS FROM CART

        while (numberCartItems() > 0) {
            try {
                CartProduct cartProduct = getCartProduct(getCartProductName(cartProducts.get(0)).getText());
                cartProduct.deleteFromCart();
            } catch (Exception ignored) { }

            displayCart();
        }
    }

    public int numberCartItems()  {
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(cart)).getText().split(" ")[0]);
    }

    public double totalPriceCart()  {
        String[] cartArray = wait.until(ExpectedConditions.visibilityOf(cart)).getText().split(" ");
        return Double.parseDouble(cartArray[cartArray.length - 1].replace("$", "").replace(",", ""));
    }



}
