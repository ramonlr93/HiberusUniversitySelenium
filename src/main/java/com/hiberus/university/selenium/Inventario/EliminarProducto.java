package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EliminarProducto {
    public static WebDriver driver;
    static String url = "https://saucedemo.com";
    public static void main( String[] args ) throws InterruptedException {

        String userProfile = "C:\\Users\\ander\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        String valorCarrito = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        System.out.println("El numero de objetos que aparece en el carrito son " + valorCarrito);
        Thread.sleep(2000);
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        List<WebElement> carrito = driver.findElements(By.xpath("//span[@class='shopping_cart_badge']"));
        if(carrito.isEmpty()){
            System.out.println("El carrito esta vacio");
        }
        else{
            System.out.println("El carrito no esta vacio");
        }
        driver.quit();
    }
}