package com.hiberus.university.selenium.checkout;

import com.hiberus.university.selenium.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckoutSuiteTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 500);
        PagesFactory.start(driver);

        driver.get(LoginPage.PAGE_URL);
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }


    @Test
    public void checkPriceProductsTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        CartPage cartPage = pf.getCartPage();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();
        inventoryPage.clickOnRandomProduct(3);
        inventoryPage.clickOnShoppingCart();
        cartPage.clickCheckout();
        checkOutStepOnePage.fillInformation("katherin", "Sanabria", "04009");
        checkOutStepOnePage.clickContinue();
        Assert.assertEquals("LA SUMA DE LOS PRECIOS DE LOS PRODUCTOS NO ES LA MISMA", checkOutStepTwoPage.cartItemPrice(), checkOutStepTwoPage.itemTotalByNumber());
    }


    @Test
    public void placeOrderTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        CartPage cartPage = pf.getCartPage();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();
        inventoryPage.clickOnRandomProduct(1);
        inventoryPage.clickOnShoppingCart();
        cartPage.clickCheckout();
        checkOutStepOnePage.fillInformation("katherin", "Sanabria", "04009");
        checkOutStepOnePage.clickContinue();
        checkOutStepTwoPage.clickFinish();
        Assert.assertEquals("EL MENSAJE FINAL DEL PEDIDO REALIZADO NO ES EL CORRECTO ",
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkOutStepTwoPage.getFinishMessage());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}