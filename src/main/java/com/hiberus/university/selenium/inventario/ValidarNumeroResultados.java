package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ValidarNumeroResultados {

    public static WebDriver driver;

    public static void main ( String[] args ) throws InterruptedException{

        //Paso 0
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 1
        driver.get("https://www.saucedemo.com");


        //Paso 2
        driver.findElement(By.id("user-name")).sendKeys("standard_user");


        //Paso 3
        driver.findElement(By.id("password")).sendKeys("secret_sauce");


        //Paso 4
        driver.findElement(By.id("login-button")).click();

        //Paso 5
        WebElement lista = driver.findElement(By.xpath("//div[@class='inventory_item']"));


      //  if(lista == 6)
      //  {
      //      System.out.println("El numero de articulos ES IGUAL a 6");
     //   }
     //   else{
     //       System.out.println("El numero de articulos NO ES IGUAL a 6");
     //   }

    }
}
