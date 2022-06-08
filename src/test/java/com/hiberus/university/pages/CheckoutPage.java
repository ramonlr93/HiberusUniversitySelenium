package com.hiberus.university.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends AbstractPage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
}
