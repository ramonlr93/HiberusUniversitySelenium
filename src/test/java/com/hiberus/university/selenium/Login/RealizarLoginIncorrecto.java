package com.hiberus.university.selenium.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLoginIncorrecto {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\iezquerra\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void testLoginIncorrecto () {
       driver.get("https://www.saucedemo.com/");
       WebElement userBox = driver.findElement(By.id("user-name"));
       userBox.sendKeys("standard_usererror");
       WebElement passBox = driver.findElement(By.id("password"));
       passBox.sendKeys("secret_sauce");
       WebElement clickButton = driver.findElement(By.id("login-button"));
       clickButton.click();
       WebElement error = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
       if (error.isDisplayed()) {
       System.out.println("Ha saltado el error");
       } else {
       System.out.println("No ha saltado el error");
    }
       String url = driver.getCurrentUrl();
       Assert.assertTrue("El Login ha Fallado", error.isDisplayed());
    }

}