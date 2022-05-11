package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginSuiteTest {
    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setUp() {

        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
    }

    /* MI CÓDIGO
    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        //Validacion
        String url = driver.getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El login es fallido porque no hemos accedido a la url indicada en los requisitos",
                "https://www.saucedemo.com/inventory.html", url);
    }

    @Test
    public void testLoginIncorrecto() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_use");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        //Validacion
        boolean isMenssageErrorVisible = driver.findElement(
                By.xpath("//div[@class='error-message-container error']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA - El elemento error no aparece", isMenssageErrorVisible);
    }*/

    // SOLUCIÓN RUBÉN
    @Test
    public void loginTest() {

        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Validar que hemos accedido correctamente a la página, comprobando que se
        // muestra la URL https://www.saucedemo.com/inventory.html
        String url = driver.getCurrentUrl(); // Almacenar la URL actual

        Assert.assertEquals("EL LOGIN ES FALLIDO. ",
                "https://www.saucedemo.com/inventory.html", url);
    }

    @Test
    public void loginIncorrectTest() {

        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard
        WebElement inputUserName =  driver.findElement(By.id("user-name"));
        inputUserName.sendKeys("standard");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Validar que se visualiza el elemento web del mensaje de error
        boolean isMessageErrorVisible;
        try {
            isMessageErrorVisible = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
        } catch (NoSuchElementException n) {
            isMessageErrorVisible = false;
        }

        Assert.assertTrue("PRUEBA FALLIDA, EL ELEMENTO DE ERROR NO APARECE. ", isMessageErrorVisible);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}