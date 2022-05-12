package com.hiberus.university.selenium;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static com.hiberus.university.selenium.utils.Constants.*;
import static com.hiberus.university.selenium.utils.Methods.initDriver;
import static org.junit.Assert.*;

public class inventorySuiteTest {
    PagesFactory pf;
    InventoryPage inventoryPage;

    @Before
    public void setUp() {
        pf = PagesFactory.start(initDriver(LoginPage.PAGE_URL));
        inventoryPage = pf.getInventoryPage();
        pf.getLoginPage().doLogin(USERNAME, PASSWORD);
    }

    @Test
    public void validateNumberProducts() {
        assertEquals("PRUEBA FALLIDA: el número de productos no es el correcto", 6, inventoryPage.getNumberProducts());
    }

    @Test
    public void selectTShirtBolt() throws Exception {
        assertTrue("PRUEBA FALLIDA: no se muestra la Sauce Labs Bolt T-Shirt", inventoryPage.isProductDisplayed("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    public void addProductToCart() throws Exception {
        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");

        assertEquals("PRUEBA FALLIDA: no se ha añadido el producto al carrito", 1, inventoryPage.getNumberProductsCart());
    }

    @Test
    public void removeProductFromCart() throws Exception {
        String productTitle = "Sauce Labs Onesie";

        inventoryPage.addProductToCart(productTitle);
        inventoryPage.removeProductFromCart(productTitle);

        assertEquals("PRUEBA FALLIDA: no se ha eliminado el producto del carrito", 0, inventoryPage.getNumberProductsCart());
    }

    @Test
    public void orderAZ() {
        inventoryPage.filterBy("az");

        List<String> productsTitles = inventoryPage.getProductsTitles();
        List<String> productsTitlesSorted = inventoryPage.getProductsTitles();
        Collections.sort(productsTitlesSorted);

        assertArrayEquals("PRUEBA FALLIDA: no esta ordenado de manera correcta", productsTitlesSorted.toArray(), productsTitles.toArray());
    }

    @Test
    public void orderPriceHiLo() {
        inventoryPage.filterBy("hilo");

        List<Double> productsPrices = inventoryPage.getProductsPrices();
        List<Double> productsPricesSorted = inventoryPage.getProductsPrices();
        Collections.sort(productsPricesSorted, Collections.reverseOrder());

        assertArrayEquals("PRUEBA FALLIDA: no esta ordenado de manera correcta", productsPricesSorted.toArray(), productsPrices.toArray());
    }

    @Test
    public void orderPriceLoHi() {
        inventoryPage.filterBy("lohi");

        List<Double> productsPrices = inventoryPage.getProductsPrices();
        List<Double> productsPricesSorted = inventoryPage.getProductsPrices();
        Collections.sort(productsPricesSorted);

        assertArrayEquals("PRUEBA FALLIDA: no esta ordenado de manera correcta", productsPricesSorted.toArray(), productsPrices.toArray());
    }

    @After
    public void tearDown() {
        pf.getDriver().close();
    }
}
