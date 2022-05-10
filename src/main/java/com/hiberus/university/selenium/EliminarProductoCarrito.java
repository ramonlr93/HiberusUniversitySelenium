package com.hiberus.university.selenium.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class EliminarProductoCarrito {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        //Eliminar producto del carrito:

        //Crear el WebDriver
        String userProfile = "C:\\Users\\Nelida\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Paso1 Ir a la página https://www.saucedemo.com
        driver.get("http://www.saucedemo.com/");
        //Paso2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Paso3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4 Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        //Paso 5 Agregar producto al carrito
        Thread.sleep(5000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(5000);
        String aniadido = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        //Paso 6 Eliminar producto del carrito
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(5000);
        //Paso 7 Validar que en el icono del carrito se ha eliminado el producto.
        String eliminado = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        if(eliminado.equals("")) {
            System.out.println("Validamos que en el icono del carrito se ha eliminado el producto.");
        } else {
            System.out.println("Validar que en el icono del carrito no se ha eliminado el producto." +aniadido);
        }
        driver.quit();
    }
}

