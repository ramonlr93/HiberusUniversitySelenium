package com.hiberus.university.selenium.logOut;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogOutTestSuite {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void comprobarLogOut(){
        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        botonLogin.click();

        WebElement menuIzquierda = driver.findElement(By.id("react-burger-menu-btn"));
        menuIzquierda.click();

        WebElement logOutBtn = driver.findElement(By.id("logout_sidebar_link"));
        logOutBtn.click();

        String urlActual = driver.getCurrentUrl();
        String urlComprobacion = "https://www.saucedemo.com/";
        Assert.assertEquals("Testfallido, no sonn el mismo precio",urlActual,urlComprobacion);

    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}
