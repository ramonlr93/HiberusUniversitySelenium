package com.hiberus.university.selenium.pages;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=product/category&path=20";


    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> inventoryNameList;

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void addItemToCartByName(String itemName) {
        getDriver().findElement(By.xpath("//a[text()='"+itemName+"']//ancestor::div[@class='product-thumb']//descendant::span[text()='Add to Cart']")).click();
    }

}


