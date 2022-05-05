package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import javax.xml.datatype.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class InventarioSuite {
    /**
     * Rigorous Test :-)
     */
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Random dado = new Random();

    @Before
    public void tearUp() {
        // 1
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5, 500);
    }

    @Test
    public void testNumeroItems() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        List<WebElement> items;

        items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='inventory_item']"))));

        Assert.assertEquals("LA PRUEBA A FALLADO PORQUE EL NUMERO DE ITEMS NO ES 6", 6, items.size());
    }

    @Test
    public void testExisteProductoSauce() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");


        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        boolean existe = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")))).isDisplayed();
        Thread.sleep(2000);
        Assert.assertTrue("EL PRODUCTO Sauce Labs Bolt T-Shirt NO ESTA EN EL INVENTARIO", existe);
    }

    @Test
    public void testAddProductoSauce() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();


        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")))).click();
        } catch (NoSuchElementException e) {

        }
        String numCarro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))).getText();
        Assert.assertEquals("EL PRODUCTO Sauce Labs Bolt T-Shirt NO SE HA AÑADIDO AL CARRO", "1", numCarro);
        Thread.sleep(2000);
    }

    @Test
    public void testRemoveProductoSauce() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        boolean existe;
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")))).click();
            Thread.sleep(1000);
            existe = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))).isDisplayed();
        } catch (NoSuchElementException e) {
            existe = false;
        }

        Thread.sleep(2000);
        Assert.assertFalse("EL PRODUCTO Sauce Labs Bolt T-Shirt NO SE HA ELIMINADO AL CARRO", existe);
    }

    @Test
    public void testAddProductosSauce() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        int i = 0;
        while (i != 3) {
            Thread.sleep(1000);
            List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='inventory_list']/descendant::button[text()='Add to cart']"))));
            items.get(dado.nextInt(items.size())).click();
            i++;
        }
        String numCarro;
        try {
            numCarro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))).getText();
        } catch (NoSuchElementException e) {
            numCarro = "";
        }
        Assert.assertEquals("EL PRODUCTO Sauce Labs Bolt T-Shirt NO SE HA AÑADIDO AL CARRO", "3", numCarro);
    }

    @Test
    public void testOrdenZASauce() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//option[@value='za']")))).click();


    }

    @After
    public void tearDawn() {
        driver.quit();
    }
}
