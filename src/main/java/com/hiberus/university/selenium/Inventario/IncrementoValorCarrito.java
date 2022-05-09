package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class IncrementoValorCarrito {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\iezquerra\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2
        driver.get("https://www.saucedemo.com");

        //Paso 3
        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard_user");

        //Paso 4
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 5
        WebElement element1 = driver.findElement(By.id("login-button"));
        element1.click();

        //Paso 6
        String url = driver.getCurrentUrl();
        System.out.println("la url es " + url);

        //Paso 7
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(2000);

    }
}
