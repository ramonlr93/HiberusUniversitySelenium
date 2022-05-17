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
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
        PagesFactory.start(driver);
        driver.get(LoginPage.PAGE_URL);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void comprobarPrecioFinalTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();

        inventoryPage.getThreeRandomItems();

        inventoryPage.clickShoppingCart();

        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();

        CheckOutStepOnePage checkoutOne = pf.getCheckOutStepOnePage();
        checkoutOne.fillInformation("Fulanito", "Fulanitez", "5555");
        checkoutOne.clickContinue();

        CheckOutStepTwoPage chechoutTwo = pf.getCheckOutStepTwoPage();
        chechoutTwo.getItemTotal();
    }

    @Test
    public void realizarPedidoTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();

        inventoryPage.getThreeRandomItems();

        inventoryPage.clickShoppingCart();

        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();

        CheckOutStepOnePage checkoutOne = pf.getCheckOutStepOnePage();
        checkoutOne.fillInformation("Fulanito", "Fulanitez", "5555");
        checkoutOne.clickContinue();

        CheckOutStepTwoPage chechoutTwo = pf.getCheckOutStepTwoPage();
        chechoutTwo.clickFinish();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}


