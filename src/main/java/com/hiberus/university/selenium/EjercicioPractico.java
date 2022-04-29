package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class EjercicioPractico {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\iezquerra\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        final String paginaPrincipal = "https://www.hiberus.com/";

        //Paso 2
        driver.get(paginaPrincipal);

        //Paso 3
        driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();

        //Paso 4
        Thread.sleep(2000);
        driver.navigate().back();
        //Paso 5
        Thread.sleep(2000);
        driver.navigate().forward();

        //Paso 6
        Thread.sleep(2000);
        driver.navigate().to(paginaPrincipal);

        //Paso 7
        Thread.sleep(2000);
        driver.navigate().refresh();

        //Paso 8
        driver.quit();

    }
}