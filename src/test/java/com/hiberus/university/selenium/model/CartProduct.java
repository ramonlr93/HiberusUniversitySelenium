package com.hiberus.university.selenium.model;

import org.openqa.selenium.WebElement;

public class CartProduct extends Product {
    private final int quantity;
    private final WebElement deleteFromCart;

    public CartProduct(WebElement name, double price, int addCartButton, WebElement deleteFromCart) {
        super(name, price);
        this.quantity = addCartButton;
        this.deleteFromCart = deleteFromCart;
    }

    @Override
    public double getPrice() {
        return price / quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void deleteFromCart() {
        deleteFromCart.click();
    }
}
