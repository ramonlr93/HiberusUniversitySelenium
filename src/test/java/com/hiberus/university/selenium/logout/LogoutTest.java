package com.hiberus.university.selenium.logout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogoutTest {

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

    @Test
    public void logoutValidationTest() {
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Realizar el Logout
        driver.findElement(By.id("react-burger-menu-btn")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//nav[@class='bm-item-list']"))));
        driver.findElement(By.id("logout_sidebar_link")).click();

        // Validar que el logout se ha realizado llevándonos a la página del Login
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals("NO SE HA REALIZADO EL LOGOUT, NO ESTAMOS EN LA PAGINA DEL LOGIN ",
                "https://www.saucedemo.com/", loginPageUrl);

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
