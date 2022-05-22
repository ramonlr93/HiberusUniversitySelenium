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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartSuiteTest {
    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);

        PagesFactory.start(driver);  //Cargar paginas de la factoria
        driver.get(LoginPage.PAGE_URL);  // Paso 1
    }

    @Test
    public void testEliminarDesdeCarrito() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getRandomAndClick(2, "add");  //Paso 5
        inventoryPage.clickOnShoppingCart(); //Paso 6

        //Cart
        CartPage cartPage = pf.getCartPage();
        List<String> itemNames = cartPage.getItemsName();
        String itemNameRemove = itemNames.get(0);

        //Inventory
        inventoryPage.getButtonByName(itemNameRemove, "remove");  //Paso 7

        Assert.assertFalse("PRUEBA FALLIDA - El producto seleccionado no se ha eliminado",
                cartPage.itemPresentToCartByName(itemNameRemove));  //Paso 8

    }

    @After
    public void tearDown() {
        driver.close();
    }

}
