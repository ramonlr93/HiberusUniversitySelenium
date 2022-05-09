package com.hiberus.university.selenium.CitaPrevia;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginCitaPrevia extends TestCase {
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
    public void testLogin()  {
        driver.get("https://citaprevia.demohiberus.com/auth");
        WebElement element = driver.findElement(By.id("mat-input-0"));
        element.sendKeys("iezquerra");
        driver.findElement(By.id("mat-input-1")).sendKeys("27Abril2022!!");
        driver.findElement(By.xpath("//span[(@class='mat-button-wrapper' and text()=' Entrar ')]")).click();
    }
}
