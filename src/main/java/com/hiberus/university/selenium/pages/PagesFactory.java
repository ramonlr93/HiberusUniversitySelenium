package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PagesFactory
{
    private static ThreadLocal<PagesFactory> pagesFactories = new ThreadLocal<PagesFactory>();
    private WebDriver driver;

    private CheckOutStepOnePage checkOutStepOnePage;
    private CheckOutStepTwoPage checkOutStepTwoPage;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;
    private CartPage cartPage;

    public static void start(WebDriver driver)
    {
        PagesFactory instance = new PagesFactory(driver);
        pagesFactories.set(instance);
    }

    public static PagesFactory getInstance()
    {
        return pagesFactories.get();
    }

    private PagesFactory(WebDriver driver)
    {
        this.driver = driver;
        checkOutStepOnePage = new CheckOutStepOnePage(driver);
        checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public CheckOutStepOnePage getCheckOutStepOnePage()
    {
        return checkOutStepOnePage;
    }

    public CheckOutStepTwoPage getCheckOutStepTwoPage()
    {
        return checkOutStepTwoPage;
    }

    public InventoryPage getInventoryPage()
    {
        return inventoryPage;
    }

    public LoginPage getLoginPage()
    {
        return loginPage;
    }

    public CartPage getCartPage()
    {
        return cartPage;
    }
}
