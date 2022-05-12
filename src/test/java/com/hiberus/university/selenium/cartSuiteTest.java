package com.hiberus.university.selenium;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.hiberus.university.selenium.utils.Constants.PASSWORD;
import static com.hiberus.university.selenium.utils.Constants.USERNAME;
import static com.hiberus.university.selenium.utils.Methods.initDriver;
import static org.junit.Assert.assertEquals;

public class cartSuiteTest {
    PagesFactory pf;

    @Before
    public void setUp() {
        pf = PagesFactory.start(initDriver(LoginPage.PAGE_URL));
        pf.getLoginPage().doLogin(USERNAME, PASSWORD);
    }
    @Test
    public void deleteItemFromCart() {
        InventoryPage inventoryPage = pf.getInventoryPage();

        inventoryPage.addRandomProductsCart(2);
        inventoryPage.goCart();

        CartPage cartPage = pf.getCartPage();

        cartPage.removeRandomProducs(1);

        assertEquals("PRUEBA FALLIDA: no se han eliminado correctamente los productos del carrito", 1, cartPage.getProductsOnCart());
    }

    @After
    public void tearDown() {
        pf.getDriver().close();
    }
}
