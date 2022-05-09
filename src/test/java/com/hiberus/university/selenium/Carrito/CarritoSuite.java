package com.hiberus.university.selenium.Carrito;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarritoSuite {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        //String userProfile = "C:\\Users\\Flores\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=" + userProfile)

        driver =  new ChromeDriver();
        //driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testEliminarDesdeCarrito() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> buttonsadd = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));
        int getRamdown1 = (int) Math.floor(Math.random() * (buttonsadd.size()));
        int getRamdown2;
        do{
            getRamdown2 = (int) Math.floor(Math.random() * (buttonsadd.size()));
        } while (getRamdown1 == getRamdown2);

        buttonsadd.get(getRamdown1).click();
        buttonsadd.get(getRamdown2).click();

        driver.findElement(By.className("shopping_cart_badge")).click();
        Thread.sleep(2000);

        List<WebElement> buttonsremove = driver.findElements(By.xpath("//button[contains(@id, 'remove')]"));
        for (int i=0;i<2;i++) {
            buttonsremove.get(i).click();
        }

        boolean carrito;
        try{
            carrito = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        } catch (NoSuchElementException find){
            carrito = false;
        }

        Assert.assertFalse("PRUEBA FALLIDA - Los productos no se han eliminado", carrito);

    }

    @After
    public void tearDown() {
        driver.close();
    }

}
