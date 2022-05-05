package com.hiberus.university.selenium.checkout;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutSuite {

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
    public void comprobarPrecioFinalCheckout(){

        double totalPrecio = 0;

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
        // Agregar al carrito el producto Test.allTheThings() T-Shirt (Red)
        driver.findElement(By.xpath("//button[@name ='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        // Vamos al carrito
        driver.findElement(By.xpath("//a[@class ='shopping_cart_link']")).click();
        // Vamos al checkout
        driver.findElement(By.id("checkout")).click();
        // Escribimos datos
        driver.findElement(By.id("first-name")).sendKeys("David");
        driver.findElement(By.id("last-name")).sendKeys("Herce");
        driver.findElement(By.id("postal-code")).sendKeys("26580");
        // Hacemos click en continue
        driver.findElement(By.id("continue")).click();

        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'inventory_item_price']"));


        for(int i=0;i<items.size();i++){
            totalPrecio += (Double.parseDouble(items.get(i).getText().substring(1,6)));
        }

        String textoTotal = driver.findElement(By.xpath("//div[@class = 'summary_subtotal_label']")).getText();
        String webTotal = (textoTotal.substring(13, textoTotal.length()));

        // Validamos que el precio es igual
        Assert.assertEquals( "PRUEBA FALLIDA, EL PRECIO ES DIFERENTE", Double.toString(totalPrecio), webTotal);
    }

    @Test
    public void realizaUnPedido(){
        String mensajeASalir = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        // Ir a la página
        driver.get(URL);
        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));
        // Agregar al carrito el producto Test.allTheThings() T-Shirt (Red)
        driver.findElement(By.xpath("//button[@name ='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        // Vamos al carrito
        driver.findElement(By.xpath("//a[@class ='shopping_cart_link']")).click();
        // Vamos al checkout
        driver.findElement(By.id("checkout")).click();
        // Escribimos datos
        driver.findElement(By.id("first-name")).sendKeys("David");
        driver.findElement(By.id("last-name")).sendKeys("Herce");
        driver.findElement(By.id("postal-code")).sendKeys("26580");
        // Hacemos click en continue
        driver.findElement(By.id("continue")).click();
        // Hacemos click en finish
        driver.findElement(By.id("finish")).click();

        String mensaje = driver.findElement(By.xpath("//div[@class = 'complete-text']")).getText();

        // Validamos que se ha realizado correctamente
        Assert.assertEquals( "PRUEBA FALLIDA, EL MENSAJE ES DIFERENTE O NO EXISTE", mensajeASalir, mensaje);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
