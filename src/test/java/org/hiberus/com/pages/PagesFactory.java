package org.hiberus.com.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory {
    private static PagesFactory pagesFactories;
    private final WebDriver driver;

    private final HomePage homePage;
    private final LoginPage loginPage;
    private final RegisterPage registerPage;

    private final SuccessAcountPage successAcountPage;

    private final StorePage storePage;

    private final ProductPage productPage;

    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    private final OrderPlacedPage orderPlacedPage;


    private PagesFactory(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        successAcountPage = new SuccessAcountPage(driver);
        storePage = new StorePage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderPlacedPage = new OrderPlacedPage(driver);
        cartPage = new CartPage(driver);
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

    public HomePage getHomePage() {return  homePage; }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public StorePage getStorePage() {
        return storePage;
    }

    public ProductPage getProductPage() {return productPage; }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }

    public OrderPlacedPage getOrderPlacedPage() {return orderPlacedPage; }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public SuccessAcountPage getSuccessAcountPage() {return successAcountPage; }

    public CartPage getCartPage() {
        return cartPage;
    }
}
