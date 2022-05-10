package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Ej1 {
public static WebDriver driver;
public static void main(String[] args) {
        String userProfile ="C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup(); // cargar chromedriver

        ChromeOptions options = new ChromeOptions(); //instanciar objeto de chromeoptions

        options.addArguments("user-data-dir=" + userProfile);

        driver =  new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();





}




}
