package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory { // Factoría de páginas que vamos a tener, lo usamos para la implementacion? del resto de páginas

    private static PagesFactory pagesFactories; // Aquí meteremos las páginas que definamos
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;
    private final CartPage cartPage;
    private final CheckoutStepOnePage checkoutStepOnePage;
    private final CheckoutStepTwoPage checkoutStepTwoPage;

    private final CheckoutCompletePage checkoutCompletePage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    public static void start (WebDriver driver) { // Inicializa el pagefactory
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() { // Con esto obtendremos todas las páginas y será necesario hacer uhn start (método anterior) para que se ionicialicen las páginas, para tener disponibles todos los elemetnos y métodos de cada página
        return pagesFactories;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
