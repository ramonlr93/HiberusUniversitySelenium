package com.hiberus.university.selenium.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginCorrect {

    public static WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";

    public void test() throws InterruptedException{
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Ir a la página
        driver.get(URL);

        // Escribir usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(500);

        // Escribir contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(500);

        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(500);

        // Comprobar que la url en la que estamos es correcta
        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("URL Correcta");
        }else{
            System.out.println("URL Incorrecta");
        }
        Thread.sleep(2000);

        // Cerrar
        driver.close();


    }

}
