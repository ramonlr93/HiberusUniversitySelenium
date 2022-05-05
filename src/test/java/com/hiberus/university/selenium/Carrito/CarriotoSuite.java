package com.hiberus.university.selenium.Carrito;

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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class CarriotoSuite
{
    /**
     * Rigorous Test :-)
     */

    //Las variables que se usarán en varias pruebas deberán ser static
    public static WebDriver driver;
    public static String username;
    public static String password;
    public static WebDriverWait wait;


    @Before
    public void setUp(){

        username = "standard_user";
        password = "secret_sauce";

        String userProfile = "C:\\Users\\candi\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //Cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); //Crear instancia para opciones de Chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options); //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //Maximiza la ventana

        wait = new WebDriverWait(driver, 10,500);
    }

    @Test
    public void borrarProductoCarrito(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //driver.findElement(By.className("shopping_cart_link")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("remove-sauce-labs-bike-light")))).click();

        boolean existe;
        try{
            driver.findElement(By.xpath("//div[@class = 'cart_item']/descendant:: div[text() = 'Sauce Labs Bike Light']"));
            existe = true;
        }catch (NoSuchElementException e){
            existe = false;
        }

        Assert.assertFalse("El producto no se ha eliminado.", existe);
    }

    

    @After
    public void testDown(){
        driver.quit();
    }
}