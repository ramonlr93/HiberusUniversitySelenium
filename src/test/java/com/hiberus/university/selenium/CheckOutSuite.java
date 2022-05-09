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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckOutSuite {
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
    public void testComprobarPrecioFinal() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Primero");
        driver.findElement(By.id("last-name")).sendKeys("Segundo");
        driver.findElement(By.id("postal-code")).sendKeys("00000");
        driver.findElement(By.id("continue")).click();
        String precio = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText().substring(13);
        List<WebElement> listaPrecios = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Double precioSumado = 0.00;
        for(int i = 0; i < 3; i++){
            precioSumado += (Double.valueOf(listaPrecios.get(i).getText().substring(1)));
        }
        Double precioTotal = Double.valueOf(precio);
        Assert.assertEquals("PRUEBA FALLADA-El precio final no corresponde con la suma de los precios de los productos",
                precioSumado, precioTotal);
    }

    @Test
    public void testRealizarPedido() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Primero");
        driver.findElement(By.id("last-name")).sendKeys("Segundo");
        driver.findElement(By.id("postal-code")).sendKeys("00000");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        String texto = driver.findElement(By.xpath("//div[@class='complete-text']")).getText();
        String textoEsperado = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals("PRUEBA FALLADA-No se ha realizado el pedido",
                textoEsperado, texto);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}