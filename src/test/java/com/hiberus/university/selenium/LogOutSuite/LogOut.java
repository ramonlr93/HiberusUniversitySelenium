package com.hiberus.university.selenium.LogOutSuite;

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

public class LogOut {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {

        setUpDriver();
        wait = new WebDriverWait(driver, 10, 500);
        authenticateSauceDemo();

    }

    @Test
    public void TestLogOut() throws InterruptedException {

        //Paso 5. Realizar el LogOut
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_button_container"))));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("react-burger-menu-btn")))).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='bm-menu']/descendant::a[3]")))).click();

        } catch (Exception e) {
            System.out.println("No se puede realizar el LogOut");
        }

        //Paso 6. Validar que el logout se ha realizado llevandonos a la pagina de login
        String paginaActual = driver.getCurrentUrl();
        String urlSauce = "https://www.saucedemo.com/";
        Assert.assertEquals("El logOut no nos lleva a la pagina de login", urlSauce, paginaActual);
    }

    @After
    public void TearDown() {
        driver.close();
    }

    private void setUpDriver() {
        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void authenticateSauceDemo() {
        //Paso1. Ir a la página Sauce
        String urlSauce = "https://www.saucedemo.com/";
        driver.get(urlSauce);

        //Paso 2. Escribir username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Paso 3. Escribir password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4. Pulsar boton login
        driver.findElement(By.id("login-button")).click();
    }

}
