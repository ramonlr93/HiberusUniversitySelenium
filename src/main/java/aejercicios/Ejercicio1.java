package aejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class Ejercicio1 {

    public static WebDriver driver;

    public static void main( String[] args ) {

        String userProfile= "C:\\Users\\pepet\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 2
        driver.get("https://www.saucedemo.com/");

        // Paso 3
        String titulo = driver.getTitle();
        int longitud = titulo.length();

        // Paso 4
        System.out.println("Título: " + titulo + "\nLongitud: " + longitud);

        // Paso 5
        String url = driver.getCurrentUrl();
        boolean correcta = url.equals("https://www.saucedemo.com/");

        if (correcta)
        {
            System.out.println("La url es correcta");
        }
        else
        {
            System.out.println("La url es incorrecta");
        }

        // Paso 8
        driver.quit();
    }
}

