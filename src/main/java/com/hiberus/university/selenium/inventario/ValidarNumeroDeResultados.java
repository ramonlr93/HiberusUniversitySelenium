package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidarNumeroDeResultados {

    public static WebDriver driver;

    public static void main( String[] args ) throws InterruptedException {

        //Paso 1
        String userProfile = "C:\\Users\\candi\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //Cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); //Crear instancia para opciones de Chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options); //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //Maximiza la ventana

        driver.get("https://www.saucedemo.com/");

        //Paso 2
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Paso 3
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4
        driver.findElement(By.id("login-button")).click();

        //Paso 5
        List<WebElement> lista = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        System.out.println("El número de elementos es: " + lista.size());

        driver.close();
    }
}
