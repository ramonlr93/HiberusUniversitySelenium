package com.hiberus.university.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static WebDriver driver;

    @Before
    public void setupClass() {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void testLogin() {
        driver.get("https://www.saucedemo.com/");

        Login("standard_user", "secret_sauce");

        String url = driver.getCurrentUrl();

        Assert.assertEquals("El Login es correcto", "https://www.saucedemo.com/inventory.html", url);
    }
    @Test
    public void testLoginIncorrect() {
        driver.get("https://www.saucedemo.com/");

        Login("standard_usererror", "¨secret_sauce");

        WebElement error = driver.findElement(By.xpath("//div[@class='error-message-container error']"));

        Assert.assertTrue(error.isDisplayed());
    }
    @After
    public void tearDom() {
        driver.quit();
    }
    private void Login(String username, String password) {
        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
}
