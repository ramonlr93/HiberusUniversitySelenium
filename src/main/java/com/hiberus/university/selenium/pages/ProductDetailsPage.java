package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(className = "inventory_details_container")
    private WebElement product;

    @FindBy(className = "back-to-products")
    private WebElement backToProductsButton;

    ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void backToProducts() {
        backToProductsButton.click();
    }

    public String getProductTitle() {
        return product.findElement(By.xpath(".//div[contains(@class, 'inventory_details_name')]")).getText();
    }

    public String getProductDescription() {
        return product.findElement(By.xpath(".//div[contains(@class, 'inventory_details_desc')]")).getText();
    }

    public Double getProductPrice() {
        return Double.parseDouble(
                product
                    .findElement(By.xpath(".//div[contains(@class, 'inventory_details_price')]"))
                    .getText()
                    .replace("$", "")
        );
    }

    private WebElement getButton() {
        return product.findElement(By.xpath(".//button"));
    }

    public void addProductToCart() {
        if (getButton().getText().equals("Add to cart"))
            getButton().click();
    }

    public void removeProductFromCart() {
        if (getButton().getText().equals("Remove"))
            getButton().click();
    }

}
