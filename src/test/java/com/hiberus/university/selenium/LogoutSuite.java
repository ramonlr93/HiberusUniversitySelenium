package com.hiberus.university.selenium;

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

public class LogoutSuite
{
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\ander\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogout() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

                driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();


        //Validacion
        String url = driver.getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El logout es fallido porque no hemos accedido a la url indicada en los requisitos",
                "https://www.saucedemo.com/", url);
    }

    @Test
    public void testLoginIncorrecto() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

                driver.findElement(By.id("user-name")).sendKeys("standard_use");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        //Validacion
        boolean isMenssageErrorVisible = driver.findElement(
                By.xpath("//div[@class='error-message-container error']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA - El elemento error no aparece", isMenssageErrorVisible);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
