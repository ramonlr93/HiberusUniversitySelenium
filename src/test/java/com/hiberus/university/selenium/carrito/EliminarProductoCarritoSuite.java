package com.hiberus.university.selenium.carrito;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

//import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class EliminarProductoCarritoSuite {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void SetUp() {

        //Paso 0
        String userProfile = "C:\\Users\\usuario\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options);       //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();      //Maximiza la ventana

        wait = new WebDriverWait(driver, 10);

    }

    /**
     * Rigorous Test:-)
     */
    @Test
    public void testEliminarProducto() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@id='login-button']")).submit();
        Thread.sleep(2000);

        driver.findElements(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        WebElement clickButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        clickButton.click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        WebElement clickButton2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        clickButton2.click();

        driver.findElement(By.id("shopping_cart_container"));
        WebElement clickButton3 = driver.findElement(By.id("shopping_cart_container"));
        clickButton3.click();

        //driver.findElement(By.id("remove-sauce-labs-bike-light"));
        //WebElement clickButton4 = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        //clickButton4.click();

        boolean aparece;
        try {
            aparece = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).isDisplayed();
        } catch (NoSuchElementException e) {
            aparece = true;
        }

        Assert.assertFalse("EL PRODUCTO Sauce Labs Bike Light APARECE en el carrito", aparece);

    }






    }



