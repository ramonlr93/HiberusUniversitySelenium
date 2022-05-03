package com.hiberus.university.selenium.Login;

import com.hiberus.university.selenium.Inventario.Constantes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLogin {

    public static WebDriver driver;

    //Paso0
    public static void main(String[] args) throws InterruptedException {

        String userProfile = Constantes.pathChrome;
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1

        driver.get("https://www.saucedemo.com/");

        //Paso 2
        //Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

        //Paso 3
        //Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        //Paso4
        //Pulsar LOGIN
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Paso 5
        //Validar la URL https://www.saucedemo.com/inventory.html
        //driver.getCurrentUrl(); // devuelve la URL en la que estás
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Url correcta");
        } else {
            System.out.println("Url incorrecta");

        }

        driver.close();


    }
}

