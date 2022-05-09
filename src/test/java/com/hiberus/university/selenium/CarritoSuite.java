package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarritoSuite {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\ander\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @Test
    public void testIncrementarCarrito() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        String valorCarrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals("PRUEBA FALLADA-No se ha incrementado el carrito",
                "1", valorCarrito);
    }

    @Test
    public void testBorrarProductoCarrito() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        boolean verdadero;
        try{
            verdadero = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Bolt T-Shirt')]")).isDisplayed();
        }catch(Exception exception){
            verdadero = false;
        }
        Assert.assertFalse("PRUEBA FALLADA-El objeto Sauce Labs Bolt T-Shirt aparece en el inventario"
                , verdadero);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}