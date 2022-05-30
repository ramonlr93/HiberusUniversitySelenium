package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends AbstractPage {

    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";

    @FindBy(className = "complete-text")
    private WebElement message;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return message;
    }

    public String getMessage(){
        return message.getText();
    }

}
