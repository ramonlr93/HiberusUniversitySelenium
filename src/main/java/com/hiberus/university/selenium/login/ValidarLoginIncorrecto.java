package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ValidarLoginIncorrecto {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Paso 0
        String userProfile = "C:\\Users\\pepet\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        //Paso 1
        driver.get("https://www.saucedemo.com");

        //Paso 2
        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard-user");

        //Paso 3
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4
        WebElement element1 = driver.findElement(By.id("login-button"));
        element1.click();

        //Paso 5
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
        boolean status = errorMessage.isDisplayed();
        if (status==true) {
            System.out.println("LA PRUEBA ES CORRECTA, SE VISUALIZA EL MENSAJE DE ERROR");
        } else {
            System.out.println("LA PRUEBA ES ERRONEA, SE VISUALIZA EL MENSAJE DE ERROR");
        }


        //Paso 6
        driver.quit();
    }
}

