package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class LoginSuite {

    public static WebDriver driver;
    public static  String username;
    public static String password;

   /* @BeforeClass
    public static void setUpClass(){
        username = "standard_user"
    }*/

    @Before
    public void setUp() {
        String userProfile = "C:\\Usuarios\\Bloodlust\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //Cargar ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String url = driver.getCurrentUrl();

        Assert.assertEquals("El login es correcto", "https://www.saucedemo.com/inventory.html", url);
    }
    @Test
    public void testLoginIncorrect() throws InterruptedException {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret__sauce");

        driver.findElement(By.id("login-button")).click();


        boolean isMessageErrorVisible = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();

        Assert.assertTrue("El login falla porque nos pide los requisitos", isMessageErrorVisible);


    }
    @After
    public void tearDown(){
        driver.close();
    }


}

