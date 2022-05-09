package com.hiberus.university.selenium.carrito;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CarritoSuiteTest {
    public static WebDriver driver;

    @Before
    public void tearUp() {
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void EliminarProducto() {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket")).click();

        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

        driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();

        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();

        String numeroCarrito   ;

        try {
            numeroCarrito = driver.findElement(By.xpath("//a[@class ='shopping_cart_link']")).getText();
        } catch (NoSuchElementException e) {
            numeroCarrito = "1";
        }

        Assert.assertEquals("PRUEBA FALLIDA: no se ha eliminado el producto", "1", numeroCarrito);

    }


    @After
    public void tearDown() {
        driver.quit();
    }

}