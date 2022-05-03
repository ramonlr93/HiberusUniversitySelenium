package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class IncrementoValorCarrito {
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

        // Ir a la página
        driver.get(URL);

        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(500);

        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(500);

        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(500);

        // Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        Thread.sleep(500);

        // Validamos que en el icono se a agregado el valor 1
        String numeroDeElementos = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        System.out.println("Se ha agregado el valor: " + numeroDeElementos);
        Thread.sleep(2000);

        // Cerramos
        driver.close();

    }
}
