package com.hiberus.university.selenium.practica2.practica1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Practica1 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 2. Abrir la página https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        // Paso 3. Obtenga el nombre del titulo de la pagina y la longitud del título
        String title = driver.getTitle();
        int length = title.length();

        Thread.sleep(2000);

        // Paso 4. Imprima el título de la página y la longitud del título en la consola de IntellIJ.
        System.out.println("Título: " + title);
        System.out.println("Longitud: " + length);

        Thread.sleep(2000);

        // Paso 5. Obtenga la URL de la página y verifique si es una página correcta.
        String url = driver.getCurrentUrl();
        if(url.equals("https://www.saucedemo.com/")){
            System.out.println("Página Correcta");
        }else{
            System.out.println("Página Incorrecta");
        }
        Thread.sleep(2000);

        // Paso 6. Obtenga la fuente de la página (código fuente HTML) y la longitud de la fuente de la
        //página.
        String pagesource = driver.getPageSource();
        int pagesourcelength = pagesource.length();

        Thread.sleep(2000);

        // Paso 7. Imprimir longitud de página en la consola de IntellIJ.
        System.out.println("Longitud de la fuente: " +pagesourcelength);

        Thread.sleep(2000);

        // Paso 8. Cierra el Navegador
        driver.close();
    }
}
