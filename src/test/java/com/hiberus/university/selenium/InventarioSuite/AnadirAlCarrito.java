package com.hiberus.university.selenium.InventarioSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnadirAlCarrito {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {

        setUpDriver();
        wait = new WebDriverWait(driver, 10, 500);
        authenticateSauceDemo();

    }

    @Test
    public void TestAnadirUnProductoAlCarrito() throws InterruptedException {
        //Paso 5. Añadir al carrito el producto Sauce Labs Bolt T-Shirt
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))));
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        } catch (NoSuchElementException e) {
        }

        //Paso 6. Validar que el carrito tiene 1 articulo
        WebElement carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        String articulosCarrito = carrito.getText();
        String articulosEsperado = "1";
        Assert.assertEquals("En el icono carrito NO añadido 1 producto ", articulosEsperado, articulosCarrito);

    }

    @Test
    public void TestAnadir3ProductosAlCarrito() throws InterruptedException {
        //Paso 5. Añadir al carrito el producto Sauce Labs Bolt T-Shirt
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        //Paso 6. Validar que el carrito tiene 1 articulo
        WebElement carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        String articulosCarrito = carrito.getText();
        String articulosEsperado = "3";
        Assert.assertEquals("En el icono carrito NO añadido 3 producto ", articulosEsperado, articulosCarrito);

    }

    @After
    public void TearDown() {
        driver.close();
    }

    private void setUpDriver() {
        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void authenticateSauceDemo() {
        //Paso1. Ir a la página Sauce
        String urlSauce = "https://www.saucedemo.com/";
        driver.get(urlSauce);

        //Paso 2. Escribir username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Paso 3. Escribir password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4. Pulsar boton login
        driver.findElement(By.id("login-button")).click();
    }

}
