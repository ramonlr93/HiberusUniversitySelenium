package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLogin {

    public static WebDriver driver;

    public static void main( String[] args ) {

        // Paso 0
        String userprofile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userprofile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 1

        System.out.println( "Hello World! QA" );
    }
}
