package com.hiberus.university.selenium.pages;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class CheckoutCompletePage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";

    @FindBy(id = "back-to-products")
    private WebElement backToProductsBtn;

    CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    protected void clickBackToProductsBtn() {
        backToProductsBtn.click();
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
}