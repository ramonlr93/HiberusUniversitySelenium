package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLogin {
    public static WebDriver driver;
    public static void main( String[] args ) throws InterruptedException {

        //Paso 0
        String userProfile= "C:\\Users\\usuario\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver= new ChromeDriver(options);       //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();      //Maximiza la ventana

        //Paso 1 Ir a la web
        driver.get("https://www.saucedemo.com/");
            // Thread.sleep(2000);

        //Paso 2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Paso 3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4 Pulsar en el boton del Login
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        //Paso 5 Validar que se accede correctamente a la pagina y comprobar que se muestra la url
        String url = driver.getCurrentUrl();

        if(url.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("La URL " + url + " es correcta ");
        }else {
            System.out.println("La URL " + url + " no es correcta ");
        }

        TimeUnit.SECONDS.sleep(1);
        driver.quit();
}
}
