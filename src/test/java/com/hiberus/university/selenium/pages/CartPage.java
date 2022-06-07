package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class CartPage extends AbstractPage{
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/cart";

    @FindBy(xpath = "//div[@class='pull-right']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='pull-left']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[contains(@onclick, 'cart.remove')]")
    private List<WebElement> removeFromCartItemButton;

    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    private List<WebElement> updateItemCartButton;

    @FindBy(xpath = "//input[contains(@name,\"quantity\")]")
    private List<WebElement> itemQuantityInput;

    CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return checkoutButton;
    }

    public void clickCheckout(){
        checkoutButton.click();
    }

    public void clickContinueShopping(){
        continueShoppingButton.click();
    }

    public void removeItemFromCart(){
        List<WebElement> lista = getDriver().findElements(By.xpath("//button[contains(@onclick, 'cart.remove')]"));
        Collections.shuffle(lista);

        for (int i=2; i<4; i++){
            lista.get(i).click();
        }
    }

    public void updateItemFromCart(){

    }

}
