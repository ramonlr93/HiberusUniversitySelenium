package com.hiberus.university.selenium.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginIncorrecto {
    public static WebDriver driver;
    static String url = "https://saucedemo.com";
    public static void main( String[] args ) throws InterruptedException {

        String userProfile = "C:\\Users\\ander\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.id("user-name")).sendKeys("standard_use");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement mensajeError = driver.findElement((By.xpath("//div[@class='error-message-container error']")));
        boolean correcto = mensajeError.isDisplayed();
        if(correcto){
            System.out.println("La prueba es correcta porque sale el mensaje de eeror");
        }
        else{
            System.out.println("La prueba es incorrecta porque no aparece el mensaje de error");
        }
        driver.quit();

    }
}