package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final LoginPage loginPage;

    private final InventoryPage inventoryPage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
    }

    public static void start(WebDriver driver) {
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return pagesFactories;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
