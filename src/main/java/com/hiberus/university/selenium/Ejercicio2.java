package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Ejercicio2 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // 1
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // 2
        driver.get("https://www.hiberus.com/");
        Thread.sleep(2000);

        // 3
        driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();
        Thread.sleep(2000);

        // 4
        driver.navigate().back();
        Thread.sleep(2000);
        // 5
        driver.navigate().forward();
        Thread.sleep(2000);
        // 6
        driver.navigate().to("https://www.hiberus.com/");
        Thread.sleep(2000);
        // 7
        driver.navigate().refresh();
        Thread.sleep(2000);
        // 8
        driver.close();
    }
}
