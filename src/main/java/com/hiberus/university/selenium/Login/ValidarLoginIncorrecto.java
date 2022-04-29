package com.hiberus.university.selenium.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ValidarLoginIncorrecto {
    public static WebDriver driver;

    public static void main( String[] args ) {
        String userProfile= "C:\\Users\\iezquerra\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2
        driver.get("https://www.saucedemo.com");

        //Paso 3
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard-user");

        //Paso 4
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 5
        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        //Paso 6
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
        boolean status = errorMessage.isDisplayed();
        if (status==true) {
            System.out.println("LA PRUEBA ES CORRECTA, SE VISUALIZA EL MENSAJE DE ERROR");
        } else {
            System.out.println("LA PRUEBA ES ERRONEA, SE VISUALIZA EL MENSAJE DE ERROR");
        }
        //Paso 8
        driver.quit();










    }
}