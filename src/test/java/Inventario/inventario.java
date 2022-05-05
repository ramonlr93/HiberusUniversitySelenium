package Inventario;

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

/**
 * Unit test for simple App.
 */
public class inventario
{
    public static WebDriver driver;
    public static final String ruta = "https://saucedemo.com/";
    public static WebDriverWait pausa;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void numeroDeProductosEsSeis() throws  InterruptedException {
        driver.get(ruta);
        pausa = new WebDriverWait(driver, 10, 1000);

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //pausa.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login-button"))));
        List<WebElement> hijos = driver.findElements(By.xpath("//div[@class='inventory_list']/child::div"));

        //Validacion
        Assert.assertEquals("PRUEBA FALLIDA - Nuemero de elementos no es 6", 6, hijos.size());
    }

    @Test
    public void existeSauceLabsBoltTShirt() throws  InterruptedException {
        driver.get(ruta);
        pausa = new WebDriverWait(driver, 10, 1000);

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        //Validacion
        boolean SauceLabsBoltTShirtVisible = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Bolt T-Shirt')]")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA - El elemento error no aparece", SauceLabsBoltTShirtVisible);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
