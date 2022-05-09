package com.hiberus.university.selenium.Carrito;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarritoSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp(){
        // Inicie un nuevo navegador Chrome ->
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void eliminarProductoCarrito(){
        driver.get("https://www.saucedemo.com");

        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        List<WebElement> buttonAddProducts =driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int i = 0; i < 2; i++){
            buttonAddProducts.get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElements(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']")).get(0).click();

        int sizeShoppingCart = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*")).size();

        Assert.assertEquals("PRUEBA FALLIDA - PRODUCTO NO ELIMINADO",1, sizeShoppingCart);
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

}
