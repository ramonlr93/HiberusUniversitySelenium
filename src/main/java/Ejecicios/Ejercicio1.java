package Ejecicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Ejercicio1 {
    public static WebDriver driver;
    public static void main( String[] args ) {
        // 1
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // 2
        driver.get("https://www.saucedemo.com");

        // 3
        String titulo = driver.getTitle();
        int lTitulo = driver.getTitle().length();
        // 4
        System.out.println("Titulo: "+titulo);
        System.out.println("Longitud del titulo: "+ lTitulo);

        // 5
        String url = driver.getCurrentUrl();
        if (url.equals("https://www.saucedemo.com")){
            System.out.println("Correcto");
        } else{
            System.out.println("Incorrecto");
        }

        // 8
        driver.close();
    }
}
