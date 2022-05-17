package com.hiberus.university.selenium.login;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginSuiteTest {
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

            String username = "standard_user";
            String password = "secret_sauce";

            //driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

            driver.findElement(By.xpath("//input[@id='login-button']")).click();

            String url = driver.getCurrentUrl();

            Assert.assertEquals("Login Failed", "https://www.saucedemo.com/inventory.html", url);
        }

        @Test
        public void testLoginIncorrect() {
            driver.get("https://www.saucedemo.com/");

            WebElement userBox = driver.findElement(By.id("user-name"));userBox.sendKeys("standard_use");

            WebElement passBox = driver.findElement(By.id("password"));passBox.sendKeys("secret_sauce");

            WebElement clickButton = driver.findElement(By.id("login-button"));clickButton.click();

            WebElement error = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
            driver.getCurrentUrl();
            Assert.assertTrue("Login failed", error.isDisplayed());
        }

        @After
        public void tearDom() {
            driver.quit();
        }
    }
