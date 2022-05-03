package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginSuite {
    public static WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";

    @Before
    public void tearUp(){
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin()
    {
        // Ir a la página
        driver.get(URL);
        // Escribir usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // Comprobar que la url en la que estamos es correcta
        Assert.assertEquals("EL LOGIN ES FALSO PORQUE NO ESTAMOS EN LA URL QUE NOS PIDE LOS REQUISITOS",
                "https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void testLoginIncorrect()
    {
        // Ir a la página
        driver.get(URL);
        // Escribir usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standarduser");
        // Escribir contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // Comprobar si existe el error
        Boolean visualizaError = driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed();
        Assert.assertTrue("PRUEBA FALLIDA, EL ELEMENTO DE ERROR NO APARECE. ", visualizaError);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
