package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ejercicio2 {

    public static WebDriver driver;

    public static void main( String[] args ) throws InterruptedException {

        //1
        String userProfile = "C:\\Users\\candi\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions(); //Crear instancia para opciones de Chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options); //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //Maximiza la ventana

        String url = "https://www.hiberus.com/"; //2
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href = '/consultoria-y-estrategia-de-negocio']")).click(); //3

        Thread.sleep(2000);
        driver.navigate().back(); //4
        Thread.sleep(2000);
        driver.navigate().forward(); //5
        Thread.sleep(2000);
        driver.navigate().to(url); //6
        Thread.sleep(2000);
        driver.navigate().refresh(); //7
        Thread.sleep(2000);
        driver.close(); //8
    }
}