package com.hiberus.university.selenium.practicaSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Practice1 {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Paso 1. Open new Chrome
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2. Open https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        //Paso 3 y 4. Obtain Name and Title from the Website and the Title length. Print it
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        int length = driver.getTitle().length();
        System.out.println("Length:  " + length);

        //Paso 5. Obtain URL from the Website and validate the url is correct. Print it.
        String url = driver.getCurrentUrl();
        if (url.equals("https://www.saucedemo.com/")) {
            System.out.println("Web URL is correct");
        } else {
            System.out.println("Web URL is not correct");
        }

        //Paso 6 y 7. Obtain the page source (HTML source code) and the length of the page source. Print it.
        String pageSource = driver.getPageSource();
        int pageSourceLength = pageSource.length();
        System.out.println("Page Source Length: " + pageSourceLength);

        //Paso 8. Close
        driver.close();
    }
}
