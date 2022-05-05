package com.hiberus.university.selenium.Ejercicio3INVENTARIO;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AnadirAlCarrito {
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
        WebElement buyCamisa = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        buyCamisa.click();
        Thread.sleep(2000);

        //Paso 6. Validar que el carrito tiene 1 articulo
        WebElement carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

        if (carrito.getText().equals("")) {
            System.out.println("NO se ha agregado ningun articulo al carrito");
        } else if (carrito.getText().equals("1")) {
            System.out.println("Se ha agregado " + carrito.getText() + " articulo al carrito");
        } else {
            System.out.println("Se han agregado " + carrito.getText() + " articulos al carrito");
        }
        driver.quit();

    }
}