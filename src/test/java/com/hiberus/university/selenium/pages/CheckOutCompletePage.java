package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";

    @FindBy(className = "complete-text")
    WebElement finalText;

    CheckOutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFinalText() {
        return finalText.getText();
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return finalText;
    }
}
