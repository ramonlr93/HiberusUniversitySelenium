package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Comandos {
    public static WebDriver driver;

    public static void main( String[] args ) {
        // Paso 1
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        String ruta = "https://hiberus.com/";
        WebDriverManager.chromedriver().setup();  //Cargar ChroneDriver
        ChromeOptions options = new ChromeOptions();  //Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(ruta);
        driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();
        driver.navigate().back();

    }
}
