package com.hiberus.university.selenium.carrito;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarritoTestSuite {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void eliminarProductoDentroDeCarrito(){
        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        botonLogin.click();
        List<WebElement> botonesAddCart =driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int i=0;i<2;i++){
            botonesAddCart.get(i).click();
        }
        WebElement carritoCompraBtn = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        carritoCompraBtn.click();
        List<WebElement> botonesEliminarCarrito =  driver.findElements(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']"));
        botonesEliminarCarrito.get(0).click();
        List<WebElement> carritoCompra = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*"));
        Assert.assertEquals("El test ha fallado",carritoCompra.size(),1);

    }
    @After
    public void quitDriver(){
        driver.quit();
    }
}
