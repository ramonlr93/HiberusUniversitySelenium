package com.hiberus.university.selenium.logout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LogoutTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Random dado = new Random();

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 5, 500);
    }

    @Test
    public void checkLogoutTest() {
        // 1
        driver.get("https://www.saucedemo.com/");
        String expectedURL = driver.getCurrentUrl();
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        driver.findElement(By.id("react-burger-menu-btn")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logout_sidebar_link")))).click();
        // 6
        Assert.assertEquals("ERROR EL LOGOUT NO SE HA REALIZADO CORRECTAMENTE.",expectedURL,driver.getCurrentUrl());
    }

    @After
    public void tearDawn() {
        driver.quit();
    }
}
