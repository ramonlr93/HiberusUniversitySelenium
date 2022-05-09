package Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ejercicio2 {
    public static WebDriver driver;

    public static void main( String[] args ) throws  InterruptedException {

        //Paso 1
        String userProfile = "C:\\Users\\Flores\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2
        driver.get("https://www.hiberus.com/");

        //Paso 3
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();

        //Paso 4
        Thread.sleep(4000);
        driver.navigate().back();

        //Paso 5
        Thread.sleep(4000);
        driver.navigate().forward();

        //Paso 6
        Thread.sleep(4000);
        driver.navigate().to("https://www.hiberus.com/");

        //Paso 7
        Thread.sleep(4000);
        driver.navigate().refresh();

        //Paso 8
        Thread.sleep(4000);
        driver.close();
    }
}
