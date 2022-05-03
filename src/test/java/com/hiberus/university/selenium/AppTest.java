package com.hiberus.university.selenium;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    public static WebDriver driver;

    @Before
    public void tearUp() {
        // 1
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");


        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");


        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        Assert.assertEquals("LA PRUEBA ES FALLIDA PORQUE NO ESTAMOS EN LA URL QUE DEBERIAMOS ESTAR", "https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void testLoginIncorrect() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");


        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_use");


        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        Assert.assertTrue("LA PRUEBA A FALLADO PORQUE NO HA SALIDO EL MENSAJE DE ERROR", driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
    }

    @Test
    public void testNumberoInventoryItems() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");


        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_use");


        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        Assert.assertEquals("LA PRUEBA A FALLADO PORQUE EL NUMERO DE ITEMS NO ES 6", 6,driver.findElements(By.xpath("//div[@class='inventory_item']")).size());
    }

    @After
    public void tearDawn() {
        driver.quit();
    }
}
