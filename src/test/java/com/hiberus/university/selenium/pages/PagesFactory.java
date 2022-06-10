package com.hiberus.university.selenium.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;

    private final RegisterPage registerPage;
    private final RegisterSuccessPage registerSuccessPage;
    private final LoginPage loginPage;
    private final MyAccountPage myAccountPage;
    private final ForgottenPasswordPage forgottenPasswordPage;
    private final InventoryPage inventoryPage;
    private final InventoryItemPage inventoryItemPage;
    private final CheckOutPage checkOutPage;
    private final CheckOutSuccessPage checkOutSuccessPage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        registerPage = new RegisterPage(driver);
        registerSuccessPage = new RegisterSuccessPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        forgottenPasswordPage = new ForgottenPasswordPage(driver);
        inventoryPage = new InventoryPage(driver);
        inventoryItemPage = new InventoryItemPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkOutSuccessPage = new CheckOutSuccessPage(driver);
    }

    public static void start(WebDriver driver) {
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return pagesFactories;
    }
}
