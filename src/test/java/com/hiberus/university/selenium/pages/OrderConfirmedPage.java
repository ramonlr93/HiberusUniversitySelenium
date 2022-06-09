package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmedPage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/success";
    @FindBy(xpath = "//href[contains(text(), 'my account')]")
    private WebElement myAccountLink;

    OrderConfirmedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

}