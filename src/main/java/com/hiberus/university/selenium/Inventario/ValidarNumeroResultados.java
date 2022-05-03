package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ValidarNumeroResultados {

    public static WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";

    public void test() throws InterruptedException{
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Ir a la URL
        driver.get(URL);

        // Escribir username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(500);

        // Escribir password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(500);

        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(500);

        // Validar que el número de productos mostrados es 6
        int len = driver.findElements(By.xpath("//div[@class='inventory_list']/child::div")).size();
        System.out.println("Numero de items: " + len);
        Thread.sleep(2000);

        // Cerramos
        driver.close();

    }



}

