package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final HomePage homePage;
    private final RegisterPage registerPage;
    private final LoginPage loginPage;
    private final UserPage userPage;
    private final MainInventoryPage mainInventoryPage;
    private final MobileDevicesPage mobileDevicesPage;
    private final CheckoutPage checkoutPage;
    private final OrderConfirmedPage orderConfirmedPage;

    private PagesFactory(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        mainInventoryPage = new MainInventoryPage(driver);
        mobileDevicesPage = new MobileDevicesPage(driver);
        checkoutPage=new CheckoutPage(driver);
        orderConfirmedPage=new OrderConfirmedPage(driver);
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

    public HomePage getHomePage() {
        return homePage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public UserPage getUserPage() {
        return userPage;
    }
    public MainInventoryPage getMainInventoryPage() {
        return mainInventoryPage;
    }
    public MobileDevicesPage getMobileDevicesPage() {
        return mobileDevicesPage;
    }
    public CheckoutPage getCheckoutPage(){
        return checkoutPage;
    }
    public OrderConfirmedPage getOrderConfirmedPage(){
        return orderConfirmedPage;
    }
}

