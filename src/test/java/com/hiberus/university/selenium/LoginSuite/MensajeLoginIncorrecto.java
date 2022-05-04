package com.hiberus.university.selenium.LoginSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MensajeLoginIncorrecto {

    public static WebDriver driver;

    @Before
    public void setUp() {

        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void TestLogin() throws InterruptedException {
        //Paso1. Ir a la página Sauce
        String urlSauce = "https://www.saucedemo.com/";
        driver.get(urlSauce);

        //Paso 2. Escribir username
        driver.findElement(By.id("user-name")).sendKeys("standard");
        Thread.sleep(2000);

        //Paso 3. Escribir password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4. Pulsar boton login
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Paso 5. Validar que se encuentra en https://www.saucedemo.com/inventory.html
        WebElement mensajeError = driver.findElement(By.xpath("//h3[@data-test='error']"));
        boolean error = mensajeError.isDisplayed();
        Assert.assertTrue("Al introducir un nombre de usuario incorrecto, no aparece el mensaje de Errod", error);


    }

    @After
    public void TearDown() {

        driver.close();
    }

}
