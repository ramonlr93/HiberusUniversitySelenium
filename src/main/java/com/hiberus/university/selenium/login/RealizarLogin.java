package com.hiberus.university.selenium.login;

import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLogin {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Paso 0
        String userProfile = "C:\\Users\\pepet\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();



        // Paso 1
        // Ir a la página https://www.saucedemo.com

        driver.get("https://www.saucedemo.com/");

        // Paso 2
        // Escribir el username standard_user

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Paso 3
        //Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret.sauce");

        // Paso 4
        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Paso 5
        //Validar que hemos accedido correctamente a la página, comprobando que se muestra
        //la URL https://www.saucedemo.com/inventory.html

        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("la URL es correcta.");
        } else {
            System.out.println("ERROR: la URL no es la correcta");
        }
        driver.close();
    }
}
