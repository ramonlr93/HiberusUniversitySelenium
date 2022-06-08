package com.hiberus.university.selenium.model;

import org.openqa.selenium.WebElement;

public class InventoryProduct extends Product{
    private final WebElement addCartButton;

    public InventoryProduct(WebElement name, double price, WebElement addCartButton) {
        super(name, price);
        this.addCartButton = addCartButton;
    }

    public void addCart()  {
        addCartButton.click();
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) { }
    }
}
