package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckOutSuccessPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    CheckOutSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
}
