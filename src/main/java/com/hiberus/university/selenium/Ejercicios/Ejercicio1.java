package com.hiberus.university.selenium.Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ejercicio1 {
    public static WebDriver driver;

    public static void main( String[] args ) throws InterruptedException {

        // Paso 1
        String userProfile = "C:\\Users\\Flores\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();  //Cargar ChroneDriver
        ChromeOptions options = new ChromeOptions();  //Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2
        driver.get("https://www.saucedemo.com/");

        //Paso 3 y 4
        String title = driver.getTitle();
        //int length_title = driver.getTitle().length();
        System.out.println("Titulo: " + title);
        System.out.println("Longitud titulo: " + title.length());

        //Paso 5
        String url = driver.getCurrentUrl();
        System.out.println("La url es: " + url);
        if (url.equals("https://www.saucedemo.com/")) {
            System.out.println("La url " + url + " es correcta");
        } else {
            System.out.println("La url " + url + " no es correcta");
        }

        //Paso 6 y 7
        String code = driver.getPageSource();
        //int length_code = driver.getPageSource().length();
        System.out.println("Codigo: " + code);
        System.out.println("Longitud codigo: " + code.length());

        //Paso 8
        Thread.sleep(2000);
        driver.close();

    }
}
