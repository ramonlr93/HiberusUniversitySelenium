package com.hiberus.university.selenium.Ejercicio3INVENTARIO;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class ValidarProductosInventario {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
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

        //Paso 5. Validar numero de items se igual a 6
        List<WebElement> list = driver.findElements(By.className("inventory_item"));
        int tLista = list.size();
        System.out.println(tLista);
        if (tLista == 6) {
            System.out.println("El número de productos mostrado es 6");
        } else {
            System.out.println("El número de productos NO es 6");
        }

        driver.quit();
    }
}
