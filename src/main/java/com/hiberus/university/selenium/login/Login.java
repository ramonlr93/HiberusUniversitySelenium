package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1. Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        //Paso 2 y 3. Escribir el username standard_user y el password secret_sauce
        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        //Paso 4. Pulsar en el botón del Login.
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Paso 5. Validar que hemos accedido correctamente a la página, comprobando que se muestra la URL.
        String currenturl = driver.getCurrentUrl();
        if (currenturl.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("La Página es correcta");
        }
        else {
            System.out.println("La Página no  es correcta");
        }

        driver.quit();

    }
}

