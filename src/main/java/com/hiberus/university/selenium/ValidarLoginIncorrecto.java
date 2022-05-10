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

        //Crear el WebDriver
        String userProfile = "C:\\Users\\Nelida\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("user-data-dir=" + userProfile);

        //Inicializarlo
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Navegamos a la web solicitada
        driver.get("https://www.saucedemo.com/");
        //Encontramos en la web el elemento que contenga user-name en su id, y escribimos standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Buscamos el elemento de la contraseña y la escribimos
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Buscamos el botón de verificar el login, y le damos click.
        driver.findElement(By.id("login-button")).click();
        //Para comprobar si hemos accedido bien o no, usamos un if y comparamos las url
        //Buscamos el elemento de error y guardamos la respuesta de isDisplayed()
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
            boolean error = errorMessage.isDisplayed();
            //si se muestra hay un error
            if (error) {
                System.out.println("Error mostrado");
            }
        }catch(Exception e){
                System.out.println("No hay error");
            }
            driver.close();
        }

    }
