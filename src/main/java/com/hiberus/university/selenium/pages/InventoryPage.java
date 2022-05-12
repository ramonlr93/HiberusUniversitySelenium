package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    private WebElement filter;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public WebElement getProductTitle(WebElement productContainer) {
        return productContainer
                .findElement(By.xpath(".//div[@class='inventory_item_name']"));
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

    public Double getProductPrice(String title) throws Exception {
        return getProductPrice(getProduct(title));
    }
    public Double getProductPrice(WebElement productContainer) {
        return Double.parseDouble(productContainer
                .findElement(By.xpath(".//div[@class='inventory_item_price']"))
                .getText()
                .replace("$", ""));
    }


    public WebElement getProductImage(WebElement productContainer) {
        return productContainer
                .findElement(By.xpath(".//img"));
    }
    public WebElement getProductImage(String title) throws Exception {
        return getProductImage(getProduct(title));
    }

    public void addProductToCart(WebElement productContainer) {
        WebElement button = getButton(productContainer);
        if (button.getText().trim().equalsIgnoreCase("Add to cart".trim()))
            button.click();
    }
    public void addProductToCart(String title) throws Exception {
        addProductToCart(getProduct(title));
    }

    public void removeProductFromCart(String title) throws Exception {
        removeProductFromCart(getProduct(title));
    }
    public void removeProductFromCart(WebElement productContainer) {
        WebElement button = getButton(productContainer);
        if (button.getText().trim().equalsIgnoreCase("Remove"))
            button.click();
    }

    public int getNumberProductsCart() {
        try {
            return Integer.parseInt(cart.findElement(By.xpath("//span")).getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public void goCart() {
        cart.click();
    }

    public void goProductDetailClickingTitle(WebElement productContainer) {
        getProductTitle(productContainer)
                .click();
    }
    public void goProductDetailClickingTitle(String title) throws Exception {
        goProductDetailClickingTitle(getProduct(title));
    }

    public void goProductDetailsClickingImage(WebElement productContainer) {
        getProductImage(productContainer)
                .click();
    }
    public void goProductDetailsClickingImage(String title) throws Exception {
        getProductImage(getProduct(title))
                .click();
    }

    public int getNumberProducts() {
        return products.size();
    }

    public void filterBy(String value) {
        try {
            filter.findElement(By.xpath("//option[@value='" + value + "']"))
                    .click();
        } catch (Exception e) {
            System.err.println("Filtro inválido");
        }
    }
    public List<String> getProductsTitles() {
        List<String> titles = new ArrayList<>();
        for (WebElement product : products)
            titles.add(getProductTitle(product).getText());
        return titles;
    }

    public List<Double> getProductsPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement product : products)
            prices.add(getProductPrice(product));
        return prices;
    }
    private List<WebElement> getAllProductsButtons() {
        List<WebElement> allButtons = new ArrayList<>();
        for (WebElement product : products)
            allButtons.add(getButton(product));
        return allButtons;
    }

    public void addRandomProductsCart(int numberProducts) {
        List<WebElement> botonesProductos = getAllProductsButtons();
        List<Integer> numerosRandom = new ArrayList<>();
        for (int i = 0; i < numberProducts && i < botonesProductos.size(); i++) {
            int rnd;
            do
                rnd = (int) Math.floor(Math.random() * (botonesProductos.size()));
            while (numerosRandom.contains(rnd));
            botonesProductos.get(rnd).click();
            numerosRandom.add(rnd);
        }
    }
}
