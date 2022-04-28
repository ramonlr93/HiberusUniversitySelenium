package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ejercicio2 {

    public static WebDriver driver;

    public static void main ( String[] args ) throws InterruptedException {
        //Paso 1

        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2
        Thread.sleep(2000);
        driver.get("https://www.hiberus.com/");

        //paso 3
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/consultoría-y-estrategia-de-negocio']")).click();
        Thread.sleep(2000);

        driver.navigate().back();

        //paso 4
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().to("https://www.hiberus.com/");
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.close();
}
}