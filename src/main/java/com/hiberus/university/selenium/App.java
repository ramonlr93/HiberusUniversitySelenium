package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
    public static final String ruta = "https://hiberus.com/";

    public static void main( String[] args ) {
        // Paso 1
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        final String ruta = "https://saucedemo.com/";
        WebDriverManager.chromedriver().setup();  //Cargar ChroneDriver
        ChromeOptions options = new ChromeOptions();  //Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get(ruta);
        driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();
        driver.navigate().back();

        //Paso 2
        driver.get(ruta);

        //Paso 3 y 4
        String title = driver.getTitle();
        //int length_title = driver.getTitle().length();
        System.out.println(title + ' ' + title.length());

        //Paso 5
        String url = driver.getCurrentUrl();
        System.out.println("La url es " + url);
        if (url.equals(ruta))
            System.out.println("La url es " + url);
    }
}
