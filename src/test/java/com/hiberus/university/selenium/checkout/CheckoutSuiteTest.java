package com.hiberus.university.selenium.checkout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class CheckoutSuiteTest {
    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setupClass() {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,10,500);
    }

    @Test
    public void checkoutFinalPrice() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        //Agregar al carrito los 3 productos elegidos al azar.


        //Ir al carrito.
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //Realizar el Checkout del producto.
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        //Rellenar datos del checkout y continuar.
        String firstname = "John";
        String lastname = "Doe";
        int zipcode = 43003;

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(Integer.toString(zipcode));
        driver.findElement(By.xpath("//button[@id='continue']")).click();

        //Finalizar Checkout
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        //Validar que el precio total del pedido (Item total) es la suma del importe de los productos seleccionados en el inventario


    }

    @Test
    public void order() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        //Agregar al carrito 1 producto elegidoalidar que el precio total del pedido (Item total) es la suma del importe de los productos seleccionados en el inventario al azar.


        //Ir al carrito.
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //Realizar el Checkout del producto.
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        //Rellenar datos del checkout y continuar.
        String firstname = "John";
        String lastname = "Doe";
        int zipcode = 43003;

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(Integer.toString(zipcode));
        driver.findElement(By.xpath("//button[@id='continue']")).click();

        //Finalizar Checkout
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        //Validar que el pedido a finalizado correctamente mostrando el mensaje

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", "https://www.saucedemo.com/checkout-complete.html", currentUrl);


    }

    @After
    public void tearDom() {
        driver.quit();
    }

}
