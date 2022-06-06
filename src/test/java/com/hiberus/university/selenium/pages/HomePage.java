package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    public static final String HOME_PAGE_URL = "https://opencart.abstracta.us";

    @FindBy(xpath = "//div[contains(@class, 'product-thumb')]")
    private List<WebElement> products;

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return products.get(0);
    }
}
