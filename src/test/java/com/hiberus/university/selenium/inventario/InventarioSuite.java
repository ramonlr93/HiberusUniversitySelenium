package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class InventarioSuite {
    public static WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";

    @Before
    public void tearUp(){
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void testValidarNumeroResultados(){
        // Ir a la URL
        driver.get(URL);
        // Escribir username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // Validar que el número de productos mostrados es 6
        int len = driver.findElements(By.xpath("//div[@class='inventory_list']/child::div")).size();
        Assert.assertEquals( "PRUEBA FALLIDA, NUMERO DE ITEMS NO ES 6", 6, len);
    }

    @Test
    public void testExisteProducto(){
        // Ir a la URL
        driver.get(URL);
        // Introducir username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Introducir password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // Añadir producto
        driver.findElement(By.xpath("//div[text() = 'Sauce Labs Bolt T-Shirt']")).click();
        // Comprobar que el botón ha cambiado y ahora es remove
        boolean existeProducto = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Bolt T-Shirt']")).isDisplayed();
        Assert.assertTrue("PRUEBA FALLIDA, EL ITEM NO EXISTE. ", existeProducto);
    }

    @Test
    public void testIncrementoValorCarrito(){
        // Ir a la página
        driver.get(URL);
        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        // Validamos que en el icono se a agregado el valor 1
        String numeroDeElementos = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        Assert.assertEquals( "PRUEBA FALLIDA, NUMERO DE ITEMS EN EL CARRITO NO ES 1", "1", numeroDeElementos);
    }


    @Test
    public void testEliminarProductoCarrito(){
        // Ir a la URL
        driver.get(URL);
        // Escribir el username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar botón Login
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // Eliminar producto
        driver.findElement(By.xpath("//button[@name ='remove-sauce-labs-bolt-t-shirt']")).click();
        // Comprobación carrito
        String numeroDeElementos = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        Assert.assertEquals( "PRUEBA FALLIDA, HAY NUMERO DE ELEMENTOS EN EL CARRITO", "", numeroDeElementos);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
