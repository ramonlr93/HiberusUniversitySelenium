package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends PagesFactory{
    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(xpath = "//div[@class='cart-item']") // Se puede usar xpath, id, css...
    private List<WebElement> inventoryItems;

    @FindBy (id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy (id = "checkout")
    private WebElement checkoutButton;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickContinueShoppingButton () {
        continueShoppingButton.click();
    }

    public void clickCheckoutButton (){
        checkoutButton.click();
    }

    public void removeItem (String itemName){

        try {
            for (WebElement elm:inventoryItems){
                elm.findElement(By.xpath("//button[contains(@id='remove-"+itemName+"')]")).click();
            }
        } catch (NoSuchElementException e) {}
    }
}
