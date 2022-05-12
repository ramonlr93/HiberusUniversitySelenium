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

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarritoSuite {

    public static WebDriver driver;

    @Before
    public void setUp(){
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testEliminarProducto() throws InterruptedException
    {
        boolean isProductDeleted;
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();


        try {
            isProductDeleted = driver.findElement(By.xpath("//div[text()= 'Sauce Labs Backpack']")).isDisplayed();
        }
        catch(NoSuchElementException exception1) {
            isProductDeleted = false;
        }

        Assert.assertFalse("PRUEBA FALLIDA, EL ELEMENTO NO SE HA ELIMINADO DEL CARRITO", isProductDeleted);
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
