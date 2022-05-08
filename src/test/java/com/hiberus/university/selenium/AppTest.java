package com.hiberus.university.selenium;

import static com.hiberus.university.selenium.login.RealizarLogin.driver;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp(){
        // paso 0
        String userProfile = "C:\\Users\\pepet\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-none")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }



    //----------------
    @Test
    public void testArraysEquals() throws InterruptedException {
        String[] nombresEsperados = {"Manuel", "M"};
        String[] nombresActuales = {"Manuel", "Manolo"};

        Assert.assertArrayEquals("Fallo No son Los mismos Arrays ", nombresEsperados, nombresActuales);

    }
    @Test
    public void testEquals() throws InterruptedException {
        //(1+1) es el valor esperado y 1 es actual
        Assert.assertEquals("FALLO: no son los mismo valores", (1+1),1);

    }
    @Test
    public void testFalse() throws InterruptedException {
        Boolean input = true;
        Assert.assertFalse("Fallo: no son el mismo valor", input);
        Assert.assertTrue("asfasdf",input);

    }
//Ejercicio 1 selenium Junit

    @Test
    public void pruebaLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret.sauce");
        driver.findElement(By.id("login-button")).click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals("El loguin es fallido porque no estamos en la URL qu enos pide los requisitos", "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testLoginIncorrect() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard");
        driver.findElement(By.id("password")).sendKeys("secret.sauce");
        driver.findElement(By.id("login-button")).click();
    }


}
