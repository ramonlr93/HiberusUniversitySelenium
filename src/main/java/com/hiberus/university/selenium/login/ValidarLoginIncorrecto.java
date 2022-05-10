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

    public static void main(String[] args) {

        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();  //Cargar ChroneDriver
        ChromeOptions options = new ChromeOptions();  //Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        WebElement element1 = driver.findElement(By.id("user-name"));
        element1.sendKeys("standard_use");

        WebElement element2 = driver.findElement(By.id("password"));
        element2.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //String url= driver.getCurrentUrl();

        if(driver.findElement(By.xpath("//div[@class = 'error-message-container error']")).isDisplayed())
            System.out.println("Visible el error");
        else System.out.println("Error no visible");

    }
}
