package com.hiberus.university.selenium.Ejercicio3LOGIN;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RealizarLogin {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\100.0.4896.127";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Paso 1. Ir URL
        String urlSauce = "https://www.saucedemo.com/";
        driver.get(urlSauce);

        //Paso 2. Escribir username
        WebElement usuario = driver.findElement(By.id("user-name"));
        usuario.sendKeys("standard_user");
        Thread.sleep(2000);

        //Paso 3. Escribir password
        WebElement contrasena = driver.findElement(By.id("password"));
        contrasena.sendKeys("secret_sauce");
        Thread.sleep(2000);

        //Paso 4. Pulsar boton login
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        botonLogin.click();
        Thread.sleep(2000);

        //Paso 5. Validar que se encuentra en https://www.saucedemo.com/inventory.html
        String paginaActual = driver.getCurrentUrl();
        System.out.println("Esta es la página a la que quiero ir "+ paginaActual);
        if (paginaActual.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Estoy en la página correcta");
        } else {
            System.out.println("NO estoy en la página correcta");
        }

        driver.quit();
    }
}
