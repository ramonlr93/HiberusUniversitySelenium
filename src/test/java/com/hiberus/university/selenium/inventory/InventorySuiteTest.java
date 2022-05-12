package com.hiberus.university.selenium.inventory;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.StringUtils;
import org.jsoup.internal.StringUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InventorySuiteTest {

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
    public void addItemTest() {
        String itemName = "Sauce Labs Backpack";

        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName(itemName);

        Assert.assertEquals("PRODUCTO NO AÑADIDO", 1, Integer.parseInt(inventoryPage.getShoppingCartNumber()));
    }

    @Test
    public void removeItemTest() {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.removeItemFromCart("Sauce Labs Backpack");

        Assert.assertEquals("PRODUCTO NO AÑADIDO", "", inventoryPage.getShoppingCartNumber());
        Assert.assertTrue("PRODUCTO NO AÑADIDO", StringUtils.isBlank(inventoryPage.getShoppingCartNumber()));
    }

    @Test
    public void sortFromAtoZ() {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertTrue("NO SE HA ORDENADO DE A - Z", inventoryPage.sortFromAToZ());
    }

    @Test
    public void sortFromZtoA() {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertTrue("NO SE HA ORDENADO DE Z - A", inventoryPage.sortFromZToA());
    }

    @Test
    public void sortFromHigherToLower() {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertTrue("NO SE HA ORDENADO DE H - L", inventoryPage.sortFromHiToLo());
    }

    @Test
    public void sortFromLowerToHigher() {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertTrue("NO SE HA ORDENADO DE L - H", inventoryPage.sortFromLoToHi());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
