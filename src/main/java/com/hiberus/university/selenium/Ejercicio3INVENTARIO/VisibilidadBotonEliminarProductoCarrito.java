package com.hiberus.university.selenium.Ejercicio3INVENTARIO;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VisibilidadBotonEliminarProductoCarrito {
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

        //Paso 5. Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        WebElement buyMono = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        buyMono.click();
        Thread.sleep(2000);

        //Paso 6. Validar que se muestra la opcion de eliminar el mono
        WebElement remove = driver.findElement(By.id("remove-sauce-labs-onesie"));
        if (remove.isDisplayed()) {
            System.out.println("Se visuliaza el botÓn de REMOVE");
        } else {
            System.out.println("No se visualiza el botón de REMOVE");
        }
        driver.quit();

    }
}