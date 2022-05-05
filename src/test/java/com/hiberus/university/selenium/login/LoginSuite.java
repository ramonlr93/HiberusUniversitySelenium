package com.hiberus.university.selenium.login;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class LoginSuite {
    /**
     * Rigorous Test :-)
     */

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void tearUp() {
        // 1
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5,500);
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");


        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");


        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(2000);
        String urlActual = driver.getCurrentUrl();
        Assert.assertEquals("LA PRUEBA ES FALLIDA PORQUE NO ESTAMOS EN LA URL QUE DEBERIAMOS ESTAR", "https://www.saucedemo.com/inventory.html", urlActual);
    }

    @Test
    public void testLoginIncorrect() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");


        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_use");


        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(2000);

        boolean existe;
        try {
            existe = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@data-test='error']")))).isDisplayed();
        } catch (NoSuchElementException e) {
            existe = false;
        }
        Assert.assertTrue("LA PRUEBA A FALLADO PORQUE NO HA SALIDO EL MENSAJE DE ERROR", existe);
    }
    @Test
    public void testAddProductoSauce() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();


        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")))).click();
        } catch (NoSuchElementException e) {

        }
        Thread.sleep(2000);
        String numCarro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))).getText();
        Thread.sleep(2000);
        Assert.assertEquals("EL PRODUCTO Sauce Labs Bolt T-Shirt NO SE HA AÑADIDO AL CARRO", "1", numCarro);
    }

    @After
    public void tearDawn() {
        driver.quit();
    }
}
