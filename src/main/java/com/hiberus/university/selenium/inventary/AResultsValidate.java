package com.hiberus.university.selenium.inventary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AResultsValidate {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 1.
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        //Paso 2 y 3.
        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        Thread.sleep(2000);

        //Paso 4.
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(2000);

        //Paso 5.
        List<WebElement> elementNameList =driver.findElements(By.xpath("//div[@class='inventory_item']"));
        if (elementNameList.size()==6) {
            System.out.println("El número de productos es correcto");
        }
        else {
            System.out.println("El número de productos no es correcto");
        }
        driver.close();
    }

}