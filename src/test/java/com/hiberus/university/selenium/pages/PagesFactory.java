package com.hiberus.university.selenium.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
//Clase para gestionar las distintas paginas
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;

    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;
    //private final InventoryItemPage inventoryItemPage;
    private final CartPage cartPage;
    private final CheckOutStepOnePage checkOutStepOnePage;
    private final CheckOutStepTwoPage checkOutStepTwoPage;
    private final CheckOutCompletePage checkOutCompletePage;



    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        //inventoryItemPage = new InventoryItemPage(driver);
        cartPage = new CartPage(driver);
        checkOutStepOnePage = new CheckOutStepOnePage(driver);
        checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);

    }

    public static void start(WebDriver driver) {
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return pagesFactories;
    }

   //Getters
    public WebDriver getDriver() {
        return driver;
    }
}
