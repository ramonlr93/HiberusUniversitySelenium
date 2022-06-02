package com.hiberus.university.selenium.Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ej3_IncrementoValorCarrito {
    public static WebDriver driver;

    public static void main( String[] args ) throws  InterruptedException {

        //Paso 0
        String userProfile = "C:\\Users\\Flores\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 1
        driver.get("https://www.saucedemo.com/");

        //Paso 2
        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard_user");

        //Paso 3
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Paso 5
        WebElement addcamiseta = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        addcamiseta.click();
        Thread.sleep(2000);

        //Paso 6
        boolean carrito = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();

        if (carrito) {
            WebElement contenido = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
            System.out.println("Se ha añadido " + contenido.getText() + " elementos");
        } else {
            System.out.println("No se ha añadido ningun producto al carrito");
        }

        //Se ha añadido remover aqui para que al volver a ejecutar la prueba se abra sin productos añadidos
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
