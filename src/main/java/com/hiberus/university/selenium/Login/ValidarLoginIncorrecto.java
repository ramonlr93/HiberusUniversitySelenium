package com.hiberus.university.selenium.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
public class ValidarLoginIncorrecto {
    public static WebDriver driver;

    public static void main(String[] args) {

        //Paso0

        String userProfile = "C:\\Users\\scasado\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso1 Ir a la pagina
        driver.get("https://www.saucedemo.com/");
        //Paso2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user3");
        //Paso3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4. Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        //Paso 5. Validar que aparece el mensaje de error
        WebElement errorMessage= driver.findElement(By.xpath("//h3[@data-test='error']"));
        boolean respuesta = errorMessage.isDisplayed();

        if(respuesta){
            System.out.println("Error mostrado");
        }else{
            System.out.println("Error oculto");
        }
        driver.close();
    }
}

