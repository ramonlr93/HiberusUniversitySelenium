package com.hiberus.university.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ejercicio1 {

    /**
     * Hello world!
     */
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //Punto 1
        String rutadriver ="C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Punto 2
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        //Punto 3
        String titulo = driver.getTitle();
        int longtitulo = titulo.length();
        //Punto 4
        System.out.println("El título es = " + titulo + "\nLa longitud es = " + longtitulo);
        //Punto 5
        String url = driver.getCurrentUrl();
        System.out.println(url);
        boolean correcta = url.equals("https://www.saucedemo.com/");
        if (correcta) {
            System.out.println("La url es correcta");
        } else {
            System.out.println("La url es incorrecta");
        }
        //Punto 6
        String codigo = driver.getPageSource();
        int longcodigo = codigo.length();
        //Punto
        System.out.println("La logitud del codigo es=" + longcodigo);

        driver.close();

    }
}