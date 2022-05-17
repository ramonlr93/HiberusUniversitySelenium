package com.hiberus.university.selenium.practicaSelenium.practicaSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Practice1 {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Paso 1.
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 2.
        driver.get("https://www.saucedemo.com/");
        sleep(2000);

        //Paso 3 y 4.
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        int length = title.length();
        System.out.println("Length: " + length);
        sleep(2000);

        // Paso 5.
        String url = "https://www.saucedemo.com/";
        String currentUrl = driver.getCurrentUrl();
        if (url.equals(currentUrl)) {
            System.out.println("Web URL is correct");
        } else System.out.println("Web URL is not correct");
        sleep(2000);

        //Paso 6 y 7.
        int lengthPageSource = driver.getPageSource().length();
        System.out.println("Length Page Source: " + lengthPageSource);
        sleep(2000);

        //Paso 8.
        driver.close();
    }
}
