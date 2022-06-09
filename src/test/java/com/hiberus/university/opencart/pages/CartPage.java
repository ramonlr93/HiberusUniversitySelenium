package com.hiberus.university.opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class CartPage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/cart";

    @FindBy(xpath = "//ul[@class='breadcrumb']/descendant::a[text()='Shopping Cart']")
    private WebElement shoppingCartLink;

    CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Override
    public WebElement getPageLoadedTestElement() {
        return shoppingCartLink;
    }
}