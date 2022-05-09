package com.hiberus.university.selenium.Loguin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ej3_RealizarLogin {
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
        Thread.sleep(2000);

        //Paso 3
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        //Paso 4
        driver.findElement(By.id("login-button")).click();

        //Paso 5
        String url = driver.getCurrentUrl();
        System.out.println("La url es " + url);
        if (url.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("La url " + url + " es correcta");
        } else {
            System.out.println("La url " + url + " no es correcta");
        }

        Thread.sleep(4000);
        driver.close();
    }
}
