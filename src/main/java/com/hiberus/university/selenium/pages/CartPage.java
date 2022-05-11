package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractPage {

    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    private List<WebElement> removeButtonList;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement openMenuButton;

    @FindBy(xpath = "//div[@class='cart_list']")
    private List<WebElement> itemList;


    CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public int getItemCount() {
        return itemList.size();

    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public void removeItems() {
        for(WebElement x: removeButtonList){
            x.click();
        }
    }
}
