package com.hiberus.university.selenium.carrito;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
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
    public void removeCartProductTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        CartPage cartPage = pf.getCartPage();
        inventoryPage.clickOnRandomProduct(2);
        inventoryPage.clickOnShoppingCart();
        cartPage.deleteCarItemtByPosition(0);
        Assert.assertFalse("EL PRODUCTO QUE SE DESEABA ELIMINAR, SE HA ELIMINADO DEL CARRITO", cartPage.cartItemByName().get(0).isEmpty());

    }

    @After
    public void tearDown() {
        driver.close();
    }

}