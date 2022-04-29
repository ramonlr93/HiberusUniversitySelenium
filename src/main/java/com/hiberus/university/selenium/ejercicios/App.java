package com.hiberus.university.selenium.ejercicios;

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
        String userProfile =  "C:\\Users\\scasado\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String https;
        driver.get("https://www.hiberus.com/");
        driver.close();
        driver.quit();


        //System.out.println( "Hello World! QA Formacion" );
    }
}
