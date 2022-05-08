package com.hiberus.university.selenium.inventario;

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
        // Paso 0
        String userProfile = "C:\\Users\\pepet\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1
        driver.get("https://www.saucedemo.com/");

        // Paso 2
        driver.findElement(By.id("user-name")).sendKeys("standard_user");


        //driver.findElement((By.xpath("//input[@id='user-name']"))).sendKeys("standard_user");

        //Paso 3
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //Paso 4
        driver.findElement(By.id("login-button")).click();
        //driver.findElement((By.xpath("//input[@id='login-button']"))).click);

        // Paso 5
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        //driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();

        // Paso 6
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();

        // Paso 7
        WebElement consulta = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        if(consulta.isDisplayed()){
            System.out.println("El producto ya esta eliminado del carrito");
        }else {
            System.out.println("El producto existe");
        }

        //paso 8 limpiamos navegador o lo eliminamos
        driver.close();
    }
}
