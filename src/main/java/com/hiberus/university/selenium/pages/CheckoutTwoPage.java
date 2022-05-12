package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutTwoPage extends AbstractPage {

    @FindBy(className = "cart_item")
    private List<WebElement> products;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "finish")
    private WebElement finishCheckoutButton;

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(className = "summary_tax_label")
    private WebElement tax;

    @FindBy(className = "summary_total_label")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@class='summary_value_label'][1]")
    private WebElement shippingInfo;

    @FindBy(xpath = "//div[@class='summary_value_label'][2]")
    private WebElement paymentInfo;

    CheckoutTwoPage(WebDriver driver) {
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

    public WebElement getProduct(String title) throws Exception {
        for (WebElement productContainer : products) {
            if (getProductTitle(productContainer).getText().equals(title)) {
                return productContainer;
            }
        }
        throw new Exception("No se ha podido encontrar el producto '" + title + "'");
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
        return getPriceWithoutDolar(productContainer
                                        .findElement(By.xpath(".//div[@class='inventory_item_price']"))
                                        .getText());
    }

    public void removeProductFromCart(String title) throws Exception {
        removeProductFromCart(getProduct(title));
    }
    public void removeProductFromCart(WebElement productContainer) {
        WebElement button = getButton(productContainer);
        if (button.getText().trim().equalsIgnoreCase("Remove"))
            button.click();
    }

    public void cancelPurchase() {
        cancelButton.click();
    }

    public void finishCheckout() {
        finishCheckoutButton.click();
    }


    public Double getItemsTotalPriceByElements() {
        Double totalPrice = 0d;
        for (WebElement product : products)
            totalPrice += getProductPrice(product) * getProductQuantity(product);
        return totalPrice;
    }
    public Double getItemsTotalPriceByPage() {
        return getPriceWithoutDolar(itemTotal.getText());
    }
    public Double getTotalPrice() {
        return getPriceWithoutDolar(totalPrice.getText());
    }
    public Double getTax() {
        return getPriceWithoutDolar(tax.getText());
    }
    private double getPriceWithoutDolar(String priceStr) {
        return Double.parseDouble(priceStr.substring(priceStr.indexOf("$") + 1));
    }
    public String getPaymentInfo() {
        return paymentInfo.getText();
    }
    public String getShippingInfo() {
        return shippingInfo.getText();
    }
}
