package com.hiberus.university.selenium;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static WebDriver driver;

    @Before
    public static void setUp(){
        // Inicie un nuevo navegador Chrome ->
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /*
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    */

    /*
    @Test
    public void testFirst() throws InterruptedException{

        String[] nombresEsperados = {"Manuel", "Manolo"};
        String[] nombresActuales = {"Manuel", "Manolo"};
        Assert.assertArrayEquals("FALLO - NO SON LOS MISMOS ARRAYS", nombresEsperados, nombresActuales);
    }

    @Test
    public void testEquals() throws InterruptedException{
        Assert.assertEquals("FALLO - NO SON LOS MISMOS VALORES", (1 + 1), 2);
    }


    @Test
    public void testFalse() throws InterruptedException{
        boolean input = false;
        Assert.assertFalse("FALLO - NO SON LOS MISMOS VALORES", input);
        Assert.assertTrue("asafefasf", input);
    }
    */

    @Test
    public void testLoginCorrect() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String url = driver.getCurrentUrl();

        Assert.assertEquals("EL LOGIN ES FALLIDO PORQUE NO ESTAMOS EN LA URL QUE NOS PIDE LOS REQUSITOS", "https://www.saucedemo.com/inventory.html", url);
    }

    @Test
    public void testLoginIncorrect() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        boolean isMessageErrorVisible = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA - EL ELEMENTO NO APARECE", isMessageErrorVisible);
    }

    @Test
    public void testValidateNumberResults(){
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        int numItems = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();

        Assert.assertEquals("PRUEBA FALLIDA - NÚMERO DE ITEMS INCORRECTO", 6, numItems);
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

}
