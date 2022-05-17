package com.hiberus.university.selenium.testCasesRuben.inventory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BAddItemToShoppingCar {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1.
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
        //driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        WebElement car = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        Thread.sleep(2000);
        if (car.getText().equals("1")) {
            System.out.println("Show Value 1");
        }
        else {
            System.out.println("Product doesn't show");
        }
        Thread.sleep(2000);

        driver.close();
    }
}
