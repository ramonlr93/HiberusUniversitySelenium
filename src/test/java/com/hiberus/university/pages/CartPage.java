package com.hiberus.university.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/cart";

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=checkout/checkout']")
    WebElement checkoutButton;

    CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickCheckout(){
        checkoutButton.click();
    }
}
