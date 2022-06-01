package com.hiberus.university.selenium.inventario;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class InventarioSuiteTest {

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
    public void validateInventoryResultsTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertEquals("EL NUMERO DE ITEMS RESULTANTES EN EL INVENTARIO, NO ES EL CORRECTO.", 6, inventoryPage.getItemList().size());
    }

    @Test
    public void validateExistenceGivenProductTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertTrue("EL PRODUCTO 'Sauce Labs Bolt T-Shirt', NO APARECE EN EL LISTADO DE ITEMS DEL INVENTARIO ", inventoryPage.isItemContains("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    public void addCartProductTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA. ", 1, inventoryPage.productsQuantityInCart());
    }

    @Test
    public void removeInventoryCartProductTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName("Sauce Labs Bolt T-Shirt");
        inventoryPage.removeItemToCartByName("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA", 0, inventoryPage.productsQuantityInCart());
    }

    @Test
    public void addCartThreeProductTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.clickOnRandomProduct(3);
        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA", 3, inventoryPage.productsQuantityInCart());
    }

    @Test
    public void sortInventoryAlphabeticalOrderTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.selectOption("za");
        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", inventoryPage.sortedZtoAInventoryByname(), inventoryPage.getInventoryName());
    }

    @Test
    public void sortInventoryAlphabeticalPriceTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.selectOption("hilo");
        Assert.assertEquals("EL FILTRO 'Price (low to high)', NO FUNCIONA CORRECTAMENTE. ", inventoryPage.getProductPrice(), inventoryPage.sortedProductHighToLowPrice());
    }
    @After
    public void tearDown() {
        driver.close();
    }

}