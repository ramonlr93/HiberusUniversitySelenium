package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IncrementoCarrito {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Paso 0

        String userProfile = Constantes.pathChrome;
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

// Paso 1 Ir a web
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

        //Paso 5 Agregar al carrito un producto
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(2000);

        //Paso 6 validamos icono carrito sea 1
        //List<WebElement> carrito = driver.findElements(By.xpath("//span[@class = 'shopping_cart_badge']"));
        //System.out.println("Número de prendas añadidas es: " + carrito.size());

        //driver.close();
    }
}
