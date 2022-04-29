package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {

    public static WebDriver driver;
    public static void main( String[] args ) {
        String userProfile= "C:\\Users\\iezquerra\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 2
        driver.get("https://www.hiberus.com/");
        driver.close();


        System.out.println( "\n" + "\n" + "Este es el valor que devuelve: " );

        //  Paso 3
        String titulo = driver.getTitle();
        int longitud = titulo.length();

        //  Paso 4
        System.out.println("Título: " + titulo + "\nLongitud: " + longitud);

        //  Paso 5
        String url = driver.getCurrentUrl();
        System.out.println("la url es " + url);
        if (url.equals("https://saucedemo.com"))
            System.out.println("La url " + url + "es correcta");
        else
            System.out.println("La url " + url + "no es correcta");

        //Paso 8
        driver.close();

    }
}
