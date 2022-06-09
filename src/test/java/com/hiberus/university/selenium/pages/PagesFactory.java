package com.hiberus.university.selenium.pages;


import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final RegisterPage registerPage;
    private final InventoryPage inventoryPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
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
