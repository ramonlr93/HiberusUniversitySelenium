package com.hiberus.university.selenium.carrito;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CarritoSuiteTest {

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
    public void eliminarProductoTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String itemName1 = "Sauce Labs Backpack";
        log.info("The user added " + itemName1 + " by Add to cart");
        String itemName2 = "" + "Sauce Labs Bolt T Shirt";
        log.info("The user added " + itemName2 + " by Add to cart");

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName(itemName1);
        inventoryPage.addItemToCartByName(itemName2);

        inventoryPage.clickShoppingCart();

        CartPage cartPage = pf.getCartPage();
        cartPage.deleteCartItemByName(itemName1);

        int currentCount = cartPage.getItemCount();
        Assert.assertEquals(1, currentCount);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
