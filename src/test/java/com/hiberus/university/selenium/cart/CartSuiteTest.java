package com.hiberus.university.selenium.cart;

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

public class CartSuiteTest {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver


        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
        PagesFactory.start(driver);
        driver.get(LoginPage.PAGE_URL);
    }

    @Test
    public void goToCheckoutTest() {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.clickOnShoppingCart();

        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();

        Assert.assertEquals("GO TO CHECKOUT FAILED", CheckoutInformationPage.PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    public void checkProductAdded() {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.clickOnShoppingCart();

        CartPage cartPage = pf.getCartPage();

        // Comprobar que el producto es el mismo al añadido
        Assert.assertEquals("NO HAY UN PRODUCTO", 1, cartPage.getItemCount());
    }

    @Test
    public void removeItemTest(){
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.clickOnShoppingCart();

        CartPage cartPage = pf.getCartPage();
        cartPage.deleteCarItemByName("Sauce Labs Backpack");

        Assert.assertEquals("NO HAY UN PRODUCTO", 0, cartPage.getItemCount());
    }

    @Test
    public void continueShoppingTest() {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.clickOnShoppingCart();

        CartPage cartPage = pf.getCartPage();
        cartPage.continueShoppingButton();
        Assert.assertEquals("CONTINUE SHOPPING BUTTON FAILED", InventoryPage.PAGE_URL, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
