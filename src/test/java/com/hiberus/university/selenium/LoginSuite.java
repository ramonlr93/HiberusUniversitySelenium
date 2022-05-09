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

public class LoginSuite
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
    public void testLogin() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

                driver.findElement(By.id("user-name")).sendKeys("standard_use");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        //Validacion
        String url = driver.getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El login es fallido porque no hemos accedido a la url indicada en los requisitos",
                "https://www.saucedemo.com/inventory.html", url);
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
