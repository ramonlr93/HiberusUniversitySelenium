package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Practicaprimera {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // EJERCICIO 1
        //Paso 1 Inicie un nuevo navegador Chrome

        String userProfile = "C:\\Users\\mnavarro\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        //Paso 1 Acceder al navegador Chrome
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2 Abrir la página https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        //Paso 3 Obtenga el nombre del titulo de la pagina y la longitud del título
        String title = driver.getTitle();
        System.out.println("El título de la web es: " + title);

        //Paso 4 Imprima el título de la página la longitud del título en la consola de IntellIJ.
        System.out.println("El tamaño del título es: " + title.length());

        //Paso 5 Obtenga la URL de la página y verifique si es una página correcta.
        String url = driver.getCurrentUrl();

        if (url.equals("https://www.saucedemo.com/")) {
            System.out.println("La página es correcta");
        } else {
            System.out.println("La página no es correcta");
        }

        //Paso 6 Obtenga la fuente de la página (código fuente HTML) y la longitud de la fuente de la pagina
        String codigo = driver.getPageSource();
        System.out.println("La longitud del código es: " + codigo.length());
        //Si quieres mostrar el código deberías poner System.out.println(codigo);

        //Paso 7 Obtenga la fuente de la página (código fuente HTML) y la longitud de la fuente de la pagina
        System.out.println();

        //Paso 8 Cierra el Navegador
        System.out.println("El tamaño de la página es: " + driver.getCurrentUrl().length());
        // Directamente pongo dentro del System.out.println 'driver.getCurrentUrl().length()'pero podría guardarlo antes en una variable como en los casos anteriores...

    }
}
