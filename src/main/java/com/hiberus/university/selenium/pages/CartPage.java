package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage extends AbstractPage {
    public static final String PAGE_UTL = "https://www.saucedemo.com/cart.html";

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    private List<WebElement> removeButtons;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[react-burger-menu-btn")
    private Select openMenu;

    @FindBy(className = "cart_list")
    private Select itemsList;

    CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return checkoutButton;
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public int getItemCount() {
        return removeButtons.size();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }
}
