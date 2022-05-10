package Test;
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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AgregarProducto{

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso 0
        String userProfile = "C:\\Users\\Nelida\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10,500);
    }

    @Test
    public void incrementarValorCarrito3() {
        //Paso 1 Ir a la pagina
        driver.get("https://www.saucedemo.com/");
        //Paso 2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Paso 3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4 Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        //Paso 5 Agregar producto al carrito
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        //Paso 6 Validamos que en el carrito sale valor 3
        int getSize = Integer.parseInt(driver.findElement(By.className("shopping_cart_badge")).getText());
        Assert.assertEquals("Número de items incorrecto",3, getSize);
        System.out.println(getSize);
    }
    @After
    public void quitDriver(){
        driver.quit();
    }
}
