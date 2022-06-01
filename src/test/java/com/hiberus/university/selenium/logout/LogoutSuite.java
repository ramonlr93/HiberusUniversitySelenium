package com.hiberus.university.selenium.logout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Ignore
public class LogoutSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void SetUp() {
        // Inicie un nuevo navegador Chrome ->
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,10,500);
    }

    @Test
    public void comprobacionLogout(){
        driver.get("https://www.saucedemo.com");

        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.findElement(By.id("logout_sidebar_link")).click();

        String urlActual = driver.getCurrentUrl();
        String urlEsperada = "https://www.saucedemo.com/";
        Assert.assertEquals("PUREBA FALLIDA - NO SE HA REALIZADO EL LOGOUT", urlEsperada, urlActual);
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}
