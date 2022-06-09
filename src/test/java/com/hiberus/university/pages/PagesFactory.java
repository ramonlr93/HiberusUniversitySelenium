package com.hiberus.university.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final RegisterPage registerPage;
    private final LoginPage loginPage;
    private final AccountPage accountPage;
    private final LaptopsInventoryPage homePage;
    private final CheckoutPage checkoutPage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;


        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        homePage = new LaptopsInventoryPage(driver);
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

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public AccountPage getAccountPage() {
        return accountPage;
    }

    public LaptopsInventoryPage getLaptopsInventoryPage() {
        return homePage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }
}