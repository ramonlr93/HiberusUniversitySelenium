package com.hiberus.university.selenium.login;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class LoginSuite {
    /**
     * Rigorous Test :-)
     */

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 5, 500);
    }

    @Test
    public void testLogin() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(2000);
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        String urlActual = driver.getCurrentUrl();
        Assert.assertEquals("LA PRUEBA ES FALLIDA PORQUE NO ESTAMOS EN LA URL QUE DEBERIAMOS ESTAR", "https://www.saucedemo.com/inventory.html", urlActual);
    }

    @Test
    public void testLoginIncorrect() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(2000);
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        boolean existe;
        try {
            existe = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@data-test='error']")))).isDisplayed();
        } catch (NoSuchElementException e) {
            existe = false;
        }
        Assert.assertTrue("LA PRUEBA A FALLADO PORQUE NO HA SALIDO EL MENSAJE DE ERROR", existe);
    }

    @After
    public void tearDawn() {
        driver.quit();
    }
}
