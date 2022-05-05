package com.hiberus.university.selenium.logout;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogOutSuite {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void comprobarLogOut() {
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
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        Assert.assertEquals("No se hizo logout","https://www.saucedemo.com/",driver.getCurrentUrl());

    }

    @After
    public void clsoeDriver() {
        driver.close();
    }
}
