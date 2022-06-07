package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class InventoryPage extends AbstractPage{
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=product/category&path=24";

    @FindBy(id = "cart")
    private WebElement cartButton;

    @FindBy(xpath = "//button[contains(@onclick, 'cart.add')]")
    private List<WebElement> addToCartButtonList;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement addedItemMessage;

    @FindBy(xpath = "//span[@id='cart-total']")
    private WebElement getCartCount;

    @FindBy(xpath = "//button[@class='btn btn-danger btn-xs']")
    private WebElement deleteItemButton;

    InventoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return cartButton;
    }

    public void clickOnCart(){
        cartButton.click();
    }

    public void addItemToCart(String number){

        List<WebElement> lista = getDriver().findElements(By.xpath("//button[contains(@onclick, 'cart.add')]"));
        Collections.shuffle(lista);
        int quantity = Integer.parseInt(number);

        for (int i=0; i<quantity; i++){
            lista.get(i).click();
        }
    }

    public void addedItemMessage(){
        addedItemMessage.isDisplayed();
    }

    public int getCartCount(){
        String cartCount = getCartCount.getText();
        int currentCartcount = Integer.parseInt(cartCount.substring(0, 1));

        return currentCartcount;
    }

    public void removeItemFromCart(){
        cartButton.click();
        deleteItemButton.click();
    }
}
