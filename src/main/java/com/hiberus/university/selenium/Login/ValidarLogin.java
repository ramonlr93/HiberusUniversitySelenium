package com.hiberus.university.selenium.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ValidarLogin {

    public static WebDriver driver;

    //Paso0
    public static void main(String[] args) throws InterruptedException {

        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1

        driver.get("https://www.saucedemo.com/");

        //Paso 2
        //Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_use");
        //Thread.sleep(2000);

        //Paso 3
        //Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);

        //Paso4
        //Pulsar LOGIN
        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        //Paso5
        //Validar que aparece mensaje de error
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
        boolean status = errorMessage.isDisplayed();
        if (status == true) {
            System.out.println("LA PRUEBA ES CORRECTA, SE VISUALIZA EL MENSAJE DE ERROR");
        } else {
            System.out.println("LA PRUEBA ES ERRONEA, SE VISUALIZA EL MENSAJE DE ERROR");
        }
        //Paso6
        driver.quit();


    }
}
