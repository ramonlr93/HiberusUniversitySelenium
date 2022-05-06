package com.hiberus.university.selenium.Inventario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EliminarProductoCarrito {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Paso0
        String userProfile = "C:\\Users\\scasado\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10, 500);

        //Paso1 Ir a la pagina
        driver.get("https://www.saucedemo.com/");
        //Paso2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Paso3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4. Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        //Paso5 Agregar producto al carrito
        Thread.sleep(5000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(5000);
        String addProduct = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        //Paso6 Eliminar producto del carrito
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(5000);
        String sinProducto = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        int sinProd;
        System.out.println(addProduct);
        if(sinProducto.equals("")) {
            sinProd = 0;
            sinProducto = "Sin producto";
        }
        System.out.println(sinProducto);
        driver.quit();
    }
}

