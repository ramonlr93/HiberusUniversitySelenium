package com.hiberus.university.selenium.model;

import org.openqa.selenium.WebElement;

public abstract class Product {
    protected final WebElement name;
    protected final double price;

    protected Product(WebElement name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name.getText();
    }

    public double getPrice() {
        return price;
    }

    public void goDetails() {
        name.click();
    }
}
