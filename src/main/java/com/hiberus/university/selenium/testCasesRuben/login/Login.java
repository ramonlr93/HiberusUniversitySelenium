package com.hiberus.university.selenium.testCasesRuben.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Thread.sleep(5000);

        // Paso 1. Ir a la URl https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);

        //Paso 2 y 3. Enter username standard_user and password secret_sauce
        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        Thread.sleep(5000);

        //Paso 4. Push Login Button.
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        Thread.sleep(5000);

        //Paso 5. Validate correct URL
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("The URL is correct");
        }
        else {
            System.out.println("The URL is not correct");
        }

        Thread.sleep(5000);

        driver.quit();

    }
}

