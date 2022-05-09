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


public class EliminarProductosCarrito {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        setUpDriver();
        wait = new WebDriverWait(driver, 10, 500);
        authenticateSauceDemo();
    }

    @Test
    public void TestEliminarProductoCarrito() throws InterruptedException {
        //Paso 5. Añadir y eliminar del carrito el producto Sauce Labs Bolt T-Shirt
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")))).click();

        //Paso 6. Validar que el carrito esta vacio
        boolean isCarritoDisplayed;
        try {
            driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed();
        } catch (NoSuchElementException e) {
            isCarritoDisplayed = false;
        }
        String articulosCarrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        String articulosEsperado = "";
        Assert.assertEquals("El carrito tiene articulos añadidos", articulosEsperado, articulosCarrito);
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
