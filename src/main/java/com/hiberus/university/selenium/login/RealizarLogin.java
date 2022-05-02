package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLogin {

    public static WebDriver driver;

    public static void main( String[] args ) throws InterruptedException {

        // Paso 0
        String userprofile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userprofile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1
        driver.get("https://www.saucedemo.com");

        // Paso 2
        // Escribir el username
        WebElement userBox = driver.findElement(By.id("user-name"));
        userBox.sendKeys("standard_user");
        Thread.sleep(2000);

        // Paso 3
        // Escribir el password secret_sauce
        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");
        Thread.sleep(2000);

        // Paso 4
        // Pulsar en el botón de login
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        // Paso 5
        // Validar que se ha accedido correctamente a la web
        String url = driver.getCurrentUrl();

        if (url.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("Página correcta");
        } else {
            System.out.println("Página incorrecta");
        }
        Thread.sleep(2000);
        driver.quit();
        }
    }

