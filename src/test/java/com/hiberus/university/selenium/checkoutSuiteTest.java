package com.hiberus.university.selenium;

import com.hiberus.university.selenium.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.hiberus.university.selenium.utils.Constants.PASSWORD;
import static com.hiberus.university.selenium.utils.Constants.USERNAME;
import static com.hiberus.university.selenium.utils.Methods.initDriver;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class checkoutSuiteTest {

    PagesFactory pf;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutOnePage checkoutOnePage;
    CheckoutTwoPage checkoutTwoPage;
    CheckoutComplete checkoutComplete;

    @Before
    public void setUp() {
        pf = PagesFactory.start(initDriver(LoginPage.PAGE_URL));
        inventoryPage = pf.getInventoryPage();
        cartPage = pf.getCartPage();
        checkoutOnePage = pf.getCheckoutOnePage();
        checkoutTwoPage = pf.getCheckoutTwoPage();
        checkoutComplete = pf.getCheckoutComplete();
        pf.getLoginPage().doLogin(USERNAME, PASSWORD);
    }
    @Test
    public void validateTotalProductsPrice() {
        inventoryPage.addRandomProductsCart(3);
        inventoryPage.goCart();

        Double productsTotalPrice = cartPage.getTotalPrice();
        cartPage.goCheckout();

        checkoutOnePage.fillInputsAndContinue("Prueba First Name", "Prueba Last Name", "Prueba Código Postal");

        // HACIENDO LA COMPROBACIÓN SI NOS GUARDAMOS LA VARIABLE DESDE EL CARRITO
        assertEquals("PRUEBA FALLIDA: el precio esta mal calculado", productsTotalPrice, checkoutTwoPage.getItemsTotalPriceByPage());

        // HACIENDO LA COMPROBACIÓN SI LO CALCULAMOS DIRECTAMENTE EN LA PÁGINA DEL CHECKOUT
        assertEquals("PRUEBA FALLIDA: el precio esta mal calculado", checkoutTwoPage.getItemsTotalPriceByElements(), checkoutTwoPage.getItemsTotalPriceByPage());
    }

    @Test
    public void makeOrder() {
        inventoryPage.addRandomProductsCart(3);
        inventoryPage.goCart();

        cartPage.goCheckout();

        checkoutOnePage.fillInputsAndContinue("Prueba First Name", "Prueba Last Name", "Prueba Código Postal");

        checkoutTwoPage.finishCheckout();

        assertEquals(
                "PRUEBA FALLIDA: No se ha finalizado correctamente la compra",
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                checkoutComplete.getCompletedOrderText()
        );
    }

    @After
    public void tearDown() {
        pf.getDriver().close();
    }
}
