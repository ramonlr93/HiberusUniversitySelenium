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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MensajeLoginIncorrecto {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {

        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 20, 500);
    }

    @Test
    public void TestLogin() throws InterruptedException {
        //Paso1. Ir a la página Sauce
        String urlSauce = "https://www.saucedemo.com/";
        driver.get(urlSauce);

        //Paso 2. Escribir username
        driver.findElement(By.id("user-name")).sendKeys("standard");

        //Paso 3. Escribir password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4. Pulsar boton login
        driver.findElement(By.id("login-button")).click();

        //Paso 5. Validar que se encuentra en https://www.saucedemo.com/inventory.html
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@data-test='error']"))));
        boolean error = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
        Assert.assertTrue("Al introducir un nombre de usuario incorrecto, no aparece el mensaje de Error", error);

    }

    @After
    public void TearDown() {

        driver.close();
    }

}
