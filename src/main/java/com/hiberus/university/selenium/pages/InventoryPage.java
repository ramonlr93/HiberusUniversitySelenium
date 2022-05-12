package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends AbstractPage{
    InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
}
