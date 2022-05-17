package com.hiberus.university.selenium.inventario;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
@Slf4j
public class InventarioSuiteTest {
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
    public void resultadosTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();

        Assert.assertEquals("FALLIDO, NO MUESTRA 6 ELEMENTOS", 6, inventoryPage.getInventoryCount());

    }

    @Test
    public void existeProductoTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        InventoryPage inventoryPage = pf.getInventoryPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue("PRUEBA FALLIDA, EL ELEMENTO NO APARECE", inventoryPage.isDisplayedItemByName("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    public void anadirProductoTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String itemName = "Sauce Labs Backpack";
        log.info("The user added " + itemName + " by Add to cart");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName(itemName);

        inventoryPage.clickShoppingCart();

        CartPage cartPage = pf.getCartPage();
        int currentCount = cartPage.getItemCount();

        Assert.assertEquals(1, currentCount);
    }

    @Test
    public void eliminarProductoTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String itemName = "Sauce Labs Backpack";
        log.info("The user added " + itemName + " by Add to cart");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName(itemName);

        inventoryPage.removeItemToCartByName(itemName);

        inventoryPage.clickShoppingCart();

        CartPage cartPage = pf.getCartPage();
        int currentCount = cartPage.getItemCount();

        Assert.assertEquals(1, currentCount);
    }

    @Test
    public void testAnadirTres() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();

        int numItemsCart = inventoryPage.getThreeRandomItems();

        Assert.assertEquals("PRUEBA FALLIDA, NO SE HAN ANADIDO LOS 3 PRODUCTOS", 3, numItemsCart);
    }

    @Test
    public void ordenarAlfabeticamenteAZTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.selectOption("az");

        List<WebElement> inventoryList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResult = new ArrayList<>();
        List<String> nameInventoryResultSorted = new ArrayList<>();

        for (WebElement webElement : inventoryList) {
            nameInventoryResult.add(webElement.getText());
            nameInventoryResultSorted.add(webElement.getText());
        }

        Collections.sort(nameInventoryResultSorted);
        Assert.assertEquals("list is not sorted", nameInventoryResultSorted, nameInventoryResult);

    }

    @Test
    public void ordenarPrecioMenorMayorTest() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.selectOption("lohi");

        List<WebElement> inventoryList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResult = new ArrayList<>();
        List<String> nameInventoryResultSorted = new ArrayList<>();

        for (WebElement webElement : inventoryList) {
            nameInventoryResult.add(webElement.getText());
            nameInventoryResultSorted.add(webElement.getText());
        }

        Collections.sort(nameInventoryResultSorted);
        Assert.assertEquals("list is not sorted", nameInventoryResultSorted, nameInventoryResult);

    }

    @Test
    public void testOrdenarPrecioMayorMenor() throws InterruptedException
    {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.selectOption("hilo");

        List<WebElement> inventoryList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResult = new ArrayList<>();
        List<String> nameInventoryResultSorted = new ArrayList<>();

        for (WebElement webElement : inventoryList) {
            nameInventoryResult.add(webElement.getText());
            nameInventoryResultSorted.add(webElement.getText());
        }

        Collections.sort(nameInventoryResultSorted);
        Assert.assertEquals("list is not sorted", nameInventoryResultSorted, nameInventoryResult);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
