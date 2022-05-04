package com.hiberus.university.selenium;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */

public class LoginSuite {
    /**
     * Rigorous Test :-)
     */
    public static WebDriver driver;

    @Before
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin()  {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals("La URL no es correcta", url, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testLoginFailed()  {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        boolean error;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_use");
        passwrod.sendKeys("secret_sauce");
        //3.- Hacer login''
        boton.click();
        error = driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed();
        Assert.assertTrue("El login no fallo correctamente", error);
    }

    @After
    public void clsoeDriver() {
        driver.close();
    }
}
