package com.hiberus.university.selenium.run.LoginSuite;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginSuite {

    public static WebDriver driver;

    public static String username;
    public static String password;

    @BeforeClass
    public static void setUpClass (){
        username = "standard_user";
        password = "secret_sauce";
    }

    @Before

    public void setUp() {

        // Paso 0

        String userProfile = "C:\\Users\\mnavarro\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions();// Crear instancia para opciones de Chrome
        options.addArguments("user-data-dir=" + userProfile);//

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }




    @Test
    public void TestLogin () {
         driver.get("https://www.saucedemo.com");

         driver.findElement(By.id("user-name")).sendKeys("standard_user");

         driver.findElement(By.id("password")).sendKeys("secret_sauce");

         driver.findElement(By.id("login-button")).click();

         String url = driver.getCurrentUrl();

         Assert.assertEquals("EL LOGIN ES FALLIDO PORQUE NO ESTAMOS EN LA URL QUE NOS PIDE LOS REQUISITOS", "https://www.saucedemo.com/inventory.html", url);
    }

    @Test
    public void testLoginIncorrect () {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

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
        driver.close();
    }
}