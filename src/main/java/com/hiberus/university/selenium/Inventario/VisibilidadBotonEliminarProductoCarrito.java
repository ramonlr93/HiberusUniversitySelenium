package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class VisibilidadBotonEliminarProductoCarrito {

    public static WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";

    public void test() throws InterruptedException{
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Ir a la URL
        driver.get(URL);

        // Introducir username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(500);

        // Introducir password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(500);

        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(500);

        // Añadir producto
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-onesie']")).click();
        Thread.sleep(1000);

        // Comprobar que el botón ha cambiado y ahora es remove
        boolean remove = driver.findElement(By.xpath("//button[@name ='remove-sauce-labs-onesie']")).isDisplayed();
        System.out.println("Existe botón remove: " + remove);

        // Eliminar producto carrito
        driver.findElement(By.xpath("//button[@name ='remove-sauce-labs-onesie']")).click();
        Thread.sleep(2000);

        // Cerramos
        driver.close();
    }

}
