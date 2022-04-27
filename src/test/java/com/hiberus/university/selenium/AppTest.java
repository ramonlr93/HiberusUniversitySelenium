package com.hiberus.university.selenium;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static WebDriver driver;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String userProfile= "C:\\Users\\iezquerra\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 2
        driver.get("https://www.hiberus.com/");
        driver.close();


        System.out.println( "\n" + "\n" + "Este es el valor que devuelve: " );

        assertTrue( true );
    }
}
