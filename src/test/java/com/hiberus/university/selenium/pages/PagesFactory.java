package com.hiberus.university.selenium.pages;

import lombok.Getter;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;
    private final CartPage cartPage;
    private final CheckoutInformationPage checkoutInformationPage;
    private final CheckoutOverviewPage checkoutOverviewPage;
    private final BasePage basePage;
    private final CheckoutCompletePage checkoutCompletePage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        basePage = new BasePage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    public static void start(WebDriver driver) {
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return pagesFactories;
    }


}
