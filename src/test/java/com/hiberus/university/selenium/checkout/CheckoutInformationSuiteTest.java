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

public class CheckoutInformationSuiteTest {


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
    public void continueTest() {
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

        CheckoutInformationPage checkoutInformationPage = pf.getCheckoutInformationPage();
        checkoutInformationPage.enterFirstName("David");
        checkoutInformationPage.enterLastName("Herce");
        checkoutInformationPage.postalCodeInput("26580");
        checkoutInformationPage.clickContinue();

        Assert.assertEquals("CONTINUE FAILED", CheckoutOverviewPage.PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    public void errorTest() {
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

        CheckoutInformationPage checkoutInformationPage = pf.getCheckoutInformationPage();
        checkoutInformationPage.enterFirstName("David");
        checkoutInformationPage.enterLastName("Herce");
        checkoutInformationPage.clickContinue();

        Assert.assertTrue("NO APARECE EL ERROR", checkoutInformationPage.hasMessageError());
    }

    @Test
    public void cancelTest() {
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

        CheckoutInformationPage checkoutInformationPage = pf.getCheckoutInformationPage();
        checkoutInformationPage.clickCancel();
        Assert.assertEquals("CANCEL FAILED", CartPage.PAGE_URL, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
