package com.hiberus.university.selenium.LogOut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogOutSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void testLogOut() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        driver.findElement(By.id("react-burger-menu-btn")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//nav[@class='bm-item-list']"))));
        driver.findElement(By.id("logout_sidebar_link")).click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El logout es fallido porque no estamos en la url del login",
                "https://www.saucedemo.com/", url);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
