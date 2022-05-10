package com.hiberus.university.selenium.carrito;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CartSuiteTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Random dado = new Random();

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 5, 500);
    }

    @Test
    public void removeCartProductTest() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        int i = 0;
        while (i != 2) {
            Thread.sleep(1000);
            List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//button[text()='Add to cart']"))));
            items.get(dado.nextInt(items.size())).click();
            i++;
        }
        // 6
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")))).click();

        // 7
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//button[text()='Remove']"))));
        int sizeBefore = items.size();
        items.get(0).click();

        items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//button[text()='Remove']"))));
        int sizeAfter = items.size();

        // 8
        Assert.assertNotEquals("EL PRODUCTO QUE SE DESEABA ELIMINAR, NO SE HA ELIMINADO DEL CARRITO", sizeAfter, sizeBefore);
    }

    @After
    public void tearDawn() {
        driver.quit();
    }
}
