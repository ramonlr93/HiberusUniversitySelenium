package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class ValidarLoginIncorrecto {

    public static WebDriver driver;

    public static void main( String[] args ) throws InterruptedException{

        //Paso 1
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 2
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);


        //Paso 3
        driver.findElement(By.id("user-name")).sendKeys("standard_userrr");
        Thread.sleep(3000);

        //Paso 4
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(3000);

        //Paso 5
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

        //Paso 6

        if(driver.findElement(By.xpath('//div[@class="error-message-container error"]')).isDisplayed())
        {
            System.out.println("El error se ha mostrado");
        }
        else
        {
            System.out.println("No se ha mostrado el error");
        }

        Thread.sleep(3000);

        //Paso 7
        driver.close();

    }

}
