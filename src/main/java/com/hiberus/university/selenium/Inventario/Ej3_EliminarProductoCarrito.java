package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ej3_EliminarProductoCarrito {
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
        WebElement addcamiseta = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        addcamiseta.click();
        Thread.sleep(2000);

        //Paso 6
        WebElement removecamiseta = driver.findElement(By.id("remove-sauce-labs-onesie"));
        removecamiseta.click();

        //Paso 7
        try {
            boolean carrito = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();

            if (carrito) {
                System.out.println("Hay productos en el carrito ");
            }

        } catch (NoSuchElementException find){
                System.out.println("No hay productos en el carrito");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
