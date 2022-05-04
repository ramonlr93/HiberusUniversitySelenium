package com.hiberus.university.selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    public static void main( String[] args ) {

        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar chrome driver
        ChromeOptions options = new ChromeOptions(); //Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https:/www.hiberus.com/");

        String url = driver.getPageSource();

        driver.close();
        System.out.println( "Este es el valor que devuelve: " + url );
    }
}
