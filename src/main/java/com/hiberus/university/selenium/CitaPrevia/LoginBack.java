package com.hiberus.university.selenium.CitaPrevia;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.WebDriver.*;

public class LoginBack {
    public static WebDriver driver;

    public static void main(String[] args) {
        String userProfile = "C:\\Users\\iezquerra\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2
        driver.get("https://citaprevia.demohiberus.com/auth");

        //Paso 3
        WebElement element = driver.findElement(By.id("mat-input-0"));
        element.sendKeys("iezquerra");

        //Paso 4
        driver.findElement(By.id("mat-input-1")).sendKeys("27Abril2022!!");

        //Paso 5
       driver.findElement(By.xpath("//span[(@class='mat-button-wrapper' and text()=' Entrar ')]")).click();

        //driver.quit();
    }
}
