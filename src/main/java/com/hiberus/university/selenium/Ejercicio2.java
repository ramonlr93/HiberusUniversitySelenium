package com.hiberus.university.selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Ejercicio2 {

    public static WebDriver driver;

    public static void main( String[] args ) {
        String userProfile =  "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        //Paso 1//
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String https;
        //Paso 2 //

    driver.get("https://www.hiberus.com/");
    //driver.findElement(By.xpath("//a[@href=’/consultoría-y-estrategia-denegocio’]")).click();
        driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();//3
        driver.navigate().back(); //4
        driver.navigate().forward(); //5
        driver.navigate().to("https://www.hiberus.com/"); //6
        driver.navigate().refresh(); //7
        driver.quit(); //8


}}
