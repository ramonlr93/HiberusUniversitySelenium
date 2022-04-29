package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ejercicio1 {

    public static WebDriver driver;

    //Paso1
    public static void main(String[] args) {

        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        // Paso 2
        driver.get("https://www.saucedemo.com/");

        // Paso 3
        String title = driver.getTitle();
        int titleLenght = title.length();

        //Paso 4
        System.out.println("Titulo de la web: " + title);
        System.out.println("Longitud del título: " + titleLenght);

        // Paso 5
        String url = driver.getCurrentUrl();
        System.out.println("la urls es " + url);
        if (url.equals("https://www.saucedemo.com/"))
            System.out.println("la página es correcta");
        else
            System.out.println("la página no es correcta");

        //Paso 8
        driver.close();
    }
}




        //System.out.println( "Hello World! QA FORMACION" );



