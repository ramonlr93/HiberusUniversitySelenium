package com.hiberus.university.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Methods {

    public static WebDriver initDriver() {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        return driver;
    }

    public static WebDriver initDriver(String url) {
        WebDriver driver = initDriver();
        driver.get(url);
        return driver;
    }
}
