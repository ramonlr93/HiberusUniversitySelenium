package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class EliminarProductoCarrrito {

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

        // Escribir el username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(500);

        // Escribir la password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(500);

        // Pulsar botón Login
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(500);

        // Agregar producto
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-onesie']")).click();
        Thread.sleep(1000);

        // Eliminar producto
        driver.findElement(By.xpath("//button[@name ='remove-sauce-labs-onesie']")).click();
        Thread.sleep(500);

        // Comprobación carrito
        String numeroDeElementos = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        System.out.println(numeroDeElementos.equals("")?"Se ha puesto el carrito a 0":"No se ha puesto el carrito a 0");
        Thread.sleep(2000);

        // Cerrar
        driver.close();
    }

}
