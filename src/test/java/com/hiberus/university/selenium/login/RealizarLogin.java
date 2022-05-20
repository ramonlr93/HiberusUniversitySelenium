package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class RealizarLogin {

    public static WebDriver driver;

    public static void main( String[] args ) {

        //Paso 1
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2
        driver.get("https://www.saucedemo.com");


        //Paso 3
        driver.findElement(By.id("user-name")).sendKeys("standard_user");


        //Paso 4
        driver.findElement(By.id("password")).sendKeys("secret_sauce");


        //Paso 5
        driver.findElement(By.id("login-button")).click();


        //Paso 6
        String currentURL = driver.getCurrentUrl();
        if (currentURL.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("La Pagina es correcta");
        }
        else{
            System.out.println("La pagina es incorrecta");
        }

        //Paso 7
        driver.close();

    }
}
