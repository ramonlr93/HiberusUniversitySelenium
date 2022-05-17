package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        /*
        Assert.assertEquals("", true, true);
         */

        /*
        // Paso 0:
        // Inicie un nuevo navegador Chrome ->


        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        // Paso 7:
        // Actualizar el navegador (Use el comando 'Refresh') ->
        driver.navigate().refresh();
        Thread.sleep(4000);

        // Paso 8:
        // Cierra el navegador ->
        driver.quit();


        // Paso 3 y 4:
        String title = driver.getTitle();
        System.out.println("El título de la web es: " + title);
        System.out.println("El tamaño del título es: " + title.length());

        // Paso 5:
        String url = driver.getCurrentUrl();

        if(url.equals("https://www.saucedemo.com/")){
            System.out.println("La página es correcta");
        }else{
            System.out.println("La página no es correcta");
        }

        // Paso 6:
        String codigo = driver.getPageSource();
        System.out.println("La longitud del código es: " + codigo.length());
        //Si quieres mostrar el código deberías poner System.out.println(codigo);

        // Paso 7:
        System.out.println();

        // Paso 8:
        System.out.println("El tamaño de la página es: " + driver.getCurrentUrl().length());



        driver.get("https://www.hiberus.com/");

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        String codigo = driver.getPageSource();

        //Thread.sleep(2000);
        //driver.close();

        driver = new ChromeDriver(options);

        driver.get("https://biwenger.as.com/");
        driver.get("https://www.as.com/");
        Thread.sleep(2000);

        driver.quit();

       System.out.println( "Hola Hiberus" );
       System.out.println("El título de la web es: " + title);
       System.out.println("La url es: \n" + url);
       System.out.println("\nEl código de la web es: \n" + codigo);
       */
    }
}
