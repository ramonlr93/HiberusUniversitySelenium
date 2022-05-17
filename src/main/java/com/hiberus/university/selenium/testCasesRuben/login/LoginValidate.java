package com.hiberus.university.selenium.testCasesRuben.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginValidate {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1. Open Website “https://www.saucedemo.com/” ->es
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        // Paso 2. Enter username standard_user ->
        WebElement userBox = driver.findElement(By.id("user-name"));
        userBox.sendKeys("standard_use");
        Thread.sleep(2000);

        // Paso 3. Enter password secret_sauce ->
        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");
        Thread.sleep(2000);

        // Paso 4. Push login Button ->
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();
        Thread.sleep(2000);

        // Paso 5. Validate error Message
        WebElement error = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
        if(error.isDisplayed()){
            System.out.println("Error is Message is showed");
        }
        else {
            System.out.println("Error is Message is not showed");
        }
        driver.close();
    }
}
