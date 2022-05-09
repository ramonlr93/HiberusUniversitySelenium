package com.hiberus.university.selenium.LogOut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogOutSuite {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        //String userProfile = "C:\\Users\\Flores\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=" + userProfile)

        driver =  new ChromeDriver();
        //driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El login es fallido porque no hemos accedido a la url indicada en los requisitos",
                "https://www.saucedemo.com/", url);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
