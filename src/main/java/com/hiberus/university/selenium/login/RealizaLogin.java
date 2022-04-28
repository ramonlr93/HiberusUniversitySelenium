package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizaLogin {

    public static WebDriver driver;

    public static void main(String[] args) {

        //Paso 1

        String userProfile = "C:\\Usuarios\\Bloodlust\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 2
        driver.get("https://www.saucedemo.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Paso 3

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Paso 4

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.id("login-button"));
        element.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Paso 5

        String url = driver.getCurrentUrl();
        if (url.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("Login correcto");
        }
        else {
            System.out.println("Login incorrecto");
        }

        driver.quit();


        //System.out.println(url);

    }
}