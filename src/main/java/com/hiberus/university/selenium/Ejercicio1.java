package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ejercicio1 {

    public static WebDriver driver;

    public static void main( String[] args ){

        //Paso 1
        String userProfile = "C:\\Users\\candi\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //Cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); //Crear instancia para opciones de Chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options); //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //Maximiza la ventana

        //Paso 2
        driver.get("https://www.saucedemo.com/"); //Abrimos la página

        //Paso 3
        String titulo = driver.getTitle();
        int longitud = titulo.length();

        //Paso 4
        System.out.println("Título: " + driver.getTitle() + "\nLongitud: " + longitud);

        //Paso 5
        String url = driver.getCurrentUrl();
        System.out.println(url);
        if(url.equals("https://www.saucedemo.com/")) System.out.println("La URL es correcta");
        else System.out.println("La URL no es correcta");

        //Paso 8
        driver.close(); //.close() cierra la página, .quit() el navegador. Usamos .close() porque solo hay una
    }
}