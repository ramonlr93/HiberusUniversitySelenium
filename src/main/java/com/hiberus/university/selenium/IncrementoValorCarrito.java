package com.hiberus.university.selenium.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class IncrementoValorCarrito {
    public static WebDriver driver;
    public static void main(String[] args) {
        //Validar el número de resultados:

        //Crear el WebDriver
        String userProfile = "C:\\Users\\Nelida\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://www.saucedemo.com/");
        //Paso2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Paso3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4. Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        // Paso 5 Agregar al carrito el producto Sauce Labs Bolt T-Shirt

        try {
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            String element = driver.findElement(By.className("shopping_cart_badge")).getText();
            if (element.equals("1")){
                System.out.println("Producto anadido a carrito");
            }
            driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        } catch (Exception e) {
            System.out.println("Producto no anadido a carrito");
        }

        driver.quit();


    }
}
