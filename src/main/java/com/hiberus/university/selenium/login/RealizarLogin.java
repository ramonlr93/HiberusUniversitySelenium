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
        //Inicie un nuevo navegador Chrome
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 1
        // Ir a la página https://www.saucedemo.com
        driver.get("https:/www.saucedemo.com/");

        Thread.sleep(1000);

        //Paso 2
        //Escribir el username standard_user
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        Thread.sleep(1000);

        //Paso 3
        //Escribir el password secret_sauce
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        Thread.sleep(1000);

        //Paso 4
        //Pulsar en el botón del Login
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();
        Thread.sleep(1000);

        //Paso 5
        //Validar que hemos accedido correctamente a la página, comprobando que se muestra la URL https://www.saucedemo.com/inventory.html

        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("La url es correcta");
        }
        else {
            System.out.println("La url NO es correcta");
        }

        driver.quit();
    }
}
