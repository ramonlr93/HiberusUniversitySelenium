package com.hiberus.university.selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Ejercicio1 {

    public static WebDriver driver;

    public static void main( String[] args ) {

        //Paso 1
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso2
        driver.get("https:/www.saucedemo.com/");

        //Paso3
        String title = driver.getTitle();
        int titleLength = title.length();

        //Paso 4
        System.out.println( "Título de la web: " + title + "y la longitud del título es: " + titleLength );

        //Paso 5
        String url = driver.getCurrentUrl();
        boolean correcta = url.equals("https://www.saucedemo.com/");

        if (correcta) {
            System.out.println("La url es correcta");
        }
        else {
            System.out.println("La url es incorrecta");
        }

        //Paso 6 y 7
        String html = driver.getPageSource();
        System.out.println("La longitud del código de la página es " + html.length());

        //Paso 8
        driver.quit();



        driver.close();
    }
}
