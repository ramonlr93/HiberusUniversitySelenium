package com.hiberus.university.opencart.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final HomePage homePage;
    private final LoginPage loginPage;
    private final AccountPage accountPage;
    private final RegisterPage registerPage;
    private final ForgottenPasswordPage forgottenPasswordPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;
    private final CheckoutSuccessPage checkoutSuccessPage;
    private final LogoutPage logoutPage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        registerPage = new RegisterPage(driver);
        forgottenPasswordPage = new ForgottenPasswordPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    public static void start(WebDriver driver) {
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return pagesFactories;
    }
}

