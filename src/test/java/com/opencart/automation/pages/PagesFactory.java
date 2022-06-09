package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
    private static PagesFactory pagesFactories;
    private final WebDriver driver;

    private final LoginPage loginPage;
    private final RegisterPage registerPage;

    private final HomePage homePage;
    private final MyAccountPage myAccountPage;
    private final CheckoutPage checkoutPage;

    private final CamerasPage camerasPage;


    private PagesFactory(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        checkoutPage = new CheckoutPage(driver);
        camerasPage = new CamerasPage(driver);
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

    public LoginPage getLoginPage() {
        return loginPage;
    }


    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public MyAccountPage getMyAccountPage() {
        return myAccountPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }

    public CamerasPage getCameraPage() {

        return camerasPage;
    }
}
