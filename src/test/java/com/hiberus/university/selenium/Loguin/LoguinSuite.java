package com.hiberus.university.selenium.Loguin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoguinSuite {
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
    public void testLoguin() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        String url = driver.getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El login es fallido porque no hemos accedido a la url indicada en los requisitos",
                "https://www.saucedemo.com/inventory.html", url);
    }

    @Test
    public void testLoguinIncorrecto() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_use");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        boolean isMenssageErrorVisible;
        try{
            isMenssageErrorVisible = driver.findElement(
                    By.xpath("//div[@class='error-message-container error']")).isDisplayed();

        } catch (NoSuchElementException find){
            isMenssageErrorVisible = false;
        }

        Assert.assertTrue("PRUEBA FALLIDA - El elemento error no aparece", isMenssageErrorVisible);

    }

    @After
    public void tearDown() {
        driver.close();
    }

}
