package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IncrementarValorCarrito {


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
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        //

        WebElement carCount = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        if(carCount.getText().equals("1")){
            System.out.println("El contador del carro es igual a 1");
        }else  {
            System.out.println("El carrito tiene un valor distinto de 1");
        }

        //paso 6
       driver.close();

    }
}
