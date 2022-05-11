package com.hiberus.university.selenium.Ejecicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ValidarLogin {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_use");
        Thread.sleep(1000);
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        // 5
        System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
        driver.close();
    }
}
