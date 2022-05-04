package com.hiberus.university.selenium.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class ValidarLoginIncorrecto {
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
        Thread.sleep(2000);

        //Paso 2
        //Escribir el username standard_use (Introducimos mal el usuario para forzar el error)
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_use");

        Thread.sleep(2000);


        //Paso 3
        //Escribir el password secret_sauce
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        Thread.sleep(2000);


        //Paso 4
        //Pulsar en el botón del Login
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();
        Thread.sleep(2000);


        //Paso 5
        //Validar que aparece el mensaje de error.
        boolean errorMessage = driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed();

        if (errorMessage) {
            System.out.println("El login NO es correcto");
        }


        driver.quit();
    }
}
