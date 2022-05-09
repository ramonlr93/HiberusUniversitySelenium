package com.hiberus.university.selenium.logout;

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

public class LogOutSuite {

    public static WebDriver driver;

    @Before
    public void setUp(){
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testLogOut() throws InterruptedException
    {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("logout_sidebar_link")).click();

        String url = driver.getCurrentUrl();

        Assert.assertEquals("EL LOGIN ES FALLIDO PORQUE NO ESTAMOS EN LA URL QUE NOS PIDE", "https://www.saucedemo.com");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
