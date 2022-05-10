package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertTrue;

        //import org.junit.Test;

        /**
        * Unit test for simple App.
        */
        public class LoginSuite {
        public static WebDriver driver;

        @Before
        public void SetUp() {

        //Paso 0
        String userProfile = "C:\\Users\\usuario\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options);       //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();      //Maximiza la ventana
    }

        /**
        * Rigorous Test:-)
        */

        @Test
        public void testLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Comprobacion
            String url = driver.getCurrentUrl();
            String urlEsperada = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals("Ha fallado la prueba porque no estamos en la URL de los requisitos",
                urlEsperada, url);
    }

        @Test
        public void testLoginIncorrect()throws  InterruptedException {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_use");
            //WebElement userBox = driver.findElement(By.id("user-name"));
            //userBox.sendKeys("standard_usererror");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            //WebElement passBox = driver.findElement(By.id("password"));
            //passBox.sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            //WebElement clickButton = driver.findElement(By.id("login-button"));
            //clickButton.click();

            boolean isMessageErrorVisible;
            try {
                isMessageErrorVisible = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
            } catch (NoSuchElementException e) {
                isMessageErrorVisible= false;
            }

            Assert.assertTrue("No aparece el mensaje de error", isMessageErrorVisible);
        }

        @After
        public void tearDowm() {
            driver.quit();
           }
}