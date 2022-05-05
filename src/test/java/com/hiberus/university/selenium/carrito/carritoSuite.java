package com.hiberus.university.selenium.carrito;

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

import java.util.List;

public class carritoSuite {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private static final String URL = "https://www.saucedemo.com/";

    @Before
    public void tearUp(){
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void testEliminaProductoDesdeCarrito(){

        Boolean productoEliminado;

        // Ir a la página
        driver.get(URL);
        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        // Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-backpack']")).click();
        // Vamos al carrito
        driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();

        // Elimino un producto
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        try{
            productoEliminado = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']")).isDisplayed();
        } catch (NoSuchElementException n) {
            productoEliminado = false;
        }

        // Validamos que en el icono se ha eliminado
        Assert.assertFalse( "PRUEBA FALLIDA, NUMERO DE ITEMS EN EL CARRITO NO ES 1", productoEliminado);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
